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
public class jo {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static ko b;
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
                            if (jo.d != null) {
                                jo.d.c(jo.c, message.arg1);
                                fj unused = jo.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (jo.d != null) {
                                if (ji.d()) {
                                    jo.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f1565));
                                } else {
                                    jo.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f156e));
                                }
                                fj unused2 = jo.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (jo.d != null) {
                                jo.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f1566));
                                fj unused3 = jo.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (jo.d != null) {
                                jo.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (jo.d != null) {
                                jo.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f156a));
                                fj unused4 = jo.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (jo.d != null) {
                                jo.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f1567));
                                fj unused5 = jo.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (jo.d != null) {
                                jo.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f1576));
                                fj unused6 = jo.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (jo.d != null) {
                                jo.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f1574));
                                fj unused7 = jo.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (jo.d != null) {
                                jo.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (jo.d != null) {
                                jo.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f156c));
                                fj unused8 = jo.d = null;
                                break;
                            }
                            break;
                    }
                } else if (jo.d != null) {
                    jo.d.e();
                }
                int unused9 = jo.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964036256, "Lcom/repackage/jo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964036256, "Lcom/repackage/jo;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            ko koVar = b;
            if (koVar != null) {
                koVar.cancel();
            }
            a = 0;
        }
    }

    public static void f(int i) {
        ko koVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65542, null, i) == null) || (koVar = b) == null) {
            return;
        }
        koVar.h(i);
    }

    public static boolean g(String str, int i, fj fjVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, fjVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new ko(f);
                }
                c = str;
                d = fjVar;
                if (b.j(str, i)) {
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

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            ko koVar = b;
            if (koVar != null) {
                koVar.k();
            }
            a = 0;
        }
    }
}
