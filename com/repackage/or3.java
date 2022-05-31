package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class or3 implements cl1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile or3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public jr3 a;
    public nr3 b;

    public or3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public static or3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (or3.class) {
                    if (c == null) {
                        c = new or3();
                    }
                }
            }
            return c;
        }
        return (or3) invokeV.objValue;
    }

    @Override // com.repackage.cl1
    public hr1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull lc2 lc2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, lc2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, lc2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, lc2Var);
            }
            return new hr1(10001, "authorize fail.");
        }
        return (hr1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new jr3();
            this.b = new nr3();
        }
    }
}
