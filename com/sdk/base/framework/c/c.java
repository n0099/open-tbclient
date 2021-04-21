package com.sdk.base.framework.c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f38897a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f38898b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<String> f38899c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f38900d = "";

    public final String a() {
        return this.f38900d;
    }

    public final void a(String str) {
        this.f38900d = str;
    }

    public final void a(List<d> list) {
        this.f38897a = list;
    }

    public final List<d> b() {
        return this.f38897a;
    }

    public final void b(List<String> list) {
        this.f38898b = list;
    }

    public final List<String> c() {
        return this.f38898b;
    }

    public final void c(List<String> list) {
        this.f38899c = list;
    }

    public final List<String> d() {
        return this.f38899c;
    }

    public final String toString() {
        return "StatusBean{_$101005=" + this.f38897a + ", _$302001=" + this.f38898b + ", _$302002=" + this.f38899c + ", _$302003='" + this.f38900d + "'}";
    }
}
