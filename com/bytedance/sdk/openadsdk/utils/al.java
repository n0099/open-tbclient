package com.bytedance.sdk.openadsdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class al extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<a> f5125a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Message message);
    }

    public al(a aVar) {
        this.f5125a = new WeakReference<>(aVar);
    }

    public al(Looper looper, a aVar) {
        super(looper);
        this.f5125a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f5125a.get();
        if (aVar != null && message != null) {
            aVar.a(message);
        }
    }
}
