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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class e extends d.a.h0.a.x.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45063e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45064f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45065g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f45066h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.x.e.b f45067i;
        public final /* synthetic */ CameraPreview j;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.h0.a.r1.e eVar, d.a.h0.a.x.e.b bVar, CameraPreview cameraPreview) {
            this.f45063e = callbackHandler;
            this.f45064f = unitedSchemeEntity;
            this.f45065g = context;
            this.f45066h = eVar;
            this.f45067i = bVar;
            this.j = cameraPreview;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                e.this.o(this.f45065g, this.f45064f, this.f45063e, this.f45066h, this.f45067i, this.j);
                return;
            }
            d.a.h0.a.v1.c.c.n(hVar, this.f45063e, this.f45064f);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45068a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45069b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f45070c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f45071d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.x.e.b f45072e;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, CameraPreview cameraPreview, d.a.h0.a.x.e.b bVar) {
            this.f45068a = unitedSchemeEntity;
            this.f45069b = callbackHandler;
            this.f45070c = eVar;
            this.f45071d = cameraPreview;
            this.f45072e = bVar;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            e.this.r(this.f45068a, this.f45069b, this.f45070c, this.f45071d, this.f45072e);
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f45069b, this.f45068a, 10005);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/camera/stopRecord");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.x.e.b bVar = (d.a.h0.a.x.e.b) q(unitedSchemeEntity);
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
        } else if (TextUtils.isEmpty(d.a.h0.a.a2.b.h(eVar.f43823f))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "get camera stop record cache path is empty");
            return false;
        } else {
            eVar.R().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(callbackHandler, unitedSchemeEntity, context, eVar, bVar, q));
            return true;
        }
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, d.a.h0.a.x.e.b bVar, CameraPreview cameraPreview) {
        d.a.h0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        if (d.a.h0.a.x.a.b().c(context) && d.a.h0.a.x.a.b().d(context)) {
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "has authorize");
            r(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar);
            return;
        }
        d.a.h0.a.k1.a.b(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new b(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar));
    }

    public final boolean p(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            return file.exists() && file.length() > 0;
        }
        return false;
    }

    public d.a.h0.a.a0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.h0.a.x.e.b(l(unitedSchemeEntity));
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar, CameraPreview cameraPreview, d.a.h0.a.x.e.b bVar) {
        boolean z;
        d.a.h0.a.c0.c.g("SwanAppCameraManager", "stop record start");
        try {
            z = cameraPreview.n();
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        try {
            d.a.h0.a.x.a.b().j();
        } catch (Exception e3) {
            e = e3;
            cameraPreview.e();
            d.a.h0.a.x.a.b().e(bVar.f41093g, bVar.n, false);
            if (a0.f44398b) {
                e.printStackTrace();
            }
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "stop recording api occur exception");
            String videoPath = cameraPreview.getVideoPath();
            String thumbPath = cameraPreview.getThumbPath();
            if (!z) {
            }
            k(unitedSchemeEntity, callbackHandler, false);
            cameraPreview.e();
            d.a.h0.a.c0.c.g("SwanAppCameraManager", "stop record end");
        }
        String videoPath2 = cameraPreview.getVideoPath();
        String thumbPath2 = cameraPreview.getThumbPath();
        if (!z && p(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("tempVideoPath", d.a.h0.a.a2.b.r(videoPath2, eVar.f43823f));
            hashMap.put("tempThumbPath", d.a.h0.a.a2.b.r(thumbPath2, eVar.f43823f));
            j(unitedSchemeEntity, callbackHandler, hashMap, "");
        } else {
            k(unitedSchemeEntity, callbackHandler, false);
        }
        cameraPreview.e();
        d.a.h0.a.c0.c.g("SwanAppCameraManager", "stop record end");
    }
}
