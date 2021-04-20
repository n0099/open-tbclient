package d.b.i0.s2.a0.l;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f61537a;

    /* renamed from: b  reason: collision with root package name */
    public String f61538b;

    /* renamed from: c  reason: collision with root package name */
    public long f61539c;

    /* renamed from: d  reason: collision with root package name */
    public int f61540d;

    /* renamed from: e  reason: collision with root package name */
    public long f61541e;

    /* renamed from: f  reason: collision with root package name */
    public String f61542f;

    /* renamed from: g  reason: collision with root package name */
    public String f61543g;

    /* renamed from: h  reason: collision with root package name */
    public int f61544h;
    public String i;
    public String j;
    public String k;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return TextUtils.equals(this.f61537a, bVar.f61537a) && TextUtils.equals(this.f61538b, bVar.f61538b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f61537a + this.f61538b).hashCode();
    }
}
