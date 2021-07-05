package d.f.b.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.UUID;
/* loaded from: classes10.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f72600a;

    /* renamed from: b  reason: collision with root package name */
    public static final UUID f72601b;

    /* renamed from: c  reason: collision with root package name */
    public static final UUID f72602c;

    /* renamed from: d  reason: collision with root package name */
    public static final UUID f72603d;

    /* renamed from: e  reason: collision with root package name */
    public static final UUID f72604e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1658816908, "Ld/f/b/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1658816908, "Ld/f/b/a/b;");
                return;
            }
        }
        f72600a = d.f.b.a.i0.v.f73412a < 23 ? 1020 : 6396;
        f72601b = new UUID(0L, 0L);
        f72602c = new UUID(1186680826959645954L, -5988876978535335093L);
        new UUID(-2129748144642739255L, 8654423357094679310L);
        f72603d = new UUID(-1301668207276963122L, -6645017420763422227L);
        f72604e = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) ? (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000 : invokeJ.longValue;
    }

    public static long b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) ? (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000 : invokeJ.longValue;
    }
}
