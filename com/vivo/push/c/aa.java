package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes7.dex */
public final class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.t f36568a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f36569b;

    public aa(z zVar, com.vivo.push.b.t tVar) {
        this.f36569b = zVar;
        this.f36568a = tVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        z zVar = this.f36569b;
        PushMessageCallback pushMessageCallback = ((ab) zVar).f36570b;
        context = zVar.f36752a;
        pushMessageCallback.onPublish(context, this.f36568a.h(), this.f36568a.g());
    }
}
