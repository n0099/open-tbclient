package com.vivo.push.model;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f36643a;

    /* renamed from: b  reason: collision with root package name */
    public String f36644b;

    public a(String str, String str2) {
        this.f36643a = str;
        this.f36644b = str2;
    }

    public final String a() {
        return this.f36643a;
    }

    public final String b() {
        return this.f36644b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.f36643a;
            if (str == null) {
                if (aVar.f36643a != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f36643a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f36643a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f36643a + "', mValue='" + this.f36644b + "'}";
    }
}
