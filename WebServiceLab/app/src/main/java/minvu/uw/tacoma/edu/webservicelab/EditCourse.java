package minvu.uw.tacoma.edu.webservicelab;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;

import minvu.uw.tacoma.edu.webservicelab.course.Course;
import minvu.uw.tacoma.edu.webservicelab.data.CourseDB;

public class EditCourse extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public String courseID;

    public CourseDB mCourseDB;

    private EditText mCourseShortDescEditText;
    private EditText mCourseLongDescEditText;
    private EditText mCoursePrereqsEditText;

    private EditCourseListener mListener;

    private final static String COURSE_EDIT_URL
            = "http://cssgate.insttech.washington.edu/~minvu/Android/editCourse.php?";

    public EditCourse() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditCourse.
     */
    // TODO: Rename and change types and number of parameters
    public static EditCourse newInstance(String param1, String param2) {
        EditCourse fragment = new EditCourse();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_edit_course, container, false);
        mCourseShortDescEditText = (EditText) v.findViewById(R.id.edit_course_short_desc);
        mCourseLongDescEditText = (EditText) v.findViewById(R.id.edit_course_long_desc);
        mCoursePrereqsEditText = (EditText) v.findViewById(R.id.edit_course_prereqs);

        Button editCourse = (Button) v.findViewById(R.id.editCourseButton);
        editCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = buildCourseURL(v);
                mListener.editCourse(url);
            }
        });
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof EditCourseListener) {
            mListener = (EditCourseListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement CourseAddListener");
        }
    }

    private String buildCourseURL(View v) {

        StringBuilder sb = new StringBuilder(COURSE_EDIT_URL);

        try {

            String courseId = courseID;
            sb.append("id=");
            sb.append(courseId);


            String courseShortDesc = mCourseShortDescEditText.getText().toString();
            sb.append("&shortDesc=");
            sb.append(URLEncoder.encode(courseShortDesc, "UTF-8"));


            String courseLongDesc = mCourseLongDescEditText.getText().toString();
            sb.append("&longDesc=");
            sb.append(URLEncoder.encode(courseLongDesc, "UTF-8"));

            String coursePrereqs = mCoursePrereqsEditText.getText().toString();
            sb.append("&prereqs=");
            sb.append(URLEncoder.encode(coursePrereqs, "UTF-8"));

            Log.i("CourseAddFragment", sb.toString());


            if (mCourseDB == null) {
                mCourseDB = new CourseDB(getActivity());
            }
            mCourseDB.updateCourse(courseId, courseShortDesc, courseLongDesc, coursePrereqs);


        }
        catch(Exception e) {
            Toast.makeText(v.getContext(), "Something wrong with the url" + e.getMessage(), Toast.LENGTH_LONG)
                    .show();
        }
        return sb.toString();
    }

    public interface EditCourseListener {
        // TODO: Update argument type and name
        void editCourse(String url);
    }
}
