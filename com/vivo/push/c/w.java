package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f39832a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f39833b;

    public w(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f39833b = tVar;
        this.f39832a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f39833b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f39793b;
        context = tVar.f39973a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f39832a);
    }
}
