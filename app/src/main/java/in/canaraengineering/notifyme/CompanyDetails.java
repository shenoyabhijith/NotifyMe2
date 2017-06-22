package in.canaraengineering.notifyme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class CompanyDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_details);
        if(getSupportActionBar() != null){  //check if action bar null if not then enable back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            TextView CompanyDescription = (TextView)findViewById(R.id.cName);
            Bundle CompanyDescriptions = getIntent().getExtras();
            if(CompanyDescription == null){
                return;
            }
            String name  = CompanyDescriptions.getString("CompanyDescription");
            CompanyDescription.setText(name);

        }
    }
    public boolean onOptionsItemSelected(MenuItem item) { //this is the back button
        Intent i = new Intent(getApplicationContext(),NavigationActivity.class);
        startActivity(i);
        return true;
    }

}
