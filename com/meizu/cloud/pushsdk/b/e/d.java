package com.meizu.cloud.pushsdk.b.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class d extends Handler {
    private final WeakReference<com.meizu.cloud.pushsdk.b.d.a> a;

    public d(com.meizu.cloud.pushsdk.b.d.a aVar) {
        super(Looper.getMainLooper());
        this.a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.meizu.cloud.pushsdk.b.d.a aVar = this.a.get();
        switch (message.what) {
            case 1:
                if (aVar != null) {
                    com.meizu.cloud.pushsdk.b.f.a aVar2 = (com.meizu.cloud.pushsdk.b.f.a) message.obj;
                    aVar.a(aVar2.a, aVar2.b);
                    return;
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
