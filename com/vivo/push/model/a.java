package com.vivo.push.model;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f39481a;

    /* renamed from: b  reason: collision with root package name */
    public String f39482b;

    public a(String str, String str2) {
        this.f39481a = str;
        this.f39482b = str2;
    }

    public final String a() {
        return this.f39481a;
    }

    public final String b() {
        return this.f39482b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.f39481a;
            if (str == null) {
                if (aVar.f39481a != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f39481a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f39481a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f39481a + "', mValue='" + this.f39482b + "'}";
    }
}
