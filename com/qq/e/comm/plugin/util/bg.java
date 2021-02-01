package com.qq.e.comm.plugin.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes15.dex */
public class bg extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final WeakReference<a> f12580a;

    /* loaded from: classes15.dex */
    public interface a {
        void a(Message message);
    }

    public bg(a aVar, Looper looper) {
        super(looper);
        this.f12580a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        a aVar = this.f12580a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.a(message);
    }
}
