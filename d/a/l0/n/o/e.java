package d.a.l0.n.o;

import android.text.TextUtils;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.webkit.internal.ETAG;
import d.a.l0.n.h.h;
import d.a.l0.n.i.l.a;
import d.a.l0.n.j.i.l;
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
        pMSAppInfo.appKey = jSONObject.optString("app_key");
        pMSAppInfo.appName = jSONObject.optString("app_name");
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
        pMSAppInfo.domainConfig = jSONObject.optString("domain_config");
        pMSAppInfo.webAction = jSONObject.optString("web_action");
        pMSAppInfo.domains = jSONObject.optString("domains");
        pMSAppInfo.serverExt = jSONObject.optString("ext");
        pMSAppInfo.appSign = jSONObject.optLong("app_sign");
        pMSAppInfo.payProtected = jSONObject.optInt("pay_protected", PMSConstants.PayProtected.NO_PAY_PROTECTED.type);
        pMSAppInfo.customerService = jSONObject.optInt("customer_service", PMSConstants.CustomerService.NO_CUSTOMER_SERVICE.type);
        pMSAppInfo.globalNotice = jSONObject.optInt("global_notice", PMSConstants.CloudSwitch.NO_DISPLAY.value);
        pMSAppInfo.globalPrivate = jSONObject.optInt("global_private", PMSConstants.CloudSwitch.NO_DISPLAY.value);
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
        d.a.l0.n.c.b().l(jSONObject.optJSONArray("ban_page"), jSONObject.optString("ban_tips"), pMSAppInfo.appKey);
        d.a.l0.n.c.b().r(pMSAppInfo, jSONObject.optJSONObject("scope_list"), jSONObject.optInt("service_degrade", 0) != 0);
        pMSAppInfo.webUrl = jSONObject.optString("web_url");
        pMSAppInfo.csProtocolVersion = PMSConstants.b.a();
        return pMSAppInfo;
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject != null && 1 == jSONObject.optInt("reset_env", 0);
    }

    public static d.a.l0.n.h.b c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (d.a.l0.n.h.b) i(jSONObject, new d.a.l0.n.h.b());
    }

    public static d.a.l0.n.h.d d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return (d.a.l0.n.h.d) i(jSONObject, new d.a.l0.n.h.d());
    }

    public static d.a.l0.n.i.l.a e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d.a.l0.n.i.l.a aVar = new d.a.l0.n.i.l.a();
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                a.C1134a c1134a = new a.C1134a();
                c1134a.f51755a = optJSONObject.optInt("errno");
                c1134a.f51756b = optJSONObject.optString("bundle_id");
                c1134a.f51757c = optJSONObject.optInt("category");
                c1134a.f51758d = j(optJSONObject.optJSONObject(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT));
                c1134a.f51759e = k(optJSONObject.optJSONArray("sub"));
                c1134a.f51760f = a(optJSONObject.optJSONObject("app_info"));
                d.a.l0.n.c.b().p(c1134a.f51756b, optJSONObject, c1134a.f51758d, c1134a.f51759e);
                arrayList.add(c1134a);
            }
        }
        aVar.f51754a = arrayList;
        return aVar;
    }

    public static d.a.l0.n.i.l.b f(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d.a.l0.n.i.l.b bVar = new d.a.l0.n.i.l.b();
        JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
        if (optJSONObject != null) {
            bVar.f51762a = j(optJSONObject.optJSONObject(FlutterActivityLaunchConfigs.DEFAULT_DART_ENTRYPOINT));
            bVar.f51763b = k(optJSONObject.optJSONArray("sub"));
            d.a.l0.n.c.b().p(str, optJSONObject, bVar.f51762a, bVar.f51763b);
        }
        bVar.f51764c = d(jSONObject.optJSONObject("framework"));
        bVar.f51766e = c(jSONObject.optJSONObject(ETAG.KEY_EXTENSION));
        bVar.f51765d = a(jSONObject.optJSONObject("app_info"));
        return bVar;
    }

    public static d.a.l0.n.i.l.c g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d.a.l0.n.i.l.c cVar = new d.a.l0.n.i.l.c();
        cVar.f51767a = l(jSONObject);
        return cVar;
    }

    public static d.a.l0.n.i.l.d h(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d.a.l0.n.i.l.d dVar = new d.a.l0.n.i.l.d();
        JSONObject optJSONObject = jSONObject.optJSONObject("pkg");
        if (optJSONObject != null) {
            dVar.f51768a = k(optJSONObject.optJSONArray("sub"));
            d.a.l0.n.c.b().p(str, optJSONObject, null, dVar.f51768a);
        }
        return dVar;
    }

    public static <T extends d.a.l0.n.h.e> T i(JSONObject jSONObject, T t) {
        if (jSONObject == null || t == null) {
            return null;
        }
        t.f51686g = jSONObject.optString("bundle_id");
        t.f51687h = jSONObject.optInt("category");
        t.j = jSONObject.optString("version_name");
        t.f51688i = jSONObject.optInt("version_code");
        t.k = jSONObject.optLong("size");
        t.l = jSONObject.optString(PackageTable.MD5);
        t.m = jSONObject.optString("sign");
        t.n = jSONObject.optString("download_url");
        return t;
    }

    public static d.a.l0.n.h.f j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d.a.l0.n.h.f fVar = (d.a.l0.n.h.f) i(jSONObject, new d.a.l0.n.h.f());
        fVar.o = jSONObject.optInt("pkg_type");
        fVar.p = jSONObject.optString("ext");
        return fVar;
    }

    public static List<d.a.l0.n.h.g> k(JSONArray jSONArray) {
        int length;
        if (jSONArray != null && (length = jSONArray.length()) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                d.a.l0.n.h.g gVar = (d.a.l0.n.h.g) i(optJSONObject, new d.a.l0.n.h.g());
                gVar.q = optJSONObject.optInt("pkg_type");
                gVar.p = optJSONObject.optString("sub_path");
                gVar.r = optJSONObject.optBoolean("independent");
                gVar.s = optJSONObject.optString("ext");
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

    public static d.a.l0.n.i.l.e n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d.a.l0.n.i.l.e eVar = new d.a.l0.n.i.l.e();
        eVar.f51769a = jSONObject.optLong("max_age");
        long optLong = jSONObject.optLong("lastsynctime");
        if (optLong > 0) {
            l.f51830c = optLong;
        }
        eVar.f51770b = jSONObject;
        return eVar;
    }
}
