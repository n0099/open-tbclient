package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f40363a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ af f40364b;

    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.f40364b = afVar;
        this.f40363a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        af afVar = this.f40364b;
        PushMessageCallback pushMessageCallback = ((ab) afVar).f40352b;
        context = afVar.f40534a;
        pushMessageCallback.onUnBind(context, this.f40363a.h(), this.f40363a.d());
    }
}
