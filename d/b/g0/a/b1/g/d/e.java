package d.b.g0.a.b1.g.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes2.dex */
public class e extends g {
    static {
        boolean z = d.b.g0.a.k.f45443a;
    }

    public e(String str) {
        super(str);
    }

    @Override // d.b.g0.a.b1.g.d.g
    public boolean a(d.b.g0.a.b1.g.a aVar, d.b.g0.a.b1.g.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.c0.c.g("video", "play, video id:" + cVar.n + " slave id: " + cVar.f43506g);
        d(aVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    public final void d(d.b.g0.a.b1.g.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.t();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
