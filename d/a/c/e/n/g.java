package d.a.c.e.n;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.util.FieldBuilder;
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
    public c f39096a;

    /* renamed from: b  reason: collision with root package name */
    public String f39097b;

    /* renamed from: c  reason: collision with root package name */
    public String f39098c;

    /* renamed from: d  reason: collision with root package name */
    public String f39099d;

    /* renamed from: e  reason: collision with root package name */
    public String f39100e;

    /* renamed from: f  reason: collision with root package name */
    public String f39101f;

    /* renamed from: g  reason: collision with root package name */
    public String f39102g;

    /* renamed from: h  reason: collision with root package name */
    public String f39103h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f39104i;

    public static String d() {
        return j.H() ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : j.t() ? "2G" : j.u() ? com.baidu.apollon.statistics.g.f3963b : (j.v() || j.z()) ? "4G" : "NONE";
    }

    public void a(String str) {
        String[] split;
        if (this.f39104i == null) {
            this.f39104i = new HashMap();
        }
        String[] split2 = str.split("&");
        if (split2 == null || split2.length == 0) {
            return;
        }
        for (String str2 : split2) {
            if (!TextUtils.isEmpty(str2) && (split = str2.split("=")) != null && split.length == 2) {
                try {
                    this.f39104i.put(split[0], URLDecoder.decode(split[1], "utf-8"));
                } catch (UnsupportedEncodingException e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    public void b(String str, String str2) {
        if (this.f39104i == null) {
            this.f39104i = new HashMap();
        }
        this.f39104i.put(str, str2);
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (this.f39096a != null) {
                jSONObject2.put("app_version", this.f39096a.f39073c);
                jSONObject2.put("client_timestamp", Long.toString(System.currentTimeMillis()));
                jSONObject2.put("cuid", this.f39096a.f39077g);
                jSONObject2.put("shoubai_cuid", this.f39096a.f39078h);
                jSONObject2.put("from", this.f39096a.f39074d);
                jSONObject2.put("uid", this.f39096a.l);
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
            if (this.f39097b != null) {
                jSONObject3.put("module", this.f39097b);
            }
            if (this.f39098c != null) {
                jSONObject3.put("action", this.f39098c);
            }
            if (this.f39099d != null) {
                jSONObject3.put("error_code", this.f39099d);
            }
            if (this.f39100e != null) {
                jSONObject3.put("error_message", this.f39100e);
            }
            if (this.f39104i != null) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : this.f39104i.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append(":");
                    sb.append(entry.getValue());
                    sb.append(FieldBuilder.SE);
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                jSONObject3.put("ext1", sb);
            }
            if (this.f39101f != null) {
                jSONObject3.put("id", this.f39101f);
            }
            if (this.f39102g != null) {
                jSONObject3.put("title", this.f39102g);
            }
            if (this.f39103h != null) {
                jSONObject3.put("abstract", this.f39103h);
            }
            jSONObject.put("debug_info", jSONObject3);
            jSONObject.put("kpi", new JSONObject());
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        return jSONObject;
    }

    public void e(String str) {
        this.f39098c = str;
    }

    public void f(c cVar) {
        this.f39096a = cVar;
    }

    public void g(String str) {
        this.f39099d = str;
    }

    public void h(String str) {
        this.f39100e = str;
    }

    public void i(String str) {
        this.f39097b = str;
    }
}
