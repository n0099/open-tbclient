package com.xiaomi.push;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.UnknownHostException;
/* loaded from: classes8.dex */
public final class ff {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ez a;

        /* renamed from: a  reason: collision with other field name */
        public String f381a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            m395a(exc);
            boolean z = exc instanceof gh;
            Exception exc2 = exc;
            if (z) {
                gh ghVar = (gh) exc;
                exc2 = exc;
                if (ghVar.a() != null) {
                    exc2 = ghVar.a();
                }
            }
            a aVar = new a();
            String message = exc2.getMessage();
            if (exc2.getCause() != null) {
                message = exc2.getCause().getMessage();
            }
            String str = exc2.getClass().getSimpleName() + ":" + message;
            int a2 = fy.a(exc2);
            if (a2 != 0) {
                aVar.a = ez.a(ez.l.a() + a2);
            }
            if (aVar.a == null) {
                aVar.a = ez.t;
            }
            if (aVar.a == ez.t) {
                aVar.f381a = str;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m395a(Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, exc) == null) && exc == null) {
            throw null;
        }
    }

    public static a b(Exception exc) {
        InterceptResult invokeL;
        ez ezVar;
        ez ezVar2;
        Throwable cause;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, exc)) == null) {
            m395a(exc);
            boolean z = exc instanceof gh;
            Exception exc2 = exc;
            if (z) {
                gh ghVar = (gh) exc;
                exc2 = exc;
                if (ghVar.a() != null) {
                    exc2 = ghVar.a();
                }
            }
            a aVar = new a();
            String message = exc2.getMessage();
            if (exc2.getCause() != null) {
                message = exc2.getCause().getMessage();
            }
            int a2 = fy.a(exc2);
            String str = exc2.getClass().getSimpleName() + ":" + message;
            if (a2 != 0) {
                ez a3 = ez.a(ez.v.a() + a2);
                aVar.a = a3;
                if (a3 == ez.G && (cause = exc2.getCause()) != null && (cause instanceof UnknownHostException)) {
                    ezVar = ez.F;
                }
                ezVar2 = aVar.a;
                if (ezVar2 != ez.D || ezVar2 == ez.E || ezVar2 == ez.G) {
                    aVar.f381a = str;
                }
                return aVar;
            }
            ezVar = ez.E;
            aVar.a = ezVar;
            ezVar2 = aVar.a;
            if (ezVar2 != ez.D) {
            }
            aVar.f381a = str;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static a c(Exception exc) {
        InterceptResult invokeL;
        ez ezVar;
        ez ezVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, exc)) == null) {
            m395a(exc);
            boolean z = exc instanceof gh;
            Exception exc2 = exc;
            if (z) {
                gh ghVar = (gh) exc;
                exc2 = exc;
                if (ghVar.a() != null) {
                    exc2 = ghVar.a();
                }
            }
            a aVar = new a();
            String message = exc2.getMessage();
            if (exc2.getCause() != null) {
                message = exc2.getCause().getMessage();
            }
            int a2 = fy.a(exc2);
            String str = exc2.getClass().getSimpleName() + ":" + message;
            if (a2 == 105) {
                ezVar = ez.L;
            } else if (a2 == 199) {
                ezVar = ez.O;
            } else if (a2 == 499) {
                aVar.a = ez.R;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    ezVar = ez.Q;
                }
                ezVar2 = aVar.a;
                if (ezVar2 != ez.O || ezVar2 == ez.P || ezVar2 == ez.R) {
                    aVar.f381a = str;
                }
                return aVar;
            } else {
                ezVar = a2 != 109 ? a2 != 110 ? ez.P : ez.N : ez.M;
            }
            aVar.a = ezVar;
            ezVar2 = aVar.a;
            if (ezVar2 != ez.O) {
            }
            aVar.f381a = str;
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static a d(Exception exc) {
        InterceptResult invokeL;
        ez ezVar;
        ez ezVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, exc)) == null) {
            m395a(exc);
            boolean z = exc instanceof gh;
            Exception exc2 = exc;
            if (z) {
                gh ghVar = (gh) exc;
                exc2 = exc;
                if (ghVar.a() != null) {
                    exc2 = ghVar.a();
                }
            }
            a aVar = new a();
            String message = exc2.getMessage();
            int a2 = fy.a(exc2);
            String str = exc2.getClass().getSimpleName() + ":" + message;
            if (a2 == 105) {
                ezVar = ez.X;
            } else if (a2 == 199) {
                ezVar = ez.aa;
            } else if (a2 == 499) {
                aVar.a = ez.ad;
                if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                    ezVar = ez.ac;
                }
                ezVar2 = aVar.a;
                if (ezVar2 != ez.aa || ezVar2 == ez.ab || ezVar2 == ez.ad) {
                    aVar.f381a = str;
                }
                return aVar;
            } else {
                ezVar = a2 != 109 ? a2 != 110 ? ez.ab : ez.Z : ez.Y;
            }
            aVar.a = ezVar;
            ezVar2 = aVar.a;
            if (ezVar2 != ez.aa) {
            }
            aVar.f381a = str;
            return aVar;
        }
        return (a) invokeL.objValue;
    }
}
