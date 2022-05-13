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
public abstract class p84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public p84() {
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

    public static p84 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (p84.class) {
                    if (a == null) {
                        a = new q84();
                    }
                }
            }
            return a;
        }
        return (p84) invokeV.objValue;
    }

    public abstract boolean a(r94 r94Var, PMSAppInfo pMSAppInfo);

    public abstract boolean b(r94 r94Var, List<s94> list, p94 p94Var, n94 n94Var, PMSAppInfo pMSAppInfo);

    public abstract void c(String str);

    public abstract void d(String str, String str2);

    public abstract <T extends q94> boolean e(Class<T> cls, String str);

    public abstract boolean f(t94 t94Var);

    public abstract boolean g(List<t94> list);

    public abstract boolean h(String str);

    @WorkerThread
    public abstract int j(@NonNull String str);

    @NonNull
    @WorkerThread
    public abstract List<s94> k(@NonNull String str, int i);

    public abstract boolean l(PMSAppInfo pMSAppInfo);

    public abstract <T extends q94> boolean m(T t);

    public abstract boolean n(String str, String str2, String str3);

    public abstract <T extends q94> T o(Class<T> cls, String str);

    public abstract Map<String, r94> p();

    public abstract t94 q(String str, long j, long j2);

    public abstract List<t94> r(String str, String[] strArr);

    public abstract List<t94> s(String str, long j, long j2);

    @Nullable
    public abstract u94 t(String str);

    public abstract PMSAppInfo u(String str);

    public abstract Map<String, PMSAppInfo> v();

    public abstract List<t94> w(String str);

    public abstract boolean x(t94 t94Var);

    public abstract boolean y(PMSAppInfo pMSAppInfo);

    public abstract boolean z(String str, int i);
}
