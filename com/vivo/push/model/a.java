package com.vivo.push.model;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f39866a;

    /* renamed from: b  reason: collision with root package name */
    public String f39867b;

    public a(String str, String str2) {
        this.f39866a = str;
        this.f39867b = str2;
    }

    public final String a() {
        return this.f39866a;
    }

    public final String b() {
        return this.f39867b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.f39866a;
            if (str == null) {
                if (aVar.f39866a != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f39866a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f39866a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f39866a + "', mValue='" + this.f39867b + "'}";
    }
}
