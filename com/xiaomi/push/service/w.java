package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.baidu.searchbox.ugc.model.UgcConstant;
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
/* loaded from: classes8.dex */
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
            flVar.c(kVar.f921a);
            flVar.b(a(iiVar));
            flVar.a("SECMSG", "message");
            String str = kVar.f921a;
            iiVar.f606a.f533a = str.substring(0, str.indexOf(UgcConstant.AT_RULE_TAG));
            iiVar.f606a.f537c = str.substring(str.indexOf("/") + 1);
            flVar.a(iw.a(iiVar), kVar.c);
            flVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m48a("try send mi push message. packagename:" + iiVar.f611b + " action:" + iiVar.f604a);
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
        byte[] a = iw.a(t);
        ii iiVar = new ii();
        ib ibVar = new ib();
        ibVar.f532a = 5L;
        ibVar.f533a = "fakeid";
        iiVar.a(ibVar);
        iiVar.a(ByteBuffer.wrap(a));
        iiVar.a(hmVar);
        iiVar.b(true);
        iiVar.b(str);
        iiVar.a(false);
        iiVar.a(str2);
        return iiVar;
    }

    private static String a(ii iiVar) {
        if (iiVar.f605a != null && iiVar.f605a.f521b != null) {
            String str = iiVar.f605a.f521b.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return iiVar.f611b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService) {
        k a = l.a(xMPushService.getApplicationContext());
        if (a != null) {
            ap.b a2 = l.a(xMPushService.getApplicationContext()).a(xMPushService);
            a(xMPushService, a2);
            ap.a().a(a2);
            bg.a(xMPushService).a(new x("GAID", 172800L, xMPushService, a));
            a(xMPushService, a, 172800);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, ii iiVar) {
        df.a(iiVar.b(), xMPushService.getApplicationContext(), iiVar, -1);
        fs m513a = xMPushService.m513a();
        if (m513a == null) {
            throw new gd("try send msg while connection is null.");
        }
        if (!m513a.m289a()) {
            throw new gd("Don't support XMPP connection.");
        }
        fl a = a(l.a((Context) xMPushService), xMPushService, iiVar);
        if (a != null) {
            m513a.b(a);
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
        fs m513a = xMPushService.m513a();
        if (m513a == null) {
            throw new gd("try send msg while connection is null.");
        }
        if (!m513a.m289a()) {
            throw new gd("Don't support XMPP connection.");
        }
        fl a = a(xMPushService, bArr);
        if (a != null) {
            m513a.b(a);
        } else {
            o.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }
}
