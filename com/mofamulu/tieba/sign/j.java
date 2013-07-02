package com.mofamulu.tieba.sign;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class j extends Handler {
    final /* synthetic */ AccountDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AccountDetailActivity accountDetailActivity) {
        this.a = accountDetailActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            this.a.c((al) message.obj);
            return;
        }
        super.handleMessage(message);
    }
}
