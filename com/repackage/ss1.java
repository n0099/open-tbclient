package com.repackage;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
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
public class ss1 extends rs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public as9 c;

    /* loaded from: classes7.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ bt1 d;
        public final /* synthetic */ ss1 e;

        public a(ss1 ss1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, bt1 bt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ss1Var, callbackHandler, unitedSchemeEntity, context, bt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ss1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = bt1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    this.e.q(this.c, this.b, this.a, this.d);
                    return;
                }
                f53.p(k53Var, this.a, this.b);
                if (this.e.c != null) {
                    this.e.c.onError(new Throwable());
                } else {
                    hx1.c("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
                }
                hx1.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements kv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ bt1 b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ ss1 e;

        public b(ss1 ss1Var, Context context, bt1 bt1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ss1Var, context, bt1Var, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ss1Var;
            this.a = context;
            this.b = bt1Var;
            this.c = unitedSchemeEntity;
            this.d = callbackHandler;
        }

        @Override // com.repackage.kv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.k(this.c, this.d, this.e.p(this.a, this.b));
                hx1.c("SwanAppCameraManager", str + "");
            }
        }

        @Override // com.repackage.kv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.d, this.c, 10005);
                if (this.e.c != null) {
                    this.e.c.onError(new Throwable());
                } else {
                    hx1.c("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
                }
                hx1.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ss1(e13 e13Var) {
        super(e13Var, "/swanAPI/camera/insert");
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
            bt1 bt1Var = (bt1) r(unitedSchemeEntity);
            as9 w = new gw1(context, bt1Var).w();
            this.c = w;
            if (w == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                hx1.c("SwanAppCameraManager", "camera component insert delayed fail");
                return false;
            }
            h03Var.e0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, bt1Var));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean p(Context context, bt1 bt1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bt1Var)) == null) {
            hx1.i("SwanAppCameraManager", "handle insert camera instruction start");
            if (context != null && bt1Var != null) {
                String str = bt1Var.b;
                nq2 nq2Var = bt1Var.h;
                if (!TextUtils.isEmpty(str) && nq2Var != null && nq2Var.h()) {
                    as9 as9Var = this.c;
                    if (as9Var == null) {
                        ax1.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                        return false;
                    }
                    as9Var.onCompleted();
                    hx1.i("SwanAppCameraManager", "handle insert camera instruction end");
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("cameraId = ");
                sb.append(str);
                sb.append(" ; position = ");
                sb.append(nq2Var == null);
                hx1.c("SwanAppCameraManager", sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Context is null ? = ");
            sb2.append(context == null);
            sb2.append(" ; model is null ? = ");
            sb2.append(bt1Var == null);
            hx1.c("SwanAppCameraManager", sb2.toString());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, bt1 bt1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, bt1Var) == null) {
            hx1.i("SwanAppCameraManager", "handleAuthorized start");
            jv2.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 1, context, new b(this, context, bt1Var, unitedSchemeEntity, callbackHandler));
        }
    }

    public xv1 r(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new bt1(l(unitedSchemeEntity)) : (xv1) invokeL.objValue;
    }
}
