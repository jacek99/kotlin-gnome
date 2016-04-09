package org.gnome.gtk.kotlin

import org.gnome.glib.ApplicationFlags
import org.gnome.gtk.Application
import org.gnome.gtk.Gtk

/**
 * Main builder entry method
 *
 * @author Jacek Furmankiewicz
 * @param args Application main() arguments
 * @param id Application ID, must contain "."
 * @param flags Application flags, default NONE
 */
fun application(args: Array<String>, id: String, flags: ApplicationFlags = ApplicationFlags.NONE, init: Application.() -> Unit): Application {
    Gtk.init(args)

    val x = Application(id,flags)
    x.init()

    Gtk.main()

    return x
}
