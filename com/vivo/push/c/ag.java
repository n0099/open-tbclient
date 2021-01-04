package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.k f13906a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ af f13907b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.f13907b = afVar;
        this.f13906a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13907b.f13901b;
        context = this.f13907b.f14008a;
        pushMessageCallback.onUnBind(context, this.f13906a.h(), this.f13906a.d());
    }
}
