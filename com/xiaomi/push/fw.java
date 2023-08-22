package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes10.dex */
public class fw implements Cloneable {
    public static String a = "wcc-ml-test10.bj";
    public static final String b = af.a;
    public static String c = null;

    /* renamed from: a  reason: collision with other field name */
    public int f422a;

    /* renamed from: a  reason: collision with other field name */
    public fz f423a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f424a = fv.f407a;

    /* renamed from: b  reason: collision with other field name */
    public boolean f425b = true;
    public String d;
    public String e;
    public String f;

    public fw(Map<String, Integer> map, int i, String str, fz fzVar) {
        a(map, i, str, fzVar);
    }

    public static final String a() {
        String str = c;
        return str != null ? str : ab.m255a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        if (j.m711a(s.m722a()) && ab.b()) {
            return;
        }
        c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fz fzVar) {
        this.f422a = i;
        this.d = str;
        this.f423a = fzVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m510a() {
        return this.f422a;
    }

    public void a(boolean z) {
        this.f424a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m511a() {
        return this.f424a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] mo512a() {
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
