package g.a.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f72661a;

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f72662b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(779623839, "Lg/a/a/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(779623839, "Lg/a/a/l;");
                return;
            }
        }
        f72661a = new byte[1024];
        f72662b = new int[1024];
    }

    public static void a(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65537, null, bArr, i2, i3) == null) {
            int i4 = 0;
            while (i4 < i3) {
                int min = Math.min(i4 + 1024, i3) - i4;
                System.arraycopy(f72661a, 0, bArr, i2 + i4, min);
                i4 += min;
            }
        }
    }

    public static void b(int[] iArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, iArr, i2, i3) == null) {
            int i4 = 0;
            while (i4 < i3) {
                int min = Math.min(i4 + 1024, i3) - i4;
                System.arraycopy(f72662b, 0, iArr, i2 + i4, min);
                i4 += min;
            }
        }
    }
}
