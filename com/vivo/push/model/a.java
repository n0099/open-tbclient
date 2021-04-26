package com.vivo.push.model;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f37469a;

    /* renamed from: b  reason: collision with root package name */
    public String f37470b;

    public a(String str, String str2) {
        this.f37469a = str;
        this.f37470b = str2;
    }

    public final String a() {
        return this.f37469a;
    }

    public final String b() {
        return this.f37470b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            String str = this.f37469a;
            if (str == null) {
                if (aVar.f37469a != null) {
                    return false;
                }
            } else if (!str.equals(aVar.f37469a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f37469a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public final String toString() {
        return "ConfigItem{mKey='" + this.f37469a + "', mValue='" + this.f37470b + "'}";
    }
}
