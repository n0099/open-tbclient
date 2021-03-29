package d.a.a.s;

import androidx.annotation.RestrictTo;
import d.a.a.s.j.j;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final List<j> f41339a;

    /* renamed from: b  reason: collision with root package name */
    public final char f41340b;

    /* renamed from: c  reason: collision with root package name */
    public final double f41341c;

    /* renamed from: d  reason: collision with root package name */
    public final String f41342d;

    /* renamed from: e  reason: collision with root package name */
    public final String f41343e;

    public d(List<j> list, char c2, double d2, double d3, String str, String str2) {
        this.f41339a = list;
        this.f41340b = c2;
        this.f41341c = d3;
        this.f41342d = str;
        this.f41343e = str2;
    }

    public static int c(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<j> a() {
        return this.f41339a;
    }

    public double b() {
        return this.f41341c;
    }

    public int hashCode() {
        return c(this.f41340b, this.f41343e, this.f41342d);
    }
}
