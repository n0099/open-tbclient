package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m53;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class v23 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public static final String c;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ String b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ v23 d;

        public a(v23 v23Var, CallbackHandler callbackHandler, String str, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v23Var, callbackHandler, str, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = v23Var;
            this.a = callbackHandler;
            this.b = str;
            this.c = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    this.d.k(this.c, this.a, this.b);
                } else {
                    f53.q(k53Var, this.a, this.b);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ String c;

        public b(v23 v23Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {v23Var, callbackHandler, unitedSchemeEntity, str};
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
            this.b = unitedSchemeEntity;
            this.c = str;
        }

        @Override // com.repackage.v23.c
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
                if (jSONObject != null && jSONObject.length() != 0) {
                    hx1.i("history", "get history :" + jSONObject.toString());
                    UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.c);
                    return;
                }
                hx1.i("history", "none history");
                UnitedSchemeUtility.safeCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(null, 0).toString(), this.c);
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface c {
        void a(JSONObject jSONObject);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755283110, "Lcom/repackage/v23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755283110, "Lcom/repackage/v23;");
                return;
            }
        }
        c = SchemeConfig.getSchemeHead() + "://v19/swan/launch?params={\"appid\":\"";
        d = SchemeConfig.getSchemeHead() + "://swangame/%s";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v23(e13 e13Var) {
        super(e13Var, "/swanAPI/getHistory");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e13Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((UnitedSchemeBaseDispatcher) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (h03Var == null) {
                hx1.c("history", "none swanApp");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal swanApp");
                if (e23.b) {
                    Log.d("SwanAppAction", "getSwanHistory --- illegal swanApp");
                }
                return false;
            }
            String optString = hd3.d(unitedSchemeEntity.getParam("params")).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                hx1.c("history", "none cb");
                if (e23.b) {
                    Log.d("SwanAppAction", "getSwanHistory --- cb is empty");
                }
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            h03Var.e0().g(context, "mapp_i_get_history", new a(this, callbackHandler, optString, unitedSchemeEntity));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void k(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, unitedSchemeEntity, callbackHandler, str) == null) {
            hx1.i("history", "start get history");
            k72.j(new b(this, callbackHandler, unitedSchemeEntity, str));
        }
    }
}
