package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes3.dex */
final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.p f13916a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ n f13917b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, com.vivo.push.b.p pVar) {
        this.f13917b = nVar;
        this.f13916a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.f13917b.f13901b;
        context = this.f13917b.f14008a;
        pushMessageCallback.onLog(context, this.f13916a.d(), this.f13916a.e(), this.f13916a.f());
    }
}
