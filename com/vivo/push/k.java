package com.vivo.push;

import android.content.Context;
import com.vivo.push.LocalAliasTagsManager;
/* loaded from: classes7.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f39477a;

    public k(j jVar) {
        this.f39477a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        j jVar = this.f39477a;
        LocalAliasTagsManager.LocalMessageCallback localMessageCallback = jVar.f39475b;
        context = jVar.f39476c.mContext;
        localMessageCallback.onTransmissionMessage(context, this.f39477a.f39474a);
    }
}
