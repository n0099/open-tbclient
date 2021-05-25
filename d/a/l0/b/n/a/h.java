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
        public final /* synthetic */ CallbackHandler f46350e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46351f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46352g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46353h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.a2.e f46354i;
        public final /* synthetic */ c.C0832c j;
        public final /* synthetic */ Bundle k;

        public a(CallbackHandler callbackHandler, String str, Context context, String str2, d.a.l0.a.a2.e eVar, c.C0832c c0832c, Bundle bundle) {
            this.f46350e = callbackHandler;
            this.f46351f = str;
            this.f46352g = context;
            this.f46353h = str2;
            this.f46354i = eVar;
            this.j = c0832c;
            this.k = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.l0.a.e2.c.d.h(iVar)) {
                if (h.this.o(this.f46352g, this.f46353h)) {
                    h.this.m(this.f46354i, (Activity) this.f46352g, this.j, this.f46350e, this.f46351f, this.k);
                    return;
                } else {
                    this.f46350e.handleSchemeDispatchCallback(this.f46351f, UnitedSchemeUtility.wrapCallbackParams(10008, "app not installed").toString());
                    return;
                }
            }
            d.a.l0.a.e2.c.d.p(iVar, this.f46350e, this.f46351f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<i<f.d>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.C0832c f46355e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f46356f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f46357g;

        public b(h hVar, c.C0832c c0832c, CallbackHandler callbackHandler, String str) {
            this.f46355e = c0832c;
            this.f46356f = callbackHandler;
            this.f46357g = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<f.d> iVar) {
            if (!iVar.c()) {
                d.a.l0.a.e0.d.l("ThirdPartyLoginAction", iVar.b() + " " + this.f46355e.toString());
                String f2 = d.a.l0.a.e2.c.d.f(iVar.b());
                if (!TextUtils.isEmpty(f2)) {
                    this.f46356f.handleSchemeDispatchCallback(this.f46357g, UnitedSchemeUtility.wrapCallbackParams(iVar.b(), f2).toString());
                } else {
                    this.f46356f.handleSchemeDispatchCallback(this.f46357g, UnitedSchemeUtility.wrapCallbackParams(iVar.b()).toString());
                }
            } else if (TextUtils.isEmpty(iVar.f41736a.f41754a)) {
                this.f46356f.handleSchemeDispatchCallback(this.f46357g, UnitedSchemeUtility.wrapCallbackParams(1001, "empty code").toString());
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", iVar.f41736a.f41754a);
                    this.f46356f.handleSchemeDispatchCallback(this.f46357g, UnitedSchemeUtility.wrapCallbackParams(jSONObject, iVar.b()).toString());
                } catch (JSONException e2) {
                    if (a0.f40949b) {
                        e2.printStackTrace();
                    }
                    this.f46356f.handleSchemeDispatchCallback(this.f46357g, UnitedSchemeUtility.wrapCallbackParams(1001, e2.getMessage()).toString());
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
        c.C0832c c0832c = new c.C0832c(optParamsAsJo);
        Bundle bundle = new Bundle();
        bundle.putInt("key_login_mode", n);
        eVar.T().g(context, "mapp_i_login", new a(callbackHandler, optString, context, optString2, eVar, c0832c, bundle));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final void m(d.a.l0.a.a2.e eVar, Activity activity, c.C0832c c0832c, CallbackHandler callbackHandler, String str, Bundle bundle) {
        eVar.T().r(activity, c0832c, bundle, new b(this, c0832c, callbackHandler, str), "SwanThirdPartLogin");
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
