package d.a.j0.s.b.l;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.lbspay.BuildConfig;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import d.a.h0.a.i2.v;
import d.a.h0.a.t1.j;
import d.a.h0.a.t1.k.a0;
import d.a.h0.a.v1.c.h;
import d.a.h0.a.v1.c.i.b;
import d.a.i0.a.f;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static String f59981d = "com.baidu.tieba://";

    /* renamed from: c  reason: collision with root package name */
    public String f59982c;

    /* loaded from: classes4.dex */
    public class a implements d.a.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f59983e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f59984f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f59985g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f59986h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f59987i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, Context context, String str, String str2, String str3, String str4, String str5) {
            this.f59983e = callbackHandler;
            this.f59984f = context;
            this.f59985g = str;
            this.f59986h = str2;
            this.f59987i = str3;
            this.j = str4;
            this.k = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!d.a.h0.a.v1.c.c.h(hVar)) {
                d.a.h0.a.v1.c.c.o(hVar, this.f59983e, b.this.f59982c);
            } else if (!b.this.l(this.f59984f, this.f59985g, this.f59986h, this.f59987i, this.j, this.k)) {
                d.a.h0.a.c0.c.b("PageTransitionAction", "page transition fail");
                this.f59983e.handleSchemeDispatchCallback(b.this.f59982c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } else {
                d.a.h0.a.c0.c.g("PageTransitionAction", "page transition success");
                this.f59983e.handleSchemeDispatchCallback(b.this.f59982c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* renamed from: d.a.j0.s.b.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1531b implements f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f59988a;

        public C1531b(Context context) {
            this.f59988a = context;
        }

        @Override // d.a.i0.a.f.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(f.v) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f59988a, null, (String) hashMap.get(f.v), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    public b(j jVar) {
        super(jVar, "/swanAPI/pageTransition");
    }

    public static String m(String str, String str2, String str3, String str4, String str5) {
        String str6;
        String str7;
        if (TextUtils.isEmpty(str5)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            JSONObject jSONObject = new JSONObject(str5);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (TextUtils.isEmpty(next)) {
                    return null;
                }
                String obj = jSONObject.opt(next).toString();
                sb.append(next + "=" + Uri.encode(obj) + "&");
            }
            if (!TextUtils.isEmpty(str4)) {
                str4 = "/" + str4;
            }
            if (TextUtils.equals(str3, AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA)) {
                str6 = "";
            } else {
                str6 = "/" + str3;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = str6 + str4;
            }
            String str8 = f59981d;
            if (TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    str8 = str8 + str;
                }
            } else {
                String substring = str2.substring(1, str2.length());
                if (TextUtils.isEmpty(str)) {
                    str7 = str8 + substring;
                } else {
                    str7 = str8 + str + "/" + substring;
                }
                str8 = str7;
            }
            StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.length() - 1));
            String str9 = str8 + "?" + ((Object) sb2);
            if (a0.f44398b) {
                Log.i("PageTransitionAction", "encodeParams: " + ((Object) sb2));
            }
            return str9;
        } catch (JSONException e2) {
            if (a0.f44398b) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static boolean n(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && str.contains("tbwebview")) {
            Uri parse = Uri.parse(str);
            if (f.c(parse)) {
                f.b().j(str, parse, new C1531b(context));
            } else {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context);
                tbWebViewActivityConfig.setUri(parse);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
            return true;
        }
        if (!TextUtils.isEmpty(str) && str.contains("com.baidu.tieba")) {
            Uri parse2 = Uri.parse(str);
            if ("miniapp".equals(parse2.getAuthority()) && "/goods".equals(parse2.getPath())) {
                d.a.i0.f0.h.i(new GoodsEvent(parse2.getQueryParameter("goodsList")));
                return true;
            }
        }
        return UtilHelper.dealOneScheme(context, str);
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "null swanApp");
            return false;
        }
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
            return false;
        }
        JSONObject b2 = v.b(param);
        String optString = b2.optString("cb");
        this.f59982c = optString;
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String optString2 = b2.optString("authority");
        String optString3 = b2.optString("path");
        String optString4 = b2.optString("module", AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA);
        String optString5 = b2.optString("action");
        JSONObject optJSONObject = b2.optJSONObject("scheme");
        try {
            optJSONObject.put("launchMode", BuildConfig.FLAVOR);
        } catch (JSONException e2) {
            if (a0.f44398b) {
                e2.printStackTrace();
            }
        }
        eVar.R().g((Activity) context, "mapp_i_baiduapp_page_trans", new a(callbackHandler, context, optString2, optString3, optString4, optString5, optJSONObject.toString()));
        d.a.h0.a.c0.c.g("PageTransitionAction", "callback success");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    public final boolean l(Context context, String str, String str2, String str3, String str4, String str5) {
        boolean z = false;
        if (!TextUtils.isEmpty(str5) && context != null) {
            String str6 = null;
            if (str3.hashCode() == -330473854) {
                str3.equals("anything");
            }
            if ("icashwebview".equals(str4)) {
                if (!StringUtils.isNull(str5)) {
                    try {
                        String optString = new JSONObject(str5).optString("url");
                        if (!StringUtils.isNull(optString)) {
                            o(optString);
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            } else {
                str6 = m(str, str2, str3, str4, str5);
                z = n(context, str6);
            }
            if (a0.f44398b) {
                Log.i("PageTransitionAction", "result = " + z + "\n拼接后的uri is: " + str6);
            }
        }
        return z;
    }

    public final void o(String str) {
        d.a.h0.a.n1.c.e.a x;
        d.a.h0.a.r1.e h2 = d.a.h0.a.r1.e.h();
        if (h2 == null || (x = h2.x()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_param_url", str);
        x.I(bundle, d.a.j0.s.b.l.a.class);
    }
}
