package d.a.m0.a.z.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import h.j;
/* loaded from: classes2.dex */
public class b extends d.a.m0.a.z.b.a {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public j f49694c;

    /* loaded from: classes2.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49695e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49696f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f49697g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.z.e.a f49698h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.m0.a.z.e.a aVar) {
            this.f49695e = callbackHandler;
            this.f49696f = unitedSchemeEntity;
            this.f49697g = context;
            this.f49698h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                b.this.q(this.f49697g, this.f49696f, this.f49695e, this.f49698h);
                return;
            }
            d.a.m0.a.e2.c.d.o(iVar, this.f49695e, this.f49696f);
            if (b.this.f49694c != null) {
                b.this.f49694c.onError(new Throwable());
            } else {
                d.a.m0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
            }
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* renamed from: d.a.m0.a.z.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0983b implements d.a.m0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f49700a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.a.z.e.a f49701b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f49702c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f49703d;

        public C0983b(Context context, d.a.m0.a.z.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f49700a = context;
            this.f49701b = aVar;
            this.f49702c = unitedSchemeEntity;
            this.f49703d = callbackHandler;
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            b.this.k(this.f49702c, this.f49703d, b.this.p(this.f49700a, this.f49701b));
            d.a.m0.a.e0.d.b("SwanAppCameraManager", str + "");
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f49703d, this.f49702c, 10005);
            if (b.this.f49694c != null) {
                b.this.f49694c.onError(new Throwable());
            } else {
                d.a.m0.a.e0.d.b("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
            }
            d.a.m0.a.e0.d.b("SwanAppCameraManager", str + "");
        }
    }

    public b(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/insert");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "handle action, but context is not Activity");
            return false;
        }
        d.a.m0.a.z.e.a aVar = (d.a.m0.a.z.e.a) r(unitedSchemeEntity);
        j x = new d.a.m0.a.c0.c.c.a(context, aVar).x();
        this.f49694c = x;
        if (x == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", "camera component insert delayed fail");
            return false;
        }
        eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, aVar));
        return true;
    }

    public final boolean p(Context context, d.a.m0.a.z.e.a aVar) {
        d.a.m0.a.e0.d.g("SwanAppCameraManager", "handle insert camera instruction start");
        if (context != null && aVar != null) {
            String str = aVar.f44629f;
            d.a.m0.a.l1.e.a.a aVar2 = aVar.l;
            if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.i()) {
                j jVar = this.f49694c;
                if (jVar == null) {
                    d.a.m0.a.c0.g.a.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                    return false;
                }
                jVar.onCompleted();
                d.a.m0.a.e0.d.g("SwanAppCameraManager", "handle insert camera instruction end");
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cameraId = ");
            sb.append(str);
            sb.append(" ; position = ");
            sb.append(aVar2 == null);
            d.a.m0.a.e0.d.b("SwanAppCameraManager", sb.toString());
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Context is null ? = ");
        sb2.append(context == null);
        sb2.append(" ; model is null ? = ");
        sb2.append(aVar == null);
        d.a.m0.a.e0.d.b("SwanAppCameraManager", sb2.toString());
        return false;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.z.e.a aVar) {
        d.a.m0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
        d.a.m0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0983b(context, aVar, unitedSchemeEntity, callbackHandler));
    }

    public d.a.m0.a.c0.b.b r(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.m0.a.z.e.a(l(unitedSchemeEntity));
    }
}
