package d.a.i0.f.i.o;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.i0.f.i.r.h;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.UUID;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends e {
    public int q;
    public int r;
    public int s;
    public String t;

    public f(Context context, c cVar, int i2, int i3) {
        super(context, cVar);
        this.q = 1;
        this.r = 1;
        this.s = 1;
        this.r = i2;
        this.s = i3;
    }

    @Override // d.a.i0.f.i.o.e
    public HashMap<String, String> a() {
        return null;
    }

    @Override // d.a.i0.f.i.o.e
    public String e() {
        return null;
    }

    @Override // d.a.i0.f.i.o.e
    public String g() {
        return "https://powerful.xdplt.com/api/v1/front/ltc";
    }

    public final String h() {
        try {
            String string = Settings.Secure.getString(this.f46616b.getContentResolver(), IAdRequestParam.ANDROID_ID);
            return TextUtils.isEmpty(string) ? UUID.randomUUID().toString() : string;
        } catch (Exception unused) {
            return "";
        }
    }

    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", String.valueOf(System.currentTimeMillis()));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", this.f46623i.e());
            jSONObject2.put("name", d.a.i0.f.i.m.a.b().a());
            jSONObject2.put("bundle", h.k());
            jSONObject2.put("version", h.l());
            jSONObject.put("app", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ua", l());
            jSONObject3.put("imei", d.a.i0.f.i.m.a.b().t());
            jSONObject3.put(IAdRequestParam.ANDROID_ID, h());
            jSONObject3.put("ip", j(true));
            jSONObject3.put("type", 1);
            jSONObject3.put(IAdRequestParam.OS, 1);
            jSONObject3.put("os_version", h.f());
            jSONObject3.put("make", h.g());
            jSONObject3.put("model", h.e());
            jSONObject3.put("language", this.f46616b.getResources().getConfiguration().locale.getLanguage());
            jSONObject3.put("connection_type", NetworkUtils.c(true));
            jSONObject3.put("carrier", k(this.f46616b));
            jSONObject3.put(IAdRequestParam.MAC, NetworkUtils.e(this.f46616b));
            jSONObject3.put("screen_width", h.i(this.f46616b));
            jSONObject3.put("screen_height", h.h(this.f46616b));
            jSONObject3.put("screen_orientation", this.f46616b.getResources().getConfiguration().orientation);
            jSONObject.put("device", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("sid", this.f46623i.b());
            jSONObject4.put("ad_count", this.q);
            jSONObject4.put(TiebaStatic.Params.AD_TYPE, this.r);
            jSONObject4.put(IAdRequestParam.POS, this.s);
            jSONObject4.put("width", this.f46623i.d());
            jSONObject4.put("height", this.f46623i.a());
            jSONObject4.put(ClientCookie.SECURE_ATTR, 1);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject4);
            jSONObject.put("imps", jSONArray);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        r0 = r3.getHostAddress().toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String j(boolean z) {
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            loop0: while (true) {
                if (!networkInterfaces.hasMoreElements()) {
                    break;
                }
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!z || !(nextElement instanceof Inet6Address)) {
                        if (!nextElement.isLoopbackAddress()) {
                            break loop0;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public int k(Context context) {
        TelephonyManager telephonyManager;
        String simOperator;
        if (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null || (simOperator = telephonyManager.getSimOperator()) == null) {
            return 0;
        }
        if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46007".equals(simOperator)) {
            return 1;
        }
        if ("46001".equals(simOperator)) {
            return 2;
        }
        return "46003".equals(simOperator) ? 3 : 0;
    }

    public final String l() {
        if (TextUtils.isEmpty(this.t)) {
            try {
                try {
                    this.t = WebSettings.getDefaultUserAgent(this.f46616b);
                } catch (Exception unused) {
                    this.t = "";
                }
            } catch (Exception unused2) {
                this.t = System.getProperty("http.agent");
            }
        }
        return this.t;
    }
}
