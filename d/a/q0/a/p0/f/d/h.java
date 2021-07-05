package d.a.q0.a.p0.f.d;

import android.content.Context;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.e2.c.j.b;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50008e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f50009f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50010g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Context f50011h;

        public a(h hVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, callbackHandler, unitedSchemeEntity, jSONObject, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50008e = callbackHandler;
            this.f50009f = unitedSchemeEntity;
            this.f50010g = jSONObject;
            this.f50011h = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (!d.a.q0.a.e2.c.d.h(iVar)) {
                    d.a.q0.a.e2.c.d.o(iVar, this.f50008e, this.f50009f);
                    return;
                }
                boolean b2 = d.a.q0.a.p0.f.a.b(this.f50010g.optInt("useExtension"));
                if (b2 && !d.a.q0.a.p0.f.c.b().exists()) {
                    d.a.q0.a.z1.b.f.e.f(AppRuntime.getAppContext(), d.a.q0.a.h.aiapps_debug_no_extension_core).F();
                    this.f50009f.result = UnitedSchemeUtility.wrapCallbackParams(1001, this.f50011h.getResources().getString(d.a.q0.a.h.aiapps_debug_no_extension_core));
                    return;
                }
                d.a.q0.a.u1.a.a.T(b2);
                UnitedSchemeUtility.callCallback(this.f50008e, this.f50009f, UnitedSchemeUtility.wrapCallbackParams(0));
                d.a.q0.a.u1.a.a.X();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/debug/setExtensionConfig");
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

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.q0.a.e0.d.b("ExtCore-SetConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!a2.has("useExtension")) {
                d.a.q0.a.e0.d.b("ExtCore-SetConfig", "useExtension is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                eVar.T().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2, context));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
