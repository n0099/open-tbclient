package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes15.dex */
final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f4668a;
    final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.b = tVar;
        this.f4668a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.f4712a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f4668a);
    }
}
