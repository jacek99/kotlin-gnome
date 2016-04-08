package org.gnome.gtk.kotlin

import org.gnome.gdk.Event
import org.gnome.gtk.Widget
import org.gnome.gtk.Window

/**
 * Wrapper around Window to simulate extension constructor
 */
fun Window(title: String = ""): Window = Window().apply {
    setTitle(title)
}

fun Window.onDeleteEvent(lambda: (widget: Widget, event: Event) -> Boolean): Window {
    this.connect(Window.DeleteEvent { widget, event -> lambda.invoke(widget, event)})
    return this
}

