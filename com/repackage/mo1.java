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
import com.repackage.zy2;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class mo1 extends lo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mo1(@NonNull tn1 tn1Var) {
        super(tn1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tn1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((tn1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.vn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "LoadingViewApi" : (String) invokeV.objValue;
    }

    public sr1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#hideLoading", false);
            Context context = getContext();
            if (!(context instanceof SwanAppActivity)) {
                return new sr1(1001, "context not support");
            }
            bz1 X = ((SwanAppActivity) context).X();
            if (X == null) {
                return new sr1(1001, "none fragmentManger");
            }
            yy1 m = X.m();
            if (!(m instanceof zy2.a)) {
                return new sr1(1001, "fragment not support");
            }
            if (m.getContext() == null) {
                return new sr1(1001, "fragment has detached");
            }
            az2.c(m);
            sw1.i("LoadingViewApi", "hide loading success");
            return sr1.f();
        }
        return (sr1) invokeV.objValue;
    }

    public sr1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#showLoading", false);
            if (n()) {
                sw1.c("LoadingViewApi", "LoadingViewApi does not supported when app is invisible.");
                return new sr1(1001, "LoadingViewApi does not supported when app is invisible.");
            }
            Pair<sr1, JSONObject> s = s(str);
            sr1 sr1Var = (sr1) s.first;
            if (sr1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                sw1.i("LoadingViewApi", "handleShowLoading : joParams = \n" + jSONObject);
                String optString = jSONObject.optString("title");
                if (TextUtils.isEmpty(optString)) {
                    return new sr1(202, "none title");
                }
                boolean optBoolean = jSONObject.optBoolean("mask", false);
                Context context = getContext();
                if (!(context instanceof SwanAppActivity)) {
                    return new sr1(1001, "context not support");
                }
                bz1 X = ((SwanAppActivity) context).X();
                if (X == null) {
                    return new sr1(1001, "none fragment");
                }
                yy1 m = X.m();
                if (!(m instanceof zy2.a)) {
                    return new sr1(1001, "fragment not support");
                }
                zy2 c = ((zy2.a) m).c();
                if (c == null) {
                    return new sr1(1001, "can't get floatLayer");
                }
                az2.f(c, context, optString, optBoolean);
                sw1.i("LoadingViewApi", "show loading success");
                return sr1.f();
            }
            return sr1Var;
        }
        return (sr1) invokeL.objValue;
    }
}
