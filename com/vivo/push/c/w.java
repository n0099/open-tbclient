package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f13926a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t f13927b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f13927b = tVar;
        this.f13926a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13927b.f13901b;
        context = this.f13927b.f14008a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f13926a);
    }
}
