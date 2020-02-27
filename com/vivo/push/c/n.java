package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes8.dex */
final class n implements Runnable {
    final /* synthetic */ com.vivo.push.b.n a;
    final /* synthetic */ m b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, com.vivo.push.b.n nVar) {
        this.b = mVar;
        this.a = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.a;
        pushMessageCallback.onLog(context, this.a.d(), this.a.e(), this.a.f());
    }
}
