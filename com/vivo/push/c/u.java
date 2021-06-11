package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f40284a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f40285b;

    public u(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f40285b = tVar;
        this.f40284a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f40285b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f40249b;
        context = tVar.f40431a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f40284a);
    }
}
