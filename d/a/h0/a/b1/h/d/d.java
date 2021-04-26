package d.a.h0.a.b1.h.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class d extends c {
    static {
        boolean z = k.f43101a;
    }

    public d(String str) {
        super(str);
    }

    @Override // d.a.h0.a.b1.h.d.c
    public boolean a(d.a.h0.a.b1.h.a aVar, d.a.h0.a.b1.h.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.c0.c.g("vrvideo", "remove, video id:" + cVar.n + " slave id: " + cVar.f41093g);
        d(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    public final void d(d.a.h0.a.b1.h.a aVar, d.a.h0.a.b1.h.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        d.a.h0.a.a0.b.a a2 = d.a.h0.a.a0.d.a.a(cVar);
        if (a2 != null) {
            a2.C();
        } else {
            d.a.h0.a.a0.g.a.a("VrVideoRemoveAction", "remove with a null component");
        }
        aVar.onDestroy();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
