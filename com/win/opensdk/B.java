package com.win.opensdk;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes7.dex */
public class B extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C f36785a;

    public B(C c2, E e2) {
        this.f36785a = c2;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.f36785a.a(message);
    }
}
