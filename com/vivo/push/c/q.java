package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnvarnishedMessage f39439a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f39440b;

    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.f39440b = pVar;
        this.f39439a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.f39440b;
        PushMessageCallback pushMessageCallback = ((ab) pVar).f39409b;
        context = pVar.f39589a;
        pushMessageCallback.onTransmissionMessage(context, this.f39439a);
    }
}
