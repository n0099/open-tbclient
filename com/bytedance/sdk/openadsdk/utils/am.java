package com.bytedance.sdk.openadsdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class am extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<a> f7563a;

    /* loaded from: classes4.dex */
    public interface a {
        void a(Message message);
    }

    public am(a aVar) {
        this.f7563a = new WeakReference<>(aVar);
    }

    public am(Looper looper, a aVar) {
        super(looper);
        this.f7563a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f7563a.get();
        if (aVar != null && message != null) {
            aVar.a(message);
        }
    }
}
