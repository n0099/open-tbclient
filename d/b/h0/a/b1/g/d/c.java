package d.b.h0.a.b1.g.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends g {
    static {
        boolean z = d.b.h0.a.k.f45772a;
    }

    public c(String str) {
        super(str);
    }

    @Override // d.b.h0.a.b1.g.d.g
    public boolean a(d.b.h0.a.b1.g.a aVar, d.b.h0.a.b1.g.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.c0.c.g("video", "open, video id:" + cVar.n + " slave id: " + cVar.f43835g);
        aVar.m();
        d(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    @Override // d.b.h0.a.b1.g.d.g
    public d.b.h0.a.b1.g.a b(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        d.b.h0.a.b1.a f2 = d.b.h0.a.b1.b.f(str, str2, str3);
        if (f2 == null) {
            return new d.b.h0.a.b1.g.a(context, d.b.h0.a.b1.g.c.h(jSONObject, new d.b.h0.a.b1.g.c()));
        }
        if (f2.a() instanceof d.b.h0.a.b1.g.a) {
            return (d.b.h0.a.b1.g.a) f2.a();
        }
        return null;
    }

    public final void d(d.b.h0.a.b1.g.a aVar, d.b.h0.a.b1.g.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.q(cVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
