package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.p f40277a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f40278b;

    public o(n nVar, com.vivo.push.b.p pVar) {
        this.f40278b = nVar;
        this.f40277a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        n nVar = this.f40278b;
        PushMessageCallback pushMessageCallback = ((ab) nVar).f40249b;
        context = nVar.f40431a;
        pushMessageCallback.onLog(context, this.f40277a.d(), this.f40277a.e(), this.f40277a.f());
    }
}
