package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m53;
/* loaded from: classes7.dex */
public class xs1 extends rs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ xs1 d;

        public a(xs1 xs1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xs1Var, unitedSchemeEntity, callbackHandler, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xs1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                bt1 bt1Var = (bt1) this.d.q(this.a);
                if (f53.h(k53Var)) {
                    this.d.p(this.c, this.a, this.b, bt1Var);
                    return;
                }
                f53.p(k53Var, this.b, this.a);
                hx1.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements kv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bt1 a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ xs1 d;

        public b(xs1 xs1Var, bt1 bt1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xs1Var, bt1Var, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = xs1Var;
            this.a = bt1Var;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
        }

        @Override // com.repackage.kv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.d.k(this.b, this.c, this.d.o(this.a));
                hx1.c("SwanAppCameraManager", str + "");
            }
        }

        @Override // com.repackage.kv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.c, this.b, 10005);
                hx1.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xs1(e13 e13Var) {
        super(e13Var, "/swanAPI/camera/update");
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

    @Override // com.repackage.e23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, h03Var)) == null) {
            if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                hx1.c("SwanAppCameraManager", "handle action, but context is not Activity");
                return false;
            }
            h03Var.e0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, unitedSchemeEntity, callbackHandler, context));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean o(bt1 bt1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bt1Var)) == null) {
            hx1.i("SwanAppCameraManager", "handle update camera instruction start");
            if (bt1Var == null) {
                hx1.c("SwanAppCameraManager", "Model is null");
                return false;
            }
            String str = bt1Var.b;
            nq2 nq2Var = bt1Var.h;
            if (!TextUtils.isEmpty(str) && nq2Var != null && nq2Var.h()) {
                gw1 gw1Var = (gw1) uw1.a(bt1Var);
                if (gw1Var == null) {
                    hx1.c("SwanAppCameraManager", "update camera with a null component");
                    return false;
                }
                yv1 update = gw1Var.update((gw1) bt1Var);
                boolean a2 = update.a();
                if (!a2) {
                    hx1.c("SwanAppCameraManager", "update camera fail: " + update.b);
                }
                return a2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cameraId = ");
            sb.append(str);
            sb.append(" ; position = ");
            sb.append(nq2Var == null);
            hx1.c("SwanAppCameraManager", sb.toString());
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, bt1 bt1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, bt1Var) == null) {
            hx1.i("SwanAppCameraManager", "handleAuthorized start");
            jv2.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 100, context, new b(this, bt1Var, unitedSchemeEntity, callbackHandler));
        }
    }

    public xv1 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new bt1(l(unitedSchemeEntity)) : (xv1) invokeL.objValue;
    }
}
