package com.vivo.push.model;
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f8059a;
    private String b;

    public a(String str, String str2) {
        this.f8059a = str;
        this.b = str2;
    }

    public final String a() {
        return this.f8059a;
    }

    public final String b() {
        return this.b;
    }

    public final int hashCode() {
        return (this.f8059a == null ? 0 : this.f8059a.hashCode()) + 31;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            return this.f8059a == null ? aVar.f8059a == null : this.f8059a.equals(aVar.f8059a);
        }
        return false;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f8059a + "', mValue='" + this.b + "'}";
    }
}
