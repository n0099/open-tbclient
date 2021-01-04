package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UnvarnishedMessage f13918a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f13919b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.f13919b = pVar;
        this.f13918a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13919b.f13901b;
        context = this.f13919b.f14008a;
        pushMessageCallback.onTransmissionMessage(context, this.f13918a);
    }
}
