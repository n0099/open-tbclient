package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f13928a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t f13929b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f13929b = tVar;
        this.f13928a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13929b.f13901b;
        context = this.f13929b.f14008a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f13928a);
    }
}
