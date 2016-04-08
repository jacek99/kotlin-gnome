package org.gnome.gtk.kotlin

import org.gnome.gtk.Gtk

/**
 * Wrapper for running a full GTK, takes care of the common setup
 */
fun runGtk(args: Array<String>, code: () -> Unit) {
    Gtk.init(args)
    code.invoke()
    Gtk.main()
}
