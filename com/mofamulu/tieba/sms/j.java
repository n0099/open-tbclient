package com.mofamulu.tieba.sms;

import android.os.Message;
import java.util.LinkedList;
/* loaded from: classes.dex */
class j implements e {
    final /* synthetic */ SMSChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(SMSChatActivity sMSChatActivity) {
        this.a = sMSChatActivity;
    }

    @Override // com.mofamulu.tieba.sms.e
    public void a(String str) {
        this.a.c(str);
    }

    @Override // com.mofamulu.tieba.sms.e
    public void a(LinkedList linkedList, boolean z) {
        Message message = new Message();
        message.what = 1;
        message.obj = linkedList;
        this.a.r.sendMessage(message);
        if (z) {
            Message message2 = new Message();
            message2.what = 3;
            this.a.r.sendMessage(message2);
        }
    }
}
