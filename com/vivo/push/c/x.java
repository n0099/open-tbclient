package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f13629a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t f13630b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f13630b = tVar;
        this.f13629a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13630b.f13602b;
        context = this.f13630b.f13709a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f13629a);
    }
}
