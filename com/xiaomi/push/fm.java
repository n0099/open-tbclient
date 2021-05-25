package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes7.dex */
public class fm implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f37594a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static final String f37595b = ae.f37295a;

    /* renamed from: c  reason: collision with root package name */
    public static String f37596c = null;

    /* renamed from: a  reason: collision with other field name */
    public int f403a;

    /* renamed from: a  reason: collision with other field name */
    public fp f404a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f405a = fl.f388a;

    /* renamed from: b  reason: collision with other field name */
    public boolean f406b = true;

    /* renamed from: d  reason: collision with root package name */
    public String f37597d;

    /* renamed from: e  reason: collision with root package name */
    public String f37598e;

    /* renamed from: f  reason: collision with root package name */
    public String f37599f;

    public fm(Map<String, Integer> map, int i2, String str, fp fpVar) {
        a(map, i2, str, fpVar);
    }

    public static final String a() {
        String str = f37596c;
        return str != null ? str : ab.m126a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? f37595b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        f37596c = str;
    }

    private void a(Map<String, Integer> map, int i2, String str, fp fpVar) {
        this.f403a = i2;
        this.f37597d = str;
        this.f404a = fpVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo315a() {
        return this.f403a;
    }

    public void a(boolean z) {
        this.f405a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m316a() {
        return this.f405a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m317a() {
        return null;
    }

    public String b() {
        return this.f37599f;
    }

    public void b(String str) {
        this.f37599f = str;
    }

    public String c() {
        if (this.f37598e == null) {
            this.f37598e = a();
        }
        return this.f37598e;
    }

    public void c(String str) {
        this.f37598e = str;
    }
}
