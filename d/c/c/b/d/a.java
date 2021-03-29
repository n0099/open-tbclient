package d.c.c.b.d;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f65671a;

    /* renamed from: b  reason: collision with root package name */
    public final String f65672b;

    public a(String str, String str2) {
        this.f65671a = str;
        this.f65672b = str2;
    }

    public final String a() {
        return this.f65671a;
    }

    public final String b() {
        return this.f65672b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f65671a, aVar.f65671a) && TextUtils.equals(this.f65672b, aVar.f65672b);
    }

    public int hashCode() {
        return (this.f65671a.hashCode() * 31) + this.f65672b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f65671a + ",value=" + this.f65672b + "]";
    }
}
