package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes18.dex */
public class ft implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f4913a = "wcc-ml-test10.bj";
    public static final String b = ae.f4787a;
    public static String c = null;

    /* renamed from: a  reason: collision with other field name */
    private int f376a;

    /* renamed from: a  reason: collision with other field name */
    private fw f377a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f378a = fs.f361a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f379b = true;
    private String d;
    private String e;
    private String f;

    public ft(Map<String, Integer> map, int i, String str, fw fwVar) {
        a(map, i, str, fwVar);
    }

    public static final String a() {
        return c != null ? c : ab.m128a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fw fwVar) {
        this.f376a = i;
        this.d = str;
        this.f377a = fwVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo304a() {
        return this.f376a;
    }

    public void a(boolean z) {
        this.f378a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m305a() {
        return this.f378a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m306a() {
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
