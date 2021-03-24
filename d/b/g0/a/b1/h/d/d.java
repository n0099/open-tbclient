package d.b.g0.a.b1.h.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class d extends c {
    static {
        boolean z = k.f45050a;
    }

    public d(String str) {
        super(str);
    }

    @Override // d.b.g0.a.b1.h.d.c
    public boolean a(d.b.g0.a.b1.h.a aVar, d.b.g0.a.b1.h.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.c0.c.g("vrvideo", "remove, video id:" + cVar.n + " slave id: " + cVar.f43113g);
        d(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    public final void d(d.b.g0.a.b1.h.a aVar, d.b.g0.a.b1.h.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        d.b.g0.a.a0.b.a a2 = d.b.g0.a.a0.d.a.a(cVar);
        if (a2 != null) {
            a2.C();
        } else {
            d.b.g0.a.a0.g.a.a("VrVideoRemoveAction", "remove with a null component");
        }
        aVar.onDestroy();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
