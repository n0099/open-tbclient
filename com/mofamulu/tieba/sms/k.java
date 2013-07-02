package com.mofamulu.tieba.sms;

import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.tieba.R;
import java.util.LinkedList;
/* loaded from: classes.dex */
class k extends Handler {
    final /* synthetic */ SMSChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(SMSChatActivity sMSChatActivity) {
        this.a = sMSChatActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            this.a.p = (LinkedList) message.obj;
            this.a.d();
        } else if (message.what == 2) {
            this.a.l.setVisibility(8);
            Toast.makeText(this.a, (String) message.obj, 1).show();
        } else if (message.what == 3) {
            if (this.a.k != null) {
                ((EditText) this.a.k.findViewById(R.id.post_content)).setText("");
                Toast.makeText(this.a, "私信回复成功", 0).show();
            }
        } else {
            super.handleMessage(message);
        }
    }
}
