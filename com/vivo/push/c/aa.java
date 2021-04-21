package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.t f39791a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f39792b;

    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.f39792b = zVar;
        this.f39791a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        z zVar = this.f39792b;
        PushMessageCallback pushMessageCallback = ((ab) zVar).f39793b;
        context = zVar.f39973a;
        pushMessageCallback.onPublish(context, this.f39791a.h(), this.f39791a.g());
    }
}
