package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import com.tencent.turingfd.sdk.ams.au.m;
/* loaded from: classes3.dex */
public final class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ m.a f13532a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f13533b;

    public l(m.a aVar, Context context) {
        this.f13532a = aVar;
        this.f13533b = context;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f13532a.f13536a.b(this.f13533b);
    }
}
