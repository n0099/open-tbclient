package d.b.j0.s2.a0.l;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f61958a;

    /* renamed from: b  reason: collision with root package name */
    public String f61959b;

    /* renamed from: c  reason: collision with root package name */
    public long f61960c;

    /* renamed from: d  reason: collision with root package name */
    public int f61961d;

    /* renamed from: e  reason: collision with root package name */
    public long f61962e;

    /* renamed from: f  reason: collision with root package name */
    public String f61963f;

    /* renamed from: g  reason: collision with root package name */
    public String f61964g;

    /* renamed from: h  reason: collision with root package name */
    public int f61965h;
    public String i;
    public String j;
    public String k;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return TextUtils.equals(this.f61958a, bVar.f61958a) && TextUtils.equals(this.f61959b, bVar.f61959b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f61958a + this.f61959b).hashCode();
    }
}
