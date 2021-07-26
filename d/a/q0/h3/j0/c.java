package d.a.q0.h3.j0;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, e> f58630a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                c.a(1);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(616484072, "Ld/a/q0/h3/j0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(616484072, "Ld/a/q0/h3/j0/c;");
                return;
            }
        }
        MessageManager.getInstance().registerListener(new a(2001011));
        f58630a = new HashMap<>();
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
            for (String str : f58630a.keySet()) {
                b(f58630a.get(str), i2);
            }
        }
    }

    public static void b(e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65538, null, eVar, i2) == null) {
            d dVar = eVar.f58638d;
            d dVar2 = eVar.f58639e;
            d dVar3 = eVar.f58640f;
            if (dVar.f58632b + dVar2.f58632b + dVar3.f58632b >= i2) {
                d.a.d.e.n.a aVar = new d.a.d.e.n.a("dbg");
                aVar.b("act", eVar.f58637c);
                aVar.b("httpTimeCost", String.valueOf(dVar.f58631a));
                aVar.b("httpNum", String.valueOf(dVar.f58632b));
                aVar.b("httpFailnum", String.valueOf(dVar.f58633c));
                aVar.b("httpSize", String.valueOf(dVar.f58634d));
                aVar.b("socketTimeCost", String.valueOf(dVar2.f58631a));
                aVar.b("socketNum", String.valueOf(dVar2.f58632b));
                aVar.b("socketFailnum", String.valueOf(dVar2.f58633c));
                aVar.b("socketSize", String.valueOf(dVar2.f58634d));
                aVar.b("abortTimeCost", String.valueOf(dVar3.f58631a));
                aVar.b("abortNum", String.valueOf(dVar3.f58632b));
                aVar.b("netType", eVar.f58636b);
                aVar.b("isJson", eVar.f58635a ? "1" : "0");
                BdStatisticsManager.getInstance().debug("frs", aVar);
                dVar.a();
                dVar2.a();
                dVar3.a();
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
            if (f58630a.containsKey(str3)) {
                return;
            }
            f58630a.put(str3, new e(str, str2, z));
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
        }
    }

    public static e e(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(AdIconUtil.AD_TEXT_ID, null, str, str2, z)) == null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str + str2;
            if (!f58630a.containsKey(str3)) {
                f58630a.put(str3, new e(str, str2, z));
            }
            return f58630a.get(str3);
        }
        return (e) invokeLLZ.objValue;
    }
}
