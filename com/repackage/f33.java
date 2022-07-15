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
import com.repackage.lp1;
import com.repackage.m53;
import com.repackage.mp1;
/* loaded from: classes6.dex */
public final class f33 extends e23 implements mp1.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CallbackHandler c;

    /* loaded from: classes6.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ lp1.c b;
        public final /* synthetic */ h03 c;
        public final /* synthetic */ f33 d;

        public a(f33 f33Var, CallbackHandler callbackHandler, lp1.c cVar, h03 h03Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f33Var, callbackHandler, cVar, h03Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = f33Var;
            this.a = callbackHandler;
            this.b = cVar;
            this.c = h03Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                this.d.k(k53Var, this.a, this.b, this.c.n0());
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f33(e13 e13Var) {
        super(e13Var, "/swanAPI/getLocation");
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

    @Override // com.repackage.mp1.c
    public void b(lp1.c cVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048576, this, cVar, i) == null) || this.c == null) {
            return;
        }
        hx1.c("GetLocationAction", "request location error code : " + i);
        this.c.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(i).toString());
    }

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (e23.b) {
                Log.d("GetLocationAction", "handle entity: " + unitedSchemeEntity.toString());
            }
            this.c = callbackHandler;
            if (h03Var == null) {
                hx1.c("location", "swan app is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                return false;
            }
            lp1.c b = lp1.c.b(unitedSchemeEntity.getParam("params"));
            if (b != null && b.a()) {
                if (TextUtils.isEmpty(b.c)) {
                    hx1.c("location", "empty cb");
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                    return false;
                }
                h03Var.e0().g(context, "mapp_location", new a(this, callbackHandler, b, h03Var));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            hx1.c("location", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // com.repackage.mp1.c
    public void f(lp1.c cVar, String str) {
        CallbackHandler callbackHandler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cVar, str) == null) || (callbackHandler = this.c) == null) {
            return;
        }
        callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(10005, "system deny").toString());
    }

    @Override // com.repackage.mp1.c
    public void g(lp1.c cVar, g33 g33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, cVar, g33Var) == null) {
            if (e23.b) {
                Log.d("GetLocationAction", "convert info : " + g33Var.a());
            }
            CallbackHandler callbackHandler = this.c;
            if (callbackHandler == null) {
                return;
            }
            callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(g33Var.a(), 0).toString());
        }
    }

    public final void k(k53<m53.e> k53Var, CallbackHandler callbackHandler, lp1.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{k53Var, callbackHandler, cVar, Boolean.valueOf(z)}) == null) {
            hx1.i("GetLocationAction", "authorized result is " + k53Var);
            if (f53.h(k53Var)) {
                mp1.d().e(cVar, this, z);
                return;
            }
            int b = k53Var.b();
            callbackHandler.handleSchemeDispatchCallback(cVar.c, UnitedSchemeUtility.wrapCallbackParams(b, f53.f(b)).toString());
        }
    }
}
