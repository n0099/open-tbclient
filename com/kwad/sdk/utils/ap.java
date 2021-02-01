package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class ap extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<a> f10810a;

    /* loaded from: classes3.dex */
    public interface a {
        void a(Message message);
    }

    public ap(a aVar) {
        this.f10810a = new WeakReference<>(aVar);
    }

    public ap(a aVar, Looper looper) {
        super(looper);
        this.f10810a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        try {
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        if (this.f10810a == null || (aVar = this.f10810a.get()) == null) {
            return;
        }
        aVar.a(message);
        super.handleMessage(message);
    }
}
