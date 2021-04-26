package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes6.dex */
public final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.t f37394a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f37395b;

    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.f37395b = zVar;
        this.f37394a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        z zVar = this.f37395b;
        PushMessageCallback pushMessageCallback = ((ab) zVar).f37396b;
        context = zVar.f37578a;
        pushMessageCallback.onPublish(context, this.f37394a.h(), this.f37394a.g());
    }
}
