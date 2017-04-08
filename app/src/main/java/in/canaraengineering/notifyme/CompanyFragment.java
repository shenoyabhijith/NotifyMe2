package in.canaraengineering.notifyme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by USER on 4/8/2017.
 */

 public class CompanyFragment extends Fragment {

    public CompanyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);


        FirebaseRecyclerAdapter<Company, ChatHolder> mAdapter = new FirebaseRecyclerAdapter<Company, ChatHolder>(
                Company.class,
                android.R.layout.activity_list_item,
                ChatHolder.class,
                databaseReference
        ) {


            @Override
            protected void populateViewHolder(ChatHolder viewHolder, Company model, int position) {
            viewHolder.setCompanyName(Company.getmCompanyName());
            viewHolder.setCompanyPackage(Company.getmCompanyPackage());
            }
        };

        rv.setAdapter(mAdapter);


        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }


}
