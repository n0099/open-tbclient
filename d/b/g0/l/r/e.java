package d.b.g0.l.r;

import android.text.TextUtils;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.pms.PMSConstants$CloudSwitch;
import com.baidu.swan.pms.PMSConstants$CustomerService;
import com.baidu.swan.pms.PMSConstants$PayProtected;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.webkit.internal.ETAG;
import d.b.g0.l.k.h;
import d.b.g0.l.l.j.a;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {
    public static PMSAppInfo a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PMSAppInfo pMSAppInfo = new PMSAppInfo();
        pMSAppInfo.appKey = jSONObject.optString(com.alipay.sdk.cons.b.f1858h);
        pMSAppInfo.appName = jSONObject.optString(DpStatConstants.KEY_APP_NAME);
        pMSAppInfo.description = jSONObject.optString("app_desc");
        pMSAppInfo.appStatus = jSONObject.optInt("app_status");
        pMSAppInfo.statusDetail = jSONObject.optString("status_detail");
        pMSAppInfo.statusDesc = jSONObject.optString("status_desc");
        pMSAppInfo.resumeDate = jSONObject.optString("resume_date");
        pMSAppInfo.subjectInfo = jSONObject.optString("subject_info");
        pMSAppInfo.maxAge = jSONObject.optLong("max_age");
        pMSAppInfo.appCategory = jSONObject.optInt("sub_category");
        pMSAppInfo.iconUrl = jSONObject.optString("icon_url");
        pMSAppInfo.serviceCategory = jSONObject.optString("service_category");
        pMSAppInfo.webViewDomains = jSONObject.optString("webview_domains");
        pMSAppInfo.webAction = jSONObject.optString("web_action");
        pMSAppInfo.domains = jSONObject.optString("domains");
        pMSAppInfo.serverExt = jSONObject.optString("ext");
        pMSAppInfo.appSign = jSONObject.optLong("app_sign");
        pMSAppInfo.payProtected = jSONObject.optInt("pay_protected", PMSConstants$PayProtected.NO_PAY_PROTECTED.type);
        pMSAppInfo.customerService = jSONObject.optInt("customer_service", PMSConstants$CustomerService.NO_CUSTOMER_SERVICE.type);
        pMSAppInfo.globalNotice = jSONObject.optInt("global_notice", PMSConstants$CloudSwitch.NO_DISPLAY.value);
        pMSAppInfo.globalPrivate = jSONObject.optInt("global_private", PMSConstants$CloudSwitch.NO_DISPLAY.value);
        pMSAppInfo.paNumber = jSONObject.optString("pa_number");
        String optString = m(pMSAppInfo.serverExt).optString("quick_app_key");
        if (!TextUtils.isEmpty(optString)) {
            pMSAppInfo.quickAppKey = optString;
        }
        JSONObject optJSONObject = m(pMSAppInfo.serverExt).optJSONObject(SwanAppBearInfo.BEAR_INFO);
        if (optJSONObject != null) {
            pMSAppInfo.bearInfo = optJSONObject.toString();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("plugins");
        if (optJSONArray != null) {
            pMSAppInfo.pluginInfo = optJSONArray.toString();
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("brand");
        if (optJSONObject2 != null) {
            pMSAppInfo.brandsInfo = optJSONObject2.toString();
        }
        d.b.g0.l.f.b().n(jSONObject.optJSONArray("ban_path"), jSONObject.optString("ban_tips"), pMSAppInfo.appKey);
        d.b.g0.l.f.b().x(pMSAppInfo, jSONObject.optJSONObject("scope_list"), jSONObject.optInt("service_degrade", 0) != 0);
        pMSAppInfo.webUrl = jSONObject.optString("web_url");
        pMSAppInfo.csProtocolVersion = d.b.g0.l.e.a();
        return pMSAppInfo;
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject != null && 1 == jSONObject.optInt("reset_env", 0);
    }

    public static d.b.g0.l.k.b c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (d.b.g0.l.k.b) i(jSONObject, new d.b.g0.l.k.b());
    }

    public static d.b.g0.l.k.d d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (d.b.g0.l.k.d) i(jSONObject, new d.b.g0.l.k.d());
    }

    public static d.b.g0.l.l.j.a e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d.b.g0.l.l.j.a aVar = new d.b.g0.l.l.j.a();
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                a.C1020a c1020a = new a.C1020a();
                c1020a.f48977a = optJSONObject.optInt("errno");
                c1020a.f48978b = optJSONObject.optString("bundle_id");
                c1020a.f48979c = optJSONObject.optInt("category");
                c1020a.f48980d = j(optJSONObject.optJSONObject(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT));
                c1020a.f48981e = k(optJSONObject.optJSONArray("sub"));
                c1020a.f48982f = a(optJSONObject.optJSONObject("app_info"));
                arrayList.add(c1020a);
            }
        }
        aVar.f48976a = arrayList;
        return aVar;
    }

    public static d.b.g0.l.l.j.b f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d.b.g0.l.l.j.b bVar = new d.b.g0.l.l.j.b();
        JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
        if (optJSONObject != null) {
            bVar.f48984a = j(optJSONObject.optJSONObject(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT));
            bVar.f48985b = k(optJSONObject.optJSONArray("sub"));
        }
        bVar.f48986c = d(jSONObject.optJSONObject("framework"));
        bVar.f48988e = c(jSONObject.optJSONObject(ETAG.KEY_EXTENSION));
        bVar.f48987d = a(jSONObject.optJSONObject("app_info"));
        return bVar;
    }

    public static d.b.g0.l.l.j.c g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d.b.g0.l.l.j.c cVar = new d.b.g0.l.l.j.c();
        cVar.f48989a = l(jSONObject);
        return cVar;
    }

    public static d.b.g0.l.l.j.d h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d.b.g0.l.l.j.d dVar = new d.b.g0.l.l.j.d();
        JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
        if (optJSONObject != null) {
            dVar.f48990a = k(optJSONObject.optJSONArray("sub"));
        }
        return dVar;
    }

    public static <T extends d.b.g0.l.k.e> T i(JSONObject jSONObject, T t) {
        if (jSONObject == null || t == null) {
            return null;
        }
        t.f48923g = jSONObject.optString("bundle_id");
        t.f48924h = jSONObject.optInt("category");
        t.j = jSONObject.optString("version_name");
        t.i = jSONObject.optLong("version_code");
        t.k = jSONObject.optLong("size");
        t.l = jSONObject.optString(PackageTable.MD5);
        t.m = jSONObject.optString("sign");
        t.n = jSONObject.optString("download_url");
        return t;
    }

    public static d.b.g0.l.k.f j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d.b.g0.l.k.f fVar = (d.b.g0.l.k.f) i(jSONObject, new d.b.g0.l.k.f());
        fVar.o = jSONObject.optInt("pkg_type");
        return fVar;
    }

    public static List<d.b.g0.l.k.g> k(JSONArray jSONArray) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                d.b.g0.l.k.g gVar = (d.b.g0.l.k.g) i(optJSONObject, new d.b.g0.l.k.g());
                gVar.q = optJSONObject.optInt("pkg_type");
                gVar.p = optJSONObject.optString("sub_path");
                gVar.r = optJSONObject.optBoolean("independent");
                arrayList.add(gVar);
            }
            return arrayList;
        }
        return null;
    }

    public static h l(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        h hVar = new h();
        i(jSONObject, hVar);
        long optLong = jSONObject.optLong("max_age");
        if (optLong < 0) {
            optLong = 0;
        }
        hVar.o = optLong;
        return hVar;
    }

    public static JSONObject m(String str) {
        if (TextUtils.isEmpty(str)) {
            return new JSONObject();
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    public static d.b.g0.l.l.j.e n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d.b.g0.l.l.j.e eVar = new d.b.g0.l.l.j.e();
        eVar.f48991a = jSONObject.optLong("max_age");
        eVar.f48992b = jSONObject;
        return eVar;
    }
}
