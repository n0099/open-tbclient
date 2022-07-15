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
import com.repackage.l03;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class tw2 extends p03 implements rw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> b;
    public final HashMap<String, sw2> c;

    /* loaded from: classes7.dex */
    public class a implements af3<l03.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tw2 a;

        public a(tw2 tw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tw2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(l03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (tw2.d) {
                    tw2 tw2Var = this.a;
                    tw2Var.T("onEventCallback msg" + aVar);
                }
                this.a.V(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements af3<l03.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tw2 a;

        public b(tw2 tw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tw2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(l03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                if (tw2.d) {
                    tw2 tw2Var = this.a;
                    tw2Var.T("onEventCallback msg" + aVar);
                }
                this.a.W(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static tw2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(28820195, "Lcom/repackage/tw2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(28820195, "Lcom/repackage/tw2$c;");
                    return;
                }
            }
            a = new tw2(g03.K());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755276414, "Lcom/repackage/tw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755276414, "Lcom/repackage/tw2;");
                return;
            }
        }
        d = rg1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tw2(k03 k03Var) {
        super(k03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k03) newInitContext.callArgs[0]);
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
        e03 e03Var = new e03();
        e03Var.f(new b(this), "event_messenger_call_out");
        e03Var.f(new a(this), "event_messenger_call_in");
        u(e03Var);
    }

    public static synchronized boolean J(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        boolean L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, str)) == null) {
            synchronized (tw2.class) {
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
            synchronized (tw2.class) {
                L = R().L(a0(str), str2);
            }
            return L;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized sw2 Q(@NonNull String str) {
        InterceptResult invokeL;
        sw2 e0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (tw2.class) {
                e0 = R().e0(str);
            }
            return e0;
        }
        return (sw2) invokeL.objValue;
    }

    public static tw2 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a : (tw2) invokeV.objValue;
    }

    public static void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            R();
        }
    }

    public static synchronized sw2 Z(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        sw2 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bundle)) == null) {
            synchronized (tw2.class) {
                c0 = R().c0(bundle);
            }
            return c0;
        }
        return (sw2) invokeL.objValue;
    }

    public static synchronized sw2 a0(@NonNull String str) {
        InterceptResult invokeL;
        sw2 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (tw2.class) {
                d0 = R().d0(str, null);
            }
            return d0;
        }
        return (sw2) invokeL.objValue;
    }

    public final synchronized boolean I(@NonNull sw2 sw2Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sw2Var, bundle)) == null) {
            synchronized (this) {
                if (sw2Var.Z()) {
                    z = L(sw2Var, bundle.getString("ipc_topic", ""));
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean L(@NonNull sw2 sw2Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sw2Var, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (sw2Var.Z()) {
                    String Q = sw2Var.Q();
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

    public final void V(l03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (d) {
                U("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle D = aVar.D();
                l03.a aVar2 = new l03.a("event_messenger_call", D);
                sw2 Z = Z(D);
                if (I(Z, D) && Z.X(aVar2)) {
                    return;
                }
                g03.K().A(aVar2);
            }
        }
    }

    public final void W(l03.a aVar) {
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

    public String X(@NonNull sw2 sw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, sw2Var)) == null) ? Y(sw2Var.Q()) : (String) invokeL.objValue;
    }

    public String Y(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? this.b.get(str) : (String) invokeL.objValue;
    }

    public tw2 b0(sw2 sw2Var, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sw2Var, exc)) == null) {
            if (sw2Var != null) {
                synchronized (this.c) {
                    sw2Var.M(exc);
                    this.c.remove(sw2Var.Q());
                }
            }
            return this;
        }
        return (tw2) invokeLL.objValue;
    }

    public final synchronized sw2 c0(Bundle bundle) {
        InterceptResult invokeL;
        sw2 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bundle)) == null) {
            synchronized (this) {
                d0 = d0(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
            }
            return d0;
        }
        return (sw2) invokeL.objValue;
    }

    public final synchronized sw2 d0(String str, Bundle bundle) {
        InterceptResult invokeLL;
        sw2 sw2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bundle)) == null) {
            synchronized (this) {
                sw2Var = TextUtils.isEmpty(str) ? null : this.c.get(str);
                if (sw2Var == null || !sw2Var.Z()) {
                    b0(sw2Var, new IllegalStateException("invalid session"));
                    sw2Var = new sw2(this, str);
                    this.c.put(sw2Var.Q(), sw2Var);
                }
                boolean z = bundle != null && I(sw2Var, bundle);
                if (z) {
                    int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
                    if (SwanAppProcessInfo.checkProcessId(i)) {
                        sw2Var.I(i);
                    } else if (SwanAppProcessInfo.SERVICE.index == i) {
                        sw2Var.K(true);
                    }
                }
                sw2Var.S(z ? bundle.getLong("ipc_session_timeout") : rw2.d0);
                if (d) {
                    U("session", "id=" + str + " session=" + bundle + " session=" + sw2Var);
                }
            }
            return sw2Var;
        }
        return (sw2) invokeLL.objValue;
    }

    public final synchronized sw2 e0(String str) {
        InterceptResult invokeL;
        sw2 c0;
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
        return (sw2) invokeL.objValue;
    }
}
