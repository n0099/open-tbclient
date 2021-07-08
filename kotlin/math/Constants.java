package kotlin.math;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\n\bÂ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u00020\u00018\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0003¨\u0006\u000b"}, d2 = {"Lkotlin/math/Constants;", "", "LN2", "D", "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class Constants {
    public static final Constants INSTANCE = new Constants();
    @JvmField
    public static final double LN2 = Math.log(2.0d);
    @JvmField
    public static final double epsilon;
    @JvmField
    public static final double taylor_2_bound;
    @JvmField
    public static final double taylor_n_bound;
    @JvmField
    public static final double upper_taylor_2_bound;
    @JvmField
    public static final double upper_taylor_n_bound;

    static {
        double ulp = Math.ulp(1.0d);
        epsilon = ulp;
        double sqrt = Math.sqrt(ulp);
        taylor_2_bound = sqrt;
        double sqrt2 = Math.sqrt(sqrt);
        taylor_n_bound = sqrt2;
        double d2 = 1;
        upper_taylor_2_bound = d2 / taylor_2_bound;
        upper_taylor_n_bound = d2 / sqrt2;
    }
}
