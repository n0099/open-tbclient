package d.a.d.e.q;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.R;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f41982a;

    /* renamed from: b  reason: collision with root package name */
    public static b f41983b;

    /* renamed from: c  reason: collision with root package name */
    public static String f41984c;

    /* renamed from: d  reason: collision with root package name */
    public static c f41985d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f41986e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.d.e.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0563a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0563a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i2 = message.what;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 6) {
                            if (a.f41985d != null) {
                                a.f41985d.error(message.what, h.a(R.string.voice_err_play));
                            }
                        } else {
                            if (a.f41985d != null) {
                                a.f41985d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (a.f41985d != null) {
                        a.f41985d.error(message.what, h.a(R.string.voice_err_no_file));
                    }
                } else if (a.f41985d != null) {
                    a.f41985d.c(a.f41984c, message.arg1);
                }
                int unused = a.f41982a = 0;
                c unused2 = a.f41985d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-402005870, "Ld/a/d/e/q/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-402005870, "Ld/a/d/e/q/a;");
                return;
            }
        }
        f41986e = new Handler(new C0563a());
    }

    public static boolean e(String str, c cVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(AdIconUtil.AD_TEXT_ID, null, str, cVar, i2)) == null) {
            if (f41982a == 0) {
                b bVar = f41983b;
                if (bVar == null) {
                    f41983b = new b(f41986e, i2);
                } else {
                    bVar.k(i2);
                }
                f41984c = str;
                f41985d = cVar;
                f41983b.j(str);
                f41982a = 2;
                new Thread(f41983b).start();
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            b bVar = f41983b;
            if (bVar != null) {
                bVar.l();
            } else {
                f41982a = 0;
            }
        }
    }
}
