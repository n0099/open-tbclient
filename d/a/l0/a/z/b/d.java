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
        public final /* synthetic */ CallbackHandler f45923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45924f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45925g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f45926h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.b f45927i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.l0.a.a2.e eVar, d.a.l0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f45923e = callbackHandler;
            this.f45924f = unitedSchemeEntity;
            this.f45925g = context;
            this.f45926h = eVar;
            this.f45927i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            int b2;
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                d.this.r(this.f45925g, this.f45924f, this.f45923e, this.f45926h, this.f45927i, this.j, this.k);
            } else if (iVar != null && iVar.a() != null) {
                String str = "authorize recorder failed : " + d.a.l0.a.e2.c.d.f(b2);
                UnitedSchemeUtility.callCallback(this.f45923e, this.f45924f, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), str));
                d.a.l0.a.e0.d.l("SwanAppAction", str);
            } else {
                d.a.l0.a.e0.d.b("SwanAppAction", "authorize recorder failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45928e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45929f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45930g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f45931h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.b f45932i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, d.a.l0.a.a2.e eVar, d.a.l0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f45928e = unitedSchemeEntity;
            this.f45929f = callbackHandler;
            this.f45930g = context;
            this.f45931h = eVar;
            this.f45932i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                d.this.t(this.f45930g, this.f45928e, this.f45929f, this.f45931h, this.f45932i, this.j, this.k);
            } else if (iVar != null && iVar.a() != null) {
                d.this.s(iVar.b(), this.f45928e, this.f45929f);
            } else {
                d.a.l0.a.e0.d.b("SwanAppAction", "authorize camera failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.l0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45933a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45934b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f45935c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f45936d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.b f45937e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45938f;

        public c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, CameraPreview cameraPreview, d.a.l0.a.z.e.b bVar, String str) {
            this.f45933a = unitedSchemeEntity;
            this.f45934b = callbackHandler;
            this.f45935c = eVar;
            this.f45936d = cameraPreview;
            this.f45937e = bVar;
            this.f45938f = str;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            d.this.w(this.f45933a, this.f45934b, this.f45935c, this.f45936d, this.f45937e, this.f45938f);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            d.this.s(10005, this.f45933a, this.f45934b);
        }
    }

    /* renamed from: d.a.l0.a.z.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0925d implements d.a.l0.a.z.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f45940a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45941b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45942c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f45943d;

        public C0925d(CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            this.f45940a = cameraPreview;
            this.f45941b = unitedSchemeEntity;
            this.f45942c = callbackHandler;
            this.f45943d = hashMap;
        }

        @Override // d.a.l0.a.z.c.b
        public void a() {
            this.f45940a.n();
            this.f45940a.e();
            d.this.u(this.f45941b, this.f45942c, this.f45943d);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "start record timeout");
        }

        @Override // d.a.l0.a.z.c.b
        public void cancel() {
            this.f45940a.n();
            this.f45940a.e();
            d.this.u(this.f45941b, this.f45942c, this.f45943d);
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
        String x = d.a.l0.a.k2.b.x(eVar.f40749f);
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
                hashMap.put("tempVideoPath", d.a.l0.a.k2.b.J(cameraPreview.getVideoPath(), eVar.f40749f));
                hashMap.put("tempThumbPath", d.a.l0.a.k2.b.J(cameraPreview.getThumbPath(), eVar.f40749f));
                d.a.l0.a.z.a.b().i(31000, new C0925d(cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
            } catch (Exception e2) {
                e = e2;
                d.a.l0.a.z.a.b().e(bVar.f40846g, bVar.f40845f, false);
                if (a0.f40949b) {
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
