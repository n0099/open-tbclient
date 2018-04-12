package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.service.ak;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class b {
    private s a = new s();

    public static String a(String str) {
        return str + ".permission.MIPUSH_RECEIVE";
    }

    private static void a(Context context, Intent intent, String str) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(str));
        }
    }

    ak.b a(com.xiaomi.slim.b bVar) {
        Collection<ak.b> c = ak.a().c(Integer.toString(bVar.c()));
        if (c.isEmpty()) {
            return null;
        }
        Iterator<ak.b> it = c.iterator();
        if (c.size() == 1) {
            return it.next();
        }
        String j = bVar.j();
        while (it.hasNext()) {
            ak.b next = it.next();
            if (TextUtils.equals(j, next.b)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    ak.b a(com.xiaomi.smack.packet.d dVar) {
        Collection<ak.b> c = ak.a().c(dVar.l());
        if (c.isEmpty()) {
            return null;
        }
        Iterator<ak.b> it = c.iterator();
        if (c.size() == 1) {
            return it.next();
        }
        String n = dVar.n();
        String m = dVar.m();
        while (it.hasNext()) {
            ak.b next = it.next();
            if (TextUtils.equals(n, next.b) || TextUtils.equals(m, next.b)) {
                return next;
            }
            while (it.hasNext()) {
            }
        }
        return null;
    }

    public void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        context.sendBroadcast(intent);
    }

    public void a(Context context, ak.b bVar, int i) {
        if ("5".equalsIgnoreCase(bVar.h)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.a);
        intent.putExtra(am.q, bVar.h);
        intent.putExtra("ext_reason", i);
        intent.putExtra(am.p, bVar.b);
        intent.putExtra(am.B, bVar.j);
        a(context, intent, bVar.a);
    }

    public void a(Context context, ak.b bVar, String str, String str2) {
        if ("5".equalsIgnoreCase(bVar.h)) {
            com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.h);
        intent.putExtra(am.p, bVar.b);
        intent.putExtra(am.B, bVar.j);
        a(context, intent, bVar.a);
    }

    public void a(Context context, ak.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.h)) {
            this.a.a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.h);
        intent.putExtra(am.p, bVar.b);
        intent.putExtra(am.B, bVar.j);
        a(context, intent, bVar.a);
    }

    public void a(XMPushService xMPushService, String str, com.xiaomi.slim.b bVar) {
        ak.b a = a(bVar);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, bVar, a);
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("don't support binary yet");
        }
    }

    public void a(XMPushService xMPushService, String str, com.xiaomi.smack.packet.d dVar) {
        String str2;
        ak.b a = a(dVar);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, dVar, a);
        } else {
            String str3 = a.a;
            if (dVar instanceof com.xiaomi.smack.packet.c) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (dVar instanceof com.xiaomi.smack.packet.b) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (!(dVar instanceof com.xiaomi.smack.packet.f)) {
                com.xiaomi.channel.commonutils.logger.b.d("unknown packet type, drop it");
                return;
            } else {
                str2 = "com.xiaomi.push.new_pres";
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str3);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", dVar.b());
            intent.putExtra(am.B, a.j);
            intent.putExtra(am.u, a.i);
            a(xMPushService, intent, str3);
        }
    }
}
