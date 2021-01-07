package com.xiaomi.push;

import java.util.Map;
/* loaded from: classes6.dex */
public class ft implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public static String f14330a = "wcc-ml-test10.bj";

    /* renamed from: b  reason: collision with root package name */
    public static final String f14331b = ae.f14149a;
    public static String c = null;

    /* renamed from: a  reason: collision with other field name */
    private int f453a;

    /* renamed from: a  reason: collision with other field name */
    private fw f454a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f455a = fs.f438a;

    /* renamed from: b  reason: collision with other field name */
    private boolean f456b = true;
    private String d;
    private String e;
    private String f;

    public ft(Map<String, Integer> map, int i, String str, fw fwVar) {
        a(map, i, str, fwVar);
    }

    public static final String a() {
        return c != null ? c : ab.m155a() ? "sandbox.xmpush.xiaomi.com" : ab.b() ? f14331b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        c = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fw fwVar) {
        this.f453a = i;
        this.d = str;
        this.f454a = fwVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public int mo331a() {
        return this.f453a;
    }

    public void a(boolean z) {
        this.f455a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m332a() {
        return this.f455a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m333a() {
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
