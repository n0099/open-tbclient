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
import com.repackage.z53;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class it1 extends et1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public class a implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ u03 d;
        public final /* synthetic */ pt1 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ it1 g;

        public a(it1 it1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, u03 u03Var, pt1 pt1Var, CameraPreview cameraPreview) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it1Var, callbackHandler, unitedSchemeEntity, context, u03Var, pt1Var, cameraPreview};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = it1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = u03Var;
            this.e = pt1Var;
            this.f = cameraPreview;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    this.g.o(this.c, this.b, this.a, this.d, this.e, this.f);
                    return;
                }
                s53.p(x53Var, this.a, this.b);
                ux1.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements xv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ u03 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ pt1 e;
        public final /* synthetic */ it1 f;

        public b(it1 it1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, CameraPreview cameraPreview, pt1 pt1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {it1Var, unitedSchemeEntity, callbackHandler, u03Var, cameraPreview, pt1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = it1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = u03Var;
            this.d = cameraPreview;
            this.e = pt1Var;
        }

        @Override // com.repackage.xv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f.r(this.a, this.b, this.c, this.d, this.e);
            }
        }

        @Override // com.repackage.xv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.b, this.a, 10005);
                ux1.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public it1(r13 r13Var) {
        super(r13Var, "/swanAPI/camera/stopRecord");
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
                super((r13) objArr2[0], (String) objArr2[1]);
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
            pt1 pt1Var = (pt1) q(unitedSchemeEntity);
            if (pt1Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                ux1.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            tw1 tw1Var = (tw1) hx1.a(pt1Var);
            if (tw1Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                ux1.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = tw1Var.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                ux1.c("SwanAppCameraManager", "get camera view is null");
                return false;
            } else if (TextUtils.isEmpty(c83.x(u03Var.b))) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                ux1.c("SwanAppCameraManager", "get camera stop record cache path is empty");
                return false;
            } else {
                u03Var.d0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, u03Var, pt1Var, q));
                return true;
            }
        }
        return invokeLLLL.booleanValue;
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, pt1 pt1Var, CameraPreview cameraPreview) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, u03Var, pt1Var, cameraPreview}) == null) {
            ux1.i("SwanAppCameraManager", "handleAuthorized start");
            if (dt1.b().c(context) && dt1.b().d(context)) {
                ux1.c("SwanAppCameraManager", "has authorize");
                r(unitedSchemeEntity, callbackHandler, u03Var, cameraPreview, pt1Var);
                return;
            }
            wv2.g(context, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, 1, new b(this, unitedSchemeEntity, callbackHandler, u03Var, cameraPreview, pt1Var));
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

    public kw1 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, unitedSchemeEntity)) == null) ? new pt1(l(unitedSchemeEntity)) : (kw1) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, CameraPreview cameraPreview, pt1 pt1Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048580, this, unitedSchemeEntity, callbackHandler, u03Var, cameraPreview, pt1Var) == null) {
            ux1.i("SwanAppCameraManager", "stop record start");
            try {
                z = cameraPreview.n();
            } catch (Exception e) {
                e = e;
                z = false;
            }
            try {
                dt1.b().j();
            } catch (Exception e2) {
                e = e2;
                cameraPreview.e();
                dt1.b().e(pt1Var.c, pt1Var.b, false);
                if (r23.b) {
                    e.printStackTrace();
                }
                ux1.c("SwanAppCameraManager", "stop recording api occur exception");
                String videoPath = cameraPreview.getVideoPath();
                String thumbPath = cameraPreview.getThumbPath();
                if (!z) {
                }
                k(unitedSchemeEntity, callbackHandler, false);
                cameraPreview.e();
                ux1.i("SwanAppCameraManager", "stop record end");
            }
            String videoPath2 = cameraPreview.getVideoPath();
            String thumbPath2 = cameraPreview.getThumbPath();
            if (!z && p(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("tempVideoPath", c83.J(videoPath2, u03Var.b));
                hashMap.put("tempThumbPath", c83.J(thumbPath2, u03Var.b));
                j(unitedSchemeEntity, callbackHandler, hashMap, "");
            } else {
                k(unitedSchemeEntity, callbackHandler, false);
            }
            cameraPreview.e();
            ux1.i("SwanAppCameraManager", "stop record end");
        }
    }
}
