package d.a.j0.s2.b0.l;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f60140a;

    /* renamed from: b  reason: collision with root package name */
    public String f60141b;

    /* renamed from: c  reason: collision with root package name */
    public long f60142c;

    /* renamed from: d  reason: collision with root package name */
    public int f60143d;

    /* renamed from: e  reason: collision with root package name */
    public long f60144e;

    /* renamed from: f  reason: collision with root package name */
    public String f60145f;

    /* renamed from: g  reason: collision with root package name */
    public String f60146g;

    /* renamed from: h  reason: collision with root package name */
    public int f60147h;

    /* renamed from: i  reason: collision with root package name */
    public String f60148i;
    public String j;
    public String k;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return TextUtils.equals(this.f60140a, bVar.f60140a) && TextUtils.equals(this.f60141b, bVar.f60141b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f60140a + this.f60141b).hashCode();
    }
}
