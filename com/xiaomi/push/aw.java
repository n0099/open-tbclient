package com.xiaomi.push;
/* loaded from: classes6.dex */
public class aw implements ay {

    /* renamed from: a  reason: collision with root package name */
    private final String f14165a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14166b;

    public aw(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f14165a = str;
        this.f14166b = str2;
    }

    @Override // com.xiaomi.push.ay
    public String a() {
        return this.f14165a;
    }

    @Override // com.xiaomi.push.ay
    public String b() {
        return this.f14166b;
    }
}
