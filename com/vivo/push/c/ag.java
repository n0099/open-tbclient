package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.k f13607a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ af f13608b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.f13608b = afVar;
        this.f13607a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13608b.f13602b;
        context = this.f13608b.f13709a;
        pushMessageCallback.onUnBind(context, this.f13607a.h(), this.f13607a.d());
    }
}
