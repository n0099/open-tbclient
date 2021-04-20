package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.p f39726a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f39727b;

    public o(n nVar, com.vivo.push.b.p pVar) {
        this.f39727b = nVar;
        this.f39726a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        n nVar = this.f39727b;
        PushMessageCallback pushMessageCallback = ((ab) nVar).f39698b;
        context = nVar.f39878a;
        pushMessageCallback.onLog(context, this.f39726a.d(), this.f39726a.e(), this.f39726a.f());
    }
}
