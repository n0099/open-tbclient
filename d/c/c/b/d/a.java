package d.c.c.b.d;

import android.text.TextUtils;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f66611a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66612b;

    public a(String str, String str2) {
        this.f66611a = str;
        this.f66612b = str2;
    }

    public final String a() {
        return this.f66611a;
    }

    public final String b() {
        return this.f66612b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f66611a, aVar.f66611a) && TextUtils.equals(this.f66612b, aVar.f66612b);
    }

    public int hashCode() {
        return (this.f66611a.hashCode() * 31) + this.f66612b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f66611a + ",value=" + this.f66612b + "]";
    }
}
