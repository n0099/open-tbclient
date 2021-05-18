package d.a.i0.a.z.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.swan.apps.camera.view.CameraPreview;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.i0.a.z.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45780e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45781f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45782g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f45783h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.z.e.c f45784i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.i0.a.a2.e eVar, d.a.i0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
            this.f45780e = callbackHandler;
            this.f45781f = unitedSchemeEntity;
            this.f45782g = context;
            this.f45783h = eVar;
            this.f45784i = cVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                f.this.p(this.f45782g, this.f45781f, this.f45780e, this.f45783h, this.f45784i, this.j, this.k);
                return;
            }
            d.a.i0.a.e2.c.d.o(iVar, this.f45780e, this.f45781f);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.i0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45785a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45786b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f45787c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f45788d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.z.e.c f45789e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45790f;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, CameraPreview cameraPreview, d.a.i0.a.z.e.c cVar, String str) {
            this.f45785a = unitedSchemeEntity;
            this.f45786b = callbackHandler;
            this.f45787c = eVar;
            this.f45788d = cameraPreview;
            this.f45789e = cVar;
            this.f45790f = str;
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            f.this.r(this.f45785a, this.f45786b, this.f45787c, this.f45788d, this.f45789e, this.f45790f);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", str + "");
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f45786b, this.f45785a, 10005);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", str + "");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.i0.a.z.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45792a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f45793b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.z.e.c f45794c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45795d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45796e;

        public c(String str, d.a.i0.a.a2.e eVar, d.a.i0.a.z.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f45792a = str;
            this.f45793b = eVar;
            this.f45794c = cVar;
            this.f45795d = callbackHandler;
            this.f45796e = unitedSchemeEntity;
        }

        @Override // d.a.i0.a.z.c.a
        public void onFailure() {
            f.this.k(this.f45796e, this.f45795d, false);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "take picture onFailure");
        }

        @Override // d.a.i0.a.z.c.a
        public void onSuccess(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tempImagePath", d.a.i0.a.k2.b.J(this.f45792a, this.f45793b.f40575f));
            } catch (JSONException e2) {
                d.a.i0.a.e0.d.b("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                d.a.i0.a.z.a b2 = d.a.i0.a.z.a.b();
                d.a.i0.a.z.e.c cVar = this.f45794c;
                b2.e(cVar.f40672g, cVar.f40671f, false);
                if (a0.f40775b) {
                    e2.printStackTrace();
                }
            }
            UnitedSchemeUtility.callCallback(this.f45795d, this.f45796e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
        }
    }

    public f(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/takePhoto");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        d.a.i0.a.z.e.c cVar = (d.a.i0.a.z.e.c) q(unitedSchemeEntity);
        if (cVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        d.a.i0.a.c0.c.c.a aVar = (d.a.i0.a.c0.c.c.a) d.a.i0.a.c0.d.a.a(cVar);
        if (aVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "get camera component is null");
            return false;
        }
        CameraPreview q = aVar.q();
        if (q == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "get camera view is null");
            return false;
        }
        String x = d.a.i0.a.k2.b.x(eVar.f40575f);
        if (TextUtils.isEmpty(x)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "get camera take photo cache path is empty");
            return false;
        }
        eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, x));
        return true;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, d.a.i0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
        d.a.i0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
        d.a.i0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
    }

    public d.a.i0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.i0.a.z.e.c(l(unitedSchemeEntity));
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, CameraPreview cameraPreview, d.a.i0.a.z.e.c cVar, String str) {
        d.a.i0.a.e0.d.g("SwanAppCameraManager", "take photo start");
        cameraPreview.setQuality(cVar.n);
        String g2 = cameraPreview.g(str);
        try {
            cameraPreview.o(g2, new c(g2, eVar, cVar, callbackHandler, unitedSchemeEntity));
        } catch (Exception e2) {
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "take picture api occur exception");
            d.a.i0.a.z.a.b().e(cVar.f40672g, cVar.f40671f, false);
            if (a0.f40775b) {
                e2.printStackTrace();
            }
        }
        d.a.i0.a.e0.d.g("SwanAppCameraManager", "take photo end");
    }
}
