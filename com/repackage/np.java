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
public class np {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static op b;
    public static String c;
    public static dj d;
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
                            if (np.d != null) {
                                np.d.c(np.c, message.arg1);
                                dj unused = np.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (np.d != null) {
                                if (gi.d()) {
                                    np.d.error(message.what, ej.a(R.string.obfuscated_res_0x7f0f1545));
                                } else {
                                    np.d.error(message.what, ej.a(R.string.obfuscated_res_0x7f0f154e));
                                }
                                dj unused2 = np.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (np.d != null) {
                                np.d.error(message.what, ej.a(R.string.obfuscated_res_0x7f0f1546));
                                dj unused3 = np.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (np.d != null) {
                                np.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (np.d != null) {
                                np.d.error(message.what, ej.a(R.string.obfuscated_res_0x7f0f154a));
                                dj unused4 = np.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (np.d != null) {
                                np.d.error(message.what, ej.a(R.string.obfuscated_res_0x7f0f1547));
                                dj unused5 = np.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (np.d != null) {
                                np.d.error(message.what, ej.a(R.string.obfuscated_res_0x7f0f1556));
                                dj unused6 = np.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (np.d != null) {
                                np.d.error(message.what, ej.a(R.string.obfuscated_res_0x7f0f1554));
                                dj unused7 = np.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (np.d != null) {
                                np.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (np.d != null) {
                                np.d.error(message.what, ej.a(R.string.obfuscated_res_0x7f0f154c));
                                dj unused8 = np.d = null;
                                break;
                            }
                            break;
                    }
                } else if (np.d != null) {
                    np.d.e();
                }
                int unused9 = np.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964032381, "Lcom/repackage/np;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964032381, "Lcom/repackage/np;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            op opVar = b;
            if (opVar != null) {
                opVar.cancel();
            }
            a = 0;
        }
    }

    public static void f(int i) {
        op opVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65542, null, i) == null) || (opVar = b) == null) {
            return;
        }
        opVar.h(i);
    }

    public static boolean g(String str, int i, dj djVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, djVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new op(f);
                }
                c = str;
                d = djVar;
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
            op opVar = b;
            if (opVar != null) {
                opVar.k();
            }
            a = 0;
        }
    }
}
