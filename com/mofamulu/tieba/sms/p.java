package com.mofamulu.tieba.sms;

import android.view.View;
import com.mofamulu.tieba.ch.au;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ SMSOutlineActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SMSOutlineActivity sMSOutlineActivity) {
        this.a = sMSOutlineActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        au.a(this.a, "http://msg.baidu.com/msg/writing");
    }
}
