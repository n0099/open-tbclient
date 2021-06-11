package d.a.l0.a.n.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.a2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.d;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.j2.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public String f47201c;

    /* renamed from: d.a.l0.a.n.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0806a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f47202e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f47203f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f47204g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47205h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47206i;
        public final /* synthetic */ UnitedSchemeEntity j;

        public C0806a(e eVar, Context context, boolean z, String str, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f47202e = eVar;
            this.f47203f = context;
            this.f47204g = z;
            this.f47205h = str;
            this.f47206i = callbackHandler;
            this.j = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            boolean e2 = this.f47202e.j().e(this.f47203f);
            if (!d.h(iVar)) {
                if (!e2 && !this.f47204g) {
                    k.M(com.baidu.pass.biometrics.face.liveness.b.b.g0, 4, this.f47205h);
                }
                d.p(iVar, this.f47206i, a.this.f47201c);
                return;
            }
            if (e2 && !this.f47204g) {
                k.M("success", 4, this.f47205h);
            }
            a.this.l(this.f47203f, this.j, this.f47206i, this.f47202e, this.f47205h);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.l0.a.n.a.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47207a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47208b;

        public b(CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity) {
            this.f47207a = callbackHandler;
            this.f47208b = unitedSchemeEntity;
        }

        @Override // d.a.l0.a.n.a.b
        public void a(int i2) {
            if (i2 == 1) {
                UnitedSchemeUtility.safeCallback(this.f47207a, this.f47208b, UnitedSchemeUtility.wrapCallbackParams(1002, "user cancel this operation").toString(), a.this.f47201c);
            } else {
                UnitedSchemeUtility.safeCallback(this.f47207a, this.f47208b, UnitedSchemeUtility.wrapCallbackParams(1003, "close failed").toString(), a.this.f47201c);
            }
        }

        @Override // d.a.l0.a.n.a.b
        public void b(JSONObject jSONObject) {
            UnitedSchemeUtility.safeCallback(this.f47207a, this.f47208b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), a.this.f47201c);
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseAddress");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        if (eVar == null) {
            d.a.l0.a.e0.d.g("ChooseAddress", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        } else if (eVar.d0()) {
            if (a0.f44625b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject m = m(unitedSchemeEntity.getParam("params"));
            String optString = m.optString("cb");
            this.f47201c = optString;
            if (TextUtils.isEmpty(optString)) {
                d.a.l0.a.e0.d.g("ChooseAddress", "cb is empty");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                return false;
            }
            String optString2 = m.optString("invokeFrom");
            boolean e2 = eVar.j().e(context);
            if (!e2) {
                k.M("show", 4, optString2);
            }
            eVar.T().h(context, "mapp_choose_address", d.i(m), new C0806a(eVar, context, e2, optString2, callbackHandler, unitedSchemeEntity));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar, String str) {
        d.a.l0.a.c1.a.c0().a(context, eVar.f44425f, eVar.D(), new b(callbackHandler, unitedSchemeEntity));
    }

    public final JSONObject m(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e2) {
            if (a0.f44625b) {
                Log.w("SwanAppAction", "JSONObject parsed error!!", e2);
            }
            return new JSONObject();
        }
    }
}
