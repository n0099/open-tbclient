package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f39446a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f39447b;

    public v(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f39447b = tVar;
        this.f39446a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f39447b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f39409b;
        context = tVar.f39589a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f39446a);
    }
}
