package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UnvarnishedMessage f13619a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ p f13620b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.f13620b = pVar;
        this.f13619a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13620b.f13602b;
        context = this.f13620b.f13709a;
        pushMessageCallback.onTransmissionMessage(context, this.f13619a);
    }
}
