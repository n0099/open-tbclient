package d.b.h0.g.b0.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.e0.l.f;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
/* loaded from: classes3.dex */
public abstract class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public final String f48633c;

    public a(j jVar, String str, String str2) {
        super(jVar, str);
        this.f48633c = str2;
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        f W = d.b.h0.a.z0.f.V().W();
        if (W == null) {
            d.b.h0.a.c0.c.b(this.f48633c, "fragment manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.b.h0.g.b0.a.b.b bVar = (d.b.h0.g.b0.a.b.b) W.n(d.b.h0.a.e0.l.j.class);
        if (bVar == null) {
            d.b.h0.a.c0.c.b(this.f48633c, "fragment is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return k(bVar.d(), unitedSchemeEntity, callbackHandler);
    }

    public void j(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public abstract boolean k(@NonNull d.b.h0.g.b0.a.b.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);
}
