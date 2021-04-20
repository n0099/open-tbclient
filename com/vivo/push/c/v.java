package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f39735a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f39736b;

    public v(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f39736b = tVar;
        this.f39735a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f39736b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f39698b;
        context = tVar.f39878a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f39735a);
    }
}
