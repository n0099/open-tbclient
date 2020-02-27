package com.xiaomi.push;
/* loaded from: classes8.dex */
public class ap implements ar {
    private final String a;
    private final String b;

    public ap(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.ar
    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.ar
    public String b() {
        return this.b;
    }
}
