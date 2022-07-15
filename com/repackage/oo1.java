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
public class oo1 extends mo1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements af3<k53<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sh1 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;

        public a(oo1 oo1Var, sh1 sh1Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oo1Var, sh1Var, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sh1Var;
            this.b = callbackHandler;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<JSONObject> k53Var) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (k53Var.c() && oo1.y(k53Var.a)) {
                    JSONObject optJSONObject = k53Var.a.optJSONObject("data");
                    if (optJSONObject != null && optJSONObject.optBoolean("result")) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                        a73.T("checkSession", "success");
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                        a73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(k53Var.b());
                    this.a.g(this.b, wrapCallbackParams.toString());
                    a73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "result failed");
                }
                this.b.handleSchemeDispatchCallback(this.c, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oo1(@NonNull io1 io1Var) {
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

    public static boolean y(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) ? jSONObject != null && TextUtils.equals(jSONObject.optString("errno"), "0") : invokeL.booleanValue;
    }

    @Override // com.repackage.ko1
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "CheckSessionApi" : (String) invokeV.objValue;
    }

    public hs1 x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#checkSession", false);
            a73.T("checkSession", "create");
            sh1 j = pj2.j();
            CallbackHandler h = a().h();
            h03 b0 = h03.b0();
            if (b0 == null) {
                j.g(h, UnitedSchemeUtility.wrapCallbackParams(1001, "swan app is null").toString());
                a73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty swanApp");
                return new hs1(1001, "swan app is null");
            }
            String O = b0.O();
            if (TextUtils.isEmpty(O)) {
                j.g(h, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
                a73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty app key");
                return new hs1(1001, "empty app key");
            }
            JSONObject r = ko1.r(str);
            if (r == null) {
                j.g(h, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                a73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty joParams");
                return new hs1(201, "empty joParams");
            }
            String optString = r.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                j.g(h, UnitedSchemeUtility.wrapCallbackParams(201, "cb is empty").toString());
                a73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "empty cb");
                return new hs1(201, "cb is empty");
            }
            Context context = getContext();
            if (!b0.N().e(context)) {
                j.g(h, UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in").toString());
                a73.U("checkSession", com.baidu.pass.biometrics.face.liveness.b.a.g0, "account not login");
                return new hs1(10004, "user not logged in");
            }
            a73.T("checkSession", "checkSession");
            n53 g = g03.K().x().a().b().g(context, O);
            g.q("checkSession");
            g.o(new a(this, j, h, optString));
            g.call();
            return new hs1(0);
        }
        return (hs1) invokeL.objValue;
    }
}
