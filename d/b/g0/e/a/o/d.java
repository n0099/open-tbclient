package d.b.g0.e.a.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.core.Domains;
import com.baidu.webkit.internal.ETAG;
import d.b.g0.a.i2.h0;
import d.b.g0.a.i2.i0;
import d.b.g0.a.i2.k0;
import d.b.g0.a.y0.e.b;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class d {
    public static String k = "ug_";
    public static String l = "ug_business";
    public static String m = "ctkey";
    public static String n = "CTK";
    public static String o = "eqid";
    public static String p = "sid_eid";
    public static String q = "exps";

    /* renamed from: b  reason: collision with root package name */
    public Context f47659b;

    /* renamed from: c  reason: collision with root package name */
    public String f47660c;

    /* renamed from: d  reason: collision with root package name */
    public String f47661d;

    /* renamed from: e  reason: collision with root package name */
    public String f47662e;
    public b i;
    public String j;

    /* renamed from: a  reason: collision with root package name */
    public String f47658a = "https://mobads.baidu.com/cpro/ui/mads.php";

    /* renamed from: f  reason: collision with root package name */
    public String f47663f = "1";

    /* renamed from: g  reason: collision with root package name */
    public String f47664g = "2";

    /* renamed from: h  reason: collision with root package name */
    public String f47665h = "8.800201";

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f47666a;

        static {
            int[] iArr = new int[SwanAppNetworkUtils.NetType.values().length];
            f47666a = iArr;
            try {
                iArr[SwanAppNetworkUtils.NetType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f47666a[SwanAppNetworkUtils.NetType.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f47666a[SwanAppNetworkUtils.NetType._2G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f47666a[SwanAppNetworkUtils.NetType._3G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f47666a[SwanAppNetworkUtils.NetType._4G.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f47666a[SwanAppNetworkUtils.NetType.UNKOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public d(Context context, b bVar) {
        this.f47659b = context;
        this.i = bVar;
        if (bVar != null) {
            this.f47660c = bVar.b();
            this.f47661d = this.i.e();
            this.f47662e = this.i.f();
        }
        if (k0.D()) {
            return;
        }
        this.j = d.b.g0.e.a.q.e.a();
    }

    public abstract HashMap<String, String> a();

    public final HashMap<String, String> b() {
        b.a J;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(h0.m(this.f47659b) / h0.j(this.f47659b))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(h0.l(this.f47659b) / h0.j(this.f47659b))));
            hashMap.put("net", "" + f());
            hashMap.put("n", this.f47663f);
            hashMap.put("pk", this.f47662e);
            hashMap.put("appid", this.f47661d);
            hashMap.put("sw", "" + h0.m(this.f47659b));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + h0.l(this.f47659b));
            hashMap.put(IXAdRequestInfo.SN, "" + g());
            hashMap.put(IXAdRequestInfo.OS, "android");
            hashMap.put("apid", "" + this.f47660c);
            hashMap.put("chid", "0");
            String r = k0.r();
            if (r.equals("0")) {
                r = "";
            }
            hashMap.put("imei", r);
            hashMap.put("cuid", d.b.g0.a.w0.a.O().c(d.b.g0.a.w0.a.c()));
            hashMap.put(IXAdRequestInfo.OSV, d.b.g0.a.b0.c.g());
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, d.b.g0.a.b0.c.f());
            hashMap.put("app_ver", k0.z());
            String k2 = i0.k(d(), "BAIDUID");
            hashMap.put(ETAG.KEY_BAIDU_ID, (TextUtils.isEmpty(k2) || k2.split(":").length <= 0) ? "" : k2.split(":")[0]);
            hashMap.put(IXAdRequestInfo.P_VER, this.f47665h);
            hashMap.put("rpt", this.f47664g);
            hashMap.put(BaiduWalletServiceProviderMap.PLUGIN_TAB, "2");
            hashMap.put("req_id", "");
            d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
            String e2 = e();
            hashMap.put(q, e2);
            if (O != null && (J = O.J()) != null) {
                hashMap.put("scene", J.S());
                JSONObject b1 = J.b1();
                if (b1 != null) {
                    hashMap.put("eqid", b1.optString(o, ""));
                }
                JSONObject L = J.L();
                if (L != null) {
                    if (L.has(l) && (jSONObject = L.getJSONObject(l)) != null) {
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
                    if (L.has(p) && (optJSONArray = L.optJSONArray(p)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(e2)) {
                            sb.append(e2 + ",");
                        }
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String optString2 = optJSONArray.optString(i);
                            if (!TextUtils.isEmpty(optString2)) {
                                sb.append(optString2);
                                if (i >= 0 && i < optJSONArray.length() - 1) {
                                    sb.append(",");
                                }
                            }
                        }
                        if (sb.length() > 0) {
                            hashMap.put(q, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(n) && !TextUtils.isEmpty(this.j)) {
                hashMap.put(n, this.j);
            }
            hashMap.put("con_name", d.b.g0.a.w0.a.k().g());
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public String c() {
        return this.j;
    }

    public String d() {
        return d.b.g0.a.w0.a.m().a().getCookie(Domains.BAIDU);
    }

    public abstract String e();

    public final int f() {
        int i = a.f47666a[SwanAppNetworkUtils.f().ordinal()];
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        return i != 6 ? 0 : 1;
                    }
                    return 4;
                }
                return 3;
            }
            return 2;
        }
        return 100;
    }

    public final String g() {
        try {
            String r = k0.r();
            return TextUtils.isEmpty(r) ? k0.A(this.f47659b) : r;
        } catch (Exception unused) {
            return "";
        }
    }

    public String h() {
        HashMap<String, String> b2 = b();
        b2.putAll(a());
        return d.b.g0.e.a.q.c.a(this.f47658a, b2);
    }
}
