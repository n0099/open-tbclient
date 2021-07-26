package d.a.o0.h.a;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.a.a2.e;
import d.a.o0.a.f1.e.b;
import d.a.o0.a.j2.k;
import d.a.o0.h.f0.h;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            b bVar = new b();
            bVar.f46322b = str;
            bVar.f46325e = str2;
            if (e.i() != null && e.i().N() != null) {
                b.a N = e.i().N();
                bVar.f46321a = k.m(N.G());
                bVar.f46326f = N.H();
                bVar.f46323c = N.T();
                bVar.a("play_time", Long.valueOf(j));
            }
            k.v("916", "68", bVar);
        }
    }

    public static void b(String str, String str2) {
        String str3;
        b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) {
            if (e.i() == null || e.i().N() == null) {
                str3 = "";
                aVar = null;
            } else {
                aVar = e.i().N();
                str3 = k.m(aVar.G());
            }
            if (aVar == null || !TextUtils.equals(str3, SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME)) {
                return;
            }
            b bVar = new b();
            bVar.f46322b = str;
            bVar.f46325e = str2;
            bVar.f46321a = str3;
            bVar.f46326f = aVar.H();
            bVar.f46323c = aVar.T();
            k.v("916", "68", bVar);
        }
    }

    public static void c(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            b bVar = new b();
            bVar.f46322b = str;
            bVar.f46325e = str2;
            if (e.i() != null && e.i().N() != null) {
                b.a N = e.i().N();
                bVar.f46321a = k.m(N.G());
                bVar.f46326f = N.H();
                bVar.f46323c = N.T();
            }
            bVar.k = str3;
            k.v("916", "68", bVar);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            b bVar = new b();
            bVar.f46322b = str;
            bVar.f46325e = "show";
            if (e.i() != null && e.i().N() != null) {
                b.a N = e.i().N();
                bVar.f46321a = k.m(N.G());
                bVar.f46326f = N.H();
                bVar.f46323c = N.T();
            }
            bVar.a("early", e() ? "0" : "1");
            k.v("916", "68", bVar);
        }
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? h.c() > 0 && d.a.o0.h.q.c.b.c() && System.currentTimeMillis() - h.c() > 6000 : invokeV.booleanValue;
    }
}
