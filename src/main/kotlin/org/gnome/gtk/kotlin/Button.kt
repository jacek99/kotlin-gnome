package org.gnome.gtk.kotlin

import org.gnome.gtk.Button

fun Button.onClicked(lambda: (source: Button) -> Unit): Button {
    this.connect(Button.Clicked { source -> lambda.invoke(source) })
    return this
}