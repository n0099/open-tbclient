package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes9.dex */
final class u implements Runnable {
    final /* synthetic */ UPSNotificationMessage a;
    final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.b = tVar;
        this.a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.a;
        pushMessageCallback.onNotificationMessageClicked(context, this.a);
    }
}
