package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes7.dex */
public class fm implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f41273a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static final String f41274b = ae.f40974a;

    /* renamed from: c  reason: collision with root package name */
    public static String f41275c = null;

    /* renamed from: a  reason: collision with other field name */
    public int f403a;

    /* renamed from: a  reason: collision with other field name */
    public fp f404a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f405a = fl.f388a;

    /* renamed from: b  reason: collision with other field name */
    public boolean f406b = true;

    /* renamed from: d  reason: collision with root package name */
    public String f41276d;

    /* renamed from: e  reason: collision with root package name */
    public String f41277e;

    /* renamed from: f  reason: collision with root package name */
    public String f41278f;

    public fm(Map<String, Integer> map, int i2, String str, fp fpVar) {
        a(map, i2, str, fpVar);
    }

    public static final String a() {
        String str = f41275c;
        return str != null ? str : ab.m125a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? f41274b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        f41275c = str;
    }

    private void a(Map<String, Integer> map, int i2, String str, fp fpVar) {
        this.f403a = i2;
        this.f41276d = str;
        this.f404a = fpVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo314a() {
        return this.f403a;
    }

    public void a(boolean z) {
        this.f405a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m315a() {
        return this.f405a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m316a() {
        return null;
    }

    public String b() {
        return this.f41278f;
    }

    public void b(String str) {
        this.f41278f = str;
    }

    public String c() {
        if (this.f41277e == null) {
            this.f41277e = a();
        }
        return this.f41277e;
    }

    public void c(String str) {
        this.f41277e = str;
    }
}
