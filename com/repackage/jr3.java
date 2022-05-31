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
public class jr3 implements cl1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, Boolean> a;
    public ir3 b;

    /* loaded from: classes6.dex */
    public class a implements lc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc2 a;
        public final /* synthetic */ jr3 b;

        public a(jr3 jr3Var, lc2 lc2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jr3Var, lc2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = jr3Var;
            this.a = lc2Var;
        }

        @Override // com.repackage.lc2
        public void a(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.b.g(true);
                this.a.a(jSONObject);
            }
        }

        @Override // com.repackage.lc2
        public void onFail(int i, @Nullable String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.b.g(false);
                this.a.onFail(i, str);
            }
        }
    }

    public jr3() {
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
        this.b = new ir3();
    }

    @Override // com.repackage.cl1
    @Nullable
    public hr1 a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull lc2 lc2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, jSONObject, lc2Var)) == null) {
            if (f()) {
                lc2Var.a(null);
                return null;
            }
            return this.b.a(jSONObject, c(lc2Var));
        }
        return (hr1) invokeLLL.objValue;
    }

    public final lc2 c(@NonNull lc2 lc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lc2Var)) == null) ? new a(this, lc2Var) : (lc2) invokeL.objValue;
    }

    public final String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            hz2 a0 = hz2.a0();
            if (a0 != null) {
                return a0.N();
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
