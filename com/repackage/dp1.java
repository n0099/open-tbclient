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
import com.repackage.qz2;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class dp1 extends cp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp1(@NonNull ko1 ko1Var) {
        super(ko1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ko1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ko1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.mo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    public js1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new js1(1001, "context not support");
            }
            sz1 swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
            if (swanAppFragmentManager == null) {
                return new js1(1001, "none fragmentManger");
            }
            pz1 m = swanAppFragmentManager.m();
            if (!(m instanceof qz2.a)) {
                return new js1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new js1(1001, "fragment has detached");
            }
            rz2.c(m);
            jx1.i("LoadingViewApi", "hide loading success");
            return js1.f();
        }
        return (js1) invokeV.objValue;
    }

    public js1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                jx1.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new js1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<js1, JSONObject> s = s(str);
            js1 js1Var = (js1) s.first;
            if (js1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                jx1.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
                String optString = jSONObject.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    return new js1(202, "none title");
                }
                boolean optBoolean = jSONObject.optBoolean("mask", false);
                Context context = getContext();
                if (!(context instanceof SwanAppActivity)) {
                    return new js1(1001, "context not support");
                }
                sz1 swanAppFragmentManager = ((SwanAppActivity) context).getSwanAppFragmentManager();
                if (swanAppFragmentManager == null) {
                    return new js1(1001, "none fragment");
                }
                pz1 m = swanAppFragmentManager.m();
                if (!(m instanceof qz2.a)) {
                    return new js1(1001, "fragment not support");
                }
                qz2 floatLayer = ((qz2.a) m).getFloatLayer();
                if (floatLayer == null) {
                    return new js1(1001, "can't get floatLayer");
                }
                rz2.f(floatLayer, context, optString, optBoolean);
                jx1.i("LoadingViewApi", "show loading success");
                return js1.f();
            }
            return js1Var;
        }
        return (js1) invokeL.objValue;
    }
}
