package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes8.dex */
final class af implements Runnable {
    final /* synthetic */ com.vivo.push.b.j a;
    final /* synthetic */ ae b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, com.vivo.push.b.j jVar) {
        this.b = aeVar;
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.a;
        pushMessageCallback.onUnBind(context, this.a.h(), this.a.d());
    }
}
