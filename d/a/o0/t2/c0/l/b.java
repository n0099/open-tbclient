package d.a.o0.t2.c0.l;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f64788a;

    /* renamed from: b  reason: collision with root package name */
    public String f64789b;

    /* renamed from: c  reason: collision with root package name */
    public long f64790c;

    /* renamed from: d  reason: collision with root package name */
    public int f64791d;

    /* renamed from: e  reason: collision with root package name */
    public long f64792e;

    /* renamed from: f  reason: collision with root package name */
    public String f64793f;

    /* renamed from: g  reason: collision with root package name */
    public String f64794g;

    /* renamed from: h  reason: collision with root package name */
    public int f64795h;

    /* renamed from: i  reason: collision with root package name */
    public String f64796i;
    public String j;
    public String k;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return TextUtils.equals(this.f64788a, bVar.f64788a) && TextUtils.equals(this.f64789b, bVar.f64789b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f64788a + this.f64789b).hashCode();
    }
}
