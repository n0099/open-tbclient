package d.b.h0.a.x.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.webkit.sdk.PermissionRequest;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.b.h0.a.x.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47644e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47645f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47646g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47647h;
        public final /* synthetic */ d.b.h0.a.x.e.c i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.b.h0.a.r1.e eVar, d.b.h0.a.x.e.c cVar, CameraPreview cameraPreview, String str) {
            this.f47644e = callbackHandler;
            this.f47645f = unitedSchemeEntity;
            this.f47646g = context;
            this.f47647h = eVar;
            this.i = cVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                f.this.p(this.f47646g, this.f47645f, this.f47644e, this.f47647h, this.i, this.j, this.k);
                return;
            }
            d.b.h0.a.v1.c.c.n(hVar, this.f47644e, this.f47645f);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47648a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47649b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47650c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f47651d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.x.e.c f47652e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47653f;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, CameraPreview cameraPreview, d.b.h0.a.x.e.c cVar, String str) {
            this.f47648a = unitedSchemeEntity;
            this.f47649b = callbackHandler;
            this.f47650c = eVar;
            this.f47651d = cameraPreview;
            this.f47652e = cVar;
            this.f47653f = str;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            f.this.r(this.f47648a, this.f47649b, this.f47650c, this.f47651d, this.f47652e, this.f47653f);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.callCallback(this.f47649b, this.f47648a, 10005);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.h0.a.x.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47655a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47656b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.x.e.c f47657c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47658d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47659e;

        public c(String str, d.b.h0.a.r1.e eVar, d.b.h0.a.x.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f47655a = str;
            this.f47656b = eVar;
            this.f47657c = cVar;
            this.f47658d = callbackHandler;
            this.f47659e = unitedSchemeEntity;
        }

        @Override // d.b.h0.a.x.c.a
        public void onFailure() {
            f.this.k(this.f47659e, this.f47658d, false);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "take picture onFailure");
        }

        @Override // d.b.h0.a.x.c.a
        public void onSuccess(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tempImagePath", d.b.h0.a.a2.b.r(this.f47655a, this.f47656b.f46461f));
            } catch (JSONException e2) {
                d.b.h0.a.c0.c.b("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                d.b.h0.a.x.a b2 = d.b.h0.a.x.a.b();
                d.b.h0.a.x.e.c cVar = this.f47657c;
                b2.e(cVar.f43835g, cVar.o, false);
                if (a0.f47009b) {
                    e2.printStackTrace();
                }
            }
            UnitedSchemeUtility.callCallback(this.f47658d, this.f47659e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/camera/takePhoto");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.x.e.c cVar = (d.b.h0.a.x.e.c) q(unitedSchemeEntity);
        if (cVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        d.b.h0.a.a0.c.c.a aVar = (d.b.h0.a.a0.c.c.a) d.b.h0.a.a0.d.a.a(cVar);
        if (aVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "get camera component is null");
            return false;
        }
        CameraPreview q = aVar.q();
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "get camera view is null");
            return false;
        }
        String h2 = d.b.h0.a.a2.b.h(eVar.f46461f);
        if (TextUtils.isEmpty(h2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "get camera take photo cache path is empty");
            return false;
        }
        eVar.R().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, h2));
        return true;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, d.b.h0.a.x.e.c cVar, CameraPreview cameraPreview, String str) {
        d.b.h0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        d.b.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
    }

    public d.b.h0.a.a0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.b.h0.a.x.e.c(l(unitedSchemeEntity));
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, CameraPreview cameraPreview, d.b.h0.a.x.e.c cVar, String str) {
        d.b.h0.a.c0.c.g("SwanAppCameraManager", "take photo start");
        cameraPreview.setQuality(cVar.n);
        String g2 = cameraPreview.g(str);
        try {
            cameraPreview.o(g2, new c(g2, eVar, cVar, callbackHandler, unitedSchemeEntity));
        } catch (Exception e2) {
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "take picture api occur exception");
            d.b.h0.a.x.a.b().e(cVar.f43835g, cVar.o, false);
            if (a0.f47009b) {
                e2.printStackTrace();
            }
        }
        d.b.h0.a.c0.c.g("SwanAppCameraManager", "take photo end");
    }
}
