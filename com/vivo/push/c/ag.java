package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f36581a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ af f36582b;

    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.f36582b = afVar;
        this.f36581a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        af afVar = this.f36582b;
        PushMessageCallback pushMessageCallback = ((ab) afVar).f36570b;
        context = afVar.f36752a;
        pushMessageCallback.onUnBind(context, this.f36581a.h(), this.f36581a.d());
    }
}
