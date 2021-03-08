package com.vivo.push;

import android.content.Context;
import com.vivo.push.LocalAliasTagsManager;
/* loaded from: classes14.dex */
final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f8056a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f8056a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        LocalAliasTagsManager.LocalMessageCallback localMessageCallback = this.f8056a.b;
        context = this.f8056a.c.mContext;
        localMessageCallback.onTransmissionMessage(context, this.f8056a.f8055a);
    }
}
