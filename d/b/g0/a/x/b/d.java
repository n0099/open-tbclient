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
        public final /* synthetic */ CallbackHandler f46893e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46894f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46895g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46896h;
        public final /* synthetic */ d.b.g0.a.x.e.b i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.b.g0.a.r1.e eVar, d.b.g0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f46893e = callbackHandler;
            this.f46894f = unitedSchemeEntity;
            this.f46895g = context;
            this.f46896h = eVar;
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
                d.this.r(this.f46895g, this.f46894f, this.f46893e, this.f46896h, this.i, this.j, this.k);
            } else if (hVar != null && hVar.a() != null) {
                String str = "authorize recorder failed : " + d.b.g0.a.v1.c.c.f(b2);
                UnitedSchemeUtility.callCallback(this.f46893e, this.f46894f, UnitedSchemeUtility.wrapCallbackParams(hVar.b(), str));
                d.b.g0.a.c0.c.l("SwanAppAction", str);
            } else {
                d.b.g0.a.c0.c.b("SwanAppAction", "authorize recorder failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46897e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46898f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46899g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46900h;
        public final /* synthetic */ d.b.g0.a.x.e.b i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, d.b.g0.a.r1.e eVar, d.b.g0.a.x.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f46897e = unitedSchemeEntity;
            this.f46898f = callbackHandler;
            this.f46899g = context;
            this.f46900h = eVar;
            this.i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                d.this.t(this.f46899g, this.f46897e, this.f46898f, this.f46900h, this.i, this.j, this.k);
            } else if (hVar != null && hVar.a() != null) {
                d.this.s(hVar.b(), this.f46897e, this.f46898f);
            } else {
                d.b.g0.a.c0.c.b("SwanAppAction", "authorize camera failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46901a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46902b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f46903c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f46904d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.x.e.b f46905e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46906f;

        public c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, CameraPreview cameraPreview, d.b.g0.a.x.e.b bVar, String str) {
            this.f46901a = unitedSchemeEntity;
            this.f46902b = callbackHandler;
            this.f46903c = eVar;
            this.f46904d = cameraPreview;
            this.f46905e = bVar;
            this.f46906f = str;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            d.this.w(this.f46901a, this.f46902b, this.f46903c, this.f46904d, this.f46905e, this.f46906f);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            d.this.s(10005, this.f46901a, this.f46902b);
        }
    }

    /* renamed from: d.b.g0.a.x.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0877d implements d.b.g0.a.x.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f46908a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46909b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46910c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f46911d;

        public C0877d(CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            this.f46908a = cameraPreview;
            this.f46909b = unitedSchemeEntity;
            this.f46910c = callbackHandler;
            this.f46911d = hashMap;
        }

        @Override // d.b.g0.a.x.c.b
        public void a() {
            this.f46908a.n();
            this.f46908a.e();
            d.this.u(this.f46909b, this.f46910c, this.f46911d);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "start record timeout");
        }

        @Override // d.b.g0.a.x.c.b
        public void cancel() {
            this.f46908a.n();
            this.f46908a.e();
            d.this.u(this.f46909b, this.f46910c, this.f46911d);
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
        String h2 = d.b.g0.a.a2.b.h(eVar.f45740f);
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
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        try {
            hashMap.put("tempVideoPath", d.b.g0.a.a2.b.r(cameraPreview.getVideoPath(), eVar.f45740f));
            hashMap.put("tempThumbPath", d.b.g0.a.a2.b.r(cameraPreview.getThumbPath(), eVar.f45740f));
            d.b.g0.a.x.a.b().i(31000, new C0877d(cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
        } catch (Exception e3) {
            e = e3;
            d.b.g0.a.x.a.b().e(bVar.f43114g, bVar.n, false);
            if (a0.f46288b) {
                e.printStackTrace();
            }
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "start recording api occur exception");
            k(unitedSchemeEntity, callbackHandler, z);
        }
        k(unitedSchemeEntity, callbackHandler, z);
    }
}
