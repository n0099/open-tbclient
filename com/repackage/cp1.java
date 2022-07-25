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
import com.repackage.pz2;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cp1 extends bp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cp1(@NonNull jo1 jo1Var) {
        super(jo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((jo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.lo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    public is1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new is1(1001, "context not support");
            }
            rz1 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new is1(1001, "none fragmentManger");
            }
            oz1 m = X.m();
            if (!(m instanceof pz2.a)) {
                return new is1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new is1(1001, "fragment has detached");
            }
            qz2.c(m);
            ix1.i("LoadingViewApi", "hide loading success");
            return is1.f();
        }
        return (is1) invokeV.objValue;
    }

    public is1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                ix1.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new is1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<is1, JSONObject> s = s(str);
            is1 is1Var = (is1) s.first;
            if (is1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                ix1.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
                String optString = jSONObject.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    return new is1(202, "none title");
                }
                boolean optBoolean = jSONObject.optBoolean("mask", false);
                Context context = getContext();
                if (!(context instanceof SwanAppActivity)) {
                    return new is1(1001, "context not support");
                }
                rz1 X = ((SwanAppActivity) context).X();
                if (X == null) {
                    return new is1(1001, "none fragment");
                }
                oz1 m = X.m();
                if (!(m instanceof pz2.a)) {
                    return new is1(1001, "fragment not support");
                }
                pz2 c = ((pz2.a) m).c();
                if (c == null) {
                    return new is1(1001, "can't get floatLayer");
                }
                qz2.f(c, context, optString, optBoolean);
                ix1.i("LoadingViewApi", "show loading success");
                return is1.f();
            }
            return is1Var;
        }
        return (is1) invokeL.objValue;
    }
}
