package h.a.a;

import com.alibaba.fastjson.asm.Opcodes;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes4.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f64073b;

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f64074c;

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f64075d;

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f64076e;

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f64077f;

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f64078g;

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f64079h;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1772533215, "Lh/a/a/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1772533215, "Lh/a/a/i;");
                return;
            }
        }
        a = new int[]{1, 5, 9, 13, 17, 25, 33, 41, 49, 65, 81, 97, 113, w0.n, 177, 209, 241, 305, 369, 497, 753, 1265, 2289, 4337, 8433, 16625};
        f64073b = new int[]{2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 7, 8, 9, 10, 11, 12, 13, 24};
        f64074c = new int[]{0, 1, 2, 3, 4, 5, 6, 8, 10, 14, 18, 26, 34, 50, 66, 98, 130, 194, 322, 578, 1090, 2114, 6210, 22594};
        f64075d = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 12, 14, 24};
        f64076e = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 18, 22, 30, 38, 54, 70, 102, 134, Opcodes.IFNULL, 326, 582, 1094, 2118};
        f64077f = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 7, 8, 9, 10, 24};
        f64078g = new int[]{0, 0, 8, 8, 0, 16, 8, 16, 16};
        f64079h = new int[]{0, 8, 0, 8, 16, 0, 16, 8, 16};
    }
}
