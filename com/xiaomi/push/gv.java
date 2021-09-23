package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.UnknownHostException;
/* loaded from: classes10.dex */
public final class gv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes10.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public ew f78063a;

        /* renamed from: a  reason: collision with other field name */
        public String f459a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public static a a(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, exc)) == null) {
            m364a(exc);
            boolean z = exc instanceof fw;
            Exception exc2 = exc;
            if (z) {
                fw fwVar = (fw) exc;
                exc2 = exc;
                if (fwVar.a() != null) {
                    exc2 = fwVar.a();
                }
            }
            a aVar = new a();
            String message = exc2.getMessage();
            if (exc2.getCause() != null) {
                message = exc2.getCause().getMessage();
            }
            String str = exc2.getClass().getSimpleName() + ":" + message;
            int a2 = fn.a(exc2);
            if (a2 != 0) {
                aVar.f78063a = ew.a(ew.l.a() + a2);
            }
            if (aVar.f78063a == null) {
                aVar.f78063a = ew.t;
            }
            if (aVar.f78063a == ew.t) {
                aVar.f459a = str;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m364a(Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, exc) == null) && exc == null) {
            throw null;
        }
    }

    public static a b(Exception exc) {
        InterceptResult invokeL;
        ew ewVar;
        ew ewVar2;
        Throwable cause;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, exc)) == null) {
            m364a(exc);
            boolean z = exc instanceof fw;
            Exception exc2 = exc;
            if (z) {
                fw fwVar = (fw) exc;
                exc2 = exc;
                if (fwVar.a() != null) {
                    exc2 = fwVar.a();
                }
            }
            a aVar = new a();
            String message = exc2.getMessage();
            if (exc2.getCause() != null) {
                message = exc2.getCause().getMessage();
            }
            int a2 = fn.a(exc2);
            String str = exc2.getClass().getSimpleName() + ":" + message;
            if (a2 != 0) {
                ew a3 = ew.a(ew.v.a() + a2);
                aVar.f78063a = a3;
                if (a3 == ew.G && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                    ewVar = ew.F;
                }
                ewVar2 = aVar.f78063a;
                if (ewVar2 != ew.D || ewVar2 == ew.E || ewVar2 == ew.G) {
                    aVar.f459a = str;
                }
                return aVar;
            }
            ewVar = ew.E;
            aVar.f78063a = ewVar;
            ewVar2 = aVar.f78063a;
            if (ewVar2 != ew.D) {
            }
            aVar.f459a = str;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static a c(Exception exc) {
        InterceptResult invokeL;
        ew ewVar;
        ew ewVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, exc)) == null) {
            m364a(exc);
            boolean z = exc instanceof fw;
            Exception exc2 = exc;
            if (z) {
                fw fwVar = (fw) exc;
                exc2 = exc;
                if (fwVar.a() != null) {
                    exc2 = fwVar.a();
                }
            }
            a aVar = new a();
            String message = exc2.getMessage();
            if (exc2.getCause() != null) {
                message = exc2.getCause().getMessage();
            }
            int a2 = fn.a(exc2);
            String str = exc2.getClass().getSimpleName() + ":" + message;
            if (a2 == 105) {
                ewVar = ew.L;
            } else if (a2 == 199) {
                ewVar = ew.O;
            } else if (a2 == 499) {
                aVar.f78063a = ew.R;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    ewVar = ew.Q;
                }
                ewVar2 = aVar.f78063a;
                if (ewVar2 != ew.O || ewVar2 == ew.P || ewVar2 == ew.R) {
                    aVar.f459a = str;
                }
                return aVar;
            } else {
                ewVar = a2 != 109 ? a2 != 110 ? ew.P : ew.N : ew.M;
            }
            aVar.f78063a = ewVar;
            ewVar2 = aVar.f78063a;
            if (ewVar2 != ew.O) {
            }
            aVar.f459a = str;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static a d(Exception exc) {
        InterceptResult invokeL;
        ew ewVar;
        ew ewVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, exc)) == null) {
            m364a(exc);
            boolean z = exc instanceof fw;
            Exception exc2 = exc;
            if (z) {
                fw fwVar = (fw) exc;
                exc2 = exc;
                if (fwVar.a() != null) {
                    exc2 = fwVar.a();
                }
            }
            a aVar = new a();
            String message = exc2.getMessage();
            int a2 = fn.a(exc2);
            String str = exc2.getClass().getSimpleName() + ":" + message;
            if (a2 == 105) {
                ewVar = ew.X;
            } else if (a2 == 199) {
                ewVar = ew.aa;
            } else if (a2 == 499) {
                aVar.f78063a = ew.ad;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    ewVar = ew.ac;
                }
                ewVar2 = aVar.f78063a;
                if (ewVar2 != ew.aa || ewVar2 == ew.ab || ewVar2 == ew.ad) {
                    aVar.f459a = str;
                }
                return aVar;
            } else {
                ewVar = a2 != 109 ? a2 != 110 ? ew.ab : ew.Z : ew.Y;
            }
            aVar.f78063a = ewVar;
            ewVar2 = aVar.f78063a;
            if (ewVar2 != ew.aa) {
            }
            aVar.f459a = str;
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
