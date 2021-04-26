package d.a.h0.g.b0.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.e0.l.f;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
/* loaded from: classes3.dex */
public abstract class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public final String f46097c;

    public a(j jVar, String str, String str2) {
        super(jVar, str);
        this.f46097c = str2;
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        f W = d.a.h0.a.z0.f.V().W();
        if (W == null) {
            d.a.h0.a.c0.c.b(this.f46097c, "fragment manager is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        d.a.h0.g.b0.a.b.b bVar = (d.a.h0.g.b0.a.b.b) W.n(d.a.h0.a.e0.l.j.class);
        if (bVar == null) {
            d.a.h0.a.c0.c.b(this.f46097c, "fragment is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        return k(bVar.d(), unitedSchemeEntity, callbackHandler);
    }

    public void j(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public abstract boolean k(@NonNull d.a.h0.g.b0.a.b.a aVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler);
}
