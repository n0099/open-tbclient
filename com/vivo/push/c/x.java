package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f36611a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f36612b;

    public x(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f36612b = tVar;
        this.f36611a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f36612b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f36570b;
        context = tVar.f36752a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f36611a);
    }
}
