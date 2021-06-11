package d.a.l0.a.z.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import h.j;
/* loaded from: classes2.dex */
public class b extends d.a.l0.a.z.b.a {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public j f49586c;

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49587e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49588f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49589g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.a f49590h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.l0.a.z.e.a aVar) {
            this.f49587e = callbackHandler;
            this.f49588f = unitedSchemeEntity;
            this.f49589g = context;
            this.f49590h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                b.this.q(this.f49589g, this.f49588f, this.f49587e, this.f49590h);
                return;
            }
            d.a.l0.a.e2.c.d.o(iVar, this.f49587e, this.f49588f);
            if (b.this.f49586c != null) {
                b.this.f49586c.onError(new Throwable());
            } else {
                d.a.l0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
            }
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* renamed from: d.a.l0.a.z.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0980b implements d.a.l0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f49592a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.a f49593b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49594c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49595d;

        public C0980b(Context context, d.a.l0.a.z.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f49592a = context;
            this.f49593b = aVar;
            this.f49594c = unitedSchemeEntity;
            this.f49595d = callbackHandler;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            b.this.k(this.f49594c, this.f49595d, b.this.p(this.f49592a, this.f49593b));
            d.a.l0.a.e0.d.b("SwanAppCameraManager", str + "");
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f49595d, this.f49594c, 10005);
            if (b.this.f49586c != null) {
                b.this.f49586c.onError(new Throwable());
            } else {
                d.a.l0.a.e0.d.b("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
            }
            d.a.l0.a.e0.d.b("SwanAppCameraManager", str + "");
        }
    }

    public b(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/insert");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "handle action, but context is not Activity");
            return false;
        }
        d.a.l0.a.z.e.a aVar = (d.a.l0.a.z.e.a) r(unitedSchemeEntity);
        j x = new d.a.l0.a.c0.c.c.a(context, aVar).x();
        this.f49586c = x;
        if (x == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "camera component insert delayed fail");
            return false;
        }
        eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, aVar));
        return true;
    }

    public final boolean p(Context context, d.a.l0.a.z.e.a aVar) {
        d.a.l0.a.e0.d.g("SwanAppCameraManager", "handle insert camera instruction start");
        if (context != null && aVar != null) {
            String str = aVar.f44521f;
            d.a.l0.a.l1.e.a.a aVar2 = aVar.l;
            if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.i()) {
                j jVar = this.f49586c;
                if (jVar == null) {
                    d.a.l0.a.c0.g.a.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                    return false;
                }
                jVar.onCompleted();
                d.a.l0.a.e0.d.g("SwanAppCameraManager", "handle insert camera instruction end");
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cameraId = ");
            sb.append(str);
            sb.append(" ; position = ");
            sb.append(aVar2 == null);
            d.a.l0.a.e0.d.b("SwanAppCameraManager", sb.toString());
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Context is null ? = ");
        sb2.append(context == null);
        sb2.append(" ; model is null ? = ");
        sb2.append(aVar == null);
        d.a.l0.a.e0.d.b("SwanAppCameraManager", sb2.toString());
        return false;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.z.e.a aVar) {
        d.a.l0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
        d.a.l0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0980b(context, aVar, unitedSchemeEntity, callbackHandler));
    }

    public d.a.l0.a.c0.b.b r(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.l0.a.z.e.a(l(unitedSchemeEntity));
    }
}
