package polinema.ac.id.starterchapter05;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import polinema.ac.id.starterchapter05.fragments.DipsFragment;
import polinema.ac.id.starterchapter05.fragments.HandstandFragment;
import polinema.ac.id.starterchapter05.fragments.PushupFragment;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Integer active;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        active = 1;
        fragmetChange(new PushupFragment(),4);
    }

    public void pushupButton(View view) {
        fragmetChange(new PushupFragment(),1);
    }

    public  void fragmetChange(Fragment fragment,int status){
        if(active != status) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.replace(R.id.frameChange, fragment, status+"");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            active = status;
        }
    }

    public void dipsButton(View view) {
        fragmetChange(new DipsFragment(),2);
    }

    public void handsButton(View view) {
        fragmetChange(new HandstandFragment(),3);
    }
}
