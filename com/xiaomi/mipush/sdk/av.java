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
import com.xiaomi.push.Cif;
import com.xiaomi.push.bk;
import com.xiaomi.push.da;
import com.xiaomi.push.eu;
import com.xiaomi.push.ev;
import com.xiaomi.push.fa;
import com.xiaomi.push.hg;
import com.xiaomi.push.hl;
import com.xiaomi.push.hq;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ie;
import com.xiaomi.push.ih;
import com.xiaomi.push.ij;
import com.xiaomi.push.il;
import com.xiaomi.push.in;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.ir;
import com.xiaomi.push.iw;
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
/* loaded from: classes8.dex */
public class av {
    private static av a = null;

    /* renamed from: a  reason: collision with other field name */
    private static Object f41a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Queue<String> f42a;

    /* renamed from: a  reason: collision with other field name */
    private Context f43a;

    private av(Context context) {
        this.f43a = context.getApplicationContext();
        if (this.f43a == null) {
            this.f43a = context;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
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
            if (com.xiaomi.push.service.ap.a.equals(str3)) {
                if (com.xiaomi.push.service.ap.b.equals(str3)) {
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
                } else if (com.xiaomi.push.service.ap.c.equals(str3) && (str2 = map.get("web_uri")) != null) {
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
                    com.xiaomi.channel.commonutils.logger.b.m47a("not resolve activity:" + intent);
                    return null;
                } catch (Exception e8) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e8.getMessage());
                    return null;
                }
            }
            return null;
        }
        i = -1;
        if (com.xiaomi.push.service.ap.a.equals(str3)) {
        }
        if (intent == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:300:0x097f  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x098c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private PushMessageHandler.a a(ic icVar, boolean z, byte[] bArr, String str, int i) {
        int i2;
        List<String> list;
        MiPushMessage generateMessage;
        try {
            ir a2 = ar.a(this.f43a, icVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + icVar.f611a);
                ev.a(this.f43a).b(this.f43a.getPackageName(), eu.m260a(i), str, "receiving an un-recognized message.");
                return null;
            }
            hg a3 = icVar.a();
            com.xiaomi.channel.commonutils.logger.b.m47a("processing a message, action=" + a3);
            switch (ax.a[a3.ordinal()]) {
                case 1:
                    if (d.m85a(this.f43a).m95d() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.m47a("receive a message in pause state. drop it");
                        ev.a(this.f43a).a(this.f43a.getPackageName(), eu.m260a(i), str, "receive a message in pause state. drop it");
                        return null;
                    }
                    ij ijVar = (ij) a2;
                    hs a4 = ijVar.a();
                    if (a4 == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                        ev.a(this.f43a).b(this.f43a.getPackageName(), eu.m260a(i), str, "receive an empty message without push content, drop it");
                        return null;
                    }
                    if (z) {
                        if (com.xiaomi.push.service.z.m555a(icVar)) {
                            MiPushClient.reportIgnoreRegMessageClicked(this.f43a, a4.m358a(), icVar.m401a(), icVar.f618b, a4.b());
                        } else {
                            MiPushClient.reportMessageClicked(this.f43a, a4.m358a(), icVar.m401a(), a4.b());
                        }
                    }
                    if (!z) {
                        if (!TextUtils.isEmpty(ijVar.d()) && MiPushClient.aliasSetTime(this.f43a, ijVar.d()) < 0) {
                            MiPushClient.addAlias(this.f43a, ijVar.d());
                        } else if (!TextUtils.isEmpty(ijVar.c()) && MiPushClient.topicSubscribedTime(this.f43a, ijVar.c()) < 0) {
                            MiPushClient.addTopic(this.f43a, ijVar.c());
                        }
                    }
                    String str2 = null;
                    if (icVar.f612a != null && icVar.f612a.m367a() != null) {
                        str2 = icVar.f612a.f525a.get("jobkey");
                    }
                    String m358a = TextUtils.isEmpty(str2) ? a4.m358a() : str2;
                    if (z || !m64a(this.f43a, m358a)) {
                        generateMessage = PushMessageHelper.generateMessage(ijVar, icVar.m401a(), z);
                        if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.z.m557a(generateMessage.getExtra())) {
                            com.xiaomi.push.service.z.m551a(this.f43a, icVar, bArr);
                            return null;
                        }
                        com.xiaomi.channel.commonutils.logger.b.m47a("receive a message, msgid=" + a4.m358a() + ", jobkey=" + m358a);
                        if (z && generateMessage.getExtra() != null && generateMessage.getExtra().containsKey("notify_effect")) {
                            Map<String, String> extra = generateMessage.getExtra();
                            String str3 = extra.get("notify_effect");
                            if (com.xiaomi.push.service.z.m555a(icVar)) {
                                Intent a5 = a(this.f43a, icVar.f618b, extra);
                                a5.putExtra("eventMessageType", i);
                                a5.putExtra("messageId", str);
                                if (a5 == null) {
                                    com.xiaomi.channel.commonutils.logger.b.m47a("Getting Intent fail from ignore reg message. ");
                                    ev.a(this.f43a).b(this.f43a.getPackageName(), eu.m260a(i), str, "Getting Intent fail from ignore reg message.");
                                    return null;
                                }
                                String c = a4.c();
                                if (!TextUtils.isEmpty(c)) {
                                    a5.putExtra("payload", c);
                                }
                                this.f43a.startActivity(a5);
                                ev.a(this.f43a).a(this.f43a.getPackageName(), eu.m260a(i), str, 3006, "business message is clicked typeId " + str3);
                            } else {
                                Intent a6 = a(this.f43a, this.f43a.getPackageName(), extra);
                                if (a6 != null) {
                                    if (!str3.equals(com.xiaomi.push.service.ap.c)) {
                                        a6.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                        a6.putExtra("eventMessageType", i);
                                        a6.putExtra("messageId", str);
                                    }
                                    this.f43a.startActivity(a6);
                                    com.xiaomi.channel.commonutils.logger.b.m47a("start activity succ");
                                    ev.a(this.f43a).a(this.f43a.getPackageName(), eu.m260a(i), str, 1006, "notification message is clicked typeId " + str3);
                                    if (str3.equals(com.xiaomi.push.service.ap.c)) {
                                        ev.a(this.f43a).a(this.f43a.getPackageName(), eu.m260a(i), str, "try open web page typeId " + str3);
                                    }
                                }
                            }
                            return null;
                        }
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.m47a("drop a duplicate message, key=" + m358a);
                        ev.a(this.f43a).c(this.f43a.getPackageName(), eu.m260a(i), str, "drop a duplicate message, key=" + m358a);
                        generateMessage = null;
                    }
                    if (icVar.m401a() != null || z) {
                        return generateMessage;
                    }
                    a(ijVar, icVar);
                    return generateMessage;
                case 2:
                    ih ihVar = (ih) a2;
                    String str4 = d.m85a(this.f43a).f61a;
                    if (TextUtils.isEmpty(str4) || !TextUtils.equals(str4, ihVar.m429a())) {
                        com.xiaomi.channel.commonutils.logger.b.m47a("bad Registration result:");
                        ev.a(this.f43a).b(this.f43a.getPackageName(), eu.m260a(i), str, "bad Registration result:");
                        return null;
                    }
                    d.m85a(this.f43a).f61a = null;
                    if (ihVar.f673a == 0) {
                        d.m85a(this.f43a).b(ihVar.f683e, ihVar.f684f, ihVar.f690l);
                        ev.a(this.f43a).a(this.f43a.getPackageName(), eu.m260a(i), str, 6006, "receive register result success");
                    } else {
                        ev.a(this.f43a).a(this.f43a.getPackageName(), eu.m260a(i), str, 6006, "receive register result fail");
                    }
                    ArrayList arrayList = null;
                    if (!TextUtils.isEmpty(ihVar.f683e)) {
                        arrayList = new ArrayList();
                        arrayList.add(ihVar.f683e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(fa.COMMAND_REGISTER.f333a, arrayList, ihVar.f673a, ihVar.f682d, null);
                    ay.a(this.f43a).m81d();
                    return generateCommandMessage;
                case 3:
                    if (((in) a2).f749a == 0) {
                        d.m85a(this.f43a).m87a();
                        MiPushClient.clearExtras(this.f43a);
                    }
                    PushMessageHandler.a();
                    break;
                case 4:
                    il ilVar = (il) a2;
                    if (ilVar.f724a == 0) {
                        MiPushClient.addTopic(this.f43a, ilVar.a());
                    }
                    ArrayList arrayList2 = null;
                    if (!TextUtils.isEmpty(ilVar.a())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(ilVar.a());
                    }
                    return PushMessageHelper.generateCommandMessage(fa.COMMAND_SUBSCRIBE_TOPIC.f333a, arrayList2, ilVar.f724a, ilVar.f730d, ilVar.b());
                case 5:
                    ip ipVar = (ip) a2;
                    if (ipVar.f769a == 0) {
                        MiPushClient.removeTopic(this.f43a, ipVar.a());
                    }
                    ArrayList arrayList3 = null;
                    if (!TextUtils.isEmpty(ipVar.a())) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(ipVar.a());
                    }
                    return PushMessageHelper.generateCommandMessage(fa.COMMAND_UNSUBSCRIBE_TOPIC.f333a, arrayList3, ipVar.f769a, ipVar.f775d, ipVar.b());
                case 6:
                    da.a(this.f43a.getPackageName(), this.f43a, a2, hg.Command, bArr.length);
                    ib ibVar = (ib) a2;
                    String a7 = ibVar.a();
                    List<String> m396a = ibVar.m396a();
                    if (ibVar.f599a == 0) {
                        if (TextUtils.equals(a7, fa.COMMAND_SET_ACCEPT_TIME.f333a) && m396a != null && m396a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f43a, m396a.get(0), m396a.get(1));
                            if ("00:00".equals(m396a.get(0)) && "00:00".equals(m396a.get(1))) {
                                d.m85a(this.f43a).a(true);
                            } else {
                                d.m85a(this.f43a).a(false);
                            }
                            list = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m396a);
                        } else if (TextUtils.equals(a7, fa.COMMAND_SET_ALIAS.f333a) && m396a != null && m396a.size() > 0) {
                            MiPushClient.addAlias(this.f43a, m396a.get(0));
                            list = m396a;
                        } else if (TextUtils.equals(a7, fa.COMMAND_UNSET_ALIAS.f333a) && m396a != null && m396a.size() > 0) {
                            MiPushClient.removeAlias(this.f43a, m396a.get(0));
                            list = m396a;
                        } else if (TextUtils.equals(a7, fa.COMMAND_SET_ACCOUNT.f333a) && m396a != null && m396a.size() > 0) {
                            MiPushClient.addAccount(this.f43a, m396a.get(0));
                            list = m396a;
                        } else if (TextUtils.equals(a7, fa.COMMAND_UNSET_ACCOUNT.f333a) && m396a != null && m396a.size() > 0) {
                            MiPushClient.removeAccount(this.f43a, m396a.get(0));
                            list = m396a;
                        } else if (TextUtils.equals(a7, fa.COMMAND_CHK_VDEVID.f333a)) {
                            if (m396a != null && m396a.size() > 0) {
                                com.xiaomi.push.i.a(this.f43a, m396a.get(0));
                            }
                            return null;
                        }
                        return PushMessageHelper.generateCommandMessage(a7, list, ibVar.f599a, ibVar.f607d, ibVar.b());
                    }
                    list = m396a;
                    return PushMessageHelper.generateCommandMessage(a7, list, ibVar.f599a, ibVar.f607d, ibVar.b());
                case 7:
                    da.a(this.f43a.getPackageName(), this.f43a, a2, hg.Notification, bArr.length);
                    if (a2 instanceof hx) {
                        hx hxVar = (hx) a2;
                        String a8 = hxVar.a();
                        if (hq.DisablePushMessage.f490a.equalsIgnoreCase(hxVar.f575d)) {
                            if (hxVar.f568a == 0) {
                                synchronized (ao.class) {
                                    if (ao.a(this.f43a).m63a(a8)) {
                                        ao.a(this.f43a).c(a8);
                                        if ("syncing".equals(ao.a(this.f43a).a(bd.DISABLE_PUSH))) {
                                            ao.a(this.f43a).a(bd.DISABLE_PUSH, "synced");
                                            MiPushClient.clearNotification(this.f43a);
                                            MiPushClient.clearLocalNotificationType(this.f43a);
                                            PushMessageHandler.a();
                                            ay.a(this.f43a).m78b();
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ao.a(this.f43a).a(bd.DISABLE_PUSH))) {
                                synchronized (ao.class) {
                                    if (ao.a(this.f43a).m63a(a8)) {
                                        if (ao.a(this.f43a).a(a8) < 10) {
                                            ao.a(this.f43a).b(a8);
                                            ay.a(this.f43a).a(true, a8);
                                        } else {
                                            ao.a(this.f43a).c(a8);
                                        }
                                    }
                                }
                                break;
                            } else {
                                ao.a(this.f43a).c(a8);
                                break;
                            }
                        } else if (hq.EnablePushMessage.f490a.equalsIgnoreCase(hxVar.f575d)) {
                            if (hxVar.f568a == 0) {
                                synchronized (ao.class) {
                                    if (ao.a(this.f43a).m63a(a8)) {
                                        ao.a(this.f43a).c(a8);
                                        if ("syncing".equals(ao.a(this.f43a).a(bd.ENABLE_PUSH))) {
                                            ao.a(this.f43a).a(bd.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ao.a(this.f43a).a(bd.ENABLE_PUSH))) {
                                synchronized (ao.class) {
                                    if (ao.a(this.f43a).m63a(a8)) {
                                        if (ao.a(this.f43a).a(a8) < 10) {
                                            ao.a(this.f43a).b(a8);
                                            ay.a(this.f43a).a(false, a8);
                                        } else {
                                            ao.a(this.f43a).c(a8);
                                        }
                                    }
                                }
                                break;
                            } else {
                                ao.a(this.f43a).c(a8);
                                break;
                            }
                        } else if (hq.ThirdPartyRegUpdate.f490a.equalsIgnoreCase(hxVar.f575d)) {
                            b(hxVar);
                            break;
                        } else if (hq.UploadTinyData.f490a.equalsIgnoreCase(hxVar.f575d)) {
                            a(hxVar);
                            break;
                        }
                    } else if (a2 instanceof Cif) {
                        Cif cif = (Cif) a2;
                        if ("registration id expired".equalsIgnoreCase(cif.f635d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f43a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f43a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f43a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f43a);
                            MiPushClient.reInitialize(this.f43a, hu.RegIdExpired);
                            for (String str5 : allAlias) {
                                MiPushClient.removeAlias(this.f43a, str5);
                                MiPushClient.setAlias(this.f43a, str5, null);
                            }
                            for (String str6 : allTopic) {
                                MiPushClient.removeTopic(this.f43a, str6);
                                MiPushClient.subscribe(this.f43a, str6, null);
                            }
                            for (String str7 : allUserAccount) {
                                MiPushClient.removeAccount(this.f43a, str7);
                                MiPushClient.setUserAccount(this.f43a, str7, null);
                            }
                            String[] split = acceptTime.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f43a);
                                MiPushClient.addAcceptTime(this.f43a, split[0], split[1]);
                                break;
                            }
                        } else if ("client_info_update_ok".equalsIgnoreCase(cif.f635d)) {
                            if (cif.m416a() != null && cif.m416a().containsKey("app_version")) {
                                d.m85a(this.f43a).m88a(cif.m416a().get("app_version"));
                                break;
                            }
                        } else if (hq.AwakeApp.f490a.equalsIgnoreCase(cif.f635d)) {
                            if (icVar.m409b() && cif.m416a() != null && cif.m416a().containsKey("awake_info")) {
                                p.a(this.f43a, d.m85a(this.f43a).m86a(), com.xiaomi.push.service.ag.a(this.f43a).a(hl.AwakeInfoUploadWaySwitch.a(), 0), cif.m416a().get("awake_info"));
                                break;
                            }
                        } else if (hq.NormalClientConfigUpdate.f490a.equalsIgnoreCase(cif.f635d)) {
                            ie ieVar = new ie();
                            try {
                                iq.a(ieVar, cif.m421a());
                                com.xiaomi.push.service.ah.a(com.xiaomi.push.service.ag.a(this.f43a), ieVar);
                                break;
                            } catch (iw e) {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                break;
                            }
                        } else if (hq.CustomClientConfigUpdate.f490a.equalsIgnoreCase(cif.f635d)) {
                            id idVar = new id();
                            try {
                                iq.a(idVar, cif.m421a());
                                com.xiaomi.push.service.ah.a(com.xiaomi.push.service.ag.a(this.f43a), idVar);
                                break;
                            } catch (iw e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                                break;
                            }
                        } else if (hq.SyncInfoResult.f490a.equalsIgnoreCase(cif.f635d)) {
                            be.a(this.f43a, cif);
                            break;
                        } else if (hq.ForceSync.f490a.equalsIgnoreCase(cif.f635d)) {
                            com.xiaomi.channel.commonutils.logger.b.m47a("receive force sync notification");
                            be.a(this.f43a, false);
                            break;
                        } else if (!hq.CancelPushMessage.f490a.equals(cif.f635d)) {
                            if (hq.HybridRegisterResult.f490a.equals(cif.f635d)) {
                                try {
                                    ih ihVar2 = new ih();
                                    iq.a(ihVar2, cif.m421a());
                                    MiPushClient4Hybrid.onReceiveRegisterResult(this.f43a, ihVar2);
                                    break;
                                } catch (iw e3) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    break;
                                }
                            } else if (hq.HybridUnregisterResult.f490a.equals(cif.f635d)) {
                                try {
                                    in inVar = new in();
                                    iq.a(inVar, cif.m421a());
                                    MiPushClient4Hybrid.onReceiveUnregisterResult(this.f43a, inVar);
                                    break;
                                } catch (iw e4) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    break;
                                }
                            } else if (hq.PushLogUpload.f490a.equals(cif.f635d) && cif.m416a() != null && cif.m416a().containsKey("packages")) {
                                String[] split2 = cif.m416a().get("packages").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                if (TextUtils.equals(this.f43a.getPackageName(), "com.xiaomi.xmsf")) {
                                    Logger.uploadLogFile(this.f43a, true);
                                    a(this.f43a, split2);
                                    break;
                                } else {
                                    Logger.uploadLogFile(this.f43a, false);
                                    break;
                                }
                            }
                        } else if (cif.m416a() != null) {
                            if (cif.m416a().containsKey(com.xiaomi.push.service.ap.J)) {
                                String str8 = cif.m416a().get(com.xiaomi.push.service.ap.J);
                                if (!TextUtils.isEmpty(str8)) {
                                    try {
                                        i2 = Integer.parseInt(str8);
                                    } catch (NumberFormatException e5) {
                                        e5.printStackTrace();
                                        i2 = -2;
                                    }
                                    if (i2 < -1) {
                                        MiPushClient.clearNotification(this.f43a, i2);
                                        break;
                                    } else {
                                        MiPushClient.clearNotification(this.f43a, cif.m416a().containsKey(com.xiaomi.push.service.ap.H) ? cif.m416a().get(com.xiaomi.push.service.ap.H) : "", cif.m416a().containsKey(com.xiaomi.push.service.ap.I) ? cif.m416a().get(com.xiaomi.push.service.ap.I) : "");
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
        } catch (v e6) {
            com.xiaomi.channel.commonutils.logger.b.a(e6);
            a(icVar);
            ev.a(this.f43a).a(this.f43a.getPackageName(), eu.m260a(i), str, e6);
            return null;
        } catch (iw e7) {
            com.xiaomi.channel.commonutils.logger.b.a(e7);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            ev.a(this.f43a).a(this.f43a.getPackageName(), eu.m260a(i), str, e7);
            return null;
        }
    }

    private PushMessageHandler.a a(ic icVar, byte[] bArr) {
        String str = null;
        try {
            ir a2 = ar.a(this.f43a, icVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + icVar.f611a);
                return null;
            }
            hg a3 = icVar.a();
            com.xiaomi.channel.commonutils.logger.b.m47a("message arrived: processing an arrived message, action=" + a3);
            switch (ax.a[a3.ordinal()]) {
                case 1:
                    ij ijVar = (ij) a2;
                    hs a4 = ijVar.a();
                    if (a4 == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive an empty message without push content, drop it");
                        return null;
                    }
                    if (icVar.f612a != null && icVar.f612a.m367a() != null) {
                        str = icVar.f612a.f525a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(ijVar, icVar.m401a(), false);
                    generateMessage.setArrivedMessage(true);
                    com.xiaomi.channel.commonutils.logger.b.m47a("message arrived: receive a message, msgid=" + a4.m358a() + ", jobkey=" + str);
                    return generateMessage;
                default:
                    return null;
            }
        } catch (v e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message but decrypt failed. report when click.");
            return null;
        } catch (iw e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive a message which action string is not valid. is the reg expired?");
            return null;
        }
    }

    public static av a(Context context) {
        if (a == null) {
            a = new av(context);
        }
        return a;
    }

    private void a() {
        SharedPreferences sharedPreferences = this.f43a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f43a, hu.PackageUnregistered);
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
        synchronized (f41a) {
            f42a.remove(str);
            d.m85a(context);
            SharedPreferences a2 = d.a(context);
            String a3 = com.xiaomi.push.ay.a(f42a, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = a2.edit();
            edit.putString("pref_msg_ids", a3);
            com.xiaomi.push.r.a(edit);
        }
    }

    private void a(Context context, String[] strArr) {
        com.xiaomi.push.ai.a(context).a(new aw(this, strArr, context));
    }

    private void a(hx hxVar) {
        String a2 = hxVar.a();
        com.xiaomi.channel.commonutils.logger.b.b("receive ack " + a2);
        Map<String, String> m381a = hxVar.m381a();
        if (m381a != null) {
            String str = m381a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
            bk.a(this.f43a).a(a2, str, Boolean.valueOf(hxVar.f568a == 0));
        }
    }

    private void a(ic icVar) {
        com.xiaomi.channel.commonutils.logger.b.m47a("receive a message but decrypt failed. report now.");
        Cif cif = new Cif(icVar.m401a().f523a, false);
        cif.c(hq.DecryptMessageFail.f490a);
        cif.b(icVar.m402a());
        cif.d(icVar.f618b);
        cif.f630a = new HashMap();
        cif.f630a.put("regid", MiPushClient.getRegId(this.f43a));
        ay.a(this.f43a).a((ay) cif, hg.Notification, false, (ht) null);
    }

    private void a(ij ijVar, ic icVar) {
        ht m401a = icVar.m401a();
        hw hwVar = new hw();
        hwVar.b(ijVar.b());
        hwVar.a(ijVar.m436a());
        hwVar.a(ijVar.a().a());
        if (!TextUtils.isEmpty(ijVar.c())) {
            hwVar.c(ijVar.c());
        }
        if (!TextUtils.isEmpty(ijVar.d())) {
            hwVar.d(ijVar.d());
        }
        hwVar.a(iq.a(this.f43a, icVar));
        ay.a(this.f43a).a((ay) hwVar, hg.AckMessage, m401a);
    }

    private void a(String str, long j, f fVar) {
        bd a2 = m.a(fVar);
        if (a2 == null) {
            return;
        }
        if (j == 0) {
            synchronized (ao.class) {
                if (ao.a(this.f43a).m63a(str)) {
                    ao.a(this.f43a).c(str);
                    if ("syncing".equals(ao.a(this.f43a).a(a2))) {
                        ao.a(this.f43a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(ao.a(this.f43a).a(a2))) {
            ao.a(this.f43a).c(str);
        } else {
            synchronized (ao.class) {
                if (ao.a(this.f43a).m63a(str)) {
                    if (ao.a(this.f43a).a(str) < 10) {
                        ao.a(this.f43a).b(str);
                        ay.a(this.f43a).a(str, a2, fVar);
                    } else {
                        ao.a(this.f43a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m64a(Context context, String str) {
        boolean z = false;
        synchronized (f41a) {
            d.m85a(context);
            SharedPreferences a2 = d.a(context);
            if (f42a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                f42a = new LinkedList();
                for (String str2 : split) {
                    f42a.add(str2);
                }
            }
            if (f42a.contains(str)) {
                z = true;
            } else {
                f42a.add(str);
                if (f42a.size() > 25) {
                    f42a.poll();
                }
                String a3 = com.xiaomi.push.ay.a(f42a, Constants.ACCEPT_TIME_SEPARATOR_SP);
                SharedPreferences.Editor edit = a2.edit();
                edit.putString("pref_msg_ids", a3);
                com.xiaomi.push.r.a(edit);
            }
        }
        return z;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m65a(ic icVar) {
        if (TextUtils.equals(Constants.HYBRID_PACKAGE_NAME, icVar.b()) || TextUtils.equals(Constants.HYBRID_DEBUG_PACKAGE_NAME, icVar.b())) {
            Map<String, String> m367a = icVar.m401a() == null ? null : icVar.m401a().m367a();
            if (m367a == null) {
                return false;
            }
            String str = m367a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
            return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
        }
        return false;
    }

    private void b(hx hxVar) {
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + hxVar.toString());
        String a2 = hxVar.a();
        Map<String, String> m381a = hxVar.m381a();
        if (m381a != null) {
            String str = m381a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + ap.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : receive fcm token sync ack");
                j.b(this.f43a, f.ASSEMBLE_PUSH_FCM, str);
                a(a2, hxVar.f568a, f.ASSEMBLE_PUSH_FCM);
            } else if (str.contains("brand:" + ap.HUAWEI.name())) {
                com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : receive hw token sync ack");
                j.b(this.f43a, f.ASSEMBLE_PUSH_HUAWEI, str);
                a(a2, hxVar.f568a, f.ASSEMBLE_PUSH_HUAWEI);
            } else if (str.contains("brand:" + ap.OPPO.name())) {
                com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : receive COS token sync ack");
                j.b(this.f43a, f.ASSEMBLE_PUSH_COS, str);
                a(a2, hxVar.f568a, f.ASSEMBLE_PUSH_COS);
            } else if (str.contains("brand:" + ap.VIVO.name())) {
                com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                j.b(this.f43a, f.ASSEMBLE_PUSH_FTOS, str);
                a(a2, hxVar.f568a, f.ASSEMBLE_PUSH_FTOS);
            }
        }
    }

    private void b(ic icVar) {
        ht m401a = icVar.m401a();
        hw hwVar = new hw();
        hwVar.b(icVar.m402a());
        hwVar.a(m401a.m366a());
        hwVar.a(m401a.m364a());
        if (!TextUtils.isEmpty(m401a.m371b())) {
            hwVar.c(m401a.m371b());
        }
        hwVar.a(iq.a(this.f43a, icVar));
        ay.a(this.f43a).a((ay) hwVar, hg.AckMessage, false, icVar.m401a());
    }

    public PushMessageHandler.a a(Intent intent) {
        String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.m47a("receive an intent from server, action=" + action);
        String stringExtra = intent.getStringExtra("mrt");
        if (stringExtra == null) {
            stringExtra = Long.toString(System.currentTimeMillis());
        }
        String stringExtra2 = intent.getStringExtra("messageId");
        int intExtra = intent.getIntExtra("eventMessageType", -1);
        if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
            boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
            if (byteArrayExtra == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an empty message, drop");
                ev.a(this.f43a).a(this.f43a.getPackageName(), intent, "receiving an empty message, drop");
                return null;
            }
            ic icVar = new ic();
            try {
                iq.a(icVar, byteArrayExtra);
                d m85a = d.m85a(this.f43a);
                ht m401a = icVar.m401a();
                if (icVar.a() == hg.SendMessage && m401a != null && !m85a.m95d() && !booleanExtra) {
                    m401a.a("mrt", stringExtra);
                    m401a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (m65a(icVar)) {
                        com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                        m401a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m401a.m364a()));
                        m401a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) iq.a(this.f43a, icVar)));
                    } else {
                        b(icVar);
                    }
                }
                if (icVar.a() == hg.SendMessage && !icVar.m409b()) {
                    if (!com.xiaomi.push.service.z.m555a(icVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = icVar.b();
                        objArr[1] = m401a != null ? m401a.m366a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m47a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr));
                        ev a2 = ev.a(this.f43a);
                        String packageName = this.f43a.getPackageName();
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = icVar.b();
                        objArr2[1] = m401a != null ? m401a.m366a() : "";
                        a2.a(packageName, intent, String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        return null;
                    } else if (!booleanExtra || m401a.m367a() == null || !m401a.m367a().containsKey("notify_effect")) {
                        com.xiaomi.channel.commonutils.logger.b.m47a(String.format("drop an un-encrypted messages. %1$s, %2$s", icVar.b(), m401a.m366a()));
                        ev a3 = ev.a(this.f43a);
                        String packageName2 = this.f43a.getPackageName();
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = icVar.b();
                        objArr3[1] = m401a != null ? m401a.m366a() : "";
                        a3.a(packageName2, intent, String.format("drop an un-encrypted messages. %1$s, %2$s", objArr3));
                        return null;
                    }
                }
                if (m85a.m94c() || icVar.f611a == hg.Registration) {
                    if (!m85a.m94c() || !m85a.m96e()) {
                        return a(icVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                    }
                    if (icVar.f611a == hg.UnRegistration) {
                        m85a.m87a();
                        MiPushClient.clearExtras(this.f43a);
                        PushMessageHandler.a();
                    } else {
                        MiPushClient.unregisterPush(this.f43a);
                    }
                } else if (com.xiaomi.push.service.z.m555a(icVar)) {
                    return a(icVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!");
                    ev.a(this.f43a).a(this.f43a.getPackageName(), intent, "receive message without registration. need re-register!");
                    a();
                }
            } catch (iw e) {
                ev.a(this.f43a).a(this.f43a.getPackageName(), intent, e);
                com.xiaomi.channel.commonutils.logger.b.a(e);
            } catch (Exception e2) {
                ev.a(this.f43a).a(this.f43a.getPackageName(), intent, e2);
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
            MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
            ic icVar2 = new ic();
            try {
                byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                if (byteArrayExtra2 != null) {
                    iq.a(icVar2, byteArrayExtra2);
                }
            } catch (iw e3) {
            }
            miPushCommandMessage.setCommand(String.valueOf(icVar2.a()));
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
            ic icVar3 = new ic();
            try {
                iq.a(icVar3, byteArrayExtra3);
                d m85a2 = d.m85a(this.f43a);
                if (com.xiaomi.push.service.z.m555a(icVar3)) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive ignore reg message, ignore!");
                } else if (!m85a2.m94c()) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive message without registration. need unregister or re-register!");
                } else if (!m85a2.m94c() || !m85a2.m96e()) {
                    return a(icVar3, byteArrayExtra3);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: app info is invalidated");
                }
            } catch (iw e4) {
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
