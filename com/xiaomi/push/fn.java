package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes5.dex */
public class fn implements Cloneable {
    public static String a = "wcc-ml-test10.bj";
    public static final String b = ae.a;
    public static String c = null;

    /* renamed from: a  reason: collision with other field name */
    private int f391a;

    /* renamed from: a  reason: collision with other field name */
    private fq f392a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f393a = fm.f376a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f394b = true;
    private String d;
    private String e;
    private String f;

    public fn(Map<String, Integer> map, int i, String str, fq fqVar) {
        a(map, i, str, fqVar);
    }

    public static final String a() {
        return c != null ? c : ab.m110a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fq fqVar) {
        this.f391a = i;
        this.d = str;
        this.f392a = fqVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo276a() {
        return this.f391a;
    }

    public void a(boolean z) {
        this.f393a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m277a() {
        return this.f393a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m278a() {
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
