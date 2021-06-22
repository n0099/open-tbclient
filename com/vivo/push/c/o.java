package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.p f40380a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f40381b;

    public o(n nVar, com.vivo.push.b.p pVar) {
        this.f40381b = nVar;
        this.f40380a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        n nVar = this.f40381b;
        PushMessageCallback pushMessageCallback = ((ab) nVar).f40352b;
        context = nVar.f40534a;
        pushMessageCallback.onLog(context, this.f40380a.d(), this.f40380a.e(), this.f40380a.f());
    }
}
