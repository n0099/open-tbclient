package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes12.dex */
final class aa implements Runnable {
    final /* synthetic */ com.vivo.push.b.t a;
    final /* synthetic */ z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.b = zVar;
        this.a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.a;
        pushMessageCallback.onPublish(context, this.a.h(), this.a.g());
    }
}
