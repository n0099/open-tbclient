package d.a.h0.a.b1.g.d;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
/* loaded from: classes3.dex */
public class e extends g {
    static {
        boolean z = d.a.h0.a.k.f43101a;
    }

    public e(String str) {
        super(str);
    }

    @Override // d.a.h0.a.b1.g.d.g
    public boolean a(d.a.h0.a.b1.g.a aVar, d.a.h0.a.b1.g.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.c0.c.g("video", "play, video id:" + cVar.n + " slave id: " + cVar.f41093g);
        d(aVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    public final void d(d.a.h0.a.b1.g.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.t();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
