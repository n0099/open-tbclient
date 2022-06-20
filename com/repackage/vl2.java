package com.repackage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.xl2;
import com.repackage.yl2;
import com.repackage.zl2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class vl2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<xl2> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755227403, "Lcom/repackage/vl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755227403, "Lcom/repackage/vl2;");
                return;
            }
        }
        b = cg1.a;
    }

    public vl2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        e();
    }

    @Nullable
    public final yl2 a(@NonNull String str, int i, int i2, @NonNull String str2, @NonNull Object obj) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2, obj})) == null) {
            yl2.a aVar = new yl2.a();
            aVar.e(str);
            aVar.g(i);
            aVar.c(i2);
            aVar.b(str2);
            aVar.f(obj);
            yl2 a = aVar.a();
            if (a == null) {
                if (b) {
                    Log.e("SwanLocalABTestAutoRegister", "build branch(" + str + ") fail: " + aVar.d().getMessage());
                    return null;
                }
                return null;
            }
            return a;
        }
        return (yl2) invokeCommon.objValue;
    }

    @Nullable
    public final zl2 b(int i, @NonNull String str, @NonNull Object obj) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, obj)) == null) {
            zl2.a aVar = new zl2.a();
            aVar.e(i);
            aVar.d(str);
            aVar.b(obj);
            zl2 a = aVar.a();
            if (a == null) {
                if (b) {
                    Log.e("SwanLocalABTestAutoRegister", "build switch(" + str + ") fail: " + aVar.c().getMessage());
                }
                return null;
            }
            return a;
        }
        return (zl2) invokeILL.objValue;
    }

    @NonNull
    public List<xl2> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Collections.unmodifiableList(this.a) : (List) invokeV.objValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            zl2 b2 = b(3, "swan_local_first_installation_update_core_delay", 0L);
            if (b2 == null) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(a("local_1000", 0, 20, "control group", 0L));
            arrayList.add(a("local_1001", 1, 20, "test group 1", 100L));
            arrayList.add(a("local_1002", 1, 20, "test group 2", 500L));
            arrayList.add(a("local_1003", 1, 20, "test group 3", 1000L));
            arrayList.add(a("local_1004", 1, 20, "test group 4", 2000L));
            xl2.a aVar = new xl2.a();
            aVar.c(b2);
            aVar.a(arrayList);
            xl2 b3 = aVar.b();
            if (b3 == null) {
                return false;
            }
            return this.a.add(b3);
        }
        return invokeV.booleanValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && d()) {
            sw1.c("SwanLocalABTestAutoRegister", "test 'first install updateCore delay' register failed'");
        }
    }
}
