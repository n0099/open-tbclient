package com.repackage;

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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class eh1 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ch1 c;

    /* loaded from: classes6.dex */
    public class a implements bh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final UnitedSchemeEntity a;
        public final CallbackHandler b;

        public a(eh1 eh1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eh1Var, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
        }

        @Override // com.repackage.bh1
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                UnitedSchemeUtility.callCallback(this.b, this.a, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements dh1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final CallbackHandler a;
        public final String b;

        public b(eh1 eh1Var, CallbackHandler callbackHandler, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eh1Var, callbackHandler, str};
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
            this.b = str;
        }

        @Override // com.repackage.dh1
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (TextUtils.isEmpty(this.b)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    ul2.U().u(new ia2("rewardedVideoAdClose", hashMap));
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("event", "close");
                    jSONObject2.put("result", jSONObject);
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.repackage.dh1
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (TextUtils.isEmpty(this.b)) {
                    ul2.U().u(new ia2("rewardedVideoAdLoad", new HashMap()));
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("event", "load");
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.repackage.dh1
        public void c(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
                if (TextUtils.isEmpty(this.b)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("data", jSONObject.toString());
                    ul2.U().u(new ia2("rewardedVideoAdError", hashMap));
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("event", "error");
                    jSONObject2.put("result", jSONObject);
                    this.a.handleSchemeDispatchCallback(this.b, UnitedSchemeUtility.wrapCallbackParams(jSONObject2, 0).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eh1(e13 e13Var) {
        super(e13Var, "/swanAPI/rewardedVideoAd");
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
        this.c = null;
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (e23.b) {
                Log.d("SwanAppAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            JSONObject a2 = e23.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString = a2.optString("cb");
            String optString2 = a2.optString("action");
            b bVar = new b(this, callbackHandler, optString);
            a aVar = new a(this, unitedSchemeEntity, callbackHandler);
            if (this.c == null) {
                this.c = new gh1(a2, bVar, aVar);
            }
            if (TextUtils.equals(optString2, "show")) {
                this.c.a(a2, aVar);
                return true;
            } else if (TextUtils.equals(optString2, "load")) {
                this.c.b(a2, aVar, bVar);
                return true;
            } else {
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
