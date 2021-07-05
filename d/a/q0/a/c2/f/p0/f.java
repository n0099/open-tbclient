package d.a.q0.a.c2.f.p0;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import com.baidu.tbadk.browser.BaseWebViewActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.v2.q0;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47112a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47113b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f47114c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f47115d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f47116e;

        public a(f fVar, String str, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, callbackHandler, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47116e = fVar;
            this.f47112a = str;
            this.f47113b = callbackHandler;
            this.f47114c = eVar;
            this.f47115d = str2;
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
                this.f47113b.handleSchemeDispatchCallback(this.f47112a, UnitedSchemeUtility.wrapCallbackParams(501, "网络异常").toString());
                d.a.q0.a.j2.q.a.b(SwanInterfaceType.NAVIGATE, 2101, this.f47115d, null, exc.getMessage());
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i2) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i2)) == null) {
                this.f47116e.n(response, this.f47112a, this.f47113b, this.f47114c);
                return response;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d.a.q0.a.c2.e eVar) {
        super(eVar, "/swanAPI/navigateToProgram");
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
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            } else if (eVar.d0()) {
                if (a0.f46883b) {
                    Log.d("NavigateToSmartProgram", "NavigateToSmartProgram does not supported when app is invisible.");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
                return false;
            } else {
                String D = eVar.D();
                if (!TextUtils.isEmpty(D) && !TextUtils.isEmpty(D.trim())) {
                    String optString = optParamsAsJo.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    } else if (TextUtils.equals(d.a.q0.a.v.a.a(optParamsAsJo.optString("appKey")), D)) {
                        if (callbackHandler != null) {
                            callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(202, "The target program is running now.").toString());
                        }
                        return true;
                    } else {
                        String appId = eVar.getAppId();
                        if (!TextUtils.isEmpty(appId) && !TextUtils.isEmpty(appId.trim())) {
                            Request l = l(appId, optParamsAsJo);
                            if (l == null) {
                                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                                return false;
                            }
                            m(l.body(), unitedSchemeEntity, optString, callbackHandler, eVar);
                            return true;
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                        return false;
                    }
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final Uri k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            String schemeHead = SchemeConfig.getSchemeHead();
            if (TextUtils.isEmpty(schemeHead)) {
                schemeHead = BaseWebViewActivity.SHOUBAI_SCHEME;
            }
            buildUpon.scheme(schemeHead);
            if (a0.f46883b) {
                Log.i("NavigateToSmartProgram", buildUpon.build().toString());
            }
            return buildUpon.build();
        }
        return (Uri) invokeL.objValue;
    }

    public final Request l(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject)) == null) {
            if (jSONObject != null && !TextUtils.isEmpty(str)) {
                String e2 = d.a.q0.a.l1.b.e(q0.n());
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("app_key", str);
                    jSONObject2.put("srcAppPage", e2);
                    jSONObject2.put("params", jSONObject);
                    Request build = new Request.Builder().url(d.a.q0.a.c1.a.n().F()).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject2.toString())).build();
                    if (a0.f46883b) {
                        Log.i("NavigateToSmartProgram", "appId :" + str + "\nrequest params" + jSONObject2.toString());
                    }
                    return build;
                } catch (Exception e3) {
                    if (a0.f46883b) {
                        e3.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (Request) invokeLL.objValue;
    }

    public final void m(RequestBody requestBody, UnitedSchemeEntity unitedSchemeEntity, String str, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, requestBody, unitedSchemeEntity, str, callbackHandler, eVar) == null) {
            String F = d.a.q0.a.c1.a.n().F();
            d.a.q0.m.d.a aVar = new d.a.q0.m.d.a(F, requestBody, new a(this, str, callbackHandler, eVar, F));
            aVar.f53900f = true;
            aVar.f53901g = false;
            aVar.f53902h = true;
            d.a.q0.m.e.a.g().e(aVar);
            d.a.q0.a.j2.q.a.a(SwanInterfaceType.NAVIGATE);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        }
    }

    public final void n(Response response, String str, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, response, str, callbackHandler, eVar) == null) {
            try {
                if (!response.isSuccessful()) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    d.a.q0.a.j2.q.a.c(SwanInterfaceType.NAVIGATE, 2104, null, response);
                    return;
                }
                String string = response.body().string();
                JSONObject jSONObject = new JSONObject(string);
                if (!TextUtils.equals(jSONObject.optString("errno"), "0")) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    d.a.q0.a.j2.q.a.c(SwanInterfaceType.NAVIGATE, jSONObject.optInt("errno", 2103), string, response);
                    return;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject == null) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                    return;
                }
                Uri k = k(optJSONObject.optString("scheme"));
                if (k == null) {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(402).toString());
                } else {
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(SchemeRouter.invokeScheme(eVar.getApplicationContext(), k, UnitedSchemeConstants.SCHEME_INVOKE_TYPE_INSIDE) ? 0 : 1001).toString());
                }
            } catch (Exception e2) {
                if (a0.f46883b) {
                    Log.d("NavigateToSmartProgram", e2.getMessage());
                }
                callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(201, e2.getMessage()).toString());
                d.a.q0.a.j2.q.a.c(SwanInterfaceType.NAVIGATE, 2103, e2.getMessage(), null);
            }
        }
    }
}
