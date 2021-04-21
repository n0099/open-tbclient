package d.b.h0.a.x.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.sdk.PermissionRequest;
import d.b.h0.a.t1.j;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
/* loaded from: classes2.dex */
public class g extends d.b.h0.a.x.b.a {

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47661e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47662f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47663g;

        public a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, Context context) {
            this.f47661e = unitedSchemeEntity;
            this.f47662f = callbackHandler;
            this.f47663g = context;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            d.b.h0.a.x.e.a aVar = (d.b.h0.a.x.e.a) g.this.q(this.f47661e);
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                g.this.p(this.f47663g, this.f47661e, this.f47662f, aVar);
                return;
            }
            d.b.h0.a.v1.c.c.n(hVar, this.f47662f, this.f47661e);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.x.e.a f47665a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47666b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47667c;

        public b(d.b.h0.a.x.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f47665a = aVar;
            this.f47666b = unitedSchemeEntity;
            this.f47667c = callbackHandler;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            g.this.k(this.f47666b, this.f47667c, g.this.o(this.f47665a));
            d.b.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.callCallback(this.f47667c, this.f47666b, 10005);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }
    }

    public g(j jVar) {
        super(jVar, "/swanAPI/camera/update");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "handle action, but context is not Activity");
            return false;
        }
        eVar.R().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(unitedSchemeEntity, callbackHandler, context));
        return true;
    }

    public final boolean o(d.b.h0.a.x.e.a aVar) {
        d.b.h0.a.c0.c.g("SwanAppCameraManager", "handle update camera instruction start");
        if (aVar == null) {
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "Model is null");
            return false;
        }
        String str = aVar.p;
        d.b.h0.a.e1.d.a.a aVar2 = aVar.l;
        if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.i()) {
            d.b.h0.a.a0.c.c.a aVar3 = (d.b.h0.a.a0.c.c.a) d.b.h0.a.a0.d.a.a(aVar);
            if (aVar3 == null) {
                d.b.h0.a.c0.c.b("SwanAppCameraManager", "update camera with a null component");
                return false;
            }
            d.b.h0.a.a0.b.c G = aVar3.G(aVar);
            boolean a2 = G.a();
            if (!a2) {
                d.b.h0.a.c0.c.b("SwanAppCameraManager", "update camera fail: " + G.f43838b);
            }
            return a2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("cameraId = ");
        sb.append(str);
        sb.append(" ; position = ");
        sb.append(aVar2 == null);
        d.b.h0.a.c0.c.b("SwanAppCameraManager", sb.toString());
        return false;
    }

    public final void p(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.x.e.a aVar) {
        d.b.h0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        d.b.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 100, context, new b(aVar, unitedSchemeEntity, callbackHandler));
    }

    public d.b.h0.a.a0.b.b q(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.b.h0.a.x.e.a(l(unitedSchemeEntity));
    }
}
