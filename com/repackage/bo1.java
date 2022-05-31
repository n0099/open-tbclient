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
import com.repackage.oy2;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bo1 extends ao1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo1(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    public hr1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new hr1(1001, "context not support");
            }
            qy1 swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                return new hr1(1001, "none fragmentManger");
            }
            ny1 m = swanAppFragmentManager.m();
            if (!(m instanceof oy2.a)) {
                return new hr1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new hr1(1001, "fragment has detached");
            }
            py2.c(m);
            hw1.i("LoadingViewApi", "hide loading success");
            return hr1.f();
        }
        return (hr1) invokeV.objValue;
    }

    public hr1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                hw1.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new hr1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            if (hr1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                hw1.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
                String optString = jSONObject.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    return new hr1(202, "none title");
                }
                boolean optBoolean = jSONObject.optBoolean("mask", false);
                Context context = getContext();
                if (!(context instanceof SwanAppActivity)) {
                    return new hr1(1001, "context not support");
                }
                qy1 swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return new hr1(1001, "none fragment");
                }
                ny1 m = swanAppFragmentManager.m();
                if (!(m instanceof oy2.a)) {
                    return new hr1(1001, "fragment not support");
                }
                oy2 floatLayer = ((oy2.a) m).getFloatLayer();
                if (floatLayer == null) {
                    return new hr1(1001, "can't get floatLayer");
                }
                py2.f(floatLayer, context, optString, optBoolean);
                hw1.i("LoadingViewApi", "show loading success");
                return hr1.f();
            }
            return hr1Var;
        }
        return (hr1) invokeL.objValue;
    }
}
