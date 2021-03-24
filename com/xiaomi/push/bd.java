package com.xiaomi.push;
/* loaded from: classes7.dex */
public class bd implements bf {

    /* renamed from: a  reason: collision with root package name */
    public final String f40274a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40275b;

    public bd(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f40274a = str;
        this.f40275b = str2;
    }

    @Override // com.xiaomi.push.bf
    public String a() {
        return this.f40274a;
    }

    @Override // com.xiaomi.push.bf
    public String b() {
        return this.f40275b;
    }
}
