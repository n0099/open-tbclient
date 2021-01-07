package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes4.dex */
final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.t f13900a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ z f13901b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.f13901b = zVar;
        this.f13900a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13901b.f13902b;
        context = this.f13901b.f14009a;
        pushMessageCallback.onPublish(context, this.f13900a.h(), this.f13900a.g());
    }
}
