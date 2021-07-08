package d.a.n0.a.p0.f.d;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.v2.e1.b<d.a.n0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46664e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46665f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f46666g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f46667h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f46668i;

        public a(b bVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, unitedSchemeEntity, jSONObject, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46668i = bVar;
            this.f46664e = callbackHandler;
            this.f46665f = unitedSchemeEntity;
            this.f46666g = jSONObject;
            this.f46667h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r3v14 */
        /* JADX WARN: Type inference failed for: r3v15, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r3v41 */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.n0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.a.n0.a.e2.c.d.h(iVar)) {
                    d.a.n0.a.e2.c.d.o(iVar, this.f46664e, this.f46665f);
                    return;
                }
                try {
                    JSONObject jSONObject = this.f46666g;
                    b bVar = this.f46668i;
                    String string = this.f46667h.getResources().getString(d.a.n0.a.h.aiapps_debug_load_cts);
                    boolean s = d.a.n0.a.u1.a.a.s();
                    d.a.n0.a.p0.f.a.a(s);
                    jSONObject.put("loadCts", bVar.k(string, Integer.valueOf(s ? 1 : 0)));
                    JSONObject jSONObject2 = this.f46666g;
                    b bVar2 = this.f46668i;
                    String string2 = this.f46667h.getResources().getString(d.a.n0.a.h.aiapps_debug_emit_live);
                    boolean r = d.a.n0.a.u1.a.a.r();
                    d.a.n0.a.p0.f.a.a(r);
                    jSONObject2.put("emitLive", bVar2.k(string2, Integer.valueOf(r ? 1 : 0)));
                    JSONObject jSONObject3 = this.f46666g;
                    b bVar3 = this.f46668i;
                    String string3 = this.f46667h.getResources().getString(d.a.n0.a.h.aiapps_debug_emit_https);
                    boolean o = d.a.n0.a.u1.a.a.o();
                    d.a.n0.a.p0.f.a.a(o);
                    jSONObject3.put("emitHttps", bVar3.k(string3, Integer.valueOf(o ? 1 : 0)));
                    JSONObject jSONObject4 = this.f46666g;
                    b bVar4 = this.f46668i;
                    String string4 = this.f46667h.getResources().getString(d.a.n0.a.h.aiapps_debug_use_extension);
                    boolean x = d.a.n0.a.u1.a.a.x();
                    d.a.n0.a.p0.f.a.a(x);
                    jSONObject4.put("useExtension", bVar4.k(string4, Integer.valueOf(x ? 1 : 0)));
                    JSONObject jSONObject5 = this.f46666g;
                    b bVar5 = this.f46668i;
                    String string5 = this.f46667h.getResources().getString(d.a.n0.a.h.aiapps_debug_emit_domain);
                    ?? r3 = (d.a.n0.a.u1.a.a.v() || d.a.n0.a.u1.a.a.z()) ? 0 : 1;
                    d.a.n0.a.p0.f.a.a(r3);
                    jSONObject5.put("emitDomain", bVar5.k(string5, Integer.valueOf((int) r3)));
                    JSONObject jSONObject6 = this.f46666g;
                    b bVar6 = this.f46668i;
                    String string6 = this.f46667h.getResources().getString(d.a.n0.a.h.aiapps_debug_emit_wss);
                    boolean q = d.a.n0.a.u1.a.a.q();
                    d.a.n0.a.p0.f.a.a(q);
                    jSONObject6.put("emitWss", bVar6.k(string6, Integer.valueOf(q ? 1 : 0)));
                    JSONObject jSONObject7 = this.f46666g;
                    b bVar7 = this.f46668i;
                    String string7 = this.f46667h.getResources().getString(d.a.n0.a.h.aiapps_debug_emit_launch_mode);
                    boolean w = d.a.n0.a.u1.a.a.w();
                    d.a.n0.a.p0.f.a.a(w);
                    jSONObject7.put("emitLaunchMode", bVar7.k(string7, Integer.valueOf(w ? 1 : 0)));
                    this.f46666g.put("debugEnvData", this.f46668i.k(this.f46667h.getResources().getString(d.a.n0.a.h.aiapps_debug_game_extra_data), d.a.n0.a.u1.a.a.g()));
                    JSONObject jSONObject8 = this.f46666g;
                    b bVar8 = this.f46668i;
                    String string8 = this.f46667h.getResources().getString(d.a.n0.a.h.aiapps_debug_emit_replace_swan_core);
                    boolean k = d.a.n0.a.u1.a.a.k();
                    d.a.n0.a.p0.f.a.a(k);
                    jSONObject8.put("emitReplaceSwanCore", bVar8.k(string8, Integer.valueOf(k ? 1 : 0)));
                    JSONObject jSONObject9 = this.f46666g;
                    b bVar9 = this.f46668i;
                    String string9 = this.f46667h.getResources().getString(d.a.n0.a.h.aiapps_debug_emit_replace_game_core);
                    boolean h2 = d.a.n0.a.u1.a.a.h();
                    d.a.n0.a.p0.f.a.a(h2);
                    jSONObject9.put("emitReplaceGameCore", bVar9.k(string9, Integer.valueOf(h2 ? 1 : 0)));
                    JSONObject jSONObject10 = this.f46666g;
                    b bVar10 = this.f46668i;
                    String string10 = this.f46667h.getResources().getString(d.a.n0.a.h.aiapps_debug_emit_replace_js_native);
                    boolean p = d.a.n0.a.u1.a.a.p();
                    d.a.n0.a.p0.f.a.a(p);
                    jSONObject10.put("emitReplaceJsNative", bVar10.k(string10, Integer.valueOf(p ? 1 : 0)));
                    boolean d2 = g.t.d();
                    JSONObject jSONObject11 = this.f46666g;
                    b bVar11 = this.f46668i;
                    String string11 = this.f46667h.getResources().getString(d.a.n0.a.h.aiapps_debug_emit_replace_v8_core);
                    d.a.n0.a.p0.f.a.a(d2);
                    jSONObject11.put("emitReplaceV8Core", bVar11.k(string11, Integer.valueOf(d2 ? 1 : 0)));
                    boolean m = d.a.n0.a.p0.f.b.m();
                    JSONObject jSONObject12 = this.f46666g;
                    b bVar12 = this.f46668i;
                    String string12 = this.f46667h.getResources().getString(d.a.n0.a.h.aiapps_debug_emit_replace_dynamic_lib);
                    d.a.n0.a.p0.f.a.a(m);
                    jSONObject12.put("emitReplaceDynamicLib", bVar12.k(string12, Integer.valueOf(m ? 1 : 0)));
                    UnitedSchemeUtility.callCallback(this.f46664e, this.f46665f, UnitedSchemeUtility.wrapCallbackParams(this.f46666g, 0));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    this.f46665f.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/getDebugConfig");
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
            JSONObject jSONObject = new JSONObject();
            d.a.n0.a.e0.d.g("getDebugConfig", "swan getDebugConfig");
            if (d.a.n0.a.a2.d.g().l() == 0) {
                eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, jSONObject, context));
            } else if (d.a.n0.a.a2.d.g().l() == 1) {
                d.a.n0.a.e0.d.g("getDebugConfig", "swangame getDebugConfig");
                if (!a0.f43581b) {
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(302);
                    return false;
                }
                JSONObject a2 = a0.a(unitedSchemeEntity, "params");
                if (a2 == null) {
                    d.a.n0.a.e0.d.b("getDebugConfig", "params is null");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else if (!a2.optString("category").equals("swanGame")) {
                    d.a.n0.a.e0.d.b("getDebugConfig", "params is not swangame");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                    return false;
                } else {
                    try {
                        boolean o = d.a.n0.a.u1.a.a.o();
                        d.a.n0.a.p0.f.a.a(o);
                        jSONObject.put("emitHttps", o ? 1 : 0);
                        boolean q = d.a.n0.a.u1.a.a.q();
                        d.a.n0.a.p0.f.a.a(q);
                        jSONObject.put("emitWss", q ? 1 : 0);
                        jSONObject.put("debugEnvData", d.a.n0.a.u1.a.a.g());
                        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "json exception");
                        return false;
                    }
                }
            } else {
                d.a.n0.a.e0.d.b("getDebugConfig", "frame type error");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "frame type error");
                return false;
            }
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final JSONObject k(String str, Object obj) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj)) == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", str);
            jSONObject.put("value", obj);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
