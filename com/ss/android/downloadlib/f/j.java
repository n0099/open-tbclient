package com.ss.android.downloadlib.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class j extends Handler {

    /* renamed from: a  reason: collision with root package name */
    WeakReference<a> f12992a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Message message);
    }

    public j(Looper looper, a aVar) {
        super(looper);
        this.f12992a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f12992a.get();
        if (aVar != null && message != null) {
            aVar.a(message);
        }
    }
}
