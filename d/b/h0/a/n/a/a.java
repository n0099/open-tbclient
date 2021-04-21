package d.b.h0.a.n.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.c;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public String f45959c;

    /* renamed from: d.b.h0.a.n.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0766a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45960e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f45961f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45962g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f45963h;

        public C0766a(CallbackHandler callbackHandler, Context context, UnitedSchemeEntity unitedSchemeEntity, e eVar) {
            this.f45960e = callbackHandler;
            this.f45961f = context;
            this.f45962g = unitedSchemeEntity;
            this.f45963h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!c.h(hVar)) {
                c.o(hVar, this.f45960e, a.this.f45959c);
            } else {
                a.this.l(this.f45961f, this.f45962g, this.f45960e, this.f45963h);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.n.a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45964a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45965b;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f45964a = callbackHandler;
            this.f45965b = unitedSchemeEntity;
        }

        @Override // d.b.h0.a.n.a.b
        public void a(int i) {
            if (i == 1) {
                UnitedSchemeUtility.safeCallback(this.f45964a, this.f45965b, UnitedSchemeUtility.wrapCallbackParams(1002, "user cancel this operation").toString(), a.this.f45959c);
            } else {
                UnitedSchemeUtility.safeCallback(this.f45964a, this.f45965b, UnitedSchemeUtility.wrapCallbackParams(1003, "close failed").toString(), a.this.f45959c);
            }
        }

        @Override // d.b.h0.a.n.a.b
        public void b(JSONObject jSONObject) {
            UnitedSchemeUtility.safeCallback(this.f45964a, this.f45965b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), a.this.f45959c);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/chooseAddress");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.b.h0.a.c0.c.g("ChooseAddress", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        } else if (eVar.Z()) {
            if (a0.f47009b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject m = m(unitedSchemeEntity.getParam("params"));
            String optString = m.optString("cb");
            this.f45959c = optString;
            if (TextUtils.isEmpty(optString)) {
                d.b.h0.a.c0.c.g("ChooseAddress", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            eVar.R().h(context, "mapp_choose_address", c.i(m), new C0766a(callbackHandler, context, unitedSchemeEntity, eVar));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        d.b.h0.a.w0.a.Q().a(context, eVar.f46461f, eVar.B(), new b(callbackHandler, unitedSchemeEntity));
    }

    public final JSONObject m(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            if (a0.f47009b) {
                Log.w("SwanAppAction", "JSONObject parsed error!!", e2);
            }
            return new JSONObject();
        }
    }
}
