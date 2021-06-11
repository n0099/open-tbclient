package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.t f40247a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f40248b;

    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.f40248b = zVar;
        this.f40247a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        z zVar = this.f40248b;
        PushMessageCallback pushMessageCallback = ((ab) zVar).f40249b;
        context = zVar.f40431a;
        pushMessageCallback.onPublish(context, this.f40247a.h(), this.f40247a.g());
    }
}
