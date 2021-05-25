package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UnvarnishedMessage f36600a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p f36601b;

    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.f36601b = pVar;
        this.f36600a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.f36601b;
        PushMessageCallback pushMessageCallback = ((ab) pVar).f36570b;
        context = pVar.f36752a;
        pushMessageCallback.onTransmissionMessage(context, this.f36600a);
    }
}
