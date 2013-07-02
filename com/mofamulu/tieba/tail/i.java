package com.mofamulu.tieba.tail;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.util.List;
/* loaded from: classes.dex */
class i extends Handler {
    final /* synthetic */ LovedBarListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LovedBarListActivity lovedBarListActivity) {
        this.a = lovedBarListActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.a.g.setEnabled(true);
        if (message.what == 1) {
            this.a.a((List) message.obj);
        } else if (message.what == 2) {
            this.a.j.setVisibility(8);
            Toast.makeText(this.a, (String) message.obj, 1).show();
        } else {
            super.handleMessage(message);
        }
    }
}
