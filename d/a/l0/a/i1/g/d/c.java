package d.a.l0.a.i1.g.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends g {
    static {
        boolean z = d.a.l0.a.k.f43199a;
    }

    public c(String str) {
        super(str);
    }

    @Override // d.a.l0.a.i1.g.d.g
    public boolean a(d.a.l0.a.i1.g.a aVar, d.a.l0.a.i1.g.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.e0.d.g("video", "open, video id:" + cVar.n + " slave id: " + cVar.f40846g);
        aVar.l();
        d(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    @Override // d.a.l0.a.i1.g.d.g
    public d.a.l0.a.i1.g.a b(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        d.a.l0.a.i1.a f2 = d.a.l0.a.i1.b.f(str, str2, str3);
        if (f2 == null) {
            return new d.a.l0.a.i1.g.a(context, d.a.l0.a.i1.g.c.h(jSONObject, new d.a.l0.a.i1.g.c()));
        }
        if (f2.i() instanceof d.a.l0.a.i1.g.a) {
            return (d.a.l0.a.i1.g.a) f2.i();
        }
        return null;
    }

    public final void d(d.a.l0.a.i1.g.a aVar, d.a.l0.a.i1.g.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.o(cVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
