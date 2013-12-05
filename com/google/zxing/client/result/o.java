package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class o extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f2852a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(String str) {
        super(ParsedResultType.ISBN);
        this.f2852a = str;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        return this.f2852a;
    }
}
