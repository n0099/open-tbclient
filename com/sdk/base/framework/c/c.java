package com.sdk.base.framework.c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f35655a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f35656b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<String> f35657c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f35658d = "";

    public final String a() {
        return this.f35658d;
    }

    public final void a(String str) {
        this.f35658d = str;
    }

    public final void a(List<d> list) {
        this.f35655a = list;
    }

    public final List<d> b() {
        return this.f35655a;
    }

    public final void b(List<String> list) {
        this.f35656b = list;
    }

    public final List<String> c() {
        return this.f35656b;
    }

    public final void c(List<String> list) {
        this.f35657c = list;
    }

    public final List<String> d() {
        return this.f35657c;
    }

    public final String toString() {
        return "StatusBean{_$101005=" + this.f35655a + ", _$302001=" + this.f35656b + ", _$302002=" + this.f35657c + ", _$302003='" + this.f35658d + "'}";
    }
}
