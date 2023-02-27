package com.xiaomi.push;
/* loaded from: classes8.dex */
public class bf implements bh {
    public final String a;
    public final String b;

    public bf(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.bh
    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.bh
    public String b() {
        return this.b;
    }
}
