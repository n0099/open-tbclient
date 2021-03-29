package com.vivo.push.model;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f39482a;

    /* renamed from: b  reason: collision with root package name */
    public String f39483b;

    public a(String str, String str2) {
        this.f39482a = str;
        this.f39483b = str2;
    }

    public final String a() {
        return this.f39482a;
    }

    public final String b() {
        return this.f39483b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.f39482a;
            if (str == null) {
                if (aVar.f39482a != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f39482a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f39482a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f39482a + "', mValue='" + this.f39483b + "'}";
    }
}
