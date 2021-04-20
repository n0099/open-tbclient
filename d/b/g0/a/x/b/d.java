package d.b.g0.a.x.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.webkit.sdk.PermissionRequest;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.b.g0.a.x.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47285e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47286f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47287g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f47288h;
        public final /* synthetic */ d.b.g0.a.x.e.b i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.b.g0.a.r1.e eVar, d.b.g0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f47285e = callbackHandler;
            this.f47286f = unitedSchemeEntity;
            this.f47287g = context;
            this.f47288h = eVar;
            this.i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            int b2;
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                d.this.r(this.f47287g, this.f47286f, this.f47285e, this.f47288h, this.i, this.j, this.k);
            } else if (hVar != null && hVar.a() != null) {
                String str = "authorize recorder failed : " + d.b.g0.a.v1.c.c.f(b2);
                UnitedSchemeUtility.callCallback(this.f47285e, this.f47286f, UnitedSchemeUtility.wrapCallbackParams(hVar.b(), str));
                d.b.g0.a.c0.c.l("SwanAppAction", str);
            } else {
                d.b.g0.a.c0.c.b("SwanAppAction", "authorize recorder failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47289e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47290f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47291g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f47292h;
        public final /* synthetic */ d.b.g0.a.x.e.b i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, d.b.g0.a.r1.e eVar, d.b.g0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f47289e = unitedSchemeEntity;
            this.f47290f = callbackHandler;
            this.f47291g = context;
            this.f47292h = eVar;
            this.i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                d.this.t(this.f47291g, this.f47289e, this.f47290f, this.f47292h, this.i, this.j, this.k);
            } else if (hVar != null && hVar.a() != null) {
                d.this.s(hVar.b(), this.f47289e, this.f47290f);
            } else {
                d.b.g0.a.c0.c.b("SwanAppAction", "authorize camera failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47293a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47294b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f47295c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f47296d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.x.e.b f47297e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47298f;

        public c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, CameraPreview cameraPreview, d.b.g0.a.x.e.b bVar, String str) {
            this.f47293a = unitedSchemeEntity;
            this.f47294b = callbackHandler;
            this.f47295c = eVar;
            this.f47296d = cameraPreview;
            this.f47297e = bVar;
            this.f47298f = str;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            d.this.w(this.f47293a, this.f47294b, this.f47295c, this.f47296d, this.f47297e, this.f47298f);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            d.this.s(10005, this.f47293a, this.f47294b);
        }
    }

    /* renamed from: d.b.g0.a.x.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0889d implements d.b.g0.a.x.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f47300a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47301b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47302c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f47303d;

        public C0889d(CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            this.f47300a = cameraPreview;
            this.f47301b = unitedSchemeEntity;
            this.f47302c = callbackHandler;
            this.f47303d = hashMap;
        }

        @Override // d.b.g0.a.x.c.b
        public void a() {
            this.f47300a.n();
            this.f47300a.e();
            d.this.u(this.f47301b, this.f47302c, this.f47303d);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "start record timeout");
        }

        @Override // d.b.g0.a.x.c.b
        public void cancel() {
            this.f47300a.n();
            this.f47300a.e();
            d.this.u(this.f47301b, this.f47302c, this.f47303d);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "start record cancel");
        }
    }

    public d(j jVar) {
        super(jVar, "/swanAPI/camera/startRecord");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.x.e.b bVar = (d.b.g0.a.x.e.b) v(unitedSchemeEntity);
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        d.b.g0.a.a0.c.c.a aVar = (d.b.g0.a.a0.c.c.a) d.b.g0.a.a0.d.a.a(bVar);
        if (aVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "get camera component is null");
            return false;
        }
        CameraPreview q = aVar.q();
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "get camera view is null");
            return false;
        }
        String h2 = d.b.g0.a.a2.b.h(eVar.f46132f);
        if (TextUtils.isEmpty(h2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "get camera start record cache path is empty");
            return false;
        }
        eVar.R().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(callbackHandler, unitedSchemeEntity, context, eVar, bVar, q, h2));
        return true;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, d.b.g0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
        eVar.R().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str));
    }

    public final void s(int i, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str = "authorize camera failed : " + d.b.g0.a.v1.c.c.f(i);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i, str));
        d.b.g0.a.c0.c.l("SwanAppAction", str);
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, d.b.g0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
        d.b.g0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        if (d.b.g0.a.x.a.b().c(context) && d.b.g0.a.x.a.b().d(context)) {
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "has authorize");
            w(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
            return;
        }
        d.b.g0.a.k1.a.b(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str));
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

    public d.b.g0.a.a0.b.b v(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.b.g0.a.x.e.b(l(unitedSchemeEntity));
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, CameraPreview cameraPreview, d.b.g0.a.x.e.b bVar, String str) {
        boolean z;
        d.b.g0.a.c0.c.g("SwanAppCameraManager", "start record start");
        HashMap hashMap = new HashMap();
        try {
            z = cameraPreview.m(str);
            try {
                hashMap.put("tempVideoPath", d.b.g0.a.a2.b.r(cameraPreview.getVideoPath(), eVar.f46132f));
                hashMap.put("tempThumbPath", d.b.g0.a.a2.b.r(cameraPreview.getThumbPath(), eVar.f46132f));
                d.b.g0.a.x.a.b().i(31000, new C0889d(cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
            } catch (Exception e2) {
                e = e2;
                d.b.g0.a.x.a.b().e(bVar.f43506g, bVar.n, false);
                if (a0.f46680b) {
                    e.printStackTrace();
                }
                d.b.g0.a.c0.c.b("SwanAppCameraManager", "start recording api occur exception");
                k(unitedSchemeEntity, callbackHandler, z);
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        k(unitedSchemeEntity, callbackHandler, z);
    }
}
