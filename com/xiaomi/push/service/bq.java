package com.xiaomi.push.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
/* loaded from: classes18.dex */
class bq extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f4860a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(XMPushService xMPushService) {
        this.f4860a = xMPushService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        super.handleMessage(message);
        if (message != null) {
            try {
                switch (message.what) {
                    case 17:
                        if (message.obj != null) {
                            this.f4860a.onStart((Intent) message.obj, XMPushService.f4792a);
                            break;
                        }
                        break;
                    case 18:
                        Message obtain = Message.obtain((Handler) null, 0);
                        obtain.what = 18;
                        Bundle bundle = new Bundle();
                        str = this.f4860a.f812a;
                        bundle.putString("xmsf_region", str);
                        obtain.setData(bundle);
                        message.replyTo.send(obtain);
                        break;
                }
            } catch (Throwable th) {
            }
        }
    }
}
