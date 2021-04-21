package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes7.dex */
public class fm implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f40898a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static final String f40899b = ae.f40606a;

    /* renamed from: c  reason: collision with root package name */
    public static String f40900c = null;

    /* renamed from: a  reason: collision with other field name */
    public int f403a;

    /* renamed from: a  reason: collision with other field name */
    public fp f404a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f405a = fl.f388a;

    /* renamed from: b  reason: collision with other field name */
    public boolean f406b = true;

    /* renamed from: d  reason: collision with root package name */
    public String f40901d;

    /* renamed from: e  reason: collision with root package name */
    public String f40902e;

    /* renamed from: f  reason: collision with root package name */
    public String f40903f;

    public fm(Map<String, Integer> map, int i, String str, fp fpVar) {
        a(map, i, str, fpVar);
    }

    public static final String a() {
        String str = f40900c;
        return str != null ? str : ab.m124a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? f40899b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        f40900c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fp fpVar) {
        this.f403a = i;
        this.f40901d = str;
        this.f404a = fpVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo313a() {
        return this.f403a;
    }

    public void a(boolean z) {
        this.f405a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m314a() {
        return this.f405a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m315a() {
        return null;
    }

    public String b() {
        return this.f40903f;
    }

    public void b(String str) {
        this.f40903f = str;
    }

    public String c() {
        if (this.f40902e == null) {
            this.f40902e = a();
        }
        return this.f40902e;
    }

    public void c(String str) {
        this.f40902e = str;
    }
}
