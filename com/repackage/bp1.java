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
import com.repackage.oz2;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bp1 extends ap1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp1(@NonNull io1 io1Var) {
        super(io1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {io1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((io1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    public hs1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new hs1(1001, "context not support");
            }
            qz1 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new hs1(1001, "none fragmentManger");
            }
            nz1 m = X.m();
            if (!(m instanceof oz2.a)) {
                return new hs1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new hs1(1001, "fragment has detached");
            }
            pz2.c(m);
            hx1.i("LoadingViewApi", "hide loading success");
            return hs1.f();
        }
        return (hs1) invokeV.objValue;
    }

    public hs1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                hx1.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new hs1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                hx1.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
                String optString = jSONObject.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    return new hs1(202, "none title");
                }
                boolean optBoolean = jSONObject.optBoolean("mask", false);
                Context context = getContext();
                if (!(context instanceof SwanAppActivity)) {
                    return new hs1(1001, "context not support");
                }
                qz1 X = ((SwanAppActivity) context).X();
                if (X == null) {
                    return new hs1(1001, "none fragment");
                }
                nz1 m = X.m();
                if (!(m instanceof oz2.a)) {
                    return new hs1(1001, "fragment not support");
                }
                oz2 c = ((oz2.a) m).c();
                if (c == null) {
                    return new hs1(1001, "can't get floatLayer");
                }
                pz2.f(c, context, optString, optBoolean);
                hx1.i("LoadingViewApi", "show loading success");
                return hs1.f();
            }
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }
}
