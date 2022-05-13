package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.o72;
import com.repackage.z53;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class tb2 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class a implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ JSONObject c;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callbackHandler, unitedSchemeEntity, jSONObject};
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
            this.b = unitedSchemeEntity;
            this.c = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (!s53.h(x53Var)) {
                    s53.p(x53Var, this.a, this.b);
                    return;
                }
                if (this.c.has("emitLive")) {
                    tw2.Q(ib2.b(this.c.optInt("emitLive")));
                }
                if (this.c.has("emitHttps")) {
                    tw2.N(ib2.b(this.c.optInt("emitHttps")));
                }
                if (this.c.has("emitDomain")) {
                    tw2.T(!ib2.b(this.c.optInt("emitDomain")));
                    tw2.W(!ib2.b(this.c.optInt("emitDomain")));
                }
                if (this.c.has("emitWss")) {
                    tw2.P(ib2.b(this.c.optInt("emitWss")));
                }
                if (this.c.has("emitLaunchMode")) {
                    tw2.U(ib2.b(this.c.optInt("emitLaunchMode")));
                }
                if (this.c.has("debugEnvData")) {
                    tw2.K(this.c.optString("debugEnvData"));
                }
                if (this.c.has("emitReplaceJsNative")) {
                    tw2.O(ib2.b(this.c.optInt("emitReplaceJsNative")));
                }
                if (this.c.has("emitReplaceV8Core")) {
                    o72.v.e(o72.v.b(this.c.optInt("emitReplaceV8Core")));
                }
                if (this.c.has("emitHostEnv")) {
                    tw2.S(this.c.optInt("emitHostEnv"));
                }
                if (this.c.has("openStabilityCollector")) {
                    nb2.b(ib2.b(this.c.optInt("openStabilityCollector")));
                }
                if (this.c.has("openPerformanceTesting")) {
                    mb2.b(ib2.b(this.c.optInt("openPerformanceTesting")));
                }
                UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(0));
                tw2.Z();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tb2(r13 r13Var) {
        super(r13Var, "/swanAPI/debug/setDebugConfig");
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

    public static boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, JSONObject jSONObject) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65537, null, context, unitedSchemeEntity, callbackHandler, u03Var, jSONObject)) == null) {
            u03Var.d0().g(context, "mapp_cts_debug", new a(callbackHandler, unitedSchemeEntity, jSONObject));
            return true;
        }
        return invokeLLLLL.booleanValue;
    }

    public static boolean k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject, JSONObject jSONObject2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, unitedSchemeEntity, callbackHandler, jSONObject, jSONObject2)) == null) {
            if (!r23.b) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                return false;
            } else if (!TextUtils.equals(jSONObject.optString("category"), "swanGame")) {
                ux1.c("setDebugConfig", "params is not swangame");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                if (jSONObject2.has("emitHttps")) {
                    tw2.N(ib2.b(jSONObject2.optInt("emitHttps")));
                }
                if (jSONObject2.has("emitWss")) {
                    tw2.P(ib2.b(jSONObject2.optInt("emitWss")));
                }
                if (jSONObject2.has("debugEnvData")) {
                    tw2.K(jSONObject2.optString("debugEnvData"));
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                tw2.Z();
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            JSONObject a2 = r23.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                ux1.c("setDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
            if (optJSONObject == null) {
                ux1.c("setDebugConfig", "config is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            int l = t03.J().l();
            if (l != 0) {
                if (l != 1) {
                    ux1.c("setDebugConfig", "frame type error");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                }
                return k(unitedSchemeEntity, callbackHandler, a2, optJSONObject);
            }
            return j(context, unitedSchemeEntity, callbackHandler, u03Var, optJSONObject);
        }
        return invokeLLLL.booleanValue;
    }
}
