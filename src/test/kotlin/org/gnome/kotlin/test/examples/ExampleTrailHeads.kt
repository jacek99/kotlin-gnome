package org.gnome.kotlin.test.examples

import org.gnome.gtk.*
import org.gnome.gtk.kotlin.application
import org.gnome.gtk.kotlin.onRowActivated
import org.gnome.gtk.kotlin.treeView
import org.gnome.gtk.kotlin.window

/*
 * A tutorial example of using a TreeView backed by a ListStore. In this
 * little demonstration, we list a number of famous hiking trails and how to
 * get to them.
*/
fun main(args: Array<String>) {

    application(args,"Kotlin.ExampleTrailHeads") {
        window(title = "Trail Heads", gtkMainQuit = true) {
            treeView {

                // define model and all its fixings
                val placeName = DataColumnString()
                val trailHead = DataColumnString()
                val elevationFormatted = DataColumnString()
                val elevationSort = DataColumnInteger()
                val accessibleByTrain = DataColumnBoolean()

                val store = ListStore(arrayOf(placeName,trailHead,elevationFormatted,elevationSort,accessibleByTrain))
                model = store


                var row = store.appendRow();
                model.setValue(row, placeName, "Blue Mountains national park\n<small>(Six Foot Track)</small>");
                model.setValue(row, trailHead, "Katoomba, NSW, Australia");
                model.setValue(row, elevationFormatted, "1015 m");
                model.setValue(row, elevationSort, 1005);
                model.setValue(row, accessibleByTrain, true);

                row = store.appendRow();
                store.setValue(row, placeName, "Kilimanjaro\n<small>(Machame route)</small>");
                store.setValue(row, trailHead, "Nairobi, Kenya");
                store.setValue(row, elevationFormatted, "5894 m");
                store.setValue(row, elevationSort, 5894);
                store.setValue(row, accessibleByTrain, false);

                row = store.appendRow();
                store.setValue(row, placeName, "Appalachian Trail\n<small>(roller coaster section)</small>");
                store.setValue(row, trailHead, "Harpers Ferry, West Virginia, USA");
                store.setValue(row, elevationFormatted, "147 m");
                store.setValue(row, elevationSort, 147);
                store.setValue(row, accessibleByTrain, true);

                var vertical = appendColumn();
                vertical.setTitle("Place");
                var renderer = CellRendererText(vertical);
                renderer.setMarkup(placeName);

                vertical = appendColumn();
                vertical.setTitle("Nearest town");
                renderer = CellRendererText(vertical);
                renderer.setText(trailHead);
                renderer.setAlignment(0.0f, 0.0f);
                vertical.setExpand(true);

                vertical = appendColumn();
                vertical.setTitle("Elevation");
                renderer = CellRendererText(vertical);
                renderer.setText(elevationFormatted);
                renderer.setAlignment(0.0f, 0.0f);


                vertical.setSortColumn(elevationSort);
                vertical.emitClicked();

                onRowActivated { treeView, treePath, treeViewColumn ->
                    val row = model.getIter(treePath);
                    val place = model.getValue(row, trailHead);
                    val height = model.getValue(row, elevationFormatted);

                    System.out.println("You want to go to $place in order to climb to $height")
                }
            }
        }
    }

}

