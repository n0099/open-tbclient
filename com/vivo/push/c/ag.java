package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f39420a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ af f39421b;

    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.f39421b = afVar;
        this.f39420a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        af afVar = this.f39421b;
        PushMessageCallback pushMessageCallback = ((ab) afVar).f39409b;
        context = afVar.f39589a;
        pushMessageCallback.onUnBind(context, this.f39420a.h(), this.f39420a.d());
    }
}
