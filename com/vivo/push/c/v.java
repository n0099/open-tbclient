package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes6.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f37433a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f37434b;

    public v(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f37434b = tVar;
        this.f37433a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f37434b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f37396b;
        context = tVar.f37578a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f37433a);
    }
}
