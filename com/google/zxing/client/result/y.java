package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class y extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f2857a;
    private final String b;
    private final String c;

    public y(String str, String str2, String str3) {
        super(ParsedResultType.TEL);
        this.f2857a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        a(this.f2857a, sb);
        a(this.c, sb);
        return sb.toString();
    }
}
