package com.vivo.push;

import android.content.Context;
import com.vivo.push.LocalAliasTagsManager;
/* loaded from: classes7.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f40420a;

    public k(j jVar) {
        this.f40420a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        j jVar = this.f40420a;
        LocalAliasTagsManager.LocalMessageCallback localMessageCallback = jVar.f40418b;
        context = jVar.f40419c.mContext;
        localMessageCallback.onTransmissionMessage(context, this.f40420a.f40417a);
    }
}
