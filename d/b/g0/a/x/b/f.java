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
        public final /* synthetic */ CallbackHandler f47315e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47316f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47317g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f47318h;
        public final /* synthetic */ d.b.g0.a.x.e.c i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.b.g0.a.r1.e eVar, d.b.g0.a.x.e.c cVar, CameraPreview cameraPreview, String str) {
            this.f47315e = callbackHandler;
            this.f47316f = unitedSchemeEntity;
            this.f47317g = context;
            this.f47318h = eVar;
            this.i = cVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                f.this.p(this.f47317g, this.f47316f, this.f47315e, this.f47318h, this.i, this.j, this.k);
                return;
            }
            d.b.g0.a.v1.c.c.n(hVar, this.f47315e, this.f47316f);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47319a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47320b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f47321c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f47322d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.x.e.c f47323e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47324f;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, CameraPreview cameraPreview, d.b.g0.a.x.e.c cVar, String str) {
            this.f47319a = unitedSchemeEntity;
            this.f47320b = callbackHandler;
            this.f47321c = eVar;
            this.f47322d = cameraPreview;
            this.f47323e = cVar;
            this.f47324f = str;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            f.this.r(this.f47319a, this.f47320b, this.f47321c, this.f47322d, this.f47323e, this.f47324f);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", str + "");
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.callCallback(this.f47320b, this.f47319a, 10005);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", str + "");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.g0.a.x.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47326a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f47327b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.x.e.c f47328c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47329d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47330e;

        public c(String str, d.b.g0.a.r1.e eVar, d.b.g0.a.x.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f47326a = str;
            this.f47327b = eVar;
            this.f47328c = cVar;
            this.f47329d = callbackHandler;
            this.f47330e = unitedSchemeEntity;
        }

        @Override // d.b.g0.a.x.c.a
        public void onFailure() {
            f.this.k(this.f47330e, this.f47329d, false);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "take picture onFailure");
        }

        @Override // d.b.g0.a.x.c.a
        public void onSuccess(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tempImagePath", d.b.g0.a.a2.b.r(this.f47326a, this.f47327b.f46132f));
            } catch (JSONException e2) {
                d.b.g0.a.c0.c.b("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                d.b.g0.a.x.a b2 = d.b.g0.a.x.a.b();
                d.b.g0.a.x.e.c cVar = this.f47328c;
                b2.e(cVar.f43506g, cVar.o, false);
                if (a0.f46680b) {
                    e2.printStackTrace();
                }
            }
            UnitedSchemeUtility.callCallback(this.f47329d, this.f47330e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
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
        String h2 = d.b.g0.a.a2.b.h(eVar.f46132f);
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
            d.b.g0.a.x.a.b().e(cVar.f43506g, cVar.o, false);
            if (a0.f46680b) {
                e2.printStackTrace();
            }
        }
        d.b.g0.a.c0.c.g("SwanAppCameraManager", "take photo end");
    }
}
