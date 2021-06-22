package d.a.c.e.n;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import d.a.c.e.p.j;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public c f42516a;

    /* renamed from: b  reason: collision with root package name */
    public String f42517b;

    /* renamed from: c  reason: collision with root package name */
    public String f42518c;

    /* renamed from: d  reason: collision with root package name */
    public String f42519d;

    /* renamed from: e  reason: collision with root package name */
    public String f42520e;

    /* renamed from: f  reason: collision with root package name */
    public String f42521f;

    /* renamed from: g  reason: collision with root package name */
    public String f42522g;

    /* renamed from: h  reason: collision with root package name */
    public String f42523h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f42524i;

    public static String d() {
        return j.H() ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : j.t() ? "2G" : j.u() ? com.baidu.apollon.statistics.g.f3985b : (j.v() || j.z()) ? "4G" : "NONE";
    }

    public void a(String str) {
        String[] split;
        if (this.f42524i == null) {
            this.f42524i = new HashMap();
        }
        String[] split2 = str.split("&");
        if (split2 == null || split2.length == 0) {
            return;
        }
        for (String str2 : split2) {
            if (!TextUtils.isEmpty(str2) && (split = str2.split("=")) != null && split.length == 2) {
                try {
                    this.f42524i.put(split[0], URLDecoder.decode(split[1], "utf-8"));
                } catch (UnsupportedEncodingException e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    public void b(String str, String str2) {
        if (this.f42524i == null) {
            this.f42524i = new HashMap();
        }
        this.f42524i.put(str, str2);
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (this.f42516a != null) {
                jSONObject2.put("app_version", this.f42516a.f42493c);
                jSONObject2.put("client_timestamp", Long.toString(System.currentTimeMillis()));
                jSONObject2.put("cuid", this.f42516a.f42497g);
                jSONObject2.put("shoubai_cuid", this.f42516a.f42498h);
                jSONObject2.put("from", this.f42516a.f42494d);
                jSONObject2.put("uid", this.f42516a.l);
            }
            jSONObject2.put("client_ip", f.b());
            jSONObject2.put("network", d());
            jSONObject2.put("model", Build.MODEL);
            jSONObject2.put("brand", Build.BRAND);
            jSONObject2.put(SearchJsBridge.COOKIE_OS_TYPE, "AND");
            jSONObject2.put("os_version", Build.VERSION.RELEASE);
            jSONObject2.put("active_id", f.a());
            jSONObject2.put("mission_id", f.c());
            jSONObject.put("base_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (this.f42517b != null) {
                jSONObject3.put("module", this.f42517b);
            }
            if (this.f42518c != null) {
                jSONObject3.put("action", this.f42518c);
            }
            if (this.f42519d != null) {
                jSONObject3.put("error_code", this.f42519d);
            }
            if (this.f42520e != null) {
                jSONObject3.put("error_message", this.f42520e);
            }
            if (this.f42524i != null) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : this.f42524i.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append(":");
                    sb.append(entry.getValue());
                    sb.append("|");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                jSONObject3.put("ext1", sb);
            }
            if (this.f42521f != null) {
                jSONObject3.put("id", this.f42521f);
            }
            if (this.f42522g != null) {
                jSONObject3.put("title", this.f42522g);
            }
            if (this.f42523h != null) {
                jSONObject3.put("abstract", this.f42523h);
            }
            jSONObject.put("debug_info", jSONObject3);
            jSONObject.put("kpi", new JSONObject());
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        return jSONObject;
    }

    public void e(String str) {
        this.f42518c = str;
    }

    public void f(c cVar) {
        this.f42516a = cVar;
    }

    public void g(String str) {
        this.f42519d = str;
    }

    public void h(String str) {
        this.f42520e = str;
    }

    public void i(String str) {
        this.f42517b = str;
    }
}
