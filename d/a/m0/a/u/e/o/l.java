package d.a.m0.a.u.e.o;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final String f48967a;

    /* renamed from: b  reason: collision with root package name */
    public final String f48968b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f48969c;

    public l(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.f48967a = str;
        this.f48968b = str2;
        this.f48969c = jSONObject.optBoolean("useEvent");
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.f48969c) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f48968b);
        }
    }

    public void b(d.a.m0.a.u.c.d dVar) {
        if (this.f48969c) {
            dVar.d(this.f48968b, new d.a.m0.a.u.h.b(0));
        }
    }

    public void c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.f48969c) {
            d.a.m0.a.g1.f.V().v(new d.a.m0.a.o0.d.f(this.f48967a, new d.a.m0.a.u.h.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f48968b);
    }

    public void d(d.a.m0.a.u.c.d dVar, JSONObject jSONObject) {
        d.a.m0.a.u.h.b bVar = new d.a.m0.a.u.h.b(0, jSONObject);
        if (this.f48969c) {
            d.a.m0.a.g1.f.V().v(new d.a.m0.a.o0.d.f(this.f48967a, bVar));
        } else {
            dVar.d(this.f48968b, bVar);
        }
    }

    public void e(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.f48969c) {
            d.a.m0.a.g1.f.V().v(new d.a.m0.a.o0.d.f(this.f48967a, new d.a.m0.a.u.h.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f48968b);
    }

    public void f(d.a.m0.a.u.c.d dVar, String str) {
        d.a.m0.a.u.h.b bVar = new d.a.m0.a.u.h.b(1001, str);
        if (this.f48969c) {
            d.a.m0.a.g1.f.V().v(new d.a.m0.a.o0.d.f(this.f48967a, bVar));
        } else {
            dVar.d(this.f48968b, bVar);
        }
    }
}
