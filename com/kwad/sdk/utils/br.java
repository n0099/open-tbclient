package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public final class br extends Handler {
    public WeakReference<a> aPx;

    /* loaded from: classes10.dex */
    public interface a {
        void a(Message message);
    }

    public br(a aVar) {
        this.aPx = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        a aVar;
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
        }
        if (this.aPx == null || (aVar = this.aPx.get()) == null) {
            return;
        }
        aVar.a(message);
        super.handleMessage(message);
    }
}
