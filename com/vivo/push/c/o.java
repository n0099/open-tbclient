package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.p f13617a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ n f13618b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, com.vivo.push.b.p pVar) {
        this.f13618b = nVar;
        this.f13617a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13618b.f13602b;
        context = this.f13618b.f13709a;
        pushMessageCallback.onLog(context, this.f13617a.d(), this.f13617a.e(), this.f13617a.f());
    }
}
