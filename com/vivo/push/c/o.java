package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes15.dex */
final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.p f13619a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ n f13620b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, com.vivo.push.b.p pVar) {
        this.f13620b = nVar;
        this.f13619a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13620b.f13604b;
        context = this.f13620b.f13711a;
        pushMessageCallback.onLog(context, this.f13619a.d(), this.f13619a.e(), this.f13619a.f());
    }
}
