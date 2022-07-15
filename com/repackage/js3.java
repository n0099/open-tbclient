package com.repackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class js3 implements cm1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Boolean> a;
    public is3 b;

    /* loaded from: classes6.dex */
    public class a implements ld2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ld2 a;
        public final /* synthetic */ js3 b;

        public a(js3 js3Var, ld2 ld2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {js3Var, ld2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = js3Var;
            this.a = ld2Var;
        }

        @Override // com.repackage.ld2
        public void a(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.b.g(true);
                this.a.a(jSONObject);
            }
        }

        @Override // com.repackage.ld2
        public void onFail(int i, @Nullable String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.b.g(false);
                this.a.onFail(i, str);
            }
        }
    }

    public js3() {
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
        this.a = new HashMap<>();
        this.b = new is3();
    }

    @Override // com.repackage.cm1
    @Nullable
    public hs1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull ld2 ld2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, ld2Var)) == null) {
            if (f()) {
                ld2Var.a(null);
                return null;
            }
            return this.b.a(jSONObject, c(ld2Var));
        }
        return (hs1) invokeLLL.objValue;
    }

    public final ld2 c(@NonNull ld2 ld2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ld2Var)) == null) ? new a(this, ld2Var) : (ld2) invokeL.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            h03 b0 = h03.b0();
            if (b0 != null) {
                return b0.O();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? TextUtils.equals(this.b.a, str) : invokeL.booleanValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Boolean bool;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            String d = d();
            if (TextUtils.isEmpty(d) || (bool = this.a.get(d)) == null) {
                return false;
            }
            return bool.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            String d = d();
            if (TextUtils.isEmpty(d)) {
                return;
            }
            this.a.put(d, Boolean.valueOf(z));
        }
    }
}
