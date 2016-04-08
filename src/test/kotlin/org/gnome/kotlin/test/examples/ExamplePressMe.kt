package org.gnome.kotlin.test.examples

import org.gnome.gtk.Gtk
import org.gnome.gtk.kotlin.*

/**
 * A simple Window with a Label and a Button in it. Demonstrates the basics of
 * initializing GTK, packing Widgets into Containers, and hooking up signals.
 */
fun main(args : Array<String>) {

    Application("Hello World").run(args, {

        window("Hello World") {
            onDeleteEvent { widget, event -> Gtk.mainQuit(); false }

            vbox(false,3) {
                label("Go ahead:\nMake my day") {}
                button("Press me!") {
                    onClicked { b -> println("I was clicked: ${b.label}") }
                }
            }
        }
    })

}

