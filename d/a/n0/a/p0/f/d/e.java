package d.a.n0.a.p0.f.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.c2.f.a0;
import d.a.n0.a.e2.c.j.b;
import d.a.n0.a.h0.u.g;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46680e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46681f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46682g;

        public a(e eVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, callbackHandler, unitedSchemeEntity, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46680e = callbackHandler;
            this.f46681f = unitedSchemeEntity;
            this.f46682g = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.a.n0.a.e2.c.d.h(iVar)) {
                    d.a.n0.a.e2.c.d.o(iVar, this.f46680e, this.f46681f);
                    return;
                }
                if (this.f46682g.has("emitLive")) {
                    d.a.n0.a.u1.a.a.P(d.a.n0.a.p0.f.a.b(this.f46682g.optInt("emitLive")));
                }
                if (this.f46682g.has("emitHttps")) {
                    d.a.n0.a.u1.a.a.M(d.a.n0.a.p0.f.a.b(this.f46682g.optInt("emitHttps")));
                }
                if (this.f46682g.has("emitDomain")) {
                    d.a.n0.a.u1.a.a.R(!d.a.n0.a.p0.f.a.b(this.f46682g.optInt("emitDomain")));
                    d.a.n0.a.u1.a.a.U(!d.a.n0.a.p0.f.a.b(this.f46682g.optInt("emitDomain")));
                }
                if (this.f46682g.has("emitWss")) {
                    d.a.n0.a.u1.a.a.O(d.a.n0.a.p0.f.a.b(this.f46682g.optInt("emitWss")));
                }
                if (this.f46682g.has("emitLaunchMode")) {
                    d.a.n0.a.u1.a.a.S(d.a.n0.a.p0.f.a.b(this.f46682g.optInt("emitLaunchMode")));
                }
                if (this.f46682g.has("debugEnvData")) {
                    d.a.n0.a.u1.a.a.J(this.f46682g.optString("debugEnvData"));
                }
                if (this.f46682g.has("emitReplaceJsNative")) {
                    d.a.n0.a.u1.a.a.N(d.a.n0.a.p0.f.a.b(this.f46682g.optInt("emitReplaceJsNative")));
                }
                if (this.f46682g.has("emitReplaceV8Core")) {
                    g.t.e(g.t.b(this.f46682g.optInt("emitReplaceV8Core")));
                }
                UnitedSchemeUtility.callCallback(this.f46680e, this.f46681f, UnitedSchemeUtility.wrapCallbackParams(0));
                d.a.n0.a.u1.a.a.X();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setDebugConfig");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.n0.a.e0.d.b("setDebugConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            JSONObject optJSONObject = a2.optJSONObject("config");
            if (optJSONObject == null) {
                d.a.n0.a.e0.d.b("setDebugConfig", "config is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            if (d.a.n0.a.a2.d.g().l() == 0) {
                eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, optJSONObject));
            } else if (d.a.n0.a.a2.d.g().l() == 1) {
                if (!a0.f43581b) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                    return false;
                } else if (!a2.optString("category").equals("swanGame")) {
                    d.a.n0.a.e0.d.b("setDebugConfig", "params is not swangame");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else {
                    if (optJSONObject.has("emitHttps")) {
                        d.a.n0.a.u1.a.a.M(d.a.n0.a.p0.f.a.b(optJSONObject.optInt("emitHttps")));
                    }
                    if (optJSONObject.has("emitWss")) {
                        d.a.n0.a.u1.a.a.O(d.a.n0.a.p0.f.a.b(optJSONObject.optInt("emitWss")));
                    }
                    if (optJSONObject.has("debugEnvData")) {
                        d.a.n0.a.u1.a.a.J(optJSONObject.optString("debugEnvData"));
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    d.a.n0.a.u1.a.a.X();
                }
            } else {
                d.a.n0.a.e0.d.b("setDebugConfig", "frame type error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }
}
