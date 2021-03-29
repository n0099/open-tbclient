package com.xiaomi.push;
/* loaded from: classes7.dex */
public class bd implements bf {

    /* renamed from: a  reason: collision with root package name */
    public final String f40275a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40276b;

    public bd(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f40275a = str;
        this.f40276b = str2;
    }

    @Override // com.xiaomi.push.bf
    public String a() {
        return this.f40275a;
    }

    @Override // com.xiaomi.push.bf
    public String b() {
        return this.f40276b;
    }
}
