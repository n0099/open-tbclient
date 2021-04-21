package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f39830a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f39831b;

    public v(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f39831b = tVar;
        this.f39830a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f39831b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f39793b;
        context = tVar.f39973a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f39830a);
    }
}
