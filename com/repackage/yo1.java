package com.repackage;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.FormBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class yo1 extends xo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a extends ResponseCallback<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ yo1 b;

        public a(yo1 yo1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yo1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = yo1Var;
            this.a = str;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                yo1 yo1Var = this.b;
                String str = this.a;
                yo1Var.d(str, new us1(1001, "operation fail, msg = " + exc.getMessage()));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(JSONObject jSONObject, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, i) == null) {
                if (jSONObject == null) {
                    this.b.d(this.a, new us1(1001, "server response fail"));
                    return;
                }
                int optInt = jSONObject.optInt("errno", 10002);
                String optString = jSONObject.optString("errmsg", SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
                if (optInt != 0) {
                    this.b.d(this.a, new us1(optInt, optString));
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    this.b.d(this.a, new us1(optInt, optString));
                    return;
                }
                this.b.d(this.a, new us1(0, optString, optJSONObject));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public JSONObject parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            ResponseBody body;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, response, i)) == null) {
                if (response == null || (body = response.body()) == null) {
                    return null;
                }
                return ud3.d(body.string());
            }
            return (JSONObject) invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yo1(@NonNull vo1 vo1Var) {
        super(vo1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vo1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((vo1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(String str, u03 u03Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, u03Var) == null) {
            w73 w73Var = new w73();
            w73Var.a = "swan";
            w73Var.b = str;
            w73Var.f = u03Var.N();
            w73Var.a("host_app", bk2.n().a());
            b73.i("2267", "83", w73Var.f());
        }
    }

    public final us1 B(String str, FormBody.Builder builder, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, builder, str2)) == null) {
            zr2 a2 = zr2.a(builder.build(), bs2.b);
            String y = y(str);
            if (TextUtils.isEmpty(y)) {
                return new us1(202);
            }
            v74 v74Var = new v74(y, a2, new a(this, str2));
            if (w74.g().c()) {
                v74Var.f = true;
            }
            v74Var.g = true;
            w74.g().e(v74Var);
            return us1.f();
        }
        return (us1) invokeLLL.objValue;
    }

    public us1 C(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            q("#takeCoupons", false);
            u03 a0 = u03.a0();
            if (a0 == null) {
                return new us1(1001, "SwanApp is null");
            }
            A("coupons_take", a0);
            if (!ap1.y(getContext())) {
                return new us1(10007, "is not baidu account");
            }
            if (!a0.M().e(getContext())) {
                return new us1(10004, "user not logged in");
            }
            Pair<us1, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((us1) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("promotionId");
                if (TextUtils.isEmpty(optString)) {
                    return new us1(202, "couponAppKey is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new us1(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", u03.f0());
                builder.add("promotionId", optString);
                return B("takeCoupons", builder, optString2);
            }
            return new us1(202);
        }
        return (us1) invokeL.objValue;
    }

    @Override // com.repackage.xo1
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "Coupon" : (String) invokeV.objValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "SwanAppCouponApi" : (String) invokeV.objValue;
    }

    public us1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            q("#getPlatformCoupons", false);
            u03 a0 = u03.a0();
            if (a0 == null) {
                return new us1(202, "SwanApp is null");
            }
            A("coupons_appkey", a0);
            if (!ap1.y(getContext())) {
                return new us1(10007, "is not baidu account");
            }
            Pair<us1, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((us1) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("couponAppKey");
                if (TextUtils.isEmpty(optString)) {
                    return new us1(202, "couponAppKey is invalid");
                }
                boolean optBoolean = jSONObject.optBoolean("withUserCoupons", false);
                if (optBoolean) {
                    A("coupons_appkey_user", a0);
                    if (!a0.M().e(getContext())) {
                        return new us1(10004, "user not logged in");
                    }
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new us1(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", u03.f0());
                builder.add("couponAppKey", optString);
                builder.add("withUserCoupons", String.valueOf(optBoolean));
                return B("getPlatformCoupons", builder, optString2);
            }
            return new us1(202);
        }
        return (us1) invokeL.objValue;
    }

    public final String y(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == -1741243770) {
                if (str.equals("takeCoupons")) {
                    c = 2;
                }
                c = 65535;
            } else if (hashCode != 15750540) {
                if (hashCode == 1991726820 && str.equals("getPlatformCoupons")) {
                    c = 0;
                }
                c = 65535;
            } else {
                if (str.equals("getUserCoupons")) {
                    c = 1;
                }
                c = 65535;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        return null;
                    }
                    return bk2.o().j();
                }
                return bk2.o().f();
            }
            return bk2.o().K();
        }
        return (String) invokeL.objValue;
    }

    public us1 z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            q("#getUserCoupons", false);
            u03 a0 = u03.a0();
            if (a0 == null) {
                return new us1(1001, "SwanApp is null");
            }
            A("coupons_user", a0);
            if (!ap1.y(getContext())) {
                return new us1(10007, "is not baidu account");
            }
            if (!a0.M().e(getContext())) {
                return new us1(10004, "user not logged in");
            }
            Pair<us1, JSONObject> s = s(str);
            JSONObject jSONObject = (JSONObject) s.second;
            if (((us1) s.first).isSuccess() && jSONObject != null) {
                String optString = jSONObject.optString("couponAppKey");
                if (TextUtils.isEmpty(optString)) {
                    return new us1(202, "couponAppKey is invalid");
                }
                String optString2 = jSONObject.optString("cb");
                if (TextUtils.isEmpty(optString2)) {
                    return new us1(202, "cb is invalid");
                }
                FormBody.Builder builder = new FormBody.Builder();
                builder.add("appKey", u03.f0());
                builder.add("couponAppKey", optString);
                return B("getUserCoupons", builder, optString2);
            }
            return new us1(202);
        }
        return (us1) invokeL.objValue;
    }
}
