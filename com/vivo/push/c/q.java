package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes4.dex */
final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UnvarnishedMessage f13919a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f13920b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.f13920b = pVar;
        this.f13919a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13920b.f13902b;
        context = this.f13920b.f14009a;
        pushMessageCallback.onTransmissionMessage(context, this.f13919a);
    }
}
