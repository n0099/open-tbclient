package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.Cif;
import com.xiaomi.push.da;
import com.xiaomi.push.ff;
import com.xiaomi.push.fm;
import com.xiaomi.push.fx;
import com.xiaomi.push.gd;
import com.xiaomi.push.hg;
import com.xiaomi.push.hv;
import com.xiaomi.push.ic;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import com.xiaomi.push.iw;
import com.xiaomi.push.service.al;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public final class w {
    static ff a(XMPushService xMPushService, byte[] bArr) {
        ic icVar = new ic();
        try {
            iq.a(icVar, bArr);
            return a(l.a((Context) xMPushService), xMPushService, icVar);
        } catch (iw e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    static ff a(k kVar, Context context, ic icVar) {
        try {
            ff ffVar = new ff();
            ffVar.a(5);
            ffVar.c(kVar.f916a);
            ffVar.b(a(icVar));
            ffVar.a("SECMSG", "message");
            String str = kVar.f916a;
            icVar.f612a.f538a = str.substring(0, str.indexOf("@"));
            icVar.f612a.f542c = str.substring(str.indexOf("/") + 1);
            ffVar.a(iq.a(icVar), kVar.c);
            ffVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m47a("try send mi push message. packagename:" + icVar.f617b + " action:" + icVar.f610a);
            return ffVar;
        } catch (NullPointerException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ic a(String str, String str2) {
        Cif cif = new Cif();
        cif.b(str2);
        cif.c("package uninstalled");
        cif.a(gd.i());
        cif.a(false);
        return a(str, str2, cif, hg.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends ir<T, ?>> ic a(String str, String str2, T t, hg hgVar) {
        byte[] a = iq.a(t);
        ic icVar = new ic();
        hv hvVar = new hv();
        hvVar.f537a = 5L;
        hvVar.f538a = "fakeid";
        icVar.a(hvVar);
        icVar.a(ByteBuffer.wrap(a));
        icVar.a(hgVar);
        icVar.b(true);
        icVar.b(str);
        icVar.a(false);
        icVar.a(str2);
        return icVar;
    }

    private static String a(ic icVar) {
        if (icVar.f611a != null && icVar.f611a.f528b != null) {
            String str = icVar.f611a.f528b.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return icVar.f617b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService) {
        k a = l.a(xMPushService.getApplicationContext());
        if (a != null) {
            al.b a2 = l.a(xMPushService.getApplicationContext()).a(xMPushService);
            a(xMPushService, a2);
            al.a().a(a2);
            bc.a(xMPushService).a(new x("GAID", 172800L, xMPushService, a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, ic icVar) {
        da.a(icVar.b(), xMPushService.getApplicationContext(), icVar, -1);
        fm m499a = xMPushService.m499a();
        if (m499a == null) {
            throw new fx("try send msg while connection is null.");
        }
        if (!m499a.m284a()) {
            throw new fx("Don't support XMPP connection.");
        }
        ff a = a(l.a((Context) xMPushService), xMPushService, icVar);
        if (a != null) {
            m499a.b(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, al.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new y(xMPushService));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        da.a(str, xMPushService.getApplicationContext(), bArr);
        fm m499a = xMPushService.m499a();
        if (m499a == null) {
            throw new fx("try send msg while connection is null.");
        }
        if (!m499a.m284a()) {
            throw new fx("Don't support XMPP connection.");
        }
        ff a = a(xMPushService, bArr);
        if (a != null) {
            m499a.b(a);
        } else {
            o.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }
}
