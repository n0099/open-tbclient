package com.vivo.push;

import android.content.Context;
import com.vivo.push.LocalAliasTagsManager;
/* loaded from: classes4.dex */
final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f13950a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f13950a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        LocalAliasTagsManager.LocalMessageCallback localMessageCallback = this.f13950a.f13949b;
        context = this.f13950a.c.mContext;
        localMessageCallback.onTransmissionMessage(context, this.f13950a.f13948a);
    }
}
