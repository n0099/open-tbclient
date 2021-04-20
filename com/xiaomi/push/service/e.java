package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import com.xiaomi.push.fa;
import com.xiaomi.push.ga;
import com.xiaomi.push.gb;
import com.xiaomi.push.gc;
import com.xiaomi.push.ge;
import com.xiaomi.push.service.av;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public q f41316a = new q();

    public static String a(av.b bVar) {
        StringBuilder sb;
        String str;
        if (HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9.equals(bVar.f41256g)) {
            sb = new StringBuilder();
            sb.append(bVar.f908a);
            str = ".permission.MIMC_RECEIVE";
        } else {
            sb = new StringBuilder();
            sb.append(bVar.f908a);
            str = ".permission.MIPUSH_RECEIVE";
        }
        sb.append(str);
        return sb.toString();
    }

    public static void a(Context context, Intent intent, av.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    public av.b a(fa faVar) {
        Collection<av.b> m586a = av.a().m586a(Integer.toString(faVar.a()));
        if (m586a.isEmpty()) {
            return null;
        }
        Iterator<av.b> it = m586a.iterator();
        if (m586a.size() == 1) {
            return it.next();
        }
        String g2 = faVar.g();
        while (it.hasNext()) {
            av.b next = it.next();
            if (TextUtils.equals(g2, next.f911b)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public av.b a(gc gcVar) {
        Collection<av.b> m586a = av.a().m586a(gcVar.k());
        if (m586a.isEmpty()) {
            return null;
        }
        Iterator<av.b> it = m586a.iterator();
        if (m586a.size() == 1) {
            return it.next();
        }
        String m = gcVar.m();
        String l = gcVar.l();
        while (it.hasNext()) {
            av.b next = it.next();
            if (TextUtils.equals(m, next.f911b) || TextUtils.equals(l, next.f911b)) {
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

    public void a(Context context, av.b bVar, int i) {
        if ("5".equalsIgnoreCase(bVar.f41256g)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.f908a);
        intent.putExtra(az.s, bVar.f41256g);
        intent.putExtra("ext_reason", i);
        intent.putExtra(az.p, bVar.f911b);
        intent.putExtra(az.D, bVar.i);
        if (bVar.f902a == null || !HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9.equals(bVar.f41256g)) {
            a(context, intent, bVar);
            return;
        }
        try {
            bVar.f902a.send(Message.obtain(null, 17, intent));
        } catch (RemoteException unused) {
            bVar.f902a = null;
            StringBuilder sb = new StringBuilder();
            sb.append("peer may died: ");
            String str = bVar.f911b;
            sb.append(str.substring(str.lastIndexOf(64)));
            com.xiaomi.channel.commonutils.logger.b.m55a(sb.toString());
        }
    }

    public void a(Context context, av.b bVar, String str, String str2) {
        if ("5".equalsIgnoreCase(bVar.f41256g)) {
            com.xiaomi.channel.commonutils.logger.b.d("mipush kicked by server");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.kicked");
        intent.setPackage(bVar.f908a);
        intent.putExtra("ext_kick_type", str);
        intent.putExtra("ext_kick_reason", str2);
        intent.putExtra("ext_chid", bVar.f41256g);
        intent.putExtra(az.p, bVar.f911b);
        intent.putExtra(az.D, bVar.i);
        a(context, intent, bVar);
    }

    public void a(Context context, av.b bVar, boolean z, int i, String str) {
        if ("5".equalsIgnoreCase(bVar.f41256g)) {
            this.f41316a.a(context, bVar, z, i, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.f908a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.f41256g);
        intent.putExtra(az.p, bVar.f911b);
        intent.putExtra(az.D, bVar.i);
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, fa faVar) {
        av.b a2 = a(faVar);
        if (a2 == null) {
            com.xiaomi.channel.commonutils.logger.b.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.f41316a.a(xMPushService, faVar, a2);
        } else {
            String str2 = a2.f908a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", faVar.m292a(a2.f41257h));
            intent.putExtra(az.D, a2.i);
            intent.putExtra(az.w, a2.f41257h);
            if (a2.f902a != null) {
                try {
                    a2.f902a.send(Message.obtain(null, 17, intent));
                    com.xiaomi.channel.commonutils.logger.b.m55a("message was sent by messenger for chid=" + str);
                    return;
                } catch (RemoteException unused) {
                    a2.f902a = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("peer may died: ");
                    String str3 = a2.f911b;
                    sb.append(str3.substring(str3.lastIndexOf(64)));
                    com.xiaomi.channel.commonutils.logger.b.m55a(sb.toString());
                }
            }
            if ("com.xiaomi.xmsf".equals(str2)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m55a("broadcast message to " + str2 + ", chid=" + str);
            a(xMPushService, intent, a2);
        }
    }

    public void a(XMPushService xMPushService, String str, gc gcVar) {
        String str2;
        String str3;
        av.b a2 = a(gcVar);
        if (a2 != null) {
            if ("5".equalsIgnoreCase(str)) {
                this.f41316a.a(xMPushService, gcVar, a2);
                return;
            }
            String str4 = a2.f908a;
            if (gcVar instanceof gb) {
                str3 = "com.xiaomi.push.new_msg";
            } else if (gcVar instanceof ga) {
                str3 = "com.xiaomi.push.new_iq";
            } else if (gcVar instanceof ge) {
                str3 = "com.xiaomi.push.new_pres";
            } else {
                str2 = "unknown packet type, drop it";
            }
            Intent intent = new Intent();
            intent.setAction(str3);
            intent.setPackage(str4);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", gcVar.a());
            intent.putExtra(az.D, a2.i);
            intent.putExtra(az.w, a2.f41257h);
            a(xMPushService, intent, a2);
            return;
        }
        str2 = "error while notify channel closed! channel " + str + " not registered";
        com.xiaomi.channel.commonutils.logger.b.d(str2);
    }
}
