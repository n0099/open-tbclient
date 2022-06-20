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
public class zr3 implements nl1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zr3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ur3 a;
    public yr3 b;

    public zr3() {
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

    public static zr3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (zr3.class) {
                    if (c == null) {
                        c = new zr3();
                    }
                }
            }
            return c;
        }
        return (zr3) invokeV.objValue;
    }

    @Override // com.repackage.nl1
    public sr1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull wc2 wc2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, wc2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, wc2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, wc2Var);
            }
            return new sr1(10001, "authorize fail.");
        }
        return (sr1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new ur3();
            this.b = new yr3();
        }
    }
}
