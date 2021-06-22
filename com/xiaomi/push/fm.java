package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes7.dex */
public class fm implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f41376a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static final String f41377b = ae.f41077a;

    /* renamed from: c  reason: collision with root package name */
    public static String f41378c = null;

    /* renamed from: a  reason: collision with other field name */
    public int f403a;

    /* renamed from: a  reason: collision with other field name */
    public fp f404a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f405a = fl.f388a;

    /* renamed from: b  reason: collision with other field name */
    public boolean f406b = true;

    /* renamed from: d  reason: collision with root package name */
    public String f41379d;

    /* renamed from: e  reason: collision with root package name */
    public String f41380e;

    /* renamed from: f  reason: collision with root package name */
    public String f41381f;

    public fm(Map<String, Integer> map, int i2, String str, fp fpVar) {
        a(map, i2, str, fpVar);
    }

    public static final String a() {
        String str = f41378c;
        return str != null ? str : ab.m125a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? f41377b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        f41378c = str;
    }

    private void a(Map<String, Integer> map, int i2, String str, fp fpVar) {
        this.f403a = i2;
        this.f41379d = str;
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
        return this.f41381f;
    }

    public void b(String str) {
        this.f41381f = str;
    }

    public String c() {
        if (this.f41380e == null) {
            this.f41380e = a();
        }
        return this.f41380e;
    }

    public void c(String str) {
        this.f41380e = str;
    }
}
