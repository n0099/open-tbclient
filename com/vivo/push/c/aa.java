package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes15.dex */
final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.t f4654a;
    final /* synthetic */ z b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.b = zVar;
        this.f4654a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.f4712a;
        pushMessageCallback.onPublish(context, this.f4654a.h(), this.f4654a.g());
    }
}
