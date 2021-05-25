package d.a.l0.n.h;

import android.text.TextUtils;
import java.util.Objects;
/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: g  reason: collision with root package name */
    public String f48012g;

    /* renamed from: h  reason: collision with root package name */
    public int f48013h;

    /* renamed from: i  reason: collision with root package name */
    public long f48014i;
    public String j;
    public long k;
    public String l;
    public String m;
    public String n;

    public boolean a() {
        return (TextUtils.isEmpty(this.f48012g) || this.f48014i <= 0 || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.n)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj != null && (obj instanceof e)) {
            e eVar = (e) obj;
            return (TextUtils.isEmpty(this.j) && TextUtils.isEmpty(eVar.j)) ? this.f48012g.equals(eVar.f48012g) && this.f48014i == eVar.f48014i : TextUtils.equals(this.f48012g, eVar.f48012g) && this.f48014i == eVar.f48014i && TextUtils.equals(this.j, eVar.j);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f48012g, Integer.valueOf(this.f48013h), Long.valueOf(this.f48014i), this.j);
    }

    public String toString() {
        return "bundleId=" + this.f48012g + ", category=" + this.f48013h + ", versionCode=" + this.f48014i + ", versionName=" + this.j + ", size=" + this.k + ", md5=" + this.l + ", sign=" + this.m + ", downloadUrl=" + this.n;
    }
}
