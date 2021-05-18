package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f36652a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ af f36653b;

    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.f36653b = afVar;
        this.f36652a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        af afVar = this.f36653b;
        PushMessageCallback pushMessageCallback = ((ab) afVar).f36641b;
        context = afVar.f36823a;
        pushMessageCallback.onUnBind(context, this.f36652a.h(), this.f36652a.d());
    }
}
