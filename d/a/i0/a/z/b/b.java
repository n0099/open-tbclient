package d.a.i0.a.z.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.smallgame.sdk.permission.PermissionProxy;
import com.baidu.webkit.sdk.PermissionRequest;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import h.j;
/* loaded from: classes2.dex */
public class b extends d.a.i0.a.z.b.a {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public j f45736c;

    /* loaded from: classes2.dex */
    public class a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45737e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45738f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45739g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.z.e.a f45740h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.i0.a.z.e.a aVar) {
            this.f45737e = callbackHandler;
            this.f45738f = unitedSchemeEntity;
            this.f45739g = context;
            this.f45740h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                b.this.q(this.f45739g, this.f45738f, this.f45737e, this.f45740h);
                return;
            }
            d.a.i0.a.e2.c.d.o(iVar, this.f45737e, this.f45738f);
            if (b.this.f45736c != null) {
                b.this.f45736c.onError(new Throwable());
            } else {
                d.a.i0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
            }
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* renamed from: d.a.i0.a.z.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0913b implements d.a.i0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45742a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.z.e.a f45743b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45744c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45745d;

        public C0913b(Context context, d.a.i0.a.z.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f45742a = context;
            this.f45743b = aVar;
            this.f45744c = unitedSchemeEntity;
            this.f45745d = callbackHandler;
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            b.this.k(this.f45744c, this.f45745d, b.this.p(this.f45742a, this.f45743b));
            d.a.i0.a.e0.d.b("SwanAppCameraManager", str + "");
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f45745d, this.f45744c, 10005);
            if (b.this.f45736c != null) {
                b.this.f45736c.onError(new Throwable());
            } else {
                d.a.i0.a.e0.d.b("SwanAppCameraManager", "handleAuthorized end, failure with a null subscriber ");
            }
            d.a.i0.a.e0.d.b("SwanAppCameraManager", str + "");
        }
    }

    public b(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/camera/insert");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "handle action, but context is not Activity");
            return false;
        }
        d.a.i0.a.z.e.a aVar = (d.a.i0.a.z.e.a) r(unitedSchemeEntity);
        j x = new d.a.i0.a.c0.c.c.a(context, aVar).x();
        this.f45736c = x;
        if (x == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", "camera component insert delayed fail");
            return false;
        }
        eVar.T().g(context, PermissionProxy.SCOPE_ID_CAMERA, new a(callbackHandler, unitedSchemeEntity, context, aVar));
        return true;
    }

    public final boolean p(Context context, d.a.i0.a.z.e.a aVar) {
        d.a.i0.a.e0.d.g("SwanAppCameraManager", "handle insert camera instruction start");
        if (context != null && aVar != null) {
            String str = aVar.f40671f;
            d.a.i0.a.l1.e.a.a aVar2 = aVar.l;
            if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.i()) {
                j jVar = this.f45736c;
                if (jVar == null) {
                    d.a.i0.a.c0.g.a.a("SwanAppCameraManager", "executionInstruction with a null subscriber");
                    return false;
                }
                jVar.onCompleted();
                d.a.i0.a.e0.d.g("SwanAppCameraManager", "handle insert camera instruction end");
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("cameraId = ");
            sb.append(str);
            sb.append(" ; position = ");
            sb.append(aVar2 == null);
            d.a.i0.a.e0.d.b("SwanAppCameraManager", sb.toString());
            return false;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Context is null ? = ");
        sb2.append(context == null);
        sb2.append(" ; model is null ? = ");
        sb2.append(aVar == null);
        d.a.i0.a.e0.d.b("SwanAppCameraManager", sb2.toString());
        return false;
    }

    public final void q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.z.e.a aVar) {
        d.a.i0.a.e0.d.g("SwanAppCameraManager", "handleAuthorized start");
        d.a.i0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0913b(context, aVar, unitedSchemeEntity, callbackHandler));
    }

    public d.a.i0.a.c0.b.b r(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.i0.a.z.e.a(l(unitedSchemeEntity));
    }
}
