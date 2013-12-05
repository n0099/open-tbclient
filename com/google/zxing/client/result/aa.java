package com.google.zxing.client.result;
/* loaded from: classes.dex */
public final class aa extends q {

    /* renamed from: a  reason: collision with root package name */
    private final String f2840a;
    private final String b;

    public aa(String str, String str2) {
        super(ParsedResultType.TEXT);
        this.f2840a = str;
        this.b = str2;
    }

    @Override // com.google.zxing.client.result.q
    public String a() {
        return this.f2840a;
    }
}
