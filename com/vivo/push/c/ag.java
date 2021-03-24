package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f39419a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ af f39420b;

    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.f39420b = afVar;
        this.f39419a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        af afVar = this.f39420b;
        PushMessageCallback pushMessageCallback = ((ab) afVar).f39408b;
        context = afVar.f39588a;
        pushMessageCallback.onUnBind(context, this.f39419a.h(), this.f39419a.d());
    }
}
