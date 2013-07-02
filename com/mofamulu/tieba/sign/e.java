package com.mofamulu.tieba.sign;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class e extends Handler {
    final /* synthetic */ AccountAddActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountAddActivity accountAddActivity) {
        this.a = accountAddActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            al alVar = (al) message.obj;
            this.a.q.setEnabled(true);
            this.a.o.setEnabled(true);
            this.a.o.setClickable(true);
            if (alVar != null) {
                this.a.r = alVar;
                this.a.l.setText(alVar.a);
                this.a.m.setText(alVar.b);
                this.a.l.setEnabled(false);
                if (alVar.l() == 1) {
                    this.a.p.setText(R.string.tbhp_sign_amx_tips);
                    this.a.o.setEnabled(false);
                    this.a.o.setClickable(false);
                }
            }
        } else if (message.what == 2) {
            this.a.setResult(1, null);
            this.a.finish();
        } else if (message.what == 3) {
            this.a.d(message.obj != null ? message.obj.toString() : null);
        } else if (message.what == 4) {
            this.a.a((Bitmap) message.obj);
        } else {
            super.handleMessage(message);
        }
    }
}
