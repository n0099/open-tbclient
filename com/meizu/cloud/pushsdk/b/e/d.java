package com.meizu.cloud.pushsdk.b.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes15.dex */
public class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<com.meizu.cloud.pushsdk.b.d.a> f4344a;

    public d(com.meizu.cloud.pushsdk.b.d.a aVar) {
        super(Looper.getMainLooper());
        this.f4344a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.meizu.cloud.pushsdk.b.d.a aVar = this.f4344a.get();
        switch (message.what) {
            case 1:
                if (aVar != null) {
                    com.meizu.cloud.pushsdk.b.f.a aVar2 = (com.meizu.cloud.pushsdk.b.f.a) message.obj;
                    aVar.a(aVar2.f4345a, aVar2.b);
                    return;
                }
                return;
            default:
                super.handleMessage(message);
                return;
        }
    }
}
