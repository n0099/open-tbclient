package com.vivo.push.model;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f36714a;

    /* renamed from: b  reason: collision with root package name */
    public String f36715b;

    public a(String str, String str2) {
        this.f36714a = str;
        this.f36715b = str2;
    }

    public final String a() {
        return this.f36714a;
    }

    public final String b() {
        return this.f36715b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.f36714a;
            if (str == null) {
                if (aVar.f36714a != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f36714a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f36714a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f36714a + "', mValue='" + this.f36715b + "'}";
    }
}
