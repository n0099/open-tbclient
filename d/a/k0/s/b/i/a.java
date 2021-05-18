package d.a.k0.s.b.i;

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
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.NewUrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import d.a.i0.a.k;
import d.a.i0.a.p.d.i;
import d.a.j0.a.f;
import d.a.j0.f0.h;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes4.dex */
public final class a implements i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f60708a = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public static String f60709b = NewUrlSchemaHelper.SCHEME;

    /* renamed from: d.a.k0.s.b.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1602a implements f.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f60710a;

        public C1602a(Context context) {
            this.f60710a = context;
        }

        @Override // d.a.j0.a.f.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            if (hashMap != null && (hashMap.get(d.a.j0.a.f.v) instanceof String)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f60710a, null, (String) hashMap.get(d.a.j0.a.f.v), true);
                tbWebViewActivityConfig.setIsFromSchema(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        }
    }

    public static String b(String str, String str2, String str3, String str4, JSONObject jSONObject) {
        String str5;
        String str6;
        Object opt;
        if (jSONObject == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (TextUtils.isEmpty(next) || (opt = jSONObject.opt(next)) == null) {
                return null;
            }
            String obj = opt.toString();
            sb.append(next + "=" + Uri.encode(obj) + "&");
        }
        if (!TextUtils.isEmpty(str4)) {
            str4 = "/" + str4;
        }
        if (TextUtils.equals(str3, AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA)) {
            str5 = "";
        } else {
            str5 = "/" + str3;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str5 + str4;
        }
        String str7 = f60709b;
        if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str)) {
                str7 = str7 + str;
            }
        } else {
            String substring = str2.substring(1, str2.length());
            if (TextUtils.isEmpty(str)) {
                str6 = str7 + substring;
            } else {
                str6 = str7 + str + "/" + substring;
            }
            str7 = str6;
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.length() - 1));
        String str8 = str7 + "?" + ((Object) sb2);
        if (f60708a) {
            Log.i("DefaultInnerSkip", "encodeParams: " + ((Object) sb2));
        }
        return str8;
    }

    public static boolean d(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && str.contains("tbwebview")) {
            Uri parse = Uri.parse(str);
            if (d.a.j0.a.f.c(parse)) {
                d.a.j0.a.f.b().j(str, parse, new C1602a(context));
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

    @Override // d.a.i0.a.p.d.i
    public d.a.i0.a.q2.a a(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null) {
            d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
            aVar.e("Context exception");
            return aVar;
        } else if (TextUtils.isEmpty(str5)) {
            return c(str5);
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            if ("icashwebview".equals(str4) && !StringUtils.isNull(str5)) {
                try {
                    String optString = new JSONObject(str5).optString("url");
                    if (!StringUtils.isNull(optString)) {
                        e(optString);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                d.a.i0.a.q2.a aVar2 = new d.a.i0.a.q2.a();
                aVar2.e("invoke failed");
                return aVar2;
            }
            try {
                JSONObject jSONObject = new JSONObject(str5);
                jSONObject.put("launchMode", BuildConfig.FLAVOR);
                String b2 = b(str, str2, str3, str4, jSONObject);
                boolean d2 = d(context, b2);
                if (f60708a) {
                    Log.i("DefaultInnerSkip", "result = " + d2 + "\n拼接后的uri is: " + b2);
                }
                if (d2) {
                    return null;
                }
                d.a.i0.a.q2.a aVar3 = new d.a.i0.a.q2.a();
                aVar3.e("invoke failed");
                return aVar3;
            } catch (JSONException e3) {
                if (f60708a) {
                    Log.i("DefaultInnerSkip", Log.getStackTraceString(e3));
                }
                return c(str5);
            }
        }
    }

    public final d.a.i0.a.q2.a c(String str) {
        d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
        aVar.j(5L);
        aVar.h(1L);
        StringBuilder sb = new StringBuilder();
        sb.append("Error in parameter parsing: from PageTransitionAction:\n called by");
        sb.append(TextUtils.isEmpty(str) ? " empty" : "");
        sb.append(" parameter:");
        sb.append(str);
        sb.append("\n");
        sb.append(" appId:");
        sb.append(d.a.i0.a.a2.d.g().getAppId());
        sb.append("\n");
        sb.append(" curPage:");
        sb.append(d.a.i0.a.g1.f.V().U());
        sb.append("\n");
        aVar.e(sb.toString());
        return aVar;
    }

    public final void e(String str) {
        d.a.i0.a.v1.c.e.a z;
        d.a.i0.a.a2.e i2 = d.a.i0.a.a2.e.i();
        if (i2 == null || (z = i2.z()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_param_url", str);
        z.K(bundle, c.class);
    }
}
