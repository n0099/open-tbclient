package com.win.opensdk;

import com.win.opensdk.top.PProvider;
/* loaded from: classes7.dex */
public class a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PProvider f36993a;

    public a1(PProvider pProvider) {
        this.f36993a = pProvider;
    }

    @Override // java.lang.Runnable
    public void run() {
        PProvider pProvider = this.f36993a;
        pProvider.f37125a = pProvider.getContext();
        PProvider pProvider2 = this.f36993a;
        if (pProvider2.f37125a == null) {
            return;
        }
        pProvider2.a();
    }
}
