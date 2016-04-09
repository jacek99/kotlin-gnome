package org.gnome.gtk.kotlin

import org.gnome.gtk.TreePath
import org.gnome.gtk.TreeView
import org.gnome.gtk.TreeViewColumn

fun TreeView.onRowActivated(lambda: (source: TreeView , path: TreePath , column: TreeViewColumn ) -> Unit): TreeView {
    this.connect(TreeView.RowActivated { source, path, column ->  lambda.invoke(source, path, column)})
    return this
}