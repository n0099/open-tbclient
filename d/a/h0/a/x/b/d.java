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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.a.h0.a.x.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45041e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45042f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45043g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f45044h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.x.e.b f45045i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.h0.a.r1.e eVar, d.a.h0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f45041e = callbackHandler;
            this.f45042f = unitedSchemeEntity;
            this.f45043g = context;
            this.f45044h = eVar;
            this.f45045i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            int b2;
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                d.this.r(this.f45043g, this.f45042f, this.f45041e, this.f45044h, this.f45045i, this.j, this.k);
            } else if (hVar != null && hVar.a() != null) {
                String str = "authorize recorder failed : " + d.a.h0.a.v1.c.c.f(b2);
                UnitedSchemeUtility.callCallback(this.f45041e, this.f45042f, UnitedSchemeUtility.wrapCallbackParams(hVar.b(), str));
                d.a.h0.a.c0.c.l("SwanAppAction", str);
            } else {
                d.a.h0.a.c0.c.b("SwanAppAction", "authorize recorder failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45046e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45047f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45048g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f45049h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.x.e.b f45050i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, d.a.h0.a.r1.e eVar, d.a.h0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f45046e = unitedSchemeEntity;
            this.f45047f = callbackHandler;
            this.f45048g = context;
            this.f45049h = eVar;
            this.f45050i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                d.this.t(this.f45048g, this.f45046e, this.f45047f, this.f45049h, this.f45050i, this.j, this.k);
            } else if (hVar != null && hVar.a() != null) {
                d.this.s(hVar.b(), this.f45046e, this.f45047f);
            } else {
                d.a.h0.a.c0.c.b("SwanAppAction", "authorize camera failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45051a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45052b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f45053c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f45054d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.x.e.b f45055e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45056f;

        public c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, CameraPreview cameraPreview, d.a.h0.a.x.e.b bVar, String str) {
            this.f45051a = unitedSchemeEntity;
            this.f45052b = callbackHandler;
            this.f45053c = eVar;
            this.f45054d = cameraPreview;
            this.f45055e = bVar;
            this.f45056f = str;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            d.this.w(this.f45051a, this.f45052b, this.f45053c, this.f45054d, this.f45055e, this.f45056f);
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            d.this.s(10005, this.f45051a, this.f45052b);
        }
    }

    /* renamed from: d.a.h0.a.x.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0848d implements d.a.h0.a.x.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f45058a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45059b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45060c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f45061d;

        public C0848d(CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            this.f45058a = cameraPreview;
            this.f45059b = unitedSchemeEntity;
            this.f45060c = callbackHandler;
            this.f45061d = hashMap;
        }

        @Override // d.a.h0.a.x.c.b
        public void a() {
            this.f45058a.n();
            this.f45058a.e();
            d.this.u(this.f45059b, this.f45060c, this.f45061d);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "start record timeout");
        }

        @Override // d.a.h0.a.x.c.b
        public void cancel() {
            this.f45058a.n();
            this.f45058a.e();
            d.this.u(this.f45059b, this.f45060c, this.f45061d);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "start record cancel");
        }
    }

    public d(j jVar) {
        super(jVar, "/swanAPI/camera/startRecord");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.x.e.b bVar = (d.a.h0.a.x.e.b) v(unitedSchemeEntity);
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        d.a.h0.a.a0.c.c.a aVar = (d.a.h0.a.a0.c.c.a) d.a.h0.a.a0.d.a.a(bVar);
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
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "get camera start record cache path is empty");
            return false;
        }
        eVar.R().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(callbackHandler, unitedSchemeEntity, context, eVar, bVar, q, h2));
        return true;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, d.a.h0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
        eVar.R().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str));
    }

    public final void s(int i2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str = "authorize camera failed : " + d.a.h0.a.v1.c.c.f(i2);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2, str));
        d.a.h0.a.c0.c.l("SwanAppAction", str);
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, d.a.h0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
        d.a.h0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        if (d.a.h0.a.x.a.b().c(context) && d.a.h0.a.x.a.b().d(context)) {
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "has authorize");
            w(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
            return;
        }
        d.a.h0.a.k1.a.b(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str));
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

    public d.a.h0.a.a0.b.b v(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.h0.a.x.e.b(l(unitedSchemeEntity));
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, CameraPreview cameraPreview, d.a.h0.a.x.e.b bVar, String str) {
        boolean z;
        d.a.h0.a.c0.c.g("SwanAppCameraManager", "start record start");
        HashMap hashMap = new HashMap();
        try {
            z = cameraPreview.m(str);
            try {
                hashMap.put("tempVideoPath", d.a.h0.a.a2.b.r(cameraPreview.getVideoPath(), eVar.f43823f));
                hashMap.put("tempThumbPath", d.a.h0.a.a2.b.r(cameraPreview.getThumbPath(), eVar.f43823f));
                d.a.h0.a.x.a.b().i(31000, new C0848d(cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
            } catch (Exception e2) {
                e = e2;
                d.a.h0.a.x.a.b().e(bVar.f41093g, bVar.n, false);
                if (a0.f44398b) {
                    e.printStackTrace();
                }
                d.a.h0.a.c0.c.b("SwanAppCameraManager", "start recording api occur exception");
                k(unitedSchemeEntity, callbackHandler, z);
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        k(unitedSchemeEntity, callbackHandler, z);
    }
}
