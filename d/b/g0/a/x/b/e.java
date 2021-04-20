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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class e extends d.b.g0.a.x.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47305e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47306f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47307g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f47308h;
        public final /* synthetic */ d.b.g0.a.x.e.b i;
        public final /* synthetic */ CameraPreview j;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.b.g0.a.r1.e eVar, d.b.g0.a.x.e.b bVar, CameraPreview cameraPreview) {
            this.f47305e = callbackHandler;
            this.f47306f = unitedSchemeEntity;
            this.f47307g = context;
            this.f47308h = eVar;
            this.i = bVar;
            this.j = cameraPreview;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                e.this.o(this.f47307g, this.f47306f, this.f47305e, this.f47308h, this.i, this.j);
                return;
            }
            d.b.g0.a.v1.c.c.n(hVar, this.f47305e, this.f47306f);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47309a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47310b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.r1.e f47311c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f47312d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.x.e.b f47313e;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, CameraPreview cameraPreview, d.b.g0.a.x.e.b bVar) {
            this.f47309a = unitedSchemeEntity;
            this.f47310b = callbackHandler;
            this.f47311c = eVar;
            this.f47312d = cameraPreview;
            this.f47313e = bVar;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            e.this.r(this.f47309a, this.f47310b, this.f47311c, this.f47312d, this.f47313e);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.callCallback(this.f47310b, this.f47309a, 10005);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", str + "");
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/camera/stopRecord");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.x.e.b bVar = (d.b.g0.a.x.e.b) q(unitedSchemeEntity);
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
        } else if (TextUtils.isEmpty(d.b.g0.a.a2.b.h(eVar.f46132f))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "get camera stop record cache path is empty");
            return false;
        } else {
            eVar.R().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(callbackHandler, unitedSchemeEntity, context, eVar, bVar, q));
            return true;
        }
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, d.b.g0.a.x.e.b bVar, CameraPreview cameraPreview) {
        d.b.g0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        if (d.b.g0.a.x.a.b().c(context) && d.b.g0.a.x.a.b().d(context)) {
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "has authorize");
            r(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar);
            return;
        }
        d.b.g0.a.k1.a.b(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new b(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar));
    }

    public final boolean p(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            return file.exists() && file.length() > 0;
        }
        return false;
    }

    public d.b.g0.a.a0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.b.g0.a.x.e.b(l(unitedSchemeEntity));
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar, CameraPreview cameraPreview, d.b.g0.a.x.e.b bVar) {
        boolean z;
        d.b.g0.a.c0.c.g("SwanAppCameraManager", "stop record start");
        try {
            z = cameraPreview.n();
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        try {
            d.b.g0.a.x.a.b().j();
        } catch (Exception e3) {
            e = e3;
            cameraPreview.e();
            d.b.g0.a.x.a.b().e(bVar.f43506g, bVar.n, false);
            if (a0.f46680b) {
                e.printStackTrace();
            }
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "stop recording api occur exception");
            String videoPath = cameraPreview.getVideoPath();
            String thumbPath = cameraPreview.getThumbPath();
            if (!z) {
            }
            k(unitedSchemeEntity, callbackHandler, false);
            cameraPreview.e();
            d.b.g0.a.c0.c.g("SwanAppCameraManager", "stop record end");
        }
        String videoPath2 = cameraPreview.getVideoPath();
        String thumbPath2 = cameraPreview.getThumbPath();
        if (!z && p(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("tempVideoPath", d.b.g0.a.a2.b.r(videoPath2, eVar.f46132f));
            hashMap.put("tempThumbPath", d.b.g0.a.a2.b.r(thumbPath2, eVar.f46132f));
            j(unitedSchemeEntity, callbackHandler, hashMap, "");
        } else {
            k(unitedSchemeEntity, callbackHandler, false);
        }
        cameraPreview.e();
        d.b.g0.a.c0.c.g("SwanAppCameraManager", "stop record end");
    }
}
