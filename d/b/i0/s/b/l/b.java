package d.b.i0.s.b.l;

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
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import d.b.g0.a.i2.v;
import d.b.g0.a.t1.j;
import d.b.g0.a.t1.k.a0;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import d.b.h0.a.f;
import d.b.h0.f0.g;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b extends a0 {

    /* renamed from: d  reason: collision with root package name */
    public static String f60099d = "com.baidu.tieba://";

    /* renamed from: c  reason: collision with root package name */
    public String f60100c;

    /* loaded from: classes4.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f60101e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f60102f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f60103g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f60104h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;

        public a(CallbackHandler callbackHandler, Context context, String str, String str2, String str3, String str4, String str5) {
            this.f60101e = callbackHandler;
            this.f60102f = context;
            this.f60103g = str;
            this.f60104h = str2;
            this.i = str3;
            this.j = str4;
            this.k = str5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!d.b.g0.a.v1.c.c.h(hVar)) {
                d.b.g0.a.v1.c.c.o(hVar, this.f60101e, b.this.f60100c);
            } else if (!b.this.l(this.f60102f, this.f60103g, this.f60104h, this.i, this.j, this.k)) {
                d.b.g0.a.c0.c.b("PageTransitionAction", "page transition fail");
                this.f60101e.handleSchemeDispatchCallback(b.this.f60100c, UnitedSchemeUtility.wrapCallbackParams(1001).toString());
            } else {
                d.b.g0.a.c0.c.g("PageTransitionAction", "page transition success");
                this.f60101e.handleSchemeDispatchCallback(b.this.f60100c, UnitedSchemeUtility.wrapCallbackParams(0).toString());
            }
        }
    }

    /* renamed from: d.b.i0.s.b.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1529b implements f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f60105a;

        public C1529b(Context context) {
            this.f60105a = context;
        }

        @Override // d.b.h0.a.f.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(f.v) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f60105a, null, (String) hashMap.get(f.v), true);
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
            if (TextUtils.equals(str3, "NA")) {
                str6 = "";
            } else {
                str6 = "/" + str3;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = str6 + str4;
            }
            String str8 = f60099d;
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
            if (a0.f46287b) {
                Log.i("PageTransitionAction", "encodeParams: " + ((Object) sb2));
            }
            return str9;
        } catch (JSONException e2) {
            if (a0.f46287b) {
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
                f.b().j(str, parse, new C1529b(context));
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
                g.g(new GoodsEvent(parse2.getQueryParameter("goodsList")));
                return true;
            }
        }
        return UtilHelper.dealOneScheme(context, str);
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
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
        this.f60100c = optString;
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String optString2 = b2.optString("authority");
        String optString3 = b2.optString("path");
        String optString4 = b2.optString("module", "NA");
        String optString5 = b2.optString("action");
        JSONObject optJSONObject = b2.optJSONObject("scheme");
        try {
            optJSONObject.put("launchMode", BuildConfig.FLAVOR);
        } catch (JSONException e2) {
            if (a0.f46287b) {
                e2.printStackTrace();
            }
        }
        eVar.R().g((Activity) context, "mapp_i_baiduapp_page_trans", new a(callbackHandler, context, optString2, optString3, optString4, optString5, optJSONObject.toString()));
        d.b.g0.a.c0.c.g("PageTransitionAction", "callback success");
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
            if (a0.f46287b) {
                Log.i("PageTransitionAction", "result = " + z + "\n拼接后的uri is: " + str6);
            }
        }
        return z;
    }

    public final void o(String str) {
        d.b.g0.a.n1.c.e.a q;
        d.b.g0.a.r1.e y = d.b.g0.a.r1.e.y();
        if (y == null || (q = y.q()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_param_url", str);
        q.I(bundle, d.b.i0.s.b.l.a.class);
    }
}
