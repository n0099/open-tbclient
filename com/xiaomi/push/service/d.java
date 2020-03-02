package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.ff;
import com.xiaomi.push.gb;
import com.xiaomi.push.gc;
import com.xiaomi.push.gd;
import com.xiaomi.push.gf;
import com.xiaomi.push.service.al;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class d {
    private p a = new p();

    public static String a(al.b bVar) {
        return !"9".equals(bVar.g) ? bVar.f860a + ".permission.MIPUSH_RECEIVE" : bVar.f860a + ".permission.MIMC_RECEIVE";
    }

    private static void a(Context context, Intent intent, al.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    al.b a(ff ffVar) {
        Collection<al.b> m512a = al.a().m512a(Integer.toString(ffVar.a()));
        if (m512a.isEmpty()) {
            return null;
        }
        Iterator<al.b> it = m512a.iterator();
        if (m512a.size() == 1) {
            return it.next();
        }
        String g = ffVar.g();
        while (it.hasNext()) {
            al.b next = it.next();
            if (TextUtils.equals(g, next.f863b)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    al.b a(gd gdVar) {
        Collection<al.b> m512a = al.a().m512a(gdVar.k());
        if (m512a.isEmpty()) {
            return null;
        }
        Iterator<al.b> it = m512a.iterator();
        if (m512a.size() == 1) {
            return it.next();
        }
        String m = gdVar.m();
        String l = gdVar.l();
        while (it.hasNext()) {
            al.b next = it.next();
            if (TextUtils.equals(m, next.f863b) || TextUtils.equals(l, next.f863b)) {
                return next;
            }
            while (it.hasNext()) {
            }
        }
        return null;
    }

    @SuppressLint({"WrongConstant"})
    public void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        if (com.xiaomi.push.l.c()) {
            intent.addFlags(16777216);
        }
        context.sendBroadcast(intent);
    }

    public void a(Context context, al.b bVar, int i) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f860a);
        intent.putExtra(ap.r, bVar.g);
        intent.putExtra("ext_reason", i);
        intent.putExtra(ap.p, bVar.f863b);
        intent.putExtra(ap.C, bVar.i);
        if (bVar.f854a == null || !"9".equals(bVar.g)) {
            a(context, intent, bVar);
            return;
        }
        try {
            bVar.f854a.send(Message.obtain(null, 17, intent));
        } catch (RemoteException e) {
            bVar.f854a = null;
            com.xiaomi.channel.commonutils.logger.b.m47a("peer may died: " + bVar.f863b.substring(bVar.f863b.lastIndexOf(64)));
        }
    }

    public void a(Context context, al.b bVar, String str, String str2) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f860a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(ap.p, bVar.f863b);
        intent.putExtra(ap.C, bVar.i);
        a(context, intent, bVar);
    }

    public void a(Context context, al.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            this.a.a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f860a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(ap.p, bVar.f863b);
        intent.putExtra(ap.C, bVar.i);
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, ff ffVar) {
        al.b a = a(ffVar);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, ffVar, a);
        } else {
            String str2 = a.f860a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", ffVar.m274a(a.h));
            intent.putExtra(ap.C, a.i);
            intent.putExtra(ap.v, a.h);
            if (a.f854a != null) {
                try {
                    a.f854a.send(Message.obtain(null, 17, intent));
                    return;
                } catch (RemoteException e) {
                    a.f854a = null;
                    com.xiaomi.channel.commonutils.logger.b.m47a("peer may died: " + a.f863b.substring(a.f863b.lastIndexOf(64)));
                }
            }
            if ("com.xiaomi.xmsf".equals(str2)) {
                return;
            }
            a(xMPushService, intent, a);
        }
    }

    public void a(XMPushService xMPushService, String str, gd gdVar) {
        String str2;
        al.b a = a(gdVar);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, gdVar, a);
        } else {
            String str3 = a.f860a;
            if (gdVar instanceof gc) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (gdVar instanceof gb) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (!(gdVar instanceof gf)) {
                com.xiaomi.channel.commonutils.logger.b.d("unknown packet type, drop it");
                return;
            } else {
                str2 = "com.xiaomi.push.new_pres";
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str3);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", gdVar.a());
            intent.putExtra(ap.C, a.i);
            intent.putExtra(ap.v, a.h);
            a(xMPushService, intent, a);
        }
    }
}
