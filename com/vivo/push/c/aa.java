package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.t f39696a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f39697b;

    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.f39697b = zVar;
        this.f39696a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        z zVar = this.f39697b;
        PushMessageCallback pushMessageCallback = ((ab) zVar).f39698b;
        context = zVar.f39878a;
        pushMessageCallback.onPublish(context, this.f39696a.h(), this.f39696a.g());
    }
}
