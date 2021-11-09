package com.meizu.cloud.pushsdk.b.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<com.meizu.cloud.pushsdk.b.d.a> f67368a;

    public d(com.meizu.cloud.pushsdk.b.d.a aVar) {
        super(Looper.getMainLooper());
        this.f67368a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        com.meizu.cloud.pushsdk.b.d.a aVar = this.f67368a.get();
        if (message.what != 1) {
            super.handleMessage(message);
        } else if (aVar != null) {
            com.meizu.cloud.pushsdk.b.f.a aVar2 = (com.meizu.cloud.pushsdk.b.f.a) message.obj;
            aVar.a(aVar2.f67369a, aVar2.f67370b);
        }
    }
}
