package d.b.h0.a.b1.g.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class j extends g {
    static {
        boolean z = d.b.h0.a.k.f45772a;
    }

    public j(String str) {
        super(str);
    }

    @Override // d.b.h0.a.b1.g.d.g
    public boolean a(d.b.h0.a.b1.g.a aVar, d.b.h0.a.b1.g.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.c0.c.g("video", "sendDanmu, video id:" + cVar.n + " slave id: " + cVar.f43835g);
        d(aVar, cVar.x, unitedSchemeEntity, callbackHandler);
        return true;
    }

    public final void d(d.b.h0.a.b1.g.a aVar, String str, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.s(str);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
