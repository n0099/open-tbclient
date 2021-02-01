package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes15.dex */
final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f13631a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t f13632b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f13632b = tVar;
        this.f13631a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13632b.f13604b;
        context = this.f13632b.f13711a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f13631a);
    }
}
