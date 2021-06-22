package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.o f40378a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f40379b;

    public m(l lVar, com.vivo.push.b.o oVar) {
        this.f40379b = lVar;
        this.f40378a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f40379b;
        PushMessageCallback pushMessageCallback = ((ab) lVar).f40352b;
        context = lVar.f40534a;
        pushMessageCallback.onListTags(context, this.f40378a.h(), this.f40378a.d(), this.f40378a.g());
    }
}
