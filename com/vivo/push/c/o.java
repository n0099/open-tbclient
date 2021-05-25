package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.p f36598a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f36599b;

    public o(n nVar, com.vivo.push.b.p pVar) {
        this.f36599b = nVar;
        this.f36598a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        n nVar = this.f36599b;
        PushMessageCallback pushMessageCallback = ((ab) nVar).f36570b;
        context = nVar.f36752a;
        pushMessageCallback.onLog(context, this.f36598a.d(), this.f36598a.e(), this.f36598a.f());
    }
}
