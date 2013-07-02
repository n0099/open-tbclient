package com.mofamulu.tieba.sms;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
/* loaded from: classes.dex */
class o extends Handler {
    final /* synthetic */ SMSOutlineActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(SMSOutlineActivity sMSOutlineActivity) {
        this.a = sMSOutlineActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            this.a.k.setVisibility(8);
            this.a.m();
        } else if (message.what == 2) {
            this.a.k.setVisibility(8);
            Toast.makeText(this.a, (String) message.obj, 1).show();
            this.a.d();
        } else {
            super.handleMessage(message);
        }
    }
}
