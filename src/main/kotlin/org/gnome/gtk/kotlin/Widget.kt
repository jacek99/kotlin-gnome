package org.gnome.gtk.kotlin

import org.gnome.gdk.EventKey
import org.gnome.gtk.Widget

fun Widget.onKeyPressEvent(lambda: (source: Widget, event: EventKey) -> Boolean): Widget {
    this.connect(Widget.KeyPressEvent { widget, eventKey -> lambda.invoke(widget,eventKey)})
    return this
}