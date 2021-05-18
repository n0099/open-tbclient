package com.bytedance.sdk.openadsdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class am extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<a> f30251a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Message message);
    }

    public am(a aVar) {
        this.f30251a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f30251a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.a(message);
    }

    public am(Looper looper, a aVar) {
        super(looper);
        this.f30251a = new WeakReference<>(aVar);
    }
}
