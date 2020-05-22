package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
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
/* loaded from: classes8.dex */
public class p {
    public static Intent a(byte[] bArr, long j) {
        ii a = a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a.f604b);
        return intent;
    }

    public static ii a(Context context, ii iiVar) {
        ic icVar = new ic();
        icVar.b(iiVar.m417a());
        hz m416a = iiVar.m416a();
        if (m416a != null) {
            icVar.a(m416a.m375a());
            icVar.a(m416a.m373a());
            if (!TextUtils.isEmpty(m416a.m380b())) {
                icVar.c(m416a.m380b());
            }
        }
        icVar.a(iw.a(context, iiVar));
        ii a = w.a(iiVar.b(), iiVar.m417a(), icVar, hm.AckMessage);
        hz m374a = iiVar.m416a().m374a();
        m374a.a("mat", Long.toString(System.currentTimeMillis()));
        a.a(m374a);
        return a;
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
        ii a = a(bArr);
        hz m416a = a.m416a();
        if (bArr != null) {
            df.a(a.b(), xMPushService.getApplicationContext(), null, a.a(), bArr.length);
        }
        if (c(a) && a(xMPushService, str)) {
            if (aa.e(a)) {
                fb.a(xMPushService.getApplicationContext()).a(a.b(), aa.b(a), m416a.m375a(), "5");
            }
            c(xMPushService, a);
        } else if (a(a) && !a(xMPushService, str) && !b(a)) {
            if (aa.e(a)) {
                fb.a(xMPushService.getApplicationContext()).a(a.b(), aa.b(a), m416a.m375a(), "6");
            }
            d(xMPushService, a);
        } else if ((!aa.m531a(a) || !com.xiaomi.push.g.m308b((Context) xMPushService, a.f604b)) && !a(xMPushService, intent)) {
            if (!com.xiaomi.push.g.m308b((Context) xMPushService, a.f604b)) {
                if (aa.e(a)) {
                    fb.a(xMPushService.getApplicationContext()).b(a.b(), aa.b(a), m416a.m375a(), "2");
                }
                a(xMPushService, a);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.m52a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (aa.e(a)) {
                fb.a(xMPushService.getApplicationContext()).b(a.b(), aa.b(a), m416a.m375a(), "3");
            }
        } else {
            if (hm.Registration == a.a()) {
                String b = a.b();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(b, a.f600a);
                edit.commit();
                fb.a(xMPushService.getApplicationContext()).a(b, "E100003", m416a.m375a(), 6003, null);
                if (!TextUtils.isEmpty(m416a.m375a())) {
                    intent.putExtra("messageId", m416a.m375a());
                    intent.putExtra("eventMessageType", SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME);
                }
            }
            if (aa.c(a)) {
                fb.a(xMPushService.getApplicationContext()).a(a.b(), aa.b(a), m416a.m375a(), 1001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m416a.m375a())) {
                    intent.putExtra("messageId", m416a.m375a());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (aa.m535b(a)) {
                fb.a(xMPushService.getApplicationContext()).a(a.b(), aa.b(a), m416a.m375a(), 2001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m416a.m375a())) {
                    intent.putExtra("messageId", m416a.m375a());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (aa.m531a(a)) {
                fb.a(xMPushService.getApplicationContext()).a(a.b(), aa.b(a), m416a.m375a(), 3001, System.currentTimeMillis(), null);
                if (!TextUtils.isEmpty(m416a.m375a())) {
                    intent.putExtra("messageId", m416a.m375a());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (m416a != null && !TextUtils.isEmpty(m416a.m383c()) && !TextUtils.isEmpty(m416a.d()) && m416a.f512b != 1 && (aa.m532a(m416a.m376a()) || !aa.m530a((Context) xMPushService, a.f604b))) {
                boolean z = false;
                if (m416a != null) {
                    r0 = m416a.f510a != null ? m416a.f510a.get("jobkey") : null;
                    if (TextUtils.isEmpty(r0)) {
                        r0 = m416a.m375a();
                    }
                    z = ac.a(xMPushService, a.f604b, r0);
                }
                if (z) {
                    fb.a(xMPushService.getApplicationContext()).c(a.b(), aa.b(a), m416a.m375a(), "1:" + r0);
                    com.xiaomi.channel.commonutils.logger.b.m52a("drop a duplicate message, key=" + r0);
                } else {
                    aa.c m528a = aa.m528a((Context) xMPushService, a, bArr);
                    if (m528a.a > 0 && !TextUtils.isEmpty(m528a.f833a)) {
                        gx.a(xMPushService, m528a.f833a, m528a.a, true, false, System.currentTimeMillis());
                    }
                    if (!aa.m531a(a)) {
                        Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                        intent2.putExtra("mipush_payload", bArr);
                        intent2.setPackage(a.f604b);
                        try {
                            List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                            if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                xMPushService.sendBroadcast(intent2, w.a(a.f604b));
                            }
                        } catch (Exception e) {
                            xMPushService.sendBroadcast(intent2, w.a(a.f604b));
                            if (e != null) {
                                fb.a(xMPushService.getApplicationContext()).b(a.b(), aa.b(a), m416a.m375a(), "1");
                            }
                        }
                    }
                }
                b(xMPushService, a);
            } else if ("com.xiaomi.xmsf".contains(a.f604b) && !a.m424b() && m416a != null && m416a.m376a() != null && m416a.m376a().containsKey("ab")) {
                b(xMPushService, a);
                com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m416a.m375a());
            } else if (a(xMPushService, str, a, m416a)) {
                if (m416a != null && !TextUtils.isEmpty(m416a.m375a())) {
                    if (aa.m535b(a)) {
                        fb.a(xMPushService.getApplicationContext()).a(a.b(), aa.b(a), m416a.m375a(), 2002, null);
                    } else if (aa.m531a(a)) {
                        fb.a(xMPushService.getApplicationContext()).a(a.b(), aa.b(a), m416a.m375a(), "7");
                    } else if (aa.c(a)) {
                        fb.a(xMPushService.getApplicationContext()).a(a.b(), aa.b(a), m416a.m375a(), "8");
                    } else if (aa.d(a)) {
                        fb.a(xMPushService.getApplicationContext()).a(a.b(), "E100003", m416a.m375a(), 6004, null);
                    }
                }
                xMPushService.sendBroadcast(intent, w.a(a.f604b));
            } else {
                fb.a(xMPushService.getApplicationContext()).a(a.b(), aa.b(a), m416a.m375a(), "9");
            }
            if (a.a() != hm.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> m376a;
        ii a = a(bArr);
        if (a == null) {
            return;
        }
        if (TextUtils.isEmpty(a.f604b)) {
            com.xiaomi.channel.commonutils.logger.b.m52a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a2 = a(bArr, valueOf.longValue());
        String a3 = aa.a(a);
        gx.a(xMPushService, a3, j, true, true, System.currentTimeMillis());
        hz m416a = a.m416a();
        if (m416a != null) {
            m416a.a("mrt", Long.toString(valueOf.longValue()));
        }
        if (hm.SendMessage == a.a() && m.a(xMPushService).m578a(a.f604b) && !aa.m531a(a)) {
            String str = "";
            if (m416a != null) {
                str = m416a.m375a();
                if (aa.e(a)) {
                    fb.a(xMPushService.getApplicationContext()).a(a.b(), aa.b(a), str, "1");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m52a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a, a.f604b);
        } else if (hm.SendMessage == a.a() && m.a(xMPushService).m580c(a.f604b) && !aa.m531a(a)) {
            String str2 = "";
            if (m416a != null) {
                str2 = m416a.m375a();
                if (aa.e(a)) {
                    fb.a(xMPushService.getApplicationContext()).a(a.b(), aa.b(a), str2, "2");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.m52a("Drop a message for push closed, msgid=" + str2);
            a(xMPushService, a, a.f604b);
        } else if (hm.SendMessage == a.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a.f604b)) {
            com.xiaomi.channel.commonutils.logger.b.m52a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a.f604b);
            a(xMPushService, a, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a.f604b);
            if (m416a == null || !aa.e(a)) {
                return;
            }
            fb.a(xMPushService.getApplicationContext()).a(a.b(), aa.b(a), m416a.m375a(), "3");
        } else {
            if (m416a != null && m416a.m375a() != null) {
                com.xiaomi.channel.commonutils.logger.b.m52a(String.format("receive a message, appid=%1$s, msgid= %2$s", a.m417a(), m416a.m375a()));
            }
            if (m416a != null && (m376a = m416a.m376a()) != null && m376a.containsKey("hide") && "true".equalsIgnoreCase(m376a.get("hide"))) {
                b(xMPushService, a);
                return;
            }
            if (m416a != null && m416a.m376a() != null && m416a.m376a().containsKey("__miid")) {
                String str3 = m416a.m376a().get("__miid");
                String a4 = com.xiaomi.push.t.a(xMPushService.getApplicationContext());
                if (TextUtils.isEmpty(a4) || !TextUtils.equals(str3, a4)) {
                    if (aa.e(a)) {
                        fb.a(xMPushService.getApplicationContext()).a(a.b(), aa.b(a), m416a.m375a(), "4");
                    }
                    com.xiaomi.channel.commonutils.logger.b.m52a(str3 + " should be login, but got " + a4);
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

    private static boolean a(ii iiVar) {
        return "com.xiaomi.xmsf".equals(iiVar.f604b) && iiVar.m416a() != null && iiVar.m416a().m376a() != null && iiVar.m416a().m376a().containsKey("miui_package_name");
    }

    private static boolean a(XMPushService xMPushService, String str, ii iiVar, hz hzVar) {
        boolean z;
        if (hzVar == null || hzVar.m376a() == null || !hzVar.m376a().containsKey("__check_alive") || !hzVar.m376a().containsKey("__awake")) {
            return true;
        }
        il ilVar = new il();
        ilVar.b(iiVar.m417a());
        ilVar.d(str);
        ilVar.c(hw.AwakeSystemApp.f475a);
        ilVar.a(hzVar.m375a());
        ilVar.f616a = new HashMap();
        boolean m307a = com.xiaomi.push.g.m307a(xMPushService.getApplicationContext(), str);
        ilVar.f616a.put("app_running", Boolean.toString(m307a));
        try {
            if (!m307a) {
                boolean parseBoolean = Boolean.parseBoolean(hzVar.m376a().get("__awake"));
                ilVar.f616a.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                    w.a(xMPushService, w.a(iiVar.b(), iiVar.m417a(), ilVar, hm.Notification));
                    return z;
                }
            }
            w.a(xMPushService, w.a(iiVar.b(), iiVar.m417a(), ilVar, hm.Notification));
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
        Map<String, String> m376a = iiVar.m416a().m376a();
        return m376a != null && m376a.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, ii iiVar) {
        xMPushService.a(new s(4, xMPushService, iiVar));
    }

    private static boolean c(ii iiVar) {
        if (iiVar.m416a() == null || iiVar.m416a().m376a() == null) {
            return false;
        }
        return "1".equals(iiVar.m416a().m376a().get("obslete_ads_message"));
    }

    private static void d(XMPushService xMPushService, ii iiVar) {
        xMPushService.a(new t(4, xMPushService, iiVar));
    }

    public void a(Context context, ap.b bVar, boolean z, int i, String str) {
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

    public void a(XMPushService xMPushService, fl flVar, ap.b bVar) {
        try {
            a(xMPushService, flVar.m283a(bVar.h), flVar.c());
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public void a(XMPushService xMPushService, gj gjVar, ap.b bVar) {
        if (!(gjVar instanceof gi)) {
            com.xiaomi.channel.commonutils.logger.b.m52a("not a mipush message");
            return;
        }
        gi giVar = (gi) gjVar;
        gg a = giVar.a("s");
        if (a != null) {
            try {
                a(xMPushService, ay.a(ay.a(bVar.h, giVar.j()), a.c()), gx.a(gjVar.m314a()));
            } catch (IllegalArgumentException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
