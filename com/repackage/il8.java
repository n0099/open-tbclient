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
/* loaded from: classes6.dex */
public class il8 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, kl8> a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
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
                il8.a(1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755614500, "Lcom/repackage/il8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755614500, "Lcom/repackage/il8;");
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

    public static void b(kl8 kl8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, kl8Var, i) == null) {
            jl8 jl8Var = kl8Var.d;
            jl8 jl8Var2 = kl8Var.e;
            jl8 jl8Var3 = kl8Var.f;
            if (jl8Var.b + jl8Var2.b + jl8Var3.b >= i) {
                wg wgVar = new wg("dbg");
                wgVar.b("act", kl8Var.c);
                wgVar.b("httpTimeCost", String.valueOf(jl8Var.a));
                wgVar.b("httpNum", String.valueOf(jl8Var.b));
                wgVar.b("httpFailnum", String.valueOf(jl8Var.c));
                wgVar.b("httpSize", String.valueOf(jl8Var.d));
                wgVar.b("socketTimeCost", String.valueOf(jl8Var2.a));
                wgVar.b("socketNum", String.valueOf(jl8Var2.b));
                wgVar.b("socketFailnum", String.valueOf(jl8Var2.c));
                wgVar.b("socketSize", String.valueOf(jl8Var2.d));
                wgVar.b("abortTimeCost", String.valueOf(jl8Var3.a));
                wgVar.b("abortNum", String.valueOf(jl8Var3.b));
                wgVar.b("netType", kl8Var.b);
                wgVar.b("isJson", kl8Var.a ? "1" : "0");
                BdStatisticsManager.getInstance().debug("frs", wgVar);
                jl8Var.a();
                jl8Var2.a();
                jl8Var3.a();
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
            a.put(str3, new kl8(str, str2, z));
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
        }
    }

    public static kl8 e(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, str2, z)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!a.containsKey(str3)) {
                a.put(str3, new kl8(str, str2, z));
            }
            return a.get(str3);
        }
        return (kl8) invokeLLZ.objValue;
    }
}
