package d.a.m0.a.c2.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.wallet.core.beans.BeanConstants;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.v2.q0;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class s extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f45050d;

    /* renamed from: c  reason: collision with root package name */
    public String f45051c;

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<d.a.m0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f45052e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f45053f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f45054g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45055h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f45056i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, Context context, String str, String str2, String str3, String str4, String str5) {
            this.f45052e = callbackHandler;
            this.f45053f = context;
            this.f45054g = str;
            this.f45055h = str2;
            this.f45056i = str3;
            this.j = str4;
            this.k = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.m0.a.e2.c.i<b.e> iVar) {
            if (!d.a.m0.a.e2.c.d.h(iVar)) {
                d.a.m0.a.e2.c.d.p(iVar, this.f45052e, s.this.f45051c);
                return;
            }
            d.a.m0.a.q2.a a2 = d.a.m0.a.c1.a.B().a(this.f45053f, this.f45054g, this.f45055h, this.f45056i, this.j, this.k);
            if (a2 != null) {
                if (a2.g() != 0) {
                    d.a.m0.a.e0.d.b("PageTransitionAction", a2.f().toString());
                    CallbackHandler callbackHandler = this.f45052e;
                    String str = s.this.f45051c;
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, a2.a() + ":" + a2.f().toString()).toString());
                    return;
                }
                d.a.m0.a.e0.d.b("PageTransitionAction", "page transition fail");
                this.f45052e.handleSchemeDispatchCallback(s.this.f45051c, UnitedSchemeUtility.wrapCallbackParams(1001, "execute fail").toString());
                return;
            }
            d.a.m0.a.e0.d.g("PageTransitionAction", "page transition success");
            this.f45052e.handleSchemeDispatchCallback(s.this.f45051c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f45050d = hashSet;
        hashSet.add("easybrowse");
        f45050d.add("live");
        f45050d.add("appTab");
        f45050d.add(BeanConstants.CHANNEL_ID_BROWSER);
        f45050d.add(AccountConstants.LOGIN_TYPE_NATIVE_SRC_COMIC);
        f45050d.add(AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL);
    }

    public s(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/pageTransition");
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.m0.a.e0.d.b("PageTransitionAction", "runtime exception");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "null swanApp");
            return false;
        } else if (eVar.d0()) {
            if (a0.f44733b) {
                Log.d("PageTransitionAction", "PageTransitionAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                d.a.m0.a.e0.d.b("PageTransitionAction", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                return false;
            }
            JSONObject d2 = d.a.m0.a.v2.w.d(param);
            String optString = d2.optString("cb");
            this.f45051c = optString;
            if (TextUtils.isEmpty(optString)) {
                d.a.m0.a.e0.d.b("PageTransitionAction", "callback is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString2 = d2.optString("authority");
            String optString3 = d2.optString("path");
            String optString4 = d2.optString("module");
            String optString5 = d2.optString("action");
            String optString6 = d2.optString("scheme");
            k(eVar, optString4);
            if (d.a.m0.a.c1.a.A().a(d2)) {
                eVar.T().g(context, "mapp_i_baiduapp_page_trans", new a(callbackHandler, context, optString2, optString3, optString4, optString5, optString6));
            } else {
                d.a.m0.a.q2.a a2 = d.a.m0.a.c1.a.B().a(context, optString2, optString3, optString4, optString5, optString6);
                if (a2 != null) {
                    if (a2.g() != 0) {
                        d.a.m0.a.e0.d.b("PageTransitionAction", a2.f().toString());
                        String str = this.f45051c;
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, a2.a() + ":" + a2.f().toString()).toString());
                    } else {
                        d.a.m0.a.e0.d.b("PageTransitionAction", "page transition fail");
                        callbackHandler.handleSchemeDispatchCallback(this.f45051c, UnitedSchemeUtility.wrapCallbackParams(1001, "execute fail").toString());
                    }
                } else {
                    d.a.m0.a.e0.d.g("PageTransitionAction", "page transition success");
                    callbackHandler.handleSchemeDispatchCallback(this.f45051c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            }
            d.a.m0.a.e0.d.g("PageTransitionAction", "callback success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void k(@NonNull d.a.m0.a.a2.e eVar, @NonNull String str) {
        d.a.m0.a.j2.p.e eVar2 = new d.a.m0.a.j2.p.e();
        eVar2.f46971c = eVar.L().T();
        eVar2.f46969a = "swan";
        if (q0.G()) {
            if (f45050d.contains(str)) {
                eVar2.f46970b = str.toLowerCase();
            } else {
                eVar2.f46970b = "other";
            }
        } else {
            eVar2.f46970b = "other";
        }
        eVar2.a(BaseHiidoContent.HOSTID, d.a.m0.a.c1.a.m().a());
        eVar2.a("appid", eVar.getAppId());
        d.a.m0.a.j2.k.u("1895", eVar2);
    }
}
