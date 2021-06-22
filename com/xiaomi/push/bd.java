package com.xiaomi.push;
/* loaded from: classes7.dex */
public class bd implements bf {

    /* renamed from: a  reason: collision with root package name */
    public final String f41131a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41132b;

    public bd(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f41131a = str;
        this.f41132b = str2;
    }

    @Override // com.xiaomi.push.bf
    public String a() {
        return this.f41131a;
    }

    @Override // com.xiaomi.push.bf
    public String b() {
        return this.f41132b;
    }
}
