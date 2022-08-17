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
public class ko {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static lo b;
    public static String c;
    public static gj d;
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
                            if (ko.d != null) {
                                ko.d.c(ko.c, message.arg1);
                                gj unused = ko.d = null;
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            if (ko.d != null) {
                                if (ki.d()) {
                                    ko.d.error(message.what, hj.a(R.string.obfuscated_res_0x7f0f1560));
                                } else {
                                    ko.d.error(message.what, hj.a(R.string.obfuscated_res_0x7f0f1569));
                                }
                                gj unused2 = ko.d = null;
                                break;
                            }
                            break;
                        case 2:
                            if (ko.d != null) {
                                ko.d.error(message.what, hj.a(R.string.obfuscated_res_0x7f0f1561));
                                gj unused3 = ko.d = null;
                                break;
                            }
                            break;
                        case 4:
                            if (ko.d != null) {
                                ko.d.b(message.arg1);
                                break;
                            }
                            break;
                        case 5:
                            if (ko.d != null) {
                                ko.d.error(message.what, hj.a(R.string.obfuscated_res_0x7f0f1565));
                                gj unused4 = ko.d = null;
                                break;
                            }
                            break;
                        case 6:
                            if (ko.d != null) {
                                ko.d.error(message.what, hj.a(R.string.obfuscated_res_0x7f0f1562));
                                gj unused5 = ko.d = null;
                                break;
                            }
                            break;
                        case 7:
                            if (ko.d != null) {
                                ko.d.error(message.what, hj.a(R.string.obfuscated_res_0x7f0f1571));
                                gj unused6 = ko.d = null;
                                break;
                            }
                            break;
                        case 8:
                            if (ko.d != null) {
                                ko.d.error(message.what, hj.a(R.string.obfuscated_res_0x7f0f156f));
                                gj unused7 = ko.d = null;
                                break;
                            }
                            break;
                        case 9:
                            if (ko.d != null) {
                                ko.d.a(message.arg1);
                                break;
                            }
                            break;
                        default:
                            if (ko.d != null) {
                                ko.d.error(message.what, hj.a(R.string.obfuscated_res_0x7f0f1567));
                                gj unused8 = ko.d = null;
                                break;
                            }
                            break;
                    }
                } else if (ko.d != null) {
                    ko.d.e();
                }
                int unused9 = ko.a = 0;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964035295, "Lcom/repackage/ko;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964035295, "Lcom/repackage/ko;");
                return;
            }
        }
        f = new Handler(new a());
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            lo loVar = b;
            if (loVar != null) {
                loVar.cancel();
            }
            a = 0;
        }
    }

    public static void f(int i) {
        lo loVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65542, null, i) == null) || (loVar = b) == null) {
            return;
        }
        loVar.h(i);
    }

    public static boolean g(String str, int i, gj gjVar) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65543, null, str, i, gjVar)) == null) {
            if (System.currentTimeMillis() - e < 1000) {
                return false;
            }
            e = System.currentTimeMillis();
            if (a == 0) {
                if (b == null) {
                    b = new lo(f);
                }
                c = str;
                d = gjVar;
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
            lo loVar = b;
            if (loVar != null) {
                loVar.k();
            }
            a = 0;
        }
    }
}
