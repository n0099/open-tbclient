package d.b.h0.b.m.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.utils.l;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.b.h0.a.i2.k0;
import d.b.h0.a.t.c.a.b;
import d.b.h0.a.t1.j;
import d.b.h0.a.t1.k.a0;
import d.b.h0.a.v1.c.i.b;
import d.b.h0.a.v1.c.i.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48111e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48112f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f48113g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48114h;
        public final /* synthetic */ d.b.h0.a.r1.e i;
        public final /* synthetic */ b.c j;
        public final /* synthetic */ Bundle k;

        public a(CallbackHandler callbackHandler, String str, Context context, String str2, d.b.h0.a.r1.e eVar, b.c cVar, Bundle bundle) {
            this.f48111e = callbackHandler;
            this.f48112f = str;
            this.f48113g = context;
            this.f48114h = str2;
            this.i = eVar;
            this.j = cVar;
            this.k = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            if (d.b.h0.a.v1.c.c.h(hVar)) {
                if (i.this.o(this.f48113g, this.f48114h)) {
                    i.this.m(this.i, (Activity) this.f48113g, this.j, this.f48111e, this.f48112f, this.k);
                    return;
                } else {
                    this.f48111e.handleSchemeDispatchCallback(this.f48112f, UnitedSchemeUtility.wrapCallbackParams(10008, "app not installed").toString());
                    return;
                }
            }
            d.b.h0.a.v1.c.c.o(hVar, this.f48111e, this.f48112f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<f.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f48115e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f48116f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48117g;

        public b(i iVar, b.c cVar, CallbackHandler callbackHandler, String str) {
            this.f48115e = cVar;
            this.f48116f = callbackHandler;
            this.f48117g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<f.d> hVar) {
            if (!hVar.c()) {
                d.b.h0.a.c0.c.l("ThirdPartyLoginAction", hVar.b() + " " + this.f48115e.toString());
                String f2 = d.b.h0.a.v1.c.c.f(hVar.b());
                if (!TextUtils.isEmpty(f2)) {
                    this.f48116f.handleSchemeDispatchCallback(this.f48117g, UnitedSchemeUtility.wrapCallbackParams(hVar.b(), f2).toString());
                } else {
                    this.f48116f.handleSchemeDispatchCallback(this.f48117g, UnitedSchemeUtility.wrapCallbackParams(hVar.b()).toString());
                }
            } else if (TextUtils.isEmpty(hVar.f47529a.f47547a)) {
                this.f48116f.handleSchemeDispatchCallback(this.f48117g, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", hVar.f47529a.f47547a);
                    this.f48116f.handleSchemeDispatchCallback(this.f48117g, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.b()).toString());
                } catch (JSONException e2) {
                    if (a0.f47009b) {
                        e2.printStackTrace();
                    }
                    this.f48116f.handleSchemeDispatchCallback(this.f48117g, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                }
            }
        }
    }

    public i(j jVar) {
        super(jVar, "/swanAPI/thirdPartyLogin");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "empty swanApp");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        }
        String optString2 = optParamsAsJo.optString("type", "");
        int n = n(optString2);
        b.c cVar = new b.c(optParamsAsJo);
        Bundle bundle = new Bundle();
        bundle.putInt("key_login_mode", n);
        eVar.R().g(context, "mapp_i_login", new a(callbackHandler, optString, context, optString2, eVar, cVar, bundle));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void m(d.b.h0.a.r1.e eVar, Activity activity, b.c cVar, CallbackHandler callbackHandler, String str, Bundle bundle) {
        eVar.R().q(activity, cVar, bundle, new b(this, cVar, callbackHandler, str));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int n(String str) {
        char c2;
        switch (str.hashCode()) {
            case -791575966:
                if (str.equals(l.f11112a)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -265713450:
                if (str.equals("username")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 3616:
                if (str.equals(LoginConstants.QQ_LOGIN)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 114009:
                if (str.equals("sms")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 113011944:
                if (str.equals("weibo")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 == 2) {
                    return 2;
                }
                if (c2 == 3) {
                    return 3;
                }
                if (c2 == 4) {
                    return 4;
                }
            }
            return 1;
        }
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean o(Context context, String str) {
        char c2;
        switch (str.hashCode()) {
            case -791575966:
                if (str.equals(l.f11112a)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -265713450:
                if (str.equals("username")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 3616:
                if (str.equals(LoginConstants.QQ_LOGIN)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 114009:
                if (str.equals("sms")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 113011944:
                if (str.equals("weibo")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 != 2) {
                    return c2 == 3 || c2 == 4;
                }
                return k0.C(context, "com.sina.weibo");
            }
            return k0.C(context, "com.tencent.mobileqq");
        }
        return k0.C(context, "com.tencent.mm");
    }
}
