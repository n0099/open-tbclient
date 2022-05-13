package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.retrieve.inter.upload.IActiveUploadListener;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rl2;
import com.repackage.z53;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class y23 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String c;
    public boolean d;

    /* loaded from: classes7.dex */
    public class a implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ u03 c;
        public final /* synthetic */ UnitedSchemeEntity d;
        public final /* synthetic */ y23 e;

        public a(y23 y23Var, CallbackHandler callbackHandler, String str, u03 u03Var, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {y23Var, callbackHandler, str, u03Var, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = y23Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = u03Var;
            this.d = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (!s53.h(x53Var)) {
                    s53.q(x53Var, this.a, this.b);
                    this.e.l(this.c, this.d, this.a, this.b);
                    return;
                }
                this.e.k(this.c, this.d, this.a, this.b);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y23(r13 r13Var, String str) {
        super(r13Var, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var, str};
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
        this.d = false;
    }

    public static void m(String str, String str2, String str3) {
        u03 a0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, str, str2, str3) == null) || (a0 = u03.a0()) == null) {
            return;
        }
        w73 w73Var = new w73();
        rl2.a V = a0.V();
        w73Var.a = n73.n(V.G());
        w73Var.e = str3;
        w73Var.b = DI.BD.FAVOR;
        w73Var.f = a0.N();
        SwanCoreVersion j0 = V.j0();
        String Y = a0.Y();
        String str4 = j0 != null ? j0.swanCoreVersionName : "";
        w73Var.a("appName", Y);
        w73Var.a("isFavor", str);
        w73Var.a("favorBy", str2);
        w73Var.a("swan", str4);
        b73.i("2571", "89", w73Var.f());
    }

    @Override // com.repackage.r23
    public final boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            if (u03Var == null) {
                ux1.c("favorite", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (r23.b) {
                    Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
                }
                return false;
            }
            JSONObject d = ud3.d(unitedSchemeEntity.getParam("params"));
            String optString = d.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                ux1.c("favorite", "none cb");
                if (r23.b) {
                    Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            this.d = d.optBoolean("isFavorButton", false);
            if (!j(u03Var, unitedSchemeEntity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, IActiveUploadListener.PARAM_ERR_MSG);
                return false;
            }
            String optString2 = d.optString("slaveId");
            String T = hm2.U().T();
            if (TextUtils.equals(optString2, hm2.U().C()) && (TextUtils.equals(T, "pages/swan-news-showcase/index") || TextUtils.equals(T, "pages/swan-operate-news/index"))) {
                k(u03Var, unitedSchemeEntity, callbackHandler, optString);
            } else if (!o(unitedSchemeEntity)) {
                u03Var.d0().g(context, this.d ? "scope_favorite_button" : "mapp_favorite", new a(this, callbackHandler, optString, u03Var, unitedSchemeEntity));
            } else {
                k(u03Var, unitedSchemeEntity, callbackHandler, optString);
            }
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public abstract boolean j(u03 u03Var, UnitedSchemeEntity unitedSchemeEntity);

    public abstract void k(u03 u03Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str);

    public void l(u03 u03Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, u03Var, unitedSchemeEntity, callbackHandler, str) == null) {
        }
    }

    public void n(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("success", "0");
            } catch (JSONException e) {
                if (eh1.a) {
                    e.printStackTrace();
                }
            }
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), str);
        }
    }

    public boolean o(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}
