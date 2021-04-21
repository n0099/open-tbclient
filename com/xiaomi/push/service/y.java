package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.db.ChatMessageDBManager;
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
/* loaded from: classes7.dex */
public final class y {
    public static fa a(XMPushService xMPushService, byte[] bArr) {
        ib ibVar = new ib();
        try {
            ip.a(ibVar, bArr);
            return a(m.a((Context) xMPushService), xMPushService, ibVar);
        } catch (iv e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    public static fa a(l lVar, Context context, ib ibVar) {
        try {
            fa faVar = new fa();
            faVar.a(5);
            faVar.c(lVar.f959a);
            faVar.b(a(ibVar));
            faVar.a("SECMSG", "message");
            String str = lVar.f959a;
            ibVar.f630a.f555a = str.substring(0, str.indexOf("@"));
            ibVar.f630a.f559c = str.substring(str.indexOf("/") + 1);
            faVar.a(ip.a(ibVar), lVar.f41430c);
            faVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m55a("try send mi push message. packagename:" + ibVar.f635b + " action:" + ibVar.f628a);
            return faVar;
        } catch (NullPointerException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    public static ib a(String str, String str2) {
        ie ieVar = new ie();
        ieVar.b(str2);
        ieVar.c("package uninstalled");
        ieVar.a(gc.i());
        ieVar.a(false);
        return a(str, str2, ieVar, hf.Notification);
    }

    public static <T extends iq<T, ?>> ib a(String str, String str2, T t, hf hfVar) {
        return a(str, str2, t, hfVar, true);
    }

    public static <T extends iq<T, ?>> ib a(String str, String str2, T t, hf hfVar, boolean z) {
        byte[] a2 = ip.a(t);
        ib ibVar = new ib();
        hu huVar = new hu();
        huVar.f554a = 5L;
        huVar.f555a = "fakeid";
        ibVar.a(huVar);
        ibVar.a(ByteBuffer.wrap(a2));
        ibVar.a(hfVar);
        ibVar.b(z);
        ibVar.b(str);
        ibVar.a(false);
        ibVar.a(str2);
        return ibVar;
    }

    public static String a(ib ibVar) {
        Map<String, String> map;
        hs hsVar = ibVar.f629a;
        if (hsVar != null && (map = hsVar.f545b) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return ibVar.f635b;
    }

    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    public static void a(XMPushService xMPushService) {
        l a2 = m.a(xMPushService.getApplicationContext());
        if (a2 != null) {
            av.b a3 = m.a(xMPushService.getApplicationContext()).a(xMPushService);
            a(xMPushService, a3);
            av.a().a(a3);
            bk.a(xMPushService).a(new z("GAID", ChatMessageDBManager.CAST_RELIABLE_MSG_EXPIRED_TIME, xMPushService, a2));
            a(xMPushService, a2, 172800);
        }
    }

    public static void a(XMPushService xMPushService, ib ibVar) {
        cy.a(ibVar.b(), xMPushService.getApplicationContext(), ibVar, -1);
        fl m545a = xMPushService.m545a();
        if (m545a == null) {
            throw new fw("try send msg while connection is null.");
        }
        if (!m545a.m308a()) {
            throw new fw("Don't support XMPP connection.");
        }
        fa a2 = a(m.a((Context) xMPushService), xMPushService, ibVar);
        if (a2 != null) {
            m545a.b(a2);
        }
    }

    public static void a(XMPushService xMPushService, av.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new ab(xMPushService));
    }

    public static void a(XMPushService xMPushService, l lVar, int i) {
        bk.a(xMPushService).a(new aa("MSAID", i, xMPushService, lVar));
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        cy.a(str, xMPushService.getApplicationContext(), bArr);
        fl m545a = xMPushService.m545a();
        if (m545a == null) {
            throw new fw("try send msg while connection is null.");
        }
        if (!m545a.m308a()) {
            throw new fw("Don't support XMPP connection.");
        }
        fa a2 = a(xMPushService, bArr);
        if (a2 != null) {
            m545a.b(a2);
        } else {
            p.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }

    public static <T extends iq<T, ?>> ib b(String str, String str2, T t, hf hfVar) {
        return a(str, str2, t, hfVar, false);
    }
}
