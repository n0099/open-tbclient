package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f40288a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f40289b;

    public w(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f40289b = tVar;
        this.f40288a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f40289b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f40249b;
        context = tVar.f40431a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f40288a);
    }
}
