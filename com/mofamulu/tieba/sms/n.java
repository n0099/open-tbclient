package com.mofamulu.tieba.sms;

import android.os.Message;
/* loaded from: classes.dex */
class n implements i {
    final /* synthetic */ SMSOutlineActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(SMSOutlineActivity sMSOutlineActivity) {
        this.a = sMSOutlineActivity;
    }

    @Override // com.mofamulu.tieba.sms.i
    public void a(String str) {
        this.a.c(str);
    }

    @Override // com.mofamulu.tieba.sms.i
    public void a() {
        Message message = new Message();
        message.what = 1;
        this.a.o.sendMessage(message);
    }
}
