package com.xiaomi.smack;

import java.util.Map;
/* loaded from: classes3.dex */
public class b implements Cloneable {
    public static String b = "wcc-ml-test10.bj";
    public static final String c = com.xiaomi.channel.commonutils.misc.c.b;
    public static String d = null;
    private String a;
    private String e;
    private int f;
    private boolean g = a.a;
    private boolean h = true;
    private String i;
    private e j;

    public b(Map<String, Integer> map, int i, String str, e eVar) {
        a(map, i, str, eVar);
    }

    private void a(Map<String, Integer> map, int i, String str, e eVar) {
        this.e = b();
        this.f = i;
        this.a = str;
        this.j = eVar;
    }

    public static final String b() {
        return d != null ? d : com.xiaomi.channel.commonutils.misc.a.a() ? "sandbox.xmpush.xiaomi.com" : com.xiaomi.channel.commonutils.misc.a.b() ? c : "app.chat.xiaomi.net";
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public byte[] a() {
        return null;
    }

    public void b(String str) {
        this.e = str;
    }

    public String c() {
        return this.i;
    }

    public int d() {
        return this.f;
    }

    public String e() {
        return this.e;
    }

    public boolean f() {
        return this.g;
    }
}
