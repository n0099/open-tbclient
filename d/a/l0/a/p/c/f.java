package d.a.l0.a.p.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.lbspay.BuildConfig;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f implements d.a.l0.a.p.d.i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43962a = d.a.l0.a.k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43963b = SchemeConfig.getSchemeHead() + "://";

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
        String str7 = f43963b;
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
        if (f43962a) {
            Log.i("DefaultInnerSkip", "encodeParams: " + ((Object) sb2));
        }
        return str8;
    }

    public static boolean d(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        return SchemeRouter.invoke(context, str);
    }

    @Override // d.a.l0.a.p.d.i
    public d.a.l0.a.q2.a a(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null) {
            d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
            aVar.e("Context exception");
            return aVar;
        } else if (TextUtils.isEmpty(str5)) {
            return c(str5);
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
            }
            try {
                JSONObject jSONObject = new JSONObject(str5);
                jSONObject.put("launchMode", BuildConfig.FLAVOR);
                String b2 = b(str, str2, str3, str4, jSONObject);
                boolean d2 = d(context, b2);
                if (f43962a) {
                    Log.i("DefaultInnerSkip", "result = " + d2 + "\n拼接后的uri is: " + b2);
                }
                if (d2) {
                    return null;
                }
                d.a.l0.a.q2.a aVar2 = new d.a.l0.a.q2.a();
                aVar2.e("invoke failed");
                return aVar2;
            } catch (JSONException e2) {
                if (f43962a) {
                    Log.i("DefaultInnerSkip", Log.getStackTraceString(e2));
                }
                return c(str5);
            }
        }
    }

    public final d.a.l0.a.q2.a c(String str) {
        d.a.l0.a.q2.a aVar = new d.a.l0.a.q2.a();
        aVar.j(5L);
        aVar.h(1L);
        StringBuilder sb = new StringBuilder();
        sb.append("Error in parameter parsing: from PageTransitionAction:\n called by");
        sb.append(TextUtils.isEmpty(str) ? " empty" : "");
        sb.append(" parameter:");
        sb.append(str);
        sb.append("\n appId:");
        sb.append(d.a.l0.a.a2.d.g().getAppId());
        sb.append("\n curPage:");
        sb.append(d.a.l0.a.g1.f.V().U());
        sb.append("\n");
        aVar.e(sb.toString());
        return aVar;
    }
}
