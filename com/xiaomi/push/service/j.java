package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.fk;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.gm;
import com.xiaomi.push.go;
import com.xiaomi.push.service.bg;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class j {
    public y a = new y();

    public static String a(bg.b bVar) {
        StringBuilder sb;
        String str;
        if ("9".equals(bVar.g)) {
            sb = new StringBuilder();
            sb.append(bVar.f935a);
            str = ".permission.MIMC_RECEIVE";
        } else {
            sb = new StringBuilder();
            sb.append(bVar.f935a);
            str = ".permission.MIPUSH_RECEIVE";
        }
        sb.append(str);
        return sb.toString();
    }

    public static void a(Context context, Intent intent, bg.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    public bg.b a(fk fkVar) {
        Collection<bg.b> m788a = bg.a().m788a(Integer.toString(fkVar.a()));
        if (m788a.isEmpty()) {
            return null;
        }
        Iterator<bg.b> it = m788a.iterator();
        if (m788a.size() == 1) {
            return it.next();
        }
        String g = fkVar.g();
        while (it.hasNext()) {
            bg.b next = it.next();
            if (TextUtils.equals(g, next.f938b)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public bg.b a(gm gmVar) {
        Collection<bg.b> m788a = bg.a().m788a(gmVar.k());
        if (m788a.isEmpty()) {
            return null;
        }
        Iterator<bg.b> it = m788a.iterator();
        if (m788a.size() == 1) {
            return it.next();
        }
        String m = gmVar.m();
        String l = gmVar.l();
        while (it.hasNext()) {
            bg.b next = it.next();
            if (TextUtils.equals(m, next.f938b) || TextUtils.equals(l, next.f938b)) {
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
        if (com.xiaomi.push.j.m710c()) {
            intent.addFlags(16777216);
        }
        com.xiaomi.channel.commonutils.logger.b.m175a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
        context.sendBroadcast(intent);
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, bg.b bVar, int i) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f935a);
        intent.putExtra(bk.t, bVar.g);
        intent.putExtra("ext_reason", i);
        intent.putExtra(bk.q, bVar.f938b);
        intent.putExtra(bk.F, bVar.i);
        if (bVar.f929a == null || !"9".equals(bVar.g)) {
            com.xiaomi.channel.commonutils.logger.b.m175a(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.g, bVar.f935a, Integer.valueOf(i)));
            a(context, intent, bVar);
            return;
        }
        try {
            bVar.f929a.send(Message.obtain(null, 17, intent));
        } catch (RemoteException unused) {
            bVar.f929a = null;
            StringBuilder sb = new StringBuilder();
            sb.append("peer may died: ");
            String str = bVar.f938b;
            sb.append(str.substring(str.lastIndexOf(64)));
            com.xiaomi.channel.commonutils.logger.b.m175a(sb.toString());
        }
    }

    public void a(Context context, bg.b bVar, String str, String str2) {
        if (bVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify kick by server!");
        } else if ("5".equalsIgnoreCase(bVar.g)) {
            com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
        } else {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.kicked");
            intent.setPackage(bVar.f935a);
            intent.putExtra("ext_kick_type", str);
            intent.putExtra("ext_kick_reason", str2);
            intent.putExtra("ext_chid", bVar.g);
            intent.putExtra(bk.q, bVar.f938b);
            intent.putExtra(bk.F, bVar.i);
            com.xiaomi.channel.commonutils.logger.b.m175a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.g, bVar.f935a, str2));
            a(context, intent, bVar);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, bg.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            this.a.a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f935a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.g);
        intent.putExtra(bk.q, bVar.f938b);
        intent.putExtra(bk.F, bVar.i);
        com.xiaomi.channel.commonutils.logger.b.m175a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.g, bVar.f935a, Boolean.valueOf(z), Integer.valueOf(i)));
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, fk fkVar) {
        an anVar;
        bg.b a = a(fkVar);
        if (a == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, fkVar, a);
        } else {
            String str2 = a.f935a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", fkVar.m482a(a.h));
            intent.putExtra(bk.F, a.i);
            intent.putExtra(bk.x, a.h);
            if (a.f929a != null) {
                try {
                    a.f929a.send(Message.obtain(null, 17, intent));
                    com.xiaomi.channel.commonutils.logger.b.m175a("message was sent by messenger for chid=" + str);
                    return;
                } catch (RemoteException unused) {
                    a.f929a = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("peer may died: ");
                    String str3 = a.f938b;
                    sb.append(str3.substring(str3.lastIndexOf(64)));
                    com.xiaomi.channel.commonutils.logger.b.m175a(sb.toString());
                }
            }
            if ("com.xiaomi.xmsf".equals(str2)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m175a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", a.g, a.f935a, fkVar.e()));
            a(xMPushService, intent, a);
            if (!"10".equals(str) || (anVar = fkVar.f375a) == null) {
                return;
            }
            anVar.d = System.currentTimeMillis();
            ao.a(xMPushService, "coord_down", fkVar.f375a);
        }
    }

    public void a(XMPushService xMPushService, String str, gm gmVar) {
        String str2;
        String str3;
        bg.b a = a(gmVar);
        if (a != null) {
            if ("5".equalsIgnoreCase(str)) {
                this.a.a(xMPushService, gmVar, a);
                return;
            }
            String str4 = a.f935a;
            if (gmVar instanceof gl) {
                str3 = "com.xiaomi.push.new_msg";
            } else if (gmVar instanceof gk) {
                str3 = "com.xiaomi.push.new_iq";
            } else if (gmVar instanceof go) {
                str3 = "com.xiaomi.push.new_pres";
            } else {
                str2 = "unknown packet type, drop it";
            }
            Intent intent = new Intent();
            intent.setAction(str3);
            intent.setPackage(str4);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", gmVar.a());
            intent.putExtra(bk.F, a.i);
            intent.putExtra(bk.x, a.h);
            com.xiaomi.channel.commonutils.logger.b.m175a(String.format("[Bcst] notify packet arrival. %s,%s,%s", a.g, a.f935a, gmVar.j()));
            a(xMPushService, intent, a);
            return;
        }
        str2 = "error while notify channel closed! channel " + str + " not registered";
        com.xiaomi.channel.commonutils.logger.b.d(str2);
    }
}
