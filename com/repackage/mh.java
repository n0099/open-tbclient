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
public class mh {
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

    public static String c(ug ugVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ugVar)) == null) {
            if (ugVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(ugVar.a, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(ugVar.b, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(ugVar.c, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(ugVar.q, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(ugVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ugVar.d, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ugVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ugVar.e, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(ugVar.k, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(ugVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ugVar.l, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ugVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ugVar.f, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ugVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ugVar.i, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ugVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ugVar.m, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ugVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ugVar.g, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(ugVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(ugVar.h, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(ugVar.o, IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, ug ugVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, ugVar)) == null) {
            if (ugVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", ugVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, ugVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, ugVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, ugVar.j, z);
            b(sb, HttpConstants.OS_VERSION, ugVar.q, z);
            b(sb, "from", ugVar.d, z);
            b(sb, "cfrom", ugVar.e, z);
            b(sb, "net_type", ugVar.p, z);
            b(sb, "cuid", ugVar.g, z);
            b(sb, "model", ugVar.k, z);
            if (TextUtils.isEmpty(ugVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", ugVar.l, z);
            }
            b(sb, "un", ugVar.m, z);
            b(sb, "utbrand", ugVar.w, z);
            b(sb, "cuid_galaxy2", ugVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(ah ahVar, ug ugVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ahVar, ugVar)) == null) {
            if (ahVar.p() != null && (ahVar.p().equals("omp") || ahVar.p().equals("mon"))) {
                return c(ugVar);
            }
            return d(true, ugVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, ug ugVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, ugVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", ugVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, ugVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, ugVar.j);
            a(hashMap, "from", ugVar.d);
            a(hashMap, "net_type", ugVar.p);
            a(hashMap, "cuid", ugVar.g);
            a(hashMap, "cuid_galaxy2", ugVar.h);
            a(hashMap, "model", ugVar.k);
            if (TextUtils.isEmpty(ugVar.l)) {
                ugVar.l = "0";
            }
            a(hashMap, "uid", ugVar.l);
            a(hashMap, "un", ugVar.m);
            a(hashMap, HttpRequest.BDUSS, ugVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", ugVar.r);
            a(hashMap, "cua", ugVar.s);
            a(hashMap, TiebaStatic.Params.BDID, ugVar.z);
            a(hashMap, "cookie", ugVar.n);
            a(hashMap, "oaid", ugVar.t);
            a(hashMap, "utbrand", ugVar.w);
            a(hashMap, "baiduapppb_ut", ugVar.x);
            a(hashMap, HttpRequest.USER_AGENT, ugVar.y);
            a(hashMap, "active_timestamp", ugVar.A);
            a(hashMap, "first_install_time", ugVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, ugVar.C);
            a(hashMap, "event_day", ugVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            } else {
                a(hashMap, "mac", ugVar.u);
                a(hashMap, HttpRequest.ANDROID_ID, ugVar.v);
                a(hashMap, HttpRequest.PHONE_IMEI, ugVar.i);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
