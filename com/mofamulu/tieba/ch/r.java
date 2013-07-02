package com.mofamulu.tieba.ch;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.mofamulu.tieba.sign.SignServiceBinder;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements Runnable {
    private final /* synthetic */ SignServiceBinder a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(SignServiceBinder signServiceBinder) {
        this.a = signServiceBinder;
    }

    @Override // java.lang.Runnable
    public void run() {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Activity activity4;
        activity = p.a;
        if (activity != null) {
            List<com.mofamulu.tieba.sign.al> e = this.a.e();
            List d = this.a.d();
            int c = com.mofamulu.tieba.sign.al.c();
            int i = 0;
            for (com.mofamulu.tieba.sign.al alVar : e) {
                if (alVar.j() < c) {
                    i++;
                }
            }
            int size = d == null ? 0 : d.size();
            activity2 = p.a;
            if (activity2 != null) {
                activity3 = p.a;
                TextView textView = (TextView) activity3.findViewById(R.id.sign_number);
                if (textView != null) {
                    activity4 = p.a;
                    activity4.runOnUiThread(new s(this, textView, e, i, size));
                    return;
                }
                Log.e("tbhp_ss", "sign_number not exsits!");
            }
        }
    }
}
