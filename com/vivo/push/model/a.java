package com.vivo.push.model;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f13655a;

    /* renamed from: b  reason: collision with root package name */
    private String f13656b;

    public a(String str, String str2) {
        this.f13655a = str;
        this.f13656b = str2;
    }

    public final String a() {
        return this.f13655a;
    }

    public final String b() {
        return this.f13656b;
    }

    public final int hashCode() {
        return (this.f13655a == null ? 0 : this.f13655a.hashCode()) + 31;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            return this.f13655a == null ? aVar.f13655a == null : this.f13655a.equals(aVar.f13655a);
        }
        return false;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f13655a + "', mValue='" + this.f13656b + "'}";
    }
}
