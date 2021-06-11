package com.sdk.base.framework.c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f39334a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f39335b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<String> f39336c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f39337d = "";

    public final String a() {
        return this.f39337d;
    }

    public final void a(String str) {
        this.f39337d = str;
    }

    public final void a(List<d> list) {
        this.f39334a = list;
    }

    public final List<d> b() {
        return this.f39334a;
    }

    public final void b(List<String> list) {
        this.f39335b = list;
    }

    public final List<String> c() {
        return this.f39335b;
    }

    public final void c(List<String> list) {
        this.f39336c = list;
    }

    public final List<String> d() {
        return this.f39336c;
    }

    public final String toString() {
        return "StatusBean{_$101005=" + this.f39334a + ", _$302001=" + this.f39335b + ", _$302002=" + this.f39336c + ", _$302003='" + this.f39337d + "'}";
    }
}
