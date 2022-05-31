package com.repackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public abstract class c74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public c74() {
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

    public static c74 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (c74.class) {
                    if (a == null) {
                        a = new d74();
                    }
                }
            }
            return a;
        }
        return (c74) invokeV.objValue;
    }

    public abstract boolean a(e84 e84Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(e84 e84Var, List<f84> list, c84 c84Var, a84 a84Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends d84> boolean e(Class<T> cls, String str);

    public abstract boolean f(g84 g84Var);

    public abstract boolean g(List<g84> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<f84> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends d84> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends d84> T o(Class<T> cls, String str);

    public abstract Map<String, e84> p();

    public abstract g84 q(String str, long j, long j2);

    public abstract List<g84> r(String str, String[] strArr);

    public abstract List<g84> s(String str, long j, long j2);

    @Nullable
    public abstract h84 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<g84> w(String str);

    public abstract boolean x(g84 g84Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);
}
