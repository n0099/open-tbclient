package d.a.q0.a.n2.f.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
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
import d.a.q0.a.c2.e;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.e0.d;
import d.a.q0.a.n2.f.a;
import d.a.q0.a.u.e.o.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.q0.a.n2.f.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0892a implements a.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49737a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49738b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f49739c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f49740d;

        public C0892a(a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, unitedSchemeEntity, callbackHandler, lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49740d = aVar;
            this.f49737a = unitedSchemeEntity;
            this.f49738b = callbackHandler;
            this.f49739c = lVar;
        }

        @Override // d.a.q0.a.n2.f.a.c
        public void a(float f2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
                d.g("compass", "handle compass change, angle:" + f2 + ",accuracy: " + i2);
                this.f49740d.k(this.f49737a, this.f49738b, this.f49739c, f2, i2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar) {
        super(eVar, "/swanAPI/startCompass");
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
                d.b("compass", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (a0.f46883b) {
                    Log.d("SwanAppAction", "startCompass --- illegal swanApp");
                }
                return false;
            } else if (context == null) {
                d.b("compass", "none context");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal context");
                if (a0.f46883b) {
                    Log.d("SwanAppAction", "startCompass --- illegal context");
                }
                return false;
            } else {
                JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
                if (optParamsAsJo == null) {
                    if (a0.f46883b) {
                        Log.d("SwanAppAction", "startCompass --- params is empty");
                    }
                    d.b("compass", "none params");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                    return false;
                }
                String optString = optParamsAsJo.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (a0.f46883b) {
                        Log.d("SwanAppAction", "startCompass --- cb is empty");
                    }
                    d.b("compass", "cb is empty");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                    return false;
                }
                d.g("compass", "init");
                l lVar = new l("compassChange", optParamsAsJo, optString);
                d.a.q0.a.n2.f.a i2 = d.a.q0.a.n2.f.a.i();
                i2.l(context);
                i2.o(new C0892a(this, unitedSchemeEntity, callbackHandler, lVar));
                d.g("compass", "start listen compass");
                i2.p();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                lVar.a(unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, l lVar, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{unitedSchemeEntity, callbackHandler, lVar, Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("direction", f2);
                jSONObject.put("accuracy", d.a.q0.a.n2.f.a.h(i2));
                if (a0.f46883b) {
                    Log.d("SwanAppAction", "compassAngle : " + jSONObject.toString());
                }
                lVar.c(unitedSchemeEntity, callbackHandler, jSONObject);
            } catch (JSONException e2) {
                d.b("compass", "handle compass,json error，" + e2.toString());
                lVar.e(unitedSchemeEntity, callbackHandler, "Json error");
            }
        }
    }
}
