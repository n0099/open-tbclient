package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class ap extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<a> f36757a;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Message message);
    }

    public ap(a aVar) {
        this.f36757a = new WeakReference<>(aVar);
    }

    public ap(a aVar, Looper looper) {
        super(looper);
        this.f36757a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        try {
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        if (this.f36757a == null || (aVar = this.f36757a.get()) == null) {
            return;
        }
        aVar.a(message);
        super.handleMessage(message);
    }
}
