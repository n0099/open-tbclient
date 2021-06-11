package d.a.j0.f;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.room.RoomMasterTable;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.swan.apps.so.SoUtils;
import com.tencent.connect.common.Constants;
import d.a.j0.l.g;
import d.a.j0.l.j;
import d.a.j0.l.k;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends a {

    /* renamed from: c  reason: collision with root package name */
    public e f44085c;

    public d(Context context, Handler handler) {
        super(context, handler);
        this.f44072b = context;
        this.f44085c = e.a(context);
    }

    public String b() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", d.a.j0.l.d.j(this.f44072b));
            jSONObject.put("1", d.a.j0.l.c.h(this.f44072b));
            jSONObject.put("2", d.a.j0.g.b.a(this.f44072b, true, false));
            jSONObject.put("3", d.a.j0.g.a.c(this.f44072b));
            return c("q/1/qr", d.a.j0.l.c.c(this.f44072b, e(f(true, false), jSONObject), "1077101"));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
            return "";
        }
    }

    public String c(String str, JSONObject jSONObject) {
        try {
            byte[] f2 = d.a.j0.l.c.f();
            String b2 = this.f44085c.b(str, URLEncoder.encode(Base64.encodeToString(d.a.j0.l.e.h(f2, g.b(d.a.j0.l.d.f(this.f44072b)).getBytes()), 0)));
            if (TextUtils.isEmpty(b2)) {
                return "";
            }
            String a2 = a(b2, this.f44085c.e(f2, jSONObject.toString()));
            if (TextUtils.isEmpty(a2)) {
                return "";
            }
            JSONObject jSONObject2 = new JSONObject(a2);
            jSONObject2.optString(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID);
            String optString = jSONObject2.optString("skey");
            String optString2 = jSONObject2.optString("data");
            return new String(d.a.j0.l.e.e(Base64.decode(optString2.getBytes(), 0), d.a.j0.l.e.g(Base64.decode(optString.getBytes(), 0), g.b(d.a.j0.l.d.f(this.f44072b)).getBytes())));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
            return "";
        }
    }

    public String d(JSONObject jSONObject, long j) {
        try {
            return c("q/1/qmini", d.a.j0.l.c.c(this.f44072b, e(f(true, false), jSONObject), "1077102"));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
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
            d.a.j0.l.c.d(th);
        }
        return jSONObject;
    }

    public final JSONObject f(boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            g(jSONObject, Constants.VIA_REPORT_TYPE_QQFAVORITES, d.a.j0.g.b.a(this.f44072b, z, z2));
            g(jSONObject, Constants.VIA_REPORT_TYPE_DATALINE, d.a.j0.l.d.b(this.f44072b, z, z2));
            g(jSONObject, Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, d.a.j0.g.b.c(this.f44072b, z, z2));
            g(jSONObject, SoUtils.SO_EVENT_ID_DEFAULT, d.a.j0.g.b.b(this.f44072b, z, z2));
            g(jSONObject, "40", d.a.j0.g.a.d(this.f44072b, z, z2));
            g(jSONObject, "41", d.a.j0.g.a.a(this.f44072b));
            g(jSONObject, RoomMasterTable.DEFAULT_ID, d.a.j0.g.a.b(this.f44072b, z, z2));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
        return jSONObject;
    }

    public final void g(JSONObject jSONObject, String str, String str2) {
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
            d.a.j0.l.c.d(th);
        }
    }

    public boolean h(JSONObject jSONObject) {
        JSONObject f2;
        try {
            f2 = f(false, true);
            f2.put("27", Build.MANUFACTURER);
            f2.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, Build.MODEL);
            f2.put(BaseUtils.METHOD_SENDMESSAGE, String.valueOf(Build.VERSION.SDK_INT));
            f2.put("56", Build.VERSION.RELEASE);
            f2.put("50", k.a(this.f44072b));
            f2.put("60", k.f(this.f44072b));
            Pair<Integer, String[]> e2 = k.e(this.f44072b);
            if (e2 != null) {
                f2.put("20", e2.first);
                String[] strArr = (String[]) e2.second;
                if (strArr.length == 4) {
                    f2.put("14", strArr[0]);
                    f2.put("18", strArr[1]);
                    f2.put(Constants.VIA_REPORT_TYPE_WPA_STATE, strArr[2]);
                    f2.put(Constants.VIA_ACT_TYPE_NINETEEN, strArr[3]);
                }
            }
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
        }
        return new JSONObject(c("q/1/qpre", d.a.j0.l.c.c(this.f44072b, e(f2, jSONObject), "1077104"))).optInt("0", 0) == 0;
    }

    public String i() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("0", this.f44072b.getPackageName());
            jSONObject.put("6", d.a.j0.l.c.l(this.f44072b));
            jSONObject.put("7", j.a(this.f44072b));
            return c("q/1/qc", d.a.j0.l.c.c(this.f44072b, jSONObject, ""));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
            return "";
        }
    }

    public String j(JSONObject jSONObject, long j) {
        try {
            return c("q/1/qv", d.a.j0.l.c.c(this.f44072b, e(f(true, false), jSONObject), ""));
        } catch (Throwable th) {
            d.a.j0.l.c.d(th);
            return "";
        }
    }
}
