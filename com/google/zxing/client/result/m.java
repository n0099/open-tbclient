package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class m extends q {

    /* renamed from: a  reason: collision with root package name */
    private final double f2850a;
    private final double b;
    private final double c;
    private final String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(double d, double d2, double d3, String str) {
        super(ParsedResultType.GEO);
        this.f2850a = d;
        this.b = d2;
        this.c = d3;
        this.d = str;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.f2850a);
        sb.append(", ");
        sb.append(this.b);
        if (this.c > 0.0d) {
            sb.append(", ");
            sb.append(this.c);
            sb.append('m');
        }
        if (this.d != null) {
            sb.append(" (");
            sb.append(this.d);
            sb.append(')');
        }
        return sb.toString();
    }
}
