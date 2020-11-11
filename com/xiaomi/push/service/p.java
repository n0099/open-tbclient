package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.df;
import com.xiaomi.push.fb;
import com.xiaomi.push.fl;
import com.xiaomi.push.gd;
import com.xiaomi.push.gg;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gx;
import com.xiaomi.push.hm;
import com.xiaomi.push.hw;
import com.xiaomi.push.hz;
import com.xiaomi.push.ic;
import com.xiaomi.push.ii;
import com.xiaomi.push.il;
import com.xiaomi.push.iw;
import com.xiaomi.push.service.aa;
import com.xiaomi.push.service.ap;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
/* loaded from: classes12.dex */
public class p {
    public static Intent a(byte[] bArr, long j) {
        ii a2 = a(bArr);
        if (a2 == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a2.f605b);
        return intent;
    }

    public static ii a(Context context, ii iiVar) {
        ic icVar = new ic();
        icVar.b(iiVar.m419a());
        hz m418a = iiVar.m418a();
        if (m418a != null) {
            icVar.a(m418a.m377a());
            icVar.a(m418a.m375a());
            if (!TextUtils.isEmpty(m418a.m382b())) {
                icVar.c(m418a.m382b());
            }
        }
        icVar.a(iw.a(context, iiVar));
        ii a2 = w.a(iiVar.b(), iiVar.m419a(), icVar, hm.AckMessage);
        hz m376a = iiVar.m418a().m376a();
        m376a.a("mat", Long.toString(System.currentTimeMillis()));
        a2.a(m376a);
        return a2;
    }

