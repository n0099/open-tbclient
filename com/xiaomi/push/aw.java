package com.xiaomi.push;
/* loaded from: classes12.dex */
public class aw implements ay {

    /* renamed from: a  reason: collision with root package name */
    private final String f4799a;
    private final String b;

    public aw(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f4799a = str;
        this.b = str2;
    }

    @Override // com.xiaomi.push.ay
    public String a() {
        return this.f4799a;
    }

    @Override // com.xiaomi.push.ay
    public String b() {
        return this.b;
    }
}
