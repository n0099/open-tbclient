package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.player.widget.BdPlayerProgressView;
import com.baidu.tbadk.core.atomData.ForumSquareActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.bm;
import com.xiaomi.push.bu;
import com.xiaomi.push.cy;
import com.xiaomi.push.ek;
import com.xiaomi.push.el;
import com.xiaomi.push.ev;
import com.xiaomi.push.hf;
import com.xiaomi.push.hk;
import com.xiaomi.push.hp;
import com.xiaomi.push.hr;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hv;
import com.xiaomi.push.hw;
import com.xiaomi.push.ia;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ie;
import com.xiaomi.push.ig;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.ip;
import com.xiaomi.push.iq;
import com.xiaomi.push.iv;
import com.xiaomi.push.service.az;
import com.yy.hiidostatis.inner.FlushManager;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UVEventType;
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
/* loaded from: classes8.dex */
public class al {
    public static /* synthetic */ Interceptable $ic;
    public static al a;

    /* renamed from: a  reason: collision with other field name */
    public static Object f68a;

    /* renamed from: a  reason: collision with other field name */
    public static Queue<String> f69a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f70a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871206724, "Lcom/xiaomi/mipush/sdk/al;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871206724, "Lcom/xiaomi/mipush/sdk/al;");
                return;
            }
        }
        f68a = new Object();
    }

    public al(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Context applicationContext = context.getApplicationContext();
        this.f70a = applicationContext;
        if (applicationContext == null) {
            this.f70a = context;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent a(Context context, String str, Map<String, String> map, int i2) {
        InterceptResult invokeLLLI;
        Intent launchIntentForPackage;
        String str2;
        Intent intent;
        StringBuilder sb;
        String message;
        String protocol;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65538, null, context, str, map, i2)) == null) {
            if (map == null) {
                return null;
            }
            if (i2 != 0) {
                return com.xiaomi.push.service.ac.a(context, str, map, i2);
            }
            if (map.containsKey("notify_effect")) {
                String str3 = map.get("notify_effect");
                int i3 = -1;
                String str4 = map.get("intent_flag");
                try {
                    if (!TextUtils.isEmpty(str4)) {
                        i3 = Integer.parseInt(str4);
                    }
                } catch (NumberFormatException e2) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause by intent_flag: " + e2.getMessage());
                }
                if (az.a.equals(str3)) {
                    try {
                        launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                    } catch (Exception e3) {
                        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e3.getMessage());
                    }
                } else if (az.f59993b.equals(str3)) {
                    if (map.containsKey("intent_uri")) {
                        String str5 = map.get("intent_uri");
                        if (str5 != null) {
                            try {
                                intent = Intent.parseUri(str5, 1);
                            } catch (URISyntaxException e4) {
                                e = e4;
                                intent = null;
                            }
                            try {
                                intent.setPackage(str);
                            } catch (URISyntaxException e5) {
                                e = e5;
                                sb = new StringBuilder();
                                sb.append("Cause: ");
                                message = e.getMessage();
                                sb.append(message);
                                com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                                launchIntentForPackage = intent;
                                if (launchIntentForPackage != null) {
                                }
                                return null;
                            }
                            launchIntentForPackage = intent;
                        }
                    } else if (map.containsKey(ForumSquareActivityConfig.FORUM_CLASS_NAME)) {
                        Intent intent2 = new Intent();
                        intent2.setComponent(new ComponentName(str, map.get(ForumSquareActivityConfig.FORUM_CLASS_NAME)));
                        launchIntentForPackage = intent2;
                    }
                    launchIntentForPackage = null;
                } else {
                    if (az.f59994c.equals(str3) && (str2 = map.get("web_uri")) != null) {
                        String trim = str2.trim();
                        if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                            trim = "http://" + trim;
                        }
                        try {
                            protocol = new URL(trim).getProtocol();
                        } catch (MalformedURLException e6) {
                            e = e6;
                            intent = null;
                        }
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            intent = new Intent("android.intent.action.VIEW");
                            try {
                                intent.setData(Uri.parse(trim));
                            } catch (MalformedURLException e7) {
                                e = e7;
                                sb = new StringBuilder();
                                sb.append("Cause: ");
                                message = e.getMessage();
                                sb.append(message);
                                com.xiaomi.channel.commonutils.logger.b.d(sb.toString());
                                launchIntentForPackage = intent;
                                if (launchIntentForPackage != null) {
                                }
                                return null;
                            }
                            launchIntentForPackage = intent;
                        }
                    }
                    launchIntentForPackage = null;
                }
                if (launchIntentForPackage != null) {
                    if (i3 >= 0) {
                        launchIntentForPackage.setFlags(i3);
                    }
                    launchIntentForPackage.addFlags(268435456);
                    try {
                        if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                            return launchIntentForPackage;
                        }
                        com.xiaomi.channel.commonutils.logger.b.m133a("not resolve activity:" + launchIntentForPackage);
                    } catch (Exception e8) {
                        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e8.getMessage());
                    }
                }
                return null;
            }
            return null;
        }
        return (Intent) invokeLLLI.objValue;
    }

    private PushMessageHandler.a a(ib ibVar, boolean z, byte[] bArr, String str, int i2, Intent intent) {
        InterceptResult invokeCommon;
        el a2;
        String packageName;
        String m349a;
        int i3;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{ibVar, Boolean.valueOf(z), bArr, str, Integer.valueOf(i2), intent})) == null) {
            MiPushMessage miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            miPushMessage = null;
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            miPushMessage = null;
            ArrayList arrayList3 = null;
            miPushMessage = null;
            try {
                iq a3 = ah.a(this.f70a, ibVar);
                if (a3 == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + ibVar.f636a);
                    el.a(this.f70a).b(this.f70a.getPackageName(), ek.m349a(i2), str, "18");
                    return null;
                }
                hf a4 = ibVar.a();
                com.xiaomi.channel.commonutils.logger.b.m133a("processing a message, action=" + a4);
                switch (am.a[a4.ordinal()]) {
                    case 1:
                        if (!ibVar.m521b()) {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                            return null;
                        } else if (b.m174a(this.f70a).m185e() && !z) {
                            com.xiaomi.channel.commonutils.logger.b.m133a("receive a message in pause state. drop it");
                            el.a(this.f70a).a(this.f70a.getPackageName(), ek.m349a(i2), str, "12");
                            return null;
                        } else {
                            ii iiVar = (ii) a3;
                            hr a5 = iiVar.a();
                            if (a5 == null) {
                                com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                                el.a(this.f70a).b(this.f70a.getPackageName(), ek.m349a(i2), str, "22");
                                return null;
                            }
                            if (z) {
                                if (com.xiaomi.push.service.ac.m638a(ibVar)) {
                                    MiPushClient.reportIgnoreRegMessageClicked(this.f70a, a5.m462a(), ibVar.m513a(), ibVar.f643b, a5.b());
                                } else {
                                    MiPushClient.reportMessageClicked(this.f70a, a5.m462a(), ibVar.m513a(), a5.b());
                                }
                            }
                            if (!z) {
                                if (!TextUtils.isEmpty(iiVar.d()) && MiPushClient.aliasSetTime(this.f70a, iiVar.d()) < 0) {
                                    MiPushClient.addAlias(this.f70a, iiVar.d());
                                } else if (!TextUtils.isEmpty(iiVar.c()) && MiPushClient.topicSubscribedTime(this.f70a, iiVar.c()) < 0) {
                                    MiPushClient.addTopic(this.f70a, iiVar.c());
                                }
                            }
                            hs hsVar = ibVar.f637a;
                            String str3 = (hsVar == null || hsVar.m471a() == null) ? null : ibVar.f637a.f549a.get("jobkey");
                            String str4 = str3;
                            if (TextUtils.isEmpty(str3)) {
                                str3 = a5.m462a();
                            }
                            if (z || !m155a(this.f70a, str3)) {
                                MiPushMessage generateMessage = PushMessageHelper.generateMessage(iiVar, ibVar.m513a(), z);
                                if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.ac.m639a(generateMessage.getExtra())) {
                                    com.xiaomi.push.service.ac.m633a(this.f70a, ibVar, bArr);
                                    return null;
                                }
                                com.xiaomi.channel.commonutils.logger.b.m133a("receive a message, msgid=" + a5.m462a() + ", jobkey=" + str3);
                                if (z && generateMessage.getExtra() != null && generateMessage.getExtra().containsKey("notify_effect")) {
                                    Map<String, String> extra = generateMessage.getExtra();
                                    String str5 = extra.get("notify_effect");
                                    int intExtra = intent.getIntExtra("notification_click_button", 0);
                                    com.xiaomi.channel.commonutils.logger.b.m133a("click style button is " + intExtra);
                                    if (intExtra != 0 && ibVar.m513a() != null) {
                                        MiPushClient.clearNotification(this.f70a, ibVar.m513a().c());
                                    }
                                    if (com.xiaomi.push.service.ac.m638a(ibVar)) {
                                        Intent a6 = a(this.f70a, ibVar.f643b, extra, intExtra);
                                        a6.putExtra("eventMessageType", i2);
                                        a6.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                        a6.putExtra("jobkey", str4);
                                        if (a6 == null) {
                                            com.xiaomi.channel.commonutils.logger.b.m133a("Getting Intent fail from ignore reg message. ");
                                            el.a(this.f70a).b(this.f70a.getPackageName(), ek.m349a(i2), str, "23");
                                            return null;
                                        }
                                        String c2 = a5.c();
                                        if (!TextUtils.isEmpty(c2)) {
                                            a6.putExtra("payload", c2);
                                        }
                                        this.f70a.startActivity(a6);
                                        el.a(this.f70a).a(this.f70a.getPackageName(), ek.m349a(i2), str, 3006, str5);
                                    } else {
                                        Context context = this.f70a;
                                        Intent a7 = a(context, context.getPackageName(), extra, intExtra);
                                        if (a7 != null) {
                                            if (!str5.equals(az.f59994c)) {
                                                a7.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                                a7.putExtra("eventMessageType", i2);
                                                a7.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                                a7.putExtra("jobkey", str4);
                                            }
                                            this.f70a.startActivity(a7);
                                            com.xiaomi.channel.commonutils.logger.b.m133a("start activity succ");
                                            el.a(this.f70a).a(this.f70a.getPackageName(), ek.m349a(i2), str, 1006, str5);
                                            if (str5.equals(az.f59994c)) {
                                                el.a(this.f70a).a(this.f70a.getPackageName(), ek.m349a(i2), str, "13");
                                            }
                                        }
                                    }
                                    return null;
                                }
                                miPushMessage = generateMessage;
                            } else {
                                com.xiaomi.channel.commonutils.logger.b.m133a("drop a duplicate message, key=" + str3);
                                el a8 = el.a(this.f70a);
                                String packageName2 = this.f70a.getPackageName();
                                String m349a2 = ek.m349a(i2);
                                a8.c(packageName2, m349a2, str, "2:" + str3);
                            }
                            if (ibVar.m513a() == null && !z) {
                                a(iiVar, ibVar);
                                break;
                            }
                        }
                        break;
                    case 2:
                        ig igVar = (ig) a3;
                        String str6 = b.m174a(this.f70a).f86a;
                        if (TextUtils.isEmpty(str6) || !TextUtils.equals(str6, igVar.m542a())) {
                            com.xiaomi.channel.commonutils.logger.b.m133a("bad Registration result:");
                            el.a(this.f70a).b(this.f70a.getPackageName(), ek.m349a(i2), str, "21");
                            return null;
                        }
                        b.m174a(this.f70a).f86a = null;
                        int i4 = (igVar.f699a > 0L ? 1 : (igVar.f699a == 0L ? 0 : -1));
                        Context context2 = this.f70a;
                        if (i4 == 0) {
                            b.m174a(context2).b(igVar.f709e, igVar.f710f, igVar.f716l);
                            a2 = el.a(this.f70a);
                            packageName = this.f70a.getPackageName();
                            m349a = ek.m349a(i2);
                            i3 = w0.j3;
                            str2 = "1";
                        } else {
                            a2 = el.a(context2);
                            packageName = this.f70a.getPackageName();
                            m349a = ek.m349a(i2);
                            i3 = w0.j3;
                            str2 = "2";
                        }
                        a2.a(packageName, m349a, str, i3, str2);
                        if (!TextUtils.isEmpty(igVar.f709e)) {
                            arrayList3 = new ArrayList();
                            arrayList3.add(igVar.f709e);
                        }
                        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ev.a.f345a, arrayList3, igVar.f699a, igVar.f708d, null);
                        an.a(this.f70a).m172d();
                        return generateCommandMessage;
                    case 3:
                        if (((im) a3).f775a == 0) {
                            b.m174a(this.f70a).m176a();
                            MiPushClient.clearExtras(this.f70a);
                        }
                        PushMessageHandler.a();
                        break;
                    case 4:
                        ik ikVar = (ik) a3;
                        if (ikVar.f750a == 0) {
                            MiPushClient.addTopic(this.f70a, ikVar.b());
                        }
                        if (!TextUtils.isEmpty(ikVar.b())) {
                            arrayList2 = new ArrayList();
                            arrayList2.add(ikVar.b());
                        }
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ev.f59608g + StringUtil.ARRAY_ELEMENT_SEPARATOR + ikVar.a());
                        return PushMessageHelper.generateCommandMessage(ev.f59608g.f345a, arrayList2, ikVar.f750a, ikVar.f756d, ikVar.c());
                    case 5:
                        io ioVar = (io) a3;
                        if (ioVar.f795a == 0) {
                            MiPushClient.removeTopic(this.f70a, ioVar.b());
                        }
                        if (!TextUtils.isEmpty(ioVar.b())) {
                            arrayList = new ArrayList();
                            arrayList.add(ioVar.b());
                        }
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ev.f59609h + StringUtil.ARRAY_ELEMENT_SEPARATOR + ioVar.a());
                        return PushMessageHelper.generateCommandMessage(ev.f59609h.f345a, arrayList, ioVar.f795a, ioVar.f801d, ioVar.c());
                    case 6:
                        cy.a(this.f70a.getPackageName(), this.f70a, a3, hf.f59729j, bArr.length);
                        ia iaVar = (ia) a3;
                        String b2 = iaVar.b();
                        List<String> m507a = iaVar.m507a();
                        if (iaVar.f624a == 0) {
                            if (TextUtils.equals(b2, ev.f59610i.f345a) && m507a != null && m507a.size() > 1) {
                                MiPushClient.addAcceptTime(this.f70a, m507a.get(0), m507a.get(1));
                                if (BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(m507a.get(0)) && BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(m507a.get(1))) {
                                    b.m174a(this.f70a).a(true);
                                } else {
                                    b.m174a(this.f70a).a(false);
                                }
                                m507a = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m507a);
                            } else if (TextUtils.equals(b2, ev.f59604c.f345a) && m507a != null && m507a.size() > 0) {
                                MiPushClient.addAlias(this.f70a, m507a.get(0));
                            } else if (TextUtils.equals(b2, ev.f59605d.f345a) && m507a != null && m507a.size() > 0) {
                                MiPushClient.removeAlias(this.f70a, m507a.get(0));
                            } else if (TextUtils.equals(b2, ev.f59606e.f345a) && m507a != null && m507a.size() > 0) {
                                MiPushClient.addAccount(this.f70a, m507a.get(0));
                            } else if (TextUtils.equals(b2, ev.f59607f.f345a) && m507a != null && m507a.size() > 0) {
                                MiPushClient.removeAccount(this.f70a, m507a.get(0));
                            } else if (TextUtils.equals(b2, ev.f59611j.f345a)) {
                                if (m507a != null && m507a.size() > 0) {
                                    com.xiaomi.push.i.a(this.f70a, m507a.get(0));
                                }
                                return null;
                            }
                        }
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + iaVar.a());
                        return PushMessageHelper.generateCommandMessage(b2, m507a, iaVar.f624a, iaVar.f632d, iaVar.c());
                    case 7:
                        cy.a(this.f70a.getPackageName(), this.f70a, a3, hf.f59728i, bArr.length);
                        if (a3 instanceof hw) {
                            hw hwVar = (hw) a3;
                            String a9 = hwVar.a();
                            com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + hwVar.b() + ", code:" + hwVar.f592a + StringUtil.ARRAY_ELEMENT_SEPARATOR + a9);
                            if (hp.E.f514a.equalsIgnoreCase(hwVar.f599d)) {
                                if (hwVar.f592a == 0) {
                                    synchronized (ae.class) {
                                        if (ae.a(this.f70a).m154a(a9)) {
                                            ae.a(this.f70a).c(a9);
                                            if ("syncing".equals(ae.a(this.f70a).a(at.a))) {
                                                ae.a(this.f70a).a(at.a, "synced");
                                                MiPushClient.clearNotification(this.f70a);
                                                MiPushClient.clearLocalNotificationType(this.f70a);
                                                PushMessageHandler.a();
                                                an.a(this.f70a).m169b();
                                            }
                                        }
                                    }
                                    break;
                                } else if ("syncing".equals(ae.a(this.f70a).a(at.a))) {
                                    synchronized (ae.class) {
                                        if (ae.a(this.f70a).m154a(a9)) {
                                            if (ae.a(this.f70a).a(a9) < 10) {
                                                ae.a(this.f70a).b(a9);
                                                an.a(this.f70a).a(true, a9);
                                            } else {
                                                ae.a(this.f70a).c(a9);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else if (hp.F.f514a.equalsIgnoreCase(hwVar.f599d)) {
                                if (hwVar.f592a == 0) {
                                    synchronized (ae.class) {
                                        if (ae.a(this.f70a).m154a(a9)) {
                                            ae.a(this.f70a).c(a9);
                                            if ("syncing".equals(ae.a(this.f70a).a(at.f59448b))) {
                                                ae.a(this.f70a).a(at.f59448b, "synced");
                                            }
                                        }
                                    }
                                    break;
                                } else if ("syncing".equals(ae.a(this.f70a).a(at.f59448b))) {
                                    synchronized (ae.class) {
                                        if (ae.a(this.f70a).m154a(a9)) {
                                            if (ae.a(this.f70a).a(a9) < 10) {
                                                ae.a(this.f70a).b(a9);
                                                an.a(this.f70a).a(false, a9);
                                            } else {
                                                ae.a(this.f70a).c(a9);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else if (hp.N.f514a.equalsIgnoreCase(hwVar.f599d)) {
                                b(hwVar);
                                break;
                            } else if (hp.B.f514a.equalsIgnoreCase(hwVar.f599d)) {
                                a(hwVar);
                                break;
                            }
                            ae.a(this.f70a).c(a9);
                            break;
                        } else if (a3 instanceof ie) {
                            ie ieVar = (ie) a3;
                            if ("registration id expired".equalsIgnoreCase(ieVar.f660d)) {
                                List<String> allAlias = MiPushClient.getAllAlias(this.f70a);
                                List<String> allTopic = MiPushClient.getAllTopic(this.f70a);
                                List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f70a);
                                String acceptTime = MiPushClient.getAcceptTime(this.f70a);
                                com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + ieVar.f660d + StringUtil.ARRAY_ELEMENT_SEPARATOR + ieVar.m528a());
                                MiPushClient.reInitialize(this.f70a, ht.a);
                                for (String str7 : allAlias) {
                                    MiPushClient.removeAlias(this.f70a, str7);
                                    MiPushClient.setAlias(this.f70a, str7, null);
                                }
                                for (String str8 : allTopic) {
                                    MiPushClient.removeTopic(this.f70a, str8);
                                    MiPushClient.subscribe(this.f70a, str8, null);
                                }
                                for (String str9 : allUserAccount) {
                                    MiPushClient.removeAccount(this.f70a, str9);
                                    MiPushClient.setUserAccount(this.f70a, str9, null);
                                }
                                String[] split = acceptTime.split(",");
                                if (split.length == 2) {
                                    MiPushClient.removeAcceptTime(this.f70a);
                                    MiPushClient.addAcceptTime(this.f70a, split[0], split[1]);
                                    break;
                                }
                            } else if (hp.f59772h.f514a.equalsIgnoreCase(ieVar.f660d)) {
                                if (ieVar.m529a() != null && ieVar.m529a().containsKey("app_version")) {
                                    b.m174a(this.f70a).m177a(ieVar.m529a().get("app_version"));
                                    break;
                                }
                            } else if (hp.m.f514a.equalsIgnoreCase(ieVar.f660d)) {
                                if (ibVar.m521b() && ieVar.m529a() != null && ieVar.m529a().containsKey("awake_info")) {
                                    Context context3 = this.f70a;
                                    o.a(context3, b.m174a(context3).m175a(), com.xiaomi.push.service.aq.a(this.f70a).a(hk.aF.a(), 0), ieVar.m529a().get("awake_info"));
                                    break;
                                }
                            } else {
                                try {
                                    if (hp.n.f514a.equalsIgnoreCase(ieVar.f660d)) {
                                        id idVar = new id();
                                        ip.a(idVar, ieVar.m534a());
                                        com.xiaomi.push.service.ar.a(com.xiaomi.push.service.aq.a(this.f70a), idVar);
                                    } else if (hp.o.f514a.equalsIgnoreCase(ieVar.f660d)) {
                                        ic icVar = new ic();
                                        ip.a(icVar, ieVar.m534a());
                                        com.xiaomi.push.service.ar.a(com.xiaomi.push.service.aq.a(this.f70a), icVar);
                                    } else if (hp.w.f514a.equalsIgnoreCase(ieVar.f660d)) {
                                        au.a(this.f70a, ieVar);
                                        break;
                                    } else if (hp.x.f514a.equalsIgnoreCase(ieVar.f660d)) {
                                        com.xiaomi.channel.commonutils.logger.b.m133a("receive force sync notification");
                                        au.a(this.f70a, false);
                                        break;
                                    } else if (hp.C.f514a.equals(ieVar.f660d)) {
                                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + ieVar.f660d + StringUtil.ARRAY_ELEMENT_SEPARATOR + ieVar.m528a());
                                        if (ieVar.m529a() != null) {
                                            int i5 = -2;
                                            if (ieVar.m529a().containsKey(az.K)) {
                                                String str10 = ieVar.m529a().get(az.K);
                                                if (!TextUtils.isEmpty(str10)) {
                                                    try {
                                                        i5 = Integer.parseInt(str10);
                                                    } catch (NumberFormatException e2) {
                                                        e2.printStackTrace();
                                                    }
                                                }
                                            }
                                            if (i5 >= -1) {
                                                MiPushClient.clearNotification(this.f70a, i5);
                                            } else {
                                                MiPushClient.clearNotification(this.f70a, ieVar.m529a().containsKey(az.I) ? ieVar.m529a().get(az.I) : "", ieVar.m529a().containsKey(az.J) ? ieVar.m529a().get(az.J) : "");
                                            }
                                        }
                                        a(ieVar);
                                        break;
                                    } else {
                                        try {
                                            if (hp.K.f514a.equals(ieVar.f660d)) {
                                                ig igVar2 = new ig();
                                                ip.a(igVar2, ieVar.m534a());
                                                MiPushClient4Hybrid.onReceiveRegisterResult(this.f70a, igVar2);
                                            } else if (hp.M.f514a.equals(ieVar.f660d)) {
                                                im imVar = new im();
                                                ip.a(imVar, ieVar.m534a());
                                                MiPushClient4Hybrid.onReceiveUnregisterResult(this.f70a, imVar);
                                            } else if (!hp.P.f514a.equals(ieVar.f660d) && com.xiaomi.push.service.d.a(ieVar)) {
                                                com.xiaomi.channel.commonutils.logger.b.b("receive notification handle by cpra");
                                                break;
                                            }
                                            break;
                                        } catch (iv e3) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e3);
                                            break;
                                        }
                                    }
                                    break;
                                } catch (iv unused) {
                                    break;
                                }
                            }
                        }
                        break;
                }
                return miPushMessage;
            } catch (t e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
                a(ibVar);
                el.a(this.f70a).b(this.f70a.getPackageName(), ek.m349a(i2), str, "19");
                return null;
            } catch (iv e5) {
                com.xiaomi.channel.commonutils.logger.b.a(e5);
                com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
                el.a(this.f70a).b(this.f70a.getPackageName(), ek.m349a(i2), str, UVEventType.PAY_WALLET_BANNER_SHOW);
                return null;
            }
        }
        return (PushMessageHandler.a) invokeCommon.objValue;
    }

    private PushMessageHandler.a a(ib ibVar, byte[] bArr) {
        InterceptResult invokeLL;
        String str;
        iq a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, ibVar, bArr)) == null) {
            String str2 = null;
            try {
                a2 = ah.a(this.f70a, ibVar);
            } catch (t e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                str = "message arrived: receive a message but decrypt failed. report when click.";
            } catch (iv e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                str = "message arrived: receive a message which action string is not valid. is the reg expired?";
            }
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + ibVar.f636a);
                return null;
            }
            hf a3 = ibVar.a();
            com.xiaomi.channel.commonutils.logger.b.m133a("message arrived: processing an arrived message, action=" + a3);
            if (am.a[a3.ordinal()] != 1) {
                return null;
            }
            if (ibVar.m521b()) {
                ii iiVar = (ii) a2;
                hr a4 = iiVar.a();
                if (a4 != null) {
                    hs hsVar = ibVar.f637a;
                    if (hsVar != null && hsVar.m471a() != null) {
                        str2 = ibVar.f637a.f549a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(iiVar, ibVar.m513a(), false);
                    generateMessage.setArrivedMessage(true);
                    com.xiaomi.channel.commonutils.logger.b.m133a("message arrived: receive a message, msgid=" + a4.m462a() + ", jobkey=" + str2);
                    return generateMessage;
                }
                str = "message arrived: receive an empty message without push content, drop it";
            } else {
                str = "message arrived: receiving an un-encrypt message(SendMessage).";
            }
            com.xiaomi.channel.commonutils.logger.b.d(str);
            return null;
        }
        return (PushMessageHandler.a) invokeLL.objValue;
    }

    public static al a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (a == null) {
                a = new al(context);
            }
            return a;
        }
        return (al) invokeL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            SharedPreferences sharedPreferences = this.f70a.getSharedPreferences("mipush_extra", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > FlushManager.ReportTimer.DEFAULT_INTERVAL) {
                MiPushClient.reInitialize(this.f70a, ht.f59799b);
                sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
            }
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            synchronized (f68a) {
                f69a.remove(str);
                b.m174a(context);
                SharedPreferences a2 = b.a(context);
                String a3 = bm.a(f69a, ",");
                SharedPreferences.Editor edit = a2.edit();
                edit.putString("pref_msg_ids", a3);
                com.xiaomi.push.r.a(edit);
            }
        }
    }

    private void a(hw hwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, hwVar) == null) {
            String a2 = hwVar.a();
            com.xiaomi.channel.commonutils.logger.b.b("receive ack " + a2);
            Map<String, String> m485a = hwVar.m485a();
            if (m485a != null) {
                String str = m485a.get("real_source");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
                bu.a(this.f70a).a(a2, str, Boolean.valueOf(hwVar.f592a == 0));
            }
        }
    }

    private void a(ib ibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, ibVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.m133a("receive a message but decrypt failed. report now.");
            ie ieVar = new ie(ibVar.m513a().f547a, false);
            ieVar.c(hp.u.f514a);
            ieVar.b(ibVar.m514a());
            ieVar.d(ibVar.f643b);
            HashMap hashMap = new HashMap();
            ieVar.f655a = hashMap;
            hashMap.put("regid", MiPushClient.getRegId(this.f70a));
            an.a(this.f70a).a((an) ieVar, hf.f59728i, false, (hs) null);
        }
    }

    private void a(ie ieVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, ieVar) == null) {
            hw hwVar = new hw();
            hwVar.c(hp.D.f514a);
            hwVar.a(ieVar.m528a());
            hwVar.a(ieVar.a());
            hwVar.b(ieVar.b());
            hwVar.e(ieVar.c());
            hwVar.a(0L);
            hwVar.d("success clear push message.");
            an.a(this.f70a).a(hwVar, hf.f59728i, false, true, null, false, this.f70a.getPackageName(), b.m174a(this.f70a).m175a(), false);
        }
    }

    private void a(ii iiVar, ib ibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, iiVar, ibVar) == null) {
            hs m513a = ibVar.m513a();
            hv hvVar = new hv();
            hvVar.b(iiVar.b());
            hvVar.a(iiVar.m549a());
            hvVar.a(iiVar.a().a());
            if (!TextUtils.isEmpty(iiVar.c())) {
                hvVar.c(iiVar.c());
            }
            if (!TextUtils.isEmpty(iiVar.d())) {
                hvVar.d(iiVar.d());
            }
            hvVar.a(ip.a(this.f70a, ibVar));
            an.a(this.f70a).a((an) hvVar, hf.f59725f, m513a);
        }
    }

    private void a(String str, long j2, e eVar) {
        at a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{str, Long.valueOf(j2), eVar}) == null) || (a2 = l.a(eVar)) == null) {
            return;
        }
        if (j2 == 0) {
            synchronized (ae.class) {
                if (ae.a(this.f70a).m154a(str)) {
                    ae.a(this.f70a).c(str);
                    if ("syncing".equals(ae.a(this.f70a).a(a2))) {
                        ae.a(this.f70a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(ae.a(this.f70a).a(a2))) {
            ae.a(this.f70a).c(str);
        } else {
            synchronized (ae.class) {
                if (ae.a(this.f70a).m154a(str)) {
                    if (ae.a(this.f70a).a(str) < 10) {
                        ae.a(this.f70a).b(str);
                        an.a(this.f70a).a(str, a2, eVar);
                    } else {
                        ae.a(this.f70a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m155a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            synchronized (f68a) {
                b.m174a(context);
                SharedPreferences a2 = b.a(context);
                if (f69a == null) {
                    String[] split = a2.getString("pref_msg_ids", "").split(",");
                    f69a = new LinkedList();
                    for (String str2 : split) {
                        f69a.add(str2);
                    }
                }
                if (f69a.contains(str)) {
                    return true;
                }
                f69a.add(str);
                if (f69a.size() > 25) {
                    f69a.poll();
                }
                String a3 = bm.a(f69a, ",");
                SharedPreferences.Editor edit = a2.edit();
                edit.putString("pref_msg_ids", a3);
                com.xiaomi.push.r.a(edit);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m156a(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, ibVar)) == null) {
            Map<String, String> m471a = ibVar.m513a() == null ? null : ibVar.m513a().m471a();
            if (m471a == null) {
                return false;
            }
            String str = m471a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
            return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
        }
        return invokeL.booleanValue;
    }

    private void b(hw hwVar) {
        long j2;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, hwVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + hwVar.toString());
            String a2 = hwVar.a();
            Map<String, String> m485a = hwVar.m485a();
            if (m485a != null) {
                String str = m485a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.contains("brand:" + af.f59442c.name())) {
                    com.xiaomi.channel.commonutils.logger.b.m133a("ASSEMBLE_PUSH : receive fcm token sync ack");
                    i.b(this.f70a, e.f59460b, str);
                    j2 = hwVar.f592a;
                    eVar = e.f59460b;
                } else {
                    if (str.contains("brand:" + af.a.name())) {
                        com.xiaomi.channel.commonutils.logger.b.m133a("ASSEMBLE_PUSH : receive hw token sync ack");
                        i.b(this.f70a, e.a, str);
                        j2 = hwVar.f592a;
                        eVar = e.a;
                    } else {
                        if (str.contains("brand:" + af.f59443d.name())) {
                            com.xiaomi.channel.commonutils.logger.b.m133a("ASSEMBLE_PUSH : receive COS token sync ack");
                            i.b(this.f70a, e.f59461c, str);
                            j2 = hwVar.f592a;
                            eVar = e.f59461c;
                        } else {
                            if (!str.contains("brand:" + af.f59444e.name())) {
                                return;
                            }
                            com.xiaomi.channel.commonutils.logger.b.m133a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                            i.b(this.f70a, e.f59462d, str);
                            j2 = hwVar.f592a;
                            eVar = e.f59462d;
                        }
                    }
                }
                a(a2, j2, eVar);
            }
        }
    }

    private void b(ib ibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, ibVar) == null) {
            hs m513a = ibVar.m513a();
            hv hvVar = new hv();
            hvVar.b(ibVar.m514a());
            hvVar.a(m513a.m470a());
            hvVar.a(m513a.m468a());
            if (!TextUtils.isEmpty(m513a.m475b())) {
                hvVar.c(m513a.m475b());
            }
            hvVar.a(ip.a(this.f70a, ibVar));
            an.a(this.f70a).a((an) hvVar, hf.f59725f, false, ibVar.m513a());
        }
    }

    public PushMessageHandler.a a(Intent intent) {
        InterceptResult invokeL;
        String str;
        el a2;
        String packageName;
        String str2;
        el a3;
        String packageName2;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            String action = intent.getAction();
            com.xiaomi.channel.commonutils.logger.b.m133a("receive an intent from server, action=" + action);
            String stringExtra = intent.getStringExtra("mrt");
            if (stringExtra == null) {
                stringExtra = Long.toString(System.currentTimeMillis());
            }
            String stringExtra2 = intent.getStringExtra(MiPushMessage.KEY_MESSAGE_ID);
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if ("com.xiaomi.mipush.RECEIVE_MESSAGE".equals(action)) {
                byte[] byteArrayExtra = intent.getByteArrayExtra("mipush_payload");
                boolean booleanExtra = intent.getBooleanExtra("mipush_notified", false);
                if (byteArrayExtra == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("receiving an empty message, drop");
                    el.a(this.f70a).a(this.f70a.getPackageName(), intent, "12");
                    return null;
                }
                ib ibVar = new ib();
                try {
                    ip.a(ibVar, byteArrayExtra);
                    b m174a = b.m174a(this.f70a);
                    hs m513a = ibVar.m513a();
                    if (ibVar.a() == hf.f59724e && m513a != null && !m174a.m185e() && !booleanExtra) {
                        m513a.a("mrt", stringExtra);
                        m513a.a("mat", Long.toString(System.currentTimeMillis()));
                        if (m156a(ibVar)) {
                            com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                            m513a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m513a.m468a()));
                            m513a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) ip.a(this.f70a, ibVar)));
                        } else {
                            b(ibVar);
                        }
                    }
                    if (ibVar.a() == hf.f59724e && !ibVar.m521b()) {
                        if (com.xiaomi.push.service.ac.m638a(ibVar)) {
                            Object[] objArr = new Object[2];
                            objArr[0] = ibVar.b();
                            objArr[1] = m513a != null ? m513a.m470a() : "";
                            com.xiaomi.channel.commonutils.logger.b.m133a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                            a3 = el.a(this.f70a);
                            packageName2 = this.f70a.getPackageName();
                            format = String.format("13: %1$s", ibVar.b());
                        } else {
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = ibVar.b();
                            objArr2[1] = m513a != null ? m513a.m470a() : "";
                            com.xiaomi.channel.commonutils.logger.b.m133a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                            a3 = el.a(this.f70a);
                            packageName2 = this.f70a.getPackageName();
                            format = String.format("14: %1$s", ibVar.b());
                        }
                        a3.a(packageName2, intent, format);
                        return null;
                    }
                    if (ibVar.a() == hf.f59724e && ibVar.m521b() && com.xiaomi.push.service.ac.m638a(ibVar) && (!booleanExtra || m513a == null || m513a.m471a() == null || !m513a.m471a().containsKey("notify_effect"))) {
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = ibVar.b();
                        objArr3[1] = m513a != null ? m513a.m470a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m133a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                        el.a(this.f70a).a(this.f70a.getPackageName(), intent, String.format("25: %1$s", ibVar.b()));
                        return null;
                    }
                    if (m174a.m183c() || ibVar.f636a == hf.a) {
                        if (!m174a.m183c() || !m174a.m186f()) {
                            return a(ibVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                        }
                        if (ibVar.f636a == hf.f59721b) {
                            m174a.m176a();
                            MiPushClient.clearExtras(this.f70a);
                            PushMessageHandler.a();
                        } else {
                            MiPushClient.unregisterPush(this.f70a);
                        }
                    } else if (com.xiaomi.push.service.ac.m638a(ibVar)) {
                        return a(ibVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    } else {
                        boolean m184d = m174a.m184d();
                        com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?" + m184d);
                        el.a(this.f70a).a(this.f70a.getPackageName(), intent, "15");
                        if (m184d) {
                            a();
                        }
                    }
                } catch (iv e2) {
                    e = e2;
                    a2 = el.a(this.f70a);
                    packageName = this.f70a.getPackageName();
                    str2 = "16";
                    a2.a(packageName, intent, str2);
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    return null;
                } catch (Exception e3) {
                    e = e3;
                    a2 = el.a(this.f70a);
                    packageName = this.f70a.getPackageName();
                    str2 = "17";
                    a2.a(packageName, intent, str2);
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    return null;
                }
            } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
                MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
                ib ibVar2 = new ib();
                try {
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                    if (byteArrayExtra2 != null) {
                        ip.a(ibVar2, byteArrayExtra2);
                    }
                } catch (iv unused) {
                }
                miPushCommandMessage.setCommand(String.valueOf(ibVar2.a()));
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
                ib ibVar3 = new ib();
                try {
                    ip.a(ibVar3, byteArrayExtra3);
                    b m174a2 = b.m174a(this.f70a);
                    if (com.xiaomi.push.service.ac.m638a(ibVar3)) {
                        str = "message arrived: receive ignore reg message, ignore!";
                    } else if (!m174a2.m183c()) {
                        str = "message arrived: receive message without registration. need unregister or re-register!";
                    } else if (!m174a2.m183c() || !m174a2.m186f()) {
                        return a(ibVar3, byteArrayExtra3);
                    } else {
                        str = "message arrived: app info is invalidated";
                    }
                    com.xiaomi.channel.commonutils.logger.b.d(str);
                } catch (Exception e4) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to deal with arrived message. " + e4);
                }
            }
            return null;
        }
        return (PushMessageHandler.a) invokeL.objValue;
    }

    public List<String> a(TimeZone timeZone, TimeZone timeZone2, List<String> list) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, timeZone, timeZone2, list)) == null) {
            if (timeZone.equals(timeZone2)) {
                return list;
            }
            long rawOffset = ((timeZone.getRawOffset() - timeZone2.getRawOffset()) / 1000) / 60;
            long parseLong = ((((Long.parseLong(list.get(0).split(":")[0]) * 60) + Long.parseLong(list.get(0).split(":")[1])) - rawOffset) + 1440) % 1440;
            long parseLong2 = ((((Long.parseLong(list.get(1).split(":")[0]) * 60) + Long.parseLong(list.get(1).split(":")[1])) - rawOffset) + 1440) % 1440;
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong / 60), Long.valueOf(parseLong % 60)));
            arrayList.add(String.format("%1$02d:%2$02d", Long.valueOf(parseLong2 / 60), Long.valueOf(parseLong2 % 60)));
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }
}
