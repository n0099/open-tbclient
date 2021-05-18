package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnvarnishedMessage f36671a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f36672b;

    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.f36672b = pVar;
        this.f36671a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.f36672b;
        PushMessageCallback pushMessageCallback = ((ab) pVar).f36641b;
        context = pVar.f36823a;
        pushMessageCallback.onTransmissionMessage(context, this.f36671a);
    }
}
