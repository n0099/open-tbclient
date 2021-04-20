package d.a.a.u;

import androidx.annotation.RestrictTo;
import d.a.a.u.j.j;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final List<j> f41637a;

    /* renamed from: b  reason: collision with root package name */
    public final char f41638b;

    /* renamed from: c  reason: collision with root package name */
    public final double f41639c;

    /* renamed from: d  reason: collision with root package name */
    public final String f41640d;

    /* renamed from: e  reason: collision with root package name */
    public final String f41641e;

    public c(List<j> list, char c2, double d2, double d3, String str, String str2) {
        this.f41637a = list;
        this.f41638b = c2;
        this.f41639c = d3;
        this.f41640d = str;
        this.f41641e = str2;
    }

    public static int c(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<j> a() {
        return this.f41637a;
    }

    public double b() {
        return this.f41639c;
    }

    public int hashCode() {
        return c(this.f41638b, this.f41641e, this.f41640d);
    }
}
