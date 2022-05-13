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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ht1 extends et1 {
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
        public final /* synthetic */ String g;
        public final /* synthetic */ ht1 h;

        public a(ht1 ht1Var, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, u03 u03Var, pt1 pt1Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht1Var, callbackHandler, unitedSchemeEntity, context, u03Var, pt1Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = ht1Var;
            this.a = callbackHandler;
            this.b = unitedSchemeEntity;
            this.c = context;
            this.d = u03Var;
            this.e = pt1Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            int b;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    this.h.r(this.c, this.b, this.a, this.d, this.e, this.f, this.g);
                } else if (x53Var != null && x53Var.a() != null) {
                    String str = "authorize recorder failed : " + s53.f(b);
                    UnitedSchemeUtility.callCallback(this.a, this.b, UnitedSchemeUtility.wrapCallbackParams(x53Var.b(), str));
                    ux1.o("SwanAppAction", str);
                } else {
                    ux1.c("SwanAppAction", "authorize recorder failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements nf3<x53<z53.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ Context c;
        public final /* synthetic */ u03 d;
        public final /* synthetic */ pt1 e;
        public final /* synthetic */ CameraPreview f;
        public final /* synthetic */ String g;
        public final /* synthetic */ ht1 h;

        public b(ht1 ht1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, u03 u03Var, pt1 pt1Var, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht1Var, unitedSchemeEntity, callbackHandler, context, u03Var, pt1Var, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = ht1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = context;
            this.d = u03Var;
            this.e = pt1Var;
            this.f = cameraPreview;
            this.g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.nf3
        /* renamed from: a */
        public void onCallback(x53<z53.e> x53Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, x53Var) == null) {
                if (s53.h(x53Var)) {
                    this.h.t(this.c, this.a, this.b, this.d, this.e, this.f, this.g);
                } else if (x53Var != null && x53Var.a() != null) {
                    this.h.s(x53Var.b(), this.a, this.b);
                } else {
                    ux1.c("SwanAppAction", "authorize camera failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements xv2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UnitedSchemeEntity a;
        public final /* synthetic */ CallbackHandler b;
        public final /* synthetic */ u03 c;
        public final /* synthetic */ CameraPreview d;
        public final /* synthetic */ pt1 e;
        public final /* synthetic */ String f;
        public final /* synthetic */ ht1 g;

        public c(ht1 ht1Var, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, CameraPreview cameraPreview, pt1 pt1Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht1Var, unitedSchemeEntity, callbackHandler, u03Var, cameraPreview, pt1Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = ht1Var;
            this.a = unitedSchemeEntity;
            this.b = callbackHandler;
            this.c = u03Var;
            this.d = cameraPreview;
            this.e = pt1Var;
            this.f = str;
        }

        @Override // com.repackage.xv2
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.g.w(this.a, this.b, this.c, this.d, this.e, this.f);
            }
        }

        @Override // com.repackage.xv2
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                this.g.s(10005, this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements mt1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CameraPreview a;
        public final /* synthetic */ UnitedSchemeEntity b;
        public final /* synthetic */ CallbackHandler c;
        public final /* synthetic */ HashMap d;
        public final /* synthetic */ ht1 e;

        public d(ht1 ht1Var, CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht1Var, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = ht1Var;
            this.a = cameraPreview;
            this.b = unitedSchemeEntity;
            this.c = callbackHandler;
            this.d = hashMap;
        }

        @Override // com.repackage.mt1
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.n();
                this.a.e();
                this.e.u(this.b, this.c, this.d);
                ux1.c("SwanAppCameraManager", "start record timeout");
            }
        }

        @Override // com.repackage.mt1
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.n();
                this.a.e();
                this.e.u(this.b, this.c, this.d);
                ux1.c("SwanAppCameraManager", "start record cancel");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ht1(r13 r13Var) {
        super(r13Var, "/swanAPI/camera/startRecord");
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
            pt1 pt1Var = (pt1) v(unitedSchemeEntity);
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
            }
            String x = c83.x(u03Var.b);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                ux1.c("SwanAppCameraManager", "get camera start record cache path is empty");
                return false;
            }
            u03Var.d0().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, u03Var, pt1Var, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, pt1 pt1Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, u03Var, pt1Var, cameraPreview, str}) == null) {
            u03Var.d0().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(this, unitedSchemeEntity, callbackHandler, context, u03Var, pt1Var, cameraPreview, str));
        }
    }

    public final void s(int i, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, unitedSchemeEntity, callbackHandler) == null) {
            String str = "authorize camera failed : " + s53.f(i);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i, str));
            ux1.o("SwanAppAction", str);
        }
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, pt1 pt1Var, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, unitedSchemeEntity, callbackHandler, u03Var, pt1Var, cameraPreview, str}) == null) {
            ux1.i("SwanAppCameraManager", "handleAuthorized start");
            if (dt1.b().c(context) && dt1.b().d(context)) {
                ux1.c("SwanAppCameraManager", "has authorize");
                w(unitedSchemeEntity, callbackHandler, u03Var, cameraPreview, pt1Var, str);
                return;
            }
            wv2.g(context, new String[]{"android.permission.CAMERA", "android.permission.RECORD_AUDIO"}, 1, new c(this, unitedSchemeEntity, callbackHandler, u03Var, cameraPreview, pt1Var, str));
        }
    }

    public final void u(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap) {
        HashMap<String, String> params;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048580, this, unitedSchemeEntity, callbackHandler, hashMap) == null) || unitedSchemeEntity == null || callbackHandler == null || hashMap == null || (params = unitedSchemeEntity.getParams()) == null || params.isEmpty()) {
            return;
        }
        String str = params.get("params");
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).optString("timeoutCallback");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        j(unitedSchemeEntity, callbackHandler, hashMap, str2);
    }

    public kw1 v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) ? new pt1(l(unitedSchemeEntity)) : (kw1) invokeL.objValue;
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, u03 u03Var, CameraPreview cameraPreview, pt1 pt1Var, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{unitedSchemeEntity, callbackHandler, u03Var, cameraPreview, pt1Var, str}) == null) {
            ux1.i("SwanAppCameraManager", "start record start");
            HashMap hashMap = new HashMap();
            try {
                z = cameraPreview.m(str);
                try {
                    hashMap.put("tempVideoPath", c83.J(cameraPreview.getVideoPath(), u03Var.b));
                    hashMap.put("tempThumbPath", c83.J(cameraPreview.getThumbPath(), u03Var.b));
                    dt1.b().i(31000, new d(this, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
                } catch (Exception e) {
                    e = e;
                    dt1.b().e(pt1Var.c, pt1Var.b, false);
                    if (r23.b) {
                        e.printStackTrace();
                    }
                    ux1.c("SwanAppCameraManager", "start recording api occur exception");
                    k(unitedSchemeEntity, callbackHandler, z);
                }
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
            k(unitedSchemeEntity, callbackHandler, z);
        }
    }
}
