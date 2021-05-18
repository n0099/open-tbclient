package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.p f36669a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f36670b;

    public o(n nVar, com.vivo.push.b.p pVar) {
        this.f36670b = nVar;
        this.f36669a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        n nVar = this.f36670b;
        PushMessageCallback pushMessageCallback = ((ab) nVar).f36641b;
        context = nVar.f36823a;
        pushMessageCallback.onLog(context, this.f36669a.d(), this.f36669a.e(), this.f36669a.f());
    }
}
