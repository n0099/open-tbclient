package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes7.dex */
public class fm implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f38420a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static final String f38421b = ae.f38121a;

    /* renamed from: c  reason: collision with root package name */
    public static String f38422c = null;

    /* renamed from: a  reason: collision with other field name */
    public int f403a;

    /* renamed from: a  reason: collision with other field name */
    public fp f404a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f405a = fl.f388a;

    /* renamed from: b  reason: collision with other field name */
    public boolean f406b = true;

    /* renamed from: d  reason: collision with root package name */
    public String f38423d;

    /* renamed from: e  reason: collision with root package name */
    public String f38424e;

    /* renamed from: f  reason: collision with root package name */
    public String f38425f;

    public fm(Map<String, Integer> map, int i2, String str, fp fpVar) {
        a(map, i2, str, fpVar);
    }

    public static final String a() {
        String str = f38422c;
        return str != null ? str : ab.m127a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? f38421b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        f38422c = str;
    }

    private void a(Map<String, Integer> map, int i2, String str, fp fpVar) {
        this.f403a = i2;
        this.f38423d = str;
        this.f404a = fpVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo316a() {
        return this.f403a;
    }

    public void a(boolean z) {
        this.f405a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m317a() {
        return this.f405a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m318a() {
        return null;
    }

    public String b() {
        return this.f38425f;
    }

    public void b(String str) {
        this.f38425f = str;
    }

    public String c() {
        if (this.f38424e == null) {
            this.f38424e = a();
        }
        return this.f38424e;
    }

    public void c(String str) {
        this.f38424e = str;
    }
}
