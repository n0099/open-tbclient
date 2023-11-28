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
            return a(u.m846a((Context) xMPushService), xMPushService, idVar);
        } catch (ix e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    public static fk a(t tVar, Context context, id idVar) {
        try {
            fk fkVar = new fk();
            fkVar.a(5);
            fkVar.c(tVar.f1001a);
            fkVar.b(a(idVar));
            fkVar.a("SECMSG", "message");
            String str = tVar.f1001a;
            idVar.f629a.f553a = str.substring(0, str.indexOf("@"));
            idVar.f629a.f557c = str.substring(str.indexOf("/") + 1);
            fkVar.a(ir.a(idVar), tVar.c);
            fkVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m190a("try send mi push message. packagename:" + idVar.f634b + " action:" + idVar.f627a);
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
        hwVar.f552a = 5L;
        hwVar.f553a = "fakeid";
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
        hu huVar = idVar.f628a;
        if (huVar != null && (map = huVar.f543b) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return idVar.f634b;
    }

    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    public static void a(XMPushService xMPushService) {
        t m846a = u.m846a(xMPushService.getApplicationContext());
        if (m846a != null) {
            bg.b a = u.m846a(xMPushService.getApplicationContext()).a(xMPushService);
            com.xiaomi.channel.commonutils.logger.b.m190a("prepare account. " + a.f931a);
            a(xMPushService, a);
            bg.a().a(a);
            a(xMPushService, m846a, 172800);
        }
    }

    public static void a(XMPushService xMPushService, id idVar) {
        da.a(idVar.b(), xMPushService.getApplicationContext(), idVar, -1);
        fv m755a = xMPushService.m755a();
        if (m755a == null) {
            throw new gg("try send msg while connection is null.");
        }
        if (!m755a.mo506a()) {
            throw new gg("Don't support XMPP connection.");
        }
        fk a = a(u.m846a((Context) xMPushService), xMPushService, idVar);
        if (a != null) {
            m755a.b(a);
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
        fv m755a = xMPushService.m755a();
        if (m755a == null) {
            throw new gg("try send msg while connection is null.");
        }
        if (!m755a.mo506a()) {
            throw new gg("Don't support XMPP connection.");
        }
        fk a = a(xMPushService, bArr);
        if (a != null) {
            m755a.b(a);
        } else {
            x.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }

    public static id b(String str, String str2) {
        ig igVar = new ig();
        igVar.b(str2);
        igVar.c(hr.AppDataCleared.f504a);
        igVar.a(bd.a());
        igVar.a(false);
        return a(str, str2, igVar, hh.Notification);
    }

    public static <T extends is<T, ?>> id b(String str, String str2, T t, hh hhVar) {
        return a(str, str2, t, hhVar, false);
    }
}
