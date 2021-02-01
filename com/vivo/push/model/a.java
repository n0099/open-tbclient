package com.vivo.push.model;
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private String f13657a;

    /* renamed from: b  reason: collision with root package name */
    private String f13658b;

    public a(String str, String str2) {
        this.f13657a = str;
        this.f13658b = str2;
    }

    public final String a() {
        return this.f13657a;
    }

    public final String b() {
        return this.f13658b;
    }

    public final int hashCode() {
        return (this.f13657a == null ? 0 : this.f13657a.hashCode()) + 31;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            return this.f13657a == null ? aVar.f13657a == null : this.f13657a.equals(aVar.f13657a);
        }
        return false;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f13657a + "', mValue='" + this.f13658b + "'}";
    }
}
