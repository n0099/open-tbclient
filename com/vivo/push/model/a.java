package com.vivo.push.model;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f13954a;

    /* renamed from: b  reason: collision with root package name */
    private String f13955b;

    public a(String str, String str2) {
        this.f13954a = str;
        this.f13955b = str2;
    }

    public final String a() {
        return this.f13954a;
    }

    public final String b() {
        return this.f13955b;
    }

    public final int hashCode() {
        return (this.f13954a == null ? 0 : this.f13954a.hashCode()) + 31;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            return this.f13954a == null ? aVar.f13954a == null : this.f13954a.equals(aVar.f13954a);
        }
        return false;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f13954a + "', mValue='" + this.f13955b + "'}";
    }
}
