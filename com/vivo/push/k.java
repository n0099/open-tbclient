package com.vivo.push;

import android.content.Context;
import com.vivo.push.LocalAliasTagsManager;
/* loaded from: classes7.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f39476a;

    public k(j jVar) {
        this.f39476a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        j jVar = this.f39476a;
        LocalAliasTagsManager.LocalMessageCallback localMessageCallback = jVar.f39474b;
        context = jVar.f39475c.mContext;
        localMessageCallback.onTransmissionMessage(context, this.f39476a.f39473a);
    }
}
