package d.a.o0.u.b.i;

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
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.a.v2.w;
import d.a.n0.a.g;
import d.a.n0.f0.h;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static String f65119d = "com.baidu.tieba://";

    /* renamed from: c  reason: collision with root package name */
    public String f65120c;

    /* loaded from: classes4.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f65121e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f65122f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f65123g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f65124h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f65125i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, Context context, String str, String str2, String str3, String str4, String str5) {
            this.f65121e = callbackHandler;
            this.f65122f = context;
            this.f65123g = str;
            this.f65124h = str2;
            this.f65125i = str3;
            this.j = str4;
            this.k = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.a.m0.a.e2.c.d.h(iVar)) {
                d.a.m0.a.e2.c.d.p(iVar, this.f65121e, d.this.f65120c);
            } else if (!d.this.l(this.f65122f, this.f65123g, this.f65124h, this.f65125i, this.j, this.k)) {
                d.a.m0.a.e0.d.b("PageTransitionAction", "page transition fail");
                this.f65121e.handleSchemeDispatchCallback(d.this.f65120c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } else {
                d.a.m0.a.e0.d.g("PageTransitionAction", "page transition success");
                this.f65121e.handleSchemeDispatchCallback(d.this.f65120c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements g.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f65126a;

        public b(Context context) {
            this.f65126a = context;
        }

        @Override // d.a.n0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(d.a.n0.a.g.v) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f65126a, null, (String) hashMap.get(d.a.n0.a.g.v), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    public d(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/pageTransition");
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
            String str8 = f65119d;
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
            if (a0.f44733b) {
                Log.i("PageTransitionAction", "encodeParams: " + ((Object) sb2));
            }
            return str9;
        } catch (JSONException e2) {
            if (a0.f44733b) {
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
            if (d.a.n0.a.g.c(parse)) {
                d.a.n0.a.g.b().j(str, parse, new b(context));
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
                h.i(new GoodsEvent(parse2.getQueryParameter("goodsList")));
                return true;
            }
        }
        return UtilHelper.dealOneScheme(context, str);
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        if (eVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "null swanApp");
            return false;
        }
        String param = unitedSchemeEntity.getParam("params");
        if (TextUtils.isEmpty(param)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "params is null");
            return false;
        }
        JSONObject d2 = w.d(param);
        String optString = d2.optString("cb");
        this.f65120c = optString;
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String optString2 = d2.optString("authority");
        String optString3 = d2.optString("path");
        String optString4 = d2.optString("module", AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA);
        String optString5 = d2.optString("action");
        JSONObject optJSONObject = d2.optJSONObject("scheme");
        try {
            optJSONObject.put("launchMode", BuildConfig.FLAVOR);
        } catch (JSONException e2) {
            if (a0.f44733b) {
                e2.printStackTrace();
            }
        }
        eVar.T().g((Activity) context, "mapp_i_baiduapp_page_trans", new a(callbackHandler, context, optString2, optString3, optString4, optString5, optJSONObject.toString()));
        d.a.m0.a.e0.d.g("PageTransitionAction", "callback success");
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
            if (a0.f44733b) {
                Log.i("PageTransitionAction", "result = " + z + "\n拼接后的uri is: " + str6);
            }
        }
        return z;
    }

    public final void o(String str) {
        d.a.m0.a.v1.c.e.a z;
        d.a.m0.a.a2.e i2 = d.a.m0.a.a2.e.i();
        if (i2 == null || (z = i2.z()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_param_url", str);
        z.K(bundle, c.class);
    }
}
