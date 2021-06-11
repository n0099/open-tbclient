package d.b.c.b.d;

import android.text.TextUtils;
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f69469a;

    /* renamed from: b  reason: collision with root package name */
    public final String f69470b;

    public a(String str, String str2) {
        this.f69469a = str;
        this.f69470b = str2;
    }

    public final String a() {
        return this.f69469a;
    }

    public final String b() {
        return this.f69470b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f69469a, aVar.f69469a) && TextUtils.equals(this.f69470b, aVar.f69470b);
    }

    public int hashCode() {
        return (this.f69469a.hashCode() * 31) + this.f69470b.hashCode();
    }

    public String toString() {
        return "Header[name=" + this.f69469a + ",value=" + this.f69470b + "]";
    }
}
