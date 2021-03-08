package com.sdk.base.framework.c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private List<d> f7629a = new ArrayList();
    private List<String> b = new ArrayList();
    private List<String> c = new ArrayList();
    private String d = "";

    public final String a() {
        return this.d;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(List<d> list) {
        this.f7629a = list;
    }

    public final List<d> b() {
        return this.f7629a;
    }

    public final void b(List<String> list) {
        this.b = list;
    }

    public final List<String> c() {
        return this.b;
    }

    public final void c(List<String> list) {
        this.c = list;
    }

    public final List<String> d() {
        return this.c;
    }

    public final String toString() {
        return "StatusBean{_$101005=" + this.f7629a + ", _$302001=" + this.b + ", _$302002=" + this.c + ", _$302003='" + this.d + "'}";
    }
}
