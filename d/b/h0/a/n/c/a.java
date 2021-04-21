package d.b.h0.a.n.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.r1.e;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.c;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: d.b.h0.a.n.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0770a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45988e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45989f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45990g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f45991h;
        public final /* synthetic */ UnitedSchemeEntity i;

        public C0770a(CallbackHandler callbackHandler, String str, Context context, e eVar, UnitedSchemeEntity unitedSchemeEntity) {
            this.f45988e = callbackHandler;
            this.f45989f = str;
            this.f45990g = context;
            this.f45991h = eVar;
            this.i = unitedSchemeEntity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!c.h(hVar)) {
                c.o(hVar, this.f45988e, this.f45989f);
                return;
            }
            d.b.h0.a.c0.c.g("chooseInvoiceTitle", OAuthResult.RESULT_MSG_SUCCESS);
            Context context = this.f45990g;
            Context n = context instanceof Activity ? (Activity) context : this.f45991h.n();
            if (n != null) {
                a.this.k(n, this.f45988e, this.i, this.f45991h, this.f45989f);
            } else {
                UnitedSchemeUtility.safeCallback(this.f45988e, this.i, UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity").toString(), this.f45989f);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.n.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45992a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f45993b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45994c;

        public b(a aVar, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, String str) {
            this.f45992a = callbackHandler;
            this.f45993b = unitedSchemeEntity;
            this.f45994c = str;
        }

        @Override // d.b.h0.a.n.c.b
        public void a(int i) {
            String jSONObject;
            if (i == 1) {
                d.b.h0.a.c0.c.g("chooseInvoiceTitle", "choose invoice cancel");
                jSONObject = UnitedSchemeUtility.wrapCallbackParams(1002, "choose invoice cancel").toString();
            } else {
                d.b.h0.a.c0.c.g("chooseInvoiceTitle", "choose invoice failed");
                jSONObject = UnitedSchemeUtility.wrapCallbackParams(1003, "choose invoice failed").toString();
            }
            UnitedSchemeUtility.safeCallback(this.f45992a, this.f45993b, jSONObject, this.f45994c);
        }

        @Override // d.b.h0.a.n.c.b
        public void b(JSONObject jSONObject) {
            d.b.h0.a.c0.c.g("chooseInvoiceTitle", "choose success");
            UnitedSchemeUtility.safeCallback(this.f45992a, this.f45993b, UnitedSchemeUtility.wrapCallbackParamsWithEncode(jSONObject, 0).toString(), this.f45994c);
        }
    }

    public a(j jVar) {
        super(jVar, "/swanAPI/chooseInvoiceTitle");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, e eVar) {
        d.b.h0.a.c0.c.g("chooseInvoiceTitle", "发票调起");
        if (eVar == null) {
            d.b.h0.a.c0.c.b("chooseInvoiceTitle", "empty swanApp");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        } else if (eVar.Z()) {
            if (a0.f47009b) {
                Log.d("SwanAppAction", "SwanAppAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
            if (optParamsAsJo == null) {
                d.b.h0.a.c0.c.b("chooseInvoiceTitle", "empty joParams");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
                return false;
            }
            String optString = optParamsAsJo.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.b.h0.a.c0.c.b("chooseInvoiceTitle", "empty cb");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
                return false;
            }
            eVar.R().h(context, "mapp_choose_invoice", c.i(optParamsAsJo), new C0770a(callbackHandler, optString, context, eVar, unitedSchemeEntity));
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void k(Context context, CallbackHandler callbackHandler, UnitedSchemeEntity unitedSchemeEntity, e eVar, String str) {
        d.b.h0.a.w0.a.R().a(context, eVar.f46461f, eVar.B(), new b(this, callbackHandler, unitedSchemeEntity, str));
    }
}
