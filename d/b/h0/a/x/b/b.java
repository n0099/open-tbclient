package d.b.h0.a.x.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.sdk.PermissionRequest;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
import h.j;
/* loaded from: classes2.dex */
public class b extends d.b.h0.a.x.b.a {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public j f47604c;

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47605e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47606f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f47607g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.x.e.a f47608h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.b.h0.a.x.e.a aVar) {
            this.f47605e = callbackHandler;
            this.f47606f = unitedSchemeEntity;
            this.f47607g = context;
            this.f47608h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                b.this.q(this.f47607g, this.f47606f, this.f47605e, this.f47608h);
                return;
            }
            d.b.h0.a.v1.c.c.n(hVar, this.f47605e, this.f47606f);
            if (b.this.f47604c != null) {
                b.this.f47604c.onError(new Throwable());
            } else {
                d.b.h0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
            }
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* renamed from: d.b.h0.a.x.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0908b implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f47609a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.x.e.a f47610b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47611c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47612d;

        public C0908b(Context context, d.b.h0.a.x.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f47609a = context;
            this.f47610b = aVar;
            this.f47611c = unitedSchemeEntity;
            this.f47612d = callbackHandler;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            b.this.k(this.f47611c, this.f47612d, b.this.p(this.f47609a, this.f47610b));
            d.b.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.callCallback(this.f47612d, this.f47611c, 10005);
            if (b.this.f47604c != null) {
                b.this.f47604c.onError(new Throwable());
            } else {
                d.b.h0.a.c0.c.b("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
            }
            d.b.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }
    }

    public b(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/camera/insert");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "handle action, but context is not Activity");
            return false;
        }
        d.b.h0.a.x.e.a aVar = (d.b.h0.a.x.e.a) r(unitedSchemeEntity);
        j x = new d.b.h0.a.a0.c.c.a(context, aVar).x();
        this.f47604c = x;
        if (x == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", "camera component insert delayed fail");
            return false;
        }
        eVar.R().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, aVar));
        return true;
    }

    public final boolean p(Context context, d.b.h0.a.x.e.a aVar) {
        d.b.h0.a.c0.c.g("SwanAppCameraManager", "handle insert camera instruction start");
        if (context != null && aVar != null) {
            String str = aVar.p;
            d.b.h0.a.e1.d.a.a aVar2 = aVar.l;
            if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.i()) {
                j jVar = this.f47604c;
                if (jVar == null) {
                    d.b.h0.a.a0.g.a.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                    return false;
                }
                jVar.onCompleted();
                d.b.h0.a.c0.c.g("SwanAppCameraManager", "handle insert camera instruction end");
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cameraId = ");
            sb.append(str);
            sb.append(" ; position = ");
            sb.append(aVar2 == null);
            d.b.h0.a.c0.c.b("SwanAppCameraManager", sb.toString());
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Context is null ? = ");
        sb2.append(context == null);
        sb2.append(" ; model is null ? = ");
        sb2.append(aVar == null);
        d.b.h0.a.c0.c.b("SwanAppCameraManager", sb2.toString());
        return false;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.x.e.a aVar) {
        d.b.h0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        d.b.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0908b(context, aVar, unitedSchemeEntity, callbackHandler));
    }

    public d.b.h0.a.a0.b.b r(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.b.h0.a.x.e.a(l(unitedSchemeEntity));
    }
}
