package minvu.uw.tacoma.edu.webservicelab.course;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;

/**
 * Created by minhvu on 2/13/17.
 */

public class Course implements Serializable{

    public String mcourseID;
    public String mshortDescription;
    public String mlongDescription;
    public String mprereqs;
    public static final String ID = "id", SHORT_DESC = "shortDesc"
            , LONG_DESC = "longDesc", PRE_REQS = "prereqs";

    public Course(String courseID, String shortDescription, String longDescription,
                  String mprereqs) {
        this.mcourseID = courseID;
        this.mshortDescription = shortDescription;
        this.mlongDescription = longDescription;
        this.mprereqs = mprereqs;

    }

    public static String parseCourseJSON(String courseJSON, List<Course> courseList) {
        String reason = null;
        if (courseJSON != null) {
            try {
                JSONArray arr = new JSONArray(courseJSON);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    Course course = new Course(obj.getString(Course.ID), obj.getString(Course.SHORT_DESC)
                            , obj.getString(Course.LONG_DESC), obj.getString(Course.PRE_REQS));
                    courseList.add(course);
                }
            } catch (JSONException e) {
                reason =  "Unable to parse data, Reason: " + e.getMessage();
            }

        }
        return reason;
    }


}
