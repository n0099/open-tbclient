package d.a.n0.a.c2.f.r0;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.c2.f.a0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.a.p.e.e f43897c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/webviewPostMessage");
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
                Log.d("WebViewPostMsgAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            d.a.n0.a.e0.d.g("webviewPostMsg", "start post webview msg");
            d.a.n0.a.p.e.e eVar2 = this.f43897c;
            if (eVar2 == null) {
                d.a.n0.a.e0.d.b("webviewPostMsg", "none webview widget");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none webview widget");
                return false;
            }
            d params = eVar2.getParams();
            if (params == null) {
                d.a.n0.a.e0.d.b("webviewPostMsg", "none WWWParams");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "none WWWParams");
                return false;
            }
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                d.a.n0.a.e0.d.b("webviewPostMsg", "none params");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none params");
                return false;
            } else if (!a2.has("data")) {
                d.a.n0.a.e0.d.b("webviewPostMsg", "none param data");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "none param data");
                return false;
            } else {
                String optString = a2.optString("data");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("data", optString);
                    jSONObject.put("eventType", "message");
                    jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, params.f43478g);
                    jSONObject.put("webviewId", params.f43477f);
                } catch (JSONException e2) {
                    if (a0.f43581b) {
                        e2.printStackTrace();
                    }
                    d.a.n0.a.e0.d.b("webviewPostMsg", "meet json exception");
                }
                d.a.n0.a.w2.g.c.a.c(params.f43478g, params.f43477f, "webview", "message", jSONObject);
                d.a.n0.a.e0.d.g("webviewPostMsg", "post webview msg success");
                unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public void j(d.a.n0.a.p.e.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) {
            this.f43897c = eVar;
        }
    }
}
