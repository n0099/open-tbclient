package d.a.h0.a.t1.k.j0;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.i2.k0;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a(b bVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.h0.a.q1.b.f.d.a();
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/hideToast");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (a0.f44398b) {
            Log.d("HideToastAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar == null) {
            d.a.h0.a.c0.c.b("hideToast", "aiapp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        k0.X(new a(this));
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
