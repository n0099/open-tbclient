package d.a.q0.a.h0.u;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f48555b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f48556c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f48557a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705834398, "Ld/a/q0/a/h0/u/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705834398, "Ld/a/q0/a/h0/u/e;");
                return;
            }
        }
        f48555b = k.f49133a;
        d.a.q0.a.c1.a.Z().getSwitch("swan_slave_ready", false);
        f48556c = false;
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static d.a.q0.a.o0.d.b a(e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, eVar)) == null) {
            if (f48555b) {
                Log.d("SlaveReadyEvent", "createSlaveReadyMessage:" + eVar);
            }
            TreeMap treeMap = new TreeMap();
            treeMap.put("slaveId", eVar.f48557a);
            return new d.a.q0.a.o0.d.b("SlaveReady", treeMap);
        }
        return (d.a.q0.a.o0.d.b) invokeL.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f48555b) {
                Log.d("SlaveReadyEvent", "isSlaveReadyABSwitchOn:" + f48556c);
            }
            return f48556c;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SlaveReadyEvent{slaveId='" + this.f48557a + "'}";
        }
        return (String) invokeV.objValue;
    }
}
