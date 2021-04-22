package com.example.eventnote2_logbook_4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.eventnote2_logbook_4.fragment.AddUpdateEventDialogFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    @Override
    public void onBackPressed() {
        Fragment homeFragment = getSupportFragmentManager().findFragmentByTag(AddUpdateEventDialogFragment.TAG);
        // kiểm tra nếu fragment đang show hiện tại là AddEventFragment
        // thì thoát app
        if(homeFragment != null && homeFragment.isVisible()) {
            this.finish();
        } else super.onBackPressed();
    }

    private void initView() {
        // mở app show homeFragment
        AddUpdateEventDialogFragment addUpdateFragment = AddUpdateEventDialogFragment.newInstance(null, AddUpdateEventDialogFragment.EventType.Add);
        getSupportFragmentManager().beginTransaction()
                .add(addUpdateFragment, AddUpdateEventDialogFragment.TAG)
                .commit();

    }

}