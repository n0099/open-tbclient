package com.sdk.base.framework.c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f38513a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f38514b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<String> f38515c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f38516d = "";

    public final String a() {
        return this.f38516d;
    }

    public final void a(String str) {
        this.f38516d = str;
    }

    public final void a(List<d> list) {
        this.f38513a = list;
    }

    public final List<d> b() {
        return this.f38513a;
    }

    public final void b(List<String> list) {
        this.f38514b = list;
    }

    public final List<String> c() {
        return this.f38514b;
    }

    public final void c(List<String> list) {
        this.f38515c = list;
    }

    public final List<String> d() {
        return this.f38515c;
    }

    public final String toString() {
        return "StatusBean{_$101005=" + this.f38513a + ", _$302001=" + this.f38514b + ", _$302002=" + this.f38515c + ", _$302003='" + this.f38516d + "'}";
    }
}
