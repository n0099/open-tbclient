package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.component.net.tnc.TNCManager;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.cy;
import com.xiaomi.push.fa;
import com.xiaomi.push.fl;
import com.xiaomi.push.fw;
import com.xiaomi.push.gc;
import com.xiaomi.push.hf;
import com.xiaomi.push.hs;
import com.xiaomi.push.hu;
import com.xiaomi.push.ib;
import com.xiaomi.push.ie;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.iv;
import com.xiaomi.push.service.av;
import java.nio.ByteBuffer;
import java.util.Map;
/* loaded from: classes10.dex */
public final class y {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static fa a(XMPushService xMPushService, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, xMPushService, bArr)) == null) {
            ib ibVar = new ib();
            try {
                ip.a(ibVar, bArr);
                return a(m.a((Context) xMPushService), xMPushService, ibVar);
            } catch (iv e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return null;
            }
        }
        return (fa) invokeLL.objValue;
    }

    public static fa a(l lVar, Context context, ib ibVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, lVar, context, ibVar)) == null) {
            try {
                fa faVar = new fa();
                faVar.a(5);
                faVar.c(lVar.f966a);
                faVar.b(a(ibVar));
                faVar.a("SECMSG", "message");
                String str = lVar.f966a;
                ibVar.f637a.f562a = str.substring(0, str.indexOf(TNCManager.TNC_PROBE_HEADER_SECEPTOR));
                ibVar.f637a.f566c = str.substring(str.indexOf("/") + 1);
                faVar.a(ip.a(ibVar), lVar.f78537c);
                faVar.a((short) 1);
                com.xiaomi.channel.commonutils.logger.b.m73a("try send mi push message. packagename:" + ibVar.f642b + " action:" + ibVar.f635a);
                return faVar;
            } catch (NullPointerException e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                return null;
            }
        }
        return (fa) invokeLLL.objValue;
    }

    public static ib a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            ie ieVar = new ie();
            ieVar.b(str2);
            ieVar.c("package uninstalled");
            ieVar.a(gc.i());
            ieVar.a(false);
            return a(str, str2, ieVar, hf.f78089i);
        }
        return (ib) invokeLL.objValue;
    }

    public static <T extends iq<T, ?>> ib a(String str, String str2, T t, hf hfVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65539, null, str, str2, t, hfVar)) == null) ? a(str, str2, t, hfVar, true) : (ib) invokeLLLL.objValue;
    }

    public static <T extends iq<T, ?>> ib a(String str, String str2, T t, hf hfVar, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, t, hfVar, Boolean.valueOf(z)})) == null) {
            byte[] a2 = ip.a(t);
            ib ibVar = new ib();
            hu huVar = new hu();
            huVar.f561a = 5L;
            huVar.f562a = "fakeid";
            ibVar.a(huVar);
            ibVar.a(ByteBuffer.wrap(a2));
            ibVar.a(hfVar);
            ibVar.b(z);
            ibVar.b(str);
            ibVar.a(false);
            ibVar.a(str2);
            return ibVar;
        }
        return (ib) invokeCommon.objValue;
    }

    public static String a(ib ibVar) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, ibVar)) == null) {
            hs hsVar = ibVar.f636a;
            if (hsVar != null && (map = hsVar.f552b) != null) {
                String str = map.get("ext_traffic_source_pkg");
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
            return ibVar.f642b;
        }
        return (String) invokeL.objValue;
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) {
            return str + ".permission.MIPUSH_RECEIVE";
        }
        return (String) invokeL.objValue;
    }

    public static void a(XMPushService xMPushService) {
        l a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, xMPushService) == null) || (a2 = m.a(xMPushService.getApplicationContext())) == null) {
            return;
        }
        av.b a3 = m.a(xMPushService.getApplicationContext()).a(xMPushService);
        a(xMPushService, a3);
        av.a().a(a3);
        bk.a(xMPushService).a(new z("GAID", ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME, xMPushService, a2));
        a(xMPushService, a2, 172800);
    }

    public static void a(XMPushService xMPushService, ib ibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, xMPushService, ibVar) == null) {
            cy.a(ibVar.b(), xMPushService.getApplicationContext(), ibVar, -1);
            fl m563a = xMPushService.m563a();
            if (m563a == null) {
                throw new fw("try send msg while connection is null.");
            }
            if (!m563a.m326a()) {
                throw new fw("Don't support XMPP connection.");
            }
            fa a2 = a(m.a((Context) xMPushService), xMPushService, ibVar);
            if (a2 != null) {
                m563a.b(a2);
            }
        }
    }

    public static void a(XMPushService xMPushService, av.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, xMPushService, bVar) == null) {
            bVar.a((Messenger) null);
            bVar.a(new ab(xMPushService));
        }
    }

    public static void a(XMPushService xMPushService, l lVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65546, null, xMPushService, lVar, i2) == null) {
            bk.a(xMPushService).a(new aa("MSAID", i2, xMPushService, lVar));
        }
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, xMPushService, str, bArr) == null) {
            cy.a(str, xMPushService.getApplicationContext(), bArr);
            fl m563a = xMPushService.m563a();
            if (m563a == null) {
                throw new fw("try send msg while connection is null.");
            }
            if (!m563a.m326a()) {
                throw new fw("Don't support XMPP connection.");
            }
            fa a2 = a(xMPushService, bArr);
            if (a2 != null) {
                m563a.b(a2);
            } else {
                p.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
            }
        }
    }

    public static <T extends iq<T, ?>> ib b(String str, String str2, T t, hf hfVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65548, null, str, str2, t, hfVar)) == null) ? a(str, str2, t, hfVar, false) : (ib) invokeLLLL.objValue;
    }
}
