package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f36680a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f36681b;

    public w(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f36681b = tVar;
        this.f36680a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f36681b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f36641b;
        context = tVar.f36823a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f36680a);
    }
}
