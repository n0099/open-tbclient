package d.b.c.b.d;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f65009a;

    /* renamed from: b  reason: collision with root package name */
    public final String f65010b;

    public a(String str, String str2) {
        this.f65009a = str;
        this.f65010b = str2;
    }

    public final String a() {
        return this.f65009a;
    }

    public final String b() {
        return this.f65010b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f65009a, aVar.f65009a) && TextUtils.equals(this.f65010b, aVar.f65010b);
    }

    public int hashCode() {
        return (this.f65009a.hashCode() * 31) + this.f65010b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f65009a + ",value=" + this.f65010b + "]";
    }
}
