package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes5.dex */
final class p implements Runnable {
    final /* synthetic */ UnvarnishedMessage a;
    final /* synthetic */ o b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, UnvarnishedMessage unvarnishedMessage) {
        this.b = oVar;
        this.a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.a;
        pushMessageCallback.onTransmissionMessage(context, this.a);
    }
}
