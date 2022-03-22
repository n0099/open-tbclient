package f.a.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes7.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f44725b;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f44726c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f44727d;

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f44728e;

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f44729f;

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f44730g;

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f44731h;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-963186589, "Lf/a/a/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-963186589, "Lf/a/a/i;");
                return;
            }
        }
        a = new int[]{1, 5, 9, 13, 17, 25, 33, 41, 49, 65, 81, 97, 113, 145, w0.u, 209, 241, 305, 369, 497, 753, 1265, 2289, 4337, 8433, 16625};
        f44725b = new int[]{2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9, 10, 11, 12, 13, 24};
        f44726c = new int[]{0, 1, 2, 3, 4, 5, 6, 8, 10, 14, 18, 26, 34, 50, 66, 98, 130, 194, 322, 578, 1090, 2114, 6210, 22594};
        f44727d = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 12, 14, 24};
        f44728e = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 18, 22, 30, 38, 54, 70, 102, 134, 198, 326, 582, 1094, 2118};
        f44729f = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 24};
        f44730g = new int[]{0, 0, 8, 8, 0, 16, 8, 16, 16};
        f44731h = new int[]{0, 8, 0, 8, 16, 0, 16, 8, 16};
    }
}
