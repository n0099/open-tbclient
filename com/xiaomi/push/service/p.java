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
/* loaded from: classes6.dex */
public class p {
    public static Intent a(byte[] bArr, long j) {
        ii a2 = a(bArr);
        if (a2 == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a2.f684b);
        return intent;
    }

    public static ii a(Context context, ii iiVar) {
        ic icVar = new ic();
        icVar.b(iiVar.m438a());
        hz m437a = iiVar.m437a();
        if (m437a != null) {
            icVar.a(m437a.m396a());
            icVar.a(m437a.m394a());
            if (!TextUtils.isEmpty(m437a.m401b())) {
                icVar.c(m437a.m401b());
            }
        }
        icVar.a(iw.a(context, iiVar));
        ii a2 = w.a(iiVar.b(), iiVar.m438a(), icVar, hm.AckMessage);
        hz m395a = iiVar.m437a().m395a();
        m395a.a("mat", Long.toString(System.currentTimeMillis()));
        a2.a(m395a);
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
        hz m437a = a2.m437a();
        if (bArr != null) {
            df.a(a2.b(), xMPushService.getApplicationContext(), null, a2.a(), bArr.length);
        }
        if (c(a2) && a(xMPushService, str)) {
            if (aa.e(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m437a.m396a(), "5");
            }
            c(xMPushService, a2);
        } else if (a(a2) && !a(xMPushService, str) && !b(a2)) {
            if (aa.e(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m437a.m396a(), "6");
            }
            d(xMPushService, a2);
        } else if ((!aa.m552a(a2) || !com.xiaomi.push.g.m329b((Context) xMPushService, a2.f684b)) && !a(xMPushService, intent)) {
            if (!com.xiaomi.push.g.m329b((Context) xMPushService, a2.f684b)) {
                if (aa.e(a2)) {
                    fb.a(xMPushService.getApplicationContext()).b(a2.b(), aa.b(a2), m437a.m396a(), "2");
                }
                a(xMPushService, a2);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m73a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (aa.e(a2)) {
                fb.a(xMPushService.getApplicationContext()).b(a2.b(), aa.b(a2), m437a.m396a(), "3");
            }
        } else {
            if (hm.Registration == a2.a()) {
                String b2 = a2.b();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(b2, a2.f680a);
                edit.commit();
                fb.a(xMPushService.getApplicationContext()).a(b2, "E100003", m437a.m396a(), 6003, null);
                if (!TextUtils.isEmpty(m437a.m396a())) {
                    intent.putExtra("messageId", m437a.m396a());
                    intent.putExtra("eventMessageType", 6000);
                }
            }
            if (aa.c(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m437a.m396a(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m437a.m396a())) {
                    intent.putExtra("messageId", m437a.m396a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (aa.m556b(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m437a.m396a(), 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m437a.m396a())) {
                    intent.putExtra("messageId", m437a.m396a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (aa.m552a(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m437a.m396a(), 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m437a.m396a())) {
                    intent.putExtra("messageId", m437a.m396a());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (m437a != null && !TextUtils.isEmpty(m437a.m404c()) && !TextUtils.isEmpty(m437a.d()) && m437a.f592b != 1 && (aa.m553a(m437a.m397a()) || !aa.m551a((Context) xMPushService, a2.f684b))) {
                boolean z = false;
                if (m437a != null) {
                    r0 = m437a.f590a != null ? m437a.f590a.get("jobkey") : null;
                    if (TextUtils.isEmpty(r0)) {
                        r0 = m437a.m396a();
                    }
                    z = ac.a(xMPushService, a2.f684b, r0);
                }
                if (z) {
                    fb.a(xMPushService.getApplicationContext()).c(a2.b(), aa.b(a2), m437a.m396a(), "1:" + r0);
                    com.xiaomi.channel.commonutils.logger.b.m73a("drop a duplicate message, key=" + r0);
                } else {
                    aa.c m549a = aa.m549a((Context) xMPushService, a2, bArr);
                    if (m549a.f14522a > 0 && !TextUtils.isEmpty(m549a.f913a)) {
                        gx.a(xMPushService, m549a.f913a, m549a.f14522a, true, false, System.currentTimeMillis());
                    }
                    if (!aa.m552a(a2)) {
                        Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                        intent2.putExtra("mipush_payload", bArr);
                        intent2.setPackage(a2.f684b);
                        try {
                            List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                            if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                xMPushService.sendBroadcast(intent2, w.a(a2.f684b));
                            }
                        } catch (Exception e) {
                            xMPushService.sendBroadcast(intent2, w.a(a2.f684b));
                            if (e != null) {
                                fb.a(xMPushService.getApplicationContext()).b(a2.b(), aa.b(a2), m437a.m396a(), "1");
                            }
                        }
                    }
                }
                b(xMPushService, a2);
            } else if ("com.xiaomi.xmsf".contains(a2.f684b) && !a2.m445b() && m437a != null && m437a.m397a() != null && m437a.m397a().containsKey("ab")) {
                b(xMPushService, a2);
                com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m437a.m396a());
            } else if (a(xMPushService, str, a2, m437a)) {
                if (m437a != null && !TextUtils.isEmpty(m437a.m396a())) {
                    if (aa.m556b(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m437a.m396a(), 2002, null);
                    } else if (aa.m552a(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m437a.m396a(), "7");
                    } else if (aa.c(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m437a.m396a(), "8");
                    } else if (aa.d(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), "E100003", m437a.m396a(), 6004, null);
                    }
                }
                xMPushService.sendBroadcast(intent, w.a(a2.f684b));
            } else {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m437a.m396a(), "9");
            }
            if (a2.a() != hm.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> m397a;
        ii a2 = a(bArr);
        if (a2 == null) {
            return;
        }
        if (TextUtils.isEmpty(a2.f684b)) {
            com.xiaomi.channel.commonutils.logger.b.m73a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a3 = a(bArr, valueOf.longValue());
        String a4 = aa.a(a2);
        gx.a(xMPushService, a4, j, true, true, System.currentTimeMillis());
        hz m437a = a2.m437a();
        if (m437a != null) {
            m437a.a("mrt", Long.toString(valueOf.longValue()));
        }
        if (hm.SendMessage == a2.a() && m.a(xMPushService).m599a(a2.f684b) && !aa.m552a(a2)) {
            String str = "";
            if (m437a != null) {
                str = m437a.m396a();
                if (aa.e(a2)) {
                    fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), str, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m73a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a2, a2.f684b);
        } else if (hm.SendMessage == a2.a() && m.a(xMPushService).m601c(a2.f684b) && !aa.m552a(a2)) {
            String str2 = "";
            if (m437a != null) {
                str2 = m437a.m396a();
                if (aa.e(a2)) {
                    fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), str2, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m73a("Drop a message for push closed, msgid=" + str2);
            a(xMPushService, a2, a2.f684b);
        } else if (hm.SendMessage == a2.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a2.f684b)) {
            com.xiaomi.channel.commonutils.logger.b.m73a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a2.f684b);
            a(xMPushService, a2, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a2.f684b);
            if (m437a == null || !aa.e(a2)) {
                return;
            }
            fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m437a.m396a(), "3");
        } else {
            if (m437a != null && m437a.m396a() != null) {
                com.xiaomi.channel.commonutils.logger.b.m73a(String.format("receive a message, appid=%1$s, msgid= %2$s", a2.m438a(), m437a.m396a()));
            }
            if (m437a != null && (m397a = m437a.m397a()) != null && m397a.containsKey("hide") && "true".equalsIgnoreCase(m397a.get("hide"))) {
                b(xMPushService, a2);
                return;
            }
            if (m437a != null && m437a.m397a() != null && m437a.m397a().containsKey("__miid")) {
                String str3 = m437a.m397a().get("__miid");
                String a5 = com.xiaomi.push.t.a(xMPushService.getApplicationContext());
                if (TextUtils.isEmpty(a5) || !TextUtils.equals(str3, a5)) {
                    if (aa.e(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m437a.m396a(), "4");
                    }
                    com.xiaomi.channel.commonutils.logger.b.m73a(str3 + " should be login, but got " + a5);
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
        return "com.xiaomi.xmsf".equals(iiVar.f684b) && iiVar.m437a() != null && iiVar.m437a().m397a() != null && iiVar.m437a().m397a().containsKey("miui_package_name");
    }

    private static boolean a(XMPushService xMPushService, String str, ii iiVar, hz hzVar) {
        boolean z;
        if (hzVar == null || hzVar.m397a() == null || !hzVar.m397a().containsKey("__check_alive") || !hzVar.m397a().containsKey("__awake")) {
            return true;
        }
        il ilVar = new il();
        ilVar.b(iiVar.m438a());
        ilVar.d(str);
        ilVar.c(hw.AwakeSystemApp.f555a);
        ilVar.a(hzVar.m396a());
        ilVar.f696a = new HashMap();
        boolean m328a = com.xiaomi.push.g.m328a(xMPushService.getApplicationContext(), str);
        ilVar.f696a.put("app_running", Boolean.toString(m328a));
        try {
            if (!m328a) {
                boolean parseBoolean = Boolean.parseBoolean(hzVar.m397a().get("__awake"));
                ilVar.f696a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                    w.a(xMPushService, w.a(iiVar.b(), iiVar.m438a(), ilVar, hm.Notification));
                    return z;
                }
            }
            w.a(xMPushService, w.a(iiVar.b(), iiVar.m438a(), ilVar, hm.Notification));
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
        Map<String, String> m397a = iiVar.m437a().m397a();
        return m397a != null && m397a.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, ii iiVar) {
        xMPushService.a(new s(4, xMPushService, iiVar));
    }

    private static boolean c(ii iiVar) {
        if (iiVar.m437a() == null || iiVar.m437a().m397a() == null) {
            return false;
        }
        return "1".equals(iiVar.m437a().m397a().get("obslete_ads_message"));
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
            a(xMPushService, flVar.m304a(bVar.h), flVar.c());
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public void a(XMPushService xMPushService, gj gjVar, ap.b bVar) {
        if (!(gjVar instanceof gi)) {
            com.xiaomi.channel.commonutils.logger.b.m73a("not a mipush message");
            return;
        }
        gi giVar = (gi) gjVar;
        gg a2 = giVar.a("s");
        if (a2 != null) {
            try {
                a(xMPushService, ay.a(ay.a(bVar.h, giVar.j()), a2.c()), gx.a(gjVar.m335a()));
            } catch (IllegalArgumentException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
