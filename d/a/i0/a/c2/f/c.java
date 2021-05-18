package d.a.i0.a.c2.f;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.SwanAppActivity;
import d.a.i0.a.v2.e0;
import d.a.i0.a.v2.q0;
/* loaded from: classes3.dex */
public class c extends a0 {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f40776e;

        public a(c cVar, SwanAppActivity swanAppActivity) {
            this.f40776e = swanAppActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            e0.a(this.f40776e);
        }
    }

    public c(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/applyUpdate");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.i0.a.e0.d.b("applyUpdate", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (!(context instanceof SwanAppActivity)) {
            d.a.i0.a.e0.d.b("applyUpdate", "context is not SwanAppActivity");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else {
            SwanAppActivity swanAppActivity = (SwanAppActivity) context;
            Intent intent = swanAppActivity.getIntent();
            if (!swanAppActivity.isDestroyed() && intent != null) {
                q0.b0(new a(this, swanAppActivity));
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
                return true;
            }
            d.a.i0.a.e0.d.b("applyUpdate", "launchScheme is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty launchScheme");
            return false;
        }
    }
}
