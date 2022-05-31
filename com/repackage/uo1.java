package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class uo1 extends no1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ uo1 c;

        public a(uo1 uo1Var, hz2 hz2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uo1Var, hz2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = uo1Var;
            this.a = hz2Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.Z().b(this.c.a().i(), this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uo1(@NonNull in1 in1Var) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "NetworkApi" : (String) invokeV.objValue;
    }

    public hr1 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            q("#getNetworkType", false);
            String e = SwanAppNetworkUtils.e();
            if (TextUtils.isEmpty(e)) {
                e = "unknown";
            } else if ("no".equals(e)) {
                e = "none";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("networkType", e);
                return new hr1(0, jSONObject);
            } catch (JSONException unused) {
                return new hr1(202);
            }
        }
        return (hr1) invokeV.objValue;
    }

    public hr1 y(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#networkStatusChange", false);
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                return new hr1(202, "swan app is null");
            }
            Pair<hr1, JSONObject> s = s(str);
            hr1 hr1Var = (hr1) s.first;
            if (hr1Var.isSuccess()) {
                String optString = ((JSONObject) s.second).optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    return new hr1(1001, "cb is empty");
                }
                gz2.L().post(new a(this, a0, optString));
                return hr1.f();
            }
            return hr1Var;
        }
        return (hr1) invokeL.objValue;
    }
}
