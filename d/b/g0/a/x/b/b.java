package d.b.g0.a.x.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.sdk.PermissionRequest;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import h.j;
/* loaded from: classes2.dex */
public class b extends d.b.g0.a.x.b.a {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public j f46883c;

    /* loaded from: classes2.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46884e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46885f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46886g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.x.e.a f46887h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.b.g0.a.x.e.a aVar) {
            this.f46884e = callbackHandler;
            this.f46885f = unitedSchemeEntity;
            this.f46886g = context;
            this.f46887h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                b.this.q(this.f46886g, this.f46885f, this.f46884e, this.f46887h);
                return;
            }
            d.b.g0.a.v1.c.c.n(hVar, this.f46884e, this.f46885f);
            if (b.this.f46883c != null) {
                b.this.f46883c.onError(new Throwable());
            } else {
                d.b.g0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
            }
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* renamed from: d.b.g0.a.x.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0876b implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f46888a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.x.e.a f46889b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f46890c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46891d;

        public C0876b(Context context, d.b.g0.a.x.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f46888a = context;
            this.f46889b = aVar;
            this.f46890c = unitedSchemeEntity;
            this.f46891d = callbackHandler;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            b.this.k(this.f46890c, this.f46891d, b.this.p(this.f46888a, this.f46889b));
            d.b.g0.a.c0.c.b("SwanAppCameraManager", str + "");
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            UnitedSchemeUtility.callCallback(this.f46891d, this.f46890c, 10005);
            if (b.this.f46883c != null) {
                b.this.f46883c.onError(new Throwable());
            } else {
                d.b.g0.a.c0.c.b("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
            }
            d.b.g0.a.c0.c.b("SwanAppCameraManager", str + "");
        }
    }

    public b(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/camera/insert");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "handle action, but context is not Activity");
            return false;
        }
        d.b.g0.a.x.e.a aVar = (d.b.g0.a.x.e.a) r(unitedSchemeEntity);
        j x = new d.b.g0.a.a0.c.c.a(context, aVar).x();
        this.f46883c = x;
        if (x == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", "camera component insert delayed fail");
            return false;
        }
        eVar.R().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, aVar));
        return true;
    }

    public final boolean p(Context context, d.b.g0.a.x.e.a aVar) {
        d.b.g0.a.c0.c.g("SwanAppCameraManager", "handle insert camera instruction start");
        if (context != null && aVar != null) {
            String str = aVar.p;
            d.b.g0.a.e1.d.a.a aVar2 = aVar.l;
            if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.i()) {
                j jVar = this.f46883c;
                if (jVar == null) {
                    d.b.g0.a.a0.g.a.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                    return false;
                }
                jVar.onCompleted();
                d.b.g0.a.c0.c.g("SwanAppCameraManager", "handle insert camera instruction end");
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cameraId = ");
            sb.append(str);
            sb.append(" ; position = ");
            sb.append(aVar2 == null);
            d.b.g0.a.c0.c.b("SwanAppCameraManager", sb.toString());
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Context is null ? = ");
        sb2.append(context == null);
        sb2.append(" ; model is null ? = ");
        sb2.append(aVar == null);
        d.b.g0.a.c0.c.b("SwanAppCameraManager", sb2.toString());
        return false;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.x.e.a aVar) {
        d.b.g0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        d.b.g0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0876b(context, aVar, unitedSchemeEntity, callbackHandler));
    }

    public d.b.g0.a.a0.b.b r(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.b.g0.a.x.e.a(l(unitedSchemeEntity));
    }
}
