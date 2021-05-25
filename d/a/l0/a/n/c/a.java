package d.a.l0.a.n.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.a2.e;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.d;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.j2.k;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.a.l0.a.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0757a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f43568e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f43569f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f43570g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43571h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43572i;
        public final /* synthetic */ String j;
        public final /* synthetic */ UnitedSchemeEntity k;

        public C0757a(e eVar, Context context, boolean z, String str, CallbackHandler callbackHandler, String str2, UnitedSchemeEntity unitedSchemeEntity) {
            this.f43568e = eVar;
            this.f43569f = context;
            this.f43570g = z;
            this.f43571h = str;
            this.f43572i = callbackHandler;
            this.j = str2;
            this.k = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            boolean e2 = this.f43568e.j().e(this.f43569f);
            if (!d.h(iVar)) {
                if (!e2 && !this.f43570g) {
                    k.M("fail", 5, this.f43571h);
                }
                d.p(iVar, this.f43572i, this.j);
                return;
            }
            d.a.l0.a.e0.d.g("chooseInvoiceTitle", OAuthResult.RESULT_MSG_SUCCESS);
            Context context = this.f43569f;
            Context x = context instanceof Activity ? (Activity) context : this.f43568e.x();
            if (x == null) {
                UnitedSchemeUtility.safeCallback(this.f43572i, this.k, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString(), this.j);
                return;
            }
            if (e2 && !this.f43570g) {
                k.M("success", 5, this.f43571h);
            }
            a.this.k(x, this.f43572i, this.k, this.f43568e, this.j, this.f43571h);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.l0.a.n.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43573a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43574b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43575c;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f43573a = callbackHandler;
            this.f43574b = unitedSchemeEntity;
            this.f43575c = str;
        }

        @Override // d.a.l0.a.n.c.b
        public void a(int i2) {
            String jSONObject;
            if (i2 == 1) {
                d.a.l0.a.e0.d.g("chooseInvoiceTitle", "choose invoice cancel");
                jSONObject = UnitedSchemeUtility.wrapCallbackParams(1002, "choose invoice cancel").toString();
            } else {
                d.a.l0.a.e0.d.g("chooseInvoiceTitle", "choose invoice failed");
                jSONObject = UnitedSchemeUtility.wrapCallbackParams(1003, "choose invoice failed").toString();
            }
            UnitedSchemeUtility.safeCallback(this.f43573a, this.f43574b, jSONObject, this.f43575c);
        }

        @Override // d.a.l0.a.n.c.b
        public void b(JSONObject jSONObject) {
            d.a.l0.a.e0.d.g("chooseInvoiceTitle", "choose success");
            UnitedSchemeUtility.safeCallback(this.f43573a, this.f43574b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f43575c);
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/chooseInvoiceTitle");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        d.a.l0.a.e0.d.g("chooseInvoiceTitle", "发票调起");
        if (eVar == null) {
            d.a.l0.a.e0.d.b("chooseInvoiceTitle", "empty swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (eVar.d0()) {
            if (a0.f40949b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.l0.a.e0.d.b("chooseInvoiceTitle", "empty joParams");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.l0.a.e0.d.b("chooseInvoiceTitle", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            String optString2 = optParamsAsJo.optString("invokeFrom");
            boolean e2 = eVar.j().e(context);
            if (!e2) {
                k.M("show", 5, optString2);
            }
            eVar.T().h(context, "mapp_choose_invoice", d.i(optParamsAsJo), new C0757a(eVar, context, e2, optString2, callbackHandler, optString, unitedSchemeEntity));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void k(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar, String str, String str2) {
        d.a.l0.a.c1.a.d0().a(context, eVar.f40749f, eVar.D(), new b(this, callbackHandler, unitedSchemeEntity, str));
    }
}
