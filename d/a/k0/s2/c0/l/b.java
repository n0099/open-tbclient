package d.a.k0.s2.c0.l;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f60869a;

    /* renamed from: b  reason: collision with root package name */
    public String f60870b;

    /* renamed from: c  reason: collision with root package name */
    public long f60871c;

    /* renamed from: d  reason: collision with root package name */
    public int f60872d;

    /* renamed from: e  reason: collision with root package name */
    public long f60873e;

    /* renamed from: f  reason: collision with root package name */
    public String f60874f;

    /* renamed from: g  reason: collision with root package name */
    public String f60875g;

    /* renamed from: h  reason: collision with root package name */
    public int f60876h;

    /* renamed from: i  reason: collision with root package name */
    public String f60877i;
    public String j;
    public String k;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return TextUtils.equals(this.f60869a, bVar.f60869a) && TextUtils.equals(this.f60870b, bVar.f60870b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f60869a + this.f60870b).hashCode();
    }
}
