package com.repackage;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class qh {
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
                str2 = URLEncoder.encode(str2, IMAudioTransRequest.CHARSET);
            }
            sb.append(str2);
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    public static String c(yg ygVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ygVar)) == null) {
            if (ygVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(ygVar.a, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(ygVar.b, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(ygVar.c, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(ygVar.q, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(ygVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ygVar.d, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ygVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ygVar.e, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(ygVar.k, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(ygVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ygVar.l, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ygVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ygVar.f, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ygVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ygVar.i, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ygVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ygVar.m, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ygVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ygVar.g, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ygVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ygVar.h, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(ygVar.o, IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, yg ygVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, ygVar)) == null) {
            if (ygVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", ygVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, ygVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, ygVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, ygVar.j, z);
            b(sb, HttpConstants.OS_VERSION, ygVar.q, z);
            b(sb, "from", ygVar.d, z);
            b(sb, "cfrom", ygVar.e, z);
            b(sb, "net_type", ygVar.p, z);
            b(sb, "cuid", ygVar.g, z);
            b(sb, "model", ygVar.k, z);
            if (TextUtils.isEmpty(ygVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", ygVar.l, z);
            }
            b(sb, "un", ygVar.m, z);
            b(sb, "utbrand", ygVar.w, z);
            b(sb, "cuid_galaxy2", ygVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(eh ehVar, yg ygVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ehVar, ygVar)) == null) {
            if (ehVar.p() != null && (ehVar.p().equals("omp") || ehVar.p().equals("mon"))) {
                return c(ygVar);
            }
            return d(true, ygVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, yg ygVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, ygVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", ygVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, ygVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, ygVar.j);
            a(hashMap, "from", ygVar.d);
            a(hashMap, "net_type", ygVar.p);
            a(hashMap, "cuid", ygVar.g);
            a(hashMap, "cuid_galaxy2", ygVar.h);
            a(hashMap, "model", ygVar.k);
            if (TextUtils.isEmpty(ygVar.l)) {
                ygVar.l = "0";
            }
            a(hashMap, "uid", ygVar.l);
            a(hashMap, "un", ygVar.m);
            a(hashMap, HttpRequest.BDUSS, ygVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", ygVar.r);
            a(hashMap, "cua", ygVar.s);
            a(hashMap, TiebaStatic.Params.BDID, ygVar.z);
            a(hashMap, "cookie", ygVar.n);
            a(hashMap, "oaid", ygVar.t);
            a(hashMap, "utbrand", ygVar.w);
            a(hashMap, "baiduapppb_ut", ygVar.x);
            a(hashMap, HttpRequest.USER_AGENT, ygVar.y);
            a(hashMap, "active_timestamp", ygVar.A);
            a(hashMap, "first_install_time", ygVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, ygVar.C);
            a(hashMap, "event_day", ygVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            } else {
                a(hashMap, "mac", ygVar.u);
                a(hashMap, HttpRequest.ANDROID_ID, ygVar.v);
                a(hashMap, HttpRequest.PHONE_IMEI, ygVar.i);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
