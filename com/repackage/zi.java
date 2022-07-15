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
public class zi {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static aj b;
    public static String c;
    public static bj d;
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
                            if (zi.d != null) {
                                zi.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f156f));
                            }
                        } else {
                            if (zi.d != null) {
                                zi.d.d(message.arg1);
                            }
                            return true;
                        }
                    } else if (zi.d != null) {
                        zi.d.error(message.what, gj.a(R.string.obfuscated_res_0x7f0f156d));
                    }
                } else if (zi.d != null) {
                    zi.d.c(zi.c, message.arg1);
                }
                int unused = zi.a = 0;
                bj unused2 = zi.d = null;
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964021066, "Lcom/repackage/zi;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964021066, "Lcom/repackage/zi;");
                return;
            }
        }
        e = new Handler(new a());
    }

    public static boolean e(String str, bj bjVar, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65541, null, str, bjVar, i)) == null) {
            if (a == 0) {
                aj ajVar = b;
                if (ajVar == null) {
                    b = new aj(e, i);
                } else {
                    ajVar.k(i);
                }
                c = str;
                d = bjVar;
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
            aj ajVar = b;
            if (ajVar != null) {
                ajVar.l();
            } else {
                a = 0;
            }
        }
    }
}
