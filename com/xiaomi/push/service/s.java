package com.xiaomi.push.service;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.ac;
import com.xiaomi.push.service.ak;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
/* loaded from: classes3.dex */
public class s {
    public static Intent a(byte[] bArr, long j) {
        com.xiaomi.xmpush.thrift.ab a = a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a.f);
        return intent;
    }

    public static com.xiaomi.xmpush.thrift.ab a(Context context, com.xiaomi.xmpush.thrift.ab abVar) {
        return a(context, abVar, false, false, false);
    }

    public static com.xiaomi.xmpush.thrift.ab a(Context context, com.xiaomi.xmpush.thrift.ab abVar, boolean z, boolean z2, boolean z3) {
        com.xiaomi.xmpush.thrift.w wVar = new com.xiaomi.xmpush.thrift.w();
        wVar.b(abVar.h());
        com.xiaomi.xmpush.thrift.r m = abVar.m();
        if (m != null) {
            wVar.a(m.b());
            wVar.a(m.d());
            if (!TextUtils.isEmpty(m.f())) {
                wVar.c(m.f());
            }
        }
        wVar.a(com.xiaomi.xmpush.thrift.aq.a(context, abVar));
        wVar.b(com.xiaomi.xmpush.thrift.aq.a(z, z2, z3));
        com.xiaomi.xmpush.thrift.ab a = aa.a(abVar.j(), abVar.h(), wVar, com.xiaomi.xmpush.thrift.a.AckMessage);
        com.xiaomi.xmpush.thrift.r a2 = abVar.m().a();
        a2.a("mat", Long.toString(System.currentTimeMillis()));
        a.a(a2);
        return a;
    }

    public static com.xiaomi.xmpush.thrift.ab a(byte[] bArr) {
        com.xiaomi.xmpush.thrift.ab abVar = new com.xiaomi.xmpush.thrift.ab();
        try {
            com.xiaomi.xmpush.thrift.aq.a(abVar, bArr);
            return abVar;
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    private static void a(XMPushService xMPushService, com.xiaomi.xmpush.thrift.ab abVar) {
        xMPushService.a(new t(4, xMPushService, abVar));
    }

    private static void a(XMPushService xMPushService, com.xiaomi.xmpush.thrift.ab abVar, String str) {
        xMPushService.a(new x(4, xMPushService, abVar, str));
    }

    private static void a(XMPushService xMPushService, com.xiaomi.xmpush.thrift.ab abVar, String str, String str2) {
        xMPushService.a(new y(4, xMPushService, abVar, str, str2));
    }

    public static void a(XMPushService xMPushService, com.xiaomi.xmpush.thrift.ab abVar, boolean z, boolean z2, boolean z3) {
        xMPushService.a(new z(4, xMPushService, abVar, z, z2, z3));
    }

    public static void a(XMPushService xMPushService, String str, byte[] bArr, Intent intent, boolean z) {
        com.xiaomi.xmpush.thrift.ab a = a(bArr);
        com.xiaomi.xmpush.thrift.r m = a.m();
        if (c(a) && a(xMPushService, str)) {
            d(xMPushService, a);
        } else if (a(a) && !a(xMPushService, str) && !b(a)) {
            e(xMPushService, a);
        } else if ((!ac.b(a) || !com.xiaomi.channel.commonutils.android.b.f(xMPushService, a.f)) && !a(xMPushService, intent)) {
            if (com.xiaomi.channel.commonutils.android.b.f(xMPushService, a.f)) {
                com.xiaomi.channel.commonutils.logger.b.a("receive a mipush message, we can see the app, but we can't see the receiver.");
            } else {
                a(xMPushService, a);
            }
        } else {
            if (com.xiaomi.xmpush.thrift.a.Registration == a.a()) {
                String j = a.j();
                SharedPreferences.Editor edit = xMPushService.getSharedPreferences("pref_registered_pkg_names", 0).edit();
                edit.putString(j, a.e);
                edit.commit();
                aw.a().b("Registe Success, package name is " + j);
            }
            if (m != null && !TextUtils.isEmpty(m.h()) && !TextUtils.isEmpty(m.j()) && m.h != 1 && (ac.a(m.s()) || !ac.a(xMPushService, a.f))) {
                boolean z2 = false;
                if (m != null) {
                    r0 = m.j != null ? m.j.get("jobkey") : null;
                    if (TextUtils.isEmpty(r0)) {
                        r0 = m.b();
                    }
                    z2 = ad.a(xMPushService, a.f, r0);
                }
                if (z2) {
                    com.xiaomi.channel.commonutils.logger.b.a("drop a duplicate message, key=" + r0);
                } else {
                    ac.b a2 = ac.a(xMPushService, a, bArr);
                    if (a2.b > 0 && !TextUtils.isEmpty(a2.a)) {
                        com.xiaomi.smack.util.g.a(xMPushService, a2.a, a2.b, true, System.currentTimeMillis());
                    }
                    if (!ac.b(a)) {
                        Intent intent2 = new Intent("com.xiaomi.mipush.MESSAGE_ARRIVED");
                        intent2.putExtra("mipush_payload", bArr);
                        intent2.setPackage(a.f);
                        try {
                            List<ResolveInfo> queryBroadcastReceivers = xMPushService.getPackageManager().queryBroadcastReceivers(intent2, 0);
                            if (queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty()) {
                                xMPushService.sendBroadcast(intent2, b.a(a.f));
                            }
                        } catch (Exception e) {
                            xMPushService.sendBroadcast(intent2, b.a(a.f));
                        }
                    }
                }
                if (z) {
                    a(xMPushService, a, false, true, false);
                } else {
                    c(xMPushService, a);
                }
            } else if (!"com.xiaomi.xmsf".contains(a.f) || a.c() || m == null || m.s() == null || !m.s().containsKey("ab")) {
                xMPushService.sendBroadcast(intent, b.a(a.f));
            } else {
                c(xMPushService, a);
                com.xiaomi.channel.commonutils.logger.b.c("receive abtest message. ack it." + m.b());
            }
            if (a.a() != com.xiaomi.xmpush.thrift.a.UnRegistration || "com.xiaomi.xmsf".equals(xMPushService.getPackageName())) {
                return;
            }
            xMPushService.stopSelf();
        }
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        Map<String, String> s;
        com.xiaomi.xmpush.thrift.ab a = a(bArr);
        if (a == null) {
            return;
        }
        if (TextUtils.isEmpty(a.f)) {
            com.xiaomi.channel.commonutils.logger.b.a("receive a mipush message without package name");
            return;
        }
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        Intent a2 = a(bArr, valueOf.longValue());
        String a3 = ac.a(a);
        com.xiaomi.smack.util.g.a(xMPushService, a3, j, true, System.currentTimeMillis());
        com.xiaomi.xmpush.thrift.r m = a.m();
        if (m != null) {
            m.a("mrt", Long.toString(valueOf.longValue()));
        }
        if (com.xiaomi.xmpush.thrift.a.SendMessage == a.a() && p.a(xMPushService).a(a.f) && !ac.b(a)) {
            com.xiaomi.channel.commonutils.logger.b.a("Drop a message for unregistered, msgid=" + (m != null ? m.b() : ""));
            a(xMPushService, a, a.f);
        } else if (com.xiaomi.xmpush.thrift.a.SendMessage == a.a() && p.a(xMPushService).c(a.f) && !ac.b(a)) {
            com.xiaomi.channel.commonutils.logger.b.a("Drop a message for push closed, msgid=" + (m != null ? m.b() : ""));
            a(xMPushService, a, a.f);
        } else if (com.xiaomi.xmpush.thrift.a.SendMessage == a.a() && !TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") && !TextUtils.equals(xMPushService.getPackageName(), a.f)) {
            com.xiaomi.channel.commonutils.logger.b.a("Receive a message with wrong package name, expect " + xMPushService.getPackageName() + ", received " + a.f);
            a(xMPushService, a, "unmatched_package", "package should be " + xMPushService.getPackageName() + ", but got " + a.f);
        } else {
            if (m != null && m.b() != null) {
                com.xiaomi.channel.commonutils.logger.b.a(String.format("receive a message, appid=%1$s, msgid= %2$s", a.h(), m.b()));
            }
            if (m != null && (s = m.s()) != null && s.containsKey("hide") && "true".equalsIgnoreCase(s.get("hide"))) {
                c(xMPushService, a);
                return;
            }
            if (m != null && m.s() != null && m.s().containsKey("__miid")) {
                String str = m.s().get("__miid");
                Account a4 = com.xiaomi.channel.commonutils.android.f.a(xMPushService);
                if ((a4 == null) | (!TextUtils.equals(str, a4.name))) {
                    com.xiaomi.channel.commonutils.logger.b.a(new StringBuilder().append(str).append(" should be login, but got ").append(a4).toString() == null ? "nothing" : a4.name);
                    a(xMPushService, a, "miid already logout or anther already login", new StringBuilder().append(str).append(" should be login, but got ").append(a4).toString() == null ? "nothing" : a4.name);
                    return;
                }
            }
            boolean z = m != null && a(m.s());
            if (z) {
                if (!b(xMPushService, a)) {
                    return;
                }
                boolean a5 = a(xMPushService, m, bArr);
                a(xMPushService, a, true, false, false);
                if (!a5) {
                    return;
                }
            }
            a(xMPushService, a3, bArr, a2, z);
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

    private static boolean a(XMPushService xMPushService, com.xiaomi.xmpush.thrift.r rVar, byte[] bArr) {
        Map<String, String> s = rVar.s();
        String[] split = s.get("__geo_ids").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        ArrayList<ContentValues> arrayList = new ArrayList<>();
        for (String str : split) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("geo_id", str);
            contentValues.put("message_id", rVar.b());
            int parseInt = Integer.parseInt(s.get("__geo_action"));
            contentValues.put("action", Integer.valueOf(parseInt));
            contentValues.put("content", bArr);
            contentValues.put("deadline", Long.valueOf(Long.parseLong(s.get("__geo_deadline"))));
            if (TextUtils.equals(e.a(xMPushService).c(str), "Enter") && parseInt == 1) {
                return true;
            }
            arrayList.add(contentValues);
        }
        if (!g.a(xMPushService).a(arrayList)) {
            com.xiaomi.channel.commonutils.logger.b.c("geofence added some new geofence message failed messagi_id:" + rVar.b());
        }
        return false;
    }

    private static boolean a(com.xiaomi.xmpush.thrift.ab abVar) {
        return "com.xiaomi.xmsf".equals(abVar.f) && abVar.m() != null && abVar.m().s() != null && abVar.m().s().containsKey("miui_package_name");
    }

    private static boolean a(Map<String, String> map) {
        return map != null && map.containsKey("__geo_ids");
    }

    private static boolean b(XMPushService xMPushService, com.xiaomi.xmpush.thrift.ab abVar) {
        if (h.a(xMPushService) && h.b(xMPushService)) {
            if (com.xiaomi.channel.commonutils.android.b.f(xMPushService, abVar.f)) {
                Map<String, String> s = abVar.m().s();
                return (s == null || !com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR.contains(s.get("__geo_action")) || TextUtils.isEmpty(s.get("__geo_ids"))) ? false : true;
            }
            a(xMPushService, abVar);
            return false;
        }
        return false;
    }

    private static boolean b(com.xiaomi.xmpush.thrift.ab abVar) {
        Map<String, String> s = abVar.m().s();
        return s != null && s.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, com.xiaomi.xmpush.thrift.ab abVar) {
        xMPushService.a(new u(4, xMPushService, abVar));
    }

    private static boolean c(com.xiaomi.xmpush.thrift.ab abVar) {
        if (abVar.m() == null || abVar.m().s() == null) {
            return false;
        }
        return "1".equals(abVar.m().s().get("obslete_ads_message"));
    }

    private static void d(XMPushService xMPushService, com.xiaomi.xmpush.thrift.ab abVar) {
        xMPushService.a(new v(4, xMPushService, abVar));
    }

    private static void e(XMPushService xMPushService, com.xiaomi.xmpush.thrift.ab abVar) {
        xMPushService.a(new w(4, xMPushService, abVar));
    }

    public void a(Context context, ak.b bVar, boolean z, int i, String str) {
        n a;
        if (z || (a = o.a(context)) == null || !"token-expired".equals(str)) {
            return;
        }
        try {
            o.a(context, a.d, a.e, a.f);
        } catch (IOException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        } catch (JSONException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    public void a(XMPushService xMPushService, com.xiaomi.slim.b bVar, ak.b bVar2) {
        try {
            a(xMPushService, bVar.d(bVar2.i), bVar.l());
        } catch (IllegalArgumentException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    public void a(XMPushService xMPushService, com.xiaomi.smack.packet.d dVar, ak.b bVar) {
        if (!(dVar instanceof com.xiaomi.smack.packet.c)) {
            com.xiaomi.channel.commonutils.logger.b.a("not a mipush message");
            return;
        }
        com.xiaomi.smack.packet.c cVar = (com.xiaomi.smack.packet.c) dVar;
        com.xiaomi.smack.packet.a p = cVar.p(NotifyType.SOUND);
        if (p != null) {
            try {
                a(xMPushService, aq.b(aq.a(bVar.i, cVar.k()), p.c()), com.xiaomi.smack.util.g.a(dVar.c()));
            } catch (IllegalArgumentException e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
    }
}
