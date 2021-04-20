package d.b.k.b.d;

import java.text.DecimalFormat;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final DecimalFormat f64565a = new DecimalFormat("0.00");

    public static String a(long j, long j2) {
        return f64565a.format(((float) j) / 1048576.0f) + "M/" + f64565a.format(((float) j2) / 1048576.0f) + "M";
    }
}
