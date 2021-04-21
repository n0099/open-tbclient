package com.xiaomi.push;
/* loaded from: classes7.dex */
public class bd implements bf {

    /* renamed from: a  reason: collision with root package name */
    public final String f40659a;

    /* renamed from: b  reason: collision with root package name */
    public final String f40660b;

    public bd(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f40659a = str;
        this.f40660b = str2;
    }

    @Override // com.xiaomi.push.bf
    public String a() {
        return this.f40659a;
    }

    @Override // com.xiaomi.push.bf
    public String b() {
        return this.f40660b;
    }
}
