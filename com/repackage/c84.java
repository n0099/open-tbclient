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
public abstract class c84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public c84() {
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

    public static c84 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (c84.class) {
                    if (a == null) {
                        a = new d84();
                    }
                }
            }
            return a;
        }
        return (c84) invokeV.objValue;
    }

    public abstract boolean a(e94 e94Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(e94 e94Var, List<f94> list, c94 c94Var, a94 a94Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends d94> boolean e(Class<T> cls, String str);

    public abstract boolean f(g94 g94Var);

    public abstract boolean g(List<g94> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<f94> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends d94> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends d94> T o(Class<T> cls, String str);

    public abstract Map<String, e94> p();

    public abstract g94 q(String str, long j, long j2);

    public abstract List<g94> r(String str, String[] strArr);

    public abstract List<g94> s(String str, long j, long j2);

    @Nullable
    public abstract h94 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<g94> w(String str);

    public abstract boolean x(g94 g94Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);
}
