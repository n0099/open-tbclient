package d.a.l0.a.i1.h.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class d extends c {
    static {
        boolean z = k.f46875a;
    }

    public d(String str) {
        super(str);
    }

    @Override // d.a.l0.a.i1.h.d.c
    public boolean a(d.a.l0.a.i1.h.a aVar, d.a.l0.a.i1.h.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.e0.d.g("vrvideo", "remove, video id:" + cVar.n + " slave id: " + cVar.f44522g);
        d(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    public final void d(d.a.l0.a.i1.h.a aVar, d.a.l0.a.i1.h.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        d.a.l0.a.c0.b.a a2 = d.a.l0.a.c0.d.a.a(cVar);
        if (a2 != null) {
            a2.C();
        } else {
            d.a.l0.a.c0.g.a.a("VrVideoRemoveAction", "remove with a null component");
        }
        aVar.onDestroy();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
