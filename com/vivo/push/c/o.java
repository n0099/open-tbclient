package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes4.dex */
final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.p f13917a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ n f13918b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, com.vivo.push.b.p pVar) {
        this.f13918b = nVar;
        this.f13917a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13918b.f13902b;
        context = this.f13918b.f14009a;
        pushMessageCallback.onLog(context, this.f13917a.d(), this.f13917a.e(), this.f13917a.f());
    }
}
