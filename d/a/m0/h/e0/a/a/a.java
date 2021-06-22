package d.a.m0.h.e0.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.m0.a.c2.e;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e0.d;
import d.a.m0.a.g1.f;
import d.a.m0.a.h0.g.g;
/* loaded from: classes3.dex */
public abstract class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public final String f51094c;

    public a(e eVar, String str, String str2) {
        super(eVar, str);
        this.f51094c = str2;
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        g W = f.V().W();
        if (W == null) {
            d.b(this.f51094c, "fragment manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.m0.h.e0.a.b.b bVar = (d.a.m0.h.e0.a.b.b) W.n(d.a.m0.h.n.a.class);
        if (bVar == null) {
            d.b(this.f51094c, "fragment is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return k(bVar.b(), unitedSchemeEntity, callbackHandler);
    }

    public void j(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public abstract boolean k(@NonNull d.a.m0.h.e0.a.b.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);
}
