package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class vi8 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, xi8> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                vi8.a(1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755230100, "Lcom/repackage/vi8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755230100, "Lcom/repackage/vi8;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2001011));
        a = new HashMap<>();
    }

    public static void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
            for (String str : a.keySet()) {
                b(a.get(str), i);
            }
        }
    }

    public static void b(xi8 xi8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, xi8Var, i) == null) {
            wi8 wi8Var = xi8Var.d;
            wi8 wi8Var2 = xi8Var.e;
            wi8 wi8Var3 = xi8Var.f;
            if (wi8Var.b + wi8Var2.b + wi8Var3.b >= i) {
                vg vgVar = new vg("dbg");
                vgVar.b("act", xi8Var.c);
                vgVar.b("httpTimeCost", String.valueOf(wi8Var.a));
                vgVar.b("httpNum", String.valueOf(wi8Var.b));
                vgVar.b("httpFailnum", String.valueOf(wi8Var.c));
                vgVar.b("httpSize", String.valueOf(wi8Var.d));
                vgVar.b("socketTimeCost", String.valueOf(wi8Var2.a));
                vgVar.b("socketNum", String.valueOf(wi8Var2.b));
                vgVar.b("socketFailnum", String.valueOf(wi8Var2.c));
                vgVar.b("socketSize", String.valueOf(wi8Var2.d));
                vgVar.b("abortTimeCost", String.valueOf(wi8Var3.a));
                vgVar.b("abortNum", String.valueOf(wi8Var3.b));
                vgVar.b("netType", xi8Var.b);
                vgVar.b("isJson", xi8Var.a ? "1" : "0");
                BdStatisticsManager.getInstance().debug("frs", vgVar);
                wi8Var.a();
                wi8Var2.a();
                wi8Var3.a();
            }
        }
    }

    public static void c(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65539, null, str, str2, z) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (a.containsKey(str3)) {
                return;
            }
            a.put(str3, new xi8(str, str2, z));
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
        }
    }

    public static xi8 e(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, str2, z)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!a.containsKey(str3)) {
                a.put(str3, new xi8(str, str2, z));
            }
            return a.get(str3);
        }
        return (xi8) invokeLLZ.objValue;
    }
}
