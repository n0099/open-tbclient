package d.b.g0.a.n.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.g0.a.r1.e;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.c;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public String f45238c;

    /* renamed from: d.b.g0.a.n.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0734a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45239e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f45240f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45241g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f45242h;

        public C0734a(CallbackHandler callbackHandler, Context context, UnitedSchemeEntity unitedSchemeEntity, e eVar) {
            this.f45239e = callbackHandler;
            this.f45240f = context;
            this.f45241g = unitedSchemeEntity;
            this.f45242h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!c.h(hVar)) {
                c.o(hVar, this.f45239e, a.this.f45238c);
            } else {
                a.this.l(this.f45240f, this.f45241g, this.f45239e, this.f45242h);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.g0.a.n.a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45243a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45244b;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f45243a = callbackHandler;
            this.f45244b = unitedSchemeEntity;
        }

        @Override // d.b.g0.a.n.a.b
        public void a(int i) {
            if (i == 1) {
                UnitedSchemeUtility.safeCallback(this.f45243a, this.f45244b, UnitedSchemeUtility.wrapCallbackParams(1002, "user cancel this operation").toString(), a.this.f45238c);
            } else {
                UnitedSchemeUtility.safeCallback(this.f45243a, this.f45244b, UnitedSchemeUtility.wrapCallbackParams(1003, "close failed").toString(), a.this.f45238c);
            }
        }

        @Override // d.b.g0.a.n.a.b
        public void b(JSONObject jSONObject) {
            UnitedSchemeUtility.safeCallback(this.f45243a, this.f45244b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), a.this.f45238c);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/chooseAddress");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.b.g0.a.c0.c.g("ChooseAddress", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        } else if (eVar.Z()) {
            if (a0.f46288b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject m = m(unitedSchemeEntity.getParam("params"));
            String optString = m.optString("cb");
            this.f45238c = optString;
            if (TextUtils.isEmpty(optString)) {
                d.b.g0.a.c0.c.g("ChooseAddress", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            eVar.R().h(context, "mapp_choose_address", c.i(m), new C0734a(callbackHandler, context, unitedSchemeEntity, eVar));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        d.b.g0.a.w0.a.Q().a(context, eVar.f45740f, eVar.B(), new b(callbackHandler, unitedSchemeEntity));
    }

    public final JSONObject m(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            if (a0.f46288b) {
                Log.w("SwanAppAction", "JSONObject parsed error!!", e2);
            }
            return new JSONObject();
        }
    }
}
