package com.xiaomi.push;
/* loaded from: classes9.dex */
public class aw implements ay {
    private final String a;
    private final String b;

    public aw(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.ay
    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.ay
    public String b() {
        return this.b;
    }
}
