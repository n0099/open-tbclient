package d.a.k.b.d;

import java.text.DecimalFormat;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final DecimalFormat f40549a = new DecimalFormat("0.00");

    public static String a(long j, long j2) {
        return f40549a.format(((float) j) / 1048576.0f) + "M/" + f40549a.format(((float) j2) / 1048576.0f) + "M";
    }
}
