package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.sapi2.utils.SapiUtils;
import com.xiaomi.mipush.sdk.PushMessageHandler;
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
public class aw {
    private static Queue<String> c;
    private Context b;
    private static aw a = null;
    private static Object d = new Object();

    private aw(Context context) {
        this.b = context.getApplicationContext();
        if (this.b == null) {
            this.b = context;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent a(Context context, String str, Map<String, String> map) {
        int i;
        Intent intent;
        String str2;
        Intent intent2;
        URISyntaxException e;
        if (map == null || !map.containsKey("notify_effect")) {
            return null;
        }
        String str3 = map.get("notify_effect");
        String str4 = map.get("intent_flag");
        try {
        } catch (NumberFormatException e2) {
            com.xiaomi.channel.commonutils.logger.b.d("Cause by intent_flag: " + e2.getMessage());
        }
        if (!TextUtils.isEmpty(str4)) {
            i = Integer.parseInt(str4);
            if (com.xiaomi.push.service.aw.a.equals(str3)) {
                if (com.xiaomi.push.service.aw.b.equals(str3)) {
                    if (map.containsKey("intent_uri")) {
                        String str5 = map.get("intent_uri");
                        if (str5 != null) {
                            try {
                                intent = Intent.parseUri(str5, 1);
                            } catch (URISyntaxException e3) {
                                e = e3;
                                intent = null;
                            }
                            try {
                                intent.setPackage(str);
                            } catch (URISyntaxException e4) {
                                e = e4;
                                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                                if (intent == null) {
                                }
                            }
                        } else {
                            intent = null;
                        }
                    } else if (map.containsKey("class_name")) {
                        Intent intent3 = new Intent();
                        intent3.setComponent(new ComponentName(str, map.get("class_name")));
                        intent = intent3;
                    }
                } else if (com.xiaomi.push.service.aw.c.equals(str3) && (str2 = map.get("web_uri")) != null) {
                    String trim = str2.trim();
                    String str6 = (trim.startsWith("http://") || trim.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) ? trim : "http://" + trim;
                    try {
                        String protocol = new URL(str6).getProtocol();
                        if (HttpHost.DEFAULT_SCHEME_NAME.equals(protocol) || "https".equals(protocol)) {
                            intent = new Intent("android.intent.action.VIEW");
                            try {
                                intent.setData(Uri.parse(str6));
                            } catch (MalformedURLException e5) {
                                intent2 = intent;
                                e = e5;
                                com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
                                intent = intent2;
                                if (intent == null) {
                                }
                            }
                        } else {
                            intent = null;
                        }
                    } catch (MalformedURLException e6) {
                        e = e6;
                        intent2 = null;
                    }
                }
                intent = null;
            } else {
                try {
                    intent = context.getPackageManager().getLaunchIntentForPackage(str);
                } catch (Exception e7) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e7.getMessage());
                    intent = null;
                }
            }
            if (intent == null) {
                if (i >= 0) {
                    intent.setFlags(i);
                }
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
        i = -1;
        if (com.xiaomi.push.service.aw.a.equals(str3)) {
        }
        if (intent == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:305:0x095f  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x096c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private PushMessageHandler.a a(com.xiaomi.xmpush.thrift.af afVar, boolean z, byte[] bArr, String str, int i) {
        int i2;
        List<String> list;
        MiPushMessage generateMessage;
        try {
            org.apache.thrift.a a2 = as.a(this.b, afVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + afVar.a);
                com.xiaomi.push.service.clientReport.d.a(this.b).b(com.xiaomi.push.service.clientReport.c.a(i), str, "receiving an un-recognized message.");
                return null;
            }
            com.xiaomi.xmpush.thrift.a a3 = afVar.a();
            com.xiaomi.channel.commonutils.logger.b.a("processing a message, action=" + a3);
            switch (ay.a[a3.ordinal()]) {
                case 1:
                    if (d.a(this.b).l() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.a("receive a message in pause state. drop it");
                        com.xiaomi.push.service.clientReport.d.a(this.b).a(com.xiaomi.push.service.clientReport.c.a(i), str, "receive a message in pause state. drop it");
                        return null;
                    }
                    com.xiaomi.xmpush.thrift.am amVar = (com.xiaomi.xmpush.thrift.am) a2;
                    com.xiaomi.xmpush.thrift.t l = amVar.l();
                    if (l == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                        com.xiaomi.push.service.clientReport.d.a(this.b).b(com.xiaomi.push.service.clientReport.c.a(i), str, "receive an empty message without push content, drop it");
                        return null;
                    }
                    if (z) {
                        if (com.xiaomi.push.service.ah.b(afVar)) {
                            MiPushClient.reportIgnoreRegMessageClicked(this.b, l.b(), afVar.m(), afVar.f, l.d());
                        } else {
                            MiPushClient.reportMessageClicked(this.b, l.b(), afVar.m(), l.d());
                        }
                    }
                    if (!z) {
                        if (!TextUtils.isEmpty(amVar.j()) && MiPushClient.aliasSetTime(this.b, amVar.j()) < 0) {
                            MiPushClient.addAlias(this.b, amVar.j());
                        } else if (!TextUtils.isEmpty(amVar.h()) && MiPushClient.topicSubscribedTime(this.b, amVar.h()) < 0) {
                            MiPushClient.addTopic(this.b, amVar.h());
                        }
                    }
                    String str2 = null;
                    if (afVar.h != null && afVar.h.s() != null) {
                        str2 = afVar.h.j.get("jobkey");
                    }
                    String b = TextUtils.isEmpty(str2) ? l.b() : str2;
                    if (z || !b(this.b, b)) {
                        generateMessage = PushMessageHelper.generateMessage(amVar, afVar.m(), z);
                        if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.ah.a(generateMessage.getExtra())) {
                            com.xiaomi.push.service.ah.a(this.b, afVar, bArr);
                            return null;
                        }
                        com.xiaomi.channel.commonutils.logger.b.a("receive a message, msgid=" + l.b() + ", jobkey=" + b);
                        if (z && generateMessage.getExtra() != null && generateMessage.getExtra().containsKey("notify_effect")) {
                            Map<String, String> extra = generateMessage.getExtra();
                            String str3 = extra.get("notify_effect");
                            if (com.xiaomi.push.service.ah.b(afVar)) {
                                Intent a4 = a(this.b, afVar.f, extra);
                                a4.putExtra("eventMessageType", i);
                                a4.putExtra("messageId", str);
                                if (a4 == null) {
                                    com.xiaomi.channel.commonutils.logger.b.a("Getting Intent fail from ignore reg message. ");
                                    com.xiaomi.push.service.clientReport.d.a(this.b).b(com.xiaomi.push.service.clientReport.c.a(i), str, "Getting Intent fail from ignore reg message.");
                                    return null;
                                }
                                String f = l.f();
                                if (!TextUtils.isEmpty(f)) {
                                    a4.putExtra("payload", f);
                                }
                                this.b.startActivity(a4);
                                com.xiaomi.push.service.clientReport.d.a(this.b).a(com.xiaomi.push.service.clientReport.c.a(i), str, 3006, "business message is clicked typeId " + str3);
                            } else {
                                Intent a5 = a(this.b, this.b.getPackageName(), extra);
                                if (a5 != null) {
                                    if (!str3.equals(com.xiaomi.push.service.aw.c)) {
                                        a5.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                        a5.putExtra("eventMessageType", i);
                                        a5.putExtra("messageId", str);
                                    }
                                    this.b.startActivity(a5);
                                    com.xiaomi.push.service.clientReport.d.a(this.b).a(com.xiaomi.push.service.clientReport.c.a(i), str, 1006, "notification message is clicked typeId " + str3);
                                    if (str3.equals(com.xiaomi.push.service.aw.c)) {
                                        com.xiaomi.push.service.clientReport.d.a(this.b).a(com.xiaomi.push.service.clientReport.c.a(i), str, "try open web page typeId " + str3);
                                    }
                                }
                            }
                            return null;
                        }
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.a("drop a duplicate message, key=" + b);
                        com.xiaomi.push.service.clientReport.d.a(this.b).c(com.xiaomi.push.service.clientReport.c.a(i), str, "drop a duplicate message, key=" + b);
                        generateMessage = null;
                    }
                    if (afVar.m() != null || z) {
                        return generateMessage;
                    }
                    a(amVar, afVar);
                    return generateMessage;
                case 2:
                    com.xiaomi.xmpush.thrift.ak akVar = (com.xiaomi.xmpush.thrift.ak) a2;
                    String str4 = d.a(this.b).a;
                    if (TextUtils.isEmpty(str4) || !TextUtils.equals(str4, akVar.c())) {
                        com.xiaomi.channel.commonutils.logger.b.a("bad Registration result:");
                        return null;
                    }
                    d.a(this.b).a = null;
                    if (akVar.e == 0) {
                        d.a(this.b).b(akVar.g, akVar.h, akVar.r);
                    }
                    ArrayList arrayList = null;
                    if (!TextUtils.isEmpty(akVar.g)) {
                        arrayList = new ArrayList();
                        arrayList.add(akVar.g);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(com.xiaomi.push.service.xmpush.a.COMMAND_REGISTER.k, arrayList, akVar.e, akVar.f, null);
                    az.a(this.b).e();
                    return generateCommandMessage;
                case 3:
                    if (((com.xiaomi.xmpush.thrift.aq) a2).e == 0) {
                        d.a(this.b).i();
                        MiPushClient.clearExtras(this.b);
                    }
                    PushMessageHandler.a();
                    break;
                case 4:
                    com.xiaomi.xmpush.thrift.ao aoVar = (com.xiaomi.xmpush.thrift.ao) a2;
                    if (aoVar.e == 0) {
                        MiPushClient.addTopic(this.b, aoVar.g());
                    }
                    ArrayList arrayList2 = null;
                    if (!TextUtils.isEmpty(aoVar.g())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(aoVar.g());
                    }
                    return PushMessageHelper.generateCommandMessage(com.xiaomi.push.service.xmpush.a.COMMAND_SUBSCRIBE_TOPIC.k, arrayList2, aoVar.e, aoVar.f, aoVar.j());
                case 5:
                    com.xiaomi.xmpush.thrift.as asVar = (com.xiaomi.xmpush.thrift.as) a2;
                    if (asVar.e == 0) {
                        MiPushClient.removeTopic(this.b, asVar.g());
                    }
                    ArrayList arrayList3 = null;
                    if (!TextUtils.isEmpty(asVar.g())) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(asVar.g());
                    }
                    return PushMessageHelper.generateCommandMessage(com.xiaomi.push.service.xmpush.a.COMMAND_UNSUBSCRIBE_TOPIC.k, arrayList3, asVar.e, asVar.f, asVar.j());
                case 6:
                    com.xiaomi.push.clientreport.a.a(this.b, a2, com.xiaomi.xmpush.thrift.a.Command, bArr.length);
                    com.xiaomi.xmpush.thrift.ae aeVar = (com.xiaomi.xmpush.thrift.ae) a2;
                    String d2 = aeVar.d();
                    List<String> i3 = aeVar.i();
                    if (aeVar.e == 0) {
                        if (TextUtils.equals(d2, com.xiaomi.push.service.xmpush.a.COMMAND_SET_ACCEPT_TIME.k) && i3 != null && i3.size() > 1) {
                            MiPushClient.addAcceptTime(this.b, i3.get(0), i3.get(1));
                            if ("00:00".equals(i3.get(0)) && "00:00".equals(i3.get(1))) {
                                d.a(this.b).a(true);
                            } else {
                                d.a(this.b).a(false);
                            }
                            list = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), i3);
                        } else if (TextUtils.equals(d2, com.xiaomi.push.service.xmpush.a.COMMAND_SET_ALIAS.k) && i3 != null && i3.size() > 0) {
                            MiPushClient.addAlias(this.b, i3.get(0));
                            list = i3;
                        } else if (TextUtils.equals(d2, com.xiaomi.push.service.xmpush.a.COMMAND_UNSET_ALIAS.k) && i3 != null && i3.size() > 0) {
                            MiPushClient.removeAlias(this.b, i3.get(0));
                            list = i3;
                        } else if (TextUtils.equals(d2, com.xiaomi.push.service.xmpush.a.COMMAND_SET_ACCOUNT.k) && i3 != null && i3.size() > 0) {
                            MiPushClient.addAccount(this.b, i3.get(0));
                            list = i3;
                        } else if (TextUtils.equals(d2, com.xiaomi.push.service.xmpush.a.COMMAND_UNSET_ACCOUNT.k) && i3 != null && i3.size() > 0) {
                            MiPushClient.removeAccount(this.b, i3.get(0));
                            list = i3;
                        } else if (TextUtils.equals(d2, com.xiaomi.push.service.xmpush.a.COMMAND_CHK_VDEVID.k)) {
                            if (i3 != null && i3.size() > 0) {
                                com.xiaomi.channel.commonutils.android.d.a(this.b, i3.get(0));
                            }
                            return null;
                        }
                        return PushMessageHelper.generateCommandMessage(d2, list, aeVar.e, aeVar.f, aeVar.k());
                    }
                    list = i3;
                    return PushMessageHelper.generateCommandMessage(d2, list, aeVar.e, aeVar.f, aeVar.k());
                case 7:
                    com.xiaomi.push.clientreport.a.a(this.b, a2, com.xiaomi.xmpush.thrift.a.Notification, bArr.length);
                    if (a2 instanceof com.xiaomi.xmpush.thrift.aa) {
                        com.xiaomi.xmpush.thrift.aa aaVar = (com.xiaomi.xmpush.thrift.aa) a2;
                        String c2 = aaVar.c();
                        if (com.xiaomi.xmpush.thrift.r.DisablePushMessage.aa.equalsIgnoreCase(aaVar.e)) {
                            if (aaVar.f == 0) {
                                synchronized (ap.class) {
                                    if (ap.a(this.b).e(c2)) {
                                        ap.a(this.b).d(c2);
                                        if ("syncing".equals(ap.a(this.b).a(be.DISABLE_PUSH))) {
                                            ap.a(this.b).a(be.DISABLE_PUSH, "synced");
                                            MiPushClient.clearNotification(this.b);
                                            MiPushClient.clearLocalNotificationType(this.b);
                                            PushMessageHandler.a();
                                            az.a(this.b).b();
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ap.a(this.b).a(be.DISABLE_PUSH))) {
                                synchronized (ap.class) {
                                    if (ap.a(this.b).e(c2)) {
                                        if (ap.a(this.b).c(c2) < 10) {
                                            ap.a(this.b).b(c2);
                                            az.a(this.b).a(true, c2);
                                        } else {
                                            ap.a(this.b).d(c2);
                                        }
                                    }
                                }
                                break;
                            } else {
                                ap.a(this.b).d(c2);
                                break;
                            }
                        } else if (com.xiaomi.xmpush.thrift.r.EnablePushMessage.aa.equalsIgnoreCase(aaVar.e)) {
                            if (aaVar.f == 0) {
                                synchronized (ap.class) {
                                    if (ap.a(this.b).e(c2)) {
                                        ap.a(this.b).d(c2);
                                        if ("syncing".equals(ap.a(this.b).a(be.ENABLE_PUSH))) {
                                            ap.a(this.b).a(be.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ap.a(this.b).a(be.ENABLE_PUSH))) {
                                synchronized (ap.class) {
                                    if (ap.a(this.b).e(c2)) {
                                        if (ap.a(this.b).c(c2) < 10) {
                                            ap.a(this.b).b(c2);
                                            az.a(this.b).a(false, c2);
                                        } else {
                                            ap.a(this.b).d(c2);
                                        }
                                    }
                                }
                                break;
                            } else {
                                ap.a(this.b).d(c2);
                                break;
                            }
                        } else if (com.xiaomi.xmpush.thrift.r.ThirdPartyRegUpdate.aa.equalsIgnoreCase(aaVar.e)) {
                            a(aaVar);
                            break;
                        }
                    } else if (a2 instanceof com.xiaomi.xmpush.thrift.ai) {
                        com.xiaomi.xmpush.thrift.ai aiVar = (com.xiaomi.xmpush.thrift.ai) a2;
                        if ("registration id expired".equalsIgnoreCase(aiVar.e)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.b);
                            List<String> allTopic = MiPushClient.getAllTopic(this.b);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.b);
                            String acceptTime = MiPushClient.getAcceptTime(this.b);
                            MiPushClient.reInitialize(this.b, com.xiaomi.xmpush.thrift.w.RegIdExpired);
                            for (String str5 : allAlias) {
                                MiPushClient.removeAlias(this.b, str5);
                                MiPushClient.setAlias(this.b, str5, null);
                            }
                            for (String str6 : allTopic) {
                                MiPushClient.removeTopic(this.b, str6);
                                MiPushClient.subscribe(this.b, str6, null);
                            }
                            for (String str7 : allUserAccount) {
                                MiPushClient.removeAccount(this.b, str7);
                                MiPushClient.setUserAccount(this.b, str7, null);
                            }
                            String[] split = acceptTime.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.b);
                                MiPushClient.addAcceptTime(this.b, split[0], split[1]);
                                break;
                            }
                        } else if ("client_info_update_ok".equalsIgnoreCase(aiVar.e)) {
                            if (aiVar.j() != null && aiVar.j().containsKey("app_version")) {
                                d.a(this.b).a(aiVar.j().get("app_version"));
                                break;
                            }
                        } else if (com.xiaomi.xmpush.thrift.r.AwakeApp.aa.equalsIgnoreCase(aiVar.e)) {
                            if (afVar.c() && aiVar.j() != null && aiVar.j().containsKey("awake_info")) {
                                o.a(this.b, d.a(this.b).c(), com.xiaomi.push.service.an.a(this.b).a(com.xiaomi.xmpush.thrift.g.AwakeInfoUploadWaySwitch.a(), 0), aiVar.j().get("awake_info"));
                                break;
                            }
                        } else if (com.xiaomi.xmpush.thrift.r.NormalClientConfigUpdate.aa.equalsIgnoreCase(aiVar.e)) {
                            com.xiaomi.xmpush.thrift.ah ahVar = new com.xiaomi.xmpush.thrift.ah();
                            try {
                                com.xiaomi.xmpush.thrift.at.a(ahVar, aiVar.q());
                                com.xiaomi.push.service.ao.a(com.xiaomi.push.service.an.a(this.b), ahVar);
                                i.c(this.b);
                                com.xiaomi.push.service.awake.module.c.a(this.b).a(com.xiaomi.push.service.an.a(this.b).a(com.xiaomi.xmpush.thrift.g.AwakeInfoUploadWaySwitch.a(), 0));
                                com.xiaomi.push.service.clientReport.c.b(this.b);
                                break;
                            } catch (org.apache.thrift.f e) {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                break;
                            }
                        } else if (com.xiaomi.xmpush.thrift.r.CustomClientConfigUpdate.aa.equalsIgnoreCase(aiVar.e)) {
                            com.xiaomi.xmpush.thrift.ag agVar = new com.xiaomi.xmpush.thrift.ag();
                            try {
                                com.xiaomi.xmpush.thrift.at.a(agVar, aiVar.q());
                                com.xiaomi.push.service.ao.a(com.xiaomi.push.service.an.a(this.b), agVar);
                                i.c(this.b);
                                com.xiaomi.push.service.awake.module.c.a(this.b).a(com.xiaomi.push.service.an.a(this.b).a(com.xiaomi.xmpush.thrift.g.AwakeInfoUploadWaySwitch.a(), 0));
                                com.xiaomi.push.service.clientReport.c.b(this.b);
                                break;
                            } catch (org.apache.thrift.f e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                                break;
                            }
                        } else if (com.xiaomi.xmpush.thrift.r.SyncInfoResult.aa.equalsIgnoreCase(aiVar.e)) {
                            bf.a(this.b, aiVar);
                            break;
                        } else if (com.xiaomi.xmpush.thrift.r.ForceSync.aa.equalsIgnoreCase(aiVar.e)) {
                            com.xiaomi.channel.commonutils.logger.b.a("receive force sync notification");
                            bf.a(this.b, false);
                            break;
                        } else if (com.xiaomi.xmpush.thrift.r.GeoRegsiter.aa.equalsIgnoreCase(aiVar.e)) {
                            w.a(this.b).a(aiVar);
                            break;
                        } else if (com.xiaomi.xmpush.thrift.r.GeoUnregsiter.aa.equalsIgnoreCase(aiVar.e)) {
                            w.a(this.b).b(aiVar);
                            break;
                        } else if (com.xiaomi.xmpush.thrift.r.GeoSync.aa.equalsIgnoreCase(aiVar.e)) {
                            w.a(this.b).c(aiVar);
                            break;
                        } else if (!com.xiaomi.xmpush.thrift.r.CancelPushMessage.aa.equals(aiVar.e)) {
                            if (com.xiaomi.xmpush.thrift.r.HybridRegisterResult.aa.equals(aiVar.e)) {
                                try {
                                    com.xiaomi.xmpush.thrift.ak akVar2 = new com.xiaomi.xmpush.thrift.ak();
                                    com.xiaomi.xmpush.thrift.at.a(akVar2, aiVar.q());
                                    MiPushClient4Hybrid.onReceiveRegisterResult(this.b, akVar2);
                                    break;
                                } catch (org.apache.thrift.f e3) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    break;
                                }
                            } else if (com.xiaomi.xmpush.thrift.r.HybridUnregisterResult.aa.equals(aiVar.e)) {
                                try {
                                    com.xiaomi.xmpush.thrift.aq aqVar = new com.xiaomi.xmpush.thrift.aq();
                                    com.xiaomi.xmpush.thrift.at.a(aqVar, aiVar.q());
                                    MiPushClient4Hybrid.onReceiveUnregisterResult(this.b, aqVar);
                                    break;
                                } catch (org.apache.thrift.f e4) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    break;
                                }
                            } else if (com.xiaomi.xmpush.thrift.r.PushLogUpload.aa.equals(aiVar.e) && aiVar.j() != null && aiVar.j().containsKey("packages")) {
                                String[] split2 = aiVar.j().get("packages").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                if (TextUtils.equals(this.b.getPackageName(), "com.xiaomi.xmsf")) {
                                    Logger.uploadLogFile(this.b, true);
                                    a(this.b, split2);
                                    break;
                                } else {
                                    Logger.uploadLogFile(this.b, false);
                                    break;
                                }
                            }
                        } else if (aiVar.j() != null) {
                            if (aiVar.j().containsKey(com.xiaomi.push.service.aw.J)) {
                                String str8 = aiVar.j().get(com.xiaomi.push.service.aw.J);
                                if (!TextUtils.isEmpty(str8)) {
                                    try {
                                        i2 = Integer.parseInt(str8);
                                    } catch (NumberFormatException e5) {
                                        e5.printStackTrace();
                                        i2 = -2;
                                    }
                                    if (i2 < -1) {
                                        MiPushClient.clearNotification(this.b, i2);
                                        break;
                                    } else {
                                        MiPushClient.clearNotification(this.b, aiVar.j().containsKey(com.xiaomi.push.service.aw.H) ? aiVar.j().get(com.xiaomi.push.service.aw.H) : "", aiVar.j().containsKey(com.xiaomi.push.service.aw.I) ? aiVar.j().get(com.xiaomi.push.service.aw.I) : "");
                                        break;
                                    }
                                }
                            }
                            i2 = -2;
                            if (i2 < -1) {
                            }
                        }
                    }
                    break;
            }
            return null;
        } catch (t e6) {
            com.xiaomi.channel.commonutils.logger.b.a(e6);
            a(afVar);
            com.xiaomi.push.service.clientReport.d.a(this.b).a(com.xiaomi.push.service.clientReport.c.a(i), str, e6);
            return null;
        } catch (org.apache.thrift.f e7) {
            com.xiaomi.channel.commonutils.logger.b.a(e7);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            com.xiaomi.push.service.clientReport.d.a(this.b).a(com.xiaomi.push.service.clientReport.c.a(i), str, e7);
            return null;
        }
    }

    private PushMessageHandler.a a(com.xiaomi.xmpush.thrift.af afVar, byte[] bArr) {
        String str = null;
        try {
            org.apache.thrift.a a2 = as.a(this.b, afVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + afVar.a);
                return null;
            }
            com.xiaomi.xmpush.thrift.a a3 = afVar.a();
            com.xiaomi.channel.commonutils.logger.b.a("message arrived: processing an arrived message, action=" + a3);
            switch (ay.a[a3.ordinal()]) {
                case 1:
                    com.xiaomi.xmpush.thrift.am amVar = (com.xiaomi.xmpush.thrift.am) a2;
                    com.xiaomi.xmpush.thrift.t l = amVar.l();
                    if (l == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive an empty message without push content, drop it");
                        return null;
                    }
                    if (afVar.h != null && afVar.h.s() != null) {
                        str = afVar.h.j.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(amVar, afVar.m(), false);
                    generateMessage.setArrivedMessage(true);
                    com.xiaomi.channel.commonutils.logger.b.a("message arrived: receive a message, msgid=" + l.b() + ", jobkey=" + str);
                    return generateMessage;
                default:
                    return null;
            }
        } catch (t e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message but decrypt failed. report when click.");
            return null;
        } catch (org.apache.thrift.f e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    public static aw a(Context context) {
        if (a == null) {
            a = new aw(context);
        }
        return a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.b, com.xiaomi.xmpush.thrift.w.PackageUnregistered);
            sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, PackageInfo packageInfo) {
        ServiceInfo[] serviceInfoArr = packageInfo.services;
        if (serviceInfoArr != null) {
            for (ServiceInfo serviceInfo : serviceInfoArr) {
                if (serviceInfo.exported && serviceInfo.enabled && "com.xiaomi.mipush.sdk.PushMessageHandler".equals(serviceInfo.name) && !context.getPackageName().equals(serviceInfo.packageName)) {
                    try {
                        Intent intent = new Intent();
                        intent.setClassName(serviceInfo.packageName, serviceInfo.name);
                        intent.setAction("com.xiaomi.mipush.sdk.SYNC_LOG");
                        PushMessageHandler.a(context, intent);
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                }
            }
        }
    }

    public static void a(Context context, String str) {
        synchronized (d) {
            c.remove(str);
            d.a(context);
            SharedPreferences b = d.b(context);
            String a2 = com.xiaomi.channel.commonutils.string.d.a(c, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = b.edit();
            edit.putString("pref_msg_ids", a2);
            com.xiaomi.channel.commonutils.android.l.a(edit);
        }
    }

    private void a(Context context, String[] strArr) {
        com.xiaomi.channel.commonutils.misc.h.a(context).a(new ax(this, strArr, context));
    }

    private void a(com.xiaomi.xmpush.thrift.aa aaVar) {
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + aaVar.toString());
        String c2 = aaVar.c();
        Map<String, String> i = aaVar.i();
        if (i != null) {
            String str = i.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + aq.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : receive fcm token sync ack");
                i.b(this.b, f.ASSEMBLE_PUSH_FCM, str);
                a(c2, aaVar.f, f.ASSEMBLE_PUSH_FCM);
            } else if (str.contains("brand:" + aq.HUAWEI.name())) {
                com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : receive hw token sync ack");
                i.b(this.b, f.ASSEMBLE_PUSH_HUAWEI, str);
                a(c2, aaVar.f, f.ASSEMBLE_PUSH_HUAWEI);
            } else if (str.contains("brand:" + aq.OPPO.name())) {
                com.xiaomi.channel.commonutils.logger.b.a("ASSEMBLE_PUSH : receive COS token sync ack");
                i.b(this.b, f.ASSEMBLE_PUSH_COS, str);
                a(c2, aaVar.f, f.ASSEMBLE_PUSH_COS);
            }
        }
    }

    private void a(com.xiaomi.xmpush.thrift.af afVar) {
        com.xiaomi.channel.commonutils.logger.b.a("receive a message but decrypt failed. report now.");
        com.xiaomi.xmpush.thrift.ai aiVar = new com.xiaomi.xmpush.thrift.ai(afVar.m().a, false);
        aiVar.c(com.xiaomi.xmpush.thrift.r.DecryptMessageFail.aa);
        aiVar.b(afVar.h());
        aiVar.d(afVar.f);
        aiVar.h = new HashMap();
        aiVar.h.put("regid", MiPushClient.getRegId(this.b));
        az.a(this.b).a((az) aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, (com.xiaomi.xmpush.thrift.u) null);
    }

    private void a(com.xiaomi.xmpush.thrift.am amVar, com.xiaomi.xmpush.thrift.af afVar) {
        com.xiaomi.xmpush.thrift.u m = afVar.m();
        com.xiaomi.xmpush.thrift.z zVar = new com.xiaomi.xmpush.thrift.z();
        zVar.b(amVar.e());
        zVar.a(amVar.c());
        zVar.a(amVar.l().h());
        if (!TextUtils.isEmpty(amVar.h())) {
            zVar.c(amVar.h());
        }
        if (!TextUtils.isEmpty(amVar.j())) {
            zVar.d(amVar.j());
        }
        zVar.a(com.xiaomi.xmpush.thrift.at.a(this.b, afVar));
        az.a(this.b).a((az) zVar, com.xiaomi.xmpush.thrift.a.AckMessage, m);
    }

    private void a(String str, long j, f fVar) {
        be c2 = l.c(fVar);
        if (c2 == null) {
            return;
        }
        if (j == 0) {
            synchronized (ap.class) {
                if (ap.a(this.b).e(str)) {
                    ap.a(this.b).d(str);
                    if ("syncing".equals(ap.a(this.b).a(c2))) {
                        ap.a(this.b).a(c2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(ap.a(this.b).a(c2))) {
            ap.a(this.b).d(str);
        } else {
            synchronized (ap.class) {
                if (ap.a(this.b).e(str)) {
                    if (ap.a(this.b).c(str) < 10) {
                        ap.a(this.b).b(str);
                        az.a(this.b).a(str, c2, fVar);
                    } else {
                        ap.a(this.b).d(str);
                    }
                }
            }
        }
    }

    private void b(com.xiaomi.xmpush.thrift.af afVar) {
        com.xiaomi.xmpush.thrift.u m = afVar.m();
        com.xiaomi.xmpush.thrift.z zVar = new com.xiaomi.xmpush.thrift.z();
        zVar.b(afVar.h());
        zVar.a(m.b());
        zVar.a(m.d());
        if (!TextUtils.isEmpty(m.f())) {
            zVar.c(m.f());
        }
        zVar.a(com.xiaomi.xmpush.thrift.at.a(this.b, afVar));
        az.a(this.b).a((az) zVar, com.xiaomi.xmpush.thrift.a.AckMessage, false, afVar.m());
    }

    private static boolean b(Context context, String str) {
        boolean z = false;
        synchronized (d) {
            d.a(context);
            SharedPreferences b = d.b(context);
            if (c == null) {
                String[] split = b.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                String a2 = com.xiaomi.channel.commonutils.string.d.a(c, Constants.ACCEPT_TIME_SEPARATOR_SP);
                SharedPreferences.Editor edit = b.edit();
                edit.putString("pref_msg_ids", a2);
                com.xiaomi.channel.commonutils.android.l.a(edit);
            }
        }
        return z;
    }

    private boolean c(com.xiaomi.xmpush.thrift.af afVar) {
        if (TextUtils.equals(Constants.HYBRID_PACKAGE_NAME, afVar.j()) || TextUtils.equals(Constants.HYBRID_DEBUG_PACKAGE_NAME, afVar.j())) {
            Map<String, String> s = afVar.m() == null ? null : afVar.m().s();
            if (s == null) {
                return false;
            }
            String str = s.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
            return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
        }
        return false;
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
            String stringExtra2 = intent.getStringExtra("messageId");
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (byteArrayExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an empty message, drop");
                com.xiaomi.push.service.clientReport.d.a(this.b).a(intent, "receiving an empty message, drop");
                return null;
            }
            com.xiaomi.xmpush.thrift.af afVar = new com.xiaomi.xmpush.thrift.af();
            try {
                com.xiaomi.xmpush.thrift.at.a(afVar, byteArrayExtra);
                d a2 = d.a(this.b);
                com.xiaomi.xmpush.thrift.u m = afVar.m();
                if (afVar.a() == com.xiaomi.xmpush.thrift.a.SendMessage && m != null && !a2.l() && !booleanExtra) {
                    m.a("mrt", stringExtra);
                    m.a("mat", Long.toString(System.currentTimeMillis()));
                    if (c(afVar)) {
                        com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                        m.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m.d()));
                        m.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) com.xiaomi.xmpush.thrift.at.a(this.b, afVar)));
                    } else {
                        b(afVar);
                    }
                }
                if (afVar.a() == com.xiaomi.xmpush.thrift.a.SendMessage && !afVar.c()) {
                    if (!com.xiaomi.push.service.ah.b(afVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = afVar.j();
                        objArr[1] = m != null ? m.b() : "";
                        com.xiaomi.channel.commonutils.logger.b.a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr));
                        com.xiaomi.push.service.clientReport.d a3 = com.xiaomi.push.service.clientReport.d.a(this.b);
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = afVar.j();
                        objArr2[1] = m != null ? m.b() : "";
                        a3.a(intent, String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        return null;
                    } else if (!booleanExtra || m.s() == null || !m.s().containsKey("notify_effect")) {
                        com.xiaomi.channel.commonutils.logger.b.a(String.format("drop an un-encrypted messages. %1$s, %2$s", afVar.j(), m.b()));
                        com.xiaomi.push.service.clientReport.d a4 = com.xiaomi.push.service.clientReport.d.a(this.b);
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = afVar.j();
                        objArr3[1] = m != null ? m.b() : "";
                        a4.a(intent, String.format("drop an un-encrypted messages. %1$s, %2$s", objArr3));
                        return null;
                    }
                }
                if (a2.j() || afVar.a == com.xiaomi.xmpush.thrift.a.Registration) {
                    if (!a2.j() || !a2.n()) {
                        return a(afVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                    }
                    if (afVar.a == com.xiaomi.xmpush.thrift.a.UnRegistration) {
                        a2.i();
                        MiPushClient.clearExtras(this.b);
                        PushMessageHandler.a();
                    } else {
                        MiPushClient.unregisterPush(this.b);
                    }
                } else if (com.xiaomi.push.service.ah.b(afVar)) {
                    return a(afVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!");
                    com.xiaomi.push.service.clientReport.d.a(this.b).a(intent, "receive message without registration. need re-register!");
                    a();
                }
            } catch (org.apache.thrift.f e) {
                com.xiaomi.push.service.clientReport.d.a(this.b).a(intent, e);
                com.xiaomi.channel.commonutils.logger.b.a(e);
            } catch (Exception e2) {
                com.xiaomi.push.service.clientReport.d.a(this.b).a(intent, e2);
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            com.xiaomi.xmpush.thrift.af afVar2 = new com.xiaomi.xmpush.thrift.af();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    com.xiaomi.xmpush.thrift.at.a(afVar2, byteArrayExtra2);
                }
            } catch (org.apache.thrift.f e3) {
            }
            miPushCommandMessage.setCommand(String.valueOf(afVar2.a()));
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
            com.xiaomi.xmpush.thrift.af afVar3 = new com.xiaomi.xmpush.thrift.af();
            try {
                com.xiaomi.xmpush.thrift.at.a(afVar3, byteArrayExtra3);
                d a5 = d.a(this.b);
                if (com.xiaomi.push.service.ah.b(afVar3)) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive ignore reg message, ignore!");
                } else if (!a5.j()) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive message without registration. need unregister or re-register!");
                } else if (!a5.j() || !a5.n()) {
                    return a(afVar3, byteArrayExtra3);
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
        long parseLong = ((((Long.parseLong(list.get(0).split(":")[0]) * 60) + Long.parseLong(list.get(0).split(":")[1])) - rawOffset) + 1440) % 1440;
        long parseLong2 = (((Long.parseLong(list.get(1).split(":")[1]) + (60 * Long.parseLong(list.get(1).split(":")[0]))) - rawOffset) + 1440) % 1440;
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
        arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
        return arrayList;
    }
}
