package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes7.dex */
public class fm implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f40513a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static final String f40514b = ae.f40221a;

    /* renamed from: c  reason: collision with root package name */
    public static String f40515c = null;

    /* renamed from: a  reason: collision with other field name */
    public int f403a;

    /* renamed from: a  reason: collision with other field name */
    public fp f404a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f405a = fl.f388a;

    /* renamed from: b  reason: collision with other field name */
    public boolean f406b = true;

    /* renamed from: d  reason: collision with root package name */
    public String f40516d;

    /* renamed from: e  reason: collision with root package name */
    public String f40517e;

    /* renamed from: f  reason: collision with root package name */
    public String f40518f;

    public fm(Map<String, Integer> map, int i, String str, fp fpVar) {
        a(map, i, str, fpVar);
    }

    public static final String a() {
        String str = f40515c;
        return str != null ? str : ab.m120a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? f40514b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        f40515c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fp fpVar) {
        this.f403a = i;
        this.f40516d = str;
        this.f404a = fpVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo309a() {
        return this.f403a;
    }

    public void a(boolean z) {
        this.f405a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m310a() {
        return this.f405a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m311a() {
        return null;
    }

    public String b() {
        return this.f40518f;
    }

    public void b(String str) {
        this.f40518f = str;
    }

    public String c() {
        if (this.f40517e == null) {
            this.f40517e = a();
        }
        return this.f40517e;
    }

    public void c(String str) {
        this.f40517e = str;
    }
}
