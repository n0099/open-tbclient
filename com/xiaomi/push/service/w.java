package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.df;
import com.xiaomi.push.fl;
import com.xiaomi.push.fs;
import com.xiaomi.push.gd;
import com.xiaomi.push.gj;
import com.xiaomi.push.hm;
import com.xiaomi.push.ib;
import com.xiaomi.push.ii;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.jc;
import com.xiaomi.push.service.ap;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class w {
    static fl a(XMPushService xMPushService, byte[] bArr) {
        ii iiVar = new ii();
        try {
            iw.a(iiVar, bArr);
            return a(l.a((Context) xMPushService), xMPushService, iiVar);
        } catch (jc e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    static fl a(k kVar, Context context, ii iiVar) {
        try {
            fl flVar = new fl();
            flVar.a(5);
            flVar.c(kVar.f995a);
            flVar.b(a(iiVar));
            flVar.a("SECMSG", "message");
            String str = kVar.f995a;
            iiVar.f680a.f607a = str.substring(0, str.indexOf("@"));
            iiVar.f680a.f611c = str.substring(str.indexOf("/") + 1);
            flVar.a(iw.a(iiVar), kVar.c);
            flVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m84a("try send mi push message. packagename:" + iiVar.f685b + " action:" + iiVar.f678a);
            return flVar;
        } catch (NullPointerException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ii a(String str, String str2) {
        il ilVar = new il();
        ilVar.b(str2);
        ilVar.c("package uninstalled");
        ilVar.a(gj.i());
        ilVar.a(false);
        return a(str, str2, ilVar, hm.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends ix<T, ?>> ii a(String str, String str2, T t, hm hmVar) {
        byte[] a2 = iw.a(t);
        ii iiVar = new ii();
        ib ibVar = new ib();
        ibVar.f606a = 5L;
        ibVar.f607a = "fakeid";
        iiVar.a(ibVar);
        iiVar.a(ByteBuffer.wrap(a2));
        iiVar.a(hmVar);
        iiVar.b(true);
        iiVar.b(str);
        iiVar.a(false);
        iiVar.a(str2);
        return iiVar;
    }

    private static String a(ii iiVar) {
        if (iiVar.f679a != null && iiVar.f679a.f595b != null) {
            String str = iiVar.f679a.f595b.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return iiVar.f685b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService) {
        k a2 = l.a(xMPushService.getApplicationContext());
        if (a2 != null) {
            ap.b a3 = l.a(xMPushService.getApplicationContext()).a(xMPushService);
            a(xMPushService, a3);
            ap.a().a(a3);
            bg.a(xMPushService).a(new x("GAID", 172800L, xMPushService, a2));
            a(xMPushService, a2, 172800);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, ii iiVar) {
        df.a(iiVar.b(), xMPushService.getApplicationContext(), iiVar, -1);
        fs m549a = xMPushService.m549a();
        if (m549a == null) {
            throw new gd("try send msg while connection is null.");
        }
        if (!m549a.m325a()) {
            throw new gd("Don't support XMPP connection.");
        }
        fl a2 = a(l.a((Context) xMPushService), xMPushService, iiVar);
        if (a2 != null) {
            m549a.b(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, ap.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new z(xMPushService));
    }

    private static void a(XMPushService xMPushService, k kVar, int i) {
        bg.a(xMPushService).a(new y("MSAID", i, xMPushService, kVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        df.a(str, xMPushService.getApplicationContext(), bArr);
        fs m549a = xMPushService.m549a();
        if (m549a == null) {
            throw new gd("try send msg while connection is null.");
        }
        if (!m549a.m325a()) {
            throw new gd("Don't support XMPP connection.");
        }
        fl a2 = a(xMPushService, bArr);
        if (a2 != null) {
            m549a.b(a2);
        } else {
            o.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }
}
