package com.vivo.push;

import android.content.Context;
import com.vivo.push.LocalAliasTagsManager;
/* loaded from: classes3.dex */
final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f13650a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f13650a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        LocalAliasTagsManager.LocalMessageCallback localMessageCallback = this.f13650a.f13649b;
        context = this.f13650a.c.mContext;
        localMessageCallback.onTransmissionMessage(context, this.f13650a.f13648a);
    }
}
