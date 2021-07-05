package d.a.q0.a.e2.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
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
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<d.a.q0.a.e2.c.i<JSONObject>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47528e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47529f;

        public a(b bVar, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, callbackHandler, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47528e = callbackHandler;
            this.f47529f = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.q0.a.e2.c.i<JSONObject> iVar) {
            JSONObject wrapCallbackParams;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (iVar.c() && d.a.q0.a.u.e.a.b.s(iVar.f47670a)) {
                    JSONObject optJSONObject = iVar.f47670a.optJSONObject("data");
                    if (optJSONObject.optBoolean("result")) {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(optJSONObject, 0);
                    } else {
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "session key expired");
                    }
                } else {
                    wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(iVar.b());
                    d.a.q0.a.c1.b.j().g(this.f47528e, wrapCallbackParams.toString());
                }
                this.f47528e.handleSchemeDispatchCallback(this.f47529f, wrapCallbackParams.toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/checkSession");
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
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                d.a.q0.a.c1.b.j().g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp").toString());
                return false;
            }
            String D = eVar.D();
            if (TextUtils.isEmpty(D)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key");
                d.a.q0.a.c1.b.j().g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(1001, "empty app key").toString());
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                d.a.q0.a.c1.b.j().g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams").toString());
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                d.a.q0.a.c1.b.j().g(callbackHandler, UnitedSchemeUtility.wrapCallbackParams(201, "empty cb").toString());
                return false;
            } else if (!eVar.j().e(context)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(10004, "user not logged in");
                d.a.q0.a.c1.b.j().g(callbackHandler, unitedSchemeEntity.result.toString());
                return true;
            } else {
                d.a.q0.a.e2.c.j.c g2 = d.a.q0.a.a2.d.g().y().a().b().g((Activity) context, D);
                g2.r("checkSession");
                g2.p(new a(this, callbackHandler, optString));
                g2.a();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
