package d.a.h0.l.k;

import android.text.TextUtils;
import java.util.Objects;
/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: g  reason: collision with root package name */
    public String f47153g;

    /* renamed from: h  reason: collision with root package name */
    public int f47154h;

    /* renamed from: i  reason: collision with root package name */
    public long f47155i;
    public String j;
    public long k;
    public String l;
    public String m;
    public String n;

    public boolean a() {
        return (TextUtils.isEmpty(this.f47153g) || this.f47155i <= 0 || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.n)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj != null && (obj instanceof e)) {
            e eVar = (e) obj;
            return (TextUtils.isEmpty(this.j) && TextUtils.isEmpty(eVar.j)) ? this.f47153g.equals(eVar.f47153g) && this.f47155i == eVar.f47155i : TextUtils.equals(this.f47153g, eVar.f47153g) && this.f47155i == eVar.f47155i && TextUtils.equals(this.j, eVar.j);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f47153g, Integer.valueOf(this.f47154h), Long.valueOf(this.f47155i), this.j);
    }

    public String toString() {
        return "bundleId=" + this.f47153g + ", category=" + this.f47154h + ", versionCode=" + this.f47155i + ", versionName=" + this.j + ", size=" + this.k + ", md5=" + this.l + ", sign=" + this.m + ", downloadUrl=" + this.n;
    }
}
