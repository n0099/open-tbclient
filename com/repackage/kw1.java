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
public class kw1 extends g13 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements lw1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ mw1 a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ kw1 c;

        public a(kw1 kw1Var, mw1 mw1Var, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kw1Var, mw1Var, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = kw1Var;
            this.a = mw1Var;
            this.b = callbackHandler;
        }

        @Override // com.repackage.lw1
        public void a(int i, View view2, @Nullable Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, view2, obj) == null) {
                nw1 nw1Var = (nw1) this.a.n();
                if (i == 0 || i == 1) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "loadState");
                        jSONObject.put("parentId", nw1Var.d);
                        jSONObject.put("viewId", nw1Var.b);
                        jSONObject.put("loadState", i == 1 ? "finish" : "error");
                    } catch (JSONException e) {
                        hx1.d("Component-Action-ImageCover", "loadState callback error", e);
                    }
                    this.c.s(this.b, jSONObject, nw1Var.e);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kw1(e13 e13Var) {
        super(e13Var, "/swanAPI/coverimage");
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
                super((e13) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.g13
    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "/swanAPI/coverimage" : (String) invokeV.objValue;
    }

    @Override // com.repackage.g13
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, h03 h03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, str, h03Var)) == null) {
            if (e23.b) {
                Log.d("Component-Action-ImageCover", "insert");
            }
            nw1 r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hx1.c("Component-Action-ImageCover", "model is null");
                return false;
            }
            mw1 mw1Var = new mw1(context, r);
            mw1Var.e0(new a(this, mw1Var, callbackHandler));
            yv1 insert = mw1Var.insert();
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

    @Override // com.repackage.g13
    public boolean o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, h03 h03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, str, h03Var)) == null) {
            if (e23.b) {
                Log.d("Component-Action-ImageCover", "remove");
            }
            nw1 r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hx1.c("Component-Action-ImageCover", "model is null");
                return false;
            }
            mw1 mw1Var = (mw1) uw1.a(r);
            if (mw1Var == null) {
                String str2 = "can't find imageCoverView component:#" + r.b;
                hx1.c("Component-Action-ImageCover", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            yv1 B = mw1Var.B();
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

    @Override // com.repackage.g13
    public boolean p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str, h03 h03Var) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(1048579, this, context, unitedSchemeEntity, callbackHandler, str, h03Var)) == null) {
            if (e23.b) {
                Log.d("Component-Action-ImageCover", "update");
            }
            nw1 r = r(unitedSchemeEntity);
            if (r == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hx1.c("Component-Action-ImageCover", "model is null");
                return false;
            }
            mw1 mw1Var = (mw1) uw1.a(r);
            if (mw1Var == null) {
                String str2 = "can't find imageCoverView component:#" + r.b;
                hx1.c("Component-Action-ImageCover", str2);
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, str2);
                return false;
            }
            yv1 update = mw1Var.update((mw1) r);
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
    public final nw1 r(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            JSONObject k = k(unitedSchemeEntity);
            if (k == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hx1.c("Component-Action-ImageCover", "params is null");
                return null;
            }
            nw1 nw1Var = new nw1();
            try {
                nw1Var.a(k);
            } catch (JSONException e) {
                e.printStackTrace();
                hx1.d("Component-Action-ImageCover", "model parse exception:", e);
            }
            return nw1Var;
        }
        return (nw1) invokeL.objValue;
    }

    public final void s(@NonNull CallbackHandler callbackHandler, JSONObject jSONObject, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, callbackHandler, jSONObject, str) == null) {
            hx1.i("Component-Action-ImageCover", "sendAsyncCallback info: " + jSONObject);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        }
    }
}
