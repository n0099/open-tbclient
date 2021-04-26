package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes6.dex */
public final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnvarnishedMessage f37426a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f37427b;

    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.f37427b = pVar;
        this.f37426a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.f37427b;
        PushMessageCallback pushMessageCallback = ((ab) pVar).f37396b;
        context = pVar.f37578a;
        pushMessageCallback.onTransmissionMessage(context, this.f37426a);
    }
}
