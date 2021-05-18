package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.t f36639a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f36640b;

    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.f36640b = zVar;
        this.f36639a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        z zVar = this.f36640b;
        PushMessageCallback pushMessageCallback = ((ab) zVar).f36641b;
        context = zVar.f36823a;
        pushMessageCallback.onPublish(context, this.f36639a.h(), this.f36639a.g());
    }
}
