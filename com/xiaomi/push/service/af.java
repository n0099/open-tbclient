package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.as;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class af {
    static com.xiaomi.slim.b a(XMPushService xMPushService, byte[] bArr) {
        com.xiaomi.xmpush.thrift.af afVar = new com.xiaomi.xmpush.thrift.af();
        try {
            com.xiaomi.xmpush.thrift.at.a(afVar, bArr);
            return a(t.a(xMPushService), xMPushService, afVar);
        } catch (org.apache.thrift.f e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    static com.xiaomi.slim.b a(s sVar, Context context, com.xiaomi.xmpush.thrift.af afVar) {
        try {
            com.xiaomi.slim.b bVar = new com.xiaomi.slim.b();
            bVar.a(5);
            bVar.c(sVar.a);
            bVar.b(a(afVar));
            bVar.a("SECMSG", "message");
            String str = sVar.a;
            afVar.g.b = str.substring(0, str.indexOf("@"));
            afVar.g.d = str.substring(str.indexOf("/") + 1);
            bVar.a(com.xiaomi.xmpush.thrift.at.a(afVar), sVar.c);
            bVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.a("try send mi push message. packagename:" + afVar.f + " action:" + afVar.a);
            return bVar;
        } catch (NullPointerException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.xiaomi.xmpush.thrift.af a(String str, String str2) {
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
        aiVar.b(str2);
        aiVar.c("package uninstalled");
        aiVar.a(com.xiaomi.smack.packet.d.j());
        aiVar.a(false);
        return a(str, str2, aiVar, com.xiaomi.xmpush.thrift.a.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends org.apache.thrift.a<T, ?>> com.xiaomi.xmpush.thrift.af a(String str, String str2, T t, com.xiaomi.xmpush.thrift.a aVar) {
        byte[] a = com.xiaomi.xmpush.thrift.at.a(t);
        com.xiaomi.xmpush.thrift.af afVar = new com.xiaomi.xmpush.thrift.af();
        com.xiaomi.xmpush.thrift.x xVar = new com.xiaomi.xmpush.thrift.x();
        xVar.a = 5L;
        xVar.b = "fakeid";
        afVar.a(xVar);
        afVar.a(ByteBuffer.wrap(a));
        afVar.a(aVar);
        afVar.c(true);
        afVar.b(str);
        afVar.a(false);
        afVar.a(str2);
        return afVar;
    }

    private static String a(com.xiaomi.xmpush.thrift.af afVar) {
        if (afVar.h != null && afVar.h.k != null) {
            String str = afVar.h.k.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return afVar.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService) {
        if (t.a(xMPushService.getApplicationContext()) != null) {
            as.b a = t.a(xMPushService.getApplicationContext()).a(xMPushService);
            a(xMPushService, a);
            as.a().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, as.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new ag(xMPushService));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar) {
        com.xiaomi.push.clientreport.a.a(xMPushService.getApplicationContext(), afVar, -1);
        com.xiaomi.smack.a g = xMPushService.g();
        if (g == null) {
            throw new com.xiaomi.smack.l("try send msg while connection is null.");
        }
        if (!g.b()) {
            throw new com.xiaomi.smack.l("Don't support XMPP connection.");
        }
        com.xiaomi.slim.b a = a(t.a(xMPushService), xMPushService, afVar);
        if (a != null) {
            g.b(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        com.xiaomi.push.clientreport.a.a(xMPushService.getApplicationContext(), bArr);
        com.xiaomi.smack.a g = xMPushService.g();
        if (g == null) {
            throw new com.xiaomi.smack.l("try send msg while connection is null.");
        }
        if (!g.b()) {
            throw new com.xiaomi.smack.l("Don't support XMPP connection.");
        }
        com.xiaomi.slim.b a = a(xMPushService, bArr);
        if (a != null) {
            g.b(a);
        } else {
            w.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }
}
