package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.o f36667a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f36668b;

    public m(l lVar, com.vivo.push.b.o oVar) {
        this.f36668b = lVar;
        this.f36667a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f36668b;
        PushMessageCallback pushMessageCallback = ((ab) lVar).f36641b;
        context = lVar.f36823a;
        pushMessageCallback.onListTags(context, this.f36667a.h(), this.f36667a.d(), this.f36667a.g());
    }
}
