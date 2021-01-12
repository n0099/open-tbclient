package com.xiaomi.push;
/* loaded from: classes6.dex */
public class aw implements ay {

    /* renamed from: a  reason: collision with root package name */
    private final String f13866a;

    /* renamed from: b  reason: collision with root package name */
    private final String f13867b;

    public aw(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f13866a = str;
        this.f13867b = str2;
    }

    @Override // com.xiaomi.push.ay
    public String a() {
        return this.f13866a;
    }

    @Override // com.xiaomi.push.ay
    public String b() {
        return this.f13867b;
    }
}
