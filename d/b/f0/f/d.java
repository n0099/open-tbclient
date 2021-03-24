package d.b.f0.f;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.games.utils.so.SoUtils;
import com.tencent.connect.common.Constants;
import d.b.f0.l.g;
import d.b.f0.l.j;
import d.b.f0.l.k;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    public e f42958c;

    public d(Context context, Handler handler) {
        super(context, handler);
        this.f42946b = context;
        this.f42958c = e.a(context);
    }

    public String b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", d.b.f0.l.d.l(this.f42946b));
            jSONObject.put("1", d.b.f0.l.c.h(this.f42946b));
            jSONObject.put("2", d.b.f0.g.b.a(this.f42946b));
            jSONObject.put("3", d.b.f0.g.a.c(this.f42946b));
            return c("q/1/qr", d.b.f0.l.c.c(this.f42946b, e(j(), jSONObject), "1077101"));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
            return "";
        }
    }

    public String c(String str, JSONObject jSONObject) {
        try {
            byte[] f2 = d.b.f0.l.c.f();
            String b2 = this.f42958c.b(str, URLEncoder.encode(Base64.encodeToString(d.b.f0.l.e.h(f2, g.b(d.b.f0.l.d.e(this.f42946b)).getBytes()), 0)));
            if (TextUtils.isEmpty(b2)) {
                return "";
            }
            String a2 = a(b2, this.f42958c.e(f2, jSONObject.toString()));
            if (TextUtils.isEmpty(a2)) {
                return "";
            }
            JSONObject jSONObject2 = new JSONObject(a2);
            jSONObject2.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
            String optString = jSONObject2.optString("skey");
            String optString2 = jSONObject2.optString("data");
            return new String(d.b.f0.l.e.e(Base64.decode(optString2.getBytes(), 0), d.b.f0.l.e.g(Base64.decode(optString.getBytes(), 0), g.b(d.b.f0.l.d.e(this.f42946b)).getBytes())));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
            return "";
        }
    }

    public String d(JSONObject jSONObject, long j) {
        try {
            return c("q/1/qmini", d.b.f0.l.c.c(this.f42946b, e(j(), jSONObject), "1077102"));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
            return "";
        }
    }

    public final JSONObject e(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return null;
        }
        if (jSONObject == null) {
            return jSONObject2;
        }
        if (jSONObject2 == null) {
            return jSONObject;
        }
        try {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
        return jSONObject;
    }

    public final void f(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                jSONObject.put(str, "");
            } else {
                jSONObject.put(str, str2);
            }
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }

    public boolean g(JSONObject jSONObject) {
        JSONObject j;
        try {
            j = j();
            j.put("27", Build.MANUFACTURER);
            j.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, Build.MODEL);
            Pair<Integer, String[]> c2 = k.c(this.f42946b);
            if (c2 != null) {
                j.put("20", c2.first);
                Object[] objArr = (String[]) c2.second;
                if (objArr.length == 4) {
                    String str = "";
                    j.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, TextUtils.isEmpty(objArr[0]) ? "" : objArr[0]);
                    j.put("18", TextUtils.isEmpty(objArr[1]) ? "" : objArr[1]);
                    j.put(Constants.VIA_REPORT_TYPE_WPA_STATE, TextUtils.isEmpty(objArr[2]) ? "" : objArr[2]);
                    if (!TextUtils.isEmpty(objArr[3])) {
                        str = objArr[3];
                    }
                    j.put(Constants.VIA_ACT_TYPE_NINETEEN, str);
                }
            }
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
        return new JSONObject(c("q/1/qpre", d.b.f0.l.c.c(this.f42946b, e(j, jSONObject), "1077104"))).optInt("0", 0) == 0;
    }

    public String h() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", this.f42946b.getPackageName());
            jSONObject.put("6", d.b.f0.l.c.l(this.f42946b));
            jSONObject.put("7", j.a(this.f42946b));
            return c("q/1/qc", d.b.f0.l.c.c(this.f42946b, jSONObject, ""));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
            return "";
        }
    }

    public String i(JSONObject jSONObject, long j) {
        try {
            return c("q/1/qv", d.b.f0.l.c.c(this.f42946b, e(j(), jSONObject), ""));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
            return "";
        }
    }

    public final JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            f(jSONObject, Constants.VIA_REPORT_TYPE_QQFAVORITES, d.b.f0.g.b.a(this.f42946b));
            f(jSONObject, Constants.VIA_REPORT_TYPE_DATALINE, d.b.f0.l.d.i(this.f42946b));
            f(jSONObject, Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, d.b.f0.g.b.c(this.f42946b));
            f(jSONObject, SoUtils.SO_EVENT_ID_DEFAULT, d.b.f0.g.b.b(this.f42946b));
            f(jSONObject, "40", d.b.f0.g.a.d(this.f42946b));
            f(jSONObject, "41", d.b.f0.g.a.a(this.f42946b));
            f(jSONObject, "42", d.b.f0.g.a.b(this.f42946b));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
        return jSONObject;
    }
}
