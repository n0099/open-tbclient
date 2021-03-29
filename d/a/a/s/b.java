package d.a.a.s;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f41328a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41329b;

    /* renamed from: c  reason: collision with root package name */
    public final double f41330c;

    /* renamed from: d  reason: collision with root package name */
    public final int f41331d;

    /* renamed from: e  reason: collision with root package name */
    public final int f41332e;

    /* renamed from: f  reason: collision with root package name */
    public final double f41333f;

    /* renamed from: g  reason: collision with root package name */
    public final double f41334g;
    @ColorInt

    /* renamed from: h  reason: collision with root package name */
    public final int f41335h;
    @ColorInt
    public final int i;
    public final double j;
    public final boolean k;

    public b(String str, String str2, double d2, int i, int i2, double d3, double d4, @ColorInt int i3, @ColorInt int i4, double d5, boolean z) {
        this.f41328a = str;
        this.f41329b = str2;
        this.f41330c = d2;
        this.f41331d = i;
        this.f41332e = i2;
        this.f41333f = d3;
        this.f41334g = d4;
        this.f41335h = i3;
        this.i = i4;
        this.j = d5;
        this.k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f41328a.hashCode() * 31) + this.f41329b.hashCode()) * 31) + this.f41330c)) * 31) + this.f41331d) * 31) + this.f41332e;
        long doubleToLongBits = Double.doubleToLongBits(this.f41333f);
        return (((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + this.f41335h;
    }
}
