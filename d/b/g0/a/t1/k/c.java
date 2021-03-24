package d.b.g0.a.t1.k;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.b.g0.a.i2.k0;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f46288e;

        public a(c cVar, SwanAppActivity swanAppActivity) {
            this.f46288e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.b.g0.g.i0.a.a(this.f46288e);
        }
    }

    public c(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/applyUpdate");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        if (eVar == null) {
            d.b.g0.a.c0.c.b("applyUpdate", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (!(context instanceof SwanAppActivity)) {
            d.b.g0.a.c0.c.b("applyUpdate", "context is not SwanAppActivity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else {
            SwanAppActivity swanAppActivity = (SwanAppActivity) context;
            Intent intent = swanAppActivity.getIntent();
            if (!swanAppActivity.isDestroyed() && intent != null) {
                k0.X(new a(this, swanAppActivity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.b.g0.a.c0.c.b("applyUpdate", "launchScheme is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty launchScheme");
            return false;
        }
    }
}
