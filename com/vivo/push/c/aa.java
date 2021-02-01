package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes15.dex */
final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.t f13602a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ z f13603b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.f13603b = zVar;
        this.f13602a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13603b.f13604b;
        context = this.f13603b.f13711a;
        pushMessageCallback.onPublish(context, this.f13602a.h(), this.f13602a.g());
    }
}
