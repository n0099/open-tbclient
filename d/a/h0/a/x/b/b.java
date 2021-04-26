package d.a.h0.a.x.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import h.j;
/* loaded from: classes2.dex */
public class b extends d.a.h0.a.x.b.a {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public j f45030c;

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45031e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45032f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45033g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.x.e.a f45034h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.h0.a.x.e.a aVar) {
            this.f45031e = callbackHandler;
            this.f45032f = unitedSchemeEntity;
            this.f45033g = context;
            this.f45034h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                b.this.q(this.f45033g, this.f45032f, this.f45031e, this.f45034h);
                return;
            }
            d.a.h0.a.v1.c.c.n(hVar, this.f45031e, this.f45032f);
            if (b.this.f45030c != null) {
                b.this.f45030c.onError(new Throwable());
            } else {
                d.a.h0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
            }
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* renamed from: d.a.h0.a.x.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0847b implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45036a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.x.e.a f45037b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45038c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45039d;

        public C0847b(Context context, d.a.h0.a.x.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f45036a = context;
            this.f45037b = aVar;
            this.f45038c = unitedSchemeEntity;
            this.f45039d = callbackHandler;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            b.this.k(this.f45038c, this.f45039d, b.this.p(this.f45036a, this.f45037b));
            d.a.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f45039d, this.f45038c, 10005);
            if (b.this.f45030c != null) {
                b.this.f45030c.onError(new Throwable());
            } else {
                d.a.h0.a.c0.c.b("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
            }
            d.a.h0.a.c0.c.b("SwanAppCameraManager", str + "");
        }
    }

    public b(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/camera/insert");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "handle action, but context is not Activity");
            return false;
        }
        d.a.h0.a.x.e.a aVar = (d.a.h0.a.x.e.a) r(unitedSchemeEntity);
        j x = new d.a.h0.a.a0.c.c.a(context, aVar).x();
        this.f45030c = x;
        if (x == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", "camera component insert delayed fail");
            return false;
        }
        eVar.R().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, aVar));
        return true;
    }

    public final boolean p(Context context, d.a.h0.a.x.e.a aVar) {
        d.a.h0.a.c0.c.g("SwanAppCameraManager", "handle insert camera instruction start");
        if (context != null && aVar != null) {
            String str = aVar.p;
            d.a.h0.a.e1.d.a.a aVar2 = aVar.l;
            if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.i()) {
                j jVar = this.f45030c;
                if (jVar == null) {
                    d.a.h0.a.a0.g.a.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                    return false;
                }
                jVar.onCompleted();
                d.a.h0.a.c0.c.g("SwanAppCameraManager", "handle insert camera instruction end");
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cameraId = ");
            sb.append(str);
            sb.append(" ; position = ");
            sb.append(aVar2 == null);
            d.a.h0.a.c0.c.b("SwanAppCameraManager", sb.toString());
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Context is null ? = ");
        sb2.append(context == null);
        sb2.append(" ; model is null ? = ");
        sb2.append(aVar == null);
        d.a.h0.a.c0.c.b("SwanAppCameraManager", sb2.toString());
        return false;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.x.e.a aVar) {
        d.a.h0.a.c0.c.g("SwanAppCameraManager", "handleAuthorized start");
        d.a.h0.a.k1.a.a(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0847b(context, aVar, unitedSchemeEntity, callbackHandler));
    }

    public d.a.h0.a.a0.b.b r(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.h0.a.x.e.a(l(unitedSchemeEntity));
    }
}
