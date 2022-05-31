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
import com.repackage.m43;
/* loaded from: classes7.dex */
public class sr1 extends rr1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public wu9 c;

    /* loaded from: classes7.dex */
    public class a implements ae3<k43<m43.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ bs1 d;
        public final /* synthetic */ sr1 e;

        public a(sr1 sr1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, bs1 bs1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr1Var, callbackHandler, unitedSchemeEntity, context, bs1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sr1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = bs1Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ae3
        /* renamed from: a */
        public void onCallback(k43<m43.e> k43Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, k43Var) == null) {
                if (f43.h(k43Var)) {
                    this.e.q(this.c, this.b, this.a, this.d);
                    return;
                }
                f43.p(k43Var, this.a, this.b);
                if (this.e.c != null) {
                    this.e.c.onError(new Throwable());
                } else {
                    hw1.c("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
                }
                hw1.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements ku2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ bs1 b;
        public final /* synthetic */ UnitedSchemeEntity c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ sr1 e;

        public b(sr1 sr1Var, Context context, bs1 bs1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sr1Var, context, bs1Var, unitedSchemeEntity, callbackHandler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = sr1Var;
            this.a = context;
            this.b = bs1Var;
            this.c = unitedSchemeEntity;
            this.d = callbackHandler;
        }

        @Override // com.repackage.ku2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.e.k(this.c, this.d, this.e.p(this.a, this.b));
                hw1.c("SwanAppCameraManager", str + "");
            }
        }

        @Override // com.repackage.ku2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.d, this.c, 10005);
                if (this.e.c != null) {
                    this.e.c.onError(new Throwable());
                } else {
                    hw1.c("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
                }
                hw1.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sr1(e03 e03Var) {
        super(e03Var, "/swanAPI/camera/insert");
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

    @Override // com.repackage.e13
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, hz2 hz2Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, hz2Var)) == null) {
            if (!(context instanceof Activity)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                hw1.c("SwanAppCameraManager", "handle action, but context is not Activity");
                return false;
            }
            bs1 bs1Var = (bs1) r(unitedSchemeEntity);
            wu9 w = new gv1(context, bs1Var).w();
            this.c = w;
            if (w == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                hw1.c("SwanAppCameraManager", "camera component insert delayed fail");
                return false;
            }
            hz2Var.d0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, bs1Var));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final boolean p(Context context, bs1 bs1Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, bs1Var)) == null) {
            hw1.i("SwanAppCameraManager", "handle insert camera instruction start");
            if (context != null && bs1Var != null) {
                String str = bs1Var.b;
                np2 np2Var = bs1Var.h;
                if (!TextUtils.isEmpty(str) && np2Var != null && np2Var.h()) {
                    wu9 wu9Var = this.c;
                    if (wu9Var == null) {
                        aw1.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                        return false;
                    }
                    wu9Var.onCompleted();
                    hw1.i("SwanAppCameraManager", "handle insert camera instruction end");
                    return true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("cameraId = ");
                sb.append(str);
                sb.append(" ; position = ");
                sb.append(np2Var == null);
                hw1.c("SwanAppCameraManager", sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Context is null ? = ");
            sb2.append(context == null);
            sb2.append(" ; model is null ? = ");
            sb2.append(bs1Var == null);
            hw1.c("SwanAppCameraManager", sb2.toString());
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, bs1 bs1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, context, unitedSchemeEntity, callbackHandler, bs1Var) == null) {
            hw1.i("SwanAppCameraManager", "handleAuthorized start");
            ju2.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 1, context, new b(this, context, bs1Var, unitedSchemeEntity, callbackHandler));
        }
    }

    public xu1 r(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new bs1(l(unitedSchemeEntity)) : (xu1) invokeL.objValue;
    }
}
