package com.xiaomi.push;
/* loaded from: classes7.dex */
public class bd implements bf {

    /* renamed from: a  reason: collision with root package name */
    public final String f37420a;

    /* renamed from: b  reason: collision with root package name */
    public final String f37421b;

    public bd(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f37420a = str;
        this.f37421b = str2;
    }

    @Override // com.xiaomi.push.bf
    public String a() {
        return this.f37420a;
    }

    @Override // com.xiaomi.push.bf
    public String b() {
        return this.f37421b;
    }
}
