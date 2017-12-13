package com.example.android.miwok;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Johnny on 12/2/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    /**
     * color resource ID
     */
    int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        //set the global variable color id to that of the input
        mColorResourceId = colorResourceId;

        Log.v("Toppings", "Poppo");
    }
    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //Alternate way to get the background to the intended color. This requires modifying the list_item.xml to have the default tan background
        //Then this will change each of the linear layouts to the category color
//        View textContainer = listItemView.findViewById(R.id.text_container);
//        textContainer.setBackgroundResource(mColorResourceId);

        //set the View's background to the global color resource id
        //This is the way I did it. This will set the entire list view's item to have the category's background color. And then, in the list_item.xml, I change it so each
        //imageview, the icon, will have the tan background
        listItemView.setBackgroundResource(mColorResourceId);

        // Get the {@link Word} object located at this position in the list
        final Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        //I think you'd want to check for true due to the face that it means one less thing the WordAdapter would have to do. If it were to check for false, it would have to run a check to see
        //if the opposite is false instead of just getting a straight answer.
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());

            //You want to make sure the view is set to visible in case it was set to invisible/gone prior.. or something but I'm not too sure why it's needed because from what I could tell, it's unnecessary
            imageView.setVisibility(View.VISIBLE);
        }
        else {
            //Use GONE because it will NOT take up any space in the layout while INVISIBLE will just display a blank area in that space
            imageView.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
