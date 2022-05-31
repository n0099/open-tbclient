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
/* loaded from: classes5.dex */
public class fo {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static go b;
    public static String c;
    public static bj d;
    public static long e;
    public static Handler f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
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
                            if (fo.d != null) {
                                fo.d.c(fo.c, message.arg1);
                                bj unused = fo.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (fo.d != null) {
                                if (fi.d()) {
                                    fo.d.error(message.what, cj.a(R.string.obfuscated_res_0x7f0f155c));
                                } else {
                                    fo.d.error(message.what, cj.a(R.string.obfuscated_res_0x7f0f1565));
                                }
                                bj unused2 = fo.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (fo.d != null) {
                                fo.d.error(message.what, cj.a(R.string.obfuscated_res_0x7f0f155d));
                                bj unused3 = fo.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (fo.d != null) {
                                fo.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (fo.d != null) {
                                fo.d.error(message.what, cj.a(R.string.obfuscated_res_0x7f0f1561));
                                bj unused4 = fo.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (fo.d != null) {
                                fo.d.error(message.what, cj.a(R.string.obfuscated_res_0x7f0f155e));
                                bj unused5 = fo.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (fo.d != null) {
                                fo.d.error(message.what, cj.a(R.string.obfuscated_res_0x7f0f156d));
                                bj unused6 = fo.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (fo.d != null) {
                                fo.d.error(message.what, cj.a(R.string.obfuscated_res_0x7f0f156b));
                                bj unused7 = fo.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (fo.d != null) {
                                fo.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (fo.d != null) {
                                fo.d.error(message.what, cj.a(R.string.obfuscated_res_0x7f0f1563));
                                bj unused8 = fo.d = null;
                                break;
                            }
                            break;
                    }
                } else if (fo.d != null) {
                    fo.d.e();
                }
                int unused9 = fo.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964040100, "Lcom/repackage/fo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964040100, "Lcom/repackage/fo;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            go goVar = b;
            if (goVar != null) {
                goVar.cancel();
            }
            a = 0;
        }
    }

    public static void f(int i) {
        go goVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65542, null, i) == null) || (goVar = b) == null) {
            return;
        }
        goVar.h(i);
    }

    public static boolean g(String str, int i, bj bjVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, bjVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new go(f);
                }
                c = str;
                d = bjVar;
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
            go goVar = b;
            if (goVar != null) {
                goVar.k();
            }
            a = 0;
        }
    }
}
