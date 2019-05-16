package com.xiaomi.push.service;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.mipush.sdk.MIPushNotificationHelper4Hybrid;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.as;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class x {
    public static Intent a(byte[] bArr, long j) {
        com.xiaomi.xmpush.thrift.af a = a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a.f);
        return intent;
    }

    public static com.xiaomi.xmpush.thrift.af a(Context context, com.xiaomi.xmpush.thrift.af afVar) {
        return a(context, afVar, false, false, false);
    }

    public static com.xiaomi.xmpush.thrift.af a(Context context, com.xiaomi.xmpush.thrift.af afVar, boolean z, boolean z2, boolean z3) {
        com.xiaomi.xmpush.thrift.z zVar = new com.xiaomi.xmpush.thrift.z();
        zVar.b(afVar.h());
        com.xiaomi.xmpush.thrift.u m = afVar.m();
        if (m != null) {
            zVar.a(m.b());
            zVar.a(m.d());
            if (!TextUtils.isEmpty(m.f())) {
                zVar.c(m.f());
            }
        }
        zVar.a(com.xiaomi.xmpush.thrift.at.a(context, afVar));
        zVar.b(com.xiaomi.xmpush.thrift.at.a(z, z2, z3));
        com.xiaomi.xmpush.thrift.af a = af.a(afVar.j(), afVar.h(), zVar, com.xiaomi.xmpush.thrift.a.AckMessage);
        com.xiaomi.xmpush.thrift.u a2 = afVar.m().a();
        a2.a("mat", Long.toString(System.currentTimeMillis()));
        a.a(a2);
        return a;
    }

    public static com.xiaomi.xmpush.thrift.af a(byte[] bArr) {
        com.xiaomi.xmpush.thrift.af afVar = new com.xiaomi.xmpush.thrift.af();
        try {
            com.xiaomi.xmpush.thrift.at.a(afVar, bArr);
            return afVar;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    private static void a(XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar) {
        xMPushService.a(new y(4, xMPushService, afVar));
    }

    private static void a(XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar, String str) {
        xMPushService.a(new ac(4, xMPushService, afVar, str));
    }

    private static void a(XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar, String str, String str2) {
        xMPushService.a(new ad(4, xMPushService, afVar, str, str2));
    }

    public static void a(XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar, boolean z, boolean z2, boolean z3) {
        a(xMPushService, afVar, z, z2, z3, false);
    }

    public static void a(XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar, boolean z, boolean z2, boolean z3, boolean z4) {
        xMPushService.a(new ae(4, xMPushService, afVar, z, z2, z3, z4));
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent, boolean z) {
        com.xiaomi.xmpush.thrift.af a = a(bArr);
        com.xiaomi.xmpush.thrift.u m = a.m();
        if (bArr != null) {
            com.xiaomi.push.clientreport.a.a(xMPushService.getApplicationContext(), null, a.a(), bArr.length);
        }
        if (c(a) && a(xMPushService, str)) {
            if (ah.e(a)) {
                com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).a(ah.f(a), m.b(), "old message received by new SDK.");
            }
            d(xMPushService, a);
        } else if (a(a) && !a(xMPushService, str) && !b(a)) {
            if (ah.e(a)) {
                com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).a(ah.f(a), m.b(), "new message received by old SDK.");
            }
            e(xMPushService, a);
        } else if ((!ah.b(a) || !com.xiaomi.channel.commonutils.android.a.e(xMPushService, a.f)) && !a(xMPushService, intent)) {
            if (!com.xiaomi.channel.commonutils.android.a.e(xMPushService, a.f)) {
                if (ah.e(a)) {
                    com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).b(ah.f(a), m.b(), "receive a message, but the package is removed.");
                }
                a(xMPushService, a);
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.a("receive a mipush message, we can see the app, but we can't see the receiver.");
            if (ah.e(a)) {
                com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).b(ah.f(a), m.b(), "receive a mipush message, we can see the app, but we can't see the receiver.");
            }
        } else {
            if (com.xiaomi.xmpush.thrift.a.Registration == a.a()) {
                String j = a.j();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(j, a.e);
                edit.commit();
            }
            if (ah.d(a)) {
                com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).a(ah.f(a), m.b(), 1001, System.currentTimeMillis(), "receive notification message ");
                if (!TextUtils.isEmpty(m.b())) {
                    intent.putExtra("messageId", m.b());
                    intent.putExtra("eventMessageType", 1000);
                }
            }
            if (ah.c(a)) {
                com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).a(ah.f(a), m.b(), 2001, System.currentTimeMillis(), "receive passThrough message");
                if (!TextUtils.isEmpty(m.b())) {
                    intent.putExtra("messageId", m.b());
                    intent.putExtra("eventMessageType", 2000);
                }
            }
            if (ah.b(a)) {
                com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).a(ah.f(a), m.b(), 3001, System.currentTimeMillis(), "receive business message");
                if (!TextUtils.isEmpty(m.b())) {
                    intent.putExtra("messageId", m.b());
                    intent.putExtra("eventMessageType", 3000);
                }
            }
            if (m != null && !TextUtils.isEmpty(m.h()) && !TextUtils.isEmpty(m.j()) && m.h != 1 && (ah.a(m.s()) || !ah.a(xMPushService, a.f))) {
                boolean z2 = false;
                if (m != null) {
                    r0 = m.j != null ? m.j.get("jobkey") : null;
                    if (TextUtils.isEmpty(r0)) {
                        r0 = m.b();
                    }
                    z2 = aj.a(xMPushService, a.f, m.b());
                }
                if (z2) {
                    com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).c(ah.f(a), m.b(), "drop a duplicate message");
                    com.xiaomi.channel.commonutils.logger.b.a("drop a duplicate message, key=" + r0);
                } else {
                    ah.c a2 = ah.a(xMPushService, a, bArr);
                    if (a2.b > 0 && !TextUtils.isEmpty(a2.a)) {
                        com.xiaomi.smack.util.g.a(xMPushService, a2.a, a2.b, true, System.currentTimeMillis());
                    }
                    if (!ah.b(a)) {
                        Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                        intent2.putExtra("mipush_payload", bArr);
                        intent2.setPackage(a.f);
                        try {
                            List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                            if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                xMPushService.sendBroadcast(intent2, af.a(a.f));
                            }
                        } catch (Exception e) {
                            xMPushService.sendBroadcast(intent2, af.a(a.f));
                            if (e != null) {
                                com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).b(ah.f(a), m.b(), e.getMessage());
                            }
                        }
                    }
                }
                if (z) {
                    a(xMPushService, a, false, true, false);
                } else {
                    c(xMPushService, a);
                }
            } else if ("com.xiaomi.xmsf".contains(a.f) && !a.c() && m != null && m.s() != null && m.s().containsKey("ab")) {
                c(xMPushService, a);
                com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m.b());
            } else if (a(xMPushService, str, a, m)) {
                if (m != null && !TextUtils.isEmpty(m.b())) {
                    if (ah.c(a)) {
                        com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).a(ah.f(a), m.b(), 2002, "try send passThrough message Broadcast");
                    } else if (ah.b(a)) {
                        com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).a(ah.f(a), m.b(), "try show awake message , but it don't show in foreground");
                    } else if (ah.d(a)) {
                        com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).a(ah.f(a), m.b(), "try show notification message , but it don't show in foreground");
                    }
                }
                xMPushService.sendBroadcast(intent, af.a(a.f));
            } else {
                com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).a(ah.f(a), m.b(), "passThough message: not permit to send broadcast ");
            }
            if (a.a() != com.xiaomi.xmpush.thrift.a.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        boolean a;
        Map<String, String> s;
        com.xiaomi.xmpush.thrift.af a2 = a(bArr);
        if (a2 == null) {
            return;
        }
        if (TextUtils.isEmpty(a2.f)) {
            com.xiaomi.channel.commonutils.logger.b.a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a3 = a(bArr, valueOf.longValue());
        String a4 = ah.a(a2);
        com.xiaomi.smack.util.g.a(xMPushService, a4, j, true, System.currentTimeMillis());
        com.xiaomi.xmpush.thrift.u m = a2.m();
        if (m != null) {
            m.a("mrt", Long.toString(valueOf.longValue()));
        }
        if (com.xiaomi.xmpush.thrift.a.SendMessage == a2.a() && u.a(xMPushService).a(a2.f) && !ah.b(a2)) {
            String str = "";
            if (m != null) {
                str = m.b();
                if (ah.e(a2)) {
                    com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).a(ah.f(a2), str, "Drop a message for unregistered");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.a("Drop a message for unregistered, msgid=" + str);
            a(xMPushService, a2, a2.f);
        } else if (com.xiaomi.xmpush.thrift.a.SendMessage == a2.a() && u.a(xMPushService).c(a2.f) && !ah.b(a2)) {
            String str2 = "";
            if (m != null) {
                str2 = m.b();
                if (ah.e(a2)) {
                    com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).a(ah.f(a2), str2, "Drop a message for push closed");
                }
            }
            com.xiaomi.channel.commonutils.logger.b.a("Drop a message for push closed, msgid=" + str2);
            a(xMPushService, a2, a2.f);
        } else if (com.xiaomi.xmpush.thrift.a.SendMessage == a2.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a2.f)) {
            com.xiaomi.channel.commonutils.logger.b.a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a2.f);
            a(xMPushService, a2, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a2.f);
            if (m == null || !ah.e(a2)) {
                return;
            }
            com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).a(ah.f(a2), m.b(), "Receive a message with wrong package name");
        } else {
            if (m != null && m.b() != null) {
                com.xiaomi.channel.commonutils.logger.b.a(String.format("receive a message, appid=%1$s, msgid= %2$s", a2.h(), m.b()));
            }
            if (m != null && (s = m.s()) != null && s.containsKey("hide") && "true".equalsIgnoreCase(s.get("hide"))) {
                c(xMPushService, a2);
                return;
            }
            if (m != null && m.s() != null && m.s().containsKey("__miid")) {
                String str3 = m.s().get("__miid");
                Account a5 = com.xiaomi.channel.commonutils.android.e.a(xMPushService);
                if (a5 == null || !TextUtils.equals(str3, a5.name)) {
                    if (ah.e(a2)) {
                        com.xiaomi.push.service.clientReport.d.a(xMPushService.getApplicationContext()).a(ah.f(a2), m.b(), "miid already logout or anther already login");
                    }
                    com.xiaomi.channel.commonutils.logger.b.a(new StringBuilder().append(str3).append(" should be login, but got ").append(a5).toString() == null ? "nothing" : a5.name);
                    a(xMPushService, a2, "miid already logout or anther already login", new StringBuilder().append(str3).append(" should be login, but got ").append(a5).toString() == null ? "nothing" : a5.name);
                    return;
                }
            }
            boolean z = m != null && a(m.s());
            if (z) {
                if (!j.e(xMPushService)) {
                    a(xMPushService, a2, false, false, false, true);
                    return;
                }
                if (!(a(m) && j.d(xMPushService))) {
                    a = true;
                } else if (!b(xMPushService, a2)) {
                    return;
                } else {
                    a = a(xMPushService, m, bArr);
                }
                a(xMPushService, a2, true, false, false);
                if (!a) {
                    return;
                }
            }
            a(xMPushService, a4, bArr, a3, z);
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

    private static boolean a(XMPushService xMPushService, com.xiaomi.xmpush.thrift.u uVar, byte[] bArr) {
        Map<String, String> s = uVar.s();
        String[] split = s.get("__geo_ids").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        ArrayList<ContentValues> arrayList = new ArrayList<>();
        for (String str : split) {
            if (g.a(xMPushService).a(str) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("geo_id", str);
                contentValues.put(MIPushNotificationHelper4Hybrid.KEY_MESSAGE_ID, uVar.b());
                int parseInt = Integer.parseInt(s.get("__geo_action"));
                contentValues.put("action", Integer.valueOf(parseInt));
                contentValues.put("content", bArr);
                contentValues.put("deadline", Long.valueOf(Long.parseLong(s.get("__geo_deadline"))));
                if (TextUtils.equals(g.a(xMPushService).c(str), "Enter") && parseInt == 1) {
                    return true;
                }
                arrayList.add(contentValues);
            }
        }
        if (!i.a(xMPushService).a(arrayList)) {
            com.xiaomi.channel.commonutils.logger.b.c("geofence added some new geofence message failed messagi_id:" + uVar.b());
        }
        return false;
    }

    private static boolean a(XMPushService xMPushService, String str, com.xiaomi.xmpush.thrift.af afVar, com.xiaomi.xmpush.thrift.u uVar) {
        boolean z;
        if (uVar == null || uVar.s() == null || !uVar.s().containsKey("__check_alive") || !uVar.s().containsKey("__awake")) {
            return true;
        }
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai();
        aiVar.b(afVar.h());
        aiVar.d(str);
        aiVar.c(com.xiaomi.xmpush.thrift.r.AwakeSystemApp.aa);
        aiVar.a(uVar.b());
        aiVar.h = new HashMap();
        boolean d = com.xiaomi.channel.commonutils.android.a.d(xMPushService.getApplicationContext(), str);
        aiVar.h.put("app_running", Boolean.toString(d));
        try {
            if (!d) {
                boolean parseBoolean = Boolean.parseBoolean(uVar.s().get("__awake"));
                aiVar.h.put("awaked", Boolean.toString(parseBoolean));
                if (!parseBoolean) {
                    z = false;
                    af.a(xMPushService, af.a(afVar.j(), afVar.h(), aiVar, com.xiaomi.xmpush.thrift.a.Notification));
                    return z;
                }
            }
            af.a(xMPushService, af.a(afVar.j(), afVar.h(), aiVar, com.xiaomi.xmpush.thrift.a.Notification));
            return z;
        } catch (com.xiaomi.smack.l e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return z;
        }
        z = true;
    }

    private static boolean a(com.xiaomi.xmpush.thrift.af afVar) {
        return "com.xiaomi.xmsf".equals(afVar.f) && afVar.m() != null && afVar.m().s() != null && afVar.m().s().containsKey("miui_package_name");
    }

    public static boolean a(com.xiaomi.xmpush.thrift.u uVar) {
        Map<String, String> s;
        if (uVar == null || (s = uVar.s()) == null) {
            return false;
        }
        return TextUtils.equals("1", s.get("__geo_local_check"));
    }

    private static boolean a(Map<String, String> map) {
        return map != null && map.containsKey("__geo_ids");
    }

    private static boolean b(XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar) {
        if (j.a(xMPushService) && j.c(xMPushService)) {
            if (com.xiaomi.channel.commonutils.android.a.e(xMPushService, afVar.f)) {
                Map<String, String> s = afVar.m().s();
                return (s == null || !com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR.contains(s.get("__geo_action")) || TextUtils.isEmpty(s.get("__geo_ids"))) ? false : true;
            }
            a(xMPushService, afVar);
            return false;
        }
        return false;
    }

    private static boolean b(com.xiaomi.xmpush.thrift.af afVar) {
        Map<String, String> s = afVar.m().s();
        return s != null && s.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar) {
        xMPushService.a(new z(4, xMPushService, afVar));
    }

    private static boolean c(com.xiaomi.xmpush.thrift.af afVar) {
        if (afVar.m() == null || afVar.m().s() == null) {
            return false;
        }
        return "1".equals(afVar.m().s().get("obslete_ads_message"));
    }

    private static void d(XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar) {
        xMPushService.a(new aa(4, xMPushService, afVar));
    }

    private static void e(XMPushService xMPushService, com.xiaomi.xmpush.thrift.af afVar) {
        xMPushService.a(new ab(4, xMPushService, afVar));
    }

    public void a(Context context, as.b bVar, boolean z, int i, String str) {
        s a;
        if (z || (a = t.a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        try {
            t.a(context, a.f, a.d, a.e);
        } catch (IOException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        } catch (JSONException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public void a(XMPushService xMPushService, com.xiaomi.slim.b bVar, as.b bVar2) {
        try {
            a(xMPushService, bVar.d(bVar2.i), bVar.l());
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public void a(XMPushService xMPushService, com.xiaomi.smack.packet.d dVar, as.b bVar) {
        if (!(dVar instanceof com.xiaomi.smack.packet.c)) {
            com.xiaomi.channel.commonutils.logger.b.a("not a mipush message");
            return;
        }
        com.xiaomi.smack.packet.c cVar = (com.xiaomi.smack.packet.c) dVar;
        com.xiaomi.smack.packet.a p = cVar.p("s");
        if (p != null) {
            try {
                a(xMPushService, bb.a(bb.a(bVar.i, cVar.k()), p.c()), com.xiaomi.smack.util.g.b(dVar.c()));
            } catch (IllegalArgumentException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
