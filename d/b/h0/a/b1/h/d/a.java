package d.b.h0.a.b1.h.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends c {
    static {
        boolean z = k.f45772a;
    }

    public a(String str) {
        super(str);
    }

    @Override // d.b.h0.a.b1.h.d.c
    public boolean a(d.b.h0.a.b1.h.a aVar, d.b.h0.a.b1.h.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.c0.c.g("vrvideo", "open, video id:" + cVar.n + " slave id: " + cVar.f43835g);
        d(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    @Override // d.b.h0.a.b1.h.d.c
    public d.b.h0.a.b1.h.a b(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        d.b.h0.a.b1.a f2 = d.b.h0.a.b1.b.f(str, str2, str3);
        if (f2 == null) {
            return new d.b.h0.a.b1.h.a(context, d.b.h0.a.b1.h.c.h(jSONObject, new d.b.h0.a.b1.h.c()));
        }
        if (f2.a() instanceof d.b.h0.a.b1.h.a) {
            return (d.b.h0.a.b1.h.a) f2.a();
        }
        return null;
    }

    public final void d(d.b.h0.a.b1.h.a aVar, d.b.h0.a.b1.h.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.j(cVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
