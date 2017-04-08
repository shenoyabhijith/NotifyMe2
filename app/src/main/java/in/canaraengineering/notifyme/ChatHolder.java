package in.canaraengineering.notifyme;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by USER on 4/8/2017.
 */
public class ChatHolder  extends RecyclerView.ViewHolder{
    private final TextView mNameField;
    private final TextView mTextField;
    public ChatHolder(View itemView) {
        super(itemView);
     mNameField = (TextView)itemView.findViewById(R.id.tv_blah);
     mTextField = (TextView)itemView.findViewById(R.id.tv_text);
    }
    public void setCompanyName(String CompanyName){
        mNameField.setText(CompanyName);

    }
    public  void setCompanyPackage(String CompanyPackage){
        mTextField.setText(CompanyPackage);
    }

}
