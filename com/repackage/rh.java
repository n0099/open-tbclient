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
public class rh {
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

    public static String c(zg zgVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zgVar)) == null) {
            if (zgVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(zgVar.a, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(zgVar.b, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(zgVar.c, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(zgVar.q, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(zgVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(zgVar.d, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(zgVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(zgVar.e, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(zgVar.k, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(zgVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(zgVar.l, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(zgVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(zgVar.f, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(zgVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(zgVar.i, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(zgVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(zgVar.m, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(zgVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(zgVar.g, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(zgVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(zgVar.h, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(zgVar.o, IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, zg zgVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, zgVar)) == null) {
            if (zgVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", zgVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, zgVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, zgVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, zgVar.j, z);
            b(sb, HttpConstants.OS_VERSION, zgVar.q, z);
            b(sb, "from", zgVar.d, z);
            b(sb, "cfrom", zgVar.e, z);
            b(sb, "net_type", zgVar.p, z);
            b(sb, "cuid", zgVar.g, z);
            b(sb, "model", zgVar.k, z);
            if (TextUtils.isEmpty(zgVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", zgVar.l, z);
            }
            b(sb, "un", zgVar.m, z);
            b(sb, "utbrand", zgVar.w, z);
            b(sb, "cuid_galaxy2", zgVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(fh fhVar, zg zgVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fhVar, zgVar)) == null) {
            if (fhVar.p() != null && (fhVar.p().equals("omp") || fhVar.p().equals("mon"))) {
                return c(zgVar);
            }
            return d(true, zgVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, zg zgVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, zgVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", zgVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, zgVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, zgVar.j);
            a(hashMap, "from", zgVar.d);
            a(hashMap, "net_type", zgVar.p);
            a(hashMap, "cuid", zgVar.g);
            a(hashMap, "cuid_galaxy2", zgVar.h);
            a(hashMap, "model", zgVar.k);
            if (TextUtils.isEmpty(zgVar.l)) {
                zgVar.l = "0";
            }
            a(hashMap, "uid", zgVar.l);
            a(hashMap, "un", zgVar.m);
            a(hashMap, HttpRequest.BDUSS, zgVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", zgVar.r);
            a(hashMap, "cua", zgVar.s);
            a(hashMap, TiebaStatic.Params.BDID, zgVar.z);
            a(hashMap, "cookie", zgVar.n);
            a(hashMap, "oaid", zgVar.t);
            a(hashMap, "utbrand", zgVar.w);
            a(hashMap, "baiduapppb_ut", zgVar.x);
            a(hashMap, HttpRequest.USER_AGENT, zgVar.y);
            a(hashMap, "active_timestamp", zgVar.A);
            a(hashMap, "first_install_time", zgVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, zgVar.C);
            a(hashMap, "event_day", zgVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            } else {
                a(hashMap, "mac", zgVar.u);
                a(hashMap, HttpRequest.ANDROID_ID, zgVar.v);
                a(hashMap, HttpRequest.PHONE_IMEI, zgVar.i);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
