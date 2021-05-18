package d.a.i0.a.i1.h.d;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.i0.a.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c {
    static {
        boolean z = k.f43025a;
    }

    public a(String str) {
        super(str);
    }

    @Override // d.a.i0.a.i1.h.d.c
    public boolean a(d.a.i0.a.i1.h.a aVar, d.a.i0.a.i1.h.c cVar, Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        d.a.i0.a.e0.d.g("vrvideo", "open, video id:" + cVar.n + " slave id: " + cVar.f40672g);
        d(aVar, cVar, unitedSchemeEntity, callbackHandler);
        return true;
    }

    @Override // d.a.i0.a.i1.h.d.c
    public d.a.i0.a.i1.h.a b(@NonNull Context context, @Nullable String str, @Nullable String str2, @NonNull String str3, @NonNull JSONObject jSONObject) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        d.a.i0.a.i1.a f2 = d.a.i0.a.i1.b.f(str, str2, str3);
        if (f2 == null) {
            return new d.a.i0.a.i1.h.a(context, d.a.i0.a.i1.h.c.h(jSONObject, new d.a.i0.a.i1.h.c()));
        }
        if (f2.i() instanceof d.a.i0.a.i1.h.a) {
            return (d.a.i0.a.i1.h.a) f2.i();
        }
        return null;
    }

    public final void d(d.a.i0.a.i1.h.a aVar, d.a.i0.a.i1.h.c cVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        aVar.g(cVar);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }
}
