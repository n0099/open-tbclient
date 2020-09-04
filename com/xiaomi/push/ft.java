package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes7.dex */
public class ft implements Cloneable {
    public static String a = "wcc-ml-test10.bj";
    public static final String b = ae.a;
    public static String c = null;

    /* renamed from: a  reason: collision with other field name */
    private int f374a;

    /* renamed from: a  reason: collision with other field name */
    private fw f375a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f376a = fs.f359a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f377b = true;
    private String d;
    private String e;
    private String f;

    public ft(Map<String, Integer> map, int i, String str, fw fwVar) {
        a(map, i, str, fwVar);
    }

    public static final String a() {
        return c != null ? c : ab.m125a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fw fwVar) {
        this.f374a = i;
        this.d = str;
        this.f375a = fwVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo301a() {
        return this.f374a;
    }

    public void a(boolean z) {
        this.f376a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m302a() {
        return this.f376a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m303a() {
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
