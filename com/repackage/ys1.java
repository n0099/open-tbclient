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
import com.repackage.o53;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ys1 extends ts1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements cf3<m53<o53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CallbackHandler a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ j03 d;
        public final /* synthetic */ ft1 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ ys1 h;

        public a(ys1 ys1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, j03 j03Var, ft1 ft1Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys1Var, callbackHandler, unitedSchemeEntity, context, j03Var, ft1Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = ys1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = j03Var;
            this.e = ft1Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.cf3
        /* renamed from: a */
        public void onCallback(m53<o53.e> m53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, m53Var) == null) {
                if (h53.h(m53Var)) {
                    this.h.p(this.c, this.b, this.a, this.d, this.e, this.f, this.g);
                    return;
                }
                h53.p(m53Var, this.a, this.b);
                jx1.c("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements mv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ j03 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ ft1 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ys1 g;

        public b(ys1 ys1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j03 j03Var, CameraPreview cameraPreview, ft1 ft1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys1Var, unitedSchemeEntity, callbackHandler, j03Var, cameraPreview, ft1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ys1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = j03Var;
            this.d = cameraPreview;
            this.e = ft1Var;
            this.f = str;
        }

        @Override // com.repackage.mv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.g.r(this.a, this.b, this.c, this.d, this.e, this.f);
                jx1.c("SwanAppCameraManager", str + "");
            }
        }

        @Override // com.repackage.mv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                UnitedSchemeUtility.callCallback(this.b, this.a, 10005);
                jx1.c("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements at1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ j03 b;
        public final /* synthetic */ ft1 c;
        public final /* synthetic */ CallbackHandler d;
        public final /* synthetic */ UnitedSchemeEntity e;
        public final /* synthetic */ ys1 f;

        public c(ys1 ys1Var, String str, j03 j03Var, ft1 ft1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ys1Var, str, j03Var, ft1Var, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = ys1Var;
            this.a = str;
            this.b = j03Var;
            this.c = ft1Var;
            this.d = callbackHandler;
            this.e = unitedSchemeEntity;
        }

        @Override // com.repackage.at1
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f.k(this.e, this.d, false);
                jx1.c("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // com.repackage.at1
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", r73.J(this.a, this.b.b));
                } catch (JSONException e) {
                    jx1.c("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    ss1 b = ss1.b();
                    ft1 ft1Var = this.c;
                    b.e(ft1Var.c, ft1Var.b, false);
                    if (g23.b) {
                        e.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.d, this.e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ys1(g13 g13Var) {
        super(g13Var, "/swanAPI/camera/takePhoto");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {g13Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((g13) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.g23
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j03 j03Var) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, j03Var)) == null) {
            ft1 ft1Var = (ft1) q(unitedSchemeEntity);
            if (ft1Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                jx1.c("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            iw1 iw1Var = (iw1) ww1.a(ft1Var);
            if (iw1Var == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                jx1.c("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = iw1Var.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                jx1.c("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = r73.x(j03Var.b);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                jx1.c("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            j03Var.d0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, j03Var, ft1Var, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j03 j03Var, ft1 ft1Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, j03Var, ft1Var, cameraPreview, str}) == null) {
            jx1.i("SwanAppCameraManager", "handleAuthorized start");
            lv2.e("android.permission.CAMERA", new String[]{"android.permission.CAMERA"}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, j03Var, cameraPreview, ft1Var, str));
        }
    }

    public zv1 q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) ? new ft1(l(unitedSchemeEntity)) : (zv1) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, j03 j03Var, CameraPreview cameraPreview, ft1 ft1Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, j03Var, cameraPreview, ft1Var, str}) == null) {
            jx1.i("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(ft1Var.j);
            String g = cameraPreview.g(str);
            try {
                cameraPreview.o(g, new c(this, g, j03Var, ft1Var, callbackHandler, unitedSchemeEntity));
            } catch (Exception e) {
                jx1.c("SwanAppCameraManager", "take picture api occur exception");
                ss1.b().e(ft1Var.c, ft1Var.b, false);
                if (g23.b) {
                    e.printStackTrace();
                }
            }
            jx1.i("SwanAppCameraManager", "take photo end");
        }
    }
}
