package ms.bd.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes9.dex */
public class m1 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile boolean f73555a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, e0> f73556b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public interface a {
        void a(String str);

        String b();

        Map<String, String> c(String str, byte[] bArr);

        void d(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1737200155, "Lms/bd/c/m1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1737200155, "Lms/bd/c/m1;");
                return;
            }
        }
        f73556b = new ConcurrentHashMap();
    }

    public m1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static synchronized a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (m1.class) {
                if (str != null) {
                    if (f73555a) {
                        Object a2 = b.a(67108866, str);
                        if (a2 == null) {
                            return null;
                        }
                        e0 e0Var = f73556b.get(str);
                        if (e0Var == null) {
                            return null;
                        }
                        return new l1(e0Var, ms.bd.c.a.c().a(), ((Long) a2).longValue());
                    }
                    return null;
                }
                throw new NullPointerException("appID must be set");
            }
        }
        return (a) invokeL.objValue;
    }

    public static synchronized void b(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, str) == null) {
            synchronized (m1.class) {
                Context applicationContext = context.getApplicationContext();
                ms.bd.c.a.c().b(applicationContext);
                n.a(applicationContext, str);
                String str2 = (String) h.a(16777217, 0, 0L, "2a6bf4", new byte[]{109, 110, 86});
                b.a(16777218, new p0());
                b.a(16777217, new a1());
                String str3 = (String) h.a(16777217, 0, 0L, "0ee8a6", new byte[]{111, 106, 18});
                b.a(16777219, new e1());
                b.a(16777221, new f1());
                b.a(16777222, new g1());
                b.a(16777223, new h1());
                b.a(16777224, new i1());
                b.a(16777225, new j1());
                b.a(16777226, new k1());
                b.a(16777227, new f0());
                b.a(16777228, new g0());
                b.a((int) InputDeviceCompat.SOURCE_JOYSTICK, new h0());
                b.a(16777233, new i0());
                b.a(16777235, new j0());
                b.a(16777238, new k0());
                b.a(16777239, new l0());
                b.a(16777241, new m0());
                b.a(16777242, new n0());
                b.a(16777243, new o0());
                b.a(16777244, new q0());
                b.a(16777245, new r0());
                b.a(16777246, new s0());
                b.a(16777247, new t0());
                b.a(16777248, new u0());
                b.a(16777249, new v0());
                b.a(16777250, new w0());
                b.a(16777251, new x0());
                b.a(16777240, new y0());
                b.a(16777252, new z0());
                b.a(16777253, new b1());
                b.a(16777254, new c1());
                b.a(16777255, new d1());
                b.a((int) InputDeviceCompat.SOURCE_HDMI, b0.c() ? new u1() : new s1());
                g.a();
                d.b.b.b.a.c.a();
                h.a(16777219, 0, 0L, null, applicationContext);
            }
        }
    }

    public static synchronized boolean c(Context context, e0 e0Var, String str) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, e0Var, str)) == null) {
            synchronized (m1.class) {
                if (context != null) {
                    if (e0Var != null) {
                        String str2 = e0Var.f73535a;
                        String str3 = (str2 == null || str2.length() <= 0) ? e0Var.f73541g : e0Var.f73535a;
                        if (str3 == null || str3.length() <= 0) {
                            throw new NullPointerException("appID must be set");
                        }
                        if (!f73555a) {
                            synchronized (m1.class) {
                                if (!f73555a) {
                                    b(context, str);
                                    f73555a = true;
                                }
                            }
                        }
                        if (f73556b.containsKey(str3)) {
                            return false;
                        }
                        if (((Boolean) b.a(67108865, e0Var.a())).booleanValue()) {
                            f73556b.put(str3, e0Var);
                            return true;
                        }
                        return false;
                    }
                    throw new NullPointerException("config could not be null");
                }
                throw new NullPointerException("context could not be null");
            }
        }
        return invokeLLL.booleanValue;
    }
}
