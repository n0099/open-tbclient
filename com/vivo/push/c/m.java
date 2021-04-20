package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.o f39724a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f39725b;

    public m(l lVar, com.vivo.push.b.o oVar) {
        this.f39725b = lVar;
        this.f39724a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f39725b;
        PushMessageCallback pushMessageCallback = ((ab) lVar).f39698b;
        context = lVar.f39878a;
        pushMessageCallback.onListTags(context, this.f39724a.h(), this.f39724a.d(), this.f39724a.g());
    }
}
