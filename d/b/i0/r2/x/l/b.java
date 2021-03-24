package d.b.i0.r2.x.l;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f59936a;

    /* renamed from: b  reason: collision with root package name */
    public String f59937b;

    /* renamed from: c  reason: collision with root package name */
    public long f59938c;

    /* renamed from: d  reason: collision with root package name */
    public int f59939d;

    /* renamed from: e  reason: collision with root package name */
    public long f59940e;

    /* renamed from: f  reason: collision with root package name */
    public String f59941f;

    /* renamed from: g  reason: collision with root package name */
    public String f59942g;

    /* renamed from: h  reason: collision with root package name */
    public int f59943h;
    public String i;
    public String j;
    public String k;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return TextUtils.equals(this.f59936a, bVar.f59936a) && TextUtils.equals(this.f59937b, bVar.f59937b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f59936a + this.f59937b).hashCode();
    }
}
