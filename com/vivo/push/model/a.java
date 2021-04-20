package com.vivo.push.model;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f39771a;

    /* renamed from: b  reason: collision with root package name */
    public String f39772b;

    public a(String str, String str2) {
        this.f39771a = str;
        this.f39772b = str2;
    }

    public final String a() {
        return this.f39771a;
    }

    public final String b() {
        return this.f39772b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.f39771a;
            if (str == null) {
                if (aVar.f39771a != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f39771a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f39771a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f39771a + "', mValue='" + this.f39772b + "'}";
    }
}
