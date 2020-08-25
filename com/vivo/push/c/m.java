package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes9.dex */
final class m implements Runnable {
    final /* synthetic */ com.vivo.push.b.o a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, com.vivo.push.b.o oVar) {
        this.b = lVar;
        this.a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.a;
        pushMessageCallback.onListTags(context, this.a.h(), this.a.d(), this.a.g());
    }
}
