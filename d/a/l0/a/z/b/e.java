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
import java.io.File;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class e extends d.a.l0.a.z.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49619e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49620f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49621g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f49622h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.b f49623i;
        public final /* synthetic */ CameraPreview j;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.l0.a.a2.e eVar, d.a.l0.a.z.e.b bVar, CameraPreview cameraPreview) {
            this.f49619e = callbackHandler;
            this.f49620f = unitedSchemeEntity;
            this.f49621g = context;
            this.f49622h = eVar;
            this.f49623i = bVar;
            this.j = cameraPreview;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                e.this.o(this.f49621g, this.f49620f, this.f49619e, this.f49622h, this.f49623i, this.j);
                return;
            }
            d.a.l0.a.e2.c.d.o(iVar, this.f49619e, this.f49620f);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.l0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49624a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49625b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f49626c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CameraPreview f49627d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.b f49628e;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, CameraPreview cameraPreview, d.a.l0.a.z.e.b bVar) {
            this.f49624a = unitedSchemeEntity;
            this.f49625b = callbackHandler;
            this.f49626c = eVar;
            this.f49627d = cameraPreview;
            this.f49628e = bVar;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            e.this.r(this.f49624a, this.f49625b, this.f49626c, this.f49627d, this.f49628e);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f49625b, this.f49624a, 10005);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", str + "");
        }
    }

    public e(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/stopRecord");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.z.e.b bVar = (d.a.l0.a.z.e.b) q(unitedSchemeEntity);
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "parse json model is null");
            return false;
        }
        d.a.l0.a.c0.c.c.a aVar = (d.a.l0.a.c0.c.c.a) d.a.l0.a.c0.d.a.a(bVar);
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
        } else if (TextUtils.isEmpty(d.a.l0.a.k2.b.x(eVar.f44425f))) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "get camera stop record cache path is empty");
            return false;
        } else {
            eVar.T().g(context, PermissionProxy.SCOPE_ID_RECORD, new a(callbackHandler, unitedSchemeEntity, context, eVar, bVar, q));
            return true;
        }
    }

    public final void o(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, d.a.l0.a.z.e.b bVar, CameraPreview cameraPreview) {
        d.a.l0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
        if (d.a.l0.a.z.a.b().c(context) && d.a.l0.a.z.a.b().d(context)) {
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "has authorize");
            r(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar);
            return;
        }
        d.a.l0.a.s1.e.f(context, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE, PermissionRequest.RESOURCE_AUDIO_CAPTURE}, 1, new b(unitedSchemeEntity, callbackHandler, eVar, cameraPreview, bVar));
    }

    public final boolean p(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            return file.exists() && file.length() > 0;
        }
        return false;
    }

    public d.a.l0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.l0.a.z.e.b(l(unitedSchemeEntity));
    }

    public final void r(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar, CameraPreview cameraPreview, d.a.l0.a.z.e.b bVar) {
        boolean z;
        d.a.l0.a.e0.d.g("SwanAppCameraManager", "stop record start");
        try {
            z = cameraPreview.n();
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        try {
            d.a.l0.a.z.a.b().j();
        } catch (Exception e3) {
            e = e3;
            cameraPreview.e();
            d.a.l0.a.z.a.b().e(bVar.f44522g, bVar.f44521f, false);
            if (a0.f44625b) {
                e.printStackTrace();
            }
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "stop recording api occur exception");
            String videoPath = cameraPreview.getVideoPath();
            String thumbPath = cameraPreview.getThumbPath();
            if (!z) {
            }
            k(unitedSchemeEntity, callbackHandler, false);
            cameraPreview.e();
            d.a.l0.a.e0.d.g("SwanAppCameraManager", "stop record end");
        }
        String videoPath2 = cameraPreview.getVideoPath();
        String thumbPath2 = cameraPreview.getThumbPath();
        if (!z && p(videoPath2) && !TextUtils.isEmpty(thumbPath2)) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("tempVideoPath", d.a.l0.a.k2.b.J(videoPath2, eVar.f44425f));
            hashMap.put("tempThumbPath", d.a.l0.a.k2.b.J(thumbPath2, eVar.f44425f));
            j(unitedSchemeEntity, callbackHandler, hashMap, "");
        } else {
            k(unitedSchemeEntity, callbackHandler, false);
        }
        cameraPreview.e();
        d.a.l0.a.e0.d.g("SwanAppCameraManager", "stop record end");
    }
}
