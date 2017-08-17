package com.kirayepay.broadcastrecievers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by rikki on 8/17/17.
 */

public class DemoFragment extends Fragment
{
    public static final String ACTION_INTENT = "DEMO_PLEASE";
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_demo,container,false);
        textView = (TextView) v.findViewById(R.id.change_text);
        IntentFilter filter = new IntentFilter(ACTION_INTENT);
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(ActivityDataReceiver, filter);
        return v;
    }
    @Override
    public void onDestroy() {
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(ActivityDataReceiver);
        super.onDestroy();
    }
    protected BroadcastReceiver ActivityDataReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(ACTION_INTENT.equals(intent.getAction())) {
                textView.setText(intent.getStringExtra("TEXT"));
            }
        }
    };
}
