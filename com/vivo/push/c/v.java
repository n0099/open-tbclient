package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f13625a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t f13626b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f13626b = tVar;
        this.f13625a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13626b.f13602b;
        context = this.f13626b.f13709a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f13625a);
    }
}
