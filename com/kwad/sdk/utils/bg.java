package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public final class bg extends Handler {
    public WeakReference<a> apk;

    /* loaded from: classes8.dex */
    public interface a {
        void a(Message message);
    }

    public bg(a aVar) {
        this.apk = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        a aVar;
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
        if (this.apk == null || (aVar = this.apk.get()) == null) {
            return;
        }
        aVar.a(message);
        super.handleMessage(message);
    }
}
