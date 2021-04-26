package d.a.h0.a.x.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.h0.a.t1.j;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
/* loaded from: classes2.dex */
public class g extends d.a.h0.a.x.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45092e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45093f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45094g;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context) {
            this.f45092e = unitedSchemeEntity;
            this.f45093f = callbackHandler;
            this.f45094g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            d.a.h0.a.x.e.a aVar = (d.a.h0.a.x.e.a) g.this.q(this.f45092e);
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                g.this.p(this.f45094g, this.f45092e, this.f45093f, aVar);
                return;
            }
            d.a.h0.a.v1.c.c.n(hVar, this.f45093f, this.f45092e);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.x.e.a f45096a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45097b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45098c;

        public b(d.a.h0.a.x.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f45096a = aVar;
            this.f45097b = unitedSchemeEntity;
            this.f45098c = callbackHandler;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            g.this.k(this.f45097b, this.f45098c, g.this.o(this.f45096a));
            d.a.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f45098c, this.f45097b, 10005);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }
    }

    public g(j jVar) {
        super(jVar, "/swanAPI/camera/update");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "handle action, but context is not Activity");
            return false;
        }
        eVar.R().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(unitedSchemeEntity, callbackHandler, context));
        return true;
    }

    public final boolean o(d.a.h0.a.x.e.a aVar) {
        d.a.h0.a.c0.c.g("SwanAppCameraManager", "handle update camera instruction start");
        if (aVar == null) {
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "Model is null");
            return false;
        }
        String str = aVar.p;
        d.a.h0.a.e1.d.a.a aVar2 = aVar.l;
        if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.i()) {
            d.a.h0.a.a0.c.c.a aVar3 = (d.a.h0.a.a0.c.c.a) d.a.h0.a.a0.d.a.a(aVar);
            if (aVar3 == null) {
                d.a.h0.a.c0.c.b("SwanAppCameraManager", "update camera with a null component");
                return false;
            }
            d.a.h0.a.a0.b.c G = aVar3.G(aVar);
            boolean a2 = G.a();
            if (!a2) {
                d.a.h0.a.c0.c.b("SwanAppCameraManager", "update camera fail: " + G.f41097b);
            }
            return a2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("cameraId = ");
        sb.append(str);
        sb.append(" ; position = ");
        sb.append(aVar2 == null);
        d.a.h0.a.c0.c.b("SwanAppCameraManager", sb.toString());
        return false;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.x.e.a aVar) {
        d.a.h0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        d.a.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 100, context, new b(aVar, unitedSchemeEntity, callbackHandler));
    }

    public d.a.h0.a.a0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.h0.a.x.e.a(l(unitedSchemeEntity));
    }
}
