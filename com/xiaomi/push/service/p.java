package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.xiaomi.push.Cif;
import com.xiaomi.push.da;
import com.xiaomi.push.ev;
import com.xiaomi.push.ff;
import com.xiaomi.push.fx;
import com.xiaomi.push.ga;
import com.xiaomi.push.gc;
import com.xiaomi.push.gd;
import com.xiaomi.push.gr;
import com.xiaomi.push.hg;
import com.xiaomi.push.hq;
import com.xiaomi.push.ht;
import com.xiaomi.push.hw;
import com.xiaomi.push.ic;
import com.xiaomi.push.iq;
import com.xiaomi.push.service.al;
import com.xiaomi.push.service.z;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class p {
    public static Intent a(byte[] bArr, long j) {
        ic a = a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a.f618b);
        return intent;
    }

    public static ic a(Context context, ic icVar) {
        hw hwVar = new hw();
        hwVar.b(icVar.m405a());
        ht m404a = icVar.m404a();
        if (m404a != null) {
            hwVar.a(m404a.m369a());
            hwVar.a(m404a.m367a());
            if (!TextUtils.isEmpty(m404a.m374b())) {
                hwVar.c(m404a.m374b());
            }
        }
        hwVar.a(iq.a(context, icVar));
        ic a = w.a(icVar.b(), icVar.m405a(), hwVar, hg.AckMessage);
        ht m368a = icVar.m404a().m368a();
        m368a.a("mat", Long.toString(System.currentTimeMillis()));
        a.a(m368a);
        return a;
    }

    public static ic a(byte[] bArr) {
        ic icVar = new ic();
        try {
            iq.a(icVar, bArr);
            return icVar;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    private static void a(XMPushService xMPushService, ic icVar) {
        xMPushService.a(new q(4, xMPushService, icVar));
    }

    private static void a(XMPushService xMPushService, ic icVar, String str) {
        xMPushService.a(new u(4, xMPushService, icVar, str));
    }

    private static void a(XMPushService xMPushService, ic icVar, String str, String str2) {
        xMPushService.a(new v(4, xMPushService, icVar, str, str2));
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        ic a = a(bArr);
        ht m404a = a.m404a();
        if (bArr != null) {
            da.a(a.b(), xMPushService.getApplicationContext(), null, a.a(), bArr.length);
        }
        if (c(a) && a(xMPushService, str)) {
            if (z.e(a)) {
                ev.a(xMPushService.getApplicationContext()).a(a.b(), z.b(a), m404a.m369a(), "old message received by new SDK.");
            }
            c(xMPushService, a);
        } else if (a(a) && !a(xMPushService, str) && !b(a)) {
            if (z.e(a)) {
                ev.a(xMPushService.getApplicationContext()).a(a.b(), z.b(a), m404a.m369a(), "new message received by old SDK.");
            }
            d(xMPushService, a);
        } else if ((!z.m558a(a) || !com.xiaomi.push.g.m302b((Context) xMPushService, a.f618b)) && !a(xMPushService, intent)) {
            if (!com.xiaomi.push.g.m302b((Context) xMPushService, a.f618b)) {
                if (z.e(a)) {
                    ev.a(xMPushService.getApplicationContext()).b(a.b(), z.b(a), m404a.m369a(), "receive a message, but the package is removed.");
                }
                a(xMPushService, a);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (z.e(a)) {
                ev.a(xMPushService.getApplicationContext()).b(a.b(), z.b(a), m404a.m369a(), "receive a mipush message, we can see the app, but we can't see the receiver.");
            }
        } else {
            if (hg.Registration == a.a()) {
                String b = a.b();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(b, a.f614a);
                edit.commit();
                ev.a(xMPushService.getApplicationContext()).a(b, "E100003", m404a.m369a(), 6003, "receive a register message");
                if (!TextUtils.isEmpty(m404a.m369a())) {
                    intent.putExtra("messageId", m404a.m369a());
                    intent.putExtra("eventMessageType", SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME);
                }
            }
            if (z.c(a)) {
                ev.a(xMPushService.getApplicationContext()).a(a.b(), z.b(a), m404a.m369a(), 1001, System.currentTimeMillis(), "receive notification message ");
                if (!TextUtils.isEmpty(m404a.m369a())) {
                    intent.putExtra("messageId", m404a.m369a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (z.m563b(a)) {
                ev.a(xMPushService.getApplicationContext()).a(a.b(), z.b(a), m404a.m369a(), 2001, System.currentTimeMillis(), "receive passThrough message");
                if (!TextUtils.isEmpty(m404a.m369a())) {
                    intent.putExtra("messageId", m404a.m369a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (z.m558a(a)) {
                ev.a(xMPushService.getApplicationContext()).a(a.b(), z.b(a), m404a.m369a(), 3001, System.currentTimeMillis(), "receive business message");
                if (!TextUtils.isEmpty(m404a.m369a())) {
                    intent.putExtra("messageId", m404a.m369a());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (m404a != null && !TextUtils.isEmpty(m404a.m377c()) && !TextUtils.isEmpty(m404a.d()) && m404a.f527b != 1 && (z.m560a(m404a.m370a()) || !z.m557a((Context) xMPushService, a.f618b))) {
                boolean z = false;
                if (m404a != null) {
                    r0 = m404a.f525a != null ? m404a.f525a.get("jobkey") : null;
                    if (TextUtils.isEmpty(r0)) {
                        r0 = m404a.m369a();
                    }
                    z = ab.a(xMPushService, a.f618b, r0);
                }
                if (z) {
                    ev.a(xMPushService.getApplicationContext()).c(a.b(), z.b(a), m404a.m369a(), "drop a duplicate message");
                    com.xiaomi.channel.commonutils.logger.b.m50a("drop a duplicate message, key=" + r0);
                } else {
                    z.c m554a = z.m554a((Context) xMPushService, a, bArr);
                    if (m554a.a > 0 && !TextUtils.isEmpty(m554a.f943a)) {
                        gr.a(xMPushService, m554a.f943a, m554a.a, true, false, System.currentTimeMillis());
                    }
                    if (!z.m558a(a)) {
                        Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                        intent2.putExtra("mipush_payload", bArr);
                        intent2.setPackage(a.f618b);
                        try {
                            List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                            if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                xMPushService.sendBroadcast(intent2, w.a(a.f618b));
                            }
                        } catch (Exception e) {
                            xMPushService.sendBroadcast(intent2, w.a(a.f618b));
                            if (e != null) {
                                ev.a(xMPushService.getApplicationContext()).b(a.b(), z.b(a), m404a.m369a(), e.getMessage());
                            }
                        }
                    }
                }
                b(xMPushService, a);
            } else if ("com.xiaomi.xmsf".contains(a.f618b) && !a.m412b() && m404a != null && m404a.m370a() != null && m404a.m370a().containsKey("ab")) {
                b(xMPushService, a);
                com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m404a.m369a());
            } else if (a(xMPushService, str, a, m404a)) {
                if (m404a != null && !TextUtils.isEmpty(m404a.m369a())) {
                    if (z.m563b(a)) {
                        ev.a(xMPushService.getApplicationContext()).a(a.b(), z.b(a), m404a.m369a(), 2002, "try send passThrough message Broadcast");
                    } else if (z.m558a(a)) {
                        ev.a(xMPushService.getApplicationContext()).a(a.b(), z.b(a), m404a.m369a(), "try show awake message , but it don't show in foreground");
                    } else if (z.c(a)) {
                        ev.a(xMPushService.getApplicationContext()).a(a.b(), z.b(a), m404a.m369a(), "try show notification message , but it don't show in foreground");
                    } else if (z.d(a)) {
                        ev.a(xMPushService.getApplicationContext()).a(a.b(), "E100003", m404a.m369a(), 6004, "try send register broadcast");
                    }
                }
                xMPushService.sendBroadcast(intent, w.a(a.f618b));
            } else {
                ev.a(xMPushService.getApplicationContext()).a(a.b(), z.b(a), m404a.m369a(), "passThough message: not permit to send broadcast ");
            }
            if (a.a() != hg.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> m370a;
        ic a = a(bArr);
        if (a == null) {
            return;
        }
        if (TextUtils.isEmpty(a.f618b)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a2 = a(bArr, valueOf.longValue());
        String a3 = z.a(a);
        gr.a(xMPushService, a3, j, true, true, System.currentTimeMillis());
        ht m404a = a.m404a();
        if (m404a != null) {
            m404a.a("mrt", Long.toString(valueOf.longValue()));
        }
        if (hg.SendMessage == a.a() && m.a(xMPushService).m550a(a.f618b) && !z.m558a(a)) {
            String str = "";
            if (m404a != null) {
                str = m404a.m369a();
                if (z.e(a)) {
                    ev.a(xMPushService.getApplicationContext()).a(a.b(), z.b(a), str, "Drop a message for unregistered");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a, a.f618b);
        } else if (hg.SendMessage == a.a() && m.a(xMPushService).m552c(a.f618b) && !z.m558a(a)) {
            String str2 = "";
            if (m404a != null) {
                str2 = m404a.m369a();
                if (z.e(a)) {
                    ev.a(xMPushService.getApplicationContext()).a(a.b(), z.b(a), str2, "Drop a message for push closed");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("Drop a message for push closed, msgid=" + str2);
            a(xMPushService, a, a.f618b);
        } else if (hg.SendMessage == a.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a.f618b)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a.f618b);
            a(xMPushService, a, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a.f618b);
            if (m404a == null || !z.e(a)) {
                return;
            }
            ev.a(xMPushService.getApplicationContext()).a(a.b(), z.b(a), m404a.m369a(), "Receive a message with wrong package name");
        } else {
            if (m404a != null && m404a.m369a() != null) {
                com.xiaomi.channel.commonutils.logger.b.m50a(String.format("receive a message, appid=%1$s, msgid= %2$s", a.m405a(), m404a.m369a()));
            }
            if (m404a != null && (m370a = m404a.m370a()) != null && m370a.containsKey("hide") && "true".equalsIgnoreCase(m370a.get("hide"))) {
                b(xMPushService, a);
                return;
            }
            if (m404a != null && m404a.m370a() != null && m404a.m370a().containsKey("__miid")) {
                String str3 = m404a.m370a().get("__miid");
                String a4 = com.xiaomi.push.t.a(xMPushService.getApplicationContext());
                if (TextUtils.isEmpty(a4) || !TextUtils.equals(str3, a4)) {
                    if (z.e(a)) {
                        ev.a(xMPushService.getApplicationContext()).a(a.b(), z.b(a), m404a.m369a(), "miid already logout or anther already login");
                    }
                    com.xiaomi.channel.commonutils.logger.b.m50a(str3 + " should be login, but got " + a4);
                    a(xMPushService, a, "miid already logout or anther already login", str3 + " should be login, but got " + a4);
                    return;
                }
            }
            a(xMPushService, a3, bArr, a2);
        }
    }

    private static boolean a(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                if (queryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    private static boolean a(ic icVar) {
        return "com.xiaomi.xmsf".equals(icVar.f618b) && icVar.m404a() != null && icVar.m404a().m370a() != null && icVar.m404a().m370a().containsKey("miui_package_name");
    }

    private static boolean a(XMPushService xMPushService, String str, ic icVar, ht htVar) {
        boolean z;
        if (htVar == null || htVar.m370a() == null || !htVar.m370a().containsKey("__check_alive") || !htVar.m370a().containsKey("__awake")) {
            return true;
        }
        Cif cif = new Cif();
        cif.b(icVar.m405a());
        cif.d(str);
        cif.c(hq.AwakeSystemApp.f490a);
        cif.a(htVar.m369a());
        cif.f630a = new HashMap();
        boolean m301a = com.xiaomi.push.g.m301a(xMPushService.getApplicationContext(), str);
        cif.f630a.put("app_running", Boolean.toString(m301a));
        try {
            if (!m301a) {
                boolean parseBoolean = Boolean.parseBoolean(htVar.m370a().get("__awake"));
                cif.f630a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                    w.a(xMPushService, w.a(icVar.b(), icVar.m405a(), cif, hg.Notification));
                    return z;
                }
            }
            w.a(xMPushService, w.a(icVar.b(), icVar.m405a(), cif, hg.Notification));
            return z;
        } catch (fx e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return z;
        }
        z = true;
    }

    private static void b(XMPushService xMPushService, ic icVar) {
        xMPushService.a(new r(4, xMPushService, icVar));
    }

    private static boolean b(ic icVar) {
        Map<String, String> m370a = icVar.m404a().m370a();
        return m370a != null && m370a.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, ic icVar) {
        xMPushService.a(new s(4, xMPushService, icVar));
    }

    private static boolean c(ic icVar) {
        if (icVar.m404a() == null || icVar.m404a().m370a() == null) {
            return false;
        }
        return "1".equals(icVar.m404a().m370a().get("obslete_ads_message"));
    }

    private static void d(XMPushService xMPushService, ic icVar) {
        xMPushService.a(new t(4, xMPushService, icVar));
    }

    public void a(Context context, al.b bVar, boolean z, int i, String str) {
        k a;
        if (z || (a = l.a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        try {
            l.a(context, a.f, a.d, a.e);
        } catch (IOException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        } catch (JSONException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public void a(XMPushService xMPushService, ff ffVar, al.b bVar) {
        try {
            a(xMPushService, ffVar.m277a(bVar.h), ffVar.c());
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public void a(XMPushService xMPushService, gd gdVar, al.b bVar) {
        if (!(gdVar instanceof gc)) {
            com.xiaomi.channel.commonutils.logger.b.m50a("not a mipush message");
            return;
        }
        gc gcVar = (gc) gdVar;
        ga a = gcVar.a("s");
        if (a != null) {
            try {
                a(xMPushService, au.a(au.a(bVar.h, gcVar.j()), a.c()), gr.a(gdVar.m308a()));
            } catch (IllegalArgumentException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
