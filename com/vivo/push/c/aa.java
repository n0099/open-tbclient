package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.t f39406a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f39407b;

    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.f39407b = zVar;
        this.f39406a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        z zVar = this.f39407b;
        PushMessageCallback pushMessageCallback = ((ab) zVar).f39408b;
        context = zVar.f39588a;
        pushMessageCallback.onPublish(context, this.f39406a.h(), this.f39406a.g());
    }
}
