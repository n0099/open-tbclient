package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b03;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class op1 extends np1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public op1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    public us1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new us1(1001, "context not support");
            }
            d02 swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                return new us1(1001, "none fragmentManger");
            }
            a02 m = swanAppFragmentManager.m();
            if (!(m instanceof b03.a)) {
                return new us1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new us1(1001, "fragment has detached");
            }
            c03.c(m);
            ux1.i("LoadingViewApi", "hide loading success");
            return us1.f();
        }
        return (us1) invokeV.objValue;
    }

    public us1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                ux1.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new us1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                ux1.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
                String optString = jSONObject.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    return new us1(202, "none title");
                }
                boolean optBoolean = jSONObject.optBoolean("mask", false);
                Context context = getContext();
                if (!(context instanceof SwanAppActivity)) {
                    return new us1(1001, "context not support");
                }
                d02 swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return new us1(1001, "none fragment");
                }
                a02 m = swanAppFragmentManager.m();
                if (!(m instanceof b03.a)) {
                    return new us1(1001, "fragment not support");
                }
                b03 floatLayer = ((b03.a) m).getFloatLayer();
                if (floatLayer == null) {
                    return new us1(1001, "can't get floatLayer");
                }
                c03.f(floatLayer, context, optString, optBoolean);
                ux1.i("LoadingViewApi", "show loading success");
                return us1.f();
            }
            return us1Var;
        }
        return (us1) invokeL.objValue;
    }
}
