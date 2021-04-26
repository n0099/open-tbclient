package d.a.h0.a.n.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.c;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public String f43297c;

    /* renamed from: d.a.h0.a.n.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0705a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43298e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f43299f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43300g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f43301h;

        public C0705a(CallbackHandler callbackHandler, Context context, UnitedSchemeEntity unitedSchemeEntity, e eVar) {
            this.f43298e = callbackHandler;
            this.f43299f = context;
            this.f43300g = unitedSchemeEntity;
            this.f43301h = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!c.h(hVar)) {
                c.o(hVar, this.f43298e, a.this.f43297c);
            } else {
                a.this.l(this.f43299f, this.f43300g, this.f43298e, this.f43301h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a.h0.a.n.a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43303a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43304b;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f43303a = callbackHandler;
            this.f43304b = unitedSchemeEntity;
        }

        @Override // d.a.h0.a.n.a.b
        public void a(int i2) {
            if (i2 == 1) {
                UnitedSchemeUtility.safeCallback(this.f43303a, this.f43304b, UnitedSchemeUtility.wrapCallbackParams(1002, "user cancel this operation").toString(), a.this.f43297c);
            } else {
                UnitedSchemeUtility.safeCallback(this.f43303a, this.f43304b, UnitedSchemeUtility.wrapCallbackParams(1003, "close failed").toString(), a.this.f43297c);
            }
        }

        @Override // d.a.h0.a.n.a.b
        public void b(JSONObject jSONObject) {
            UnitedSchemeUtility.safeCallback(this.f43303a, this.f43304b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), a.this.f43297c);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/chooseAddress");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.a.h0.a.c0.c.g("ChooseAddress", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        } else if (eVar.Z()) {
            if (a0.f44398b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject m = m(unitedSchemeEntity.getParam("params"));
            String optString = m.optString("cb");
            this.f43297c = optString;
            if (TextUtils.isEmpty(optString)) {
                d.a.h0.a.c0.c.g("ChooseAddress", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            eVar.R().h(context, "mapp_choose_address", c.i(m), new C0705a(callbackHandler, context, unitedSchemeEntity, eVar));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        d.a.h0.a.w0.a.Q().a(context, eVar.f43823f, eVar.B(), new b(callbackHandler, unitedSchemeEntity));
    }

    public final JSONObject m(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            if (a0.f44398b) {
                Log.w("SwanAppAction", "JSONObject parsed error!!", e2);
            }
            return new JSONObject();
        }
    }
}
