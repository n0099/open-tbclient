package d.a.m0.n.h;

import android.text.TextUtils;
import java.util.Objects;
/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: g  reason: collision with root package name */
    public String f51794g;

    /* renamed from: h  reason: collision with root package name */
    public int f51795h;

    /* renamed from: i  reason: collision with root package name */
    public long f51796i;
    public String j;
    public long k;
    public String l;
    public String m;
    public String n;

    public boolean a() {
        return (TextUtils.isEmpty(this.f51794g) || this.f51796i <= 0 || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.n)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj != null && (obj instanceof e)) {
            e eVar = (e) obj;
            return (TextUtils.isEmpty(this.j) && TextUtils.isEmpty(eVar.j)) ? this.f51794g.equals(eVar.f51794g) && this.f51796i == eVar.f51796i : TextUtils.equals(this.f51794g, eVar.f51794g) && this.f51796i == eVar.f51796i && TextUtils.equals(this.j, eVar.j);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f51794g, Integer.valueOf(this.f51795h), Long.valueOf(this.f51796i), this.j);
    }

    public String toString() {
        return "bundleId=" + this.f51794g + ", category=" + this.f51795h + ", versionCode=" + this.f51796i + ", versionName=" + this.j + ", size=" + this.k + ", md5=" + this.l + ", sign=" + this.m + ", downloadUrl=" + this.n;
    }
}
