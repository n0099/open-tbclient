package com.win.opensdk;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class C0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ D0 f40573a;

    public C0(D0 d0) {
        this.f40573a = d0;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        HashMap a2 = M0.a(this.f40573a.f40586a);
        try {
            str = this.f40573a.a() + M0.a(a2);
        } catch (UnsupportedEncodingException unused) {
            str = "";
        }
        z.a(str, (Map) null, new B0(this));
    }
}
