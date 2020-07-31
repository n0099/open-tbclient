package com.vivo.push;

import android.content.Context;
import com.vivo.push.LocalAliasTagsManager;
/* loaded from: classes3.dex */
final class k implements Runnable {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        LocalAliasTagsManager.LocalMessageCallback localMessageCallback = this.a.b;
        context = this.a.c.mContext;
        localMessageCallback.onTransmissionMessage(context, this.a.a);
    }
}
