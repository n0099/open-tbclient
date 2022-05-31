package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m43;
import com.repackage.pn1;
import com.repackage.q43;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bh3 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ String d;
        public final /* synthetic */ hz2 e;
        public final /* synthetic */ pn1.d f;
        public final /* synthetic */ Bundle g;
        public final /* synthetic */ bh3 h;

        public a(bh3 bh3Var, CallbackHandler callbackHandler, String str, Context context, String str2, hz2 hz2Var, pn1.d dVar, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh3Var, callbackHandler, str, context, str2, hz2Var, dVar, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = bh3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = context;
            this.d = str2;
            this.e = hz2Var;
            this.f = dVar;
            this.g = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (f43.h(k43Var)) {
                    if (this.h.o(this.c, this.d)) {
                        this.h.m(this.e, (Activity) this.c, this.f, this.a, this.b, this.g);
                        return;
                    } else {
                        this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(10008, "app not installed").toString());
                        return;
                    }
                }
                f43.q(k43Var, this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements ae3<k43<q43.d>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pn1.d a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ String c;

        public b(bh3 bh3Var, pn1.d dVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh3Var, dVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
            this.b = callbackHandler;
            this.c = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<q43.d> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (!k43Var.c()) {
                    hw1.o("ThirdPartyLoginAction", k43Var.b() + " " + this.a.toString());
                    String f = f43.f(k43Var.b());
                    if (!TextUtils.isEmpty(f)) {
                        this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(k43Var.b(), f).toString());
                    } else {
                        this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(k43Var.b()).toString());
                    }
                } else if (TextUtils.isEmpty(k43Var.a.a)) {
                    this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
                } else {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("code", k43Var.a.a);
                        this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(jSONObject, k43Var.b()).toString());
                    } catch (JSONException e) {
                        if (e13.b) {
                            e.printStackTrace();
                        }
                        this.b.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(1001, e.getMessage()).toString());
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh3(e03 e03Var) {
        super(e03Var, "/swanAPI/thirdPartyLogin");
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
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            if (hz2Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("type", "");
            int n = n(optString2);
            pn1.d dVar = new pn1.d(optParamsAsJo);
            Bundle bundle = new Bundle();
            bundle.putInt("key_login_mode", n);
            hz2Var.d0().g(context, "mapp_i_login", new a(this, callbackHandler, optString, context, optString2, hz2Var, dVar, bundle));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void m(hz2 hz2Var, Activity activity, pn1.d dVar, CallbackHandler callbackHandler, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{hz2Var, activity, dVar, callbackHandler, str, bundle}) == null) {
            hz2Var.d0().r(activity, dVar, bundle, new b(this, dVar, callbackHandler, str), "SwanThirdPartLogin");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int n(String str) {
        InterceptResult invokeL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            switch (str.hashCode()) {
                case -791575966:
                    if (str.equals(ThirdPartyUtil.TYPE_WEIXIN)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -265713450:
                    if (str.equals("username")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 3616:
                    if (str.equals(LoginConstants.QQ_LOGIN)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 114009:
                    if (str.equals(LoginConstants.SMS_LOGIN)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 113011944:
                    if (str.equals("weibo")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        return 2;
                    }
                    if (c == 3) {
                        return 3;
                    }
                    if (c == 4) {
                        return 4;
                    }
                }
                return 1;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean o(Context context, String str) {
        InterceptResult invokeLL;
        char c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            switch (str.hashCode()) {
                case -791575966:
                    if (str.equals(ThirdPartyUtil.TYPE_WEIXIN)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -265713450:
                    if (str.equals("username")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 3616:
                    if (str.equals(LoginConstants.QQ_LOGIN)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 114009:
                    if (str.equals(LoginConstants.SMS_LOGIN)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 113011944:
                    if (str.equals("weibo")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c != 2) {
                        return c == 3 || c == 4;
                    }
                    return bd3.F(context, "com.sina.weibo");
                }
                return bd3.F(context, "com.tencent.mobileqq");
            }
            return bd3.F(context, "com.tencent.mm");
        }
        return invokeLL.booleanValue;
    }
}
