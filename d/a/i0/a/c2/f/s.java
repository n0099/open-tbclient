package d.a.i0.a.c2.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.wallet.core.beans.BeanConstants;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.v2.q0;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class s extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f41092d;

    /* renamed from: c  reason: collision with root package name */
    public String f41093c;

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<d.a.i0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f41094e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f41095f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f41096g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f41097h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f41098i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, Context context, String str, String str2, String str3, String str4, String str5) {
            this.f41094e = callbackHandler;
            this.f41095f = context;
            this.f41096g = str;
            this.f41097h = str2;
            this.f41098i = str3;
            this.j = str4;
            this.k = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.i0.a.e2.c.i<b.e> iVar) {
            if (!d.a.i0.a.e2.c.d.h(iVar)) {
                d.a.i0.a.e2.c.d.p(iVar, this.f41094e, s.this.f41093c);
                return;
            }
            d.a.i0.a.q2.a a2 = d.a.i0.a.c1.a.B().a(this.f41095f, this.f41096g, this.f41097h, this.f41098i, this.j, this.k);
            if (a2 != null) {
                if (a2.g() != 0) {
                    d.a.i0.a.e0.d.b("PageTransitionAction", a2.f().toString());
                    CallbackHandler callbackHandler = this.f41094e;
                    String str = s.this.f41093c;
                    callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, a2.a() + ":" + a2.f().toString()).toString());
                    return;
                }
                d.a.i0.a.e0.d.b("PageTransitionAction", "page transition fail");
                this.f41094e.handleSchemeDispatchCallback(s.this.f41093c, UnitedSchemeUtility.wrapCallbackParams(1001, "execute fail").toString());
                return;
            }
            d.a.i0.a.e0.d.g("PageTransitionAction", "page transition success");
            this.f41094e.handleSchemeDispatchCallback(s.this.f41093c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f41092d = hashSet;
        hashSet.add("easybrowse");
        f41092d.add("live");
        f41092d.add("appTab");
        f41092d.add(BeanConstants.CHANNEL_ID_BROWSER);
        f41092d.add(AccountConstants.LOGIN_TYPE_NATIVE_SRC_COMIC);
        f41092d.add(AccountConstants.LOGIN_TYPE_NATIVE_SRC_NOVEL);
    }

    public s(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/pageTransition");
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        if (eVar == null) {
            d.a.i0.a.e0.d.b("PageTransitionAction", "runtime exception");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "null swanApp");
            return false;
        } else if (eVar.d0()) {
            if (a0.f40775b) {
                Log.d("PageTransitionAction", "PageTransitionAction does not supported when app is invisible.");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "this operation does not supported when app is invisible.");
            return false;
        } else {
            String param = unitedSchemeEntity.getParam("params");
            if (TextUtils.isEmpty(param)) {
                d.a.i0.a.e0.d.b("PageTransitionAction", "params is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
                return false;
            }
            JSONObject d2 = d.a.i0.a.v2.w.d(param);
            String optString = d2.optString("cb");
            this.f41093c = optString;
            if (TextUtils.isEmpty(optString)) {
                d.a.i0.a.e0.d.b("PageTransitionAction", "callback is null");
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
            }
            String optString2 = d2.optString("authority");
            String optString3 = d2.optString("path");
            String optString4 = d2.optString("module");
            String optString5 = d2.optString("action");
            String optString6 = d2.optString("scheme");
            k(eVar, optString4);
            if (d.a.i0.a.c1.a.A().a(d2)) {
                eVar.T().g(context, "mapp_i_baiduapp_page_trans", new a(callbackHandler, context, optString2, optString3, optString4, optString5, optString6));
            } else {
                d.a.i0.a.q2.a a2 = d.a.i0.a.c1.a.B().a(context, optString2, optString3, optString4, optString5, optString6);
                if (a2 != null) {
                    if (a2.g() != 0) {
                        d.a.i0.a.e0.d.b("PageTransitionAction", a2.f().toString());
                        String str = this.f41093c;
                        callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(1001, a2.a() + ":" + a2.f().toString()).toString());
                    } else {
                        d.a.i0.a.e0.d.b("PageTransitionAction", "page transition fail");
                        callbackHandler.handleSchemeDispatchCallback(this.f41093c, UnitedSchemeUtility.wrapCallbackParams(1001, "execute fail").toString());
                    }
                } else {
                    d.a.i0.a.e0.d.g("PageTransitionAction", "page transition success");
                    callbackHandler.handleSchemeDispatchCallback(this.f41093c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
                }
            }
            d.a.i0.a.e0.d.g("PageTransitionAction", "callback success");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }

    public final void k(@NonNull d.a.i0.a.a2.e eVar, @NonNull String str) {
        d.a.i0.a.j2.p.e eVar2 = new d.a.i0.a.j2.p.e();
        eVar2.f43013c = eVar.L().T();
        eVar2.f43011a = "swan";
        if (q0.G()) {
            if (f41092d.contains(str)) {
                eVar2.f43012b = str.toLowerCase();
            } else {
                eVar2.f43012b = "other";
            }
        } else {
            eVar2.f43012b = "other";
        }
        eVar2.a("hostid", d.a.i0.a.c1.a.m().a());
        eVar2.a("appid", eVar.getAppId());
        d.a.i0.a.j2.k.u("1895", eVar2);
    }
}
