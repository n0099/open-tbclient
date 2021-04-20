package com.win.opensdk;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g1 f40219a;

    public f1(g1 g1Var) {
        this.f40219a = g1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        HashMap a2 = p1.a(this.f40219a.f40224a);
        try {
            str = this.f40219a.a() + p1.a(a2);
        } catch (UnsupportedEncodingException unused) {
            str = "";
        }
        G.a(str, (Map) null, new e1(this));
    }
}
