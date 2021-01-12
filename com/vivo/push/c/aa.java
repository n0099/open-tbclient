package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.t f13600a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ z f13601b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.f13601b = zVar;
        this.f13600a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13601b.f13602b;
        context = this.f13601b.f13709a;
        pushMessageCallback.onPublish(context, this.f13600a.h(), this.f13600a.g());
    }
}
