package d.a.i0.a.z.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
/* loaded from: classes2.dex */
public class g extends d.a.i0.a.z.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45798e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45799f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45800g;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context) {
            this.f45798e = unitedSchemeEntity;
            this.f45799f = callbackHandler;
            this.f45800g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            d.a.i0.a.z.e.a aVar = (d.a.i0.a.z.e.a) g.this.q(this.f45798e);
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                g.this.p(this.f45800g, this.f45798e, this.f45799f, aVar);
                return;
            }
            d.a.i0.a.e2.c.d.o(iVar, this.f45799f, this.f45798e);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.i0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.z.e.a f45802a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45803b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45804c;

        public b(d.a.i0.a.z.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f45802a = aVar;
            this.f45803b = unitedSchemeEntity;
            this.f45804c = callbackHandler;
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            g.this.k(this.f45803b, this.f45804c, g.this.o(this.f45802a));
            d.a.i0.a.e0.d.b("SwanAppCameraManager", str + "");
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f45804c, this.f45803b, 10005);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", str + "");
        }
    }

    public g(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/update");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "handle action, but context is not Activity");
            return false;
        }
        eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(unitedSchemeEntity, callbackHandler, context));
        return true;
    }

    public final boolean o(d.a.i0.a.z.e.a aVar) {
        d.a.i0.a.e0.d.g("SwanAppCameraManager", "handle update camera instruction start");
        if (aVar == null) {
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "Model is null");
            return false;
        }
        String str = aVar.f40671f;
        d.a.i0.a.l1.e.a.a aVar2 = aVar.l;
        if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.i()) {
            d.a.i0.a.c0.c.c.a aVar3 = (d.a.i0.a.c0.c.c.a) d.a.i0.a.c0.d.a.a(aVar);
            if (aVar3 == null) {
                d.a.i0.a.e0.d.b("SwanAppCameraManager", "update camera with a null component");
                return false;
            }
            d.a.i0.a.c0.b.c G = aVar3.G(aVar);
            boolean a2 = G.a();
            if (!a2) {
                d.a.i0.a.e0.d.b("SwanAppCameraManager", "update camera fail: " + G.f40676b);
            }
            return a2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("cameraId = ");
        sb.append(str);
        sb.append(" ; position = ");
        sb.append(aVar2 == null);
        d.a.i0.a.e0.d.b("SwanAppCameraManager", sb.toString());
        return false;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.z.e.a aVar) {
        d.a.i0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
        d.a.i0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 100, context, new b(aVar, unitedSchemeEntity, callbackHandler));
    }

    public d.a.i0.a.c0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.i0.a.z.e.a(l(unitedSchemeEntity));
    }
}
