package com.vivo.push;

import android.content.Context;
import com.vivo.push.LocalAliasTagsManager;
/* loaded from: classes7.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f39766a;

    public k(j jVar) {
        this.f39766a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        j jVar = this.f39766a;
        LocalAliasTagsManager.LocalMessageCallback localMessageCallback = jVar.f39764b;
        context = jVar.f39765c.mContext;
        localMessageCallback.onTransmissionMessage(context, this.f39766a.f39763a);
    }
}
