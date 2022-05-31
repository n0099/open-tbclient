package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class k13 extends l13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements ab2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hz2 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ k13 e;

        public a(k13 k13Var, hz2 hz2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k13Var, hz2Var, callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = k13Var;
            this.a = hz2Var;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
            this.d = str;
        }

        @Override // com.repackage.ab2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.e.d) {
                    zy2 f = zy2.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f1317);
                    f.l(2);
                    f.G();
                }
                this.e.n(this.c, this.b, this.d);
            }
        }

        @Override // com.repackage.ab2
        public void b(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                if (this.e.d && !z) {
                    zy2 f = zy2.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f0155);
                    f.l(2);
                    f.G();
                }
                this.e.n(this.c, this.b, this.d);
            }
        }

        @Override // com.repackage.ab2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e) {
                    if (rf1.a) {
                        e.printStackTrace();
                    }
                }
                if (this.e.d) {
                    l13.m("1", "btn", "success");
                    f62.t();
                    if (xo2.k(this.a.x())) {
                        xo2.p("addmyswan", bd3.n().e());
                    } else {
                        Context applicationContext = this.a.getApplicationContext();
                        zy2 g = zy2.g(applicationContext, oi2.l0().f(applicationContext));
                        g.l(2);
                        g.q(2);
                        g.G();
                    }
                }
                UnitedSchemeUtility.safeCallback(this.b, this.c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k13(e03 e03Var) {
        super(e03Var, "/swanAPI/addFavor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((e03) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.l13
    public boolean j(hz2 hz2Var, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, hz2Var, unitedSchemeEntity)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                return false;
            }
            try {
                String N = this.d ? hz2Var.N() : new JSONObject(param).optString("appid");
                this.c = N;
                return !TextUtils.isEmpty(N);
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.l13
    public void k(hz2 hz2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hz2Var, unitedSchemeEntity, callbackHandler, str) == null) {
            PMSAppInfo u = c74.i().u(this.c);
            if (u != null && !TextUtils.isEmpty(u.appId)) {
                if (this.d) {
                    l13.m("1", "btn", "invoke");
                } else {
                    l13.m("1", RetrieveTaskManager.KEY, "invoke");
                }
                SwanFavorDataManager.h().b(this.c, new a(this, hz2Var, callbackHandler, unitedSchemeEntity, str));
                return;
            }
            n(unitedSchemeEntity, callbackHandler, str);
        }
    }

    @Override // com.repackage.l13
    public void l(hz2 hz2Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        wj1 l0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, hz2Var, unitedSchemeEntity, callbackHandler, str) == null) && this.d && (l0 = oi2.l0()) != null) {
            l0.g(hz2Var);
        }
    }
}