    public static ii a(byte[] bArr) {
        ii iiVar = new ii();
        try {
            iw.a(iiVar, bArr);
            return iiVar;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    private static void a(XMPushService xMPushService, ii iiVar) {
        xMPushService.a(new q(4, xMPushService, iiVar));
    }

    private static void a(XMPushService xMPushService, ii iiVar, String str) {
        xMPushService.a(new u(4, xMPushService, iiVar, str));
    }

    private static void a(XMPushService xMPushService, ii iiVar, String str, String str2) {
        xMPushService.a(new v(4, xMPushService, iiVar, str, str2));
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent) {
        ii a2 = a(bArr);
        hz m418a = a2.m418a();
        if (bArr != null) {
            df.a(a2.b(), xMPushService.getApplicationContext(), null, a2.a(), bArr.length);
        }
        if (c(a2) && a(xMPushService, str)) {
            if (aa.e(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m418a.m377a(), "5");
            }
            c(xMPushService, a2);
        } else if (a(a2) && !a(xMPushService, str) && !b(a2)) {
            if (aa.e(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m418a.m377a(), "6");
            }
            d(xMPushService, a2);
        } else if ((!aa.m533a(a2) || !com.xiaomi.push.g.m310b((Context) xMPushService, a2.f605b)) && !a(xMPushService, intent)) {
            if (!com.xiaomi.push.g.m310b((Context) xMPushService, a2.f605b)) {
                if (aa.e(a2)) {
                    fb.a(xMPushService.getApplicationContext()).b(a2.b(), aa.b(a2), m418a.m377a(), "2");
                }
                a(xMPushService, a2);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (aa.e(a2)) {
                fb.a(xMPushService.getApplicationContext()).b(a2.b(), aa.b(a2), m418a.m377a(), "3");
            }
        } else {
            if (hm.Registration == a2.a()) {
                String b = a2.b();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(b, a2.f601a);
                edit.commit();
                fb.a(xMPushService.getApplicationContext()).a(b, "E100003", m418a.m377a(), 6003, null);
                if (!TextUtils.isEmpty(m418a.m377a())) {
                    intent.putExtra("messageId", m418a.m377a());
                    intent.putExtra("eventMessageType", 6000);
                }
            }
            if (aa.c(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m418a.m377a(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m418a.m377a())) {
                    intent.putExtra("messageId", m418a.m377a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (aa.m537b(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m418a.m377a(), 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m418a.m377a())) {
                    intent.putExtra("messageId", m418a.m377a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (aa.m533a(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m418a.m377a(), 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m418a.m377a())) {
                    intent.putExtra("messageId", m418a.m377a());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (m418a != null && !TextUtils.isEmpty(m418a.m385c()) && !TextUtils.isEmpty(m418a.d()) && m418a.f513b != 1 && (aa.m534a(m418a.m378a()) || !aa.m532a((Context) xMPushService, a2.f605b))) {
                boolean z = false;
                if (m418a != null) {
                    r0 = m418a.f511a != null ? m418a.f511a.get("jobkey") : null;
                    if (TextUtils.isEmpty(r0)) {
                        r0 = m418a.m377a();
                    }
                    z = ac.a(xMPushService, a2.f605b, r0);
                }
                if (z) {
                    fb.a(xMPushService.getApplicationContext()).c(a2.b(), aa.b(a2), m418a.m377a(), "1:" + r0);
                    com.xiaomi.channel.commonutils.logger.b.m54a("drop a duplicate message, key=" + r0);
                } else {
                    aa.c m530a = aa.m530a((Context) xMPushService, a2, bArr);
                    if (m530a.f5042a > 0 && !TextUtils.isEmpty(m530a.f834a)) {
                        gx.a(xMPushService, m530a.f834a, m530a.f5042a, true, false, System.currentTimeMillis());
                    }
                    if (!aa.m533a(a2)) {
                        Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                        intent2.putExtra("mipush_payload", bArr);
                        intent2.setPackage(a2.f605b);
                        try {
                            List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                            if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                xMPushService.sendBroadcast(intent2, w.a(a2.f605b));
                            }
                        } catch (Exception e) {
                            xMPushService.sendBroadcast(intent2, w.a(a2.f605b));
                            if (e != null) {
                                fb.a(xMPushService.getApplicationContext()).b(a2.b(), aa.b(a2), m418a.m377a(), "1");
                            }
                        }
                    }
                }
                b(xMPushService, a2);
            } else if ("com.xiaomi.xmsf".contains(a2.f605b) && !a2.m426b() && m418a != null && m418a.m378a() != null && m418a.m378a().containsKey("ab")) {
                b(xMPushService, a2);
                com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m418a.m377a());
            } else if (a(xMPushService, str, a2, m418a)) {
                if (m418a != null && !TextUtils.isEmpty(m418a.m377a())) {
                    if (aa.m537b(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m418a.m377a(), 2002, null);
                    } else if (aa.m533a(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m418a.m377a(), "7");
                    } else if (aa.c(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m418a.m377a(), "8");
                    } else if (aa.d(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), "E100003", m418a.m377a(), 6004, null);
                    }
                }
                xMPushService.sendBroadcast(intent, w.a(a2.f605b));
            } else {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m418a.m377a(), "9");
            }
            if (a2.a() != hm.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> m378a;
        ii a2 = a(bArr);
        if (a2 == null) {
            return;
        }
        if (TextUtils.isEmpty(a2.f605b)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a3 = a(bArr, valueOf.longValue());
        String a4 = aa.a(a2);
        gx.a(xMPushService, a4, j, true, true, System.currentTimeMillis());
        hz m418a = a2.m418a();
        if (m418a != null) {
            m418a.a("mrt", Long.toString(valueOf.longValue()));
        }
        if (hm.SendMessage == a2.a() && m.a(xMPushService).m580a(a2.f605b) && !aa.m533a(a2)) {
            String str = "";
            if (m418a != null) {
                str = m418a.m377a();
                if (aa.e(a2)) {
                    fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), str, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a2, a2.f605b);
        } else if (hm.SendMessage == a2.a() && m.a(xMPushService).m582c(a2.f605b) && !aa.m533a(a2)) {
            String str2 = "";
            if (m418a != null) {
                str2 = m418a.m377a();
                if (aa.e(a2)) {
                    fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), str2, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m54a("Drop a message for push closed, msgid=" + str2);
            a(xMPushService, a2, a2.f605b);
        } else if (hm.SendMessage == a2.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a2.f605b)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a2.f605b);
            a(xMPushService, a2, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a2.f605b);
            if (m418a == null || !aa.e(a2)) {
                return;
            }
            fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m418a.m377a(), "3");
        } else {
            if (m418a != null && m418a.m377a() != null) {
                com.xiaomi.channel.commonutils.logger.b.m54a(String.format("receive a message, appid=%1$s, msgid= %2$s", a2.m419a(), m418a.m377a()));
            }
            if (m418a != null && (m378a = m418a.m378a()) != null && m378a.containsKey("hide") && "true".equalsIgnoreCase(m378a.get("hide"))) {
                b(xMPushService, a2);
                return;
            }
            if (m418a != null && m418a.m378a() != null && m418a.m378a().containsKey("__miid")) {
                String str3 = m418a.m378a().get("__miid");
                String a5 = com.xiaomi.push.t.a(xMPushService.getApplicationContext());
                if (TextUtils.isEmpty(a5) || !TextUtils.equals(str3, a5)) {
                    if (aa.e(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m418a.m377a(), "4");
                    }
                    com.xiaomi.channel.commonutils.logger.b.m54a(str3 + " should be login, but got " + a5);
                    a(xMPushService, a2, "miid already logout or anther already login", str3 + " should be login, but got " + a5);
                    return;
                }
            }
            a(xMPushService, a4, bArr, a3);
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

    private static boolean a(ii iiVar) {
        return "com.xiaomi.xmsf".equals(iiVar.f605b) && iiVar.m418a() != null && iiVar.m418a().m378a() != null && iiVar.m418a().m378a().containsKey("miui_package_name");
    }

    private static boolean a(XMPushService xMPushService, String str, ii iiVar, hz hzVar) {
        boolean z;
        if (hzVar == null || hzVar.m378a() == null || !hzVar.m378a().containsKey("__check_alive") || !hzVar.m378a().containsKey("__awake")) {
            return true;
        }
        il ilVar = new il();
        ilVar.b(iiVar.m419a());
        ilVar.d(str);
        ilVar.c(hw.AwakeSystemApp.f476a);
        ilVar.a(hzVar.m377a());
        ilVar.f617a = new HashMap();
        boolean m309a = com.xiaomi.push.g.m309a(xMPushService.getApplicationContext(), str);
        ilVar.f617a.put("app_running", Boolean.toString(m309a));
        try {
            if (!m309a) {
                boolean parseBoolean = Boolean.parseBoolean(hzVar.m378a().get("__awake"));
                ilVar.f617a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                    w.a(xMPushService, w.a(iiVar.b(), iiVar.m419a(), ilVar, hm.Notification));
                    return z;
                }
            }
            w.a(xMPushService, w.a(iiVar.b(), iiVar.m419a(), ilVar, hm.Notification));
            return z;
        } catch (gd e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return z;
        }
        z = true;
    }

    private static void b(XMPushService xMPushService, ii iiVar) {
        xMPushService.a(new r(4, xMPushService, iiVar));
    }

    private static boolean b(ii iiVar) {
        Map<String, String> m378a = iiVar.m418a().m378a();
        return m378a != null && m378a.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, ii iiVar) {
        xMPushService.a(new s(4, xMPushService, iiVar));
    }

    private static boolean c(ii iiVar) {
        if (iiVar.m418a() == null || iiVar.m418a().m378a() == null) {
            return false;
        }
        return "1".equals(iiVar.m418a().m378a().get("obslete_ads_message"));
    }

    private static void d(XMPushService xMPushService, ii iiVar) {
        xMPushService.a(new t(4, xMPushService, iiVar));
    }

    public void a(Context context, ap.b bVar, boolean z, int i, String str) {
        k a2;
        if (z || (a2 = l.a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        try {
            l.a(context, a2.f, a2.d, a2.e);
        } catch (IOException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        } catch (JSONException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public void a(XMPushService xMPushService, fl flVar, ap.b bVar) {
        try {
            a(xMPushService, flVar.m285a(bVar.h), flVar.c());
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public void a(XMPushService xMPushService, gj gjVar, ap.b bVar) {
        if (!(gjVar instanceof gi)) {
            com.xiaomi.channel.commonutils.logger.b.m54a("not a mipush message");
            return;
        }
        gi giVar = (gi) gjVar;
        gg a2 = giVar.a("s");
        if (a2 != null) {
            try {
                a(xMPushService, ay.a(ay.a(bVar.h, giVar.j()), a2.c()), gx.a(gjVar.m316a()));
            } catch (IllegalArgumentException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
