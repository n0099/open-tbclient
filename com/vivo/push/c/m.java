package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.o f39819a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f39820b;

    public m(l lVar, com.vivo.push.b.o oVar) {
        this.f39820b = lVar;
        this.f39819a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f39820b;
        PushMessageCallback pushMessageCallback = ((ab) lVar).f39793b;
        context = lVar.f39973a;
        pushMessageCallback.onListTags(context, this.f39819a.h(), this.f39819a.d(), this.f39819a.g());
    }
}
