package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes15.dex */
final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.o f13617a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l f13618b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, com.vivo.push.b.o oVar) {
        this.f13618b = lVar;
        this.f13617a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13618b.f13604b;
        context = this.f13618b.f13711a;
        pushMessageCallback.onListTags(context, this.f13617a.h(), this.f13617a.d(), this.f13617a.g());
    }
}
