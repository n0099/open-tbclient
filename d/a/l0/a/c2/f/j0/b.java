package d.a.l0.a.c2.f.j0;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.v2.q0;
/* loaded from: classes3.dex */
public class b extends a0 {

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a(b bVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.a.l0.a.z1.b.f.e.a();
        }
    }

    public b(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/hideToast");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        if (a0.f44625b) {
            Log.d("HideToastAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        if (eVar == null) {
            d.a.l0.a.e0.d.b("hideToast", "aiapp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        q0.b0(new a(this));
        unitedSchemeEntity.result = UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }
}
