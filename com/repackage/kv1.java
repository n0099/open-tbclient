package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kv1 extends g03 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements lv1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mv1 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ kv1 c;

        public a(kv1 kv1Var, mv1 mv1Var, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kv1Var, mv1Var, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kv1Var;
            this.a = mv1Var;
            this.b = callbackHandler;
        }

        @Override // com.repackage.lv1
        public void a(int i, View view2, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, view2, obj) == null) {
                nv1 nv1Var = (nv1) this.a.n();
                if (i == 0 || i == 1) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "loadState");
                        jSONObject.put("parentId", nv1Var.d);
                        jSONObject.put("viewId", nv1Var.b);
                        jSONObject.put("loadState", i == 1 ? "finish" : "error");
                    } catch (JSONException e) {
                        hw1.d("Component-Action-ImageCover", "loadState callback error", e);
                    }
                    this.c.s(this.b, jSONObject, nv1Var.e);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kv1(e03 e03Var) {
        super(e03Var, "/swanAPI/coverimage");
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
                super((e03) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.g03
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/coverimage" : (String) invokeV.objValue;
    }

    @Override // com.repackage.g03
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hz2 hz2Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, hz2Var)) == null) {
            if (e13.b) {
                Log.d("Component-Action-ImageCover", "insert");
            }
            nv1 r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hw1.c("Component-Action-ImageCover", "model is null");
                return false;
            }
            mv1 mv1Var = new mv1(context, r);
            mv1Var.e0(new a(this, mv1Var, callbackHandler));
            yu1 insert = mv1Var.insert();
            boolean a2 = insert.a();
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, insert.b);
            }
            return a2;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.repackage.g03
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hz2 hz2Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, hz2Var)) == null) {
            if (e13.b) {
                Log.d("Component-Action-ImageCover", "remove");
            }
            nv1 r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hw1.c("Component-Action-ImageCover", "model is null");
                return false;
            }
            mv1 mv1Var = (mv1) uv1.a(r);
            if (mv1Var == null) {
                String str2 = "can't find imageCoverView component:#" + r.b;
                hw1.c("Component-Action-ImageCover", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            yu1 B = mv1Var.B();
            boolean a2 = B.a();
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, B.b);
            }
            return a2;
        }
        return invokeLLLLL.booleanValue;
    }

    @Override // com.repackage.g03
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, hz2 hz2Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, hz2Var)) == null) {
            if (e13.b) {
                Log.d("Component-Action-ImageCover", "update");
            }
            nv1 r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hw1.c("Component-Action-ImageCover", "model is null");
                return false;
            }
            mv1 mv1Var = (mv1) uv1.a(r);
            if (mv1Var == null) {
                String str2 = "can't find imageCoverView component:#" + r.b;
                hw1.c("Component-Action-ImageCover", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            yu1 update = mv1Var.update((mv1) r);
            boolean a2 = update.a();
            if (a2) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            } else {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, update.b);
            }
            return a2;
        }
        return invokeLLLLL.booleanValue;
    }

    @Nullable
    public final nv1 r(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hw1.c("Component-Action-ImageCover", "params is null");
                return null;
            }
            nv1 nv1Var = new nv1();
            try {
                nv1Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                hw1.d("Component-Action-ImageCover", "model parse exception:", e);
            }
            return nv1Var;
        }
        return (nv1) invokeL.objValue;
    }

    public final void s(@NonNull CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, callbackHandler, jSONObject, str) == null) {
            hw1.i("Component-Action-ImageCover", "sendAsyncCallback info: " + jSONObject);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }
}
