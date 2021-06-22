package com.win.opensdk;

import com.win.opensdk.top.PProvider;
/* loaded from: classes7.dex */
public class a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PProvider f40775a;

    public a1(PProvider pProvider) {
        this.f40775a = pProvider;
    }

    @Override // java.lang.Runnable
    public void run() {
        PProvider pProvider = this.f40775a;
        pProvider.f40907a = pProvider.getContext();
        PProvider pProvider2 = this.f40775a;
        if (pProvider2.f40907a == null) {
            return;
        }
        pProvider2.a();
    }
}
