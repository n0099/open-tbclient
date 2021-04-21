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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.b.h0.a.x.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47614e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47615f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47616g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47617h;
        public final /* synthetic */ d.b.h0.a.x.e.b i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.b.h0.a.r1.e eVar, d.b.h0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f47614e = callbackHandler;
            this.f47615f = unitedSchemeEntity;
            this.f47616g = context;
            this.f47617h = eVar;
            this.i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            int b2;
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                d.this.r(this.f47616g, this.f47615f, this.f47614e, this.f47617h, this.i, this.j, this.k);
            } else if (hVar != null && hVar.a() != null) {
                String str = "authorize recorder failed : " + d.b.h0.a.v1.c.c.f(b2);
                UnitedSchemeUtility.callCallback(this.f47614e, this.f47615f, UnitedSchemeUtility.wrapCallbackParams(hVar.b(), str));
                d.b.h0.a.c0.c.l("SwanAppAction", str);
            } else {
                d.b.h0.a.c0.c.b("SwanAppAction", "authorize recorder failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47618e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47619f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47620g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47621h;
        public final /* synthetic */ d.b.h0.a.x.e.b i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, d.b.h0.a.r1.e eVar, d.b.h0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f47618e = unitedSchemeEntity;
            this.f47619f = callbackHandler;
            this.f47620g = context;
            this.f47621h = eVar;
            this.i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                d.this.t(this.f47620g, this.f47618e, this.f47619f, this.f47621h, this.i, this.j, this.k);
            } else if (hVar != null && hVar.a() != null) {
                d.this.s(hVar.b(), this.f47618e, this.f47619f);
            } else {
                d.b.h0.a.c0.c.b("SwanAppAction", "authorize camera failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47622a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47623b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47624c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f47625d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.x.e.b f47626e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47627f;

        public c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, CameraPreview cameraPreview, d.b.h0.a.x.e.b bVar, String str) {
            this.f47622a = unitedSchemeEntity;
            this.f47623b = callbackHandler;
            this.f47624c = eVar;
            this.f47625d = cameraPreview;
            this.f47626e = bVar;
            this.f47627f = str;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            d.this.w(this.f47622a, this.f47623b, this.f47624c, this.f47625d, this.f47626e, this.f47627f);
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            d.this.s(10005, this.f47622a, this.f47623b);
        }
    }

    /* renamed from: d.b.h0.a.x.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0909d implements d.b.h0.a.x.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f47629a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47630b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47631c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f47632d;

        public C0909d(CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            this.f47629a = cameraPreview;
            this.f47630b = unitedSchemeEntity;
            this.f47631c = callbackHandler;
            this.f47632d = hashMap;
        }

        @Override // d.b.h0.a.x.c.b
        public void a() {
            this.f47629a.n();
            this.f47629a.e();
            d.this.u(this.f47630b, this.f47631c, this.f47632d);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "start record timeout");
        }

        @Override // d.b.h0.a.x.c.b
        public void cancel() {
            this.f47629a.n();
            this.f47629a.e();
            d.this.u(this.f47630b, this.f47631c, this.f47632d);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "start record cancel");
        }
    }

    public d(j jVar) {
        super(jVar, "/swanAPI/camera/startRecord");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.x.e.b bVar = (d.b.h0.a.x.e.b) v(unitedSchemeEntity);
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        d.b.h0.a.a0.c.c.a aVar = (d.b.h0.a.a0.c.c.a) d.b.h0.a.a0.d.a.a(bVar);
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
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "get camera start record cache path is empty");
            return false;
        }
        eVar.R().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(callbackHandler, unitedSchemeEntity, context, eVar, bVar, q, h2));
        return true;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, d.b.h0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
        eVar.R().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str));
    }

    public final void s(int i, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str = "authorize camera failed : " + d.b.h0.a.v1.c.c.f(i);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i, str));
        d.b.h0.a.c0.c.l("SwanAppAction", str);
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, d.b.h0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
        d.b.h0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        if (d.b.h0.a.x.a.b().c(context) && d.b.h0.a.x.a.b().d(context)) {
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "has authorize");
            w(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
            return;
        }
        d.b.h0.a.k1.a.b(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str));
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

    public d.b.h0.a.a0.b.b v(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.b.h0.a.x.e.b(l(unitedSchemeEntity));
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, CameraPreview cameraPreview, d.b.h0.a.x.e.b bVar, String str) {
        boolean z;
        d.b.h0.a.c0.c.g("SwanAppCameraManager", "start record start");
        HashMap hashMap = new HashMap();
        try {
            z = cameraPreview.m(str);
            try {
                hashMap.put("tempVideoPath", d.b.h0.a.a2.b.r(cameraPreview.getVideoPath(), eVar.f46461f));
                hashMap.put("tempThumbPath", d.b.h0.a.a2.b.r(cameraPreview.getThumbPath(), eVar.f46461f));
                d.b.h0.a.x.a.b().i(31000, new C0909d(cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
            } catch (Exception e2) {
                e = e2;
                d.b.h0.a.x.a.b().e(bVar.f43835g, bVar.n, false);
                if (a0.f47009b) {
                    e.printStackTrace();
                }
                d.b.h0.a.c0.c.b("SwanAppCameraManager", "start recording api occur exception");
                k(unitedSchemeEntity, callbackHandler, z);
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        k(unitedSchemeEntity, callbackHandler, z);
    }
}
