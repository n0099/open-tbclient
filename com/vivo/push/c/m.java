package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.o f13914a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ l f13915b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, com.vivo.push.b.o oVar) {
        this.f13915b = lVar;
        this.f13914a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13915b.f13901b;
        context = this.f13915b.f14008a;
        pushMessageCallback.onListTags(context, this.f13914a.h(), this.f13914a.d(), this.f13914a.g());
    }
}
