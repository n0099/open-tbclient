package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes15.dex */
final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UnvarnishedMessage f13621a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f13622b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.f13622b = pVar;
        this.f13621a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13622b.f13604b;
        context = this.f13622b.f13711a;
        pushMessageCallback.onTransmissionMessage(context, this.f13621a);
    }
}
