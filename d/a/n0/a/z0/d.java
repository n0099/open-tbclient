package d.a.n0.a.z0;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.c0.c.f.a;
import d.a.n0.a.c2.f.a0;
import d.a.n0.a.g1.f;
import d.a.n0.a.h0.g.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements a.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48614a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f48615b;

        public a(d dVar, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48615b = dVar;
            this.f48614a = callbackHandler;
        }

        @Override // d.a.n0.a.c0.c.f.a.g
        public void a(String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, jSONObject) == null) {
                this.f48615b.k(this.f48614a, 0, str, jSONObject);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/openInput");
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
            if (a0.f43581b) {
                Log.d("OpenInputAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            f V = f.V();
            if (optParamsAsJo == null) {
                d.a.n0.a.e0.d.b("openInput", "paramsJson is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            g W = V.W();
            if (W == null) {
                d.a.n0.a.e0.d.b("openInput", "fragmentManager is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragmentManager is null");
                return false;
            }
            SwanAppActivity activity = f.V().getActivity();
            if (activity == null) {
                d.a.n0.a.e0.d.b("openInput", "activity is null when add input");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "activity is null when add input");
                return false;
            }
            d.a.n0.a.h0.g.f o = W.o();
            if (o == null) {
                d.a.n0.a.e0.d.b("openInput", "fragment is null when add input");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "fragment is null when add input");
                return false;
            }
            d.a.n0.a.c0.c.f.b bVar = new d.a.n0.a.c0.c.f.b();
            try {
                bVar.a(optParamsAsJo);
            } catch (JSONException e2) {
                e2.printStackTrace();
                d.a.n0.a.e0.d.c("OpenInputAction", "model parse exception:", e2);
            }
            boolean a2 = new d.a.n0.a.c0.c.f.a(context, bVar, activity, o, new a(this, callbackHandler)).w().a();
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(a2 ? 0 : 1001));
            return a2;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(CallbackHandler callbackHandler, int i2, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, callbackHandler, i2, str, jSONObject) == null) {
            if (a0.f43581b) {
                Log.d("OpenInputAction", "sendAsyncCallback, arg0: " + i2 + ", arg1: " + jSONObject);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString());
        }
    }
}
