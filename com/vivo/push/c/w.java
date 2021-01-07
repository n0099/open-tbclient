package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes4.dex */
final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f13927a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ t f13928b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f13928b = tVar;
        this.f13927a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13928b.f13902b;
        context = this.f13928b.f14009a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f13927a);
    }
}
