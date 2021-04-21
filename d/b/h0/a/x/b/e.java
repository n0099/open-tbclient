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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class e extends d.b.h0.a.x.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47634e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47635f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47636g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47637h;
        public final /* synthetic */ d.b.h0.a.x.e.b i;
        public final /* synthetic */ CameraPreview j;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.b.h0.a.r1.e eVar, d.b.h0.a.x.e.b bVar, CameraPreview cameraPreview) {
            this.f47634e = callbackHandler;
            this.f47635f = unitedSchemeEntity;
            this.f47636g = context;
            this.f47637h = eVar;
            this.i = bVar;
            this.j = cameraPreview;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                e.this.o(this.f47636g, this.f47635f, this.f47634e, this.f47637h, this.i, this.j);
                return;
            }
            d.b.h0.a.v1.c.c.n(hVar, this.f47634e, this.f47635f);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47638a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47639b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.r1.e f47640c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f47641d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.x.e.b f47642e;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, CameraPreview cameraPreview, d.b.h0.a.x.e.b bVar) {
            this.f47638a = unitedSchemeEntity;
            this.f47639b = callbackHandler;
            this.f47640c = eVar;
            this.f47641d = cameraPreview;
            this.f47642e = bVar;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            e.this.r(this.f47638a, this.f47639b, this.f47640c, this.f47641d, this.f47642e);
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.callCallback(this.f47639b, this.f47638a, 10005);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/camera/stopRecord");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.x.e.b bVar = (d.b.h0.a.x.e.b) q(unitedSchemeEntity);
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
        } else if (TextUtils.isEmpty(d.b.h0.a.a2.b.h(eVar.f46461f))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "get camera stop record cache path is empty");
            return false;
        } else {
            eVar.R().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(callbackHandler, unitedSchemeEntity, context, eVar, bVar, q));
            return true;
        }
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, d.b.h0.a.x.e.b bVar, CameraPreview cameraPreview) {
        d.b.h0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        if (d.b.h0.a.x.a.b().c(context) && d.b.h0.a.x.a.b().d(context)) {
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "has authorize");
            r(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar);
            return;
        }
        d.b.h0.a.k1.a.b(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new b(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar));
    }

    public final boolean p(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            return file.exists() && file.length() > 0;
        }
        return false;
    }

    public d.b.h0.a.a0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.b.h0.a.x.e.b(l(unitedSchemeEntity));
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar, CameraPreview cameraPreview, d.b.h0.a.x.e.b bVar) {
        boolean z;
        d.b.h0.a.c0.c.g("SwanAppCameraManager", "stop record start");
        try {
            z = cameraPreview.n();
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        try {
            d.b.h0.a.x.a.b().j();
        } catch (Exception e3) {
            e = e3;
            cameraPreview.e();
            d.b.h0.a.x.a.b().e(bVar.f43835g, bVar.n, false);
            if (a0.f47009b) {
                e.printStackTrace();
            }
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "stop recording api occur exception");
            String videoPath = cameraPreview.getVideoPath();
            String thumbPath = cameraPreview.getThumbPath();
            if (!z) {
            }
            k(unitedSchemeEntity, callbackHandler, false);
            cameraPreview.e();
            d.b.h0.a.c0.c.g("SwanAppCameraManager", "stop record end");
        }
        String videoPath2 = cameraPreview.getVideoPath();
        String thumbPath2 = cameraPreview.getThumbPath();
        if (!z && p(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("tempVideoPath", d.b.h0.a.a2.b.r(videoPath2, eVar.f46461f));
            hashMap.put("tempThumbPath", d.b.h0.a.a2.b.r(thumbPath2, eVar.f46461f));
            j(unitedSchemeEntity, callbackHandler, hashMap, "");
        } else {
            k(unitedSchemeEntity, callbackHandler, false);
        }
        cameraPreview.e();
        d.b.h0.a.c0.c.g("SwanAppCameraManager", "stop record end");
    }
}
