package com.win.opensdk;

import com.win.opensdk.top.PProvider;
/* loaded from: classes7.dex */
public class D1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PProvider f40040a;

    public D1(PProvider pProvider) {
        this.f40040a = pProvider;
    }

    @Override // java.lang.Runnable
    public void run() {
        PProvider pProvider = this.f40040a;
        pProvider.f40428a = pProvider.getContext();
        PProvider pProvider2 = this.f40040a;
        if (pProvider2.f40428a == null) {
            return;
        }
        pProvider2.a();
    }
}
