package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes6.dex */
public class fn implements Cloneable {
    public static String a = "wcc-ml-test10.bj";
    public static final String b = ae.a;
    public static String c = null;

    /* renamed from: a  reason: collision with other field name */
    private int f389a;

    /* renamed from: a  reason: collision with other field name */
    private fq f390a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f391a = fm.f374a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f392b = true;
    private String d;
    private String e;
    private String f;

    public fn(Map<String, Integer> map, int i, String str, fq fqVar) {
        a(map, i, str, fqVar);
    }

    public static final String a() {
        return c != null ? c : ab.m119a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fq fqVar) {
        this.f389a = i;
        this.d = str;
        this.f390a = fqVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo285a() {
        return this.f389a;
    }

    public void a(boolean z) {
        this.f391a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m286a() {
        return this.f391a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m287a() {
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
