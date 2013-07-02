package com.mofamulu.tieba.ch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
/* loaded from: classes.dex */
class l extends BroadcastReceiver {
    final TextView a;

    public l(TextView textView) {
        this.a = textView;
        a(au.a);
    }

    protected void a(int i) {
        if (i > 0) {
            this.a.setText(new StringBuilder(String.valueOf(i)).toString());
            this.a.setVisibility(0);
            return;
        }
        this.a.setVisibility(8);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("sms", 0);
        a(intExtra);
        Log.v("tbhp_test", "receive message:" + intExtra);
    }
}
