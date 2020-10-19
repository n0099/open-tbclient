package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes15.dex */
final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.t f4656a;
    final /* synthetic */ z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.b = zVar;
        this.f4656a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.f4714a;
        pushMessageCallback.onPublish(context, this.f4656a.h(), this.f4656a.g());
    }
}
