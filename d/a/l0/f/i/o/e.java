package d.a.l0.f.i.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.wallet.core.Domains;
import d.a.l0.f.i.r.h;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class e {
    public static String k = "ug_";
    public static String l = "ug_business";
    public static String m = "ctkey";
    public static String n = "CTK";
    public static String o = "sid_eid";
    public static String p = "exps";

    /* renamed from: b  reason: collision with root package name */
    public Context f50466b;

    /* renamed from: c  reason: collision with root package name */
    public String f50467c;

    /* renamed from: d  reason: collision with root package name */
    public String f50468d;

    /* renamed from: e  reason: collision with root package name */
    public String f50469e;

    /* renamed from: i  reason: collision with root package name */
    public c f50473i;
    public String j;

    /* renamed from: a  reason: collision with root package name */
    public String f50465a = "https://mobads.baidu.com/cpro/ui/mads.php";

    /* renamed from: f  reason: collision with root package name */
    public String f50470f = "1";

    /* renamed from: g  reason: collision with root package name */
    public String f50471g = "2";

    /* renamed from: h  reason: collision with root package name */
    public String f50472h = "8.800201";

    public e(Context context, c cVar) {
        this.f50466b = context;
        this.f50473i = cVar;
        if (cVar != null) {
            this.f50467c = cVar.b();
            this.f50468d = this.f50473i.e();
            this.f50469e = this.f50473i.g();
        }
        if (h.o()) {
            return;
        }
        this.j = h.b();
    }

    public abstract HashMap<String, String> a();

    public final HashMap<String, String> b() {
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IAdRequestParam.QUERY_WIDTH, String.valueOf(Math.round(h.i(this.f50466b) / h.d(this.f50466b))));
            hashMap.put(IAdRequestParam.QUERY_HEIGHT, String.valueOf(Math.round(h.h(this.f50466b) / h.d(this.f50466b))));
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(NetworkUtils.c(false));
            hashMap.put("net", sb.toString());
            hashMap.put("n", this.f50470f);
            hashMap.put("pk", this.f50469e);
            hashMap.put("appid", this.f50468d);
            hashMap.put("sw", "" + h.i(this.f50466b));
            hashMap.put(IAdRequestParam.SCREEN_HEIGHT, "" + h.h(this.f50466b));
            hashMap.put(IAdRequestParam.SN, "" + f());
            hashMap.put(IAdRequestParam.OS, "android");
            hashMap.put("apid", "" + this.f50467c);
            hashMap.put(IAdRequestParam.CHID, "0");
            String t = d.a.l0.f.i.m.a.b().t();
            if (t.equals("0")) {
                t = "";
            }
            hashMap.put("imei", t);
            hashMap.put("cuid", d.a.l0.f.i.m.a.b().s());
            hashMap.put(IAdRequestParam.OSV, h.f());
            hashMap.put(IAdRequestParam.PHONE_TYPE, h.e());
            hashMap.put(IAdRequestParam.APV, h.l());
            String c2 = h.c(d(), "BAIDUID");
            hashMap.put("baiduid", (TextUtils.isEmpty(c2) || c2.split(":").length <= 0) ? "" : c2.split(":")[0]);
            hashMap.put("p_ver", this.f50472h);
            hashMap.put(IAdRequestParam.RPT, this.f50471g);
            hashMap.put("tab", "2");
            hashMap.put(IAdRequestParam.REQ_ID, "");
            hashMap.put("scene", d.a.l0.f.i.m.a.b().k());
            String e2 = e();
            hashMap.put(p, e2);
            hashMap.put("eqid", d.a.l0.f.i.m.a.b().m());
            JSONObject u = d.a.l0.f.i.m.a.b().u();
            if (u != null) {
                if (u.has(l) && (jSONObject = u.getJSONObject(l)) != null) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next)) {
                            String optString = jSONObject.optString(next, "none");
                            if (n.equals(next)) {
                                hashMap.put(m, optString);
                                this.j = optString;
                            } else {
                                hashMap.put(k + next, optString);
                            }
                        }
                    }
                }
                if (u.has(o) && (optJSONArray = u.optJSONArray(o)) != null && optJSONArray.length() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    if (!TextUtils.isEmpty(e2)) {
                        sb2.append(e2 + ",");
                    }
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        String optString2 = optJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString2)) {
                            sb2.append(optString2);
                            if (i2 >= 0 && i2 < optJSONArray.length() - 1) {
                                sb2.append(",");
                            }
                        }
                    }
                    if (sb2.length() > 0) {
                        hashMap.put(p, sb2.toString());
                    }
                }
            }
            if (!hashMap.containsKey(n) && !TextUtils.isEmpty(this.j)) {
                hashMap.put(n, this.j);
            }
            hashMap.put("con_name", d.a.l0.f.i.m.a.b().a());
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public String c() {
        return this.j;
    }

    public String d() {
        return d.a.l0.f.i.m.a.b().l(Domains.BAIDU);
    }

    public abstract String e();

    public final String f() {
        try {
            String t = d.a.l0.f.i.m.a.b().t();
            return TextUtils.isEmpty(t) ? NetworkUtils.e(this.f50466b) : t;
        } catch (Exception unused) {
            return "";
        }
    }

    public String g() {
        HashMap<String, String> b2 = b();
        b2.putAll(a());
        return d.a.l0.f.i.r.e.a(this.f50465a, b2);
    }
}
