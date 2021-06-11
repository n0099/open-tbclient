package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class ag implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.k f40260a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ af f40261b;

    public ag(af afVar, com.vivo.push.b.k kVar) {
        this.f40261b = afVar;
        this.f40260a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        af afVar = this.f40261b;
        PushMessageCallback pushMessageCallback = ((ab) afVar).f40249b;
        context = afVar.f40431a;
        pushMessageCallback.onUnBind(context, this.f40260a.h(), this.f40260a.d());
    }
}
