package in.canaraengineering.notifyme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private final static int FADE_DURATION = 1000;
    private ProgressBar spinner;
    private CardView cardView;
    private static final String Company = "Notice";
    private String key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar() != null){  //check if action bar null if not then enable back button
             getSupportActionBar().setDisplayHomeAsUpEnabled(true);
             getSupportActionBar().setHomeButtonEnabled(true);
         }


        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        ListView l = (ListView)findViewById(R.id.listview);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://notifyme-31753.firebaseio.com/cec");

        FirebaseListAdapter<Notice> firabaselistdapter = new FirebaseListAdapter<Notice>( // SetListAdapter
                this,
                Notice.class,
                R.layout.simple_list_item1,
                ref.child("Notice")                          //add information from company class
        ) {
            @Override
            protected void populateView(View v, Notice model, int position) {
                final TextView NoticeDescription  = (TextView)v.findViewById(R.id.noticedescription);
                CardView cardView = (CardView)v.findViewById(R.id.Cardview);
                NoticeDescription.setText(model.getNoticeDescription());
                setScaleAnimation(cardView);
            }
        };

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                spinner.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        l.setAdapter(firabaselistdapter); //set the adapter here
    }
    public boolean onOptionsItemSelected(MenuItem item) { //this is the back button
       Intent i = new Intent(getApplicationContext(),NavigationActivity.class);
        startActivity(i);
        return true;
    }

    private void setScaleAnimation(View view) {       //Set scale animation
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

}


