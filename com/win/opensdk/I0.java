package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes6.dex */
public class I0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Info f37659a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ K0 f37660b;

    public I0(K0 k0, Info info) {
        this.f37660b = k0;
        this.f37659a = info;
    }

    @Override // java.lang.Runnable
    public void run() {
        L0 l0 = this.f37660b.f37686g;
        if (l0 != null) {
            l0.a(this.f37659a);
        }
    }
}
