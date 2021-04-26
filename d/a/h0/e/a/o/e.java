package d.a.h0.e.a.o;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.k0;
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
public class e extends d {
    public int r;
    public int s;
    public int t;
    public String u;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45843a;

        static {
            int[] iArr = new int[SwanAppNetworkUtils.NetType.values().length];
            f45843a = iArr;
            try {
                iArr[SwanAppNetworkUtils.NetType.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45843a[SwanAppNetworkUtils.NetType._2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45843a[SwanAppNetworkUtils.NetType._3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45843a[SwanAppNetworkUtils.NetType._4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45843a[SwanAppNetworkUtils.NetType._5G.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public e(Context context, b bVar, int i2, int i3) {
        super(context, bVar);
        this.r = 1;
        this.s = 1;
        this.t = 1;
        this.s = i2;
        this.t = i3;
    }

    private int f() {
        int i2 = a.f45843a[SwanAppNetworkUtils.f().ordinal()];
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                i3 = 3;
                if (i2 != 3) {
                    i3 = 4;
                    if (i2 != 4) {
                        i3 = 5;
                        if (i2 != 5) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i3;
    }

    @Override // d.a.h0.e.a.o.d
    public HashMap<String, String> a() {
        return null;
    }

    @Override // d.a.h0.e.a.o.d
    public String e() {
        return null;
    }

    @Override // d.a.h0.e.a.o.d
    public String h() {
        return "https://powerful.xdplt.com/api/v1/front/ltc";
    }

    public final String i() {
        try {
            String string = Settings.Secure.getString(this.f45834b.getContentResolver(), IAdRequestParam.ANDROID_ID);
            return TextUtils.isEmpty(string) ? UUID.randomUUID().toString() : string;
        } catch (Exception unused) {
            return "";
        }
    }

    public JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", String.valueOf(System.currentTimeMillis()));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", this.f45841i.e());
            jSONObject2.put("name", d.a.h0.a.w0.a.k().f());
            jSONObject2.put("bundle", d.a.h0.a.w0.a.c().getPackageName());
            jSONObject2.put("version", k0.z());
            jSONObject.put("app", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ua", m());
            jSONObject3.put("imei", k0.r());
            jSONObject3.put(IAdRequestParam.ANDROID_ID, i());
            jSONObject3.put("ip", k(true));
            jSONObject3.put("type", 1);
            jSONObject3.put(IAdRequestParam.OS, 1);
            jSONObject3.put("os_version", d.a.h0.a.b0.c.g());
            jSONObject3.put("make", d.a.h0.a.b0.c.h());
            jSONObject3.put("model", d.a.h0.a.b0.c.f());
            jSONObject3.put("language", this.f45834b.getResources().getConfiguration().locale.getLanguage());
            jSONObject3.put("connection_type", f());
            jSONObject3.put("carrier", l(this.f45834b));
            jSONObject3.put(IAdRequestParam.MAC, k0.A(this.f45834b));
            jSONObject3.put("screen_width", h0.m(this.f45834b));
            jSONObject3.put("screen_height", h0.l(this.f45834b));
            jSONObject3.put("screen_orientation", this.f45834b.getResources().getConfiguration().orientation);
            jSONObject.put("device", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("sid", this.f45841i.b());
            jSONObject4.put("ad_count", this.r);
            jSONObject4.put(TiebaStatic.Params.AD_TYPE, this.s);
            jSONObject4.put(IAdRequestParam.POS, this.t);
            jSONObject4.put("width", this.f45841i.d());
            jSONObject4.put("height", this.f45841i.a());
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
    public final String k(boolean z) {
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

    public int l(Context context) {
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

    public final String m() {
        if (TextUtils.isEmpty(this.u)) {
            try {
                try {
                    this.u = WebSettings.getDefaultUserAgent(this.f45834b);
                } catch (Exception unused) {
                    this.u = "";
                }
            } catch (Exception unused2) {
                this.u = System.getProperty("http.agent");
            }
        }
        return this.u;
    }
}
