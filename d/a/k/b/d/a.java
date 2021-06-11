package d.a.k.b.d;

import java.text.DecimalFormat;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final DecimalFormat f44225a = new DecimalFormat("0.00");

    public static String a(long j, long j2) {
        return f44225a.format(((float) j) / 1048576.0f) + "M/" + f44225a.format(((float) j2) / 1048576.0f) + "M";
    }
}
