package d.b.g0.a.b1.h.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class e extends c {
    static {
        boolean z = k.f45443a;
    }

    public e(String str) {
        super(str);
    }

    @Override // d.b.g0.a.b1.h.d.c
    public boolean a(d.b.g0.a.b1.h.a aVar, d.b.g0.a.b1.h.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.c0.c.a("vrvideo", "update, video id:" + cVar.n + " slave id: " + cVar.f43506g);
        d(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    public final void d(d.b.g0.a.b1.h.a aVar, d.b.g0.a.b1.h.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.k(cVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
