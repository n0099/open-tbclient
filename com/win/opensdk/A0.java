package com.win.opensdk;

import android.webkit.JsResult;
/* loaded from: classes7.dex */
public class A0 implements D0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0 f39615a;

    public A0(C0 c0) {
        this.f39615a = c0;
    }

    public void a(C0 c0, boolean z) {
    }

    public boolean a(String str) {
        A2 a2;
        J0 j0 = this.f39615a.o;
        if (j0 == null || (a2 = ((R0) j0).f39785d) == null) {
            return false;
        }
        return a2.a(str, "");
    }

    public boolean a(String str, JsResult jsResult) {
        return false;
    }

    public boolean a(boolean z) {
        return false;
    }

    public void a() {
        J0 j0 = this.f39615a.o;
        if (j0 != null) {
            ((R0) j0).c();
        }
    }
}
