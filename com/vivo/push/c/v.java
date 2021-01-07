package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes4.dex */
final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f13925a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t f13926b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f13926b = tVar;
        this.f13925a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13926b.f13902b;
        context = this.f13926b.f14009a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f13925a);
    }
}
