package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.o f39435a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f39436b;

    public m(l lVar, com.vivo.push.b.o oVar) {
        this.f39436b = lVar;
        this.f39435a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f39436b;
        PushMessageCallback pushMessageCallback = ((ab) lVar).f39409b;
        context = lVar.f39589a;
        pushMessageCallback.onListTags(context, this.f39435a.h(), this.f39435a.d(), this.f39435a.g());
    }
}
