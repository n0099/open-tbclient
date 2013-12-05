package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class ag extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f2844a;
    private final String b;
    private final String c;
    private final boolean d;

    public ag(String str, String str2, String str3, boolean z) {
        super(ParsedResultType.WIFI);
        this.f2844a = str2;
        this.b = str;
        this.c = str3;
        this.d = z;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(80);
        a(this.f2844a, sb);
        a(this.b, sb);
        a(this.c, sb);
        a(Boolean.toString(this.d), sb);
        return sb.toString();
    }
}
