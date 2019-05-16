package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.service.as;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class d {
    private x a = new x();

    public static String a(as.b bVar) {
        return !"9".equals(bVar.h) ? bVar.a + ".permission.MIPUSH_RECEIVE" : bVar.a + ".permission.MIMC_RECEIVE";
    }

    private static void a(Context context, Intent intent, as.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    as.b a(com.xiaomi.slim.b bVar) {
        Collection<as.b> c = as.a().c(Integer.toString(bVar.c()));
        if (c.isEmpty()) {
            return null;
        }
        Iterator<as.b> it = c.iterator();
        if (c.size() == 1) {
            return it.next();
        }
        String j = bVar.j();
        while (it.hasNext()) {
            as.b next = it.next();
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
    as.b a(com.xiaomi.smack.packet.d dVar) {
        Collection<as.b> c = as.a().c(dVar.l());
        if (c.isEmpty()) {
            return null;
        }
        Iterator<as.b> it = c.iterator();
        if (c.size() == 1) {
            return it.next();
        }
        String n = dVar.n();
        String m = dVar.m();
        while (it.hasNext()) {
            as.b next = it.next();
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

    public void a(Context context, as.b bVar, int i) {
        if ("5".equalsIgnoreCase(bVar.h)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.a);
        intent.putExtra(aw.r, bVar.h);
        intent.putExtra("ext_reason", i);
        intent.putExtra(aw.p, bVar.b);
        intent.putExtra(aw.C, bVar.j);
        if (bVar.o == null || !"9".equals(bVar.h)) {
            a(context, intent, bVar);
            return;
        }
        try {
            bVar.o.send(Message.obtain(null, 17, intent));
        } catch (RemoteException e) {
            bVar.o = null;
            com.xiaomi.channel.commonutils.logger.b.a("peer may died: " + bVar.b.substring(bVar.b.lastIndexOf(64)));
        }
    }

    public void a(Context context, as.b bVar, String str, String str2) {
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
        intent.putExtra(aw.p, bVar.b);
        intent.putExtra(aw.C, bVar.j);
        a(context, intent, bVar);
    }

    public void a(Context context, as.b bVar, boolean z, int i, String str) {
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
        intent.putExtra(aw.p, bVar.b);
        intent.putExtra(aw.C, bVar.j);
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, com.xiaomi.slim.b bVar) {
        as.b a = a(bVar);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, bVar, a);
        } else {
            String str2 = a.a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", bVar.d(a.i));
            intent.putExtra(aw.C, a.j);
            intent.putExtra(aw.v, a.i);
            if (a.o != null) {
                try {
                    a.o.send(Message.obtain(null, 17, intent));
                    return;
                } catch (RemoteException e) {
                    a.o = null;
                    com.xiaomi.channel.commonutils.logger.b.a("peer may died: " + a.b.substring(a.b.lastIndexOf(64)));
                }
            }
            if ("com.xiaomi.xmsf".equals(str2)) {
                return;
            }
            a(xMPushService, intent, a);
        }
    }

    public void a(XMPushService xMPushService, String str, com.xiaomi.smack.packet.d dVar) {
        String str2;
        as.b a = a(dVar);
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
            intent.putExtra(aw.C, a.j);
            intent.putExtra(aw.v, a.i);
            a(xMPushService, intent, a);
        }
    }
}
