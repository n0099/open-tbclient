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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends d.a.l0.a.z.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45956e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45957f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45958g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f45959h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.c f45960i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.l0.a.a2.e eVar, d.a.l0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
            this.f45956e = callbackHandler;
            this.f45957f = unitedSchemeEntity;
            this.f45958g = context;
            this.f45959h = eVar;
            this.f45960i = cVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                f.this.p(this.f45958g, this.f45957f, this.f45956e, this.f45959h, this.f45960i, this.j, this.k);
                return;
            }
            d.a.l0.a.e2.c.d.o(iVar, this.f45956e, this.f45957f);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.l0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45961a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45962b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f45963c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f45964d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.c f45965e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45966f;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, CameraPreview cameraPreview, d.a.l0.a.z.e.c cVar, String str) {
            this.f45961a = unitedSchemeEntity;
            this.f45962b = callbackHandler;
            this.f45963c = eVar;
            this.f45964d = cameraPreview;
            this.f45965e = cVar;
            this.f45966f = str;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            f.this.r(this.f45961a, this.f45962b, this.f45963c, this.f45964d, this.f45965e, this.f45966f);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", str + "");
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f45962b, this.f45961a, 10005);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", str + "");
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.l0.a.z.c.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45968a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f45969b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.c f45970c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45971d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45972e;

        public c(String str, d.a.l0.a.a2.e eVar, d.a.l0.a.z.e.c cVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f45968a = str;
            this.f45969b = eVar;
            this.f45970c = cVar;
            this.f45971d = callbackHandler;
            this.f45972e = unitedSchemeEntity;
        }

        @Override // d.a.l0.a.z.c.a
        public void onFailure() {
            f.this.k(this.f45972e, this.f45971d, false);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "take picture onFailure");
        }

        @Override // d.a.l0.a.z.c.a
        public void onSuccess(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tempImagePath", d.a.l0.a.k2.b.J(this.f45968a, this.f45969b.f40749f));
            } catch (JSONException e2) {
                d.a.l0.a.e0.d.b("SwanAppCameraManager", "take picture onSuccess but json object occur exception");
                d.a.l0.a.z.a b2 = d.a.l0.a.z.a.b();
                d.a.l0.a.z.e.c cVar = this.f45970c;
                b2.e(cVar.f40846g, cVar.f40845f, false);
                if (a0.f40949b) {
                    e2.printStackTrace();
                }
            }
            UnitedSchemeUtility.callCallback(this.f45971d, this.f45972e, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0));
        }
    }

    public f(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/takePhoto");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.z.e.c cVar = (d.a.l0.a.z.e.c) q(unitedSchemeEntity);
        if (cVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        d.a.l0.a.c0.c.c.a aVar = (d.a.l0.a.c0.c.c.a) d.a.l0.a.c0.d.a.a(cVar);
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
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "get camera take photo cache path is empty");
            return false;
        }
        eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, eVar, cVar, q, x));
        return true;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.z.e.c cVar, CameraPreview cameraPreview, String str) {
        d.a.l0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
        d.a.l0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new b(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, cVar, str));
    }

    public d.a.l0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.l0.a.z.e.c(l(unitedSchemeEntity));
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, CameraPreview cameraPreview, d.a.l0.a.z.e.c cVar, String str) {
        d.a.l0.a.e0.d.g("SwanAppCameraManager", "take photo start");
        cameraPreview.setQuality(cVar.n);
        String g2 = cameraPreview.g(str);
        try {
            cameraPreview.o(g2, new c(g2, eVar, cVar, callbackHandler, unitedSchemeEntity));
        } catch (Exception e2) {
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "take picture api occur exception");
            d.a.l0.a.z.a.b().e(cVar.f40846g, cVar.f40845f, false);
            if (a0.f40949b) {
                e2.printStackTrace();
            }
        }
        d.a.l0.a.e0.d.g("SwanAppCameraManager", "take photo end");
    }
}
