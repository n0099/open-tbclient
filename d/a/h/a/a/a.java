package d.a.h.a.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.q.g;
import d.a.d.e.q.h;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static int f42827a;

    /* renamed from: b  reason: collision with root package name */
    public static b f42828b;

    /* renamed from: c  reason: collision with root package name */
    public static String f42829c;

    /* renamed from: d  reason: collision with root package name */
    public static g f42830d;

    /* renamed from: e  reason: collision with root package name */
    public static long f42831e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f42832f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.h.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0600a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0600a() {
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
                if (i2 != 100) {
                    switch (i2) {
                        case 0:
                            if (a.f42830d != null) {
                                a.f42830d.c(a.f42829c, message.arg1);
                                g unused = a.f42830d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (a.f42830d != null) {
                                if (d.a.d.e.p.f.d()) {
                                    a.f42830d.error(message.what, h.a(R.string.voice_err_create_file_fail));
                                } else {
                                    a.f42830d.error(message.what, h.a(R.string.voice_err_sdcard_nospace));
                                }
                                g unused2 = a.f42830d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (a.f42830d != null) {
                                a.f42830d.error(message.what, h.a(R.string.voice_err_file_fail));
                                g unused3 = a.f42830d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (a.f42830d != null) {
                                a.f42830d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (a.f42830d != null) {
                                a.f42830d.error(message.what, h.a(R.string.voice_err_load_lib_fail));
                                g unused4 = a.f42830d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (a.f42830d != null) {
                                a.f42830d.error(message.what, h.a(R.string.voice_err_init_fail));
                                g unused5 = a.f42830d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (a.f42830d != null) {
                                a.f42830d.error(message.what, h.a(R.string.voice_record_timeout_tip));
                                g unused6 = a.f42830d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (a.f42830d != null) {
                                a.f42830d.error(message.what, h.a(R.string.voice_record_short_tip));
                                g unused7 = a.f42830d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (a.f42830d != null) {
                                a.f42830d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (a.f42830d != null) {
                                a.f42830d.error(message.what, h.a(R.string.voice_err_other));
                                g unused8 = a.f42830d = null;
                                break;
                            }
                            break;
                    }
                } else if (a.f42830d != null) {
                    a.f42830d.e();
                }
                int unused9 = a.f42827a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2135692382, "Ld/a/h/a/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2135692382, "Ld/a/h/a/a/a;");
                return;
            }
        }
        f42832f = new Handler(new C0600a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            b bVar = f42828b;
            if (bVar != null) {
                bVar.cancel();
            }
            f42827a = 0;
        }
    }

    public static boolean f(String str, int i2, g gVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(AdIconUtil.BAIDU_LOGO_ID, null, str, i2, gVar)) == null) {
            if (System.currentTimeMillis() - f42831e < 1000) {
                return false;
            }
            f42831e = System.currentTimeMillis();
            if (f42827a == 0) {
                if (f42828b == null) {
                    f42828b = new b(f42832f);
                }
                f42829c = str;
                f42830d = gVar;
                if (f42828b.i(str, i2)) {
                    f42827a = 3;
                    new Thread(f42828b).start();
                    return true;
                }
                f42828b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            b bVar = f42828b;
            if (bVar != null) {
                bVar.j();
            }
            f42827a = 0;
        }
    }
}
