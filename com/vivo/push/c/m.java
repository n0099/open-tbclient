package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.o f40275a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f40276b;

    public m(l lVar, com.vivo.push.b.o oVar) {
        this.f40276b = lVar;
        this.f40275a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f40276b;
        PushMessageCallback pushMessageCallback = ((ab) lVar).f40249b;
        context = lVar.f40431a;
        pushMessageCallback.onListTags(context, this.f40275a.h(), this.f40275a.d(), this.f40275a.g());
    }
}
