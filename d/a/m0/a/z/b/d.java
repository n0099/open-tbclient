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
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends d.a.m0.a.z.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49705e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49706f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49707g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f49708h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.z.e.b f49709i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.m0.a.a2.e eVar, d.a.m0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f49705e = callbackHandler;
            this.f49706f = unitedSchemeEntity;
            this.f49707g = context;
            this.f49708h = eVar;
            this.f49709i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            int b2;
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                d.this.r(this.f49707g, this.f49706f, this.f49705e, this.f49708h, this.f49709i, this.j, this.k);
            } else if (iVar != null && iVar.a() != null) {
                String str = "authorize recorder failed : " + d.a.m0.a.e2.c.d.f(b2);
                UnitedSchemeUtility.callCallback(this.f49705e, this.f49706f, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), str));
                d.a.m0.a.e0.d.l("SwanAppAction", str);
            } else {
                d.a.m0.a.e0.d.b("SwanAppAction", "authorize recorder failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49710e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49711f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49712g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f49713h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.z.e.b f49714i;
        public final /* synthetic */ CameraPreview j;
        public final /* synthetic */ String k;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context, d.a.m0.a.a2.e eVar, d.a.m0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
            this.f49710e = unitedSchemeEntity;
            this.f49711f = callbackHandler;
            this.f49712g = context;
            this.f49713h = eVar;
            this.f49714i = bVar;
            this.j = cameraPreview;
            this.k = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                d.this.t(this.f49712g, this.f49710e, this.f49711f, this.f49713h, this.f49714i, this.j, this.k);
            } else if (iVar != null && iVar.a() != null) {
                d.this.s(iVar.b(), this.f49710e, this.f49711f);
            } else {
                d.a.m0.a.e0.d.b("SwanAppAction", "authorize camera failed : result is invalid");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.m0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49715a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49716b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.a2.e f49717c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f49718d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.z.e.b f49719e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49720f;

        public c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, CameraPreview cameraPreview, d.a.m0.a.z.e.b bVar, String str) {
            this.f49715a = unitedSchemeEntity;
            this.f49716b = callbackHandler;
            this.f49717c = eVar;
            this.f49718d = cameraPreview;
            this.f49719e = bVar;
            this.f49720f = str;
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            d.this.w(this.f49715a, this.f49716b, this.f49717c, this.f49718d, this.f49719e, this.f49720f);
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
            d.this.s(10005, this.f49715a, this.f49716b);
        }
    }

    /* renamed from: d.a.m0.a.z.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0984d implements d.a.m0.a.z.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f49722a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49723b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49724c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f49725d;

        public C0984d(CameraPreview cameraPreview, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, HashMap hashMap) {
            this.f49722a = cameraPreview;
            this.f49723b = unitedSchemeEntity;
            this.f49724c = callbackHandler;
            this.f49725d = hashMap;
        }

        @Override // d.a.m0.a.z.c.b
        public void a() {
            this.f49722a.n();
            this.f49722a.e();
            d.this.u(this.f49723b, this.f49724c, this.f49725d);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "start record timeout");
        }

        @Override // d.a.m0.a.z.c.b
        public void cancel() {
            this.f49722a.n();
            this.f49722a.e();
            d.this.u(this.f49723b, this.f49724c, this.f49725d);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "start record cancel");
        }
    }

    public d(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/startRecord");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.z.e.b bVar = (d.a.m0.a.z.e.b) v(unitedSchemeEntity);
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        d.a.m0.a.c0.c.c.a aVar = (d.a.m0.a.c0.c.c.a) d.a.m0.a.c0.d.a.a(bVar);
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
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "get camera start record cache path is empty");
            return false;
        }
        eVar.T().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(callbackHandler, unitedSchemeEntity, context, eVar, bVar, q, x));
        return true;
    }

    public final void r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, d.a.m0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new b(unitedSchemeEntity, callbackHandler, context, eVar, bVar, cameraPreview, str));
    }

    public final void s(int i2, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str = "authorize camera failed : " + d.a.m0.a.e2.c.d.f(i2);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(i2, str));
        d.a.m0.a.e0.d.l("SwanAppAction", str);
    }

    public final void t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, d.a.m0.a.z.e.b bVar, CameraPreview cameraPreview, String str) {
        d.a.m0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
        if (d.a.m0.a.z.a.b().c(context) && d.a.m0.a.z.a.b().d(context)) {
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "has authorize");
            w(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str);
            return;
        }
        d.a.m0.a.s1.e.f(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new c(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar, str));
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

    public d.a.m0.a.c0.b.b v(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.m0.a.z.e.b(l(unitedSchemeEntity));
    }

    public final void w(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar, CameraPreview cameraPreview, d.a.m0.a.z.e.b bVar, String str) {
        boolean z;
        d.a.m0.a.e0.d.g("SwanAppCameraManager", "start record start");
        HashMap hashMap = new HashMap();
        try {
            z = cameraPreview.m(str);
            try {
                hashMap.put("tempVideoPath", d.a.m0.a.k2.b.J(cameraPreview.getVideoPath(), eVar.f44533f));
                hashMap.put("tempThumbPath", d.a.m0.a.k2.b.J(cameraPreview.getThumbPath(), eVar.f44533f));
                d.a.m0.a.z.a.b().i(31000, new C0984d(cameraPreview, unitedSchemeEntity, callbackHandler, hashMap));
            } catch (Exception e2) {
                e = e2;
                d.a.m0.a.z.a.b().e(bVar.f44630g, bVar.f44629f, false);
                if (a0.f44733b) {
                    e.printStackTrace();
                }
                d.a.m0.a.e0.d.b("SwanAppCameraManager", "start recording api occur exception");
                k(unitedSchemeEntity, callbackHandler, z);
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        k(unitedSchemeEntity, callbackHandler, z);
    }
}
