package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes15.dex */
final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.k f13609a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ af f13610b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.f13610b = afVar;
        this.f13609a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13610b.f13604b;
        context = this.f13610b.f13711a;
        pushMessageCallback.onUnBind(context, this.f13609a.h(), this.f13609a.d());
    }
}
