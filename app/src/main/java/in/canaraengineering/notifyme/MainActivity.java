package in.canaraengineering.notifyme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private final static int FADE_DURATION = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView l = (ListView)findViewById(R.id.listview);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Company");

        String userId = ref.push().getKey();
        Company c = new Company("infosys","cec","SomePackage");
        ref.child(userId).setValue(c);

        FirebaseListAdapter<Company> firabaselistdapter = new FirebaseListAdapter<Company>( // SetListAdapter
                this,
                Company.class,
                R.layout.simple_list_item1,
                ref
        ) {
            @Override
            protected void populateView(View v, Company model, int position) {
                TextView CompanyName = (TextView)v.findViewById(R.id.CompanyName);
                TextView CompanyVenue = (TextView)v.findViewById(R.id.CompanyVenue);
                TextView CompanyPackage = (TextView)v.findViewById(R.id.CompanyPackage);
                CardView cardView = (CardView)v.findViewById(R.id.Cardview);
                CompanyName.setText( model.getCompanyName());
                CompanyVenue.setText(model.getCompanyVenue());
                CompanyPackage.setText(model.getCompanyPackage());
                setScaleAnimation(cardView);
            }
        };

        l.setAdapter(firabaselistdapter);

    }
    private void setScaleAnimation(View view) {       //Set scale animation
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

}


