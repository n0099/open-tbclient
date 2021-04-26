package com.win.opensdk;

import com.win.opensdk.top.PProvider;
/* loaded from: classes6.dex */
public class a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PProvider f37819a;

    public a1(PProvider pProvider) {
        this.f37819a = pProvider;
    }

    @Override // java.lang.Runnable
    public void run() {
        PProvider pProvider = this.f37819a;
        pProvider.f37951a = pProvider.getContext();
        PProvider pProvider2 = this.f37819a;
        if (pProvider2.f37951a == null) {
            return;
        }
        pProvider2.a();
    }
}
