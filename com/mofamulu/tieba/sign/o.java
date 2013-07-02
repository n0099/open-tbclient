package com.mofamulu.tieba.sign;

import android.os.Handler;
import android.os.Message;
import java.util.List;
/* loaded from: classes.dex */
class o extends Handler {
    final /* synthetic */ AccountListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(AccountListActivity accountListActivity) {
        this.a = accountListActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            this.a.a((List) message.obj);
        } else if (message.what == 2) {
            if (Boolean.TRUE.equals(message.obj)) {
                this.a.j.setText("停止签到[当前正在签到中……]");
            } else {
                this.a.j.setText("立即开始签到[开始后可以离开此屏幕]");
            }
            this.a.j.setEnabled(true);
        } else {
            super.handleMessage(message);
        }
    }
}
