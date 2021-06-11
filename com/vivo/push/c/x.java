package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f40290a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f40291b;

    public x(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f40291b = tVar;
        this.f40290a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f40291b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f40249b;
        context = tVar.f40431a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f40290a);
    }
}
