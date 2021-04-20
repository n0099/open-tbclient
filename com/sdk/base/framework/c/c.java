package com.sdk.base.framework.c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f38802a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f38803b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<String> f38804c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f38805d = "";

    public final String a() {
        return this.f38805d;
    }

    public final void a(String str) {
        this.f38805d = str;
    }

    public final void a(List<d> list) {
        this.f38802a = list;
    }

    public final List<d> b() {
        return this.f38802a;
    }

    public final void b(List<String> list) {
        this.f38803b = list;
    }

    public final List<String> c() {
        return this.f38803b;
    }

    public final void c(List<String> list) {
        this.f38804c = list;
    }

    public final List<String> d() {
        return this.f38804c;
    }

    public final String toString() {
        return "StatusBean{_$101005=" + this.f38802a + ", _$302001=" + this.f38803b + ", _$302002=" + this.f38804c + ", _$302003='" + this.f38805d + "'}";
    }
}
