package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnvarnishedMessage f40279a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f40280b;

    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.f40280b = pVar;
        this.f40279a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.f40280b;
        PushMessageCallback pushMessageCallback = ((ab) pVar).f40249b;
        context = pVar.f40431a;
        pushMessageCallback.onTransmissionMessage(context, this.f40279a);
    }
}
