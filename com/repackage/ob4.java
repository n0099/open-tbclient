package com.repackage;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public abstract class ob4 implements rb4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ob4() {
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

    public static <T> T e(@Nullable T t, @Nullable pb4<T> pb4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, t, pb4Var)) == null) {
            if (t != null && pb4Var != null) {
                pb4Var.a(t);
            }
            return t;
        }
        return (T) invokeLL.objValue;
    }

    @Override // com.repackage.rb4
    @Nullable
    public JSONObject a(@Nullable pb4<JSONObject> pb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pb4Var)) == null) {
            JSONObject d = d();
            e(d, pb4Var);
            return d;
        }
        return (JSONObject) invokeL.objValue;
    }

    @Override // com.repackage.rb4
    @Nullable
    public JSONArray b(@Nullable pb4<JSONArray> pb4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pb4Var)) == null) {
            JSONArray c = c();
            e(c, pb4Var);
            return c;
        }
        return (JSONArray) invokeL.objValue;
    }

    @Nullable
    public JSONArray c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (JSONArray) invokeV.objValue;
    }

    @Nullable
    public JSONObject d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }
}
