package d.b.h0.a.b1.g.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class h extends g {
    static {
        boolean z = d.b.h0.a.k.f45772a;
    }

    public h(String str) {
        super(str);
    }

    @Override // d.b.h0.a.b1.g.d.g
    public boolean a(d.b.h0.a.b1.g.a aVar, d.b.h0.a.b1.g.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.c0.c.g("video", "remove, video id:" + cVar.n + " slave id: " + cVar.f43835g);
        d(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    public final void d(d.b.h0.a.b1.g.a aVar, d.b.h0.a.b1.g.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        d.b.h0.a.a0.b.a a2 = d.b.h0.a.a0.d.a.a(cVar);
        if (a2 != null) {
            a2.C();
        } else {
            d.b.h0.a.a0.g.a.a("VideoPlayerAction", "remove with a null component");
        }
        aVar.onDestroy();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
