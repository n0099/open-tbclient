package com.win.opensdk;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class f1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g1 f39930a;

    public f1(g1 g1Var) {
        this.f39930a = g1Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        HashMap a2 = p1.a(this.f39930a.f39935a);
        try {
            str = this.f39930a.a() + p1.a(a2);
        } catch (UnsupportedEncodingException unused) {
            str = "";
        }
        G.a(str, (Map) null, new e1(this));
    }
}
