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
/* loaded from: classes6.dex */
public class ph {
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

    public static String c(xg xgVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, xgVar)) == null) {
            if (xgVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(xgVar.a, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(xgVar.b, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(xgVar.c, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(xgVar.q, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(xgVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(xgVar.d, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(xgVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(xgVar.e, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(xgVar.k, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(xgVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(xgVar.l, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(xgVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(xgVar.f, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(xgVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(xgVar.i, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(xgVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(xgVar.m, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(xgVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(xgVar.g, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(xgVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(xgVar.h, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(xgVar.o, IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, xg xgVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, xgVar)) == null) {
            if (xgVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", xgVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, xgVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, xgVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, xgVar.j, z);
            b(sb, HttpConstants.OS_VERSION, xgVar.q, z);
            b(sb, "from", xgVar.d, z);
            b(sb, "cfrom", xgVar.e, z);
            b(sb, "net_type", xgVar.p, z);
            b(sb, "cuid", xgVar.g, z);
            b(sb, "model", xgVar.k, z);
            if (TextUtils.isEmpty(xgVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", xgVar.l, z);
            }
            b(sb, "un", xgVar.m, z);
            b(sb, "utbrand", xgVar.w, z);
            b(sb, "cuid_galaxy2", xgVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(dh dhVar, xg xgVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, dhVar, xgVar)) == null) {
            if (dhVar.p() != null && (dhVar.p().equals("omp") || dhVar.p().equals("mon"))) {
                return c(xgVar);
            }
            return d(true, xgVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, xg xgVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, xgVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", xgVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, xgVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, xgVar.j);
            a(hashMap, "from", xgVar.d);
            a(hashMap, "net_type", xgVar.p);
            a(hashMap, "cuid", xgVar.g);
            a(hashMap, "cuid_galaxy2", xgVar.h);
            a(hashMap, "model", xgVar.k);
            if (TextUtils.isEmpty(xgVar.l)) {
                xgVar.l = "0";
            }
            a(hashMap, "uid", xgVar.l);
            a(hashMap, "un", xgVar.m);
            a(hashMap, HttpRequest.BDUSS, xgVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", xgVar.r);
            a(hashMap, "cua", xgVar.s);
            a(hashMap, TiebaStatic.Params.BDID, xgVar.z);
            a(hashMap, "cookie", xgVar.n);
            a(hashMap, "oaid", xgVar.t);
            a(hashMap, "utbrand", xgVar.w);
            a(hashMap, "baiduapppb_ut", xgVar.x);
            a(hashMap, HttpRequest.USER_AGENT, xgVar.y);
            a(hashMap, "active_timestamp", xgVar.A);
            a(hashMap, "first_install_time", xgVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, xgVar.C);
            a(hashMap, "event_day", xgVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            } else {
                a(hashMap, "mac", xgVar.u);
                a(hashMap, HttpRequest.ANDROID_ID, xgVar.v);
                a(hashMap, HttpRequest.PHONE_IMEI, xgVar.i);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
