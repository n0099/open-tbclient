package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnvarnishedMessage f40382a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f40383b;

    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.f40383b = pVar;
        this.f40382a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.f40383b;
        PushMessageCallback pushMessageCallback = ((ab) pVar).f40352b;
        context = pVar.f40534a;
        pushMessageCallback.onTransmissionMessage(context, this.f40382a);
    }
}
