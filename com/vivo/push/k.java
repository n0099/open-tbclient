package com.vivo.push;

import android.content.Context;
import com.vivo.push.LocalAliasTagsManager;
/* loaded from: classes11.dex */
final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f4451a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f4451a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        LocalAliasTagsManager.LocalMessageCallback localMessageCallback = this.f4451a.b;
        context = this.f4451a.c.mContext;
        localMessageCallback.onTransmissionMessage(context, this.f4451a.f4450a);
    }
}
