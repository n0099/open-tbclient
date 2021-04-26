package d.a.h0.b.m.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.i2.k0;
import d.a.h0.a.t.c.a.b;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.i.b;
import d.a.h0.a.v1.c.i.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45555e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45556f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f45557g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45558h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.r1.e f45559i;
        public final /* synthetic */ b.c j;
        public final /* synthetic */ Bundle k;

        public a(CallbackHandler callbackHandler, String str, Context context, String str2, d.a.h0.a.r1.e eVar, b.c cVar, Bundle bundle) {
            this.f45555e = callbackHandler;
            this.f45556f = str;
            this.f45557g = context;
            this.f45558h = str2;
            this.f45559i = eVar;
            this.j = cVar;
            this.k = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            if (d.a.h0.a.v1.c.c.h(hVar)) {
                if (i.this.o(this.f45557g, this.f45558h)) {
                    i.this.m(this.f45559i, (Activity) this.f45557g, this.j, this.f45555e, this.f45556f, this.k);
                    return;
                } else {
                    this.f45555e.handleSchemeDispatchCallback(this.f45556f, UnitedSchemeUtility.wrapCallbackParams(10008, "app not installed").toString());
                    return;
                }
            }
            d.a.h0.a.v1.c.c.o(hVar, this.f45555e, this.f45556f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<f.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f45560e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45561f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45562g;

        public b(i iVar, b.c cVar, CallbackHandler callbackHandler, String str) {
            this.f45560e = cVar;
            this.f45561f = callbackHandler;
            this.f45562g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<f.d> hVar) {
            if (!hVar.c()) {
                d.a.h0.a.c0.c.l("ThirdPartyLoginAction", hVar.b() + " " + this.f45560e.toString());
                String f2 = d.a.h0.a.v1.c.c.f(hVar.b());
                if (!TextUtils.isEmpty(f2)) {
                    this.f45561f.handleSchemeDispatchCallback(this.f45562g, UnitedSchemeUtility.wrapCallbackParams(hVar.b(), f2).toString());
                } else {
                    this.f45561f.handleSchemeDispatchCallback(this.f45562g, UnitedSchemeUtility.wrapCallbackParams(hVar.b()).toString());
                }
            } else if (TextUtils.isEmpty(hVar.f44952a.f44970a)) {
                this.f45561f.handleSchemeDispatchCallback(this.f45562g, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", hVar.f44952a.f44970a);
                    this.f45561f.handleSchemeDispatchCallback(this.f45562g, UnitedSchemeUtility.wrapCallbackParams(jSONObject, hVar.b()).toString());
                } catch (JSONException e2) {
                    if (a0.f44398b) {
                        e2.printStackTrace();
                    }
                    this.f45561f.handleSchemeDispatchCallback(this.f45562g, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                }
            }
        }
    }

    public i(j jVar) {
        super(jVar, "/swanAPI/thirdPartyLogin");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
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

    public final void m(d.a.h0.a.r1.e eVar, Activity activity, b.c cVar, CallbackHandler callbackHandler, String str, Bundle bundle) {
        eVar.R().q(activity, cVar, bundle, new b(this, cVar, callbackHandler, str));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int n(String str) {
        char c2;
        switch (str.hashCode()) {
            case -791575966:
                if (str.equals(ThirdPartyUtil.TYPE_WEIXIN)) {
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
                if (str.equals(ThirdPartyUtil.TYPE_WEIXIN)) {
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
