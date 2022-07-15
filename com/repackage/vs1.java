package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m53;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class vs1 extends rs1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements af3<k53<m53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ h03 d;
        public final /* synthetic */ ct1 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ vs1 g;

        public a(vs1 vs1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, h03 h03Var, ct1 ct1Var, CameraPreview cameraPreview) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vs1Var, callbackHandler, unitedSchemeEntity, context, h03Var, ct1Var, cameraPreview};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = vs1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = h03Var;
            this.e = ct1Var;
            this.f = cameraPreview;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.af3
        /* renamed from: b */
        public void a(k53<m53.e> k53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k53Var) == null) {
                if (f53.h(k53Var)) {
                    this.g.o(this.c, this.b, this.a, this.d, this.e, this.f);
                    return;
                }
                f53.p(k53Var, this.a, this.b);
                hx1.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements kv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ h03 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ ct1 e;
        public final /* synthetic */ vs1 f;

        public b(vs1 vs1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var, CameraPreview cameraPreview, ct1 ct1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vs1Var, unitedSchemeEntity, callbackHandler, h03Var, cameraPreview, ct1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = vs1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = h03Var;
            this.d = cameraPreview;
            this.e = ct1Var;
        }

        @Override // com.repackage.kv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f.r(this.a, this.b, this.c, this.d, this.e);
            }
        }

        @Override // com.repackage.kv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.b, this.a, 10005);
                hx1.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vs1(e13 e13Var) {
        super(e13Var, "/swanAPI/camera/stopRecord");
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
            ct1 ct1Var = (ct1) q(unitedSchemeEntity);
            if (ct1Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                hx1.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            gw1 gw1Var = (gw1) uw1.a(ct1Var);
            if (gw1Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                hx1.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = gw1Var.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                hx1.c("SwanAppCameraManager", "get camera view is null");
                return false;
            } else if (TextUtils.isEmpty(p73.x(h03Var.b))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                hx1.c("SwanAppCameraManager", "get camera stop record cache path is empty");
                return false;
            } else {
                h03Var.e0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, h03Var, ct1Var, q));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var, ct1 ct1Var, CameraPreview cameraPreview) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, h03Var, ct1Var, cameraPreview}) == null) {
            hx1.i("SwanAppCameraManager", "handleAuthorized start");
            if (qs1.b().c(context) && qs1.b().d(context)) {
                hx1.c("SwanAppCameraManager", "has authorize");
                r(unitedSchemeEntity, callbackHandler, h03Var, cameraPreview, ct1Var);
                return;
            }
            jv2.g(context, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, 1, new b(this, unitedSchemeEntity, callbackHandler, h03Var, cameraPreview, ct1Var));
        }
    }

    public final boolean p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                return file.exists() && file.length() > 0;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public xv1 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new ct1(l(unitedSchemeEntity)) : (xv1) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, h03 h03Var, CameraPreview cameraPreview, ct1 ct1Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, unitedSchemeEntity, callbackHandler, h03Var, cameraPreview, ct1Var) == null) {
            hx1.i("SwanAppCameraManager", "stop record start");
            try {
                z = cameraPreview.n();
            } catch (Exception e) {
                e = e;
                z = false;
            }
            try {
                qs1.b().j();
            } catch (Exception e2) {
                e = e2;
                cameraPreview.e();
                qs1.b().e(ct1Var.c, ct1Var.b, false);
                if (e23.b) {
                    e.printStackTrace();
                }
                hx1.c("SwanAppCameraManager", "stop recording api occur exception");
                String videoPath = cameraPreview.getVideoPath();
                String thumbPath = cameraPreview.getThumbPath();
                if (!z) {
                }
                k(unitedSchemeEntity, callbackHandler, false);
                cameraPreview.e();
                hx1.i("SwanAppCameraManager", "stop record end");
            }
            String videoPath2 = cameraPreview.getVideoPath();
            String thumbPath2 = cameraPreview.getThumbPath();
            if (!z && p(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("tempVideoPath", p73.J(videoPath2, h03Var.b));
                hashMap.put("tempThumbPath", p73.J(thumbPath2, h03Var.b));
                j(unitedSchemeEntity, callbackHandler, hashMap, "");
            } else {
                k(unitedSchemeEntity, callbackHandler, false);
            }
            cameraPreview.e();
            hx1.i("SwanAppCameraManager", "stop record end");
        }
    }
}
