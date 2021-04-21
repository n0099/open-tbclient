package com.vivo.push;

import android.content.Context;
import com.vivo.push.LocalAliasTagsManager;
/* loaded from: classes7.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f39861a;

    public k(j jVar) {
        this.f39861a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        j jVar = this.f39861a;
        LocalAliasTagsManager.LocalMessageCallback localMessageCallback = jVar.f39859b;
        context = jVar.f39860c.mContext;
        localMessageCallback.onTransmissionMessage(context, this.f39861a.f39858a);
    }
}
