package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes8.dex */
public class fn implements Cloneable {
    public static String a = "wcc-ml-test10.bj";
    public static final String b = ae.a;
    public static String c = null;

    /* renamed from: a  reason: collision with other field name */
    private int f386a;

    /* renamed from: a  reason: collision with other field name */
    private fq f387a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f388a = fm.f371a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f389b = true;
    private String d;
    private String e;
    private String f;

    public fn(Map<String, Integer> map, int i, String str, fq fqVar) {
        a(map, i, str, fqVar);
    }

    public static final String a() {
        return c != null ? c : ab.m122a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fq fqVar) {
        this.f386a = i;
        this.d = str;
        this.f387a = fqVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo288a() {
        return this.f386a;
    }

    public void a(boolean z) {
        this.f388a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m289a() {
        return this.f388a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m290a() {
        return null;
    }

    public String b() {
        return this.f;
    }

    public void b(String str) {
        this.f = str;
    }

    public String c() {
        if (this.e == null) {
            this.e = a();
        }
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }
}
