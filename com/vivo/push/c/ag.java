package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes8.dex */
final class ag implements Runnable {
    final /* synthetic */ com.vivo.push.b.k a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.b = afVar;
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.a;
        pushMessageCallback.onUnBind(context, this.a.h(), this.a.d());
    }
}
