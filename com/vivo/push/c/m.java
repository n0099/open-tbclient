package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.o f36596a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f36597b;

    public m(l lVar, com.vivo.push.b.o oVar) {
        this.f36597b = lVar;
        this.f36596a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f36597b;
        PushMessageCallback pushMessageCallback = ((ab) lVar).f36570b;
        context = lVar.f36752a;
        pushMessageCallback.onListTags(context, this.f36596a.h(), this.f36596a.d(), this.f36596a.g());
    }
}
