package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f13623a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t f13624b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f13624b = tVar;
        this.f13623a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13624b.f13602b;
        context = this.f13624b.f13709a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f13623a);
    }
}
