package d.b.g0.l.k;

import android.text.TextUtils;
import java.util.Objects;
/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: g  reason: collision with root package name */
    public String f49315g;

    /* renamed from: h  reason: collision with root package name */
    public int f49316h;
    public long i;
    public String j;
    public long k;
    public String l;
    public String m;
    public String n;

    public boolean a() {
        return (TextUtils.isEmpty(this.f49315g) || this.i <= 0 || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.n)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj != null && (obj instanceof e)) {
            e eVar = (e) obj;
            return (TextUtils.isEmpty(this.j) && TextUtils.isEmpty(eVar.j)) ? this.f49315g.equals(eVar.f49315g) && this.i == eVar.i : TextUtils.equals(this.f49315g, eVar.f49315g) && this.i == eVar.i && TextUtils.equals(this.j, eVar.j);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f49315g, Integer.valueOf(this.f49316h), Long.valueOf(this.i), this.j);
    }

    public String toString() {
        return "bundleId=" + this.f49315g + ", category=" + this.f49316h + ", versionCode=" + this.i + ", versionName=" + this.j + ", size=" + this.k + ", md5=" + this.l + ", sign=" + this.m + ", downloadUrl=" + this.n;
    }
}
