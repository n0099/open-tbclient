package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.t f40350a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f40351b;

    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.f40351b = zVar;
        this.f40350a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        z zVar = this.f40351b;
        PushMessageCallback pushMessageCallback = ((ab) zVar).f40352b;
        context = zVar.f40534a;
        pushMessageCallback.onPublish(context, this.f40350a.h(), this.f40350a.g());
    }
}
