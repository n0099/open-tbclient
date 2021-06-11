package com.vivo.push.model;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f40322a;

    /* renamed from: b  reason: collision with root package name */
    public String f40323b;

    public a(String str, String str2) {
        this.f40322a = str;
        this.f40323b = str2;
    }

    public final String a() {
        return this.f40322a;
    }

    public final String b() {
        return this.f40323b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.f40322a;
            if (str == null) {
                if (aVar.f40322a != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f40322a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f40322a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f40322a + "', mValue='" + this.f40323b + "'}";
    }
}
