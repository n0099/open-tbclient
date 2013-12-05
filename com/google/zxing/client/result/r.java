package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class r extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f2854a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(String str, String str2) {
        super(ParsedResultType.PRODUCT);
        this.f2854a = str;
        this.b = str2;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        return this.f2854a;
    }
}
