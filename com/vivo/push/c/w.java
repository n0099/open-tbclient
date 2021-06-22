package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f40391a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f40392b;

    public w(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f40392b = tVar;
        this.f40391a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f40392b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f40352b;
        context = tVar.f40534a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f40391a);
    }
}
