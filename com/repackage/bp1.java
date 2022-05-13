package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bp1 extends zo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements nf3<x53<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fi1 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;

        public a(bp1 bp1Var, fi1 fi1Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bp1Var, fi1Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fi1Var;
            this.b = callbackHandler;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<JSONObject> x53Var) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (x53Var.c() && bp1.y(x53Var.a)) {
                    JSONObject optJSONObject = x53Var.a.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                        n73.T("checkSession", "success");
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                        n73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(x53Var.b());
                    this.a.g(this.b, wrapCallbackParams.toString());
                    n73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "result failed");
                }
                this.b.handleSchemeDispatchCallback(this.c, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bp1(@NonNull vo1 vo1Var) {
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

    public static boolean y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0") : invokeL.booleanValue;
    }

    @Override // com.repackage.xo1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CheckSessionApi" : (String) invokeV.objValue;
    }

    public us1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#checkSession", false);
            n73.T("checkSession", "create");
            fi1 j = ck2.j();
            CallbackHandler i = a().i();
            u03 a0 = u03.a0();
            if (a0 == null) {
                j.g(i, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                n73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty swanApp");
                return new us1(1001, "swan app is null");
            }
            String N = a0.N();
            if (TextUtils.isEmpty(N)) {
                j.g(i, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
                n73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty app key");
                return new us1(1001, "empty app key");
            }
            JSONObject r = xo1.r(str);
            if (r == null) {
                j.g(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                n73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty joParams");
                return new us1(201, "empty joParams");
            }
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j.g(i, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                n73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                return new us1(201, "cb is empty");
            }
            Context context = getContext();
            if (!a0.M().e(context)) {
                j.g(i, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                n73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "account not login");
                return new us1(10004, "user not logged in");
            }
            n73.T("checkSession", "checkSession");
            a63 g = t03.J().y().a().b().g(context, N);
            g.q("checkSession");
            g.o(new a(this, j, i, optString));
            g.call();
            return new us1(0);
        }
        return (us1) invokeL.objValue;
    }
}
