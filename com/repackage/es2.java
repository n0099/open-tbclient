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
/* loaded from: classes5.dex */
public class es2 extends sr2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755727123, "Lcom/repackage/es2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755727123, "Lcom/repackage/es2;");
                return;
            }
        }
        f = rf1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public es2(@NonNull in1 in1Var) {
        super(in1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {in1Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((in1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PaymentPanelApi" : (String) invokeV.objValue;
    }

    public hr1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#chooseCoupon", false);
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan app is null");
                }
                return new hr1(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan activity is null");
                }
                return new hr1(1001, "swan activity is null");
            }
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            if (hr1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new hr1(202, "cb is empty");
                }
                String optString2 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString2)) {
                    return new hr1(202, "empty componentId");
                }
                String optString3 = jSONObject.optString("appKey");
                if (TextUtils.isEmpty(optString3)) {
                    return new hr1(202, "empty appKey");
                }
                String optString4 = jSONObject.optString("totalAmount");
                if (TextUtils.isEmpty(optString4)) {
                    return new hr1(202, "empty totalAmount");
                }
                PaymentPanelManager.z().s(this, x, optString2, optString3, optString4, optString);
                return hr1.f();
            }
            return hr1Var;
        }
        return (hr1) invokeL.objValue;
    }

    public hr1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#getPaymentInfo", false);
            if (hz2.a0() == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: null swan runtime");
                }
                return new hr1(1001, "swan app is null");
            }
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            if (hr1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new hr1(202, "cb is empty");
                }
                String optString2 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString2)) {
                    return new hr1(202, "empty componentId");
                }
                String optString3 = jSONObject.optString("dealId");
                if (TextUtils.isEmpty(optString3)) {
                    return new hr1(202, "empty dealId");
                }
                String optString4 = jSONObject.optString("appKey");
                if (TextUtils.isEmpty(optString4)) {
                    return new hr1(202, "empty appKey");
                }
                String optString5 = jSONObject.optString("totalAmount");
                if (TextUtils.isEmpty(optString5)) {
                    return new hr1(202, "empty totalAmount");
                }
                PaymentPanelManager.z().C(this, optString2, optString3, optString4, optString5, optString);
                return hr1.f();
            }
            return hr1Var;
        }
        return (hr1) invokeL.objValue;
    }

    public hr1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            q("#setPaymentInfo", false);
            if (hz2.a0() == null) {
                if (f) {
                    Log.e("PaymentPanelApi", "failed: swan app is null");
                }
                return new hr1(1001, "swan app is null");
            }
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            if (hr1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new hr1(202, "cb is empty");
                }
                String optString2 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString2)) {
                    return new hr1(202, "empty componentId");
                }
                String optString3 = jSONObject.optString(PolyActivity.CHOSEN_CHANNEL_KEY);
                if (TextUtils.isEmpty(optString3)) {
                    return new hr1(202, "empty chosenChannel");
                }
                PaymentPanelManager.z().J(this, optString2, optString3, optString);
                return hr1.f();
            }
            return hr1Var;
        }
        return (hr1) invokeL.objValue;
    }
}
