package com.repackage;

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
import com.repackage.at2;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class us2 extends ss2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements at2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ us2 b;

        public a(us2 us2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {us2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = us2Var;
            this.a = str;
        }

        @Override // com.repackage.at2.d
        public void a(@NonNull hs1 hs1Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hs1Var) == null) {
                this.b.d(this.a, hs1Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public us2(@NonNull io1 io1Var) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "PaymentApi" : (String) invokeV.objValue;
    }

    public hs1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#requestThirdPayment", false);
            h03 b0 = h03.b0();
            if (b0 == null) {
                return new hs1(1001, "swan app is null");
            }
            SwanAppActivity w = b0.w();
            if (w == null) {
                return new hs1(1001, "swan activity is null");
            }
            Pair<hs1, JSONObject> s = s(str);
            hs1 hs1Var = (hs1) s.first;
            if (hs1Var.isSuccess()) {
                JSONObject jSONObject = (JSONObject) s.second;
                String optString = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new hs1(202, "cb is empty");
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("orderInfo");
                String optString2 = jSONObject.optString("invokeFrom");
                if (TextUtils.isEmpty(optString2)) {
                    optString2 = "api";
                }
                new at2(b0, w, new a(this, optString)).n(optJSONObject, optString2);
                return hs1.f();
            }
            return hs1Var;
        }
        return (hs1) invokeL.objValue;
    }
}
