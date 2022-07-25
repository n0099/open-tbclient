package com.repackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m03;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class uw2 extends q03 implements sw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> b;
    public final HashMap<String, tw2> c;

    /* loaded from: classes7.dex */
    public class a implements bf3<m03.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uw2 a;

        public a(uw2 uw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uw2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(m03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (uw2.d) {
                    uw2 uw2Var = this.a;
                    uw2Var.T("onEventCallback msg" + aVar);
                }
                this.a.V(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements bf3<m03.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ uw2 a;

        public b(uw2 uw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = uw2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.bf3
        /* renamed from: b */
        public void a(m03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (uw2.d) {
                    uw2 uw2Var = this.a;
                    uw2Var.T("onEventCallback msg" + aVar);
                }
                this.a.W(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static uw2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(57449346, "Lcom/repackage/uw2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(57449346, "Lcom/repackage/uw2$c;");
                    return;
                }
            }
            a = new uw2(h03.K());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755246623, "Lcom/repackage/uw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755246623, "Lcom/repackage/uw2;");
                return;
            }
        }
        d = sg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uw2(l03 l03Var) {
        super(l03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {l03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((l03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        if (d) {
            T("SwanIpc");
        }
        f03 f03Var = new f03();
        f03Var.f(new b(this), "event_messenger_call_out");
        f03Var.f(new a(this), "event_messenger_call_in");
        u(f03Var);
    }

    public static synchronized boolean J(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        boolean L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, str)) == null) {
            synchronized (uw2.class) {
                L = R().L(Z(bundle), str);
            }
            return L;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized boolean K(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        boolean L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            synchronized (uw2.class) {
                L = R().L(a0(str), str2);
            }
            return L;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized tw2 Q(@NonNull String str) {
        InterceptResult invokeL;
        tw2 e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (uw2.class) {
                e0 = R().e0(str);
            }
            return e0;
        }
        return (tw2) invokeL.objValue;
    }

    public static uw2 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a : (uw2) invokeV.objValue;
    }

    public static void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            R();
        }
    }

    public static synchronized tw2 Z(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        tw2 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bundle)) == null) {
            synchronized (uw2.class) {
                c0 = R().c0(bundle);
            }
            return c0;
        }
        return (tw2) invokeL.objValue;
    }

    public static synchronized tw2 a0(@NonNull String str) {
        InterceptResult invokeL;
        tw2 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (uw2.class) {
                d0 = R().d0(str, null);
            }
            return d0;
        }
        return (tw2) invokeL.objValue;
    }

    public final synchronized boolean I(@NonNull tw2 tw2Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tw2Var, bundle)) == null) {
            synchronized (this) {
                if (tw2Var.Z()) {
                    z = L(tw2Var, bundle.getString("ipc_topic", ""));
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean L(@NonNull tw2 tw2Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tw2Var, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (tw2Var.Z()) {
                    String Q = tw2Var.Q();
                    String str2 = this.b.get(Q);
                    boolean z2 = !TextUtils.isEmpty(str2);
                    z = (!z2 || TextUtils.equals(str2, str)) ? true : true;
                    if (z && !z2 && !TextUtils.isEmpty(str)) {
                        this.b.put(Q, str);
                    }
                    return z;
                }
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public final void T(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && d) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public final void U(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            T(str + ": " + str2);
        }
    }

    public final void V(m03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (d) {
                U("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle D = aVar.D();
                m03.a aVar2 = new m03.a("event_messenger_call", D);
                tw2 Z = Z(D);
                if (I(Z, D) && Z.X(aVar2)) {
                    return;
                }
                h03.K().A(aVar2);
            }
        }
    }

    public final void W(m03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (d) {
                U("onCallOut", "msg=" + aVar);
            }
            if (aVar != null) {
                Z(aVar.D()).call();
            }
        }
    }

    public String X(@NonNull tw2 tw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, tw2Var)) == null) ? Y(tw2Var.Q()) : (String) invokeL.objValue;
    }

    public String Y(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? this.b.get(str) : (String) invokeL.objValue;
    }

    public uw2 b0(tw2 tw2Var, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tw2Var, exc)) == null) {
            if (tw2Var != null) {
                synchronized (this.c) {
                    tw2Var.M(exc);
                    this.c.remove(tw2Var.Q());
                }
            }
            return this;
        }
        return (uw2) invokeLL.objValue;
    }

    public final synchronized tw2 c0(Bundle bundle) {
        InterceptResult invokeL;
        tw2 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bundle)) == null) {
            synchronized (this) {
                d0 = d0(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
            }
            return d0;
        }
        return (tw2) invokeL.objValue;
    }

    public final synchronized tw2 d0(String str, Bundle bundle) {
        InterceptResult invokeLL;
        tw2 tw2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bundle)) == null) {
            synchronized (this) {
                tw2Var = TextUtils.isEmpty(str) ? null : this.c.get(str);
                if (tw2Var == null || !tw2Var.Z()) {
                    b0(tw2Var, new IllegalStateException("invalid session"));
                    tw2Var = new tw2(this, str);
                    this.c.put(tw2Var.Q(), tw2Var);
                }
                boolean z = bundle != null && I(tw2Var, bundle);
                if (z) {
                    int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
                    if (SwanAppProcessInfo.checkProcessId(i)) {
                        tw2Var.I(i);
                    } else if (SwanAppProcessInfo.SERVICE.index == i) {
                        tw2Var.K(true);
                    }
                }
                tw2Var.S(z ? bundle.getLong("ipc_session_timeout") : sw2.n0);
                if (d) {
                    U("session", "id=" + str + " session=" + bundle + " session=" + tw2Var);
                }
            }
            return tw2Var;
        }
        return (tw2) invokeLL.objValue;
    }

    public final synchronized tw2 e0(String str) {
        InterceptResult invokeL;
        tw2 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            synchronized (this) {
                c0 = c0(null);
                L(c0, str);
                if (d) {
                    U("topic", str + " session=" + c0);
                }
            }
            return c0;
        }
        return (tw2) invokeL.objValue;
    }
}
