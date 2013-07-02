package com.mofamulu.tieba.tail;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import org.json.JSONArray;
/* loaded from: classes.dex */
class d extends Handler {
    final /* synthetic */ FAQActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FAQActivity fAQActivity) {
        this.a = fAQActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            this.a.a((JSONArray) message.obj);
        } else if (message.what == 2) {
            this.a.j.setVisibility(8);
            Toast.makeText(this.a, (String) message.obj, 1).show();
        } else {
            super.handleMessage(message);
        }
    }
}
