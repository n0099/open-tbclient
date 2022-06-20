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
/* loaded from: classes6.dex */
public abstract class n74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public n74() {
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

    public static n74 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (n74.class) {
                    if (a == null) {
                        a = new o74();
                    }
                }
            }
            return a;
        }
        return (n74) invokeV.objValue;
    }

    public abstract boolean a(p84 p84Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(p84 p84Var, List<q84> list, n84 n84Var, l84 l84Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends o84> boolean e(Class<T> cls, String str);

    public abstract boolean f(r84 r84Var);

    public abstract boolean g(List<r84> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<q84> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends o84> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends o84> T o(Class<T> cls, String str);

    public abstract Map<String, p84> p();

    public abstract r84 q(String str, long j, long j2);

    public abstract List<r84> r(String str, String[] strArr);

    public abstract List<r84> s(String str, long j, long j2);

    @Nullable
    public abstract s84 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<r84> w(String str);

    public abstract boolean x(r84 r84Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);
}
