package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f39804a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ af f39805b;

    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.f39805b = afVar;
        this.f39804a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        af afVar = this.f39805b;
        PushMessageCallback pushMessageCallback = ((ab) afVar).f39793b;
        context = afVar.f39973a;
        pushMessageCallback.onUnBind(context, this.f39804a.h(), this.f39804a.d());
    }
}
