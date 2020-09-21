package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes12.dex */
final class o implements Runnable {
    final /* synthetic */ com.vivo.push.b.p a;
    final /* synthetic */ n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, com.vivo.push.b.p pVar) {
        this.b = nVar;
        this.a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.a;
        pushMessageCallback.onLog(context, this.a.d(), this.a.e(), this.a.f());
    }
}
