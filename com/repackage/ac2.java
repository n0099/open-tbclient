package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.api.module.subscription.SubscribeHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ac2 extends e13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context c;
    public hz2 d;
    public CallbackHandler e;

    /* loaded from: classes5.dex */
    public class a implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;

        public a(ac2 ac2Var, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac2Var, unitedSchemeEntity};
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
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i, @NonNull String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, jSONObject) == null) {
                this.a.result = UnitedSchemeUtility.wrapCallbackParams(i, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements SubscribeHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ac2 b;

        public b(ac2 ac2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ac2Var;
            this.a = str;
        }

        @Override // com.baidu.swan.apps.api.module.subscription.SubscribeHelper.k
        public void a(int i, @NonNull String str, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, jSONObject) == null) {
                if (jSONObject == null) {
                    this.b.e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(i, str).toString());
                } else {
                    this.b.e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, i).toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements bc2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ac2 b;

        public c(ac2 ac2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ac2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ac2Var;
            this.a = str;
        }

        @Override // com.repackage.lx2
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                this.b.e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
                if (nx2.c.c()) {
                    return;
                }
                if (oi2.h0().e(this.b.c)) {
                    nx2.c.e();
                } else {
                    nx2.c.f();
                }
            }
        }

        @Override // com.repackage.lx2
        public void onFail(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.b.e.handleSchemeDispatchCallback(this.a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ac2(e03 e03Var) {
        super(e03Var, "/swanAPI/getFormId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e03Var};
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
    }

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            if (unitedSchemeEntity == null) {
                if (e13.b) {
                    Log.w("GetFormIdAction", "entity is null");
                }
                return false;
            } else if (hz2Var != null && (context instanceof Activity) && callbackHandler != null) {
                this.c = context;
                this.d = hz2Var;
                this.e = callbackHandler;
                JSONObject a2 = e13.a(unitedSchemeEntity, "params");
                if (a2 != null && a2.length() != 0) {
                    String optString = a2.optString("cb");
                    if (TextUtils.isEmpty(optString)) {
                        if (e13.b) {
                            Log.w("GetFormIdAction", "cb is empty");
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                        return false;
                    }
                    String N = hz2Var.N();
                    if (TextUtils.isEmpty(N)) {
                        if (e13.b) {
                            Log.w("GetFormIdAction", "appKey is empty");
                        }
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "appKey is empty");
                        return false;
                    }
                    if (TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE.equals(a2.optString("reportType"))) {
                        SubscribeHelper subscribeHelper = new SubscribeHelper();
                        if (!subscribeHelper.n(this.c, this.d, N, a2, SubscribeHelper.invokeSubscribeFrom.GET_FORM_ID_BUTTON, new a(this, unitedSchemeEntity))) {
                            return false;
                        }
                        subscribeHelper.o(N, new b(this, optString));
                    } else {
                        l(N, optString);
                    }
                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                    return true;
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
                return false;
            } else {
                if (e13.b) {
                    Log.d("GetFormIdAction", "runtime parameter error");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
                return false;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void l(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            if (!SubscribeHelper.l()) {
                this.e.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(hc3.f(null, "data", hc3.f(null, "formid", "")), 0).toString());
                return;
            }
            oi2.W().c(str, new c(this, str2));
        }
    }
}
