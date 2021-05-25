package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f36607a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f36608b;

    public v(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f36608b = tVar;
        this.f36607a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f36608b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f36570b;
        context = tVar.f36752a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f36607a);
    }
}
