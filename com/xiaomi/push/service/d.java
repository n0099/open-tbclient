package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.push.fl;
import com.xiaomi.push.gh;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gl;
import com.xiaomi.push.service.ap;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes12.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private p f5099a = new p();

    public static String a(ap.b bVar) {
        return !"9".equals(bVar.g) ? bVar.f860a + ".permission.MIPUSH_RECEIVE" : bVar.f860a + ".permission.MIMC_RECEIVE";
    }

    private static void a(Context context, Intent intent, ap.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    ap.b a(fl flVar) {
        Collection<ap.b> m546a = ap.a().m546a(Integer.toString(flVar.a()));
        if (m546a.isEmpty()) {
            return null;
        }
        Iterator<ap.b> it = m546a.iterator();
        if (m546a.size() == 1) {
            return it.next();
        }
        String g = flVar.g();
        while (it.hasNext()) {
            ap.b next = it.next();
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
    ap.b a(gj gjVar) {
        Collection<ap.b> m546a = ap.a().m546a(gjVar.k());
        if (m546a.isEmpty()) {
            return null;
        }
        Iterator<ap.b> it = m546a.iterator();
        if (m546a.size() == 1) {
            return it.next();
        }
        String m = gjVar.m();
        String l = gjVar.l();
        while (it.hasNext()) {
            ap.b next = it.next();
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

    public void a(Context context, ap.b bVar, int i) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f860a);
        intent.putExtra(at.r, bVar.g);
        intent.putExtra("ext_reason", i);
        intent.putExtra(at.p, bVar.f863b);
        intent.putExtra(at.C, bVar.i);
        if (bVar.f854a == null || !"9".equals(bVar.g)) {
            a(context, intent, bVar);
            return;
        }
        try {
            bVar.f854a.send(Message.obtain(null, 17, intent));
        } catch (RemoteException e) {
            bVar.f854a = null;
            com.xiaomi.channel.commonutils.logger.b.m55a("peer may died: " + bVar.f863b.substring(bVar.f863b.lastIndexOf(64)));
        }
    }

    public void a(Context context, ap.b bVar, String str, String str2) {
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
        intent.putExtra(at.p, bVar.f863b);
        intent.putExtra(at.C, bVar.i);
        a(context, intent, bVar);
    }

    public void a(Context context, ap.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.g)) {
            this.f5099a.a(context, bVar, z, i, str);
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
        intent.putExtra(at.p, bVar.f863b);
        intent.putExtra(at.C, bVar.i);
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, fl flVar) {
        ap.b a2 = a(flVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.f5099a.a(xMPushService, flVar, a2);
        } else {
            String str2 = a2.f860a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", flVar.m286a(a2.h));
            intent.putExtra(at.C, a2.i);
            intent.putExtra(at.v, a2.h);
            if (a2.f854a != null) {
                try {
                    a2.f854a.send(Message.obtain(null, 17, intent));
                    return;
                } catch (RemoteException e) {
                    a2.f854a = null;
                    com.xiaomi.channel.commonutils.logger.b.m55a("peer may died: " + a2.f863b.substring(a2.f863b.lastIndexOf(64)));
                }
            }
            if ("com.xiaomi.xmsf".equals(str2)) {
                return;
            }
            a(xMPushService, intent, a2);
        }
    }

    public void a(XMPushService xMPushService, String str, gj gjVar) {
        String str2;
        ap.b a2 = a(gjVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.f5099a.a(xMPushService, gjVar, a2);
        } else {
            String str3 = a2.f860a;
            if (gjVar instanceof gi) {
                str2 = "com.xiaomi.push.new_msg";
            } else if (gjVar instanceof gh) {
                str2 = "com.xiaomi.push.new_iq";
            } else if (!(gjVar instanceof gl)) {
                com.xiaomi.channel.commonutils.logger.b.d("unknown packet type, drop it");
                return;
            } else {
                str2 = "com.xiaomi.push.new_pres";
            }
            Intent intent = new Intent();
            intent.setAction(str2);
            intent.setPackage(str3);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", gjVar.a());
            intent.putExtra(at.C, a2.i);
            intent.putExtra(at.v, a2.h);
            a(xMPushService, intent, a2);
        }
    }
}
