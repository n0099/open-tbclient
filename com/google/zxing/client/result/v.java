package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class v extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f2856a;
    private final String[] b;
    private final String c;
    private final String d;

    public v(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.f2856a = new String[]{str};
        this.b = new String[]{str2};
        this.c = str3;
        this.d = str4;
    }

    public v(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.f2856a = strArr;
        this.b = strArr2;
        this.c = str;
        this.d = str2;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        a(this.f2856a, sb);
        a(this.c, sb);
        a(this.d, sb);
        return sb.toString();
    }
}
