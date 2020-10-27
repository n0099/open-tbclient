package com.vivo.push;

import android.content.Context;
import com.vivo.push.LocalAliasTagsManager;
/* loaded from: classes15.dex */
final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f4679a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f4679a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        LocalAliasTagsManager.LocalMessageCallback localMessageCallback = this.f4679a.b;
        context = this.f4679a.c.mContext;
        localMessageCallback.onTransmissionMessage(context, this.f4679a.f4678a);
    }
}
