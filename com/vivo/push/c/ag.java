package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes11.dex */
final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.k f4429a;
    final /* synthetic */ af b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.b = afVar;
        this.f4429a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.f4484a;
        pushMessageCallback.onUnBind(context, this.f4429a.h(), this.f4429a.d());
    }
}
