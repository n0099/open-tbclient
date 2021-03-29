package d.b.i0.r2.x.l;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f59937a;

    /* renamed from: b  reason: collision with root package name */
    public String f59938b;

    /* renamed from: c  reason: collision with root package name */
    public long f59939c;

    /* renamed from: d  reason: collision with root package name */
    public int f59940d;

    /* renamed from: e  reason: collision with root package name */
    public long f59941e;

    /* renamed from: f  reason: collision with root package name */
    public String f59942f;

    /* renamed from: g  reason: collision with root package name */
    public String f59943g;

    /* renamed from: h  reason: collision with root package name */
    public int f59944h;
    public String i;
    public String j;
    public String k;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return TextUtils.equals(this.f59937a, bVar.f59937a) && TextUtils.equals(this.f59938b, bVar.f59938b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f59937a + this.f59938b).hashCode();
    }
}
