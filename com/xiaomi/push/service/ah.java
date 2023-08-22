package com.xiaomi.push.service;

import android.content.Context;
import android.os.Messenger;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.da;
import com.xiaomi.push.fk;
import com.xiaomi.push.fv;
import com.xiaomi.push.gg;
import com.xiaomi.push.gm;
import com.xiaomi.push.hh;
import com.xiaomi.push.hr;
import com.xiaomi.push.hu;
import com.xiaomi.push.hw;
import com.xiaomi.push.id;
import com.xiaomi.push.ig;
import com.xiaomi.push.ir;
import com.xiaomi.push.is;
import com.xiaomi.push.ix;
import com.xiaomi.push.service.bg;
import java.nio.ByteBuffer;
import java.util.Map;
/* loaded from: classes10.dex */
public final class ah {
    public static fk a(XMPushService xMPushService, byte[] bArr) {
        id idVar = new id();
        try {
            ir.a(idVar, bArr);
            return a(u.m836a((Context) xMPushService), xMPushService, idVar);
        } catch (ix e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    public static fk a(t tVar, Context context, id idVar) {
        try {
            fk fkVar = new fk();
            fkVar.a(5);
            fkVar.c(tVar.f1006a);
            fkVar.b(a(idVar));
            fkVar.a("SECMSG", "message");
            String str = tVar.f1006a;
            idVar.f634a.f558a = str.substring(0, str.indexOf("@"));
            idVar.f634a.f562c = str.substring(str.indexOf("/") + 1);
            fkVar.a(ir.a(idVar), tVar.c);
            fkVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m180a("try send mi push message. packagename:" + idVar.f639b + " action:" + idVar.f632a);
            return fkVar;
        } catch (NullPointerException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    public static id a(String str, String str2) {
        ig igVar = new ig();
        igVar.b(str2);
        igVar.c("package uninstalled");
        igVar.a(gm.i());
        igVar.a(false);
        return a(str, str2, igVar, hh.Notification);
    }

    public static <T extends is<T, ?>> id a(String str, String str2, T t, hh hhVar) {
        return a(str, str2, t, hhVar, true);
    }

    public static <T extends is<T, ?>> id a(String str, String str2, T t, hh hhVar, boolean z) {
        byte[] a = ir.a(t);
        id idVar = new id();
        hw hwVar = new hw();
        hwVar.f557a = 5L;
        hwVar.f558a = "fakeid";
        idVar.a(hwVar);
        idVar.a(ByteBuffer.wrap(a));
        idVar.a(hhVar);
        idVar.b(z);
        idVar.b(str);
        idVar.a(false);
        idVar.a(str2);
        return idVar;
    }

    public static String a(id idVar) {
        Map<String, String> map;
        hu huVar = idVar.f633a;
        if (huVar != null && (map = huVar.f548b) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return idVar.f639b;
    }

    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    public static void a(XMPushService xMPushService) {
        t m836a = u.m836a(xMPushService.getApplicationContext());
        if (m836a != null) {
            bg.b a = u.m836a(xMPushService.getApplicationContext()).a(xMPushService);
            com.xiaomi.channel.commonutils.logger.b.m180a("prepare account. " + a.f936a);
            a(xMPushService, a);
            bg.a().a(a);
            a(xMPushService, m836a, 172800);
        }
    }

    public static void a(XMPushService xMPushService, id idVar) {
        da.a(idVar.b(), xMPushService.getApplicationContext(), idVar, -1);
        fv m745a = xMPushService.m745a();
        if (m745a == null) {
            throw new gg("try send msg while connection is null.");
        }
        if (!m745a.mo496a()) {
            throw new gg("Don't support XMPP connection.");
        }
        fk a = a(u.m836a((Context) xMPushService), xMPushService, idVar);
        if (a != null) {
            m745a.b(a);
        }
    }

    public static void a(XMPushService xMPushService, bg.b bVar) {
        bVar.a((Messenger) null);
        bVar.a(new aj(xMPushService));
    }

    public static void a(XMPushService xMPushService, t tVar, int i) {
        bx.a(xMPushService).a(new ai("MSAID", i, xMPushService, tVar));
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr) {
        da.a(str, xMPushService.getApplicationContext(), bArr);
        fv m745a = xMPushService.m745a();
        if (m745a == null) {
            throw new gg("try send msg while connection is null.");
        }
        if (!m745a.mo496a()) {
            throw new gg("Don't support XMPP connection.");
        }
        fk a = a(xMPushService, bArr);
        if (a != null) {
            m745a.b(a);
        } else {
            x.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }

    public static id b(String str, String str2) {
        ig igVar = new ig();
        igVar.b(str2);
        igVar.c(hr.AppDataCleared.f509a);
        igVar.a(bd.a());
        igVar.a(false);
        return a(str, str2, igVar, hh.Notification);
    }

    public static <T extends is<T, ?>> id b(String str, String str2, T t, hh hhVar) {
        return a(str, str2, t, hhVar, false);
    }
}
