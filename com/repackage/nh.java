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
public class nh {
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

    public static String c(vg vgVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, vgVar)) == null) {
            if (vgVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            try {
                sb.append("product");
                sb.append("=");
                sb.append(URLEncoder.encode(vgVar.a, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("sub_sys");
                sb.append("=");
                sb.append(URLEncoder.encode(vgVar.b, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("version");
                sb.append("=");
                sb.append(URLEncoder.encode(vgVar.c, IMAudioTransRequest.CHARSET));
                sb.append("&");
                sb.append("os");
                sb.append("=");
                sb.append("android");
                sb.append("&");
                sb.append(HttpConstants.OS_VERSION);
                sb.append("=");
                sb.append(URLEncoder.encode(vgVar.q, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(vgVar.d)) {
                    sb.append("&");
                    sb.append("from");
                    sb.append("=");
                    sb.append(URLEncoder.encode(vgVar.d, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(vgVar.e)) {
                    sb.append("&");
                    sb.append("cfrom");
                    sb.append("=");
                    sb.append(URLEncoder.encode(vgVar.e, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("phone");
                sb.append("=");
                sb.append(URLEncoder.encode(vgVar.k, IMAudioTransRequest.CHARSET));
                if (!TextUtils.isEmpty(vgVar.l)) {
                    sb.append("&");
                    sb.append("uid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(vgVar.l, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(vgVar.f)) {
                    sb.append("&");
                    sb.append("client_id");
                    sb.append("=");
                    sb.append(URLEncoder.encode(vgVar.f, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(vgVar.i)) {
                    sb.append("&");
                    sb.append("imei");
                    sb.append("=");
                    sb.append(URLEncoder.encode(vgVar.i, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(vgVar.m)) {
                    sb.append("&");
                    sb.append("uname");
                    sb.append("=");
                    sb.append(URLEncoder.encode(vgVar.m, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(vgVar.g)) {
                    sb.append("&");
                    sb.append("cuid");
                    sb.append("=");
                    sb.append(URLEncoder.encode(vgVar.g, IMAudioTransRequest.CHARSET));
                }
                if (!TextUtils.isEmpty(vgVar.h)) {
                    sb.append("&");
                    sb.append("cuid_galaxy2");
                    sb.append("=");
                    sb.append(URLEncoder.encode(vgVar.h, IMAudioTransRequest.CHARSET));
                }
                sb.append("&");
                sb.append("net");
                sb.append("=");
                sb.append(URLEncoder.encode(vgVar.o, IMAudioTransRequest.CHARSET));
            } catch (UnsupportedEncodingException e) {
                BdLog.e(e);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(boolean z, vg vgVar) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65539, null, z, vgVar)) == null) {
            if (vgVar == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("_client_type=2");
            b(sb, "_client_version", vgVar.c, z);
            b(sb, HttpRequest.PHONE_IMEI, vgVar.i, z);
            b(sb, HttpRequest.CLIENT_ID, vgVar.f, z);
            b(sb, HttpRequest.SUBAPP_TYPE, vgVar.j, z);
            b(sb, HttpConstants.OS_VERSION, vgVar.q, z);
            b(sb, "from", vgVar.d, z);
            b(sb, "cfrom", vgVar.e, z);
            b(sb, "net_type", vgVar.p, z);
            b(sb, "cuid", vgVar.g, z);
            b(sb, "model", vgVar.k, z);
            if (TextUtils.isEmpty(vgVar.l)) {
                b(sb, "uid", "0", z);
            } else {
                b(sb, "uid", vgVar.l, z);
            }
            b(sb, "un", vgVar.m, z);
            b(sb, "utbrand", vgVar.w, z);
            b(sb, "cuid_galaxy2", vgVar.h, z);
            return sb.toString();
        }
        return (String) invokeZL.objValue;
    }

    public static String e(bh bhVar, vg vgVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bhVar, vgVar)) == null) {
            if (bhVar.p() != null && (bhVar.p().equals("omp") || bhVar.p().equals("mon"))) {
                return c(vgVar);
            }
            return d(true, vgVar);
        }
        return (String) invokeLL.objValue;
    }

    public static HashMap<String, Object> f(String str, vg vgVar, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65541, null, str, vgVar, z)) == null) {
            HashMap<String, Object> hashMap = new HashMap<>();
            a(hashMap, HttpRequest.CLIENT_TYPE, "2");
            a(hashMap, "_client_version", vgVar.c);
            a(hashMap, HttpRequest.CLIENT_ID, vgVar.f);
            a(hashMap, HttpRequest.SUBAPP_TYPE, vgVar.j);
            a(hashMap, "from", vgVar.d);
            a(hashMap, "net_type", vgVar.p);
            a(hashMap, "cuid", vgVar.g);
            a(hashMap, "cuid_galaxy2", vgVar.h);
            a(hashMap, "model", vgVar.k);
            if (TextUtils.isEmpty(vgVar.l)) {
                vgVar.l = "0";
            }
            a(hashMap, "uid", vgVar.l);
            a(hashMap, "un", vgVar.m);
            a(hashMap, HttpRequest.BDUSS, vgVar.n);
            if (z) {
                a(hashMap, "find_bug", "2");
            } else {
                a(hashMap, "find_bug", "0");
            }
            a(hashMap, "sz", vgVar.r);
            a(hashMap, "cua", vgVar.s);
            a(hashMap, TiebaStatic.Params.BDID, vgVar.z);
            a(hashMap, "cookie", vgVar.n);
            a(hashMap, "oaid", vgVar.t);
            a(hashMap, "utbrand", vgVar.w);
            a(hashMap, "baiduapppb_ut", vgVar.x);
            a(hashMap, HttpRequest.USER_AGENT, vgVar.y);
            a(hashMap, "active_timestamp", vgVar.A);
            a(hashMap, "first_install_time", vgVar.B);
            a(hashMap, TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, vgVar.C);
            a(hashMap, "event_day", vgVar.D);
            if (((Boolean) MessageManager.getInstance().runTask(2000985, Boolean.class, str).getData()).booleanValue()) {
                MessageManager.getInstance().runTask(2000984, HashMap.class, hashMap);
            } else {
                a(hashMap, "mac", vgVar.u);
                a(hashMap, HttpRequest.ANDROID_ID, vgVar.v);
                a(hashMap, HttpRequest.PHONE_IMEI, vgVar.i);
            }
            return hashMap;
        }
        return (HashMap) invokeLLZ.objValue;
    }
}
