package d.a.i0.a.w1.f;

import android.content.Context;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.c2.e;
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.g1.f;
import d.a.i0.a.h0.g.g;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class a extends a0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e dispatcher) {
        super(dispatcher, "/swanAPI/community/closeCommunityEditor");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity entity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entity, "entity");
        if (eVar != null) {
            f V = f.V();
            Intrinsics.checkNotNullExpressionValue(V, "SwanAppController.getInstance()");
            g W = V.W();
            if (W != null) {
                d.a.i0.a.h0.g.d m = W.m();
                if (m instanceof d.a.i0.a.w1.c) {
                    ((d.a.i0.a.w1.c) m).d3();
                    entity.result = UnitedSchemeUtility.wrapCallbackParams(0, "");
                    return true;
                }
            }
            entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "top is not publisher");
            return false;
        }
        entity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal app info");
        return false;
    }
}
