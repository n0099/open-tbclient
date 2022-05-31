package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.as2;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ur2 extends sr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements as2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ur2 b;

        public a(ur2 ur2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ur2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ur2Var;
            this.a = str;
        }

        @Override // com.repackage.as2.d
        public void a(@NonNull hr1 hr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hr1Var) == null) {
                this.b.d(this.a, hr1Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ur2(@NonNull in1 in1Var) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PaymentApi" : (String) invokeV.objValue;
    }

    public hr1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#requestThirdPayment", false);
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                return new hr1(1001, "swan app is null");
            }
            SwanAppActivity x = a0.x();
            if (x == null) {
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
                JSONObject optJSONObject = jSONObject.optJSONObject("orderInfo");
                String optString2 = jSONObject.optString("invokeFrom");
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = RetrieveTaskManager.KEY;
                }
                new as2(a0, x, new a(this, optString)).n(optJSONObject, optString2);
                return hr1.f();
            }
            return hr1Var;
        }
        return (hr1) invokeL.objValue;
    }
}
