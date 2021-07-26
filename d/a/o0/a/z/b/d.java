package d.a.o0.a.z.b;

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
import d.a.o0.a.c2.f.a0;
import d.a.o0.a.e2.c.i;
import d.a.o0.a.e2.c.j.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends d.a.o0.a.z.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49053e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49054f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49055g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f49056h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.z.e.b f49057i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;
        public final /* synthetic */ d l;

        public a(d dVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.o0.a.a2.e eVar, d.a.o0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, callbackHandler, unitedSchemeEntity, context, eVar, bVar, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = dVar;
            this.f49053e = callbackHandler;
            this.f49054f = unitedSchemeEntity;
            this.f49055g = context;
            this.f49056h = eVar;
            this.f49057i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            int b2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.o0.a.e2.c.d.h(iVar)) {
                    this.l.r(this.f49055g, this.f49054f, this.f49053e, this.f49056h, this.f49057i, this.j, this.k);
                } else if (iVar != null && iVar.a() != null) {
                    String str = "authorize recorder failed : " + d.a.o0.a.e2.c.d.f(b2);
                    UnitedSchemeUtility.callCallback(this.f49053e, this.f49054f, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), str));
                    d.a.o0.a.e0.d.l("SwanAppAction", str);
                } else {
                    d.a.o0.a.e0.d.b("SwanAppAction", "authorize recorder failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements d.a.o0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49058e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49059f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49060g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f49061h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.z.e.b f49062i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;
        public final /* synthetic */ d l;

        public b(d dVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, d.a.o0.a.a2.e eVar, d.a.o0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.l = dVar;
            this.f49058e = unitedSchemeEntity;
            this.f49059f = callbackHandler;
            this.f49060g = context;
            this.f49061h = eVar;
            this.f49062i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.o0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.o0.a.e2.c.d.h(iVar)) {
                    this.l.t(this.f49060g, this.f49058e, this.f49059f, this.f49061h, this.f49062i, this.j, this.k);
                } else if (iVar != null && iVar.a() != null) {
                    this.l.s(iVar.b(), this.f49058e, this.f49059f);
                } else {
                    d.a.o0.a.e0.d.b("SwanAppAction", "authorize camera failed : result is invalid");
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements d.a.o0.a.s1.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49063a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49064b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.a2.e f49065c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f49066d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.a.z.e.b f49067e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49068f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f49069g;

        public c(d dVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, CameraPreview cameraPreview, d.a.o0.a.z.e.b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49069g = dVar;
            this.f49063a = unitedSchemeEntity;
            this.f49064b = callbackHandler;
            this.f49065c = eVar;
            this.f49066d = cameraPreview;
            this.f49067e = bVar;
            this.f49068f = str;
        }

        @Override // d.a.o0.a.s1.f
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f49069g.w(this.f49063a, this.f49064b, this.f49065c, this.f49066d, this.f49067e, this.f49068f);
            }
        }

        @Override // d.a.o0.a.s1.f
        public void b(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
                this.f49069g.s(10005, this.f49063a, this.f49064b);
            }
        }
    }

    /* renamed from: d.a.o0.a.z.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1002d implements d.a.o0.a.z.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f49070a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49071b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49072c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f49073d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f49074e;

        public C1002d(d dVar, CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49074e = dVar;
            this.f49070a = cameraPreview;
            this.f49071b = unitedSchemeEntity;
            this.f49072c = callbackHandler;
            this.f49073d = hashMap;
        }

        @Override // d.a.o0.a.z.c.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49070a.n();
                this.f49070a.e();
                this.f49074e.u(this.f49071b, this.f49072c, this.f49073d);
                d.a.o0.a.e0.d.b("SwanAppCameraManager", "start record timeout");
            }
        }

        @Override // d.a.o0.a.z.c.b
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f49070a.n();
                this.f49070a.e();
                this.f49074e.u(this.f49071b, this.f49072c, this.f49073d);
                d.a.o0.a.e0.d.b("SwanAppCameraManager", "start record cancel");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(d.a.o0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/startRecord");
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
                super((d.a.o0.a.c2.e) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.o0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, context, unitedSchemeEntity, callbackHandler, eVar)) == null) {
            d.a.o0.a.z.e.b bVar = (d.a.o0.a.z.e.b) v(unitedSchemeEntity);
            if (bVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                d.a.o0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
                return false;
            }
            d.a.o0.a.c0.c.c.a aVar = (d.a.o0.a.c0.c.c.a) d.a.o0.a.c0.d.a.a(bVar);
            if (aVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.o0.a.e0.d.b("SwanAppCameraManager", "get camera component is null");
                return false;
            }
            CameraPreview q = aVar.q();
            if (q == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.o0.a.e0.d.b("SwanAppCameraManager", "get camera view is null");
                return false;
            }
            String x = d.a.o0.a.k2.b.x(eVar.f43885f);
            if (TextUtils.isEmpty(x)) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                d.a.o0.a.e0.d.b("SwanAppCameraManager", "get camera start record cache path is empty");
                return false;
            }
            eVar.T().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(this, callbackHandler, unitedSchemeEntity, context, eVar, bVar, q, x));
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, d.a.o0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview, str}) == null) {
            eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(this, unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str));
        }
    }

    public final void s(int i2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, unitedSchemeEntity, callbackHandler) == null) {
            String str = "authorize camera failed : " + d.a.o0.a.e2.c.d.f(i2);
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2, str));
            d.a.o0.a.e0.d.l("SwanAppAction", str);
        }
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, d.a.o0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, unitedSchemeEntity, callbackHandler, eVar, bVar, cameraPreview, str}) == null) {
            d.a.o0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
            if (d.a.o0.a.z.a.b().c(context) && d.a.o0.a.z.a.b().d(context)) {
                d.a.o0.a.e0.d.b("SwanAppCameraManager", "has authorize");
                w(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
                return;
            }
            d.a.o0.a.s1.e.f(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(this, unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str));
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
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        j(unitedSchemeEntity, callbackHandler, hashMap, str2);
    }

    public d.a.o0.a.c0.b.b v(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, unitedSchemeEntity)) == null) ? new d.a.o0.a.z.e.b(l(unitedSchemeEntity)) : (d.a.o0.a.c0.b.b) invokeL.objValue;
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.o0.a.a2.e eVar, CameraPreview cameraPreview, d.a.o0.a.z.e.b bVar, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str}) == null) {
            d.a.o0.a.e0.d.g("SwanAppCameraManager", "start record start");
            HashMap hashMap = new HashMap();
            try {
                z = cameraPreview.m(str);
                try {
                    hashMap.put("tempVideoPath", d.a.o0.a.k2.b.J(cameraPreview.getVideoPath(), eVar.f43885f));
                    hashMap.put("tempThumbPath", d.a.o0.a.k2.b.J(cameraPreview.getThumbPath(), eVar.f43885f));
                    d.a.o0.a.z.a.b().i(31000, new C1002d(this, cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
                } catch (Exception e2) {
                    e = e2;
                    d.a.o0.a.z.a.b().e(bVar.f43982g, bVar.f43981f, false);
                    if (a0.f44085b) {
                        e.printStackTrace();
                    }
                    d.a.o0.a.e0.d.b("SwanAppCameraManager", "start recording api occur exception");
                    k(unitedSchemeEntity, callbackHandler, z);
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
            }
            k(unitedSchemeEntity, callbackHandler, z);
        }
    }
}
