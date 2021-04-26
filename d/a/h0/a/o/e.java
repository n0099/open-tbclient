package d.a.h0.a.o;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public d.a.h0.a.o.b f43476c;

    /* loaded from: classes.dex */
    public class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final UnitedSchemeEntity f43477a;

        public a(e eVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
            this.f43477a = unitedSchemeEntity;
        }
    }

    /* loaded from: classes.dex */
    public class b implements d {
        public b(e eVar, CallbackHandler callbackHandler, String str) {
        }
    }

    public e(j jVar) {
        super(jVar, "/swanAPI/rewardedVideoAd");
        this.f43476c = null;
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (a0.f44398b) {
            Log.d("SwanAppAction", "handle entity: " + unitedSchemeEntity.toString());
        }
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        String optString = a2.optString("cb");
        String optString2 = a2.optString("action");
        b bVar = new b(this, callbackHandler, optString);
        a aVar = new a(this, unitedSchemeEntity, callbackHandler);
        if (this.f43476c == null) {
            d.a.h0.a.o.b a3 = d.a.h0.a.w0.a.b().a(a2, bVar, aVar);
            this.f43476c = a3;
            if (a3 == null) {
                this.f43476c = new d.a.h0.a.o.a();
            }
        }
        if (TextUtils.equals(optString2, "show")) {
            this.f43476c.a(a2, aVar);
            return true;
        } else if (TextUtils.equals(optString2, "load")) {
            this.f43476c.b(a2, aVar, bVar);
            return true;
        } else {
            return true;
        }
    }
}
