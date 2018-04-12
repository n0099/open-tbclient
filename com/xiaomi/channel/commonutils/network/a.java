package com.xiaomi.channel.commonutils.network;
/* loaded from: classes3.dex */
public class a implements c {
    private final String a;
    private final String b;

    public a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.channel.commonutils.network.c
    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.channel.commonutils.network.c
    public String b() {
        return this.b;
    }
}
