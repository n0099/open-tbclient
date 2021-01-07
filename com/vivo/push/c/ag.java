package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes4.dex */
final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.k f13907a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ af f13908b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.f13908b = afVar;
        this.f13907a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13908b.f13902b;
        context = this.f13908b.f14009a;
        pushMessageCallback.onUnBind(context, this.f13907a.h(), this.f13907a.d());
    }
}
