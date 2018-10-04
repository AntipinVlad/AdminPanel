package programfirebase.comdasd.example.javad.adminpanel;

/**
 * Created by javad on 07.06.2018.
 */

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by SUDA on 08-09-2017.
 */


public class NoteViewHolder extends RecyclerView.ViewHolder {

    View mView;

    TextView textTitle, textTime,textLink;
    CardView noteCard;

    public NoteViewHolder(View itemView) {
        super(itemView);

        mView = itemView;

        textTitle = mView.findViewById(R.id.note_title);
        textTime = mView.findViewById(R.id.note_time);
        noteCard = mView.findViewById(R.id.note_card);
        textLink = mView.findViewById(R.id.note_link);
    }

    public void setNoteTitle(String title) {textTitle.setText(title);}

    public void setNoteTime(String time) {textTime.setText(time);}

    public void setNoteLink(String content) {textLink.setText(content);}

}
