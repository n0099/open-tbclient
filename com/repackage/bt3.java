package com.repackage;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bt3 implements pm1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bt3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ws3 a;
    public at3 b;

    public bt3() {
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

    public static bt3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (bt3.class) {
                    if (c == null) {
                        c = new bt3();
                    }
                }
            }
            return c;
        }
        return (bt3) invokeV.objValue;
    }

    @Override // com.repackage.pm1
    public us1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull yd2 yd2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, yd2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, yd2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, yd2Var);
            }
            return new us1(10001, "authorize fail.");
        }
        return (us1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new ws3();
            this.b = new at3();
        }
    }
}
