package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnvarnishedMessage f39438a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f39439b;

    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.f39439b = pVar;
        this.f39438a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.f39439b;
        PushMessageCallback pushMessageCallback = ((ab) pVar).f39408b;
        context = pVar.f39588a;
        pushMessageCallback.onTransmissionMessage(context, this.f39438a);
    }
}
