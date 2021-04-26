package d.a.h0.a.n.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.r1.e;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.c;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends a0 {

    /* renamed from: d.a.h0.a.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0709a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43328e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43329f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f43330g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f43331h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43332i;

        public C0709a(CallbackHandler callbackHandler, String str, Context context, e eVar, UnitedSchemeEntity unitedSchemeEntity) {
            this.f43328e = callbackHandler;
            this.f43329f = str;
            this.f43330g = context;
            this.f43331h = eVar;
            this.f43332i = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!c.h(hVar)) {
                c.o(hVar, this.f43328e, this.f43329f);
                return;
            }
            d.a.h0.a.c0.c.g("chooseInvoiceTitle", OAuthResult.RESULT_MSG_SUCCESS);
            Context context = this.f43330g;
            Context v = context instanceof Activity ? (Activity) context : this.f43331h.v();
            if (v != null) {
                a.this.k(v, this.f43328e, this.f43332i, this.f43331h, this.f43329f);
            } else {
                UnitedSchemeUtility.safeCallback(this.f43328e, this.f43332i, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString(), this.f43329f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a.h0.a.n.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f43333a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f43334b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43335c;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f43333a = callbackHandler;
            this.f43334b = unitedSchemeEntity;
            this.f43335c = str;
        }

        @Override // d.a.h0.a.n.c.b
        public void a(int i2) {
            String jSONObject;
            if (i2 == 1) {
                d.a.h0.a.c0.c.g("chooseInvoiceTitle", "choose invoice cancel");
                jSONObject = UnitedSchemeUtility.wrapCallbackParams(1002, "choose invoice cancel").toString();
            } else {
                d.a.h0.a.c0.c.g("chooseInvoiceTitle", "choose invoice failed");
                jSONObject = UnitedSchemeUtility.wrapCallbackParams(1003, "choose invoice failed").toString();
            }
            UnitedSchemeUtility.safeCallback(this.f43333a, this.f43334b, jSONObject, this.f43335c);
        }

        @Override // d.a.h0.a.n.c.b
        public void b(JSONObject jSONObject) {
            d.a.h0.a.c0.c.g("chooseInvoiceTitle", "choose success");
            UnitedSchemeUtility.safeCallback(this.f43333a, this.f43334b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f43335c);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/chooseInvoiceTitle");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        d.a.h0.a.c0.c.g("chooseInvoiceTitle", "发票调起");
        if (eVar == null) {
            d.a.h0.a.c0.c.b("chooseInvoiceTitle", "empty swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (eVar.Z()) {
            if (a0.f44398b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.a.h0.a.c0.c.b("chooseInvoiceTitle", "empty joParams");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.h0.a.c0.c.b("chooseInvoiceTitle", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            eVar.R().h(context, "mapp_choose_invoice", c.i(optParamsAsJo), new C0709a(callbackHandler, optString, context, eVar, unitedSchemeEntity));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void k(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar, String str) {
        d.a.h0.a.w0.a.R().a(context, eVar.f43823f, eVar.B(), new b(this, callbackHandler, unitedSchemeEntity, str));
    }
}
