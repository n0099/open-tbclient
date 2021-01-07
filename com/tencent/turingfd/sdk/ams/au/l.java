package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import com.tencent.turingfd.sdk.ams.au.m;
/* loaded from: classes4.dex */
public final class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m.a f13832a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f13833b;

    public l(m.a aVar, Context context) {
        this.f13832a = aVar;
        this.f13833b = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f13832a.f13836a.b(this.f13833b);
    }
}
