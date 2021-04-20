package d.b.g0.a.t.c.m;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final String f46588a;

    /* renamed from: b  reason: collision with root package name */
    public final String f46589b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f46590c;

    public k(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.f46588a = str;
        this.f46589b = str2;
        this.f46590c = jSONObject.optBoolean("useEvent");
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.f46590c) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f46589b);
        }
    }

    public void b(d.b.g0.a.t.b.d dVar) {
        if (this.f46590c) {
            dVar.c(this.f46589b, new d.b.g0.a.t.e.b(0));
        }
    }

    public void c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.f46590c) {
            d.b.g0.a.z0.f.V().N(new d.b.g0.a.k0.b.f(this.f46588a, new d.b.g0.a.t.e.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f46589b);
    }

    public void d(d.b.g0.a.t.b.d dVar, JSONObject jSONObject) {
        d.b.g0.a.t.e.b bVar = new d.b.g0.a.t.e.b(0, jSONObject);
        if (this.f46590c) {
            d.b.g0.a.z0.f.V().N(new d.b.g0.a.k0.b.f(this.f46588a, bVar));
        } else {
            dVar.c(this.f46589b, bVar);
        }
    }

    public void e(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.f46590c) {
            d.b.g0.a.z0.f.V().N(new d.b.g0.a.k0.b.f(this.f46588a, new d.b.g0.a.t.e.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f46589b);
    }

    public void f(d.b.g0.a.t.b.d dVar, String str) {
        d.b.g0.a.t.e.b bVar = new d.b.g0.a.t.e.b(1001, str);
        if (this.f46590c) {
            d.b.g0.a.z0.f.V().N(new d.b.g0.a.k0.b.f(this.f46588a, bVar));
        } else {
            dVar.c(this.f46589b, bVar);
        }
    }
}
