package d.a.l0.a.z.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.a.l0.a.z.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49597e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49598f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49599g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f49600h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.b f49601i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.l0.a.a2.e eVar, d.a.l0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f49597e = callbackHandler;
            this.f49598f = unitedSchemeEntity;
            this.f49599g = context;
            this.f49600h = eVar;
            this.f49601i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            int b2;
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                d.this.r(this.f49599g, this.f49598f, this.f49597e, this.f49600h, this.f49601i, this.j, this.k);
            } else if (iVar != null && iVar.a() != null) {
                String str = "authorize recorder failed : " + d.a.l0.a.e2.c.d.f(b2);
                UnitedSchemeUtility.callCallback(this.f49597e, this.f49598f, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), str));
                d.a.l0.a.e0.d.l("SwanAppAction", str);
            } else {
                d.a.l0.a.e0.d.b("SwanAppAction", "authorize recorder failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49602e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49603f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49604g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f49605h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.b f49606i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, d.a.l0.a.a2.e eVar, d.a.l0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f49602e = unitedSchemeEntity;
            this.f49603f = callbackHandler;
            this.f49604g = context;
            this.f49605h = eVar;
            this.f49606i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                d.this.t(this.f49604g, this.f49602e, this.f49603f, this.f49605h, this.f49606i, this.j, this.k);
            } else if (iVar != null && iVar.a() != null) {
                d.this.s(iVar.b(), this.f49602e, this.f49603f);
            } else {
                d.a.l0.a.e0.d.b("SwanAppAction", "authorize camera failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.l0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49607a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49608b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f49609c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f49610d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.b f49611e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49612f;

        public c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, CameraPreview cameraPreview, d.a.l0.a.z.e.b bVar, String str) {
            this.f49607a = unitedSchemeEntity;
            this.f49608b = callbackHandler;
            this.f49609c = eVar;
            this.f49610d = cameraPreview;
            this.f49611e = bVar;
            this.f49612f = str;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            d.this.w(this.f49607a, this.f49608b, this.f49609c, this.f49610d, this.f49611e, this.f49612f);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            d.this.s(10005, this.f49607a, this.f49608b);
        }
    }

    /* renamed from: d.a.l0.a.z.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0981d implements d.a.l0.a.z.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f49614a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49615b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49616c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f49617d;

        public C0981d(CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            this.f49614a = cameraPreview;
            this.f49615b = unitedSchemeEntity;
            this.f49616c = callbackHandler;
            this.f49617d = hashMap;
        }

        @Override // d.a.l0.a.z.c.b
        public void a() {
            this.f49614a.n();
            this.f49614a.e();
            d.this.u(this.f49615b, this.f49616c, this.f49617d);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "start record timeout");
        }

        @Override // d.a.l0.a.z.c.b
        public void cancel() {
            this.f49614a.n();
            this.f49614a.e();
            d.this.u(this.f49615b, this.f49616c, this.f49617d);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "start record cancel");
        }
    }

    public d(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/startRecord");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.z.e.b bVar = (d.a.l0.a.z.e.b) v(unitedSchemeEntity);
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        d.a.l0.a.c0.c.c.a aVar = (d.a.l0.a.c0.c.c.a) d.a.l0.a.c0.d.a.a(bVar);
        if (aVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "get camera component is null");
            return false;
        }
        CameraPreview q = aVar.q();
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "get camera view is null");
            return false;
        }
        String x = d.a.l0.a.k2.b.x(eVar.f44425f);
        if (TextUtils.isEmpty(x)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "get camera start record cache path is empty");
            return false;
        }
        eVar.T().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(callbackHandler, unitedSchemeEntity, context, eVar, bVar, q, x));
        return true;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str));
    }

    public final void s(int i2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str = "authorize camera failed : " + d.a.l0.a.e2.c.d.f(i2);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2, str));
        d.a.l0.a.e0.d.l("SwanAppAction", str);
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        d.a.l0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
        if (d.a.l0.a.z.a.b().c(context) && d.a.l0.a.z.a.b().d(context)) {
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "has authorize");
            w(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
            return;
        }
        d.a.l0.a.s1.e.f(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str));
    }

    public final void u(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap<String, String> hashMap) {
        HashMap<String, String> params;
        if (unitedSchemeEntity == null || callbackHandler == null || hashMap == null || (params = unitedSchemeEntity.getParams()) == null || params.isEmpty()) {
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

    public d.a.l0.a.c0.b.b v(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.l0.a.z.e.b(l(unitedSchemeEntity));
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, CameraPreview cameraPreview, d.a.l0.a.z.e.b bVar, String str) {
        boolean z;
        d.a.l0.a.e0.d.g("SwanAppCameraManager", "start record start");
        HashMap hashMap = new HashMap();
        try {
            z = cameraPreview.m(str);
            try {
                hashMap.put("tempVideoPath", d.a.l0.a.k2.b.J(cameraPreview.getVideoPath(), eVar.f44425f));
                hashMap.put("tempThumbPath", d.a.l0.a.k2.b.J(cameraPreview.getThumbPath(), eVar.f44425f));
                d.a.l0.a.z.a.b().i(31000, new C0981d(cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
            } catch (Exception e2) {
                e = e2;
                d.a.l0.a.z.a.b().e(bVar.f44522g, bVar.f44521f, false);
                if (a0.f44625b) {
                    e.printStackTrace();
                }
                d.a.l0.a.e0.d.b("SwanAppCameraManager", "start recording api occur exception");
                k(unitedSchemeEntity, callbackHandler, z);
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        k(unitedSchemeEntity, callbackHandler, z);
    }
}
