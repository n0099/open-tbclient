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
/* loaded from: classes6.dex */
public class on1 extends mn1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ae3<k43<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg1 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;

        public a(on1 on1Var, sg1 sg1Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on1Var, sg1Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg1Var;
            this.b = callbackHandler;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<JSONObject> k43Var) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (k43Var.c() && on1.y(k43Var.a)) {
                    JSONObject optJSONObject = k43Var.a.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                        a63.T("checkSession", "success");
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                        a63.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(k43Var.b());
                    this.a.g(this.b, wrapCallbackParams.toString());
                    a63.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "result failed");
                }
                this.b.handleSchemeDispatchCallback(this.c, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public on1(@NonNull in1 in1Var) {
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

    public static boolean y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0") : invokeL.booleanValue;
    }

    @Override // com.repackage.kn1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CheckSessionApi" : (String) invokeV.objValue;
    }

    public hr1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#checkSession", false);
            a63.T("checkSession", "create");
            sg1 j = pi2.j();
            CallbackHandler i = a().i();
            hz2 a0 = hz2.a0();
            if (a0 == null) {
                j.g(i, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                a63.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty swanApp");
                return new hr1(1001, "swan app is null");
            }
            String N = a0.N();
            if (TextUtils.isEmpty(N)) {
                j.g(i, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
                a63.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty app key");
                return new hr1(1001, "empty app key");
            }
            JSONObject r = kn1.r(str);
            if (r == null) {
                j.g(i, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                a63.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty joParams");
                return new hr1(201, "empty joParams");
            }
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j.g(i, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                a63.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                return new hr1(201, "cb is empty");
            }
            Context context = getContext();
            if (!a0.M().e(context)) {
                j.g(i, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                a63.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "account not login");
                return new hr1(10004, "user not logged in");
            }
            a63.T("checkSession", "checkSession");
            n43 g = gz2.J().y().a().b().g(context, N);
            g.q("checkSession");
            g.o(new a(this, j, i, optString));
            g.call();
            return new hr1(0);
        }
        return (hr1) invokeL.objValue;
    }
}
