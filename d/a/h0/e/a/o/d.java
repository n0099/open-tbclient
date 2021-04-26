package d.a.h0.e.a.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.wallet.core.Domains;
import com.baidu.webkit.internal.ETAG;
import d.a.h0.a.i2.h0;
import d.a.h0.a.i2.i0;
import d.a.h0.a.i2.k0;
import d.a.h0.a.y0.e.b;
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
    public Context f45834b;

    /* renamed from: c  reason: collision with root package name */
    public String f45835c;

    /* renamed from: d  reason: collision with root package name */
    public String f45836d;

    /* renamed from: e  reason: collision with root package name */
    public String f45837e;

    /* renamed from: i  reason: collision with root package name */
    public b f45841i;
    public String j;

    /* renamed from: a  reason: collision with root package name */
    public String f45833a = "https://mobads.baidu.com/cpro/ui/mads.php";

    /* renamed from: f  reason: collision with root package name */
    public String f45838f = "1";

    /* renamed from: g  reason: collision with root package name */
    public String f45839g = "2";

    /* renamed from: h  reason: collision with root package name */
    public String f45840h = "8.800201";

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f45842a;

        static {
            int[] iArr = new int[SwanAppNetworkUtils.NetType.values().length];
            f45842a = iArr;
            try {
                iArr[SwanAppNetworkUtils.NetType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45842a[SwanAppNetworkUtils.NetType.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45842a[SwanAppNetworkUtils.NetType._2G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45842a[SwanAppNetworkUtils.NetType._3G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45842a[SwanAppNetworkUtils.NetType._4G.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45842a[SwanAppNetworkUtils.NetType.UNKOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public d(Context context, b bVar) {
        this.f45834b = context;
        this.f45841i = bVar;
        if (bVar != null) {
            this.f45835c = bVar.b();
            this.f45836d = this.f45841i.e();
            this.f45837e = this.f45841i.f();
        }
        if (k0.D()) {
            return;
        }
        this.j = d.a.h0.e.a.q.e.a();
    }

    public abstract HashMap<String, String> a();

    public final HashMap<String, String> b() {
        b.a J;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IAdRequestParam.QUERY_WIDTH, String.valueOf(Math.round(h0.m(this.f45834b) / h0.j(this.f45834b))));
            hashMap.put(IAdRequestParam.QUERY_HEIGHT, String.valueOf(Math.round(h0.l(this.f45834b) / h0.j(this.f45834b))));
            hashMap.put("net", "" + f());
            hashMap.put("n", this.f45838f);
            hashMap.put("pk", this.f45837e);
            hashMap.put("appid", this.f45836d);
            hashMap.put("sw", "" + h0.m(this.f45834b));
            hashMap.put(IAdRequestParam.SCREEN_HEIGHT, "" + h0.l(this.f45834b));
            hashMap.put(IAdRequestParam.SN, "" + g());
            hashMap.put(IAdRequestParam.OS, "android");
            hashMap.put("apid", "" + this.f45835c);
            hashMap.put(IAdRequestParam.CHID, "0");
            String r = k0.r();
            if (r.equals("0")) {
                r = "";
            }
            hashMap.put("imei", r);
            hashMap.put("cuid", d.a.h0.a.w0.a.O().f(d.a.h0.a.w0.a.c()));
            hashMap.put(IAdRequestParam.OSV, d.a.h0.a.b0.c.g());
            hashMap.put(IAdRequestParam.PHONE_TYPE, d.a.h0.a.b0.c.f());
            hashMap.put("app_ver", k0.z());
            String k2 = i0.k(d(), "BAIDUID");
            hashMap.put(ETAG.KEY_BAIDU_ID, (TextUtils.isEmpty(k2) || k2.split(":").length <= 0) ? "" : k2.split(":")[0]);
            hashMap.put("p_ver", this.f45840h);
            hashMap.put(IAdRequestParam.RPT, this.f45839g);
            hashMap.put("tab", "2");
            hashMap.put(IAdRequestParam.REQ_ID, "");
            d.a.h0.a.r1.e O = d.a.h0.a.r1.e.O();
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
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            String optString2 = optJSONArray.optString(i2);
                            if (!TextUtils.isEmpty(optString2)) {
                                sb.append(optString2);
                                if (i2 >= 0 && i2 < optJSONArray.length() - 1) {
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
            hashMap.put("con_name", d.a.h0.a.w0.a.k().f());
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public String c() {
        return this.j;
    }

    public String d() {
        return d.a.h0.a.w0.a.m().a().getCookie(Domains.BAIDU);
    }

    public abstract String e();

    public final int f() {
        int i2 = a.f45842a[SwanAppNetworkUtils.f().ordinal()];
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        return i2 != 6 ? 0 : 1;
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
            return TextUtils.isEmpty(r) ? k0.A(this.f45834b) : r;
        } catch (Exception unused) {
            return "";
        }
    }

    public String h() {
        HashMap<String, String> b2 = b();
        b2.putAll(a());
        return d.a.h0.e.a.q.c.a(this.f45833a, b2);
    }
}
