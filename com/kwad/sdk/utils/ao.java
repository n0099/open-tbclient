package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class ao extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<a> f34050a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Message message);
    }

    public ao(a aVar) {
        this.f34050a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (this.f34050a == null || (aVar = this.f34050a.get()) == null) {
            return;
        }
        aVar.a(message);
        super.handleMessage(message);
    }
}
