package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes6.dex */
final class w implements Runnable {
    final /* synthetic */ UPSNotificationMessage a;
    final /* synthetic */ s b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar, UPSNotificationMessage uPSNotificationMessage) {
        this.b = sVar;
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
