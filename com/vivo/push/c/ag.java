package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f39709a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ af f39710b;

    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.f39710b = afVar;
        this.f39709a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        af afVar = this.f39710b;
        PushMessageCallback pushMessageCallback = ((ab) afVar).f39698b;
        context = afVar.f39878a;
        pushMessageCallback.onUnBind(context, this.f39709a.h(), this.f39709a.d());
    }
}
