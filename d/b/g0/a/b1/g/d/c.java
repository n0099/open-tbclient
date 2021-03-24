package d.b.g0.a.b1.g.d;

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
        boolean z = d.b.g0.a.k.f45050a;
    }

    public c(String str) {
        super(str);
    }

    @Override // d.b.g0.a.b1.g.d.g
    public boolean a(d.b.g0.a.b1.g.a aVar, d.b.g0.a.b1.g.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        d.b.g0.a.c0.c.g("video", "open, video id:" + cVar.n + " slave id: " + cVar.f43113g);
        aVar.m();
        d(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    @Override // d.b.g0.a.b1.g.d.g
    public d.b.g0.a.b1.g.a b(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        d.b.g0.a.b1.a f2 = d.b.g0.a.b1.b.f(str, str2, str3);
        if (f2 == null) {
            return new d.b.g0.a.b1.g.a(context, d.b.g0.a.b1.g.c.h(jSONObject, new d.b.g0.a.b1.g.c()));
        }
        if (f2.a() instanceof d.b.g0.a.b1.g.a) {
            return (d.b.g0.a.b1.g.a) f2.a();
        }
        return null;
    }

    public final void d(d.b.g0.a.b1.g.a aVar, d.b.g0.a.b1.g.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.q(cVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
