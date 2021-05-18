package com.vivo.push;

import android.content.Context;
import com.vivo.push.LocalAliasTagsManager;
/* loaded from: classes7.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f36709a;

    public k(j jVar) {
        this.f36709a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        j jVar = this.f36709a;
        LocalAliasTagsManager.LocalMessageCallback localMessageCallback = jVar.f36707b;
        context = jVar.f36708c.mContext;
        localMessageCallback.onTransmissionMessage(context, this.f36709a.f36706a);
    }
}
