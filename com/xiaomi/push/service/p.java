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
/* loaded from: classes18.dex */
public class p {
    public static Intent a(byte[] bArr, long j) {
        ii a2 = a(bArr);
        if (a2 == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a2.f608b);
        return intent;
    }

    public static ii a(Context context, ii iiVar) {
        ic icVar = new ic();
        icVar.b(iiVar.m422a());
        hz m421a = iiVar.m421a();
        if (m421a != null) {
            icVar.a(m421a.m380a());
            icVar.a(m421a.m378a());
            if (!TextUtils.isEmpty(m421a.m385b())) {
                icVar.c(m421a.m385b());
            }
        }
        icVar.a(iw.a(context, iiVar));
        ii a2 = w.a(iiVar.b(), iiVar.m422a(), icVar, hm.AckMessage);
        hz m379a = iiVar.m421a().m379a();
        m379a.a("mat", Long.toString(System.currentTimeMillis()));
        a2.a(m379a);
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
        hz m421a = a2.m421a();
        if (bArr != null) {
            df.a(a2.b(), xMPushService.getApplicationContext(), null, a2.a(), bArr.length);
        }
        if (c(a2) && a(xMPushService, str)) {
            if (aa.e(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m421a.m380a(), "5");
            }
            c(xMPushService, a2);
        } else if (a(a2) && !a(xMPushService, str) && !b(a2)) {
            if (aa.e(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m421a.m380a(), "6");
            }
            d(xMPushService, a2);
        } else if ((!aa.m536a(a2) || !com.xiaomi.push.g.m313b((Context) xMPushService, a2.f608b)) && !a(xMPushService, intent)) {
            if (!com.xiaomi.push.g.m313b((Context) xMPushService, a2.f608b)) {
                if (aa.e(a2)) {
                    fb.a(xMPushService.getApplicationContext()).b(a2.b(), aa.b(a2), m421a.m380a(), "2");
                }
                a(xMPushService, a2);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m57a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (aa.e(a2)) {
                fb.a(xMPushService.getApplicationContext()).b(a2.b(), aa.b(a2), m421a.m380a(), "3");
            }
        } else {
            if (hm.Registration == a2.a()) {
                String b = a2.b();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(b, a2.f604a);
                edit.commit();
                fb.a(xMPushService.getApplicationContext()).a(b, "E100003", m421a.m380a(), 6003, null);
                if (!TextUtils.isEmpty(m421a.m380a())) {
                    intent.putExtra("messageId", m421a.m380a());
                    intent.putExtra("eventMessageType", 6000);
                }
            }
            if (aa.c(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m421a.m380a(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m421a.m380a())) {
                    intent.putExtra("messageId", m421a.m380a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (aa.m540b(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m421a.m380a(), 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m421a.m380a())) {
                    intent.putExtra("messageId", m421a.m380a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (aa.m536a(a2)) {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m421a.m380a(), 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m421a.m380a())) {
                    intent.putExtra("messageId", m421a.m380a());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (m421a != null && !TextUtils.isEmpty(m421a.m388c()) && !TextUtils.isEmpty(m421a.d()) && m421a.f516b != 1 && (aa.m537a(m421a.m381a()) || !aa.m535a((Context) xMPushService, a2.f608b))) {
                boolean z = false;
                if (m421a != null) {
                    r0 = m421a.f514a != null ? m421a.f514a.get("jobkey") : null;
                    if (TextUtils.isEmpty(r0)) {
                        r0 = m421a.m380a();
                    }
                    z = ac.a(xMPushService, a2.f608b, r0);
                }
                if (z) {
                    fb.a(xMPushService.getApplicationContext()).c(a2.b(), aa.b(a2), m421a.m380a(), "1:" + r0);
                    com.xiaomi.channel.commonutils.logger.b.m57a("drop a duplicate message, key=" + r0);
                } else {
                    aa.c m533a = aa.m533a((Context) xMPushService, a2, bArr);
                    if (m533a.f5042a > 0 && !TextUtils.isEmpty(m533a.f837a)) {
                        gx.a(xMPushService, m533a.f837a, m533a.f5042a, true, false, System.currentTimeMillis());
                    }
                    if (!aa.m536a(a2)) {
                        Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                        intent2.putExtra("mipush_payload", bArr);
                        intent2.setPackage(a2.f608b);
                        try {
                            List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                            if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                xMPushService.sendBroadcast(intent2, w.a(a2.f608b));
                            }
                        } catch (Exception e) {
                            xMPushService.sendBroadcast(intent2, w.a(a2.f608b));
                            if (e != null) {
                                fb.a(xMPushService.getApplicationContext()).b(a2.b(), aa.b(a2), m421a.m380a(), "1");
                            }
                        }
                    }
                }
                b(xMPushService, a2);
            } else if ("com.xiaomi.xmsf".contains(a2.f608b) && !a2.m429b() && m421a != null && m421a.m381a() != null && m421a.m381a().containsKey("ab")) {
                b(xMPushService, a2);
                com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m421a.m380a());
            } else if (a(xMPushService, str, a2, m421a)) {
                if (m421a != null && !TextUtils.isEmpty(m421a.m380a())) {
                    if (aa.m540b(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m421a.m380a(), 2002, null);
                    } else if (aa.m536a(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m421a.m380a(), "7");
                    } else if (aa.c(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m421a.m380a(), "8");
                    } else if (aa.d(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), "E100003", m421a.m380a(), 6004, null);
                    }
                }
                xMPushService.sendBroadcast(intent, w.a(a2.f608b));
            } else {
                fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m421a.m380a(), "9");
            }
            if (a2.a() != hm.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> m381a;
        ii a2 = a(bArr);
        if (a2 == null) {
            return;
        }
        if (TextUtils.isEmpty(a2.f608b)) {
            com.xiaomi.channel.commonutils.logger.b.m57a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a3 = a(bArr, valueOf.longValue());
        String a4 = aa.a(a2);
        gx.a(xMPushService, a4, j, true, true, System.currentTimeMillis());
        hz m421a = a2.m421a();
        if (m421a != null) {
            m421a.a("mrt", Long.toString(valueOf.longValue()));
        }
        if (hm.SendMessage == a2.a() && m.a(xMPushService).m583a(a2.f608b) && !aa.m536a(a2)) {
            String str = "";
            if (m421a != null) {
                str = m421a.m380a();
                if (aa.e(a2)) {
                    fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), str, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m57a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a2, a2.f608b);
        } else if (hm.SendMessage == a2.a() && m.a(xMPushService).m585c(a2.f608b) && !aa.m536a(a2)) {
            String str2 = "";
            if (m421a != null) {
                str2 = m421a.m380a();
                if (aa.e(a2)) {
                    fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), str2, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m57a("Drop a message for push closed, msgid=" + str2);
            a(xMPushService, a2, a2.f608b);
        } else if (hm.SendMessage == a2.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a2.f608b)) {
            com.xiaomi.channel.commonutils.logger.b.m57a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a2.f608b);
            a(xMPushService, a2, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a2.f608b);
            if (m421a == null || !aa.e(a2)) {
                return;
            }
            fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m421a.m380a(), "3");
        } else {
            if (m421a != null && m421a.m380a() != null) {
                com.xiaomi.channel.commonutils.logger.b.m57a(String.format("receive a message, appid=%1$s, msgid= %2$s", a2.m422a(), m421a.m380a()));
            }
            if (m421a != null && (m381a = m421a.m381a()) != null && m381a.containsKey("hide") && "true".equalsIgnoreCase(m381a.get("hide"))) {
                b(xMPushService, a2);
                return;
            }
            if (m421a != null && m421a.m381a() != null && m421a.m381a().containsKey("__miid")) {
                String str3 = m421a.m381a().get("__miid");
                String a5 = com.xiaomi.push.t.a(xMPushService.getApplicationContext());
                if (TextUtils.isEmpty(a5) || !TextUtils.equals(str3, a5)) {
                    if (aa.e(a2)) {
                        fb.a(xMPushService.getApplicationContext()).a(a2.b(), aa.b(a2), m421a.m380a(), "4");
                    }
                    com.xiaomi.channel.commonutils.logger.b.m57a(str3 + " should be login, but got " + a5);
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
        return "com.xiaomi.xmsf".equals(iiVar.f608b) && iiVar.m421a() != null && iiVar.m421a().m381a() != null && iiVar.m421a().m381a().containsKey("miui_package_name");
    }

    private static boolean a(XMPushService xMPushService, String str, ii iiVar, hz hzVar) {
        boolean z;
        if (hzVar == null || hzVar.m381a() == null || !hzVar.m381a().containsKey("__check_alive") || !hzVar.m381a().containsKey("__awake")) {
            return true;
        }
        il ilVar = new il();
        ilVar.b(iiVar.m422a());
        ilVar.d(str);
        ilVar.c(hw.AwakeSystemApp.f479a);
        ilVar.a(hzVar.m380a());
        ilVar.f620a = new HashMap();
        boolean m312a = com.xiaomi.push.g.m312a(xMPushService.getApplicationContext(), str);
        ilVar.f620a.put("app_running", Boolean.toString(m312a));
        try {
            if (!m312a) {
                boolean parseBoolean = Boolean.parseBoolean(hzVar.m381a().get("__awake"));
                ilVar.f620a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                    w.a(xMPushService, w.a(iiVar.b(), iiVar.m422a(), ilVar, hm.Notification));
                    return z;
                }
            }
            w.a(xMPushService, w.a(iiVar.b(), iiVar.m422a(), ilVar, hm.Notification));
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
        Map<String, String> m381a = iiVar.m421a().m381a();
        return m381a != null && m381a.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, ii iiVar) {
        xMPushService.a(new s(4, xMPushService, iiVar));
    }

    private static boolean c(ii iiVar) {
        if (iiVar.m421a() == null || iiVar.m421a().m381a() == null) {
            return false;
        }
        return "1".equals(iiVar.m421a().m381a().get("obslete_ads_message"));
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
            a(xMPushService, flVar.m288a(bVar.h), flVar.c());
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public void a(XMPushService xMPushService, gj gjVar, ap.b bVar) {
        if (!(gjVar instanceof gi)) {
            com.xiaomi.channel.commonutils.logger.b.m57a("not a mipush message");
            return;
        }
        gi giVar = (gi) gjVar;
        gg a2 = giVar.a("s");
        if (a2 != null) {
            try {
                a(xMPushService, ay.a(ay.a(bVar.h, giVar.j()), a2.c()), gx.a(gjVar.m319a()));
            } catch (IllegalArgumentException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
