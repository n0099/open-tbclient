package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.o f39434a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f39435b;

    public m(l lVar, com.vivo.push.b.o oVar) {
        this.f39435b = lVar;
        this.f39434a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f39435b;
        PushMessageCallback pushMessageCallback = ((ab) lVar).f39408b;
        context = lVar.f39588a;
        pushMessageCallback.onListTags(context, this.f39434a.h(), this.f39434a.d(), this.f39434a.g());
    }
}
