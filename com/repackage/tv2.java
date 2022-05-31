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
import com.repackage.lz2;
import java.util.HashMap;
/* loaded from: classes7.dex */
public final class tv2 extends pz2 implements rv2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, String> b;
    public final HashMap<String, sv2> c;

    /* loaded from: classes7.dex */
    public class a implements ae3<lz2.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv2 a;

        public a(tv2 tv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tv2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(lz2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (tv2.d) {
                    tv2 tv2Var = this.a;
                    tv2Var.S("onEventCallback msg" + aVar);
                }
                this.a.U(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ae3<lz2.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv2 a;

        public b(tv2 tv2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tv2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(lz2.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (tv2.d) {
                    tv2 tv2Var = this.a;
                    tv2Var.S("onEventCallback msg" + aVar);
                }
                this.a.V(aVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static tv2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(27896674, "Lcom/repackage/tv2$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(27896674, "Lcom/repackage/tv2$c;");
                    return;
                }
            }
            a = new tv2(gz2.J());
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755277375, "Lcom/repackage/tv2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755277375, "Lcom/repackage/tv2;");
                return;
            }
        }
        d = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tv2(kz2 kz2Var) {
        super(kz2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kz2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((kz2) newInitContext.callArgs[0]);
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
        ez2 ez2Var = new ez2();
        ez2Var.e(new b(this), "event_messenger_call_out");
        ez2Var.e(new a(this), "event_messenger_call_in");
        v(ez2Var);
    }

    public static synchronized boolean I(@NonNull Bundle bundle, @NonNull String str) {
        InterceptResult invokeLL;
        boolean K;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, bundle, str)) == null) {
            synchronized (tv2.class) {
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
            synchronized (tv2.class) {
                K = Q().K(Z(str), str2);
            }
            return K;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized sv2 P(@NonNull String str) {
        InterceptResult invokeL;
        sv2 d0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            synchronized (tv2.class) {
                d0 = Q().d0(str);
            }
            return d0;
        }
        return (sv2) invokeL.objValue;
    }

    public static tv2 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? c.a : (tv2) invokeV.objValue;
    }

    public static void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, null) == null) {
            Q();
        }
    }

    public static synchronized sv2 Y(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        sv2 b0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bundle)) == null) {
            synchronized (tv2.class) {
                b0 = Q().b0(bundle);
            }
            return b0;
        }
        return (sv2) invokeL.objValue;
    }

    public static synchronized sv2 Z(@NonNull String str) {
        InterceptResult invokeL;
        sv2 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (tv2.class) {
                c0 = Q().c0(str, null);
            }
            return c0;
        }
        return (sv2) invokeL.objValue;
    }

    public final synchronized boolean H(@NonNull sv2 sv2Var, @NonNull Bundle bundle) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, sv2Var, bundle)) == null) {
            synchronized (this) {
                if (sv2Var.Z()) {
                    z = K(sv2Var, bundle.getString("ipc_topic", ""));
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized boolean K(@NonNull sv2 sv2Var, @NonNull String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sv2Var, str)) == null) {
            synchronized (this) {
                boolean z = false;
                if (sv2Var.Z()) {
                    String Q = sv2Var.Q();
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

    public final void U(lz2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            if (d) {
                T("onCallIn", "msg=" + aVar);
            }
            if (aVar != null) {
                Bundle D = aVar.D();
                lz2.a aVar2 = new lz2.a("event_messenger_call", D);
                sv2 Y = Y(D);
                if (H(Y, D) && Y.X(aVar2)) {
                    return;
                }
                gz2.J().A(aVar2);
            }
        }
    }

    public final void V(lz2.a aVar) {
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

    public String W(@NonNull sv2 sv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, sv2Var)) == null) ? X(sv2Var.Q()) : (String) invokeL.objValue;
    }

    public String X(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) ? this.b.get(str) : (String) invokeL.objValue;
    }

    public tv2 a0(sv2 sv2Var, Exception exc) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sv2Var, exc)) == null) {
            if (sv2Var != null) {
                synchronized (this.c) {
                    sv2Var.M(exc);
                    this.c.remove(sv2Var.Q());
                }
            }
            return this;
        }
        return (tv2) invokeLL.objValue;
    }

    public final synchronized sv2 b0(Bundle bundle) {
        InterceptResult invokeL;
        sv2 c0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, bundle)) == null) {
            synchronized (this) {
                c0 = c0(bundle == null ? null : bundle.getString("ipc_session_id"), bundle);
            }
            return c0;
        }
        return (sv2) invokeL.objValue;
    }

    public final synchronized sv2 c0(String str, Bundle bundle) {
        InterceptResult invokeLL;
        sv2 sv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, str, bundle)) == null) {
            synchronized (this) {
                sv2Var = TextUtils.isEmpty(str) ? null : this.c.get(str);
                if (sv2Var == null || !sv2Var.Z()) {
                    a0(sv2Var, new IllegalStateException("invalid session"));
                    sv2Var = new sv2(this, str);
                    this.c.put(sv2Var.Q(), sv2Var);
                }
                boolean z = bundle != null && H(sv2Var, bundle);
                if (z) {
                    int i = bundle.getInt("ipc_session_repal", SwanAppProcessInfo.UNKNOWN.index);
                    if (SwanAppProcessInfo.checkProcessId(i)) {
                        sv2Var.I(i);
                    } else if (SwanAppProcessInfo.SERVICE.index == i) {
                        sv2Var.K(true);
                    }
                }
                sv2Var.S(z ? bundle.getLong("ipc_session_timeout") : rv2.d0);
                if (d) {
                    T("session", "id=" + str + " session=" + bundle + " session=" + sv2Var);
                }
            }
            return sv2Var;
        }
        return (sv2) invokeLL.objValue;
    }

    public final synchronized sv2 d0(String str) {
        InterceptResult invokeL;
        sv2 b0;
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
        return (sv2) invokeL.objValue;
    }
}
