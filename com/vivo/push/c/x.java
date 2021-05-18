package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f36682a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f36683b;

    public x(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f36683b = tVar;
        this.f36682a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f36683b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f36641b;
        context = tVar.f36823a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f36682a);
    }
}
