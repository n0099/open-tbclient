package d.c.c.b.d;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f65670a;

    /* renamed from: b  reason: collision with root package name */
    public final String f65671b;

    public a(String str, String str2) {
        this.f65670a = str;
        this.f65671b = str2;
    }

    public final String a() {
        return this.f65670a;
    }

    public final String b() {
        return this.f65671b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f65670a, aVar.f65670a) && TextUtils.equals(this.f65671b, aVar.f65671b);
    }

    public int hashCode() {
        return (this.f65670a.hashCode() * 31) + this.f65671b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f65670a + ",value=" + this.f65671b + "]";
    }
}
