package d.a.i0.n.h;

import android.text.TextUtils;
import java.util.Objects;
/* loaded from: classes3.dex */
public class e extends c {

    /* renamed from: g  reason: collision with root package name */
    public String f47836g;

    /* renamed from: h  reason: collision with root package name */
    public int f47837h;

    /* renamed from: i  reason: collision with root package name */
    public long f47838i;
    public String j;
    public long k;
    public String l;
    public String m;
    public String n;

    public boolean a() {
        return (TextUtils.isEmpty(this.f47836g) || this.f47838i <= 0 || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.m) || TextUtils.isEmpty(this.n)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        if (obj != null && (obj instanceof e)) {
            e eVar = (e) obj;
            return (TextUtils.isEmpty(this.j) && TextUtils.isEmpty(eVar.j)) ? this.f47836g.equals(eVar.f47836g) && this.f47838i == eVar.f47838i : TextUtils.equals(this.f47836g, eVar.f47836g) && this.f47838i == eVar.f47838i && TextUtils.equals(this.j, eVar.j);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f47836g, Integer.valueOf(this.f47837h), Long.valueOf(this.f47838i), this.j);
    }

    public String toString() {
        return "bundleId=" + this.f47836g + ", category=" + this.f47837h + ", versionCode=" + this.f47838i + ", versionName=" + this.j + ", size=" + this.k + ", md5=" + this.l + ", sign=" + this.m + ", downloadUrl=" + this.n;
    }
}
