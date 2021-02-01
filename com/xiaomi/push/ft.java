package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes6.dex */
public class ft implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f14032a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static final String f14033b = ae.f13851a;
    public static String c = null;

    /* renamed from: a  reason: collision with other field name */
    private int f452a;

    /* renamed from: a  reason: collision with other field name */
    private fw f453a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f454a = fs.f437a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f455b = true;
    private String d;
    private String e;
    private String f;

    public ft(Map<String, Integer> map, int i, String str, fw fwVar) {
        a(map, i, str, fwVar);
    }

    public static final String a() {
        return c != null ? c : ab.m151a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? f14033b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fw fwVar) {
        this.f452a = i;
        this.d = str;
        this.f453a = fwVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo327a() {
        return this.f452a;
    }

    public void a(boolean z) {
        this.f454a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m328a() {
        return this.f454a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m329a() {
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
