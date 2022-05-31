package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.di2;
import com.repackage.m43;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ba2 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ba2 d;

        public a(ba2 ba2Var, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ba2Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (f43.h(k43Var)) {
                    this.d.k(this.c, this.b, this.a);
                } else {
                    f43.q(k43Var, this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements di2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;

        public b(ba2 ba2Var, CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba2Var, callbackHandler, jSONObject, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = callbackHandler;
            this.b = jSONObject;
            this.c = str;
        }

        @Override // com.repackage.di2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.repackage.di2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a == null) {
                    hw1.o("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    hw1.c("ExtCore-DebugDownload", "download failed");
                    zy2.f(oi2.c(), R.string.obfuscated_res_0x7f0f0125).G();
                    this.b.put("status", -1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.a.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(this.b, 1001).toString());
            }
        }

        @Override // com.repackage.di2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a == null) {
                    hw1.o("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    File c = y92.c();
                    File b = y92.b();
                    if (c.exists() && kf4.U(c.getPath(), b.getPath())) {
                        hw1.c("ExtCore-DebugDownload", "download success");
                        zy2.f(oi2.c(), R.string.obfuscated_res_0x7f0f0126).G();
                        this.b.put("status", 0);
                        this.a.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(this.b, 0).toString());
                    } else {
                        hw1.c("ExtCore-DebugDownload", "download failed");
                        zy2.f(oi2.c(), R.string.obfuscated_res_0x7f0f0125).G();
                        this.b.put("status", -1);
                        this.a.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(this.b, 1001).toString());
                    }
                } catch (JSONException e) {
                    hw1.d("ExtCore-DebugDownload", "build result with exception", e);
                    e.printStackTrace();
                    this.a.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(this.b, 1001).toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ba2(e03 e03Var) {
        super(e03Var, "/swanAPI/debug/downloadExtension");
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
            JSONObject a2 = e13.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                hw1.c("ExtCore-DebugDownload", "params is null");
                zy2.f(context, R.string.obfuscated_res_0x7f0f0142).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString = a2.optString("url");
            if (TextUtils.isEmpty(optString)) {
                hw1.c("ExtCore-DebugDownload", "url is null");
                zy2.f(context, R.string.obfuscated_res_0x7f0f0117).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = a2.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                hw1.c("ExtCore-DebugDownload", "cb is null");
                zy2.f(context, R.string.obfuscated_res_0x7f0f0124).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
                return false;
            }
            hz2Var.d0().g(context, "mapp_cts_debug", new a(this, callbackHandler, optString2, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, callbackHandler) == null) {
            di2.I(str, new b(this, callbackHandler, new JSONObject(), str2));
        }
    }
}
