package d.a.n0.t2.c0.l;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f64663a;

    /* renamed from: b  reason: collision with root package name */
    public String f64664b;

    /* renamed from: c  reason: collision with root package name */
    public long f64665c;

    /* renamed from: d  reason: collision with root package name */
    public int f64666d;

    /* renamed from: e  reason: collision with root package name */
    public long f64667e;

    /* renamed from: f  reason: collision with root package name */
    public String f64668f;

    /* renamed from: g  reason: collision with root package name */
    public String f64669g;

    /* renamed from: h  reason: collision with root package name */
    public int f64670h;

    /* renamed from: i  reason: collision with root package name */
    public String f64671i;
    public String j;
    public String k;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return TextUtils.equals(this.f64663a, bVar.f64663a) && TextUtils.equals(this.f64664b, bVar.f64664b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f64663a + this.f64664b).hashCode();
    }
}
