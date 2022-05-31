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
public class hh8 {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, jh8> a;
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
                hh8.a(1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755648135, "Lcom/repackage/hh8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755648135, "Lcom/repackage/hh8;");
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

    public static void b(jh8 jh8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, jh8Var, i) == null) {
            ih8 ih8Var = jh8Var.d;
            ih8 ih8Var2 = jh8Var.e;
            ih8 ih8Var3 = jh8Var.f;
            if (ih8Var.b + ih8Var2.b + ih8Var3.b >= i) {
                rg rgVar = new rg("dbg");
                rgVar.b("act", jh8Var.c);
                rgVar.b("httpTimeCost", String.valueOf(ih8Var.a));
                rgVar.b("httpNum", String.valueOf(ih8Var.b));
                rgVar.b("httpFailnum", String.valueOf(ih8Var.c));
                rgVar.b("httpSize", String.valueOf(ih8Var.d));
                rgVar.b("socketTimeCost", String.valueOf(ih8Var2.a));
                rgVar.b("socketNum", String.valueOf(ih8Var2.b));
                rgVar.b("socketFailnum", String.valueOf(ih8Var2.c));
                rgVar.b("socketSize", String.valueOf(ih8Var2.d));
                rgVar.b("abortTimeCost", String.valueOf(ih8Var3.a));
                rgVar.b("abortNum", String.valueOf(ih8Var3.b));
                rgVar.b("netType", jh8Var.b);
                rgVar.b("isJson", jh8Var.a ? "1" : "0");
                BdStatisticsManager.getInstance().debug("frs", rgVar);
                ih8Var.a();
                ih8Var2.a();
                ih8Var3.a();
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
            a.put(str3, new jh8(str, str2, z));
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
        }
    }

    public static jh8 e(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, str2, z)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!a.containsKey(str3)) {
                a.put(str3, new jh8(str, str2, z));
            }
            return a.get(str3);
        }
        return (jh8) invokeLLZ.objValue;
    }
}
