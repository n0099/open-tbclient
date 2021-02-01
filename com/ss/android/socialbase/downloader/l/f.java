package com.ss.android.socialbase.downloader.l;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class f extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<a> f13220a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Message message);
    }

    public f(Looper looper, a aVar) {
        super(looper);
        this.f13220a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f13220a.get();
        if (aVar != null && message != null) {
            aVar.a(message);
        }
    }
}
