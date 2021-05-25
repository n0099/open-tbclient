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
    public j f45912c;

    /* loaded from: classes2.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45913e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45914f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45915g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.a f45916h;

        public a(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, Context context, d.a.l0.a.z.e.a aVar) {
            this.f45913e = callbackHandler;
            this.f45914f = unitedSchemeEntity;
            this.f45915g = context;
            this.f45916h = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                b.this.q(this.f45915g, this.f45914f, this.f45913e, this.f45916h);
                return;
            }
            d.a.l0.a.e2.c.d.o(iVar, this.f45913e, this.f45914f);
            if (b.this.f45912c != null) {
                b.this.f45912c.onError(new Throwable());
            } else {
                d.a.l0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure with a null subscriber ");
            }
            d.a.l0.a.e0.d.b("SwanAppCameraManager", "camera authorize failure");
        }
    }

    /* renamed from: d.a.l0.a.z.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0924b implements d.a.l0.a.s1.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f45918a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.z.e.a f45919b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45920c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45921d;

        public C0924b(Context context, d.a.l0.a.z.e.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f45918a = context;
            this.f45919b = aVar;
            this.f45920c = unitedSchemeEntity;
            this.f45921d = callbackHandler;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            b.this.k(this.f45920c, this.f45921d, b.this.p(this.f45918a, this.f45919b));
            d.a.l0.a.e0.d.b("SwanAppCameraManager", str + "");
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            UnitedSchemeUtility.callCallback(this.f45921d, this.f45920c, 10005);
            if (b.this.f45912c != null) {
                b.this.f45912c.onError(new Throwable());
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
        this.f45912c = x;
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
            String str = aVar.f40845f;
            d.a.l0.a.l1.e.a.a aVar2 = aVar.l;
            if (!TextUtils.isEmpty(str) && aVar2 != null && aVar2.i()) {
                j jVar = this.f45912c;
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
        d.a.l0.a.s1.e.e(PermissionRequest.RESOURCE_VIDEO_CAPTURE, new String[]{PermissionRequest.RESOURCE_VIDEO_CAPTURE}, 1, context, new C0924b(context, aVar, unitedSchemeEntity, callbackHandler));
    }

    public d.a.l0.a.c0.b.b r(UnitedSchemeEntity unitedSchemeEntity) {
        return new d.a.l0.a.z.e.a(l(unitedSchemeEntity));
    }
}
