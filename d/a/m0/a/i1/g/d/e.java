package d.a.m0.a.i1.g.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes3.dex */
public class e extends g {
    static {
        boolean z = d.a.m0.a.k.f46983a;
    }

    public e(String str) {
        super(str);
    }

    @Override // d.a.m0.a.i1.g.d.g
    public boolean a(d.a.m0.a.i1.g.a aVar, d.a.m0.a.i1.g.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        d.a.m0.a.e0.d.g("video", "play, video id:" + cVar.n + " slave id: " + cVar.f44630g);
        d(aVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    public final void d(d.a.m0.a.i1.g.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.r();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
