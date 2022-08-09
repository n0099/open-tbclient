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
import com.repackage.g03;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tp1 extends sp1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tp1(@NonNull ap1 ap1Var) {
        super(ap1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ap1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((ap1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.cp1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    public zs1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new zs1(1001, "context not support");
            }
            i02 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new zs1(1001, "none fragmentManger");
            }
            f02 m = X.m();
            if (!(m instanceof g03.a)) {
                return new zs1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new zs1(1001, "fragment has detached");
            }
            h03.c(m);
            zx1.i("LoadingViewApi", "hide loading success");
            return zs1.f();
        }
        return (zs1) invokeV.objValue;
    }

    public zs1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                zx1.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new zs1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<zs1, JSONObject> s = s(str);
            zs1 zs1Var = (zs1) s.first;
            if (zs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                zx1.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
                String optString = jSONObject.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    return new zs1(202, "none title");
                }
                boolean optBoolean = jSONObject.optBoolean("mask", false);
                Context context = getContext();
                if (!(context instanceof SwanAppActivity)) {
                    return new zs1(1001, "context not support");
                }
                i02 X = ((SwanAppActivity) context).X();
                if (X == null) {
                    return new zs1(1001, "none fragment");
                }
                f02 m = X.m();
                if (!(m instanceof g03.a)) {
                    return new zs1(1001, "fragment not support");
                }
                g03 d = ((g03.a) m).d();
                if (d == null) {
                    return new zs1(1001, "can't get floatLayer");
                }
                h03.f(d, context, optString, optBoolean);
                zx1.i("LoadingViewApi", "show loading success");
                return zs1.f();
            }
            return zs1Var;
        }
        return (zs1) invokeL.objValue;
    }
}
