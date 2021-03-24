package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.p f39436a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f39437b;

    public o(n nVar, com.vivo.push.b.p pVar) {
        this.f39437b = nVar;
        this.f39436a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        n nVar = this.f39437b;
        PushMessageCallback pushMessageCallback = ((ab) nVar).f39408b;
        context = nVar.f39588a;
        pushMessageCallback.onLog(context, this.f39436a.d(), this.f39436a.e(), this.f39436a.f());
    }
}
