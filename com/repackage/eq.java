package com.repackage;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class eq {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static fq b;
    public static String c;
    public static fj d;
    public static long e;
    public static Handler f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                int i = message.what;
                if (i != 100) {
                    switch (i) {
                        case 0:
                            if (eq.d != null) {
                                eq.d.c(eq.c, message.arg1);
                                fj unused = eq.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (eq.d != null) {
                                if (ii.d()) {
                                    eq.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f151a));
                                } else {
                                    eq.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f1523));
                                }
                                fj unused2 = eq.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (eq.d != null) {
                                eq.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f151b));
                                fj unused3 = eq.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (eq.d != null) {
                                eq.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (eq.d != null) {
                                eq.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f151f));
                                fj unused4 = eq.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (eq.d != null) {
                                eq.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f151c));
                                fj unused5 = eq.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (eq.d != null) {
                                eq.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f152a));
                                fj unused6 = eq.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (eq.d != null) {
                                eq.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f1529));
                                fj unused7 = eq.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (eq.d != null) {
                                eq.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (eq.d != null) {
                                eq.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f1521));
                                fj unused8 = eq.d = null;
                                break;
                            }
                            break;
                    }
                } else if (eq.d != null) {
                    eq.d.e();
                }
                int unused9 = eq.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964040999, "Lcom/repackage/eq;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964040999, "Lcom/repackage/eq;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            fq fqVar = b;
            if (fqVar != null) {
                fqVar.cancel();
            }
            a = 0;
        }
    }

    public static boolean f(String str, int i, fj fjVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65542, null, str, i, fjVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new fq(f);
                }
                c = str;
                d = fjVar;
                if (b.i(str, i)) {
                    a = 3;
                    new Thread(b).start();
                    return true;
                }
                b = null;
            }
            return false;
        }
        return invokeLIL.booleanValue;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            fq fqVar = b;
            if (fqVar != null) {
                fqVar.j();
            }
            a = 0;
        }
    }
}
