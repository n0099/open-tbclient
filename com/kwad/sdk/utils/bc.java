package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes8.dex */
public class bc extends Handler {
    public WeakReference<a> a;

    /* loaded from: classes8.dex */
    public interface a {
        void a(Message message);
    }

    public bc(a aVar) {
        this.a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (this.a == null || (aVar = this.a.get()) == null) {
            return;
        }
        aVar.a(message);
        super.handleMessage(message);
    }
}
