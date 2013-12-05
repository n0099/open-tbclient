package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class d extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f2845a;
    private final String[] b;
    private final String c;
    private final String[] d;
    private final String[] e;
    private final String[] f;
    private final String[] g;
    private final String h;
    private final String i;
    private final String[] j;
    private final String[] k;
    private final String l;
    private final String m;
    private final String n;
    private final String[] o;
    private final String[] p;

    public d(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(ParsedResultType.ADDRESSBOOK);
        this.f2845a = strArr;
        this.b = strArr2;
        this.c = str;
        this.d = strArr3;
        this.e = strArr4;
        this.f = strArr5;
        this.g = strArr6;
        this.h = str2;
        this.i = str3;
        this.j = strArr7;
        this.k = strArr8;
        this.l = str4;
        this.m = str5;
        this.n = str6;
        this.o = strArr9;
        this.p = strArr10;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        a(this.f2845a, sb);
        a(this.b, sb);
        a(this.c, sb);
        a(this.n, sb);
        a(this.l, sb);
        a(this.j, sb);
        a(this.d, sb);
        a(this.f, sb);
        a(this.h, sb);
        a(this.o, sb);
        a(this.m, sb);
        a(this.p, sb);
        a(this.i, sb);
        return sb.toString();
    }
}
