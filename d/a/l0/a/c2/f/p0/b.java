package d.a.l0.a.c2.f.p0;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.l0.a.c2.f.a0;
/* loaded from: classes3.dex */
public class b extends a0 {
    public b(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/exit");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.g1.f.V().exit();
        return true;
    }
}
