package com.win.opensdk;

import com.win.opensdk.top.PProvider;
/* loaded from: classes7.dex */
public class D1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PProvider f39656a;

    public D1(PProvider pProvider) {
        this.f39656a = pProvider;
    }

    @Override // java.lang.Runnable
    public void run() {
        PProvider pProvider = this.f39656a;
        pProvider.f40044a = pProvider.getContext();
        PProvider pProvider2 = this.f39656a;
        if (pProvider2.f40044a == null) {
            return;
        }
        pProvider2.a();
    }
}
