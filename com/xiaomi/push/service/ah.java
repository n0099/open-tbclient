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
            return a(u.m834a((Context) xMPushService), xMPushService, idVar);
        } catch (ix e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return null;
        }
    }

    public static fk a(t tVar, Context context, id idVar) {
        try {
            fk fkVar = new fk();
            fkVar.a(5);
            fkVar.c(tVar.f1005a);
            fkVar.b(a(idVar));
            fkVar.a("SECMSG", "message");
            String str = tVar.f1005a;
            idVar.f633a.f557a = str.substring(0, str.indexOf("@"));
            idVar.f633a.f561c = str.substring(str.indexOf("/") + 1);
            fkVar.a(ir.a(idVar), tVar.c);
            fkVar.a((short) 1);
            com.xiaomi.channel.commonutils.logger.b.m178a("try send mi push message. packagename:" + idVar.f638b + " action:" + idVar.f631a);
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
        hwVar.f556a = 5L;
        hwVar.f557a = "fakeid";
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
        hu huVar = idVar.f632a;
        if (huVar != null && (map = huVar.f547b) != null) {
            String str = map.get("ext_traffic_source_pkg");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return idVar.f638b;
    }

    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    public static void a(XMPushService xMPushService) {
        t m834a = u.m834a(xMPushService.getApplicationContext());
        if (m834a != null) {
            bg.b a = u.m834a(xMPushService.getApplicationContext()).a(xMPushService);
            com.xiaomi.channel.commonutils.logger.b.m178a("prepare account. " + a.f935a);
            a(xMPushService, a);
            bg.a().a(a);
            a(xMPushService, m834a, 172800);
        }
    }

    public static void a(XMPushService xMPushService, id idVar) {
        da.a(idVar.b(), xMPushService.getApplicationContext(), idVar, -1);
        fv m743a = xMPushService.m743a();
        if (m743a == null) {
            throw new gg("try send msg while connection is null.");
        }
        if (!m743a.mo494a()) {
            throw new gg("Don't support XMPP connection.");
        }
        fk a = a(u.m834a((Context) xMPushService), xMPushService, idVar);
        if (a != null) {
            m743a.b(a);
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
        fv m743a = xMPushService.m743a();
        if (m743a == null) {
            throw new gg("try send msg while connection is null.");
        }
        if (!m743a.mo494a()) {
            throw new gg("Don't support XMPP connection.");
        }
        fk a = a(xMPushService, bArr);
        if (a != null) {
            m743a.b(a);
        } else {
            x.a(xMPushService, str, bArr, ErrorCode.ERROR_INVALID_PAYLOAD, "not a valid message");
        }
    }

    public static id b(String str, String str2) {
        ig igVar = new ig();
        igVar.b(str2);
        igVar.c(hr.AppDataCleared.f508a);
        igVar.a(bd.a());
        igVar.a(false);
        return a(str, str2, igVar, hh.Notification);
    }

    public static <T extends is<T, ?>> id b(String str, String str2, T t, hh hhVar) {
        return a(str, str2, t, hhVar, false);
    }
}
