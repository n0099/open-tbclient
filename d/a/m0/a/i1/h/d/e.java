package d.a.m0.a.i1.h.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class e extends c {
    static {
        boolean z = k.f46983a;
    }

    public e(String str) {
        super(str);
    }

    @Override // d.a.m0.a.i1.h.d.c
    public boolean a(d.a.m0.a.i1.h.a aVar, d.a.m0.a.i1.h.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.e0.d.a("vrvideo", "update, video id:" + cVar.n + " slave id: " + cVar.f44630g);
        d(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    public final void d(d.a.m0.a.i1.h.a aVar, d.a.m0.a.i1.h.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.h(cVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
