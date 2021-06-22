package d.a.m0.a.z.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
/* loaded from: classes2.dex */
public class g extends d.a.m0.a.z.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49756e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49757f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49758g;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context) {
            this.f49756e = unitedSchemeEntity;
            this.f49757f = callbackHandler;
            this.f49758g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            d.a.m0.a.z.e.a aVar = (d.a.m0.a.z.e.a) g.this.q(this.f49756e);
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                g.this.p(this.f49758g, this.f49756e, this.f49757f, aVar);
                return;
            }
            d.a.m0.a.e2.c.d.o(iVar, this.f49757f, this.f49756e);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.m0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.z.e.a f49760a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49761b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49762c;

        public b(d.a.m0.a.z.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f49760a = aVar;
            this.f49761b = unitedSchemeEntity;
            this.f49762c = callbackHandler;
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            g.this.k(this.f49761b, this.f49762c, g.this.o(this.f49760a));
            d.a.m0.a.e0.d.b("SwanAppCameraManager", str + "");
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f49762c, this.f49761b, 10005);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", str + "");
        }
    }

    public g(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/update");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "handle action, but context is not Activity");
            return false;
        }
        eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(unitedSchemeEntity, callbackHandler, context));
        return true;
    }

    public final boolean o(d.a.m0.a.z.e.a aVar) {
        d.a.m0.a.e0.d.g("SwanAppCameraManager", "handle update camera instruction start");
        if (aVar == null) {
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "Model is null");
            return false;
        }
        String str = aVar.f44629f;
        d.a.m0.a.l1.e.a.a aVar2 = aVar.l;
        if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.i()) {
            d.a.m0.a.c0.c.c.a aVar3 = (d.a.m0.a.c0.c.c.a) d.a.m0.a.c0.d.a.a(aVar);
            if (aVar3 == null) {
                d.a.m0.a.e0.d.b("SwanAppCameraManager", "update camera with a null component");
                return false;
            }
            d.a.m0.a.c0.b.c G = aVar3.G(aVar);
            boolean a2 = G.a();
            if (!a2) {
                d.a.m0.a.e0.d.b("SwanAppCameraManager", "update camera fail: " + G.f44634b);
            }
            return a2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("cameraId = ");
        sb.append(str);
        sb.append(" ; position = ");
        sb.append(aVar2 == null);
        d.a.m0.a.e0.d.b("SwanAppCameraManager", sb.toString());
        return false;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.z.e.a aVar) {
        d.a.m0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
        d.a.m0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 100, context, new b(aVar, unitedSchemeEntity, callbackHandler));
    }

    public d.a.m0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.m0.a.z.e.a(l(unitedSchemeEntity));
    }
}
