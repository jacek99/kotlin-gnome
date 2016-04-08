package org.gnome.gtk.kotlin

import org.gnome.glib.Glib
import org.gnome.gtk.Gtk

/**
 * Wrapper representing the entire app
 */
class Application(programName: String) {

    init {
        // Glib good practice
        Glib.setProgramName(programName)
    }

    /**
     * Entry point for the application
     */
    fun run(args: Array<String>, code: () -> Unit): Application {
        Gtk.init(args)
        code.invoke()
        Gtk.main()
        return this
    }

}