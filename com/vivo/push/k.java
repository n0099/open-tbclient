package com.vivo.push;

import android.content.Context;
import com.vivo.push.LocalAliasTagsManager;
/* loaded from: classes6.dex */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f37464a;

    public k(j jVar) {
        this.f37464a = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        j jVar = this.f37464a;
        LocalAliasTagsManager.LocalMessageCallback localMessageCallback = jVar.f37462b;
        context = jVar.f37463c.mContext;
        localMessageCallback.onTransmissionMessage(context, this.f37464a.f37461a);
    }
}
