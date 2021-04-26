package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
/* loaded from: classes6.dex */
public final class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.vivo.push.b.o f37422a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f37423b;

    public m(l lVar, com.vivo.push.b.o oVar) {
        this.f37423b = lVar;
        this.f37422a = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f37423b;
        PushMessageCallback pushMessageCallback = ((ab) lVar).f37396b;
        context = lVar.f37578a;
        pushMessageCallback.onListTags(context, this.f37422a.h(), this.f37422a.d(), this.f37422a.g());
    }
}
