package org.gnome.gtk.kotlin

import org.gnome.gtk.*

fun Container.button(text: String, init: Button.() -> Unit): Button {
    val x = Button(text)
    x.init()
    this.add(x)
    return x
}

fun Container.label(text: String, init: Label.() -> Unit) : Label {
    val x = Label(text)
    x.init()
    this.add(x)
    return x
}

fun Container.treeView(init: TreeView.() -> Unit): TreeView {
    val x = TreeView()
    x.init()
    this.add(x)
    return x
}

fun Container.vbox(homogenous: Boolean = false, spacing: Int = 4, init: VBox.() -> Unit) : VBox {
    val v = VBox(homogenous, spacing)
    v.init()
    this.add(v)
    return v;
}
