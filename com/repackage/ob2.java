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
import com.repackage.qj2;
import com.repackage.z53;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ob2 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ ob2 d;

        public a(ob2 ob2Var, CallbackHandler callbackHandler, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob2Var, callbackHandler, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ob2Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    this.d.k(this.c, this.b, this.a);
                } else {
                    s53.q(x53Var, this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements qj2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ JSONObject b;
        public final /* synthetic */ String c;

        public b(ob2 ob2Var, CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ob2Var, callbackHandler, jSONObject, str};
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

        @Override // com.repackage.qj2.c
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            }
        }

        @Override // com.repackage.qj2.c
        public void onFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a == null) {
                    ux1.o("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    ux1.c("ExtCore-DebugDownload", "download failed");
                    m03.f(bk2.c(), R.string.obfuscated_res_0x7f0f0124).G();
                    this.b.put("status", -1);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.a.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(this.b, 1001).toString());
            }
        }

        @Override // com.repackage.qj2.c
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.a == null) {
                    ux1.o("ExtCore-DebugDownload", "handler is null");
                    return;
                }
                try {
                    File c = lb2.c();
                    File b = lb2.b();
                    if (c.exists() && xg4.U(c.getPath(), b.getPath())) {
                        ux1.c("ExtCore-DebugDownload", "download success");
                        m03.f(bk2.c(), R.string.obfuscated_res_0x7f0f0125).G();
                        this.b.put("status", 0);
                        this.a.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(this.b, 0).toString());
                    } else {
                        ux1.c("ExtCore-DebugDownload", "download failed");
                        m03.f(bk2.c(), R.string.obfuscated_res_0x7f0f0124).G();
                        this.b.put("status", -1);
                        this.a.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(this.b, 1001).toString());
                    }
                } catch (JSONException e) {
                    ux1.d("ExtCore-DebugDownload", "build result with exception", e);
                    e.printStackTrace();
                    this.a.handleSchemeDispatchCallback(this.c, UnitedSchemeUtility.wrapCallbackParams(this.b, 1001).toString());
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ob2(r13 r13Var) {
        super(r13Var, "/swanAPI/debug/downloadExtension");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var};
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

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            JSONObject a2 = r23.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                ux1.c("ExtCore-DebugDownload", "params is null");
                m03.f(context, R.string.obfuscated_res_0x7f0f0141).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString = a2.optString("url");
            if (TextUtils.isEmpty(optString)) {
                ux1.c("ExtCore-DebugDownload", "url is null");
                m03.f(context, R.string.obfuscated_res_0x7f0f0116).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            String optString2 = a2.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                ux1.c("ExtCore-DebugDownload", "cb is null");
                m03.f(context, R.string.obfuscated_res_0x7f0f0123).G();
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "illegal cb");
                return false;
            }
            u03Var.d0().g(context, "mapp_cts_debug", new a(this, callbackHandler, optString2, optString));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(String str, String str2, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, callbackHandler) == null) {
            qj2.I(str, new b(this, callbackHandler, new JSONObject(), str2));
        }
    }
}
