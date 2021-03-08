package com.win.opensdk;

import com.win.opensdk.top.PProvider;
/* loaded from: classes14.dex */
public class p implements Runnable {
    public final /* synthetic */ PProvider qkv;

    public p(PProvider pProvider) {
        this.qkv = pProvider;
    }

    @Override // java.lang.Runnable
    public void run() {
        PProvider pProvider = this.qkv;
        pProvider.f8173a = pProvider.getContext();
        PProvider pProvider2 = this.qkv;
        if (pProvider2.f8173a == null) {
            return;
        }
        pProvider2.a();
    }
}
