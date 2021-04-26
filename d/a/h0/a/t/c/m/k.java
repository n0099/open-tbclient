package d.a.h0.a.t.c.m;

import androidx.annotation.NonNull;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final String f44304a;

    /* renamed from: b  reason: collision with root package name */
    public final String f44305b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f44306c;

    public k(@NonNull String str, @NonNull JSONObject jSONObject, String str2) {
        this.f44304a = str;
        this.f44305b = str2;
        this.f44306c = jSONObject.optBoolean("useEvent");
    }

    public void a(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        if (this.f44306c) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0).toString(), this.f44305b);
        }
    }

    public void b(d.a.h0.a.t.b.d dVar) {
        if (this.f44306c) {
            dVar.c(this.f44305b, new d.a.h0.a.t.e.b(0));
        }
    }

    public void c(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONObject jSONObject) {
        if (this.f44306c) {
            d.a.h0.a.z0.f.V().x(new d.a.h0.a.k0.b.f(this.f44304a, new d.a.h0.a.t.e.b(0, jSONObject)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString(), this.f44305b);
    }

    public void d(d.a.h0.a.t.b.d dVar, JSONObject jSONObject) {
        d.a.h0.a.t.e.b bVar = new d.a.h0.a.t.e.b(0, jSONObject);
        if (this.f44306c) {
            d.a.h0.a.z0.f.V().x(new d.a.h0.a.k0.b.f(this.f44304a, bVar));
        } else {
            dVar.c(this.f44305b, bVar);
        }
    }

    public void e(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        if (this.f44306c) {
            d.a.h0.a.z0.f.V().x(new d.a.h0.a.k0.b.f(this.f44304a, new d.a.h0.a.t.e.b(1001, str)));
            return;
        }
        UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, str).toString(), this.f44305b);
    }

    public void f(d.a.h0.a.t.b.d dVar, String str) {
        d.a.h0.a.t.e.b bVar = new d.a.h0.a.t.e.b(1001, str);
        if (this.f44306c) {
            d.a.h0.a.z0.f.V().x(new d.a.h0.a.k0.b.f(this.f44304a, bVar));
        } else {
            dVar.c(this.f44305b, bVar);
        }
    }
}
