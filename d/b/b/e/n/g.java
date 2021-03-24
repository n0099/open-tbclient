package d.b.b.e.n;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.imageProblem.httpNet.CDNIPDirectConnect;
import d.b.b.e.p.j;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public c f41909a;

    /* renamed from: b  reason: collision with root package name */
    public String f41910b;

    /* renamed from: c  reason: collision with root package name */
    public String f41911c;

    /* renamed from: d  reason: collision with root package name */
    public String f41912d;

    /* renamed from: e  reason: collision with root package name */
    public String f41913e;

    /* renamed from: f  reason: collision with root package name */
    public String f41914f;

    /* renamed from: g  reason: collision with root package name */
    public String f41915g;

    /* renamed from: h  reason: collision with root package name */
    public String f41916h;
    public Map<String, String> i;

    public static String d() {
        return j.H() ? CDNIPDirectConnect.CDNNetworkChangeReceiver.WIFI_STRING : j.t() ? "2G" : j.u() ? com.baidu.apollon.statistics.g.f3873b : (j.v() || j.z()) ? "4G" : "NONE";
    }

    public void a(String str) {
        String[] split;
        if (this.i == null) {
            this.i = new HashMap();
        }
        String[] split2 = str.split("&");
        if (split2 == null || split2.length == 0) {
            return;
        }
        for (String str2 : split2) {
            if (!TextUtils.isEmpty(str2) && (split = str2.split("=")) != null && split.length == 2) {
                try {
                    this.i.put(split[0], URLDecoder.decode(split[1], "utf-8"));
                } catch (UnsupportedEncodingException e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    public void b(String str, String str2) {
        if (this.i == null) {
            this.i = new HashMap();
        }
        this.i.put(str, str2);
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (this.f41909a != null) {
                jSONObject2.put("app_version", this.f41909a.f41887c);
                jSONObject2.put("client_timestamp", Long.toString(System.currentTimeMillis()));
                jSONObject2.put("cuid", this.f41909a.f41891g);
                jSONObject2.put(AdExtParam.KEY_SHOUBAI_CUID, this.f41909a.f41892h);
                jSONObject2.put("from", this.f41909a.f41888d);
                jSONObject2.put("uid", this.f41909a.l);
            }
            jSONObject2.put("client_ip", f.b());
            jSONObject2.put("network", d());
            jSONObject2.put("model", Build.MODEL);
            jSONObject2.put("brand", Build.BRAND);
            jSONObject2.put("os_type", "AND");
            jSONObject2.put("os_version", Build.VERSION.RELEASE);
            jSONObject2.put("active_id", f.a());
            jSONObject2.put("mission_id", f.c());
            jSONObject.put("base_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (this.f41910b != null) {
                jSONObject3.put("module", this.f41910b);
            }
            if (this.f41911c != null) {
                jSONObject3.put("action", this.f41911c);
            }
            if (this.f41912d != null) {
                jSONObject3.put("error_code", this.f41912d);
            }
            if (this.f41913e != null) {
                jSONObject3.put("error_message", this.f41913e);
            }
            if (this.i != null) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, String> entry : this.i.entrySet()) {
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
            if (this.f41914f != null) {
                jSONObject3.put("id", this.f41914f);
            }
            if (this.f41915g != null) {
                jSONObject3.put("title", this.f41915g);
            }
            if (this.f41916h != null) {
                jSONObject3.put("abstract", this.f41916h);
            }
            jSONObject.put("debug_info", jSONObject3);
            jSONObject.put("kpi", new JSONObject());
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        return jSONObject;
    }

    public void e(String str) {
        this.f41911c = str;
    }

    public void f(c cVar) {
        this.f41909a = cVar;
    }

    public void g(String str) {
        this.f41912d = str;
    }

    public void h(String str) {
        this.f41913e = str;
    }

    public void i(String str) {
        this.f41910b = str;
    }
}
