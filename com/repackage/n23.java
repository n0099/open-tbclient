package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.favordata.SwanFavorDataManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n23 extends l23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements bc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h03 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ String d;
        public final /* synthetic */ n23 e;

        public a(n23 n23Var, h03 h03Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {n23Var, h03Var, callbackHandler, unitedSchemeEntity, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = n23Var;
            this.a = h03Var;
            this.b = callbackHandler;
            this.c = unitedSchemeEntity;
            this.d = str;
        }

        @Override // com.repackage.bc2
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.e.d) {
                    zz2 f = zz2.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f131d);
                    f.l(2);
                    f.G();
                }
                this.e.n(this.c, this.b, this.d);
            }
        }

        @Override // com.repackage.bc2
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("success", "1");
                } catch (JSONException e) {
                    if (rg1.a) {
                        e.printStackTrace();
                    }
                }
                if (this.e.d) {
                    l23.m("0", "btn", "success");
                    zz2 f = zz2.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f010f);
                    f.l(2);
                    f.G();
                }
                UnitedSchemeUtility.safeCallback(this.b, this.c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.d);
            }
        }

        @Override // com.repackage.bc2
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (this.e.d && !z) {
                    zz2 f = zz2.f(this.a.getApplicationContext(), R.string.obfuscated_res_0x7f0f010e);
                    f.l(2);
                    f.G();
                }
                this.e.n(this.c, this.b, this.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n23(e13 e13Var) {
        super(e13Var, "/swanAPI/deleteFavor");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((e13) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.l23
    public boolean j(h03 h03Var, UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, h03Var, unitedSchemeEntity)) == null) {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                return false;
            }
            try {
                String O = this.d ? h03Var.O() : new JSONObject(param).optString("appid");
                this.c = O;
                return !TextUtils.isEmpty(O);
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // com.repackage.l23
    public void k(h03 h03Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, h03Var, unitedSchemeEntity, callbackHandler, str) == null) {
            if (this.d) {
                l23.m("0", "btn", "invoke");
            } else {
                l23.m("0", "api", "invoke");
            }
            SwanFavorDataManager h = SwanFavorDataManager.h();
            String str2 = this.c;
            a aVar = new a(this, h03Var, callbackHandler, unitedSchemeEntity, str);
            ca2 l = ca2.l();
            l.n(3);
            h.c(str2, aVar, l.k());
        }
    }

    @Override // com.repackage.l23
    public void l(h03 h03Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        wk1 l0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, h03Var, unitedSchemeEntity, callbackHandler, str) == null) && this.d && (l0 = oj2.l0()) != null) {
            l0.e(h03Var);
        }
    }
}
