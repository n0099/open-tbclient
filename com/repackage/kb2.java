package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m53;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class kb2 extends e23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ JSONObject c;
        public final /* synthetic */ Context d;

        public a(kb2 kb2Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, JSONObject jSONObject, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kb2Var, callbackHandler, unitedSchemeEntity, jSONObject, context};
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
            this.c = jSONObject;
            this.d = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (!f53.h(k53Var)) {
                    f53.p(k53Var, this.a, this.b);
                    return;
                }
                boolean b = va2.b(this.c.optInt("useExtension"));
                if (b && !ya2.b().exists()) {
                    zz2.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f013e).G();
                    this.b.result = UnitedSchemeUtility.wrapCallbackParams(1001, this.d.getResources().getString(R.string.obfuscated_res_0x7f0f013e));
                    return;
                }
                gw2.V(b);
                UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(0));
                gw2.Z();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kb2(e13 e13Var) {
        super(e13Var, "/swanAPI/debug/setExtensionConfig");
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
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            JSONObject a2 = e23.a(unitedSchemeEntity, "params");
            if (a2 == null) {
                hx1.c("ExtCore-SetConfig", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (!a2.has("useExtension")) {
                hx1.c("ExtCore-SetConfig", "useExtension is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else {
                h03Var.e0().g(context, "mapp_cts_debug", new a(this, callbackHandler, unitedSchemeEntity, a2, context));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }
}
