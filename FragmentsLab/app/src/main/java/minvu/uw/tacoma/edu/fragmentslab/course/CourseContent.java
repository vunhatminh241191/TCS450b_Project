package minvu.uw.tacoma.edu.fragmentslab.course;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class CourseContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<CourseItem> ITEMS = new ArrayList<CourseItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, CourseItem> ITEM_MAP = new HashMap<String, CourseItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createCourseItem(i));
        }
    }

    private static void addItem(CourseItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static CourseItem createCourseItem(int position) {
        return new CourseItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class CourseItem implements Serializable {
        public final String id;
        public final String title;
        public final String shortDesc;

        public CourseItem(String id, String title, String shortDesc) {
            this.id = id;
            this.title = title;
            this.shortDesc = shortDesc;
        }

        @Override
        public String toString() {
            return shortDesc;
        }
    }
}
