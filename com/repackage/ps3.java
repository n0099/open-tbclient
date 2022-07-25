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
public class ps3 implements dm1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ps3 c;
    public transient /* synthetic */ FieldHolder $fh;
    public ks3 a;
    public os3 b;

    public ps3() {
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

    public static ps3 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (c == null) {
                synchronized (ps3.class) {
                    if (c == null) {
                        c = new ps3();
                    }
                }
            }
            return c;
        }
        return (ps3) invokeV.objValue;
    }

    @Override // com.repackage.dm1
    public is1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull md2 md2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, md2Var)) == null) {
            if (this.a.e(str)) {
                return this.a.a(str, jSONObject, md2Var);
            }
            if (this.a.f()) {
                return this.b.a(str, jSONObject, md2Var);
            }
            return new is1(10001, "authorize fail.");
        }
        return (is1) invokeLLL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.a = new ks3();
            this.b = new os3();
        }
    }
}
