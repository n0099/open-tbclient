package d.b.c.b.d;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f65738a;

    /* renamed from: b  reason: collision with root package name */
    public final String f65739b;

    public a(String str, String str2) {
        this.f65738a = str;
        this.f65739b = str2;
    }

    public final String a() {
        return this.f65738a;
    }

    public final String b() {
        return this.f65739b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f65738a, aVar.f65738a) && TextUtils.equals(this.f65739b, aVar.f65739b);
    }

    public int hashCode() {
        return (this.f65738a.hashCode() * 31) + this.f65739b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f65738a + ",value=" + this.f65739b + "]";
    }
}
