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
import com.repackage.y03;
import java.util.HashMap;
/* loaded from: classes6.dex */
public final class gx2 extends c13 implements ex2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> b;
    public final HashMap<String, fx2> c;

    /* loaded from: classes6.dex */
    public class a implements nf3<y03.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx2 a;

        public a(gx2 gx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gx2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(y03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (gx2.d) {
                    gx2 gx2Var = this.a;
                    gx2Var.S("onEventCallback msg" + aVar);
                }
                this.a.U(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements nf3<y03.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx2 a;

        public b(gx2 gx2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gx2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(y03.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (gx2.d) {
                    gx2 gx2Var = this.a;
                    gx2Var.S("onEventCallback msg" + aVar);
                }
                this.a.V(aVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static gx2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-342435247, "Lcom/repackage/gx2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-342435247, "Lcom/repackage/gx2$c;");
                    return;
                }
            }
            a = new gx2(t03.J());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755662736, "Lcom/repackage/gx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755662736, "Lcom/repackage/gx2;");
                return;
            }
        }
        d = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gx2(x03 x03Var) {
        super(x03Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x03Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((x03) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        if (d) {
            S("SwanIpc");
        }
        r03 r03Var = new r03();
        r03Var.e(new b(this), "event_messenger_call_out");
        r03Var.e(new a(this), "event_messenger_call_in");
        v(r03Var);
    }

    public static synchronized boolean I(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        boolean K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, str)) == null) {
            synchronized (gx2.class) {
                K = Q().K(Y(bundle), str);
            }
            return K;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized boolean J(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        boolean K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, str2)) == null) {
            synchronized (gx2.class) {
                K = Q().K(Z(str), str2);
            }
            return K;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized fx2 P(@NonNull String str) {
        InterceptResult invokeL;
        fx2 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (gx2.class) {
                d0 = Q().d0(str);
            }
            return d0;
        }
        return (fx2) invokeL.objValue;
    }

    public static gx2 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a : (gx2) invokeV.objValue;
    }

    public static void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            Q();
        }
    }

    public static synchronized fx2 Y(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        fx2 b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bundle)) == null) {
            synchronized (gx2.class) {
                b0 = Q().b0(bundle);
            }
            return b0;
        }
        return (fx2) invokeL.objValue;
    }

    public static synchronized fx2 Z(@NonNull String str) {
        InterceptResult invokeL;
        fx2 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (gx2.class) {
                c0 = Q().c0(str, null);
            }
            return c0;
        }
        return (fx2) invokeL.objValue;
    }

    public final synchronized boolean H(@NonNull fx2 fx2Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fx2Var, bundle)) == null) {
            synchronized (this) {
                if (fx2Var.Z()) {
                    z = K(fx2Var, bundle.getString("ipc_topic", ""));
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean K(@NonNull fx2 fx2Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fx2Var, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (fx2Var.Z()) {
                    String Q = fx2Var.Q();
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

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && d) {
            Log.i("SwanIpc", SwanAppProcessInfo.current() + " >> " + str);
        }
    }

    public final void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            S(str + ": " + str2);
        }
    }

    public final void U(y03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (d) {
                T("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle D = aVar.D();
                y03.a aVar2 = new y03.a("event_messenger_call", D);
                fx2 Y = Y(D);
                if (H(Y, D) && Y.X(aVar2)) {
                    return;
                }
                t03.J().A(aVar2);
            }
        }
    }

    public final void V(y03.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            if (d) {
                T("onCallOut", "msg=" + aVar);
            }
            if (aVar != null) {
                Y(aVar.D()).call();
            }
        }
    }

    public String W(@NonNull fx2 fx2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fx2Var)) == null) ? X(fx2Var.Q()) : (String) invokeL.objValue;
    }

    public String X(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? this.b.get(str) : (String) invokeL.objValue;
    }

    public gx2 a0(fx2 fx2Var, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fx2Var, exc)) == null) {
            if (fx2Var != null) {
                synchronized (this.c) {
                    fx2Var.M(exc);
                    this.c.remove(fx2Var.Q());
                }
            }
            return this;
        }
        return (gx2) invokeLL.objValue;
    }

    public final synchronized fx2 b0(Bundle bundle) {
        InterceptResult invokeL;
        fx2 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bundle)) == null) {
            synchronized (this) {
                c0 = c0(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
            }
            return c0;
        }
        return (fx2) invokeL.objValue;
    }

    public final synchronized fx2 c0(String str, Bundle bundle) {
        InterceptResult invokeLL;
        fx2 fx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bundle)) == null) {
            synchronized (this) {
                fx2Var = TextUtils.isEmpty(str) ? null : this.c.get(str);
                if (fx2Var == null || !fx2Var.Z()) {
                    a0(fx2Var, new IllegalStateException("invalid session"));
                    fx2Var = new fx2(this, str);
                    this.c.put(fx2Var.Q(), fx2Var);
                }
                boolean z = bundle != null && H(fx2Var, bundle);
                if (z) {
                    int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
                    if (SwanAppProcessInfo.checkProcessId(i)) {
                        fx2Var.I(i);
                    } else if (SwanAppProcessInfo.SERVICE.index == i) {
                        fx2Var.K(true);
                    }
                }
                fx2Var.S(z ? bundle.getLong("ipc_session_timeout") : ex2.d0);
                if (d) {
                    T("session", "id=" + str + " session=" + bundle + " session=" + fx2Var);
                }
            }
            return fx2Var;
        }
        return (fx2) invokeLL.objValue;
    }

    public final synchronized fx2 d0(String str) {
        InterceptResult invokeL;
        fx2 b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            synchronized (this) {
                b0 = b0(null);
                K(b0, str);
                if (d) {
                    T("topic", str + " session=" + b0);
                }
            }
            return b0;
        }
        return (fx2) invokeL.objValue;
    }
}
