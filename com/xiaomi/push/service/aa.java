package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.ak;
import java.nio.ByteBuffer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class aa {
    static com.xiaomi.slim.b a(XMPushService xMPushService, byte[] bArr) {
        com.xiaomi.xmpush.thrift.ab abVar = new com.xiaomi.xmpush.thrift.ab();
        try {
            com.xiaomi.xmpush.thrift.aq.a(abVar, bArr);
            return a(o.a(xMPushService), xMPushService, abVar);
        } catch (org.apache.thrift.f e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    static com.xiaomi.slim.b a(n nVar, Context context, com.xiaomi.xmpush.thrift.ab abVar) {
        try {
            com.xiaomi.slim.b bVar = new com.xiaomi.slim.b();
            bVar.a(5);
            bVar.c(nVar.a);
            bVar.b(abVar.f);
            bVar.a("SECMSG", "message");
            String str = nVar.a;
            abVar.g.b = str.substring(0, str.indexOf("@"));
            abVar.g.d = str.substring(str.indexOf("/") + 1);
            bVar.a(com.xiaomi.xmpush.thrift.aq.a(abVar), nVar.c);
            bVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.a("try send mi push message. packagename:" + abVar.f + " action:" + abVar.a);
            return bVar;
        } catch (NullPointerException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.xiaomi.xmpush.thrift.ab a(String str, String str2) {
        com.xiaomi.xmpush.thrift.ae aeVar = new com.xiaomi.xmpush.thrift.ae();
        aeVar.b(str2);
        aeVar.c("package uninstalled");
        aeVar.a(com.xiaomi.smack.packet.d.j());
        aeVar.a(false);
        return a(str, str2, aeVar, com.xiaomi.xmpush.thrift.a.Notification);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends org.apache.thrift.a<T, ?>> com.xiaomi.xmpush.thrift.ab a(String str, String str2, T t, com.xiaomi.xmpush.thrift.a aVar) {
        byte[] a = com.xiaomi.xmpush.thrift.aq.a(t);
        com.xiaomi.xmpush.thrift.ab abVar = new com.xiaomi.xmpush.thrift.ab();
        com.xiaomi.xmpush.thrift.u uVar = new com.xiaomi.xmpush.thrift.u();
        uVar.a = 5L;
        uVar.b = "fakeid";
        abVar.a(uVar);
        abVar.a(ByteBuffer.wrap(a));
        abVar.a(aVar);
        abVar.c(true);
        abVar.b(str);
        abVar.a(false);
        abVar.a(str2);
        return abVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService) {
        if (o.a(xMPushService.getApplicationContext()) != null) {
            ak.b a = o.a(xMPushService.getApplicationContext()).a(xMPushService);
            a(xMPushService, a);
            ak.a().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, ak.b bVar) {
        bVar.a(new ab(xMPushService));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, com.xiaomi.xmpush.thrift.ab abVar) {
        com.xiaomi.smack.a h = xMPushService.h();
        if (h == null) {
            throw new com.xiaomi.smack.l("try send msg while connection is null.");
        }
        if (!h.a()) {
            throw new com.xiaomi.smack.l("Don't support XMPP connection.");
        }
        com.xiaomi.slim.b a = a(o.a(xMPushService), xMPushService, abVar);
        if (a != null) {
            h.b(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        com.xiaomi.smack.a h = xMPushService.h();
        if (h == null) {
            throw new com.xiaomi.smack.l("try send msg while connection is null.");
        }
        if (!h.a()) {
            throw new com.xiaomi.smack.l("Don't support XMPP connection.");
        }
        com.xiaomi.slim.b a = a(xMPushService, bArr);
        if (a != null) {
            h.b(a);
        } else {
            r.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }
}
