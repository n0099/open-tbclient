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
public abstract class e84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public e84() {
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

    public static e84 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (e84.class) {
                    if (a == null) {
                        a = new f84();
                    }
                }
            }
            return a;
        }
        return (e84) invokeV.objValue;
    }

    public abstract boolean a(g94 g94Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(g94 g94Var, List<h94> list, e94 e94Var, c94 c94Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends f94> boolean e(Class<T> cls, String str);

    public abstract boolean f(i94 i94Var);

    public abstract boolean g(List<i94> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<h94> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends f94> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends f94> T o(Class<T> cls, String str);

    public abstract Map<String, g94> p();

    public abstract i94 q(String str, long j, long j2);

    public abstract List<i94> r(String str, String[] strArr);

    public abstract List<i94> s(String str, long j, long j2);

    @Nullable
    public abstract j94 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<i94> w(String str);

    public abstract boolean x(i94 i94Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);
}
