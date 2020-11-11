package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes15.dex */
final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.o f4663a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, com.vivo.push.b.o oVar) {
        this.b = lVar;
        this.f4663a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.f4714a;
        pushMessageCallback.onListTags(context, this.f4663a.h(), this.f4663a.d(), this.f4663a.g());
    }
}
