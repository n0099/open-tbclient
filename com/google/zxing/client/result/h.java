package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class h extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f2847a;
    private final String b;
    private final String c;
    private final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str, String str2, String str3, String str4) {
        super(ParsedResultType.EMAIL_ADDRESS);
        this.f2847a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        a(this.f2847a, sb);
        a(this.b, sb);
        a(this.c, sb);
        return sb.toString();
    }
}
