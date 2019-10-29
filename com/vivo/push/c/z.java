package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class z implements Runnable {
    final /* synthetic */ com.vivo.push.b.r a;
    final /* synthetic */ y b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, com.vivo.push.b.r rVar) {
        this.b = yVar;
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.a;
        pushMessageCallback.onPublish(context, this.a.h(), this.a.g());
    }
}
