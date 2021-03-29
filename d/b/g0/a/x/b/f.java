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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.b.g0.a.x.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46923e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46924f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46925g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46926h;
        public final /* synthetic */ d.b.g0.a.x.e.c i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.b.g0.a.r1.e eVar, d.b.g0.a.x.e.c cVar, CameraPreview cameraPreview, String str) {
            this.f46923e = callbackHandler;
            this.f46924f = unitedSchemeEntity;
            this.f46925g = context;
            this.f46926h = eVar;
            this.i = cVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                f.this.p(this.f46925g, this.f46924f, this.f46923e, this.f46926h, this.i, this.j, this.k);
                return;
            }
            d.b.g0.a.v1.c.c.n(hVar, this.f46923e, this.f46924f);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46927a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46928b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46929c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f46930d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.x.e.c f46931e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46932f;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, CameraPreview cameraPreview, d.b.g0.a.x.e.c cVar, String str) {
            this.f46927a = unitedSchemeEntity;
            this.f46928b = callbackHandler;
            this.f46929c = eVar;
            this.f46930d = cameraPreview;
            this.f46931e = cVar;
            this.f46932f = str;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            f.this.r(this.f46927a, this.f46928b, this.f46929c, this.f46930d, this.f46931e, this.f46932f);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", str + "");
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.callCallback(this.f46928b, this.f46927a, 10005);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", str + "");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.g0.a.x.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46934a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46935b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.x.e.c f46936c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46937d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46938e;

        public c(String str, d.b.g0.a.r1.e eVar, d.b.g0.a.x.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f46934a = str;
            this.f46935b = eVar;
            this.f46936c = cVar;
            this.f46937d = callbackHandler;
            this.f46938e = unitedSchemeEntity;
        }

        @Override // d.b.g0.a.x.c.a
        public void onFailure() {
            f.this.k(this.f46938e, this.f46937d, false);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "take picture onFailure");
        }

        @Override // d.b.g0.a.x.c.a
        public void onSuccess(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tempImagePath", d.b.g0.a.a2.b.r(this.f46934a, this.f46935b.f45740f));
            } catch (JSONException e2) {
                d.b.g0.a.c0.c.b("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                d.b.g0.a.x.a b2 = d.b.g0.a.x.a.b();
                d.b.g0.a.x.e.c cVar = this.f46936c;
                b2.e(cVar.f43114g, cVar.o, false);
                if (a0.f46288b) {
                    e2.printStackTrace();
                }
            }
            UnitedSchemeUtility.callCallback(this.f46937d, this.f46938e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/camera/takePhoto");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.x.e.c cVar = (d.b.g0.a.x.e.c) q(unitedSchemeEntity);
        if (cVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        d.b.g0.a.a0.c.c.a aVar = (d.b.g0.a.a0.c.c.a) d.b.g0.a.a0.d.a.a(cVar);
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
        String h2 = d.b.g0.a.a2.b.h(eVar.f45740f);
        if (TextUtils.isEmpty(h2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "get camera take photo cache path is empty");
            return false;
        }
        eVar.R().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, h2));
        return true;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, d.b.g0.a.x.e.c cVar, CameraPreview cameraPreview, String str) {
        d.b.g0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        d.b.g0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
    }

    public d.b.g0.a.a0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.b.g0.a.x.e.c(l(unitedSchemeEntity));
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, CameraPreview cameraPreview, d.b.g0.a.x.e.c cVar, String str) {
        d.b.g0.a.c0.c.g("SwanAppCameraManager", "take photo start");
        cameraPreview.setQuality(cVar.n);
        String g2 = cameraPreview.g(str);
        try {
            cameraPreview.o(g2, new c(g2, eVar, cVar, callbackHandler, unitedSchemeEntity));
        } catch (Exception e2) {
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "take picture api occur exception");
            d.b.g0.a.x.a.b().e(cVar.f43114g, cVar.o, false);
            if (a0.f46288b) {
                e2.printStackTrace();
            }
        }
        d.b.g0.a.c0.c.g("SwanAppCameraManager", "take photo end");
    }
}
