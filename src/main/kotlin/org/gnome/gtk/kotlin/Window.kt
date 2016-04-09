package org.gnome.gtk.kotlin

import org.gnome.gdk.Event
import org.gnome.gtk.Gtk
import org.gnome.gtk.Widget
import org.gnome.gtk.Window

fun Window.onDeleteEvent(lambda: (widget: Widget, event: Event) -> Boolean): Window {
    this.connect(Window.DeleteEvent { widget, event -> lambda.invoke(widget, event)})
    return this
}

var Window.title: String
    get() = ""
    set(value: String) {
        setTitle(value)
    }

var Window.borderWidth: Int
    get() = 0
    set(value: Int) {
        setBorderWidth(value)
    }

/**
 * Builder entry method
 * @param title Window title
 * @param borderWidth Border width
 * @param gtkMainQuit Automatically shuts down GTK if this window is closed. Should be set to true on main application window only *
 */
fun window(title: String = "", borderWidth: Int = 0, gtkMainQuit: Boolean = false, init: Window.() -> Unit): Window {
    val w = Window()
    w.init()
    w.title = title
    w.borderWidth = borderWidth

    if (gtkMainQuit)
        w.onDeleteEvent { widget, event -> Gtk.mainQuit(); false }

    // show all contents automatically
    w.showAll()
    return w

}