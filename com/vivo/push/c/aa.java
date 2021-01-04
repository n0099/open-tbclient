package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.t f13899a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ z f13900b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.f13900b = zVar;
        this.f13899a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13900b.f13901b;
        context = this.f13900b.f14008a;
        pushMessageCallback.onPublish(context, this.f13899a.h(), this.f13899a.g());
    }
}
