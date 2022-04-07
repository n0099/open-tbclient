package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qs3 implements em1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qs3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ls3 a;
    public ps3 b;

    public qs3() {
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

    public static qs3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (qs3.class) {
                    if (c == null) {
                        c = new qs3();
                    }
                }
            }
            return c;
        }
        return (qs3) invokeV.objValue;
    }

    @Override // com.repackage.em1
    public js1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull nd2 nd2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, nd2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, nd2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, nd2Var);
            }
            return new js1(10001, "authorize fail.");
        }
        return (js1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new ls3();
            this.b = new ps3();
        }
    }
}
