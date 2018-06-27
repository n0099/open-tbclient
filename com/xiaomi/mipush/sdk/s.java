package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.service.ac;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.ai;
import com.xiaomi.push.service.am;
import com.xiaomi.xmpush.thrift.ad;
import com.xiaomi.xmpush.thrift.ae;
import com.xiaomi.xmpush.thrift.ag;
import com.xiaomi.xmpush.thrift.aj;
import com.xiaomi.xmpush.thrift.al;
import com.xiaomi.xmpush.thrift.an;
import com.xiaomi.xmpush.thrift.ap;
import com.xiaomi.xmpush.thrift.aq;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;
import org.apache.http.HttpHost;
/* loaded from: classes3.dex */
public class s {
    private static Queue<String> c;
    private Context b;
    private static s a = null;
    private static Object d = new Object();

    private s(Context context) {
        this.b = context.getApplicationContext();
        if (this.b == null) {
            this.b = context;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent a(Context context, String str, Map<String, String> map) {
        Intent intent;
        String str2;
        Intent intent2;
        URISyntaxException e;
        if (map == null || !map.containsKey("notify_effect")) {
            return null;
        }
        String str3 = map.get("notify_effect");
        if (am.a.equals(str3)) {
            try {
                intent = context.getPackageManager().getLaunchIntentForPackage(str);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e2.getMessage());
                intent = null;
            }
        } else {
            if (am.b.equals(str3)) {
                if (map.containsKey("intent_uri")) {
                    String str4 = map.get("intent_uri");
                    if (str4 != null) {
                        try {
                            intent = Intent.parseUri(str4, 1);
                        } catch (URISyntaxException e3) {
                            e = e3;
                            intent = null;
                        }
                        try {
                            intent.setPackage(str);
                        } catch (URISyntaxException e4) {
                            e = e4;
                            com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                            if (intent != null) {
                            }
                        }
                    } else {
                        intent = null;
                    }
                } else if (map.containsKey("class_name")) {
                    Intent intent3 = new Intent();
                    intent3.setComponent(new ComponentName(str, map.get("class_name")));
                    try {
                        if (map.containsKey("intent_flag")) {
                            intent3.setFlags(Integer.parseInt(map.get("intent_flag")));
                        }
                    } catch (NumberFormatException e5) {
                        com.xiaomi.channel.commonutils.logger.b.d("Cause by intent_flag: " + e5.getMessage());
                    }
                    intent = intent3;
                }
            } else if (am.c.equals(str3) && (str2 = map.get("web_uri")) != null) {
                String trim = str2.trim();
                String str5 = (trim.startsWith("http://") || trim.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) ? trim : "http://" + trim;
                try {
                    String protocol = new URL(str5).getProtocol();
                    if (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || "https".equals(protocol)) {
                        intent = new Intent("android.intent.action.VIEW");
                        try {
                            intent.setData(Uri.parse(str5));
                        } catch (MalformedURLException e6) {
                            intent2 = intent;
                            e = e6;
                            com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                            intent = intent2;
                            if (intent != null) {
                            }
                        }
                    } else {
                        intent = null;
                    }
                } catch (MalformedURLException e7) {
                    e = e7;
                    intent2 = null;
                }
            }
            intent = null;
        }
        if (intent != null) {
            intent.addFlags(268435456);
            try {
                if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                    return intent;
                }
                return null;
            } catch (Exception e8) {
                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e8.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v144, resolved type: com.xiaomi.mipush.sdk.MiPushMessage */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:273:0x06e9  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x06f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private PushMessageHandler.a a(com.xiaomi.xmpush.thrift.ab abVar, boolean z, byte[] bArr) {
        int i;
        List<String> list;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        MiPushCommandMessage miPushCommandMessage = null;
        try {
            org.apache.thrift.a a2 = q.a(this.b, abVar);
            if (a2 != null) {
                com.xiaomi.channel.commonutils.logger.b.c("receive a message." + a2);
                com.xiaomi.xmpush.thrift.a a3 = abVar.a();
                com.xiaomi.channel.commonutils.logger.b.a("processing a message, action=" + a3);
                switch (t.a[a3.ordinal()]) {
                    case 1:
                        if (a.a(this.b).l() && !z) {
                            com.xiaomi.channel.commonutils.logger.b.a("receive a message in pause state. drop it");
                            break;
                        } else {
                            aj ajVar = (aj) a2;
                            com.xiaomi.xmpush.thrift.q l = ajVar.l();
                            if (l != null) {
                                if (z) {
                                    if (ac.b(abVar)) {
                                        MiPushClient.reportIgnoreRegMessageClicked(this.b, l.b(), abVar.m(), abVar.f, l.d());
                                    } else {
                                        MiPushClient.reportMessageClicked(this.b, l.b(), abVar.m(), l.d());
                                    }
                                }
                                if (!z) {
                                    if (!TextUtils.isEmpty(ajVar.j()) && MiPushClient.aliasSetTime(this.b, ajVar.j()) < 0) {
                                        MiPushClient.addAlias(this.b, ajVar.j());
                                    } else if (!TextUtils.isEmpty(ajVar.h()) && MiPushClient.topicSubscribedTime(this.b, ajVar.h()) < 0) {
                                        MiPushClient.addTopic(this.b, ajVar.h());
                                    }
                                }
                                String str = (abVar.h == null || abVar.h.s() == null) ? null : abVar.h.j.get("jobkey");
                                String b = TextUtils.isEmpty(str) ? l.b() : str;
                                if (z || !a(this.b, b)) {
                                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(ajVar, abVar.m(), z);
                                    if (generateMessage.getPassThrough() != 0 || z || !ac.a(generateMessage.getExtra())) {
                                        com.xiaomi.channel.commonutils.logger.b.a("receive a message, msgid=" + l.b() + ", jobkey=" + b);
                                        if (z && generateMessage.getExtra() != null && generateMessage.getExtra().containsKey("notify_effect")) {
                                            Map<String, String> extra = generateMessage.getExtra();
                                            String str2 = extra.get("notify_effect");
                                            if (!ac.b(abVar)) {
                                                Intent a4 = a(this.b, this.b.getPackageName(), extra);
                                                if (a4 != null) {
                                                    if (!str2.equals(am.c)) {
                                                        a4.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                                    }
                                                    this.b.startActivity(a4);
                                                    break;
                                                }
                                            } else {
                                                Intent a5 = a(this.b, abVar.f, extra);
                                                if (a5 != null) {
                                                    String f = l.f();
                                                    if (!TextUtils.isEmpty(f)) {
                                                        a5.putExtra("payload", f);
                                                    }
                                                    this.b.startActivity(a5);
                                                    break;
                                                } else {
                                                    com.xiaomi.channel.commonutils.logger.b.a("Getting Intent fail from ignore reg message. ");
                                                    break;
                                                }
                                            }
                                        } else {
                                            miPushCommandMessage = generateMessage;
                                        }
                                    } else {
                                        ac.a(this.b, abVar, bArr);
                                        break;
                                    }
                                } else {
                                    com.xiaomi.channel.commonutils.logger.b.a("drop a duplicate message, key=" + b);
                                }
                                if (abVar.m() == null && !z) {
                                    a(ajVar, abVar);
                                    break;
                                }
                            } else {
                                com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                                break;
                            }
                        }
                        break;
                    case 2:
                        ag agVar = (ag) a2;
                        if (agVar.f == 0) {
                            a.a(this.b).b(agVar.h, agVar.i);
                        }
                        if (TextUtils.isEmpty(agVar.h)) {
                            arrayList3 = null;
                        } else {
                            arrayList3 = new ArrayList();
                            arrayList3.add(agVar.h);
                        }
                        miPushCommandMessage = PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_REGISTER, arrayList3, agVar.f, agVar.g, null);
                        u.a(this.b).e();
                        break;
                    case 3:
                        if (((an) a2).f == 0) {
                            a.a(this.b).h();
                            MiPushClient.clearExtras(this.b);
                        }
                        PushMessageHandler.a();
                        break;
                    case 4:
                        al alVar = (al) a2;
                        if (alVar.f == 0) {
                            MiPushClient.addTopic(this.b, alVar.h());
                        }
                        if (TextUtils.isEmpty(alVar.h())) {
                            arrayList2 = null;
                        } else {
                            arrayList2 = new ArrayList();
                            arrayList2.add(alVar.h());
                        }
                        miPushCommandMessage = PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_SUBSCRIBE_TOPIC, arrayList2, alVar.f, alVar.g, alVar.k());
                        break;
                    case 5:
                        ap apVar = (ap) a2;
                        if (apVar.f == 0) {
                            MiPushClient.removeTopic(this.b, apVar.h());
                        }
                        if (TextUtils.isEmpty(apVar.h())) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList();
                            arrayList.add(apVar.h());
                        }
                        miPushCommandMessage = PushMessageHelper.generateCommandMessage(MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC, arrayList, apVar.f, apVar.g, apVar.k());
                        break;
                    case 6:
                        com.xiaomi.xmpush.thrift.aa aaVar = (com.xiaomi.xmpush.thrift.aa) a2;
                        String e = aaVar.e();
                        List<String> k = aaVar.k();
                        if (aaVar.g == 0) {
                            if (TextUtils.equals(e, MiPushClient.COMMAND_SET_ACCEPT_TIME) && k != null && k.size() > 1) {
                                MiPushClient.addAcceptTime(this.b, k.get(0), k.get(1));
                                if ("00:00".equals(k.get(0)) && "00:00".equals(k.get(1))) {
                                    a.a(this.b).a(true);
                                } else {
                                    a.a(this.b).a(false);
                                }
                                list = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), k);
                            } else if (TextUtils.equals(e, MiPushClient.COMMAND_SET_ALIAS) && k != null && k.size() > 0) {
                                MiPushClient.addAlias(this.b, k.get(0));
                                list = k;
                            } else if (TextUtils.equals(e, MiPushClient.COMMAND_UNSET_ALIAS) && k != null && k.size() > 0) {
                                MiPushClient.removeAlias(this.b, k.get(0));
                                list = k;
                            } else if (TextUtils.equals(e, MiPushClient.COMMAND_SET_ACCOUNT) && k != null && k.size() > 0) {
                                MiPushClient.addAccount(this.b, k.get(0));
                                list = k;
                            } else if (TextUtils.equals(e, MiPushClient.COMMAND_UNSET_ACCOUNT) && k != null && k.size() > 0) {
                                MiPushClient.removeAccount(this.b, k.get(0));
                            }
                            miPushCommandMessage = PushMessageHelper.generateCommandMessage(e, list, aaVar.g, aaVar.h, aaVar.m());
                            break;
                        }
                        list = k;
                        miPushCommandMessage = PushMessageHelper.generateCommandMessage(e, list, aaVar.g, aaVar.h, aaVar.m());
                        break;
                    case 7:
                        if (a2 instanceof com.xiaomi.xmpush.thrift.x) {
                            com.xiaomi.xmpush.thrift.x xVar = (com.xiaomi.xmpush.thrift.x) a2;
                            String c2 = xVar.c();
                            if (!com.xiaomi.xmpush.thrift.o.DisablePushMessage.N.equalsIgnoreCase(xVar.e)) {
                                if (com.xiaomi.xmpush.thrift.o.EnablePushMessage.N.equalsIgnoreCase(xVar.e)) {
                                    if (xVar.g != 0) {
                                        if (!"enable_syncing".equals(p.a(this.b).a())) {
                                            p.a(this.b).d(c2);
                                            break;
                                        } else {
                                            synchronized (p.class) {
                                                if (p.a(this.b).e(c2)) {
                                                    if (p.a(this.b).c(c2) < 10) {
                                                        p.a(this.b).b(c2);
                                                        u.a(this.b).a(false, c2);
                                                    } else {
                                                        p.a(this.b).d(c2);
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                    } else {
                                        synchronized (p.class) {
                                            if (p.a(this.b).e(c2)) {
                                                p.a(this.b).d(c2);
                                                if ("enable_syncing".equals(p.a(this.b).a())) {
                                                    p.a(this.b).f("enable_synced");
                                                    p.a(this.b).d(c2);
                                                }
                                            }
                                        }
                                        break;
                                    }
                                }
                            } else if (xVar.g != 0) {
                                if (!"disable_syncing".equals(p.a(this.b).a())) {
                                    p.a(this.b).d(c2);
                                    break;
                                } else {
                                    synchronized (p.class) {
                                        if (p.a(this.b).e(c2)) {
                                            if (p.a(this.b).c(c2) < 10) {
                                                p.a(this.b).b(c2);
                                                u.a(this.b).a(true, c2);
                                            } else {
                                                p.a(this.b).d(c2);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else {
                                synchronized (p.class) {
                                    if (p.a(this.b).e(c2)) {
                                        p.a(this.b).d(c2);
                                        if ("disable_syncing".equals(p.a(this.b).a())) {
                                            p.a(this.b).f("disable_synced");
                                            MiPushClient.clearNotification(this.b);
                                            MiPushClient.clearLocalNotificationType(this.b);
                                            PushMessageHandler.a();
                                            u.a(this.b).b();
                                        }
                                    }
                                }
                                break;
                            }
                        } else if (a2 instanceof ae) {
                            ae aeVar = (ae) a2;
                            if ("registration id expired".equalsIgnoreCase(aeVar.e)) {
                                MiPushClient.reInitialize(this.b, com.xiaomi.xmpush.thrift.t.RegIdExpired);
                                break;
                            } else if ("client_info_update_ok".equalsIgnoreCase(aeVar.e)) {
                                if (aeVar.i() != null && aeVar.i().containsKey("app_version")) {
                                    a.a(this.b).a(aeVar.i().get("app_version"));
                                    break;
                                }
                            } else if ("awake_app".equalsIgnoreCase(aeVar.e)) {
                                if (aeVar.i() != null && aeVar.i().containsKey("packages")) {
                                    MiPushClient.awakeApps(this.b, aeVar.i().get("packages").split(","));
                                    break;
                                }
                            } else if (com.xiaomi.xmpush.thrift.o.NormalClientConfigUpdate.N.equalsIgnoreCase(aeVar.e)) {
                                ad adVar = new ad();
                                try {
                                    aq.a(adVar, aeVar.m());
                                    ai.a(ah.a(this.b), adVar);
                                    break;
                                } catch (org.apache.thrift.f e2) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                                    break;
                                }
                            } else if (com.xiaomi.xmpush.thrift.o.CustomClientConfigUpdate.N.equalsIgnoreCase(aeVar.e)) {
                                com.xiaomi.xmpush.thrift.ac acVar = new com.xiaomi.xmpush.thrift.ac();
                                try {
                                    aq.a(acVar, aeVar.m());
                                    ai.a(ah.a(this.b), acVar);
                                    break;
                                } catch (org.apache.thrift.f e3) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    break;
                                }
                            } else if (com.xiaomi.xmpush.thrift.o.SyncInfoResult.N.equalsIgnoreCase(aeVar.e)) {
                                x.a(this.b, aeVar);
                                break;
                            } else if (com.xiaomi.xmpush.thrift.o.ForceSync.N.equalsIgnoreCase(aeVar.e)) {
                                com.xiaomi.channel.commonutils.logger.b.a("receive force sync notification");
                                x.a(this.b, false);
                                break;
                            } else if (com.xiaomi.xmpush.thrift.o.GeoRegsiter.N.equalsIgnoreCase(aeVar.e)) {
                                f.a(this.b).a(aeVar);
                                break;
                            } else if (com.xiaomi.xmpush.thrift.o.GeoUnregsiter.N.equalsIgnoreCase(aeVar.e)) {
                                f.a(this.b).b(aeVar);
                                break;
                            } else if (com.xiaomi.xmpush.thrift.o.GeoSync.N.equalsIgnoreCase(aeVar.e)) {
                                f.a(this.b).c(aeVar);
                                break;
                            } else if (com.xiaomi.xmpush.thrift.o.CancelPushMessage.N.equals(aeVar.e) && aeVar.i() != null) {
                                if (aeVar.i().containsKey(am.H)) {
                                    String str3 = aeVar.i().get(am.H);
                                    if (!TextUtils.isEmpty(str3)) {
                                        try {
                                            i = Integer.parseInt(str3);
                                        } catch (NumberFormatException e4) {
                                            e4.printStackTrace();
                                            i = -2;
                                        }
                                        if (i >= -1) {
                                            MiPushClient.clearNotification(this.b, aeVar.i().containsKey(am.F) ? aeVar.i().get(am.F) : "", aeVar.i().containsKey(am.G) ? aeVar.i().get(am.G) : "");
                                            break;
                                        } else {
                                            MiPushClient.clearNotification(this.b, i);
                                            break;
                                        }
                                    }
                                }
                                i = -2;
                                if (i >= -1) {
                                }
                            }
                        }
                        break;
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + abVar.a);
            }
        } catch (c e5) {
            com.xiaomi.channel.commonutils.logger.b.a(e5);
            a(abVar);
        } catch (org.apache.thrift.f e6) {
            com.xiaomi.channel.commonutils.logger.b.a(e6);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
        }
        return miPushCommandMessage;
    }

    private PushMessageHandler.a a(com.xiaomi.xmpush.thrift.ab abVar, byte[] bArr) {
        MiPushMessage miPushMessage = null;
        miPushMessage = null;
        miPushMessage = null;
        r1 = null;
        String str = null;
        miPushMessage = null;
        miPushMessage = null;
        try {
            org.apache.thrift.a a2 = q.a(this.b, abVar);
            if (a2 != null) {
                com.xiaomi.channel.commonutils.logger.b.c("message arrived: receive a message." + a2);
                com.xiaomi.xmpush.thrift.a a3 = abVar.a();
                com.xiaomi.channel.commonutils.logger.b.a("message arrived: processing an arrived message, action=" + a3);
                switch (t.a[a3.ordinal()]) {
                    case 1:
                        aj ajVar = (aj) a2;
                        com.xiaomi.xmpush.thrift.q l = ajVar.l();
                        if (l != null) {
                            if (abVar.h != null && abVar.h.s() != null) {
                                str = abVar.h.j.get("jobkey");
                            }
                            MiPushMessage generateMessage = PushMessageHelper.generateMessage(ajVar, abVar.m(), false);
                            generateMessage.setArrivedMessage(true);
                            com.xiaomi.channel.commonutils.logger.b.a("message arrived: receive a message, msgid=" + l.b() + ", jobkey=" + str);
                            miPushMessage = generateMessage;
                            break;
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive an empty message without push content, drop it");
                            break;
                        }
                        break;
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + abVar.a);
            }
        } catch (c e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message but decrypt failed. report when click.");
        } catch (org.apache.thrift.f e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message which action string is not valid. is the reg expired?");
        }
        return miPushMessage;
    }

    public static s a(Context context) {
        if (a == null) {
            a = new s(context);
        }
        return a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences(MiPushClient.PREF_EXTRA, 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.b, com.xiaomi.xmpush.thrift.t.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    private void a(com.xiaomi.xmpush.thrift.ab abVar) {
        com.xiaomi.channel.commonutils.logger.b.a("receive a message but decrypt failed. report now.");
        ae aeVar = new ae(abVar.m().a, false);
        aeVar.c(com.xiaomi.xmpush.thrift.o.DecryptMessageFail.N);
        aeVar.b(abVar.h());
        aeVar.d(abVar.f);
        aeVar.h = new HashMap();
        aeVar.h.put("regid", MiPushClient.getRegId(this.b));
        u.a(this.b).a(aeVar, com.xiaomi.xmpush.thrift.a.Notification, false, null);
    }

    private void a(aj ajVar, com.xiaomi.xmpush.thrift.ab abVar) {
        com.xiaomi.xmpush.thrift.r m = abVar.m();
        com.xiaomi.xmpush.thrift.w wVar = new com.xiaomi.xmpush.thrift.w();
        wVar.b(ajVar.e());
        wVar.a(ajVar.c());
        wVar.a(ajVar.l().h());
        if (!TextUtils.isEmpty(ajVar.h())) {
            wVar.c(ajVar.h());
        }
        if (!TextUtils.isEmpty(ajVar.j())) {
            wVar.d(ajVar.j());
        }
        wVar.a(aq.a(this.b, abVar));
        u.a(this.b).a((u) wVar, com.xiaomi.xmpush.thrift.a.AckMessage, m);
    }

    private static boolean a(Context context, String str) {
        boolean z = false;
        synchronized (d) {
            SharedPreferences j = a.a(context).j();
            if (c == null) {
                String[] split = j.getString("pref_msg_ids", "").split(",");
                c = new LinkedList();
                for (String str2 : split) {
                    c.add(str2);
                }
            }
            if (c.contains(str)) {
                z = true;
            } else {
                c.add(str);
                if (c.size() > 25) {
                    c.poll();
                }
                String a2 = com.xiaomi.channel.commonutils.string.d.a(c, ",");
                SharedPreferences.Editor edit = j.edit();
                edit.putString("pref_msg_ids", a2);
                edit.commit();
            }
        }
        return z;
    }

    private void b(com.xiaomi.xmpush.thrift.ab abVar) {
        com.xiaomi.xmpush.thrift.r m = abVar.m();
        com.xiaomi.xmpush.thrift.w wVar = new com.xiaomi.xmpush.thrift.w();
        wVar.b(abVar.h());
        wVar.a(m.b());
        wVar.a(m.d());
        if (!TextUtils.isEmpty(m.f())) {
            wVar.c(m.f());
        }
        wVar.a(aq.a(this.b, abVar));
        u.a(this.b).a(wVar, com.xiaomi.xmpush.thrift.a.AckMessage, false, abVar.m());
    }

    public PushMessageHandler.a a(Intent intent) {
        String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an empty message, drop");
                return null;
            }
            com.xiaomi.xmpush.thrift.ab abVar = new com.xiaomi.xmpush.thrift.ab();
            try {
                aq.a(abVar, byteArrayExtra);
                a a2 = a.a(this.b);
                com.xiaomi.xmpush.thrift.r m = abVar.m();
                if (abVar.a() == com.xiaomi.xmpush.thrift.a.SendMessage && m != null && !a2.l() && !booleanExtra) {
                    if (m != null) {
                        abVar.m().a("mrt", stringExtra);
                        abVar.m().a("mat", Long.toString(System.currentTimeMillis()));
                    }
                    b(abVar);
                }
                if (abVar.a() == com.xiaomi.xmpush.thrift.a.SendMessage && !abVar.c()) {
                    if (!ac.b(abVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = abVar.j();
                        objArr[1] = m != null ? m.b() : "";
                        com.xiaomi.channel.commonutils.logger.b.a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr));
                        return null;
                    } else if (!booleanExtra || m.s() == null || !m.s().containsKey("notify_effect")) {
                        com.xiaomi.channel.commonutils.logger.b.a(String.format("drop an un-encrypted messages. %1$s, %2$s", abVar.j(), m.b()));
                        return null;
                    }
                }
                if (a2.i() || abVar.a == com.xiaomi.xmpush.thrift.a.Registration) {
                    if (!a2.i() || !a2.n()) {
                        return a(abVar, booleanExtra, byteArrayExtra);
                    }
                    if (abVar.a == com.xiaomi.xmpush.thrift.a.UnRegistration) {
                        a2.h();
                        MiPushClient.clearExtras(this.b);
                        PushMessageHandler.a();
                    } else {
                        MiPushClient.unregisterPush(this.b);
                    }
                } else if (ac.b(abVar)) {
                    return a(abVar, booleanExtra, byteArrayExtra);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!");
                    a();
                }
            } catch (org.apache.thrift.f e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            com.xiaomi.xmpush.thrift.ab abVar2 = new com.xiaomi.xmpush.thrift.ab();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    aq.a(abVar2, byteArrayExtra2);
                }
            } catch (org.apache.thrift.f e3) {
            }
            miPushCommandMessage.setCommand(String.valueOf(abVar2.a()));
            miPushCommandMessage.setResultCode(intent.getIntExtra("mipush_error_code", 0));
            miPushCommandMessage.setReason(intent.getStringExtra("mipush_error_msg"));
            com.xiaomi.channel.commonutils.logger.b.d("receive a error message. code = " + intent.getIntExtra("mipush_error_code", 0) + ", msg= " + intent.getStringExtra("mipush_error_msg"));
            return miPushCommandMessage;
        } else if ("com.xiaomi.mipush.MESSAGE_ARRIVED".equals(action)) {
            byte[] byteArrayExtra3 = intent.getByteArrayExtra("mipush_payload");
            if (byteArrayExtra3 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an empty message, drop");
                return null;
            }
            com.xiaomi.xmpush.thrift.ab abVar3 = new com.xiaomi.xmpush.thrift.ab();
            try {
                aq.a(abVar3, byteArrayExtra3);
                a a3 = a.a(this.b);
                if (ac.b(abVar3)) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive ignore reg message, ignore!");
                } else if (!a3.i()) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive message without registration. need unregister or re-register!");
                } else if (!a3.i() || !a3.n()) {
                    return a(abVar3, byteArrayExtra3);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: app info is invalidated");
                }
            } catch (org.apache.thrift.f e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
            } catch (Exception e5) {
                com.xiaomi.channel.commonutils.logger.b.a(e5);
            }
        }
        return null;
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        if (timeZone.equals(timeZone2)) {
            return list;
        }
        long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
        long parseLong = ((((Long.parseLong(list.get(0).split(SystemInfoUtil.COLON)[0]) * 60) + Long.parseLong(list.get(0).split(SystemInfoUtil.COLON)[1])) - rawOffset) + 1440) % 1440;
        long parseLong2 = (((Long.parseLong(list.get(1).split(SystemInfoUtil.COLON)[1]) + (60 * Long.parseLong(list.get(1).split(SystemInfoUtil.COLON)[0]))) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }
}
