package com.win.opensdk;

import com.win.opensdk.top.PProvider;
/* loaded from: classes7.dex */
public class a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PProvider f37064a;

    public a1(PProvider pProvider) {
        this.f37064a = pProvider;
    }

    @Override // java.lang.Runnable
    public void run() {
        PProvider pProvider = this.f37064a;
        pProvider.f37196a = pProvider.getContext();
        PProvider pProvider2 = this.f37064a;
        if (pProvider2.f37196a == null) {
            return;
        }
        pProvider2.a();
    }
}
