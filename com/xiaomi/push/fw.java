package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes10.dex */
public class fw implements Cloneable {
    public static String a = "wcc-ml-test10.bj";
    public static final String b = af.a;
    public static String c = null;

    /* renamed from: a  reason: collision with other field name */
    public int f417a;

    /* renamed from: a  reason: collision with other field name */
    public fz f418a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f419a = fv.f402a;

    /* renamed from: b  reason: collision with other field name */
    public boolean f420b = true;
    public String d;
    public String e;
    public String f;

    public fw(Map<String, Integer> map, int i, String str, fz fzVar) {
        a(map, i, str, fzVar);
    }

    public static final String a() {
        String str = c;
        return str != null ? str : ab.m265a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        if (j.m721a(s.m732a()) && ab.b()) {
            return;
        }
        c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fz fzVar) {
        this.f417a = i;
        this.d = str;
        this.f418a = fzVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m520a() {
        return this.f417a;
    }

    public void a(boolean z) {
        this.f419a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m521a() {
        return this.f419a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] mo522a() {
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
