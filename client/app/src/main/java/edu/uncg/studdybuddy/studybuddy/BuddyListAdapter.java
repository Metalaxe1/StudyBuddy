package edu.uncg.studdybuddy.studybuddy;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import StudyBuddy.Student;

/**
 * Created by Anthony Ratliff on 4/9/2017.
 */

public class BuddyListAdapter extends BaseAdapter {
    private Context c;
    private ArrayList<Student> students;

    public BuddyListAdapter(Context c, ArrayList<Student> studentList) {
        this.c = c;
        this.students = studentList;
    }


    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView= LayoutInflater.from(c).inflate(R.layout.model_buddy_list,parent,false);
        }
        final Student s = (Student) this.getItem(position);
        ImageView img = (ImageView) convertView.findViewById(R.id.smileyImg);
        TextView nameTxt = (TextView) convertView.findViewById(R.id.nameTxt);
        TextView statTxt = (TextView) convertView.findViewById(R.id.statusTxt);

        img.setImageResource(R.drawable.smiley_yellow);
        nameTxt.setText(s.getStudentName());
        boolean online = s.getOnlineStatus();
        String stat;
        if (online) {
            stat = "Online";
            statTxt.setTextColor(Color.GREEN);
        }
        else {
            stat = "Offline";
            statTxt.setTextColor(Color.RED);
        }
        statTxt.setText(stat);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, s.getStudentName(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}