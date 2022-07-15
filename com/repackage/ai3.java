package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.StringResponseCallback;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ai3 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int c;

    /* loaded from: classes5.dex */
    public class a implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ ai3 d;

        public a(ai3 ai3Var, CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ai3Var, callbackHandler, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ai3Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = jSONObject;
        }

        @Override // com.repackage.ai3.c
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject == null) {
                    this.d.p(this.a, this.b, this.c);
                    return;
                }
                ai3 ai3Var = this.d;
                ai3Var.c = ai3Var.m(jSONObject);
                this.d.p(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends StringResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(ai3 ai3Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ai3Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        /* renamed from: a */
        public void onSuccess(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                try {
                    this.a.a(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                    this.a.a(null);
                }
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, exc) == null) {
                this.a.a(null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(JSONObject jSONObject);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai3(e13 e13Var) {
        super(e13Var, "/swanAPI/privateGetUserInfo");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e13Var};
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
        this.c = -1;
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (h03Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
                return false;
            }
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            try {
                o(context, callbackHandler, h03Var, optString);
            } catch (JSONException unused) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final int m(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject)) == null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                JSONArray optJSONArray = jSONObject.optJSONArray("data");
                if (optJSONObject == null) {
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        optJSONObject = optJSONArray.getJSONObject(0);
                    } else {
                        if (e23.b) {
                            Log.d(BaseJsonData.TAG, "Invalid data field!");
                        }
                        optJSONObject = null;
                    }
                }
                if (optJSONObject == null || (jSONObject2 = optJSONObject.getJSONObject("userx")) == null || (jSONObject3 = jSONObject2.getJSONObject(Config.EVENT_ATTR)) == null || (jSONObject4 = jSONObject3.getJSONObject(ActionJsonData.TAG_DATASET)) == null) {
                    return -1;
                }
                return jSONObject4.optInt("gender");
            } catch (JSONException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public final void n(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gender", "1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(dx1.v(gg3.c()))).addParam("data", jSONObject.toString()).cookieManager(oj2.q().a())).build().executeAsync(new b(this, cVar));
    }

    public final void o(Context context, CallbackHandler callbackHandler, h03 h03Var, String str) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, context, callbackHandler, h03Var, str) == null) {
            String y = hg3.y(context);
            if (!TextUtils.isEmpty(hg3.i(context)) && !TextUtils.isEmpty(y)) {
                JSONObject jSONObject = new JSONObject();
                hh3 g = hg3.g(context);
                jSONObject.put("displayname", g.a);
                jSONObject.put("portrait", g.b);
                if (this.c != -1) {
                    p(callbackHandler, str, jSONObject);
                    return;
                } else {
                    n(new a(this, callbackHandler, str, jSONObject));
                    return;
                }
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(10003).toString());
        }
    }

    public final void p(CallbackHandler callbackHandler, String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, callbackHandler, str, jSONObject) == null) {
            int i = this.c;
            if (i != -1) {
                try {
                    jSONObject.put("gender", String.valueOf(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }
}
