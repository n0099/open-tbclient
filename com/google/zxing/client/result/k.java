package com.google.zxing.client.result;

import java.util.Map;
/* loaded from: classes.dex */
public final class k extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f2849a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final Map<String, String> o;

    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(ParsedResultType.PRODUCT);
        this.f2849a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = str10;
        this.k = str11;
        this.l = str12;
        this.m = str13;
        this.n = str14;
        this.o = map;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            return a(this.b, kVar.b) && a(this.c, kVar.c) && a(this.d, kVar.d) && a(this.e, kVar.e) && a(this.g, kVar.g) && a(this.h, kVar.h) && a(this.i, kVar.i) && a(this.j, kVar.j) && a(this.k, kVar.k) && a(this.l, kVar.l) && a(this.m, kVar.m) && a(this.n, kVar.n) && a(this.o, kVar.o);
        }
        return false;
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public int hashCode() {
        return ((((((((((((0 ^ a(this.b)) ^ a(this.c)) ^ a(this.d)) ^ a(this.e)) ^ a(this.g)) ^ a(this.h)) ^ a(this.i)) ^ a(this.j)) ^ a(this.k)) ^ a(this.l)) ^ a(this.m)) ^ a(this.n)) ^ a(this.o);
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        return String.valueOf(this.f2849a);
    }
}
