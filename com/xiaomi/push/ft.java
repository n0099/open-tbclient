package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes8.dex */
public class ft implements Cloneable {
    public static String a = "wcc-ml-test10.bj";
    public static final String b = ae.a;
    public static String c = null;

    /* renamed from: a  reason: collision with other field name */
    private int f378a;

    /* renamed from: a  reason: collision with other field name */
    private fw f379a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f380a = fs.f363a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f381b = true;
    private String d;
    private String e;
    private String f;

    public ft(Map<String, Integer> map, int i, String str, fw fwVar) {
        a(map, i, str, fwVar);
    }

    public static final String a() {
        return c != null ? c : ab.m119a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fw fwVar) {
        this.f378a = i;
        this.d = str;
        this.f379a = fwVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo295a() {
        return this.f378a;
    }

    public void a(boolean z) {
        this.f380a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m296a() {
        return this.f380a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m297a() {
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
