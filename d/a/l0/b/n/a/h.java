package d.a.l0.b.n.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.e2.c.i;
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.e2.c.j.f;
import d.a.l0.a.u.e.a.c;
import d.a.l0.a.v2.q0;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements d.a.l0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50024e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50025f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f50026g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f50027h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f50028i;
        public final /* synthetic */ c.C0888c j;
        public final /* synthetic */ Bundle k;

        public a(CallbackHandler callbackHandler, String str, Context context, String str2, d.a.l0.a.a2.e eVar, c.C0888c c0888c, Bundle bundle) {
            this.f50024e = callbackHandler;
            this.f50025f = str;
            this.f50026g = context;
            this.f50027h = str2;
            this.f50028i = eVar;
            this.j = c0888c;
            this.k = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                if (h.this.o(this.f50026g, this.f50027h)) {
                    h.this.m(this.f50028i, (Activity) this.f50026g, this.j, this.f50024e, this.f50025f, this.k);
                    return;
                } else {
                    this.f50024e.handleSchemeDispatchCallback(this.f50025f, UnitedSchemeUtility.wrapCallbackParams(10008, "app not installed").toString());
                    return;
                }
            }
            d.a.l0.a.e2.c.d.p(iVar, this.f50024e, this.f50025f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<i<f.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.C0888c f50029e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f50030f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50031g;

        public b(h hVar, c.C0888c c0888c, CallbackHandler callbackHandler, String str) {
            this.f50029e = c0888c;
            this.f50030f = callbackHandler;
            this.f50031g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            if (!iVar.c()) {
                d.a.l0.a.e0.d.l("ThirdPartyLoginAction", iVar.b() + " " + this.f50029e.toString());
                String f2 = d.a.l0.a.e2.c.d.f(iVar.b());
                if (!TextUtils.isEmpty(f2)) {
                    this.f50030f.handleSchemeDispatchCallback(this.f50031g, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), f2).toString());
                } else {
                    this.f50030f.handleSchemeDispatchCallback(this.f50031g, UnitedSchemeUtility.wrapCallbackParams(iVar.b()).toString());
                }
            } else if (TextUtils.isEmpty(iVar.f45412a.f45430a)) {
                this.f50030f.handleSchemeDispatchCallback(this.f50031g, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", iVar.f45412a.f45430a);
                    this.f50030f.handleSchemeDispatchCallback(this.f50031g, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
                } catch (JSONException e2) {
                    if (a0.f44625b) {
                        e2.printStackTrace();
                    }
                    this.f50030f.handleSchemeDispatchCallback(this.f50031g, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
                }
            }
        }
    }

    public h(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/thirdPartyLogin");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
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
        c.C0888c c0888c = new c.C0888c(optParamsAsJo);
        Bundle bundle = new Bundle();
        bundle.putInt("key_login_mode", n);
        eVar.T().g(context, "mapp_i_login", new a(callbackHandler, optString, context, optString2, eVar, c0888c, bundle));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void m(d.a.l0.a.a2.e eVar, Activity activity, c.C0888c c0888c, CallbackHandler callbackHandler, String str, Bundle bundle) {
        eVar.T().r(activity, c0888c, bundle, new b(this, c0888c, callbackHandler, str), "SwanThirdPartLogin");
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
                return q0.F(context, "com.sina.weibo");
            }
            return q0.F(context, "com.tencent.mobileqq");
        }
        return q0.F(context, "com.tencent.mm");
    }
}
