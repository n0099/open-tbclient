package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.p f39437a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f39438b;

    public o(n nVar, com.vivo.push.b.p pVar) {
        this.f39438b = nVar;
        this.f39437a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        n nVar = this.f39438b;
        PushMessageCallback pushMessageCallback = ((ab) nVar).f39409b;
        context = nVar.f39589a;
        pushMessageCallback.onLog(context, this.f39437a.d(), this.f39437a.e(), this.f39437a.f());
    }
}
