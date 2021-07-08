package d.a.n0.a.z.b;

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
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.n0.a.c2.f.a0;
import d.a.n0.a.e2.c.i;
import d.a.n0.a.e2.c.j.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class f extends d.a.n0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48582e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48583f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f48584g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f48585h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.z.e.c f48586i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;
        public final /* synthetic */ f l;

        public a(f fVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.n0.a.a2.e eVar, d.a.n0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, callbackHandler, unitedSchemeEntity, context, eVar, cVar, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = fVar;
            this.f48582e = callbackHandler;
            this.f48583f = unitedSchemeEntity;
            this.f48584g = context;
            this.f48585h = eVar;
            this.f48586i = cVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.n0.a.e2.c.d.h(iVar)) {
                    this.l.p(this.f48584g, this.f48583f, this.f48582e, this.f48585h, this.f48586i, this.j, this.k);
                    return;
                }
                d.a.n0.a.e2.c.d.o(iVar, this.f48582e, this.f48583f);
                d.a.n0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.n0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48587a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48588b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f48589c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f48590d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.z.e.c f48591e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48592f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f48593g;

        public b(f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar, CameraPreview cameraPreview, d.a.n0.a.z.e.c cVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48593g = fVar;
            this.f48587a = unitedSchemeEntity;
            this.f48588b = callbackHandler;
            this.f48589c = eVar;
            this.f48590d = cameraPreview;
            this.f48591e = cVar;
            this.f48592f = str;
        }

        @Override // d.a.n0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f48593g.r(this.f48587a, this.f48588b, this.f48589c, this.f48590d, this.f48591e, this.f48592f);
                d.a.n0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }

        @Override // d.a.n0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f48588b, this.f48587a, 10005);
                d.a.n0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.n0.a.z.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48594a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.a2.e f48595b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.z.e.c f48596c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48597d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f48598e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f48599f;

        public c(f fVar, String str, d.a.n0.a.a2.e eVar, d.a.n0.a.z.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, str, eVar, cVar, callbackHandler, unitedSchemeEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48599f = fVar;
            this.f48594a = str;
            this.f48595b = eVar;
            this.f48596c = cVar;
            this.f48597d = callbackHandler;
            this.f48598e = unitedSchemeEntity;
        }

        @Override // d.a.n0.a.z.c.a
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f48599f.k(this.f48598e, this.f48597d, false);
                d.a.n0.a.e0.d.b("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // d.a.n0.a.z.c.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", d.a.n0.a.k2.b.J(this.f48594a, this.f48595b.f43381f));
                } catch (JSONException e2) {
                    d.a.n0.a.e0.d.b("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    d.a.n0.a.z.a b2 = d.a.n0.a.z.a.b();
                    d.a.n0.a.z.e.c cVar = this.f48596c;
                    b2.e(cVar.f43478g, cVar.f43477f, false);
                    if (a0.f43581b) {
                        e2.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.f48597d, this.f48598e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d.a.n0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/takePhoto");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.n0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.n0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            d.a.n0.a.z.e.c cVar = (d.a.n0.a.z.e.c) q(unitedSchemeEntity);
            if (cVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.a.n0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            d.a.n0.a.c0.c.c.a aVar = (d.a.n0.a.c0.c.c.a) d.a.n0.a.c0.d.a.a(cVar);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.n0.a.e0.d.b("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = aVar.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.n0.a.e0.d.b("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = d.a.n0.a.k2.b.x(eVar.f43381f);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.n0.a.e0.d.b("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar, d.a.n0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, cVar, cameraPreview, str}) == null) {
            d.a.n0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
            d.a.n0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
        }
    }

    public d.a.n0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) ? new d.a.n0.a.z.e.c(l(unitedSchemeEntity)) : (d.a.n0.a.c0.b.b) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.n0.a.a2.e eVar, CameraPreview cameraPreview, d.a.n0.a.z.e.c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str}) == null) {
            d.a.n0.a.e0.d.g("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(cVar.n);
            String g2 = cameraPreview.g(str);
            try {
                cameraPreview.o(g2, new c(this, g2, eVar, cVar, callbackHandler, unitedSchemeEntity));
            } catch (Exception e2) {
                d.a.n0.a.e0.d.b("SwanAppCameraManager", "take picture api occur exception");
                d.a.n0.a.z.a.b().e(cVar.f43478g, cVar.f43477f, false);
                if (a0.f43581b) {
                    e2.printStackTrace();
                }
            }
            d.a.n0.a.e0.d.g("SwanAppCameraManager", "take photo end");
        }
    }
}
