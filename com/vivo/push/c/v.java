package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f13924a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t f13925b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f13925b = tVar;
        this.f13924a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13925b.f13901b;
        context = this.f13925b.f14008a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f13924a);
    }
}
