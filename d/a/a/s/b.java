package d.a.a.s;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41327a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41328b;

    /* renamed from: c  reason: collision with root package name */
    public final double f41329c;

    /* renamed from: d  reason: collision with root package name */
    public final int f41330d;

    /* renamed from: e  reason: collision with root package name */
    public final int f41331e;

    /* renamed from: f  reason: collision with root package name */
    public final double f41332f;

    /* renamed from: g  reason: collision with root package name */
    public final double f41333g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public final int f41334h;
    @ColorInt
    public final int i;
    public final double j;
    public final boolean k;

    public b(String str, String str2, double d2, int i, int i2, double d3, double d4, @ColorInt int i3, @ColorInt int i4, double d5, boolean z) {
        this.f41327a = str;
        this.f41328b = str2;
        this.f41329c = d2;
        this.f41330d = i;
        this.f41331e = i2;
        this.f41332f = d3;
        this.f41333g = d4;
        this.f41334h = i3;
        this.i = i4;
        this.j = d5;
        this.k = z;
    }

    public int hashCode() {
        double hashCode = ((this.f41327a.hashCode() * 31) + this.f41328b.hashCode()) * 31;
        double d2 = this.f41329c;
        Double.isNaN(hashCode);
        int i = (((((int) (hashCode + d2)) * 31) + this.f41330d) * 31) + this.f41331e;
        long doubleToLongBits = Double.doubleToLongBits(this.f41332f);
        return (((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f41334h;
    }
}
