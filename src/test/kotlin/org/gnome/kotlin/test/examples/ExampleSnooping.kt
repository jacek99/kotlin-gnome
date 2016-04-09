package org.gnome.kotlin.test.examples


import org.gnome.gdk.ModifierType
import org.gnome.gtk.kotlin.application
import org.gnome.gtk.kotlin.label
import org.gnome.gtk.kotlin.onKeyPressEvent
import org.gnome.gtk.kotlin.window

/**
 * Observing the flow of key strokes. This is essentially the code used to
 * generate the data about sequencing described in {@link ModifierType}.
 */
fun main(args : Array<String>) {

    application(args, "Kotlin.KeySnooping") {

        window(title = "Key Snooping", borderWidth = 30, gtkMainQuit = true) {

            label("<b>Start Typing!</b>\n" + "Start typing and details about\n"
                    + "your KeyEvents will\n" + "appear on the console.") {
                useMarkup = true
            }

            onKeyPressEvent { widget, eventKey ->

                val key = eventKey.keyval
                val mod = eventKey.state

                print("Pressed: $key  Modifier: $mod ");

                if (mod == ModifierType.SHIFT_MASK) {
                    print("That's Shifty!");
                }
                if (mod.contains(ModifierType.ALT_MASK)) {
                    print("Hooray for Alt!");
                }
                if (mod.contains(ModifierType.SUPER_MASK)) {
                    print("You're Super!");
                }

                println()
                false
            }
        }
    }
}
