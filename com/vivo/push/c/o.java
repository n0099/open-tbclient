package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes6.dex */
public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.p f37424a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f37425b;

    public o(n nVar, com.vivo.push.b.p pVar) {
        this.f37425b = nVar;
        this.f37424a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        n nVar = this.f37425b;
        PushMessageCallback pushMessageCallback = ((ab) nVar).f37396b;
        context = nVar.f37578a;
        pushMessageCallback.onLog(context, this.f37424a.d(), this.f37424a.e(), this.f37424a.f());
    }
}
