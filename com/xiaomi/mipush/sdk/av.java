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
/* loaded from: classes6.dex */
public class av {
    private static av a = null;

    /* renamed from: a  reason: collision with other field name */
    private static Object f44a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static Queue<String> f45a;

    /* renamed from: a  reason: collision with other field name */
    private Context f46a;

    private av(Context context) {
        this.f46a = context.getApplicationContext();
        if (this.f46a == null) {
            this.f46a = context;
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
                    com.xiaomi.channel.commonutils.logger.b.m42a("not resolve activity:" + intent);
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
            ir a2 = ar.a(this.f46a, icVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + icVar.f614a);
                ev.a(this.f46a).b(this.f46a.getPackageName(), eu.m255a(i), str, "receiving an un-recognized message.");
                return null;
            }
            hg a3 = icVar.a();
            com.xiaomi.channel.commonutils.logger.b.m42a("processing a message, action=" + a3);
            switch (ax.a[a3.ordinal()]) {
                case 1:
                    if (d.m80a(this.f46a).m90d() && !z) {
                        com.xiaomi.channel.commonutils.logger.b.m42a("receive a message in pause state. drop it");
                        ev.a(this.f46a).a(this.f46a.getPackageName(), eu.m255a(i), str, "receive a message in pause state. drop it");
                        return null;
                    }
                    ij ijVar = (ij) a2;
                    hs a4 = ijVar.a();
                    if (a4 == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                        ev.a(this.f46a).b(this.f46a.getPackageName(), eu.m255a(i), str, "receive an empty message without push content, drop it");
                        return null;
                    }
                    if (z) {
                        if (com.xiaomi.push.service.z.m550a(icVar)) {
                            MiPushClient.reportIgnoreRegMessageClicked(this.f46a, a4.m353a(), icVar.m396a(), icVar.f621b, a4.b());
                        } else {
                            MiPushClient.reportMessageClicked(this.f46a, a4.m353a(), icVar.m396a(), a4.b());
                        }
                    }
                    if (!z) {
                        if (!TextUtils.isEmpty(ijVar.d()) && MiPushClient.aliasSetTime(this.f46a, ijVar.d()) < 0) {
                            MiPushClient.addAlias(this.f46a, ijVar.d());
                        } else if (!TextUtils.isEmpty(ijVar.c()) && MiPushClient.topicSubscribedTime(this.f46a, ijVar.c()) < 0) {
                            MiPushClient.addTopic(this.f46a, ijVar.c());
                        }
                    }
                    String str2 = null;
                    if (icVar.f615a != null && icVar.f615a.m362a() != null) {
                        str2 = icVar.f615a.f528a.get("jobkey");
                    }
                    String m353a = TextUtils.isEmpty(str2) ? a4.m353a() : str2;
                    if (z || !m59a(this.f46a, m353a)) {
                        generateMessage = PushMessageHelper.generateMessage(ijVar, icVar.m396a(), z);
                        if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.z.m552a(generateMessage.getExtra())) {
                            com.xiaomi.push.service.z.m546a(this.f46a, icVar, bArr);
                            return null;
                        }
                        com.xiaomi.channel.commonutils.logger.b.m42a("receive a message, msgid=" + a4.m353a() + ", jobkey=" + m353a);
                        if (z && generateMessage.getExtra() != null && generateMessage.getExtra().containsKey("notify_effect")) {
                            Map<String, String> extra = generateMessage.getExtra();
                            String str3 = extra.get("notify_effect");
                            if (com.xiaomi.push.service.z.m550a(icVar)) {
                                Intent a5 = a(this.f46a, icVar.f621b, extra);
                                a5.putExtra("eventMessageType", i);
                                a5.putExtra("messageId", str);
                                if (a5 == null) {
                                    com.xiaomi.channel.commonutils.logger.b.m42a("Getting Intent fail from ignore reg message. ");
                                    ev.a(this.f46a).b(this.f46a.getPackageName(), eu.m255a(i), str, "Getting Intent fail from ignore reg message.");
                                    return null;
                                }
                                String c = a4.c();
                                if (!TextUtils.isEmpty(c)) {
                                    a5.putExtra("payload", c);
                                }
                                this.f46a.startActivity(a5);
                                ev.a(this.f46a).a(this.f46a.getPackageName(), eu.m255a(i), str, 3006, "business message is clicked typeId " + str3);
                            } else {
                                Intent a6 = a(this.f46a, this.f46a.getPackageName(), extra);
                                if (a6 != null) {
                                    if (!str3.equals(com.xiaomi.push.service.ap.c)) {
                                        a6.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                        a6.putExtra("eventMessageType", i);
                                        a6.putExtra("messageId", str);
                                    }
                                    this.f46a.startActivity(a6);
                                    com.xiaomi.channel.commonutils.logger.b.m42a("start activity succ");
                                    ev.a(this.f46a).a(this.f46a.getPackageName(), eu.m255a(i), str, 1006, "notification message is clicked typeId " + str3);
                                    if (str3.equals(com.xiaomi.push.service.ap.c)) {
                                        ev.a(this.f46a).a(this.f46a.getPackageName(), eu.m255a(i), str, "try open web page typeId " + str3);
                                    }
                                }
                            }
                            return null;
                        }
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.m42a("drop a duplicate message, key=" + m353a);
                        ev.a(this.f46a).c(this.f46a.getPackageName(), eu.m255a(i), str, "drop a duplicate message, key=" + m353a);
                        generateMessage = null;
                    }
                    if (icVar.m396a() != null || z) {
                        return generateMessage;
                    }
                    a(ijVar, icVar);
                    return generateMessage;
                case 2:
                    ih ihVar = (ih) a2;
                    String str4 = d.m80a(this.f46a).f64a;
                    if (TextUtils.isEmpty(str4) || !TextUtils.equals(str4, ihVar.m424a())) {
                        com.xiaomi.channel.commonutils.logger.b.m42a("bad Registration result:");
                        ev.a(this.f46a).b(this.f46a.getPackageName(), eu.m255a(i), str, "bad Registration result:");
                        return null;
                    }
                    d.m80a(this.f46a).f64a = null;
                    if (ihVar.f676a == 0) {
                        d.m80a(this.f46a).b(ihVar.f686e, ihVar.f687f, ihVar.f693l);
                        ev.a(this.f46a).a(this.f46a.getPackageName(), eu.m255a(i), str, 6006, "receive register result success");
                    } else {
                        ev.a(this.f46a).a(this.f46a.getPackageName(), eu.m255a(i), str, 6006, "receive register result fail");
                    }
                    ArrayList arrayList = null;
                    if (!TextUtils.isEmpty(ihVar.f686e)) {
                        arrayList = new ArrayList();
                        arrayList.add(ihVar.f686e);
                    }
                    MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(fa.COMMAND_REGISTER.f336a, arrayList, ihVar.f676a, ihVar.f685d, null);
                    ay.a(this.f46a).m76d();
                    return generateCommandMessage;
                case 3:
                    if (((in) a2).f752a == 0) {
                        d.m80a(this.f46a).m82a();
                        MiPushClient.clearExtras(this.f46a);
                    }
                    PushMessageHandler.a();
                    break;
                case 4:
                    il ilVar = (il) a2;
                    if (ilVar.f727a == 0) {
                        MiPushClient.addTopic(this.f46a, ilVar.a());
                    }
                    ArrayList arrayList2 = null;
                    if (!TextUtils.isEmpty(ilVar.a())) {
                        arrayList2 = new ArrayList();
                        arrayList2.add(ilVar.a());
                    }
                    return PushMessageHelper.generateCommandMessage(fa.COMMAND_SUBSCRIBE_TOPIC.f336a, arrayList2, ilVar.f727a, ilVar.f733d, ilVar.b());
                case 5:
                    ip ipVar = (ip) a2;
                    if (ipVar.f772a == 0) {
                        MiPushClient.removeTopic(this.f46a, ipVar.a());
                    }
                    ArrayList arrayList3 = null;
                    if (!TextUtils.isEmpty(ipVar.a())) {
                        arrayList3 = new ArrayList();
                        arrayList3.add(ipVar.a());
                    }
                    return PushMessageHelper.generateCommandMessage(fa.COMMAND_UNSUBSCRIBE_TOPIC.f336a, arrayList3, ipVar.f772a, ipVar.f778d, ipVar.b());
                case 6:
                    da.a(this.f46a.getPackageName(), this.f46a, a2, hg.Command, bArr.length);
                    ib ibVar = (ib) a2;
                    String a7 = ibVar.a();
                    List<String> m391a = ibVar.m391a();
                    if (ibVar.f602a == 0) {
                        if (TextUtils.equals(a7, fa.COMMAND_SET_ACCEPT_TIME.f336a) && m391a != null && m391a.size() > 1) {
                            MiPushClient.addAcceptTime(this.f46a, m391a.get(0), m391a.get(1));
                            if ("00:00".equals(m391a.get(0)) && "00:00".equals(m391a.get(1))) {
                                d.m80a(this.f46a).a(true);
                            } else {
                                d.m80a(this.f46a).a(false);
                            }
                            list = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m391a);
                        } else if (TextUtils.equals(a7, fa.COMMAND_SET_ALIAS.f336a) && m391a != null && m391a.size() > 0) {
                            MiPushClient.addAlias(this.f46a, m391a.get(0));
                            list = m391a;
                        } else if (TextUtils.equals(a7, fa.COMMAND_UNSET_ALIAS.f336a) && m391a != null && m391a.size() > 0) {
                            MiPushClient.removeAlias(this.f46a, m391a.get(0));
                            list = m391a;
                        } else if (TextUtils.equals(a7, fa.COMMAND_SET_ACCOUNT.f336a) && m391a != null && m391a.size() > 0) {
                            MiPushClient.addAccount(this.f46a, m391a.get(0));
                            list = m391a;
                        } else if (TextUtils.equals(a7, fa.COMMAND_UNSET_ACCOUNT.f336a) && m391a != null && m391a.size() > 0) {
                            MiPushClient.removeAccount(this.f46a, m391a.get(0));
                            list = m391a;
                        } else if (TextUtils.equals(a7, fa.COMMAND_CHK_VDEVID.f336a)) {
                            if (m391a != null && m391a.size() > 0) {
                                com.xiaomi.push.i.a(this.f46a, m391a.get(0));
                            }
                            return null;
                        }
                        return PushMessageHelper.generateCommandMessage(a7, list, ibVar.f602a, ibVar.f610d, ibVar.b());
                    }
                    list = m391a;
                    return PushMessageHelper.generateCommandMessage(a7, list, ibVar.f602a, ibVar.f610d, ibVar.b());
                case 7:
                    da.a(this.f46a.getPackageName(), this.f46a, a2, hg.Notification, bArr.length);
                    if (a2 instanceof hx) {
                        hx hxVar = (hx) a2;
                        String a8 = hxVar.a();
                        if (hq.DisablePushMessage.f493a.equalsIgnoreCase(hxVar.f578d)) {
                            if (hxVar.f571a == 0) {
                                synchronized (ao.class) {
                                    if (ao.a(this.f46a).m58a(a8)) {
                                        ao.a(this.f46a).c(a8);
                                        if ("syncing".equals(ao.a(this.f46a).a(bd.DISABLE_PUSH))) {
                                            ao.a(this.f46a).a(bd.DISABLE_PUSH, "synced");
                                            MiPushClient.clearNotification(this.f46a);
                                            MiPushClient.clearLocalNotificationType(this.f46a);
                                            PushMessageHandler.a();
                                            ay.a(this.f46a).m73b();
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ao.a(this.f46a).a(bd.DISABLE_PUSH))) {
                                synchronized (ao.class) {
                                    if (ao.a(this.f46a).m58a(a8)) {
                                        if (ao.a(this.f46a).a(a8) < 10) {
                                            ao.a(this.f46a).b(a8);
                                            ay.a(this.f46a).a(true, a8);
                                        } else {
                                            ao.a(this.f46a).c(a8);
                                        }
                                    }
                                }
                                break;
                            } else {
                                ao.a(this.f46a).c(a8);
                                break;
                            }
                        } else if (hq.EnablePushMessage.f493a.equalsIgnoreCase(hxVar.f578d)) {
                            if (hxVar.f571a == 0) {
                                synchronized (ao.class) {
                                    if (ao.a(this.f46a).m58a(a8)) {
                                        ao.a(this.f46a).c(a8);
                                        if ("syncing".equals(ao.a(this.f46a).a(bd.ENABLE_PUSH))) {
                                            ao.a(this.f46a).a(bd.ENABLE_PUSH, "synced");
                                        }
                                    }
                                }
                                break;
                            } else if ("syncing".equals(ao.a(this.f46a).a(bd.ENABLE_PUSH))) {
                                synchronized (ao.class) {
                                    if (ao.a(this.f46a).m58a(a8)) {
                                        if (ao.a(this.f46a).a(a8) < 10) {
                                            ao.a(this.f46a).b(a8);
                                            ay.a(this.f46a).a(false, a8);
                                        } else {
                                            ao.a(this.f46a).c(a8);
                                        }
                                    }
                                }
                                break;
                            } else {
                                ao.a(this.f46a).c(a8);
                                break;
                            }
                        } else if (hq.ThirdPartyRegUpdate.f493a.equalsIgnoreCase(hxVar.f578d)) {
                            b(hxVar);
                            break;
                        } else if (hq.UploadTinyData.f493a.equalsIgnoreCase(hxVar.f578d)) {
                            a(hxVar);
                            break;
                        }
                    } else if (a2 instanceof Cif) {
                        Cif cif = (Cif) a2;
                        if ("registration id expired".equalsIgnoreCase(cif.f638d)) {
                            List<String> allAlias = MiPushClient.getAllAlias(this.f46a);
                            List<String> allTopic = MiPushClient.getAllTopic(this.f46a);
                            List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f46a);
                            String acceptTime = MiPushClient.getAcceptTime(this.f46a);
                            MiPushClient.reInitialize(this.f46a, hu.RegIdExpired);
                            for (String str5 : allAlias) {
                                MiPushClient.removeAlias(this.f46a, str5);
                                MiPushClient.setAlias(this.f46a, str5, null);
                            }
                            for (String str6 : allTopic) {
                                MiPushClient.removeTopic(this.f46a, str6);
                                MiPushClient.subscribe(this.f46a, str6, null);
                            }
                            for (String str7 : allUserAccount) {
                                MiPushClient.removeAccount(this.f46a, str7);
                                MiPushClient.setUserAccount(this.f46a, str7, null);
                            }
                            String[] split = acceptTime.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (split.length == 2) {
                                MiPushClient.removeAcceptTime(this.f46a);
                                MiPushClient.addAcceptTime(this.f46a, split[0], split[1]);
                                break;
                            }
                        } else if ("client_info_update_ok".equalsIgnoreCase(cif.f638d)) {
                            if (cif.m411a() != null && cif.m411a().containsKey("app_version")) {
                                d.m80a(this.f46a).m83a(cif.m411a().get("app_version"));
                                break;
                            }
                        } else if (hq.AwakeApp.f493a.equalsIgnoreCase(cif.f638d)) {
                            if (icVar.m404b() && cif.m411a() != null && cif.m411a().containsKey("awake_info")) {
                                p.a(this.f46a, d.m80a(this.f46a).m81a(), com.xiaomi.push.service.ag.a(this.f46a).a(hl.AwakeInfoUploadWaySwitch.a(), 0), cif.m411a().get("awake_info"));
                                break;
                            }
                        } else if (hq.NormalClientConfigUpdate.f493a.equalsIgnoreCase(cif.f638d)) {
                            ie ieVar = new ie();
                            try {
                                iq.a(ieVar, cif.m416a());
                                com.xiaomi.push.service.ah.a(com.xiaomi.push.service.ag.a(this.f46a), ieVar);
                                break;
                            } catch (iw e) {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                break;
                            }
                        } else if (hq.CustomClientConfigUpdate.f493a.equalsIgnoreCase(cif.f638d)) {
                            id idVar = new id();
                            try {
                                iq.a(idVar, cif.m416a());
                                com.xiaomi.push.service.ah.a(com.xiaomi.push.service.ag.a(this.f46a), idVar);
                                break;
                            } catch (iw e2) {
                                com.xiaomi.channel.commonutils.logger.b.a(e2);
                                break;
                            }
                        } else if (hq.SyncInfoResult.f493a.equalsIgnoreCase(cif.f638d)) {
                            be.a(this.f46a, cif);
                            break;
                        } else if (hq.ForceSync.f493a.equalsIgnoreCase(cif.f638d)) {
                            com.xiaomi.channel.commonutils.logger.b.m42a("receive force sync notification");
                            be.a(this.f46a, false);
                            break;
                        } else if (!hq.CancelPushMessage.f493a.equals(cif.f638d)) {
                            if (hq.HybridRegisterResult.f493a.equals(cif.f638d)) {
                                try {
                                    ih ihVar2 = new ih();
                                    iq.a(ihVar2, cif.m416a());
                                    MiPushClient4Hybrid.onReceiveRegisterResult(this.f46a, ihVar2);
                                    break;
                                } catch (iw e3) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    break;
                                }
                            } else if (hq.HybridUnregisterResult.f493a.equals(cif.f638d)) {
                                try {
                                    in inVar = new in();
                                    iq.a(inVar, cif.m416a());
                                    MiPushClient4Hybrid.onReceiveUnregisterResult(this.f46a, inVar);
                                    break;
                                } catch (iw e4) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e4);
                                    break;
                                }
                            } else if (hq.PushLogUpload.f493a.equals(cif.f638d) && cif.m411a() != null && cif.m411a().containsKey("packages")) {
                                String[] split2 = cif.m411a().get("packages").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                if (TextUtils.equals(this.f46a.getPackageName(), "com.xiaomi.xmsf")) {
                                    Logger.uploadLogFile(this.f46a, true);
                                    a(this.f46a, split2);
                                    break;
                                } else {
                                    Logger.uploadLogFile(this.f46a, false);
                                    break;
                                }
                            }
                        } else if (cif.m411a() != null) {
                            if (cif.m411a().containsKey(com.xiaomi.push.service.ap.J)) {
                                String str8 = cif.m411a().get(com.xiaomi.push.service.ap.J);
                                if (!TextUtils.isEmpty(str8)) {
                                    try {
                                        i2 = Integer.parseInt(str8);
                                    } catch (NumberFormatException e5) {
                                        e5.printStackTrace();
                                        i2 = -2;
                                    }
                                    if (i2 < -1) {
                                        MiPushClient.clearNotification(this.f46a, i2);
                                        break;
                                    } else {
                                        MiPushClient.clearNotification(this.f46a, cif.m411a().containsKey(com.xiaomi.push.service.ap.H) ? cif.m411a().get(com.xiaomi.push.service.ap.H) : "", cif.m411a().containsKey(com.xiaomi.push.service.ap.I) ? cif.m411a().get(com.xiaomi.push.service.ap.I) : "");
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
            ev.a(this.f46a).a(this.f46a.getPackageName(), eu.m255a(i), str, e6);
            return null;
        } catch (iw e7) {
            com.xiaomi.channel.commonutils.logger.b.a(e7);
            com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
            ev.a(this.f46a).a(this.f46a.getPackageName(), eu.m255a(i), str, e7);
            return null;
        }
    }

    private PushMessageHandler.a a(ic icVar, byte[] bArr) {
        String str = null;
        try {
            ir a2 = ar.a(this.f46a, icVar);
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + icVar.f614a);
                return null;
            }
            hg a3 = icVar.a();
            com.xiaomi.channel.commonutils.logger.b.m42a("message arrived: processing an arrived message, action=" + a3);
            switch (ax.a[a3.ordinal()]) {
                case 1:
                    ij ijVar = (ij) a2;
                    hs a4 = ijVar.a();
                    if (a4 == null) {
                        com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive an empty message without push content, drop it");
                        return null;
                    }
                    if (icVar.f615a != null && icVar.f615a.m362a() != null) {
                        str = icVar.f615a.f528a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(ijVar, icVar.m396a(), false);
                    generateMessage.setArrivedMessage(true);
                    com.xiaomi.channel.commonutils.logger.b.m42a("message arrived: receive a message, msgid=" + a4.m353a() + ", jobkey=" + str);
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
        SharedPreferences sharedPreferences = this.f46a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > 1800000) {
            MiPushClient.reInitialize(this.f46a, hu.PackageUnregistered);
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
        synchronized (f44a) {
            f45a.remove(str);
            d.m80a(context);
            SharedPreferences a2 = d.a(context);
            String a3 = com.xiaomi.push.ay.a(f45a, Constants.ACCEPT_TIME_SEPARATOR_SP);
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
        Map<String, String> m376a = hxVar.m376a();
        if (m376a != null) {
            String str = m376a.get("real_source");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
            bk.a(this.f46a).a(a2, str, Boolean.valueOf(hxVar.f571a == 0));
        }
    }

    private void a(ic icVar) {
        com.xiaomi.channel.commonutils.logger.b.m42a("receive a message but decrypt failed. report now.");
        Cif cif = new Cif(icVar.m396a().f526a, false);
        cif.c(hq.DecryptMessageFail.f493a);
        cif.b(icVar.m397a());
        cif.d(icVar.f621b);
        cif.f633a = new HashMap();
        cif.f633a.put("regid", MiPushClient.getRegId(this.f46a));
        ay.a(this.f46a).a((ay) cif, hg.Notification, false, (ht) null);
    }

    private void a(ij ijVar, ic icVar) {
        ht m396a = icVar.m396a();
        hw hwVar = new hw();
        hwVar.b(ijVar.b());
        hwVar.a(ijVar.m431a());
        hwVar.a(ijVar.a().a());
        if (!TextUtils.isEmpty(ijVar.c())) {
            hwVar.c(ijVar.c());
        }
        if (!TextUtils.isEmpty(ijVar.d())) {
            hwVar.d(ijVar.d());
        }
        hwVar.a(iq.a(this.f46a, icVar));
        ay.a(this.f46a).a((ay) hwVar, hg.AckMessage, m396a);
    }

    private void a(String str, long j, f fVar) {
        bd a2 = m.a(fVar);
        if (a2 == null) {
            return;
        }
        if (j == 0) {
            synchronized (ao.class) {
                if (ao.a(this.f46a).m58a(str)) {
                    ao.a(this.f46a).c(str);
                    if ("syncing".equals(ao.a(this.f46a).a(a2))) {
                        ao.a(this.f46a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(ao.a(this.f46a).a(a2))) {
            ao.a(this.f46a).c(str);
        } else {
            synchronized (ao.class) {
                if (ao.a(this.f46a).m58a(str)) {
                    if (ao.a(this.f46a).a(str) < 10) {
                        ao.a(this.f46a).b(str);
                        ay.a(this.f46a).a(str, a2, fVar);
                    } else {
                        ao.a(this.f46a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m59a(Context context, String str) {
        boolean z = false;
        synchronized (f44a) {
            d.m80a(context);
            SharedPreferences a2 = d.a(context);
            if (f45a == null) {
                String[] split = a2.getString("pref_msg_ids", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                f45a = new LinkedList();
                for (String str2 : split) {
                    f45a.add(str2);
                }
            }
            if (f45a.contains(str)) {
                z = true;
            } else {
                f45a.add(str);
                if (f45a.size() > 25) {
                    f45a.poll();
                }
                String a3 = com.xiaomi.push.ay.a(f45a, Constants.ACCEPT_TIME_SEPARATOR_SP);
                SharedPreferences.Editor edit = a2.edit();
                edit.putString("pref_msg_ids", a3);
                com.xiaomi.push.r.a(edit);
            }
        }
        return z;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m60a(ic icVar) {
        if (TextUtils.equals(Constants.HYBRID_PACKAGE_NAME, icVar.b()) || TextUtils.equals(Constants.HYBRID_DEBUG_PACKAGE_NAME, icVar.b())) {
            Map<String, String> m362a = icVar.m396a() == null ? null : icVar.m396a().m362a();
            if (m362a == null) {
                return false;
            }
            String str = m362a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
            return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
        }
        return false;
    }

    private void b(hx hxVar) {
        com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + hxVar.toString());
        String a2 = hxVar.a();
        Map<String, String> m376a = hxVar.m376a();
        if (m376a != null) {
            String str = m376a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (str.contains("brand:" + ap.FCM.name())) {
                com.xiaomi.channel.commonutils.logger.b.m42a("ASSEMBLE_PUSH : receive fcm token sync ack");
                j.b(this.f46a, f.ASSEMBLE_PUSH_FCM, str);
                a(a2, hxVar.f571a, f.ASSEMBLE_PUSH_FCM);
            } else if (str.contains("brand:" + ap.HUAWEI.name())) {
                com.xiaomi.channel.commonutils.logger.b.m42a("ASSEMBLE_PUSH : receive hw token sync ack");
                j.b(this.f46a, f.ASSEMBLE_PUSH_HUAWEI, str);
                a(a2, hxVar.f571a, f.ASSEMBLE_PUSH_HUAWEI);
            } else if (str.contains("brand:" + ap.OPPO.name())) {
                com.xiaomi.channel.commonutils.logger.b.m42a("ASSEMBLE_PUSH : receive COS token sync ack");
                j.b(this.f46a, f.ASSEMBLE_PUSH_COS, str);
                a(a2, hxVar.f571a, f.ASSEMBLE_PUSH_COS);
            } else if (str.contains("brand:" + ap.VIVO.name())) {
                com.xiaomi.channel.commonutils.logger.b.m42a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                j.b(this.f46a, f.ASSEMBLE_PUSH_FTOS, str);
                a(a2, hxVar.f571a, f.ASSEMBLE_PUSH_FTOS);
            }
        }
    }

    private void b(ic icVar) {
        ht m396a = icVar.m396a();
        hw hwVar = new hw();
        hwVar.b(icVar.m397a());
        hwVar.a(m396a.m361a());
        hwVar.a(m396a.m359a());
        if (!TextUtils.isEmpty(m396a.m366b())) {
            hwVar.c(m396a.m366b());
        }
        hwVar.a(iq.a(this.f46a, icVar));
        ay.a(this.f46a).a((ay) hwVar, hg.AckMessage, false, icVar.m396a());
    }

    public PushMessageHandler.a a(Intent intent) {
        String action = intent.getAction();
        com.xiaomi.channel.commonutils.logger.b.m42a("receive an intent from server, action=" + action);
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
                ev.a(this.f46a).a(this.f46a.getPackageName(), intent, "receiving an empty message, drop");
                return null;
            }
            ic icVar = new ic();
            try {
                iq.a(icVar, byteArrayExtra);
                d m80a = d.m80a(this.f46a);
                ht m396a = icVar.m396a();
                if (icVar.a() == hg.SendMessage && m396a != null && !m80a.m90d() && !booleanExtra) {
                    m396a.a("mrt", stringExtra);
                    m396a.a("mat", Long.toString(System.currentTimeMillis()));
                    if (m60a(icVar)) {
                        com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                        m396a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m396a.m359a()));
                        m396a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) iq.a(this.f46a, icVar)));
                    } else {
                        b(icVar);
                    }
                }
                if (icVar.a() == hg.SendMessage && !icVar.m404b()) {
                    if (!com.xiaomi.push.service.z.m550a(icVar)) {
                        Object[] objArr = new Object[2];
                        objArr[0] = icVar.b();
                        objArr[1] = m396a != null ? m396a.m361a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m42a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr));
                        ev a2 = ev.a(this.f46a);
                        String packageName = this.f46a.getPackageName();
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = icVar.b();
                        objArr2[1] = m396a != null ? m396a.m361a() : "";
                        a2.a(packageName, intent, String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                        return null;
                    } else if (!booleanExtra || m396a.m362a() == null || !m396a.m362a().containsKey("notify_effect")) {
                        com.xiaomi.channel.commonutils.logger.b.m42a(String.format("drop an un-encrypted messages. %1$s, %2$s", icVar.b(), m396a.m361a()));
                        ev a3 = ev.a(this.f46a);
                        String packageName2 = this.f46a.getPackageName();
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = icVar.b();
                        objArr3[1] = m396a != null ? m396a.m361a() : "";
                        a3.a(packageName2, intent, String.format("drop an un-encrypted messages. %1$s, %2$s", objArr3));
                        return null;
                    }
                }
                if (m80a.m89c() || icVar.f614a == hg.Registration) {
                    if (!m80a.m89c() || !m80a.m91e()) {
                        return a(icVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                    }
                    if (icVar.f614a == hg.UnRegistration) {
                        m80a.m82a();
                        MiPushClient.clearExtras(this.f46a);
                        PushMessageHandler.a();
                    } else {
                        MiPushClient.unregisterPush(this.f46a);
                    }
                } else if (com.xiaomi.push.service.z.m550a(icVar)) {
                    return a(icVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!");
                    ev.a(this.f46a).a(this.f46a.getPackageName(), intent, "receive message without registration. need re-register!");
                    a();
                }
            } catch (iw e) {
                ev.a(this.f46a).a(this.f46a.getPackageName(), intent, e);
                com.xiaomi.channel.commonutils.logger.b.a(e);
            } catch (Exception e2) {
                ev.a(this.f46a).a(this.f46a.getPackageName(), intent, e2);
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
                d m80a2 = d.m80a(this.f46a);
                if (com.xiaomi.push.service.z.m550a(icVar3)) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive ignore reg message, ignore!");
                } else if (!m80a2.m89c()) {
                    com.xiaomi.channel.commonutils.logger.b.d("message arrived: receive message without registration. need unregister or re-register!");
                } else if (!m80a2.m89c() || !m80a2.m91e()) {
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
