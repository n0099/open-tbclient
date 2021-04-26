package com.sdk.base.framework.c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f36481a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f36482b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<String> f36483c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f36484d = "";

    public final String a() {
        return this.f36484d;
    }

    public final void a(String str) {
        this.f36484d = str;
    }

    public final void a(List<d> list) {
        this.f36481a = list;
    }

    public final List<d> b() {
        return this.f36481a;
    }

    public final void b(List<String> list) {
        this.f36482b = list;
    }

    public final List<String> c() {
        return this.f36482b;
    }

    public final void c(List<String> list) {
        this.f36483c = list;
    }

    public final List<String> d() {
        return this.f36483c;
    }

    public final String toString() {
        return "StatusBean{_$101005=" + this.f36481a + ", _$302001=" + this.f36482b + ", _$302002=" + this.f36483c + ", _$302003='" + this.f36484d + "'}";
    }
}
