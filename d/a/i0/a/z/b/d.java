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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.a.i0.a.z.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45747e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45748f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45749g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f45750h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.z.e.b f45751i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.i0.a.a2.e eVar, d.a.i0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f45747e = callbackHandler;
            this.f45748f = unitedSchemeEntity;
            this.f45749g = context;
            this.f45750h = eVar;
            this.f45751i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            int b2;
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                d.this.r(this.f45749g, this.f45748f, this.f45747e, this.f45750h, this.f45751i, this.j, this.k);
            } else if (iVar != null && iVar.a() != null) {
                String str = "authorize recorder failed : " + d.a.i0.a.e2.c.d.f(b2);
                UnitedSchemeUtility.callCallback(this.f45747e, this.f45748f, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), str));
                d.a.i0.a.e0.d.l("SwanAppAction", str);
            } else {
                d.a.i0.a.e0.d.b("SwanAppAction", "authorize recorder failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45752e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45753f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45754g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f45755h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.z.e.b f45756i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, d.a.i0.a.a2.e eVar, d.a.i0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f45752e = unitedSchemeEntity;
            this.f45753f = callbackHandler;
            this.f45754g = context;
            this.f45755h = eVar;
            this.f45756i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                d.this.t(this.f45754g, this.f45752e, this.f45753f, this.f45755h, this.f45756i, this.j, this.k);
            } else if (iVar != null && iVar.a() != null) {
                d.this.s(iVar.b(), this.f45752e, this.f45753f);
            } else {
                d.a.i0.a.e0.d.b("SwanAppAction", "authorize camera failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.i0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45757a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45758b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.a2.e f45759c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f45760d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.z.e.b f45761e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45762f;

        public c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, CameraPreview cameraPreview, d.a.i0.a.z.e.b bVar, String str) {
            this.f45757a = unitedSchemeEntity;
            this.f45758b = callbackHandler;
            this.f45759c = eVar;
            this.f45760d = cameraPreview;
            this.f45761e = bVar;
            this.f45762f = str;
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            d.this.w(this.f45757a, this.f45758b, this.f45759c, this.f45760d, this.f45761e, this.f45762f);
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
            d.this.s(10005, this.f45757a, this.f45758b);
        }
    }

    /* renamed from: d.a.i0.a.z.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0914d implements d.a.i0.a.z.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f45764a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45765b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45766c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f45767d;

        public C0914d(CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            this.f45764a = cameraPreview;
            this.f45765b = unitedSchemeEntity;
            this.f45766c = callbackHandler;
            this.f45767d = hashMap;
        }

        @Override // d.a.i0.a.z.c.b
        public void a() {
            this.f45764a.n();
            this.f45764a.e();
            d.this.u(this.f45765b, this.f45766c, this.f45767d);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "start record timeout");
        }

        @Override // d.a.i0.a.z.c.b
        public void cancel() {
            this.f45764a.n();
            this.f45764a.e();
            d.this.u(this.f45765b, this.f45766c, this.f45767d);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "start record cancel");
        }
    }

    public d(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/startRecord");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        d.a.i0.a.z.e.b bVar = (d.a.i0.a.z.e.b) v(unitedSchemeEntity);
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        d.a.i0.a.c0.c.c.a aVar = (d.a.i0.a.c0.c.c.a) d.a.i0.a.c0.d.a.a(bVar);
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
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "get camera start record cache path is empty");
            return false;
        }
        eVar.T().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(callbackHandler, unitedSchemeEntity, context, eVar, bVar, q, x));
        return true;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, d.a.i0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str));
    }

    public final void s(int i2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str = "authorize camera failed : " + d.a.i0.a.e2.c.d.f(i2);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2, str));
        d.a.i0.a.e0.d.l("SwanAppAction", str);
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, d.a.i0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        d.a.i0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
        if (d.a.i0.a.z.a.b().c(context) && d.a.i0.a.z.a.b().d(context)) {
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "has authorize");
            w(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
            return;
        }
        d.a.i0.a.s1.e.f(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str));
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

    public d.a.i0.a.c0.b.b v(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.i0.a.z.e.b(l(unitedSchemeEntity));
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar, CameraPreview cameraPreview, d.a.i0.a.z.e.b bVar, String str) {
        boolean z;
        d.a.i0.a.e0.d.g("SwanAppCameraManager", "start record start");
        HashMap hashMap = new HashMap();
        try {
            z = cameraPreview.m(str);
            try {
                hashMap.put("tempVideoPath", d.a.i0.a.k2.b.J(cameraPreview.getVideoPath(), eVar.f40575f));
                hashMap.put("tempThumbPath", d.a.i0.a.k2.b.J(cameraPreview.getThumbPath(), eVar.f40575f));
                d.a.i0.a.z.a.b().i(31000, new C0914d(cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
            } catch (Exception e2) {
                e = e2;
                d.a.i0.a.z.a.b().e(bVar.f40672g, bVar.f40671f, false);
                if (a0.f40775b) {
                    e.printStackTrace();
                }
                d.a.i0.a.e0.d.b("SwanAppCameraManager", "start recording api occur exception");
                k(unitedSchemeEntity, callbackHandler, z);
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        k(unitedSchemeEntity, callbackHandler, z);
    }
}
