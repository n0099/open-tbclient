package d.a.p0.d;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static int f52215a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f52216b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static int f52217c = 3;

    /* renamed from: d  reason: collision with root package name */
    public static int f52218d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static int f52219e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static int f52220f = 3;

    /* renamed from: g  reason: collision with root package name */
    public static int f52221g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static int f52222h = 7;

    /* renamed from: i  reason: collision with root package name */
    public static b f52223i;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(87755023, "Ld/a/p0/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(87755023, "Ld/a/p0/d/a;");
                return;
            }
        }
        f52223i = new b();
    }

    public static void a(@NonNull int i2, @NonNull int i3, String str, String str2, String str3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i4)}) == null) {
            c cVar = new c();
            cVar.f52224a = i2;
            cVar.f52225b = i3;
            cVar.f52226c = str;
            cVar.f52227d = str2;
            cVar.f52228e = str3;
            cVar.f52229f = i4;
            f52223i.a(cVar);
        }
    }
}
