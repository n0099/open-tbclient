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
/* loaded from: classes7.dex */
public class vi {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static wi b;
    public static String c;
    public static xi d;
    public static Handler e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
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
                if (i != 0) {
                    if (i != 1) {
                        if (i != 6) {
                            if (vi.d != null) {
                                vi.d.error(message.what, cj.a(R.string.obfuscated_res_0x7f0f1564));
                            }
                        } else {
                            if (vi.d != null) {
                                vi.d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (vi.d != null) {
                        vi.d.error(message.what, cj.a(R.string.obfuscated_res_0x7f0f1562));
                    }
                } else if (vi.d != null) {
                    vi.d.c(vi.c, message.arg1);
                }
                int unused = vi.a = 0;
                xi unused2 = vi.d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964024910, "Lcom/repackage/vi;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964024910, "Lcom/repackage/vi;");
                return;
            }
        }
        e = new Handler(new a());
    }

    public static boolean e(String str, xi xiVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, xiVar, i)) == null) {
            if (a == 0) {
                wi wiVar = b;
                if (wiVar == null) {
                    b = new wi(e, i);
                } else {
                    wiVar.k(i);
                }
                c = str;
                d = xiVar;
                b.j(str);
                a = 2;
                new Thread(b).start();
                return true;
            }
            return false;
        }
        return invokeLLI.booleanValue;
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            wi wiVar = b;
            if (wiVar != null) {
                wiVar.l();
            } else {
                a = 0;
            }
        }
    }
}
