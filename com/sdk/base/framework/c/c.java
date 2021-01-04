package com.sdk.base.framework.c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes15.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private List<d> f13113a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private List<String> f13114b = new ArrayList();
    private List<String> c = new ArrayList();
    private String d = "";

    public final String a() {
        return this.d;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(List<d> list) {
        this.f13113a = list;
    }

    public final List<d> b() {
        return this.f13113a;
    }

    public final void b(List<String> list) {
        this.f13114b = list;
    }

    public final List<String> c() {
        return this.f13114b;
    }

    public final void c(List<String> list) {
        this.c = list;
    }

    public final List<String> d() {
        return this.c;
    }

    public final String toString() {
        return "StatusBean{_$101005=" + this.f13113a + ", _$302001=" + this.f13114b + ", _$302002=" + this.c + ", _$302003='" + this.d + "'}";
    }
}
