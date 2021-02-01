package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import com.tencent.turingfd.sdk.ams.au.m;
/* loaded from: classes15.dex */
public final class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m.a f13534a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f13535b;

    public l(m.a aVar, Context context) {
        this.f13534a = aVar;
        this.f13535b = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f13534a.f13538a.b(this.f13535b);
    }
}
