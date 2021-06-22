package com.sdk.base.framework.c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f39432a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f39433b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<String> f39434c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f39435d = "";

    public final String a() {
        return this.f39435d;
    }

    public final void a(String str) {
        this.f39435d = str;
    }

    public final void a(List<d> list) {
        this.f39432a = list;
    }

    public final List<d> b() {
        return this.f39432a;
    }

    public final void b(List<String> list) {
        this.f39433b = list;
    }

    public final List<String> c() {
        return this.f39433b;
    }

    public final void c(List<String> list) {
        this.f39434c = list;
    }

    public final List<String> d() {
        return this.f39434c;
    }

    public final String toString() {
        return "StatusBean{_$101005=" + this.f39432a + ", _$302001=" + this.f39433b + ", _$302002=" + this.f39434c + ", _$302003='" + this.f39435d + "'}";
    }
}
