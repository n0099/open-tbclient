package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
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
    public static Object f44a;

    /* renamed from: a  reason: collision with other field name */
    public static Queue<String> f45a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f46a;

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
        f44a = new Object();
    }

    public al(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Context applicationContext = context.getApplicationContext();
        this.f46a = applicationContext;
        if (applicationContext == null) {
            this.f46a = context;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        InterceptResult invokeLLLI;
        Intent launchIntentForPackage;
        String str2;
        Intent intent;
        StringBuilder sb;
        String message;
        String protocol;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65538, null, context, str, map, i)) == null) {
            if (map == null) {
                return null;
            }
            if (i != 0) {
                return com.xiaomi.push.service.ac.a(context, str, map, i);
            }
            if (map.containsKey("notify_effect")) {
                String str3 = map.get("notify_effect");
                int i2 = -1;
                String str4 = map.get("intent_flag");
                try {
                    if (!TextUtils.isEmpty(str4)) {
                        i2 = Integer.parseInt(str4);
                    }
                } catch (NumberFormatException e) {
                    com.xiaomi.channel.commonutils.logger.b.d("Cause by intent_flag: " + e.getMessage());
                }
                if (az.a.equals(str3)) {
                    try {
                        launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e2.getMessage());
                    }
                } else if (az.b.equals(str3)) {
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
                    if (az.c.equals(str3) && (str2 = map.get("web_uri")) != null) {
                        String trim = str2.trim();
                        if (!trim.startsWith("http://") && !trim.startsWith("https://")) {
                            trim = "http://" + trim;
                        }
                        try {
                            protocol = new URL(trim).getProtocol();
                        } catch (MalformedURLException e5) {
                            e = e5;
                            intent = null;
                        }
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            intent = new Intent("android.intent.action.VIEW");
                            try {
                                intent.setData(Uri.parse(trim));
                            } catch (MalformedURLException e6) {
                                e = e6;
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
                    if (i2 >= 0) {
                        launchIntentForPackage.setFlags(i2);
                    }
                    launchIntentForPackage.addFlags(LaunchTaskConstants.OTHER_PROCESS);
                    try {
                        if (context.getPackageManager().resolveActivity(launchIntentForPackage, 65536) != null) {
                            return launchIntentForPackage;
                        }
                        com.xiaomi.channel.commonutils.logger.b.m109a("not resolve activity:" + launchIntentForPackage);
                    } catch (Exception e7) {
                        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e7.getMessage());
                    }
                }
                return null;
            }
            return null;
        }
        return (Intent) invokeLLLI.objValue;
    }

    private PushMessageHandler.a a(ib ibVar, boolean z, byte[] bArr, String str, int i, Intent intent) {
        InterceptResult invokeCommon;
        el a2;
        String packageName;
        String m325a;
        int i2;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{ibVar, Boolean.valueOf(z), bArr, str, Integer.valueOf(i), intent})) == null) {
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
                iq a3 = ah.a(this.f46a, ibVar);
                if (a3 == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + ibVar.f612a);
                    el.a(this.f46a).b(this.f46a.getPackageName(), ek.m325a(i), str, "18");
                    return null;
                }
                hf a4 = ibVar.a();
                com.xiaomi.channel.commonutils.logger.b.m109a("processing a message, action=" + a4);
                switch (am.a[a4.ordinal()]) {
                    case 1:
                        if (!ibVar.m497b()) {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                            return null;
                        } else if (b.m150a(this.f46a).m161e() && !z) {
                            com.xiaomi.channel.commonutils.logger.b.m109a("receive a message in pause state. drop it");
                            el.a(this.f46a).a(this.f46a.getPackageName(), ek.m325a(i), str, "12");
                            return null;
                        } else {
                            ii iiVar = (ii) a3;
                            hr a5 = iiVar.a();
                            if (a5 == null) {
                                com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                                el.a(this.f46a).b(this.f46a.getPackageName(), ek.m325a(i), str, "22");
                                return null;
                            }
                            if (z) {
                                if (com.xiaomi.push.service.ac.m614a(ibVar)) {
                                    MiPushClient.reportIgnoreRegMessageClicked(this.f46a, a5.m438a(), ibVar.m489a(), ibVar.f619b, a5.b());
                                } else {
                                    MiPushClient.reportMessageClicked(this.f46a, a5.m438a(), ibVar.m489a(), a5.b());
                                }
                            }
                            if (!z) {
                                if (!TextUtils.isEmpty(iiVar.d()) && MiPushClient.aliasSetTime(this.f46a, iiVar.d()) < 0) {
                                    MiPushClient.addAlias(this.f46a, iiVar.d());
                                } else if (!TextUtils.isEmpty(iiVar.c()) && MiPushClient.topicSubscribedTime(this.f46a, iiVar.c()) < 0) {
                                    MiPushClient.addTopic(this.f46a, iiVar.c());
                                }
                            }
                            hs hsVar = ibVar.f613a;
                            String str3 = (hsVar == null || hsVar.m447a() == null) ? null : ibVar.f613a.f525a.get("jobkey");
                            String str4 = str3;
                            if (TextUtils.isEmpty(str3)) {
                                str3 = a5.m438a();
                            }
                            if (z || !m131a(this.f46a, str3)) {
                                MiPushMessage generateMessage = PushMessageHelper.generateMessage(iiVar, ibVar.m489a(), z);
                                if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.ac.m615a(generateMessage.getExtra())) {
                                    com.xiaomi.push.service.ac.m609a(this.f46a, ibVar, bArr);
                                    return null;
                                }
                                com.xiaomi.channel.commonutils.logger.b.m109a("receive a message, msgid=" + a5.m438a() + ", jobkey=" + str3);
                                if (z && generateMessage.getExtra() != null && generateMessage.getExtra().containsKey("notify_effect")) {
                                    Map<String, String> extra = generateMessage.getExtra();
                                    String str5 = extra.get("notify_effect");
                                    int intExtra = intent.getIntExtra("notification_click_button", 0);
                                    com.xiaomi.channel.commonutils.logger.b.m109a("click style button is " + intExtra);
                                    if (intExtra != 0 && ibVar.m489a() != null) {
                                        MiPushClient.clearNotification(this.f46a, ibVar.m489a().c());
                                    }
                                    if (com.xiaomi.push.service.ac.m614a(ibVar)) {
                                        Intent a6 = a(this.f46a, ibVar.f619b, extra, intExtra);
                                        a6.putExtra("eventMessageType", i);
                                        a6.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                        a6.putExtra("jobkey", str4);
                                        if (a6 == null) {
                                            com.xiaomi.channel.commonutils.logger.b.m109a("Getting Intent fail from ignore reg message. ");
                                            el.a(this.f46a).b(this.f46a.getPackageName(), ek.m325a(i), str, "23");
                                            return null;
                                        }
                                        String c = a5.c();
                                        if (!TextUtils.isEmpty(c)) {
                                            a6.putExtra("payload", c);
                                        }
                                        this.f46a.startActivity(a6);
                                        el.a(this.f46a).a(this.f46a.getPackageName(), ek.m325a(i), str, 3006, str5);
                                    } else {
                                        Context context = this.f46a;
                                        Intent a7 = a(context, context.getPackageName(), extra, intExtra);
                                        if (a7 != null) {
                                            if (!str5.equals(az.c)) {
                                                a7.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                                a7.putExtra("eventMessageType", i);
                                                a7.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                                a7.putExtra("jobkey", str4);
                                            }
                                            this.f46a.startActivity(a7);
                                            com.xiaomi.channel.commonutils.logger.b.m109a("start activity succ");
                                            el.a(this.f46a).a(this.f46a.getPackageName(), ek.m325a(i), str, 1006, str5);
                                            if (str5.equals(az.c)) {
                                                el.a(this.f46a).a(this.f46a.getPackageName(), ek.m325a(i), str, "13");
                                            }
                                        }
                                    }
                                    return null;
                                }
                                miPushMessage = generateMessage;
                            } else {
                                com.xiaomi.channel.commonutils.logger.b.m109a("drop a duplicate message, key=" + str3);
                                el a8 = el.a(this.f46a);
                                String packageName2 = this.f46a.getPackageName();
                                String m325a2 = ek.m325a(i);
                                a8.c(packageName2, m325a2, str, "2:" + str3);
                            }
                            if (ibVar.m489a() == null && !z) {
                                a(iiVar, ibVar);
                                break;
                            }
                        }
                        break;
                    case 2:
                        ig igVar = (ig) a3;
                        String str6 = b.m150a(this.f46a).f62a;
                        if (TextUtils.isEmpty(str6) || !TextUtils.equals(str6, igVar.m518a())) {
                            com.xiaomi.channel.commonutils.logger.b.m109a("bad Registration result:");
                            el.a(this.f46a).b(this.f46a.getPackageName(), ek.m325a(i), str, "21");
                            return null;
                        }
                        b.m150a(this.f46a).f62a = null;
                        int i3 = (igVar.f675a > 0L ? 1 : (igVar.f675a == 0L ? 0 : -1));
                        Context context2 = this.f46a;
                        if (i3 == 0) {
                            b.m150a(context2).b(igVar.f685e, igVar.f686f, igVar.f692l);
                            a2 = el.a(this.f46a);
                            packageName = this.f46a.getPackageName();
                            m325a = ek.m325a(i);
                            i2 = w0.j3;
                            str2 = "1";
                        } else {
                            a2 = el.a(context2);
                            packageName = this.f46a.getPackageName();
                            m325a = ek.m325a(i);
                            i2 = w0.j3;
                            str2 = "2";
                        }
                        a2.a(packageName, m325a, str, i2, str2);
                        if (!TextUtils.isEmpty(igVar.f685e)) {
                            arrayList3 = new ArrayList();
                            arrayList3.add(igVar.f685e);
                        }
                        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ev.a.f321a, arrayList3, igVar.f675a, igVar.f684d, null);
                        an.a(this.f46a).m148d();
                        return generateCommandMessage;
                    case 3:
                        if (((im) a3).f751a == 0) {
                            b.m150a(this.f46a).m152a();
                            MiPushClient.clearExtras(this.f46a);
                        }
                        PushMessageHandler.a();
                        break;
                    case 4:
                        ik ikVar = (ik) a3;
                        if (ikVar.f726a == 0) {
                            MiPushClient.addTopic(this.f46a, ikVar.b());
                        }
                        if (!TextUtils.isEmpty(ikVar.b())) {
                            arrayList2 = new ArrayList();
                            arrayList2.add(ikVar.b());
                        }
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ev.g + StringUtil.ARRAY_ELEMENT_SEPARATOR + ikVar.a());
                        return PushMessageHelper.generateCommandMessage(ev.g.f321a, arrayList2, ikVar.f726a, ikVar.f732d, ikVar.c());
                    case 5:
                        io ioVar = (io) a3;
                        if (ioVar.f771a == 0) {
                            MiPushClient.removeTopic(this.f46a, ioVar.b());
                        }
                        if (!TextUtils.isEmpty(ioVar.b())) {
                            arrayList = new ArrayList();
                            arrayList.add(ioVar.b());
                        }
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ev.h + StringUtil.ARRAY_ELEMENT_SEPARATOR + ioVar.a());
                        return PushMessageHelper.generateCommandMessage(ev.h.f321a, arrayList, ioVar.f771a, ioVar.f777d, ioVar.c());
                    case 6:
                        cy.a(this.f46a.getPackageName(), this.f46a, a3, hf.j, bArr.length);
                        ia iaVar = (ia) a3;
                        String b = iaVar.b();
                        List<String> m483a = iaVar.m483a();
                        if (iaVar.f600a == 0) {
                            if (TextUtils.equals(b, ev.i.f321a) && m483a != null && m483a.size() > 1) {
                                MiPushClient.addAcceptTime(this.f46a, m483a.get(0), m483a.get(1));
                                if (BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(m483a.get(0)) && BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(m483a.get(1))) {
                                    b.m150a(this.f46a).a(true);
                                } else {
                                    b.m150a(this.f46a).a(false);
                                }
                                m483a = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m483a);
                            } else if (TextUtils.equals(b, ev.c.f321a) && m483a != null && m483a.size() > 0) {
                                MiPushClient.addAlias(this.f46a, m483a.get(0));
                            } else if (TextUtils.equals(b, ev.d.f321a) && m483a != null && m483a.size() > 0) {
                                MiPushClient.removeAlias(this.f46a, m483a.get(0));
                            } else if (TextUtils.equals(b, ev.e.f321a) && m483a != null && m483a.size() > 0) {
                                MiPushClient.addAccount(this.f46a, m483a.get(0));
                            } else if (TextUtils.equals(b, ev.f.f321a) && m483a != null && m483a.size() > 0) {
                                MiPushClient.removeAccount(this.f46a, m483a.get(0));
                            } else if (TextUtils.equals(b, ev.j.f321a)) {
                                if (m483a != null && m483a.size() > 0) {
                                    com.xiaomi.push.i.a(this.f46a, m483a.get(0));
                                }
                                return null;
                            }
                        }
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + b + StringUtil.ARRAY_ELEMENT_SEPARATOR + iaVar.a());
                        return PushMessageHelper.generateCommandMessage(b, m483a, iaVar.f600a, iaVar.f608d, iaVar.c());
                    case 7:
                        cy.a(this.f46a.getPackageName(), this.f46a, a3, hf.i, bArr.length);
                        if (a3 instanceof hw) {
                            hw hwVar = (hw) a3;
                            String a9 = hwVar.a();
                            com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + hwVar.b() + ", code:" + hwVar.f568a + StringUtil.ARRAY_ELEMENT_SEPARATOR + a9);
                            if (hp.E.f490a.equalsIgnoreCase(hwVar.f575d)) {
                                if (hwVar.f568a == 0) {
                                    synchronized (ae.class) {
                                        if (ae.a(this.f46a).m130a(a9)) {
                                            ae.a(this.f46a).c(a9);
                                            if ("syncing".equals(ae.a(this.f46a).a(at.a))) {
                                                ae.a(this.f46a).a(at.a, "synced");
                                                MiPushClient.clearNotification(this.f46a);
                                                MiPushClient.clearLocalNotificationType(this.f46a);
                                                PushMessageHandler.a();
                                                an.a(this.f46a).m145b();
                                            }
                                        }
                                    }
                                    break;
                                } else if ("syncing".equals(ae.a(this.f46a).a(at.a))) {
                                    synchronized (ae.class) {
                                        if (ae.a(this.f46a).m130a(a9)) {
                                            if (ae.a(this.f46a).a(a9) < 10) {
                                                ae.a(this.f46a).b(a9);
                                                an.a(this.f46a).a(true, a9);
                                            } else {
                                                ae.a(this.f46a).c(a9);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else if (hp.F.f490a.equalsIgnoreCase(hwVar.f575d)) {
                                if (hwVar.f568a == 0) {
                                    synchronized (ae.class) {
                                        if (ae.a(this.f46a).m130a(a9)) {
                                            ae.a(this.f46a).c(a9);
                                            if ("syncing".equals(ae.a(this.f46a).a(at.b))) {
                                                ae.a(this.f46a).a(at.b, "synced");
                                            }
                                        }
                                    }
                                    break;
                                } else if ("syncing".equals(ae.a(this.f46a).a(at.b))) {
                                    synchronized (ae.class) {
                                        if (ae.a(this.f46a).m130a(a9)) {
                                            if (ae.a(this.f46a).a(a9) < 10) {
                                                ae.a(this.f46a).b(a9);
                                                an.a(this.f46a).a(false, a9);
                                            } else {
                                                ae.a(this.f46a).c(a9);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else if (hp.N.f490a.equalsIgnoreCase(hwVar.f575d)) {
                                b(hwVar);
                                break;
                            } else if (hp.B.f490a.equalsIgnoreCase(hwVar.f575d)) {
                                a(hwVar);
                                break;
                            }
                            ae.a(this.f46a).c(a9);
                            break;
                        } else if (a3 instanceof ie) {
                            ie ieVar = (ie) a3;
                            if ("registration id expired".equalsIgnoreCase(ieVar.f636d)) {
                                List<String> allAlias = MiPushClient.getAllAlias(this.f46a);
                                List<String> allTopic = MiPushClient.getAllTopic(this.f46a);
                                List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f46a);
                                String acceptTime = MiPushClient.getAcceptTime(this.f46a);
                                com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + ieVar.f636d + StringUtil.ARRAY_ELEMENT_SEPARATOR + ieVar.m504a());
                                MiPushClient.reInitialize(this.f46a, ht.a);
                                for (String str7 : allAlias) {
                                    MiPushClient.removeAlias(this.f46a, str7);
                                    MiPushClient.setAlias(this.f46a, str7, null);
                                }
                                for (String str8 : allTopic) {
                                    MiPushClient.removeTopic(this.f46a, str8);
                                    MiPushClient.subscribe(this.f46a, str8, null);
                                }
                                for (String str9 : allUserAccount) {
                                    MiPushClient.removeAccount(this.f46a, str9);
                                    MiPushClient.setUserAccount(this.f46a, str9, null);
                                }
                                String[] split = acceptTime.split(",");
                                if (split.length == 2) {
                                    MiPushClient.removeAcceptTime(this.f46a);
                                    MiPushClient.addAcceptTime(this.f46a, split[0], split[1]);
                                    break;
                                }
                            } else if (hp.h.f490a.equalsIgnoreCase(ieVar.f636d)) {
                                if (ieVar.m505a() != null && ieVar.m505a().containsKey("app_version")) {
                                    b.m150a(this.f46a).m153a(ieVar.m505a().get("app_version"));
                                    break;
                                }
                            } else if (hp.m.f490a.equalsIgnoreCase(ieVar.f636d)) {
                                if (ibVar.m497b() && ieVar.m505a() != null && ieVar.m505a().containsKey("awake_info")) {
                                    Context context3 = this.f46a;
                                    o.a(context3, b.m150a(context3).m151a(), com.xiaomi.push.service.aq.a(this.f46a).a(hk.aF.a(), 0), ieVar.m505a().get("awake_info"));
                                    break;
                                }
                            } else {
                                try {
                                    if (hp.n.f490a.equalsIgnoreCase(ieVar.f636d)) {
                                        id idVar = new id();
                                        ip.a(idVar, ieVar.m510a());
                                        com.xiaomi.push.service.ar.a(com.xiaomi.push.service.aq.a(this.f46a), idVar);
                                    } else if (hp.o.f490a.equalsIgnoreCase(ieVar.f636d)) {
                                        ic icVar = new ic();
                                        ip.a(icVar, ieVar.m510a());
                                        com.xiaomi.push.service.ar.a(com.xiaomi.push.service.aq.a(this.f46a), icVar);
                                    } else if (hp.w.f490a.equalsIgnoreCase(ieVar.f636d)) {
                                        au.a(this.f46a, ieVar);
                                        break;
                                    } else if (hp.x.f490a.equalsIgnoreCase(ieVar.f636d)) {
                                        com.xiaomi.channel.commonutils.logger.b.m109a("receive force sync notification");
                                        au.a(this.f46a, false);
                                        break;
                                    } else if (hp.C.f490a.equals(ieVar.f636d)) {
                                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + ieVar.f636d + StringUtil.ARRAY_ELEMENT_SEPARATOR + ieVar.m504a());
                                        if (ieVar.m505a() != null) {
                                            int i4 = -2;
                                            if (ieVar.m505a().containsKey(az.K)) {
                                                String str10 = ieVar.m505a().get(az.K);
                                                if (!TextUtils.isEmpty(str10)) {
                                                    try {
                                                        i4 = Integer.parseInt(str10);
                                                    } catch (NumberFormatException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                            if (i4 >= -1) {
                                                MiPushClient.clearNotification(this.f46a, i4);
                                            } else {
                                                MiPushClient.clearNotification(this.f46a, ieVar.m505a().containsKey(az.I) ? ieVar.m505a().get(az.I) : "", ieVar.m505a().containsKey(az.J) ? ieVar.m505a().get(az.J) : "");
                                            }
                                        }
                                        a(ieVar);
                                        break;
                                    } else {
                                        try {
                                            if (hp.K.f490a.equals(ieVar.f636d)) {
                                                ig igVar2 = new ig();
                                                ip.a(igVar2, ieVar.m510a());
                                                MiPushClient4Hybrid.onReceiveRegisterResult(this.f46a, igVar2);
                                            } else if (hp.M.f490a.equals(ieVar.f636d)) {
                                                im imVar = new im();
                                                ip.a(imVar, ieVar.m510a());
                                                MiPushClient4Hybrid.onReceiveUnregisterResult(this.f46a, imVar);
                                            } else if (!hp.P.f490a.equals(ieVar.f636d) && com.xiaomi.push.service.d.a(ieVar)) {
                                                com.xiaomi.channel.commonutils.logger.b.b("receive notification handle by cpra");
                                                break;
                                            }
                                            break;
                                        } catch (iv e2) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e2);
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
            } catch (t e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                a(ibVar);
                el.a(this.f46a).b(this.f46a.getPackageName(), ek.m325a(i), str, "19");
                return null;
            } catch (iv e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
                com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
                el.a(this.f46a).b(this.f46a.getPackageName(), ek.m325a(i), str, UVEventType.PAY_WALLET_BANNER_SHOW);
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
                a2 = ah.a(this.f46a, ibVar);
            } catch (t e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                str = "message arrived: receive a message but decrypt failed. report when click.";
            } catch (iv e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                str = "message arrived: receive a message which action string is not valid. is the reg expired?";
            }
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + ibVar.f612a);
                return null;
            }
            hf a3 = ibVar.a();
            com.xiaomi.channel.commonutils.logger.b.m109a("message arrived: processing an arrived message, action=" + a3);
            if (am.a[a3.ordinal()] != 1) {
                return null;
            }
            if (ibVar.m497b()) {
                ii iiVar = (ii) a2;
                hr a4 = iiVar.a();
                if (a4 != null) {
                    hs hsVar = ibVar.f613a;
                    if (hsVar != null && hsVar.m447a() != null) {
                        str2 = ibVar.f613a.f525a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(iiVar, ibVar.m489a(), false);
                    generateMessage.setArrivedMessage(true);
                    com.xiaomi.channel.commonutils.logger.b.m109a("message arrived: receive a message, msgid=" + a4.m438a() + ", jobkey=" + str2);
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
            SharedPreferences sharedPreferences = this.f46a.getSharedPreferences("mipush_extra", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > FlushManager.ReportTimer.DEFAULT_INTERVAL) {
                MiPushClient.reInitialize(this.f46a, ht.b);
                sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
            }
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            synchronized (f44a) {
                f45a.remove(str);
                b.m150a(context);
                SharedPreferences a2 = b.a(context);
                String a3 = bm.a(f45a, ",");
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
            Map<String, String> m461a = hwVar.m461a();
            if (m461a != null) {
                String str = m461a.get("real_source");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
                bu.a(this.f46a).a(a2, str, Boolean.valueOf(hwVar.f568a == 0));
            }
        }
    }

    private void a(ib ibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, ibVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.m109a("receive a message but decrypt failed. report now.");
            ie ieVar = new ie(ibVar.m489a().f523a, false);
            ieVar.c(hp.u.f490a);
            ieVar.b(ibVar.m490a());
            ieVar.d(ibVar.f619b);
            HashMap hashMap = new HashMap();
            ieVar.f631a = hashMap;
            hashMap.put("regid", MiPushClient.getRegId(this.f46a));
            an.a(this.f46a).a((an) ieVar, hf.i, false, (hs) null);
        }
    }

    private void a(ie ieVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, ieVar) == null) {
            hw hwVar = new hw();
            hwVar.c(hp.D.f490a);
            hwVar.a(ieVar.m504a());
            hwVar.a(ieVar.a());
            hwVar.b(ieVar.b());
            hwVar.e(ieVar.c());
            hwVar.a(0L);
            hwVar.d("success clear push message.");
            an.a(this.f46a).a(hwVar, hf.i, false, true, null, false, this.f46a.getPackageName(), b.m150a(this.f46a).m151a(), false);
        }
    }

    private void a(ii iiVar, ib ibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, iiVar, ibVar) == null) {
            hs m489a = ibVar.m489a();
            hv hvVar = new hv();
            hvVar.b(iiVar.b());
            hvVar.a(iiVar.m525a());
            hvVar.a(iiVar.a().a());
            if (!TextUtils.isEmpty(iiVar.c())) {
                hvVar.c(iiVar.c());
            }
            if (!TextUtils.isEmpty(iiVar.d())) {
                hvVar.d(iiVar.d());
            }
            hvVar.a(ip.a(this.f46a, ibVar));
            an.a(this.f46a).a((an) hvVar, hf.f, m489a);
        }
    }

    private void a(String str, long j, e eVar) {
        at a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{str, Long.valueOf(j), eVar}) == null) || (a2 = l.a(eVar)) == null) {
            return;
        }
        if (j == 0) {
            synchronized (ae.class) {
                if (ae.a(this.f46a).m130a(str)) {
                    ae.a(this.f46a).c(str);
                    if ("syncing".equals(ae.a(this.f46a).a(a2))) {
                        ae.a(this.f46a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(ae.a(this.f46a).a(a2))) {
            ae.a(this.f46a).c(str);
        } else {
            synchronized (ae.class) {
                if (ae.a(this.f46a).m130a(str)) {
                    if (ae.a(this.f46a).a(str) < 10) {
                        ae.a(this.f46a).b(str);
                        an.a(this.f46a).a(str, a2, eVar);
                    } else {
                        ae.a(this.f46a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m131a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            synchronized (f44a) {
                b.m150a(context);
                SharedPreferences a2 = b.a(context);
                if (f45a == null) {
                    String[] split = a2.getString("pref_msg_ids", "").split(",");
                    f45a = new LinkedList();
                    for (String str2 : split) {
                        f45a.add(str2);
                    }
                }
                if (f45a.contains(str)) {
                    return true;
                }
                f45a.add(str);
                if (f45a.size() > 25) {
                    f45a.poll();
                }
                String a3 = bm.a(f45a, ",");
                SharedPreferences.Editor edit = a2.edit();
                edit.putString("pref_msg_ids", a3);
                com.xiaomi.push.r.a(edit);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m132a(ib ibVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, ibVar)) == null) {
            Map<String, String> m447a = ibVar.m489a() == null ? null : ibVar.m489a().m447a();
            if (m447a == null) {
                return false;
            }
            String str = m447a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
            return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
        }
        return invokeL.booleanValue;
    }

    private void b(hw hwVar) {
        long j;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, hwVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + hwVar.toString());
            String a2 = hwVar.a();
            Map<String, String> m461a = hwVar.m461a();
            if (m461a != null) {
                String str = m461a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.contains("brand:" + af.c.name())) {
                    com.xiaomi.channel.commonutils.logger.b.m109a("ASSEMBLE_PUSH : receive fcm token sync ack");
                    i.b(this.f46a, e.b, str);
                    j = hwVar.f568a;
                    eVar = e.b;
                } else {
                    if (str.contains("brand:" + af.a.name())) {
                        com.xiaomi.channel.commonutils.logger.b.m109a("ASSEMBLE_PUSH : receive hw token sync ack");
                        i.b(this.f46a, e.a, str);
                        j = hwVar.f568a;
                        eVar = e.a;
                    } else {
                        if (str.contains("brand:" + af.d.name())) {
                            com.xiaomi.channel.commonutils.logger.b.m109a("ASSEMBLE_PUSH : receive COS token sync ack");
                            i.b(this.f46a, e.c, str);
                            j = hwVar.f568a;
                            eVar = e.c;
                        } else {
                            if (!str.contains("brand:" + af.e.name())) {
                                return;
                            }
                            com.xiaomi.channel.commonutils.logger.b.m109a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                            i.b(this.f46a, e.d, str);
                            j = hwVar.f568a;
                            eVar = e.d;
                        }
                    }
                }
                a(a2, j, eVar);
            }
        }
    }

    private void b(ib ibVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, ibVar) == null) {
            hs m489a = ibVar.m489a();
            hv hvVar = new hv();
            hvVar.b(ibVar.m490a());
            hvVar.a(m489a.m446a());
            hvVar.a(m489a.m444a());
            if (!TextUtils.isEmpty(m489a.m451b())) {
                hvVar.c(m489a.m451b());
            }
            hvVar.a(ip.a(this.f46a, ibVar));
            an.a(this.f46a).a((an) hvVar, hf.f, false, ibVar.m489a());
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
            com.xiaomi.channel.commonutils.logger.b.m109a("receive an intent from server, action=" + action);
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
                    el.a(this.f46a).a(this.f46a.getPackageName(), intent, "12");
                    return null;
                }
                ib ibVar = new ib();
                try {
                    ip.a(ibVar, byteArrayExtra);
                    b m150a = b.m150a(this.f46a);
                    hs m489a = ibVar.m489a();
                    if (ibVar.a() == hf.e && m489a != null && !m150a.m161e() && !booleanExtra) {
                        m489a.a("mrt", stringExtra);
                        m489a.a("mat", Long.toString(System.currentTimeMillis()));
                        if (m132a(ibVar)) {
                            com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                            m489a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m489a.m444a()));
                            m489a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) ip.a(this.f46a, ibVar)));
                        } else {
                            b(ibVar);
                        }
                    }
                    if (ibVar.a() == hf.e && !ibVar.m497b()) {
                        if (com.xiaomi.push.service.ac.m614a(ibVar)) {
                            Object[] objArr = new Object[2];
                            objArr[0] = ibVar.b();
                            objArr[1] = m489a != null ? m489a.m446a() : "";
                            com.xiaomi.channel.commonutils.logger.b.m109a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                            a3 = el.a(this.f46a);
                            packageName2 = this.f46a.getPackageName();
                            format = String.format("13: %1$s", ibVar.b());
                        } else {
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = ibVar.b();
                            objArr2[1] = m489a != null ? m489a.m446a() : "";
                            com.xiaomi.channel.commonutils.logger.b.m109a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                            a3 = el.a(this.f46a);
                            packageName2 = this.f46a.getPackageName();
                            format = String.format("14: %1$s", ibVar.b());
                        }
                        a3.a(packageName2, intent, format);
                        return null;
                    }
                    if (ibVar.a() == hf.e && ibVar.m497b() && com.xiaomi.push.service.ac.m614a(ibVar) && (!booleanExtra || m489a == null || m489a.m447a() == null || !m489a.m447a().containsKey("notify_effect"))) {
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = ibVar.b();
                        objArr3[1] = m489a != null ? m489a.m446a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m109a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                        el.a(this.f46a).a(this.f46a.getPackageName(), intent, String.format("25: %1$s", ibVar.b()));
                        return null;
                    }
                    if (m150a.m159c() || ibVar.f612a == hf.a) {
                        if (!m150a.m159c() || !m150a.m162f()) {
                            return a(ibVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                        }
                        if (ibVar.f612a == hf.b) {
                            m150a.m152a();
                            MiPushClient.clearExtras(this.f46a);
                            PushMessageHandler.a();
                        } else {
                            MiPushClient.unregisterPush(this.f46a);
                        }
                    } else if (com.xiaomi.push.service.ac.m614a(ibVar)) {
                        return a(ibVar, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    } else {
                        boolean m160d = m150a.m160d();
                        com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?" + m160d);
                        el.a(this.f46a).a(this.f46a.getPackageName(), intent, "15");
                        if (m160d) {
                            a();
                        }
                    }
                } catch (iv e) {
                    e = e;
                    a2 = el.a(this.f46a);
                    packageName = this.f46a.getPackageName();
                    str2 = "16";
                    a2.a(packageName, intent, str2);
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    a2 = el.a(this.f46a);
                    packageName = this.f46a.getPackageName();
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
                    b m150a2 = b.m150a(this.f46a);
                    if (com.xiaomi.push.service.ac.m614a(ibVar3)) {
                        str = "message arrived: receive ignore reg message, ignore!";
                    } else if (!m150a2.m159c()) {
                        str = "message arrived: receive message without registration. need unregister or re-register!";
                    } else if (!m150a2.m159c() || !m150a2.m162f()) {
                        return a(ibVar3, byteArrayExtra3);
                    } else {
                        str = "message arrived: app info is invalidated";
                    }
                    com.xiaomi.channel.commonutils.logger.b.d(str);
                } catch (Exception e3) {
                    com.xiaomi.channel.commonutils.logger.b.d("fail to deal with arrived message. " + e3);
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
