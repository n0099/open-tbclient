package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f39737a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f39738b;

    public w(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f39738b = tVar;
        this.f39737a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f39738b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f39698b;
        context = tVar.f39878a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f39737a);
    }
}
