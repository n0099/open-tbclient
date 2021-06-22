package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f40389a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f40390b;

    public v(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f40390b = tVar;
        this.f40389a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f40390b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f40352b;
        context = tVar.f40534a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f40389a);
    }
}
