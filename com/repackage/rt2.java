package com.repackage;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.poly.widget.PolyActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class rt2 extends ft2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755338879, "Lcom/repackage/rt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755338879, "Lcom/repackage/rt2;");
                return;
            }
        }
        f = eh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rt2(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PaymentPanelApi" : (String) invokeV.objValue;
    }

    public us1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#chooseCoupon", false);
            u03 a0 = u03.a0();
            if (a0 == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan app is null");
                }
                return new us1(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan activity is null");
                }
                return new us1(1001, "swan activity is null");
            }
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new us1(202, "cb is empty");
                }
                String optString2 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString2)) {
                    return new us1(202, "empty componentId");
                }
                String optString3 = jSONObject.optString("appKey");
                if (TextUtils.isEmpty(optString3)) {
                    return new us1(202, "empty appKey");
                }
                String optString4 = jSONObject.optString("totalAmount");
                if (TextUtils.isEmpty(optString4)) {
                    return new us1(202, "empty totalAmount");
                }
                PaymentPanelManager.z().s(this, x, optString2, optString3, optString4, optString);
                return us1.f();
            }
            return us1Var;
        }
        return (us1) invokeL.objValue;
    }

    public us1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getPaymentInfo", false);
            if (u03.a0() == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: null swan runtime");
                }
                return new us1(1001, "swan app is null");
            }
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new us1(202, "cb is empty");
                }
                String optString2 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString2)) {
                    return new us1(202, "empty componentId");
                }
                String optString3 = jSONObject.optString("dealId");
                if (TextUtils.isEmpty(optString3)) {
                    return new us1(202, "empty dealId");
                }
                String optString4 = jSONObject.optString("appKey");
                if (TextUtils.isEmpty(optString4)) {
                    return new us1(202, "empty appKey");
                }
                String optString5 = jSONObject.optString("totalAmount");
                if (TextUtils.isEmpty(optString5)) {
                    return new us1(202, "empty totalAmount");
                }
                PaymentPanelManager.z().C(this, optString2, optString3, optString4, optString5, optString);
                return us1.f();
            }
            return us1Var;
        }
        return (us1) invokeL.objValue;
    }

    public us1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#setPaymentInfo", false);
            if (u03.a0() == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan app is null");
                }
                return new us1(1001, "swan app is null");
            }
            Pair<us1, JSONObject> s = s(str);
            us1 us1Var = (us1) s.first;
            if (us1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new us1(202, "cb is empty");
                }
                String optString2 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString2)) {
                    return new us1(202, "empty componentId");
                }
                String optString3 = jSONObject.optString(PolyActivity.CHOSEN_CHANNEL_KEY);
                if (TextUtils.isEmpty(optString3)) {
                    return new us1(202, "empty chosenChannel");
                }
                PaymentPanelManager.z().J(this, optString2, optString3, optString);
                return us1.f();
            }
            return us1Var;
        }
        return (us1) invokeL.objValue;
    }
}
