package d.a.h0.a.x.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.h0.a.x.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45074e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45075f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45076g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f45077h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.x.e.c f45078i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.h0.a.r1.e eVar, d.a.h0.a.x.e.c cVar, CameraPreview cameraPreview, String str) {
            this.f45074e = callbackHandler;
            this.f45075f = unitedSchemeEntity;
            this.f45076g = context;
            this.f45077h = eVar;
            this.f45078i = cVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                f.this.p(this.f45076g, this.f45075f, this.f45074e, this.f45077h, this.f45078i, this.j, this.k);
                return;
            }
            d.a.h0.a.v1.c.c.n(hVar, this.f45074e, this.f45075f);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45079a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45080b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f45081c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f45082d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.x.e.c f45083e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45084f;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, CameraPreview cameraPreview, d.a.h0.a.x.e.c cVar, String str) {
            this.f45079a = unitedSchemeEntity;
            this.f45080b = callbackHandler;
            this.f45081c = eVar;
            this.f45082d = cameraPreview;
            this.f45083e = cVar;
            this.f45084f = str;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            f.this.r(this.f45079a, this.f45080b, this.f45081c, this.f45082d, this.f45083e, this.f45084f);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f45080b, this.f45079a, 10005);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.h0.a.x.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45086a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f45087b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.x.e.c f45088c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45089d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45090e;

        public c(String str, d.a.h0.a.r1.e eVar, d.a.h0.a.x.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f45086a = str;
            this.f45087b = eVar;
            this.f45088c = cVar;
            this.f45089d = callbackHandler;
            this.f45090e = unitedSchemeEntity;
        }

        @Override // d.a.h0.a.x.c.a
        public void onFailure() {
            f.this.k(this.f45090e, this.f45089d, false);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "take picture onFailure");
        }

        @Override // d.a.h0.a.x.c.a
        public void onSuccess(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tempImagePath", d.a.h0.a.a2.b.r(this.f45086a, this.f45087b.f43823f));
            } catch (JSONException e2) {
                d.a.h0.a.c0.c.b("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                d.a.h0.a.x.a b2 = d.a.h0.a.x.a.b();
                d.a.h0.a.x.e.c cVar = this.f45088c;
                b2.e(cVar.f41093g, cVar.o, false);
                if (a0.f44398b) {
                    e2.printStackTrace();
                }
            }
            UnitedSchemeUtility.callCallback(this.f45089d, this.f45090e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
        }
    }

    public f(j jVar) {
        super(jVar, "/swanAPI/camera/takePhoto");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.x.e.c cVar = (d.a.h0.a.x.e.c) q(unitedSchemeEntity);
        if (cVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        d.a.h0.a.a0.c.c.a aVar = (d.a.h0.a.a0.c.c.a) d.a.h0.a.a0.d.a.a(cVar);
        if (aVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "get camera component is null");
            return false;
        }
        CameraPreview q = aVar.q();
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "get camera view is null");
            return false;
        }
        String h2 = d.a.h0.a.a2.b.h(eVar.f43823f);
        if (TextUtils.isEmpty(h2)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "get camera take photo cache path is empty");
            return false;
        }
        eVar.R().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, h2));
        return true;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, d.a.h0.a.x.e.c cVar, CameraPreview cameraPreview, String str) {
        d.a.h0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        d.a.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
    }

    public d.a.h0.a.a0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.h0.a.x.e.c(l(unitedSchemeEntity));
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, CameraPreview cameraPreview, d.a.h0.a.x.e.c cVar, String str) {
        d.a.h0.a.c0.c.g("SwanAppCameraManager", "take photo start");
        cameraPreview.setQuality(cVar.n);
        String g2 = cameraPreview.g(str);
        try {
            cameraPreview.o(g2, new c(g2, eVar, cVar, callbackHandler, unitedSchemeEntity));
        } catch (Exception e2) {
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "take picture api occur exception");
            d.a.h0.a.x.a.b().e(cVar.f41093g, cVar.o, false);
            if (a0.f44398b) {
                e2.printStackTrace();
            }
        }
        d.a.h0.a.c0.c.g("SwanAppCameraManager", "take photo end");
    }
}
