package com.vivo.push.model;
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f4684a;
    private String b;

    public a(String str, String str2) {
        this.f4684a = str;
        this.b = str2;
    }

    public final String a() {
        return this.f4684a;
    }

    public final String b() {
        return this.b;
    }

    public final int hashCode() {
        return (this.f4684a == null ? 0 : this.f4684a.hashCode()) + 31;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            return this.f4684a == null ? aVar.f4684a == null : this.f4684a.equals(aVar.f4684a);
        }
        return false;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f4684a + "', mValue='" + this.b + "'}";
    }
}
