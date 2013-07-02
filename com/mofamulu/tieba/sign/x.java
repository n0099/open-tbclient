package com.mofamulu.tieba.sign;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.util.List;
/* loaded from: classes.dex */
class x extends Handler {
    final /* synthetic */ AccountSelectBarsToSignActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(AccountSelectBarsToSignActivity accountSelectBarsToSignActivity) {
        this.a = accountSelectBarsToSignActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.a.j.setEnabled(true);
        if (message.what == 1) {
            this.a.a((List) message.obj);
        } else if (message.what == 2) {
            this.a.k.setVisibility(8);
            Toast.makeText(this.a, (String) message.obj, 1).show();
        } else {
            super.handleMessage(message);
        }
    }
}
