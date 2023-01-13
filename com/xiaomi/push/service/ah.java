package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.Cif;
import com.xiaomi.push.db;
import com.xiaomi.push.fl;
import com.xiaomi.push.fw;
import com.xiaomi.push.gh;
import com.xiaomi.push.gn;
import com.xiaomi.push.hj;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.hy;
import com.xiaomi.push.ii;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.iz;
import com.xiaomi.push.service.bg;
import java.nio.ByteBuffer;
import java.util.Map;
/* loaded from: classes8.dex */
public final class ah {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static fl a(XMPushService xMPushService, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, xMPushService, bArr)) == null) {
            Cif cif = new Cif();
            try {
                it.a(cif, bArr);
                return a(u.m754a((Context) xMPushService), xMPushService, cif);
            } catch (iz e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            }
        }
        return (fl) invokeLL.objValue;
    }

    public static fl a(t tVar, Context context, Cif cif) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, tVar, context, cif)) == null) {
            try {
                fl flVar = new fl();
                flVar.a(5);
                flVar.c(tVar.f1028a);
                flVar.b(a(cif));
                flVar.a("SECMSG", "message");
                String str = tVar.f1028a;
                cif.f651a.f578a = str.substring(0, str.indexOf("@"));
                cif.f651a.f582c = str.substring(str.indexOf("/") + 1);
                flVar.a(it.a(cif), tVar.c);
                flVar.a((short) 1);
                com.xiaomi.channel.commonutils.logger.b.m103a("try send mi push message. packagename:" + cif.f656b + " action:" + cif.f649a);
                return flVar;
            } catch (NullPointerException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            }
        }
        return (fl) invokeLLL.objValue;
    }

    public static Cif a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            ii iiVar = new ii();
            iiVar.b(str2);
            iiVar.c("package uninstalled");
            iiVar.a(gn.i());
            iiVar.a(false);
            return a(str, str2, iiVar, hj.i);
        }
        return (Cif) invokeLL.objValue;
    }

    public static <T extends iu<T, ?>> Cif a(String str, String str2, T t, hj hjVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, str2, t, hjVar)) == null) ? a(str, str2, t, hjVar, true) : (Cif) invokeLLLL.objValue;
    }

    public static <T extends iu<T, ?>> Cif a(String str, String str2, T t, hj hjVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, t, hjVar, Boolean.valueOf(z)})) == null) {
            byte[] a = it.a(t);
            Cif cif = new Cif();
            hy hyVar = new hy();
            hyVar.f577a = 5L;
            hyVar.f578a = "fakeid";
            cif.a(hyVar);
            cif.a(ByteBuffer.wrap(a));
            cif.a(hjVar);
            cif.b(z);
            cif.b(str);
            cif.a(false);
            cif.a(str2);
            return cif;
        }
        return (Cif) invokeCommon.objValue;
    }

    public static String a(Cif cif) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, cif)) == null) {
            hw hwVar = cif.f650a;
            if (hwVar != null && (map = hwVar.f568b) != null) {
                String str = map.get("ext_traffic_source_pkg");
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
            return cif.f656b;
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            return str + ".permission.MIPUSH_RECEIVE";
        }
        return (String) invokeL.objValue;
    }

    public static void a(XMPushService xMPushService) {
        t m754a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, xMPushService) == null) || (m754a = u.m754a(xMPushService.getApplicationContext())) == null) {
            return;
        }
        bg.b a = u.m754a(xMPushService.getApplicationContext()).a(xMPushService);
        com.xiaomi.channel.commonutils.logger.b.m103a("prepare account. " + a.f957a);
        a(xMPushService, a);
        bg.a().a(a);
        bx.a(xMPushService).a(new ai("GAID", ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME, xMPushService, m754a));
        a(xMPushService, m754a, 172800);
    }

    public static void a(XMPushService xMPushService, Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, xMPushService, cif) == null) {
            db.a(cif.b(), xMPushService.getApplicationContext(), cif, -1);
            fw m663a = xMPushService.m663a();
            if (m663a == null) {
                throw new gh("try send msg while connection is null.");
            }
            if (!m663a.mo418a()) {
                throw new gh("Don't support XMPP connection.");
            }
            fl a = a(u.m754a((Context) xMPushService), xMPushService, cif);
            if (a != null) {
                m663a.b(a);
            }
        }
    }

    public static void a(XMPushService xMPushService, bg.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, xMPushService, bVar) == null) {
            bVar.a((Messenger) null);
            bVar.a(new ak(xMPushService));
        }
    }

    public static void a(XMPushService xMPushService, t tVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65546, null, xMPushService, tVar, i) == null) {
            bx.a(xMPushService).a(new aj("MSAID", i, xMPushService, tVar));
        }
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, xMPushService, str, bArr) == null) {
            db.a(str, xMPushService.getApplicationContext(), bArr);
            fw m663a = xMPushService.m663a();
            if (m663a == null) {
                throw new gh("try send msg while connection is null.");
            }
            if (!m663a.mo418a()) {
                throw new gh("Don't support XMPP connection.");
            }
            fl a = a(xMPushService, bArr);
            if (a != null) {
                m663a.b(a);
            } else {
                x.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
            }
        }
    }

    public static Cif b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, str2)) == null) {
            ii iiVar = new ii();
            iiVar.b(str2);
            iiVar.c(ht.ac.f529a);
            iiVar.a(bd.a());
            iiVar.a(false);
            return a(str, str2, iiVar, hj.i);
        }
        return (Cif) invokeLL.objValue;
    }

    public static <T extends iu<T, ?>> Cif b(String str, String str2, T t, hj hjVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65549, null, str, str2, t, hjVar)) == null) ? a(str, str2, t, hjVar, false) : (Cif) invokeLLLL.objValue;
    }
}
