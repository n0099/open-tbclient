package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f40393a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f40394b;

    public x(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f40394b = tVar;
        this.f40393a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f40394b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f40352b;
        context = tVar.f40534a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f40393a);
    }
}
