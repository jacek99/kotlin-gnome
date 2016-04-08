package org.gnome.kotlin.test.examples

import org.gnome.gdk.Event;
import org.gnome.gtk.Button;
import org.gnome.gtk.Gtk;
import org.gnome.gtk.Label;
import org.gnome.gtk.VBox;
import org.gnome.gtk.Widget;
import org.gnome.gtk.kotlin.Window

import org.gnome.gtk.kotlin.onClicked
import org.gnome.gtk.kotlin.onDeleteEvent
import org.gnome.gtk.kotlin.props
import org.gnome.gtk.kotlin.runGtk

/**
 * A simple Window with a Label and a Button in it. Demonstrates the basics of
 * initializing GTK, packing Widgets into Containers, and hooking up signals.
 */
fun main(args : Array<String>) {
    runGtk(args, {
        val w = Window(title = "Hello World")
                .onDeleteEvent { widget, event -> Gtk.mainQuit(); false }

        with(w) {
            val x = VBox(false, 3)
            with(x) {
                add(Label("Go ahead:\nMake my day"))
                add(Button("Press me!").onClicked { b -> println("I was clicked: ${b.label}") })
            }

            add(x)
            showAll()
        }
    })
}

