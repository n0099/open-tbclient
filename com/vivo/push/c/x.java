package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f39449a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f39450b;

    public x(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f39450b = tVar;
        this.f39449a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f39450b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f39408b;
        context = tVar.f39588a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f39449a);
    }
}
