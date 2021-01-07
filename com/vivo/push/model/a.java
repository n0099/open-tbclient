package com.vivo.push.model;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f13955a;

    /* renamed from: b  reason: collision with root package name */
    private String f13956b;

    public a(String str, String str2) {
        this.f13955a = str;
        this.f13956b = str2;
    }

    public final String a() {
        return this.f13955a;
    }

    public final String b() {
        return this.f13956b;
    }

    public final int hashCode() {
        return (this.f13955a == null ? 0 : this.f13955a.hashCode()) + 31;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            return this.f13955a == null ? aVar.f13955a == null : this.f13955a.equals(aVar.f13955a);
        }
        return false;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f13955a + "', mValue='" + this.f13956b + "'}";
    }
}
