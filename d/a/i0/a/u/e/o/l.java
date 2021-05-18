package d.a.i0.a.u.e.o;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public final String f45009a;

    /* renamed from: b  reason: collision with root package name */
    public final String f45010b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f45011c;

    public l(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.f45009a = str;
        this.f45010b = str2;
        this.f45011c = jSONObject.optBoolean("useEvent");
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.f45011c) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f45010b);
        }
    }

    public void b(d.a.i0.a.u.c.d dVar) {
        if (this.f45011c) {
            dVar.d(this.f45010b, new d.a.i0.a.u.h.b(0));
        }
    }

    public void c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.f45011c) {
            d.a.i0.a.g1.f.V().v(new d.a.i0.a.o0.d.f(this.f45009a, new d.a.i0.a.u.h.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f45010b);
    }

    public void d(d.a.i0.a.u.c.d dVar, JSONObject jSONObject) {
        d.a.i0.a.u.h.b bVar = new d.a.i0.a.u.h.b(0, jSONObject);
        if (this.f45011c) {
            d.a.i0.a.g1.f.V().v(new d.a.i0.a.o0.d.f(this.f45009a, bVar));
        } else {
            dVar.d(this.f45010b, bVar);
        }
    }

    public void e(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.f45011c) {
            d.a.i0.a.g1.f.V().v(new d.a.i0.a.o0.d.f(this.f45009a, new d.a.i0.a.u.h.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f45010b);
    }

    public void f(d.a.i0.a.u.c.d dVar, String str) {
        d.a.i0.a.u.h.b bVar = new d.a.i0.a.u.h.b(1001, str);
        if (this.f45011c) {
            d.a.i0.a.g1.f.V().v(new d.a.i0.a.o0.d.f(this.f45009a, bVar));
        } else {
            dVar.d(this.f45010b, bVar);
        }
    }
}
