package d.b.b.e.n.l;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes.dex */
public class d {
    public static void a(HashMap<String, Object> hashMap, String str, String str2) {
        if (hashMap == null || str == null || str2 == null) {
            return;
        }
        hashMap.put(str, str2);
    }

    public static void b(StringBuilder sb, String str, String str2, boolean z) {
        if (sb == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            sb.append("&");
            sb.append(str);
            sb.append("=");
            if (z) {
                str2 = URLEncoder.encode(str2, "utf-8");
            }
            sb.append(str2);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public static String c(d.b.b.e.n.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("product");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.f41885a, "utf-8"));
            sb.append("&");
            sb.append("sub_sys");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.f41886b, "utf-8"));
            sb.append("&");
            sb.append("version");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.f41887c, "utf-8"));
            sb.append("&");
            sb.append(IXAdRequestInfo.OS);
            sb.append("=");
            sb.append("android");
            sb.append("&");
            sb.append("os_version");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.q, "utf-8"));
            if (!TextUtils.isEmpty(cVar.f41888d)) {
                sb.append("&");
                sb.append("from");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.f41888d, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.f41889e)) {
                sb.append("&");
                sb.append("cfrom");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.f41889e, "utf-8"));
            }
            sb.append("&");
            sb.append("phone");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.k, "utf-8"));
            if (!TextUtils.isEmpty(cVar.l)) {
                sb.append("&");
                sb.append("uid");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.l, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.f41890f)) {
                sb.append("&");
                sb.append("client_id");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.f41890f, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.i)) {
                sb.append("&");
                sb.append("imei");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.i, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.m)) {
                sb.append("&");
                sb.append("uname");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.m, "utf-8"));
            }
            if (!TextUtils.isEmpty(cVar.f41891g)) {
                sb.append("&");
                sb.append("cuid");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.f41891g, "utf-8"));
            }
            sb.append("&");
            sb.append("net");
            sb.append("=");
            sb.append(URLEncoder.encode(cVar.o, "utf-8"));
        } catch (UnsupportedEncodingException e2) {
            BdLog.e(e2);
        }
        return sb.toString();
    }

    public static String d(boolean z, d.b.b.e.n.c cVar) {
        if (cVar == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_client_type=2");
        b(sb, HttpRequest.CLIENT_VERSION, cVar.f41887c, z);
        b(sb, HttpRequest.PHONE_IMEI, cVar.i, z);
        b(sb, HttpRequest.CLIENT_ID, cVar.f41890f, z);
        b(sb, HttpRequest.SUBAPP_TYPE, cVar.j, z);
        b(sb, "os_version", cVar.q, z);
        b(sb, "from", cVar.f41888d, z);
        b(sb, "cfrom", cVar.f41889e, z);
        b(sb, "net_type", cVar.p, z);
        b(sb, "cuid", cVar.f41891g, z);
        b(sb, "model", cVar.k, z);
        if (TextUtils.isEmpty(cVar.l)) {
            b(sb, "uid", "0", z);
        } else {
            b(sb, "uid", cVar.l, z);
        }
        b(sb, "un", cVar.m, z);
        b(sb, "utbrand", cVar.w, z);
        return sb.toString();
    }

    public static String e(d.b.b.e.n.h.a aVar, d.b.b.e.n.c cVar) {
        if (aVar.p() != null && (aVar.p().equals("omp") || aVar.p().equals("mon"))) {
            return c(cVar);
        }
        return d(true, cVar);
    }

    public static HashMap<String, Object> f(d.b.b.e.n.c cVar, boolean z) {
        HashMap<String, Object> hashMap = new HashMap<>();
        a(hashMap, HttpRequest.CLIENT_TYPE, "2");
        a(hashMap, HttpRequest.CLIENT_VERSION, cVar.f41887c);
        a(hashMap, HttpRequest.PHONE_IMEI, cVar.i);
        a(hashMap, HttpRequest.CLIENT_ID, cVar.f41890f);
        a(hashMap, HttpRequest.SUBAPP_TYPE, cVar.j);
        a(hashMap, "from", cVar.f41888d);
        a(hashMap, "net_type", cVar.p);
        a(hashMap, "cuid", cVar.f41891g);
        a(hashMap, "model", cVar.k);
        if (TextUtils.isEmpty(cVar.l)) {
            cVar.l = "0";
        }
        a(hashMap, "uid", cVar.l);
        a(hashMap, "un", cVar.m);
        a(hashMap, HttpRequest.BDUSS, cVar.n);
        if (z) {
            a(hashMap, "find_bug", "2");
        } else {
            a(hashMap, "find_bug", "0");
        }
        a(hashMap, "sz", cVar.r);
        a(hashMap, "cua", cVar.s);
        a(hashMap, "bdid", cVar.z);
        a(hashMap, "cookie", cVar.n);
        a(hashMap, "oaid", cVar.t);
        a(hashMap, "mac", cVar.u);
        a(hashMap, "android_id", cVar.v);
        a(hashMap, "utbrand", cVar.w);
        a(hashMap, "baiduapppb_ut", cVar.x);
        a(hashMap, com.alipay.sdk.cons.b.f1852b, cVar.y);
        a(hashMap, "active_timestamp", cVar.A);
        a(hashMap, "first_install_time", cVar.B);
        a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, cVar.C);
        a(hashMap, "event_day", cVar.D);
        return hashMap;
    }
}
