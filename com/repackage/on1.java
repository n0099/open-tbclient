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
import com.repackage.d02;
import com.repackage.z53;
/* loaded from: classes6.dex */
public class on1 extends r23 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ String c;
        public final /* synthetic */ d02 d;
        public final /* synthetic */ on1 e;

        public a(on1 on1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str, d02 d02Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {on1Var, callbackHandler, unitedSchemeEntity, str, d02Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = on1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = str;
            this.d = d02Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (!s53.h(x53Var)) {
                    s53.p(x53Var, this.a, this.b);
                } else {
                    this.e.k(this.c, this.d, this.a, this.b);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public on1(r13 r13Var) {
        super(r13Var, "/swanAPI/openAdLandingPage");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {r13Var};
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

    @Override // com.repackage.r23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, u03Var)) == null) {
            if (r23.b) {
                Log.d("OpenAdLandingPageAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            String o = d43.o(unitedSchemeEntity, "params");
            if (TextUtils.isEmpty(o)) {
                ux1.i("AdLanding", "adLanding: url is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            d02 V = hm2.U().V();
            if (V == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            } else if (TextUtils.equals(d43.n(unitedSchemeEntity, "params", "invokeFrom"), "boxjs")) {
                k(o, V, callbackHandler, unitedSchemeEntity);
                return true;
            } else {
                u03Var.d0().g(context, "mapp_i_open_adlanding", new a(this, callbackHandler, unitedSchemeEntity, o, V));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void j(uq2 uq2Var, d02 d02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, uq2Var, d02Var) == null) {
            ux1.i("AdLanding", "openAdLanding: page url=" + uq2Var.c);
            d02.b i = d02Var.i("adLanding");
            i.n(d02.g, d02.i);
            i.k("adLanding", uq2Var).b();
        }
    }

    public void k(String str, d02 d02Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, d02Var, callbackHandler, unitedSchemeEntity) == null) {
            j(uq2.d(str, str), d02Var);
            ux1.i("AdLanding", "open adLanding page success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        }
    }
}
