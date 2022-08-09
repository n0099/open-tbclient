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
/* loaded from: classes7.dex */
public abstract class u84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public u84() {
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

    public static u84 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (u84.class) {
                    if (a == null) {
                        a = new v84();
                    }
                }
            }
            return a;
        }
        return (u84) invokeV.objValue;
    }

    public abstract boolean a(w94 w94Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(w94 w94Var, List<x94> list, u94 u94Var, s94 s94Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends v94> boolean e(Class<T> cls, String str);

    public abstract boolean f(y94 y94Var);

    public abstract boolean g(List<y94> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<x94> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends v94> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends v94> T o(Class<T> cls, String str);

    public abstract Map<String, w94> p();

    public abstract y94 q(String str, long j, long j2);

    public abstract List<y94> r(String str, String[] strArr);

    public abstract List<y94> s(String str, long j, long j2);

    @Nullable
    public abstract z94 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<y94> w(String str);

    public abstract boolean x(y94 y94Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);
}
