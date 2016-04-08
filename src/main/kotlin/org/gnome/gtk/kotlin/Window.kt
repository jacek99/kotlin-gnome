package org.gnome.gtk.kotlin

import org.gnome.gdk.Event
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


// builder
fun window(title: String = "", init: Window.() -> Unit): Window {
    val w = Window()
    w.init()
    w.title = title
    return w

}