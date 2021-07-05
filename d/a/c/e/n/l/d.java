package d.a.c.e.n.l;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(HashMap<String, Object> hashMap, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, hashMap, str, str2) == null) || hashMap == null || str == null || str2 == null) {
            return;
        }
        hashMap.put(str, str2);
    }

    public static void b(StringBuilder sb, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{sb, str, str2, Boolean.valueOf(z)}) == null) || sb == null || TextUtils.isEmpty(str)) {
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

    public static String c(d.a.c.e.n.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cVar)) == null) {
            if (cVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.f44300a, "utf-8"));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.f44301b, "utf-8"));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.f44302c, "utf-8"));
                sb.append("&");
                sb.append(IAdRequestParam.OS);
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(cVar.q, "utf-8"));
                if (!TextUtils.isEmpty(cVar.f44303d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(cVar.f44303d, "utf-8"));
                }
                if (!TextUtils.isEmpty(cVar.f44304e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(cVar.f44304e, "utf-8"));
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
                if (!TextUtils.isEmpty(cVar.f44305f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(cVar.f44305f, "utf-8"));
                }
                if (!TextUtils.isEmpty(cVar.f44308i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(cVar.f44308i, "utf-8"));
                }
                if (!TextUtils.isEmpty(cVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(cVar.m, "utf-8"));
                }
                if (!TextUtils.isEmpty(cVar.f44306g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(cVar.f44306g, "utf-8"));
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
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, d.a.c.e.n.c cVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, cVar)) == null) {
            if (cVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", cVar.f44302c, z);
            b(sb, HttpRequest.PHONE_IMEI, cVar.f44308i, z);
            b(sb, HttpRequest.CLIENT_ID, cVar.f44305f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, cVar.j, z);
            b(sb, HttpConstants.OS_VERSION, cVar.q, z);
            b(sb, "from", cVar.f44303d, z);
            b(sb, "cfrom", cVar.f44304e, z);
            b(sb, "net_type", cVar.p, z);
            b(sb, "cuid", cVar.f44306g, z);
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
        return (String) invokeZL.objValue;
    }

    public static String e(d.a.c.e.n.h.a aVar, d.a.c.e.n.c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, aVar, cVar)) == null) {
            if (aVar.p() != null && (aVar.p().equals("omp") || aVar.p().equals("mon"))) {
                return c(cVar);
            }
            return d(true, cVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(d.a.c.e.n.c cVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(AdIconUtil.AD_TEXT_ID, null, cVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", cVar.f44302c);
            a(hashMap, HttpRequest.PHONE_IMEI, cVar.f44308i);
            a(hashMap, HttpRequest.CLIENT_ID, cVar.f44305f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, cVar.j);
            a(hashMap, "from", cVar.f44303d);
            a(hashMap, "net_type", cVar.p);
            a(hashMap, "cuid", cVar.f44306g);
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
            a(hashMap, IAdRequestParam.ANDROID_ID, cVar.v);
            a(hashMap, "utbrand", cVar.w);
            a(hashMap, "baiduapppb_ut", cVar.x);
            a(hashMap, com.alipay.sdk.cons.b.f1841b, cVar.y);
            a(hashMap, "active_timestamp", cVar.A);
            a(hashMap, "first_install_time", cVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, cVar.C);
            a(hashMap, "event_day", cVar.D);
            return hashMap;
        }
        return (HashMap) invokeLZ.objValue;
    }
}
