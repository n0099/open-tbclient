package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes7.dex */
public class fm implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f37665a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static final String f37666b = ae.f37366a;

    /* renamed from: c  reason: collision with root package name */
    public static String f37667c = null;

    /* renamed from: a  reason: collision with other field name */
    public int f403a;

    /* renamed from: a  reason: collision with other field name */
    public fp f404a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f405a = fl.f388a;

    /* renamed from: b  reason: collision with other field name */
    public boolean f406b = true;

    /* renamed from: d  reason: collision with root package name */
    public String f37668d;

    /* renamed from: e  reason: collision with root package name */
    public String f37669e;

    /* renamed from: f  reason: collision with root package name */
    public String f37670f;

    public fm(Map<String, Integer> map, int i2, String str, fp fpVar) {
        a(map, i2, str, fpVar);
    }

    public static final String a() {
        String str = f37667c;
        return str != null ? str : ab.m126a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? f37666b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        f37667c = str;
    }

    private void a(Map<String, Integer> map, int i2, String str, fp fpVar) {
        this.f403a = i2;
        this.f37668d = str;
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
        return this.f37670f;
    }

    public void b(String str) {
        this.f37670f = str;
    }

    public String c() {
        if (this.f37669e == null) {
            this.f37669e = a();
        }
        return this.f37669e;
    }

    public void c(String str) {
        this.f37669e = str;
    }
}
