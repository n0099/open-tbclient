package d.a.n0.t2.c0.l;

import android.text.TextUtils;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f60971a;

    /* renamed from: b  reason: collision with root package name */
    public String f60972b;

    /* renamed from: c  reason: collision with root package name */
    public long f60973c;

    /* renamed from: d  reason: collision with root package name */
    public int f60974d;

    /* renamed from: e  reason: collision with root package name */
    public long f60975e;

    /* renamed from: f  reason: collision with root package name */
    public String f60976f;

    /* renamed from: g  reason: collision with root package name */
    public String f60977g;

    /* renamed from: h  reason: collision with root package name */
    public int f60978h;

    /* renamed from: i  reason: collision with root package name */
    public String f60979i;
    public String j;
    public String k;

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return TextUtils.equals(this.f60971a, bVar.f60971a) && TextUtils.equals(this.f60972b, bVar.f60972b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f60971a + this.f60972b).hashCode();
    }
}
