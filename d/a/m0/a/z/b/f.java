package d.a.m0.a.z.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.m0.a.z.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49738e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49739f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49740g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f49741h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.z.e.c f49742i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.m0.a.a2.e eVar, d.a.m0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
            this.f49738e = callbackHandler;
            this.f49739f = unitedSchemeEntity;
            this.f49740g = context;
            this.f49741h = eVar;
            this.f49742i = cVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                f.this.p(this.f49740g, this.f49739f, this.f49738e, this.f49741h, this.f49742i, this.j, this.k);
                return;
            }
            d.a.m0.a.e2.c.d.o(iVar, this.f49738e, this.f49739f);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.m0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49743a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49744b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f49745c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f49746d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.z.e.c f49747e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49748f;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, CameraPreview cameraPreview, d.a.m0.a.z.e.c cVar, String str) {
            this.f49743a = unitedSchemeEntity;
            this.f49744b = callbackHandler;
            this.f49745c = eVar;
            this.f49746d = cameraPreview;
            this.f49747e = cVar;
            this.f49748f = str;
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            f.this.r(this.f49743a, this.f49744b, this.f49745c, this.f49746d, this.f49747e, this.f49748f);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", str + "");
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f49744b, this.f49743a, 10005);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", str + "");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.m0.a.z.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f49750a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f49751b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.z.e.c f49752c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49753d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49754e;

        public c(String str, d.a.m0.a.a2.e eVar, d.a.m0.a.z.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f49750a = str;
            this.f49751b = eVar;
            this.f49752c = cVar;
            this.f49753d = callbackHandler;
            this.f49754e = unitedSchemeEntity;
        }

        @Override // d.a.m0.a.z.c.a
        public void onFailure() {
            f.this.k(this.f49754e, this.f49753d, false);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "take picture onFailure");
        }

        @Override // d.a.m0.a.z.c.a
        public void onSuccess(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tempImagePath", d.a.m0.a.k2.b.J(this.f49750a, this.f49751b.f44533f));
            } catch (JSONException e2) {
                d.a.m0.a.e0.d.b("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                d.a.m0.a.z.a b2 = d.a.m0.a.z.a.b();
                d.a.m0.a.z.e.c cVar = this.f49752c;
                b2.e(cVar.f44630g, cVar.f44629f, false);
                if (a0.f44733b) {
                    e2.printStackTrace();
                }
            }
            UnitedSchemeUtility.callCallback(this.f49753d, this.f49754e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
        }
    }

    public f(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/takePhoto");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.z.e.c cVar = (d.a.m0.a.z.e.c) q(unitedSchemeEntity);
        if (cVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        d.a.m0.a.c0.c.c.a aVar = (d.a.m0.a.c0.c.c.a) d.a.m0.a.c0.d.a.a(cVar);
        if (aVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "get camera component is null");
            return false;
        }
        CameraPreview q = aVar.q();
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "get camera view is null");
            return false;
        }
        String x = d.a.m0.a.k2.b.x(eVar.f44533f);
        if (TextUtils.isEmpty(x)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "get camera take photo cache path is empty");
            return false;
        }
        eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, x));
        return true;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, d.a.m0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
        d.a.m0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
        d.a.m0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
    }

    public d.a.m0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.m0.a.z.e.c(l(unitedSchemeEntity));
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, CameraPreview cameraPreview, d.a.m0.a.z.e.c cVar, String str) {
        d.a.m0.a.e0.d.g("SwanAppCameraManager", "take photo start");
        cameraPreview.setQuality(cVar.n);
        String g2 = cameraPreview.g(str);
        try {
            cameraPreview.o(g2, new c(g2, eVar, cVar, callbackHandler, unitedSchemeEntity));
        } catch (Exception e2) {
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "take picture api occur exception");
            d.a.m0.a.z.a.b().e(cVar.f44630g, cVar.f44629f, false);
            if (a0.f44733b) {
                e2.printStackTrace();
            }
        }
        d.a.m0.a.e0.d.g("SwanAppCameraManager", "take photo end");
    }
}
