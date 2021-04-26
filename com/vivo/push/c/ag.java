package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes6.dex */
public final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f37407a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ af f37408b;

    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.f37408b = afVar;
        this.f37407a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        af afVar = this.f37408b;
        PushMessageCallback pushMessageCallback = ((ab) afVar).f37396b;
        context = afVar.f37578a;
        pushMessageCallback.onUnBind(context, this.f37407a.h(), this.f37407a.d());
    }
}
