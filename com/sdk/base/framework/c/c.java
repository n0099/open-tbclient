package com.sdk.base.framework.c;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public List<d> f35726a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<String> f35727b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<String> f35728c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f35729d = "";

    public final String a() {
        return this.f35729d;
    }

    public final void a(String str) {
        this.f35729d = str;
    }

    public final void a(List<d> list) {
        this.f35726a = list;
    }

    public final List<d> b() {
        return this.f35726a;
    }

    public final void b(List<String> list) {
        this.f35727b = list;
    }

    public final List<String> c() {
        return this.f35727b;
    }

    public final void c(List<String> list) {
        this.f35728c = list;
    }

    public final List<String> d() {
        return this.f35728c;
    }

    public final String toString() {
        return "StatusBean{_$101005=" + this.f35726a + ", _$302001=" + this.f35727b + ", _$302002=" + this.f35728c + ", _$302003='" + this.f35729d + "'}";
    }
}
