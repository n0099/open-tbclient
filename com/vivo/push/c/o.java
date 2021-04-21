package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.p f39821a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f39822b;

    public o(n nVar, com.vivo.push.b.p pVar) {
        this.f39822b = nVar;
        this.f39821a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        n nVar = this.f39822b;
        PushMessageCallback pushMessageCallback = ((ab) nVar).f39793b;
        context = nVar.f39973a;
        pushMessageCallback.onLog(context, this.f39821a.d(), this.f39821a.e(), this.f39821a.f());
    }
}
