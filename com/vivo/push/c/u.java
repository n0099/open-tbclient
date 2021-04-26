package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes6.dex */
public final class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UPSNotificationMessage f37431a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f37432b;

    public u(t tVar, UPSNotificationMessage uPSNotificationMessage) {
        this.f37432b = tVar;
        this.f37431a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        t tVar = this.f37432b;
        PushMessageCallback pushMessageCallback = ((ab) tVar).f37396b;
        context = tVar.f37578a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f37431a);
    }
}
