package d.a.q0.a.z.b;

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
import d.a.q0.a.c2.f.a0;
import d.a.q0.a.e2.c.i;
import d.a.q0.a.e2.c.j.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class f extends d.a.q0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f51884e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f51885f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f51886g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f51887h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.z.e.c f51888i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;
        public final /* synthetic */ f l;

        public a(f fVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.q0.a.a2.e eVar, d.a.q0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
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
            this.f51884e = callbackHandler;
            this.f51885f = unitedSchemeEntity;
            this.f51886g = context;
            this.f51887h = eVar;
            this.f51888i = cVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.q0.a.e2.c.d.h(iVar)) {
                    this.l.p(this.f51886g, this.f51885f, this.f51884e, this.f51887h, this.f51888i, this.j, this.k);
                    return;
                }
                d.a.q0.a.e2.c.d.o(iVar, this.f51884e, this.f51885f);
                d.a.q0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.q0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f51889a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f51890b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f51891c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f51892d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.z.e.c f51893e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f51894f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f51895g;

        public b(f fVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, CameraPreview cameraPreview, d.a.q0.a.z.e.c cVar, String str) {
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
            this.f51895g = fVar;
            this.f51889a = unitedSchemeEntity;
            this.f51890b = callbackHandler;
            this.f51891c = eVar;
            this.f51892d = cameraPreview;
            this.f51893e = cVar;
            this.f51894f = str;
        }

        @Override // d.a.q0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f51895g.r(this.f51889a, this.f51890b, this.f51891c, this.f51892d, this.f51893e, this.f51894f);
                d.a.q0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }

        @Override // d.a.q0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                UnitedSchemeUtility.callCallback(this.f51890b, this.f51889a, 10005);
                d.a.q0.a.e0.d.b("SwanAppCameraManager", str + "");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements d.a.q0.a.z.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51896a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f51897b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.z.e.c f51898c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f51899d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f51900e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f51901f;

        public c(f fVar, String str, d.a.q0.a.a2.e eVar, d.a.q0.a.z.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
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
            this.f51901f = fVar;
            this.f51896a = str;
            this.f51897b = eVar;
            this.f51898c = cVar;
            this.f51899d = callbackHandler;
            this.f51900e = unitedSchemeEntity;
        }

        @Override // d.a.q0.a.z.c.a
        public void onFailure() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f51901f.k(this.f51900e, this.f51899d, false);
                d.a.q0.a.e0.d.b("SwanAppCameraManager", "take picture onFailure");
            }
        }

        @Override // d.a.q0.a.z.c.a
        public void onSuccess(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("tempImagePath", d.a.q0.a.k2.b.J(this.f51896a, this.f51897b.f46683f));
                } catch (JSONException e2) {
                    d.a.q0.a.e0.d.b("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                    d.a.q0.a.z.a b2 = d.a.q0.a.z.a.b();
                    d.a.q0.a.z.e.c cVar = this.f51898c;
                    b2.e(cVar.f46780g, cVar.f46779f, false);
                    if (a0.f46883b) {
                        e2.printStackTrace();
                    }
                }
                UnitedSchemeUtility.callCallback(this.f51899d, this.f51900e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d.a.q0.a.c2.e eVar) {
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
                super((d.a.q0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            d.a.q0.a.z.e.c cVar = (d.a.q0.a.z.e.c) q(unitedSchemeEntity);
            if (cVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.a.q0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            d.a.q0.a.c0.c.c.a aVar = (d.a.q0.a.c0.c.c.a) d.a.q0.a.c0.d.a.a(cVar);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.q0.a.e0.d.b("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = aVar.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.q0.a.e0.d.b("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = d.a.q0.a.k2.b.x(eVar.f46683f);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.q0.a.e0.d.b("SwanAppCameraManager", "get camera take photo cache path is empty");
                return false;
            }
            eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, d.a.q0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, cVar, cameraPreview, str}) == null) {
            d.a.q0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
            d.a.q0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
        }
    }

    public d.a.q0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, unitedSchemeEntity)) == null) ? new d.a.q0.a.z.e.c(l(unitedSchemeEntity)) : (d.a.q0.a.c0.b.b) invokeL.objValue;
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.q0.a.a2.e eVar, CameraPreview cameraPreview, d.a.q0.a.z.e.c cVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str}) == null) {
            d.a.q0.a.e0.d.g("SwanAppCameraManager", "take photo start");
            cameraPreview.setQuality(cVar.n);
            String g2 = cameraPreview.g(str);
            try {
                cameraPreview.o(g2, new c(this, g2, eVar, cVar, callbackHandler, unitedSchemeEntity));
            } catch (Exception e2) {
                d.a.q0.a.e0.d.b("SwanAppCameraManager", "take picture api occur exception");
                d.a.q0.a.z.a.b().e(cVar.f46780g, cVar.f46779f, false);
                if (a0.f46883b) {
                    e2.printStackTrace();
                }
            }
            d.a.q0.a.e0.d.g("SwanAppCameraManager", "take photo end");
        }
    }
}
