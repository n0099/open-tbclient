package d.b.c.b.d;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f65695a;

    /* renamed from: b  reason: collision with root package name */
    public final String f65696b;

    public a(String str, String str2) {
        this.f65695a = str;
        this.f65696b = str2;
    }

    public final String a() {
        return this.f65695a;
    }

    public final String b() {
        return this.f65696b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f65695a, aVar.f65695a) && TextUtils.equals(this.f65696b, aVar.f65696b);
    }

    public int hashCode() {
        return (this.f65695a.hashCode() * 31) + this.f65696b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f65695a + ",value=" + this.f65696b + "]";
    }
}
