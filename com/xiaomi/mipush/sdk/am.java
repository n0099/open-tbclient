package com.xiaomi.mipush.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.player.widget.BdPlayerProgressView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import com.xiaomi.mipush.sdk.PushMessageHandler;
import com.xiaomi.push.Cif;
import com.xiaomi.push.bp;
import com.xiaomi.push.bx;
import com.xiaomi.push.db;
import com.xiaomi.push.en;
import com.xiaomi.push.eo;
import com.xiaomi.push.ey;
import com.xiaomi.push.hj;
import com.xiaomi.push.ho;
import com.xiaomi.push.ht;
import com.xiaomi.push.hv;
import com.xiaomi.push.hw;
import com.xiaomi.push.hx;
import com.xiaomi.push.hz;
import com.xiaomi.push.ia;
import com.xiaomi.push.ie;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.ik;
import com.xiaomi.push.im;
import com.xiaomi.push.io;
import com.xiaomi.push.iq;
import com.xiaomi.push.is;
import com.xiaomi.push.it;
import com.xiaomi.push.iu;
import com.xiaomi.push.iz;
import com.xiaomi.push.service.ay;
import com.xiaomi.push.service.ba;
import com.xiaomi.push.service.bb;
import com.xiaomi.push.service.bk;
import com.xiaomi.push.service.br;
import com.xiaomi.push.w;
import com.yy.hiidostatis.inner.FlushManager;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UVEventType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TimeZone;
/* loaded from: classes8.dex */
public class am {
    public static /* synthetic */ Interceptable $ic;
    public static am a;

    /* renamed from: a  reason: collision with other field name */
    public static Object f45a;

    /* renamed from: a  reason: collision with other field name */
    public static Queue<String> f46a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public Context f47a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871206693, "Lcom/xiaomi/mipush/sdk/am;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871206693, "Lcom/xiaomi/mipush/sdk/am;");
                return;
            }
        }
        f45a = new Object();
    }

    public am(Context context) {
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
        this.f47a = applicationContext;
        if (applicationContext == null) {
            this.f47a = context;
        }
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(65538, null, context, str, map, i)) == null) ? com.xiaomi.push.service.al.b(context, str, map, i) : (Intent) invokeLLLI.objValue;
    }

    private PushMessageHandler.a a(Cif cif, boolean z, byte[] bArr, String str, int i, Intent intent) {
        InterceptResult invokeCommon;
        eo a2;
        String packageName;
        String m304a;
        String str2;
        String str3;
        String str4;
        MiPushMessage miPushMessage;
        eo a3;
        String packageName2;
        String m304a2;
        int i2;
        String str5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{cif, Boolean.valueOf(z), bArr, str, Integer.valueOf(i), intent})) == null) {
            ArrayList arrayList = null;
            try {
                iu a4 = ai.a(this.f47a, cif);
                if (a4 == null) {
                    com.xiaomi.channel.commonutils.logger.b.d("receiving an un-recognized message. " + cif.f618a);
                    eo.a(this.f47a).b(this.f47a.getPackageName(), en.m304a(i), str, "18");
                    s.c(this.f47a, cif, z);
                    return null;
                }
                hj a5 = cif.a();
                com.xiaomi.channel.commonutils.logger.b.m84a("processing a message, action=" + a5);
                switch (an.a[a5.ordinal()]) {
                    case 1:
                        if (!cif.m468b()) {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(SendMessage).");
                            return null;
                        } else if (b.m126a(this.f47a).m137e() && !z) {
                            com.xiaomi.channel.commonutils.logger.b.m84a("receive a message in pause state. drop it");
                            eo.a(this.f47a).a(this.f47a.getPackageName(), en.m304a(i), str, "12");
                            return null;
                        } else {
                            im imVar = (im) a4;
                            hv a6 = imVar.a();
                            if (a6 == null) {
                                com.xiaomi.channel.commonutils.logger.b.d("receive an empty message without push content, drop it");
                                eo.a(this.f47a).b(this.f47a.getPackageName(), en.m304a(i), str, "22");
                                s.d(this.f47a, cif, z);
                                return null;
                            }
                            int intExtra = intent.getIntExtra("notification_click_button", 0);
                            if (z) {
                                if (com.xiaomi.push.service.al.m604a(cif)) {
                                    MiPushClient.reportIgnoreRegMessageClicked(this.f47a, a6.m418a(), cif.m460a(), cif.f625b, a6.b());
                                } else {
                                    hw hwVar = cif.m460a() != null ? new hw(cif.m460a()) : new hw();
                                    if (hwVar.m427a() == null) {
                                        hwVar.a(new HashMap());
                                    }
                                    hwVar.m427a().put("notification_click_button", String.valueOf(intExtra));
                                    MiPushClient.reportMessageClicked(this.f47a, a6.m418a(), hwVar, a6.b());
                                }
                            }
                            if (!z) {
                                if (!TextUtils.isEmpty(imVar.d()) && MiPushClient.aliasSetTime(this.f47a, imVar.d()) < 0) {
                                    MiPushClient.addAlias(this.f47a, imVar.d());
                                } else if (!TextUtils.isEmpty(imVar.c()) && MiPushClient.topicSubscribedTime(this.f47a, imVar.c()) < 0) {
                                    MiPushClient.addTopic(this.f47a, imVar.c());
                                }
                            }
                            hw hwVar2 = cif.f619a;
                            if (hwVar2 == null || hwVar2.m427a() == null) {
                                str3 = null;
                                str4 = null;
                            } else {
                                str3 = cif.f619a.f533a.get("jobkey");
                                str4 = str3;
                            }
                            if (TextUtils.isEmpty(str3)) {
                                str3 = a6.m418a();
                            }
                            if (z || !m107a(this.f47a, str3)) {
                                MiPushMessage generateMessage = PushMessageHelper.generateMessage(imVar, cif.m460a(), z);
                                if (generateMessage.getPassThrough() == 0 && !z && com.xiaomi.push.service.al.m605a(generateMessage.getExtra())) {
                                    com.xiaomi.push.service.al.m600a(this.f47a, cif, bArr);
                                    return null;
                                }
                                com.xiaomi.channel.commonutils.logger.b.m84a("receive a message, msgid=" + a6.m418a() + ", jobkey=" + str3 + ", btn=" + intExtra);
                                String a7 = com.xiaomi.push.service.al.a(generateMessage.getExtra(), intExtra);
                                if (z && generateMessage.getExtra() != null && !TextUtils.isEmpty(a7)) {
                                    Map<String, String> extra = generateMessage.getExtra();
                                    if (intExtra != 0 && cif.m460a() != null) {
                                        ao.a(this.f47a).a(cif.m460a().c(), intExtra);
                                    }
                                    if (com.xiaomi.push.service.al.m604a(cif)) {
                                        Intent a8 = a(this.f47a, cif.f625b, extra, intExtra);
                                        a8.putExtra("eventMessageType", i);
                                        a8.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                        a8.putExtra("jobkey", str4);
                                        if (a8 == null) {
                                            com.xiaomi.channel.commonutils.logger.b.m84a("Getting Intent fail from ignore reg message. ");
                                            eo.a(this.f47a).b(this.f47a.getPackageName(), en.m304a(i), str, "23");
                                            return null;
                                        }
                                        String c = a6.c();
                                        if (!TextUtils.isEmpty(c)) {
                                            a8.putExtra("payload", c);
                                        }
                                        this.f47a.startActivity(a8);
                                        s.a(this.f47a, cif);
                                        eo.a(this.f47a).a(this.f47a.getPackageName(), en.m304a(i), str, 3006, a7);
                                        return null;
                                    }
                                    Context context = this.f47a;
                                    Intent a9 = a(context, context.getPackageName(), extra, intExtra);
                                    if (a9 != null) {
                                        if (!a7.equals(bk.c)) {
                                            a9.putExtra(PushMessageHelper.KEY_MESSAGE, generateMessage);
                                            a9.putExtra("eventMessageType", i);
                                            a9.putExtra(MiPushMessage.KEY_MESSAGE_ID, str);
                                            a9.putExtra("jobkey", str4);
                                        }
                                        this.f47a.startActivity(a9);
                                        s.a(this.f47a, cif);
                                        com.xiaomi.channel.commonutils.logger.b.m84a("start activity succ");
                                        eo.a(this.f47a).a(this.f47a.getPackageName(), en.m304a(i), str, 1006, a7);
                                        if (a7.equals(bk.c)) {
                                            eo.a(this.f47a).a(this.f47a.getPackageName(), en.m304a(i), str, "13");
                                            return null;
                                        }
                                        return null;
                                    }
                                    return null;
                                }
                                miPushMessage = generateMessage;
                            } else {
                                com.xiaomi.channel.commonutils.logger.b.m84a("drop a duplicate message, key=" + str3);
                                eo a10 = eo.a(this.f47a);
                                String packageName3 = this.f47a.getPackageName();
                                String m304a3 = en.m304a(i);
                                a10.c(packageName3, m304a3, str, "2:" + str3);
                                miPushMessage = null;
                            }
                            if (cif.m460a() == null && !z) {
                                a(imVar, cif);
                            }
                            return miPushMessage;
                        }
                    case 2:
                        ik ikVar = (ik) a4;
                        String str6 = b.m126a(this.f47a).f63a;
                        if (TextUtils.isEmpty(str6) || !TextUtils.equals(str6, ikVar.m489a())) {
                            com.xiaomi.channel.commonutils.logger.b.m84a("bad Registration result:");
                            eo.a(this.f47a).b(this.f47a.getPackageName(), en.m304a(i), str, "21");
                            return null;
                        }
                        b.m126a(this.f47a).f63a = null;
                        int i3 = (ikVar.f681a > 0L ? 1 : (ikVar.f681a == 0L ? 0 : -1));
                        Context context2 = this.f47a;
                        if (i3 == 0) {
                            b.m126a(context2).b(ikVar.f693e, ikVar.f694f, ikVar.f700l);
                            FCMPushHelper.persistIfXmsfSupDecrypt(this.f47a);
                            a3 = eo.a(this.f47a);
                            packageName2 = this.f47a.getPackageName();
                            m304a2 = en.m304a(i);
                            i2 = w0.j3;
                            str5 = "1";
                        } else {
                            a3 = eo.a(context2);
                            packageName2 = this.f47a.getPackageName();
                            m304a2 = en.m304a(i);
                            i2 = w0.j3;
                            str5 = "2";
                        }
                        a3.a(packageName2, m304a2, str, i2, str5);
                        if (!TextUtils.isEmpty(ikVar.f693e)) {
                            arrayList = new ArrayList();
                            arrayList.add(ikVar.f693e);
                        }
                        MiPushCommandMessage generateCommandMessage = PushMessageHelper.generateCommandMessage(ey.a.f326a, arrayList, ikVar.f681a, ikVar.f692d, null, ikVar.m490a());
                        ao.a(this.f47a).m124d();
                        return generateCommandMessage;
                    case 3:
                        if (!cif.m468b()) {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt message(UnRegistration).");
                            return null;
                        }
                        if (((iq) a4).f759a == 0) {
                            b.m126a(this.f47a).m128a();
                            MiPushClient.clearExtras(this.f47a);
                        }
                        PushMessageHandler.a();
                        break;
                    case 4:
                        io ioVar = (io) a4;
                        if (ioVar.f734a == 0) {
                            MiPushClient.addTopic(this.f47a, ioVar.b());
                        }
                        if (!TextUtils.isEmpty(ioVar.b())) {
                            arrayList = new ArrayList();
                            arrayList.add(ioVar.b());
                        }
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ey.g + StringUtil.ARRAY_ELEMENT_SEPARATOR + ioVar.a());
                        return PushMessageHelper.generateCommandMessage(ey.g.f326a, arrayList, ioVar.f734a, ioVar.f740d, ioVar.c(), null);
                    case 5:
                        is isVar = (is) a4;
                        if (isVar.f779a == 0) {
                            MiPushClient.removeTopic(this.f47a, isVar.b());
                        }
                        if (!TextUtils.isEmpty(isVar.b())) {
                            arrayList = new ArrayList();
                            arrayList.add(isVar.b());
                        }
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + ey.h + StringUtil.ARRAY_ELEMENT_SEPARATOR + isVar.a());
                        return PushMessageHelper.generateCommandMessage(ey.h.f326a, arrayList, isVar.f779a, isVar.f785d, isVar.c(), null);
                    case 6:
                        db.a(this.f47a.getPackageName(), this.f47a, a4, hj.j, bArr.length);
                        ie ieVar = (ie) a4;
                        String b = ieVar.b();
                        List<String> m454a = ieVar.m454a();
                        if (ieVar.f606a == 0) {
                            if (TextUtils.equals(b, ey.i.f326a) && m454a != null && m454a.size() > 1) {
                                MiPushClient.addAcceptTime(this.f47a, m454a.get(0), m454a.get(1));
                                if (BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(m454a.get(0)) && BdPlayerProgressView.DEFAULT_TIME_TEXT.equals(m454a.get(1))) {
                                    b.m126a(this.f47a).a(true);
                                } else {
                                    b.m126a(this.f47a).a(false);
                                }
                                m454a = a(TimeZone.getTimeZone("GMT+08"), TimeZone.getDefault(), m454a);
                            } else if (TextUtils.equals(b, ey.c.f326a) && m454a != null && m454a.size() > 0) {
                                MiPushClient.addAlias(this.f47a, m454a.get(0));
                            } else if (TextUtils.equals(b, ey.d.f326a) && m454a != null && m454a.size() > 0) {
                                MiPushClient.removeAlias(this.f47a, m454a.get(0));
                            } else if (TextUtils.equals(b, ey.e.f326a) && m454a != null && m454a.size() > 0) {
                                MiPushClient.addAccount(this.f47a, m454a.get(0));
                            } else if (TextUtils.equals(b, ey.f.f326a) && m454a != null && m454a.size() > 0) {
                                MiPushClient.removeAccount(this.f47a, m454a.get(0));
                            } else if (TextUtils.equals(b, ey.j.f326a)) {
                                return null;
                            }
                        }
                        List<String> list = m454a;
                        com.xiaomi.channel.commonutils.logger.b.e("resp-cmd:" + b + StringUtil.ARRAY_ELEMENT_SEPARATOR + ieVar.a());
                        return PushMessageHelper.generateCommandMessage(b, list, ieVar.f606a, ieVar.f614d, ieVar.c(), null);
                    case 7:
                        db.a(this.f47a.getPackageName(), this.f47a, a4, hj.i, bArr.length);
                        if (a4 instanceof ia) {
                            ia iaVar = (ia) a4;
                            String a11 = iaVar.a();
                            com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + iaVar.b() + ", code:" + iaVar.f576a + StringUtil.ARRAY_ELEMENT_SEPARATOR + a11);
                            if (ht.E.f498a.equalsIgnoreCase(iaVar.f583d)) {
                                if (iaVar.f576a == 0) {
                                    synchronized (af.class) {
                                        if (af.a(this.f47a).m106a(a11)) {
                                            af.a(this.f47a).c(a11);
                                            if ("syncing".equals(af.a(this.f47a).a(au.a))) {
                                                af.a(this.f47a).a(au.a, "synced");
                                                MiPushClient.clearNotification(this.f47a);
                                                MiPushClient.clearLocalNotificationType(this.f47a);
                                                PushMessageHandler.a();
                                                ao.a(this.f47a).m121b();
                                            }
                                        }
                                    }
                                    break;
                                } else if ("syncing".equals(af.a(this.f47a).a(au.a))) {
                                    synchronized (af.class) {
                                        if (af.a(this.f47a).m106a(a11)) {
                                            if (af.a(this.f47a).a(a11) < 10) {
                                                af.a(this.f47a).b(a11);
                                                ao.a(this.f47a).a(true, a11);
                                            } else {
                                                af.a(this.f47a).c(a11);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else if (ht.F.f498a.equalsIgnoreCase(iaVar.f583d)) {
                                if (iaVar.f576a == 0) {
                                    synchronized (af.class) {
                                        if (af.a(this.f47a).m106a(a11)) {
                                            af.a(this.f47a).c(a11);
                                            if ("syncing".equals(af.a(this.f47a).a(au.b))) {
                                                af.a(this.f47a).a(au.b, "synced");
                                            }
                                        }
                                    }
                                    break;
                                } else if ("syncing".equals(af.a(this.f47a).a(au.b))) {
                                    synchronized (af.class) {
                                        if (af.a(this.f47a).m106a(a11)) {
                                            if (af.a(this.f47a).a(a11) < 10) {
                                                af.a(this.f47a).b(a11);
                                                ao.a(this.f47a).a(false, a11);
                                            } else {
                                                af.a(this.f47a).c(a11);
                                            }
                                        }
                                    }
                                    break;
                                }
                            } else if (ht.N.f498a.equalsIgnoreCase(iaVar.f583d)) {
                                b(iaVar);
                                break;
                            } else if (ht.B.f498a.equalsIgnoreCase(iaVar.f583d)) {
                                a(iaVar);
                                break;
                            }
                            af.a(this.f47a).c(a11);
                            break;
                        } else if (a4 instanceof ii) {
                            ii iiVar = (ii) a4;
                            if ("registration id expired".equalsIgnoreCase(iiVar.f642d)) {
                                List<String> allAlias = MiPushClient.getAllAlias(this.f47a);
                                List<String> allTopic = MiPushClient.getAllTopic(this.f47a);
                                List<String> allUserAccount = MiPushClient.getAllUserAccount(this.f47a);
                                String acceptTime = MiPushClient.getAcceptTime(this.f47a);
                                com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + iiVar.f642d + StringUtil.ARRAY_ELEMENT_SEPARATOR + iiVar.m475a());
                                MiPushClient.reInitialize(this.f47a, hx.a);
                                for (String str7 : allAlias) {
                                    MiPushClient.removeAlias(this.f47a, str7);
                                    MiPushClient.setAlias(this.f47a, str7, null);
                                }
                                for (String str8 : allTopic) {
                                    MiPushClient.removeTopic(this.f47a, str8);
                                    MiPushClient.subscribe(this.f47a, str8, null);
                                }
                                for (String str9 : allUserAccount) {
                                    MiPushClient.removeAccount(this.f47a, str9);
                                    MiPushClient.setUserAccount(this.f47a, str9, null);
                                }
                                String[] split = acceptTime.split(",");
                                if (split.length == 2) {
                                    MiPushClient.removeAcceptTime(this.f47a);
                                    MiPushClient.addAcceptTime(this.f47a, split[0], split[1]);
                                    break;
                                }
                            } else if (ht.h.f498a.equalsIgnoreCase(iiVar.f642d)) {
                                if (iiVar.m476a() != null && iiVar.m476a().containsKey("app_version")) {
                                    b.m126a(this.f47a).m129a(iiVar.m476a().get("app_version"));
                                    break;
                                }
                            } else if (ht.m.f498a.equalsIgnoreCase(iiVar.f642d)) {
                                if (cif.m468b() && iiVar.m476a() != null && iiVar.m476a().containsKey("awake_info")) {
                                    Context context3 = this.f47a;
                                    o.a(context3, b.m126a(context3).m127a(), ba.a(this.f47a).a(ho.aF.a(), 0), iiVar.m476a().get("awake_info"));
                                    break;
                                }
                            } else {
                                try {
                                    if (ht.n.f498a.equalsIgnoreCase(iiVar.f642d)) {
                                        ih ihVar = new ih();
                                        it.a(ihVar, iiVar.m481a());
                                        bb.a(ba.a(this.f47a), ihVar);
                                    } else if (ht.o.f498a.equalsIgnoreCase(iiVar.f642d)) {
                                        ig igVar = new ig();
                                        it.a(igVar, iiVar.m481a());
                                        bb.a(ba.a(this.f47a), igVar);
                                    } else if (ht.w.f498a.equalsIgnoreCase(iiVar.f642d)) {
                                        av.a(this.f47a, iiVar);
                                        break;
                                    } else if (ht.x.f498a.equalsIgnoreCase(iiVar.f642d)) {
                                        com.xiaomi.channel.commonutils.logger.b.m84a("receive force sync notification");
                                        av.a(this.f47a, false);
                                        break;
                                    } else if (ht.C.f498a.equals(iiVar.f642d)) {
                                        com.xiaomi.channel.commonutils.logger.b.e("resp-type:" + iiVar.f642d + StringUtil.ARRAY_ELEMENT_SEPARATOR + iiVar.m475a());
                                        if (iiVar.m476a() != null) {
                                            int i4 = -2;
                                            if (iiVar.m476a().containsKey(bk.M)) {
                                                String str10 = iiVar.m476a().get(bk.M);
                                                if (!TextUtils.isEmpty(str10)) {
                                                    try {
                                                        i4 = Integer.parseInt(str10);
                                                    } catch (NumberFormatException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }
                                            if (i4 >= -1) {
                                                MiPushClient.clearNotification(this.f47a, i4);
                                            } else {
                                                MiPushClient.clearNotification(this.f47a, iiVar.m476a().containsKey(bk.K) ? iiVar.m476a().get(bk.K) : "", iiVar.m476a().containsKey(bk.L) ? iiVar.m476a().get(bk.L) : "");
                                            }
                                        }
                                        a(iiVar);
                                        break;
                                    } else {
                                        try {
                                            if (ht.K.f498a.equals(iiVar.f642d)) {
                                                ik ikVar2 = new ik();
                                                it.a(ikVar2, iiVar.m481a());
                                                MiPushClient4Hybrid.onReceiveRegisterResult(this.f47a, ikVar2);
                                            } else if (ht.M.f498a.equals(iiVar.f642d)) {
                                                iq iqVar = new iq();
                                                it.a(iqVar, iiVar.m481a());
                                                MiPushClient4Hybrid.onReceiveUnregisterResult(this.f47a, iqVar);
                                            } else if (!ht.P.f498a.equals(iiVar.f642d)) {
                                                if (ht.af.f498a.equals(iiVar.f642d)) {
                                                    com.xiaomi.channel.commonutils.logger.b.b("receive detect msg");
                                                    b(iiVar);
                                                    break;
                                                } else if (com.xiaomi.push.service.i.a(iiVar)) {
                                                    com.xiaomi.channel.commonutils.logger.b.b("receive notification handle by cpra");
                                                    break;
                                                }
                                            }
                                            break;
                                        } catch (iz e2) {
                                            com.xiaomi.channel.commonutils.logger.b.a(e2);
                                            break;
                                        }
                                    }
                                    break;
                                } catch (iz unused) {
                                    break;
                                }
                            }
                        }
                        break;
                }
                return null;
            } catch (u e3) {
                com.xiaomi.channel.commonutils.logger.b.a(e3);
                a(cif);
                a2 = eo.a(this.f47a);
                packageName = this.f47a.getPackageName();
                m304a = en.m304a(i);
                str2 = "19";
                a2.b(packageName, m304a, str, str2);
                s.c(this.f47a, cif, z);
                return null;
            } catch (iz e4) {
                com.xiaomi.channel.commonutils.logger.b.a(e4);
                com.xiaomi.channel.commonutils.logger.b.d("receive a message which action string is not valid. is the reg expired?");
                a2 = eo.a(this.f47a);
                packageName = this.f47a.getPackageName();
                m304a = en.m304a(i);
                str2 = UVEventType.PAY_WALLET_BANNER_SHOW;
                a2.b(packageName, m304a, str, str2);
                s.c(this.f47a, cif, z);
                return null;
            }
        }
        return (PushMessageHandler.a) invokeCommon.objValue;
    }

    private PushMessageHandler.a a(Cif cif, byte[] bArr) {
        InterceptResult invokeLL;
        String str;
        iu a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, this, cif, bArr)) == null) {
            String str2 = null;
            try {
                a2 = ai.a(this.f47a, cif);
            } catch (u e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                str = "message arrived: receive a message but decrypt failed. report when click.";
            } catch (iz e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                str = "message arrived: receive a message which action string is not valid. is the reg expired?";
            }
            if (a2 == null) {
                com.xiaomi.channel.commonutils.logger.b.d("message arrived: receiving an un-recognized message. " + cif.f618a);
                return null;
            }
            hj a3 = cif.a();
            com.xiaomi.channel.commonutils.logger.b.m84a("message arrived: processing an arrived message, action=" + a3);
            if (an.a[a3.ordinal()] != 1) {
                return null;
            }
            if (cif.m468b()) {
                im imVar = (im) a2;
                hv a4 = imVar.a();
                if (a4 != null) {
                    hw hwVar = cif.f619a;
                    if (hwVar != null && hwVar.m427a() != null) {
                        str2 = cif.f619a.f533a.get("jobkey");
                    }
                    MiPushMessage generateMessage = PushMessageHelper.generateMessage(imVar, cif.m460a(), false);
                    generateMessage.setArrivedMessage(true);
                    com.xiaomi.channel.commonutils.logger.b.m84a("message arrived: receive a message, msgid=" + a4.m418a() + ", jobkey=" + str2);
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

    public static am a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (a == null) {
                a = new am(context);
            }
            return a;
        }
        return (am) invokeL.objValue;
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            SharedPreferences sharedPreferences = this.f47a.getSharedPreferences("mipush_extra", 0);
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - sharedPreferences.getLong(Constants.SP_KEY_LAST_REINITIALIZE, 0L)) > FlushManager.ReportTimer.DEFAULT_INTERVAL) {
                MiPushClient.reInitialize(this.f47a, hx.b);
                sharedPreferences.edit().putLong(Constants.SP_KEY_LAST_REINITIALIZE, currentTimeMillis).commit();
            }
        }
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, str) == null) {
            synchronized (f45a) {
                f46a.remove(str);
                b.m126a(context);
                SharedPreferences a2 = b.a(context);
                String a3 = bp.a(f46a, ",");
                SharedPreferences.Editor edit = a2.edit();
                edit.putString("pref_msg_ids", a3);
                com.xiaomi.push.t.a(edit);
            }
        }
    }

    private void a(ia iaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, iaVar) == null) {
            String a2 = iaVar.a();
            com.xiaomi.channel.commonutils.logger.b.b("receive ack " + a2);
            Map<String, String> m441a = iaVar.m441a();
            if (m441a != null) {
                String str = m441a.get("real_source");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b("receive ack : messageId = " + a2 + "  realSource = " + str);
                bx.a(this.f47a).a(a2, str, Boolean.valueOf(iaVar.f576a == 0));
            }
        }
    }

    private void a(Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, cif) == null) {
            com.xiaomi.channel.commonutils.logger.b.m84a("receive a message but decrypt failed. report now.");
            ii iiVar = new ii(cif.m460a().f531a, false);
            iiVar.c(ht.u.f498a);
            iiVar.b(cif.m461a());
            iiVar.d(cif.f625b);
            HashMap hashMap = new HashMap();
            iiVar.f637a = hashMap;
            hashMap.put("regid", MiPushClient.getRegId(this.f47a));
            ao.a(this.f47a).a((ao) iiVar, hj.i, false, (hw) null);
        }
    }

    private void a(ii iiVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, iiVar) == null) {
            ia iaVar = new ia();
            iaVar.c(ht.D.f498a);
            iaVar.a(iiVar.m475a());
            iaVar.a(iiVar.a());
            iaVar.b(iiVar.b());
            iaVar.e(iiVar.c());
            iaVar.a(0L);
            iaVar.d("success clear push message.");
            ao.a(this.f47a).a(iaVar, hj.i, false, true, null, false, this.f47a.getPackageName(), b.m126a(this.f47a).m127a(), false);
        }
    }

    private void a(im imVar, Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, imVar, cif) == null) {
            hw m460a = cif.m460a();
            if (m460a != null) {
                m460a = br.a(m460a.m425a());
            }
            hz hzVar = new hz();
            hzVar.b(imVar.b());
            hzVar.a(imVar.m498a());
            hzVar.a(imVar.a().a());
            if (!TextUtils.isEmpty(imVar.c())) {
                hzVar.c(imVar.c());
            }
            if (!TextUtils.isEmpty(imVar.d())) {
                hzVar.d(imVar.d());
            }
            hzVar.a(it.a(this.f47a, cif));
            ao.a(this.f47a).a((ao) hzVar, hj.f, m460a);
        }
    }

    private void a(String str, long j, e eVar) {
        au a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{str, Long.valueOf(j), eVar}) == null) || (a2 = l.a(eVar)) == null) {
            return;
        }
        if (j == 0) {
            synchronized (af.class) {
                if (af.a(this.f47a).m106a(str)) {
                    af.a(this.f47a).c(str);
                    if ("syncing".equals(af.a(this.f47a).a(a2))) {
                        af.a(this.f47a).a(a2, "synced");
                    }
                }
            }
        } else if (!"syncing".equals(af.a(this.f47a).a(a2))) {
            af.a(this.f47a).c(str);
        } else {
            synchronized (af.class) {
                if (af.a(this.f47a).m106a(str)) {
                    if (af.a(this.f47a).a(str) < 10) {
                        af.a(this.f47a).b(str);
                        ao.a(this.f47a).a(str, a2, eVar);
                    } else {
                        af.a(this.f47a).c(str);
                    }
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m107a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            synchronized (f45a) {
                b.m126a(context);
                SharedPreferences a2 = b.a(context);
                if (f46a == null) {
                    String[] split = a2.getString("pref_msg_ids", "").split(",");
                    f46a = new LinkedList();
                    for (String str2 : split) {
                        f46a.add(str2);
                    }
                }
                if (f46a.contains(str)) {
                    return true;
                }
                f46a.add(str);
                if (f46a.size() > 25) {
                    f46a.poll();
                }
                String a3 = bp.a(f46a, ",");
                SharedPreferences.Editor edit = a2.edit();
                edit.putString("pref_msg_ids", a3);
                com.xiaomi.push.t.a(edit);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m108a(Cif cif) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, this, cif)) == null) {
            Map<String, String> m427a = cif.m460a() == null ? null : cif.m460a().m427a();
            if (m427a == null) {
                return false;
            }
            String str = m427a.get(Constants.EXTRA_KEY_PUSH_SERVER_ACTION);
            return TextUtils.equals(str, Constants.EXTRA_VALUE_HYBRID_MESSAGE) || TextUtils.equals(str, Constants.EXTRA_VALUE_PLATFORM_MESSAGE);
        }
        return invokeL.booleanValue;
    }

    private void b(ia iaVar) {
        long j;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, iaVar) == null) {
            com.xiaomi.channel.commonutils.logger.b.c("ASSEMBLE_PUSH : " + iaVar.toString());
            String a2 = iaVar.a();
            Map<String, String> m441a = iaVar.m441a();
            if (m441a != null) {
                String str = m441a.get(Constants.ASSEMBLE_PUSH_REG_INFO);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (str.contains("brand:" + ag.c.name())) {
                    com.xiaomi.channel.commonutils.logger.b.m84a("ASSEMBLE_PUSH : receive fcm token sync ack");
                    i.b(this.f47a, e.b, str);
                    j = iaVar.f576a;
                    eVar = e.b;
                } else {
                    if (str.contains("brand:" + ag.a.name())) {
                        com.xiaomi.channel.commonutils.logger.b.m84a("ASSEMBLE_PUSH : receive hw token sync ack");
                        i.b(this.f47a, e.a, str);
                        j = iaVar.f576a;
                        eVar = e.a;
                    } else {
                        if (str.contains("brand:" + ag.d.name())) {
                            com.xiaomi.channel.commonutils.logger.b.m84a("ASSEMBLE_PUSH : receive COS token sync ack");
                            i.b(this.f47a, e.c, str);
                            j = iaVar.f576a;
                            eVar = e.c;
                        } else {
                            if (!str.contains("brand:" + ag.e.name())) {
                                return;
                            }
                            com.xiaomi.channel.commonutils.logger.b.m84a("ASSEMBLE_PUSH : receive FTOS token sync ack");
                            i.b(this.f47a, e.d, str);
                            j = iaVar.f576a;
                            eVar = e.d;
                        }
                    }
                }
                a(a2, j, eVar);
            }
        }
    }

    private void b(Cif cif) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, cif) == null) {
            hw m460a = cif.m460a();
            if (m460a != null) {
                m460a = br.a(m460a.m425a());
            }
            hz hzVar = new hz();
            hzVar.b(cif.m461a());
            hzVar.a(m460a.m426a());
            hzVar.a(m460a.m424a());
            if (!TextUtils.isEmpty(m460a.m431b())) {
                hzVar.c(m460a.m431b());
            }
            hzVar.a(it.a(this.f47a, cif));
            ao.a(this.f47a).a((ao) hzVar, hj.f, false, m460a);
        }
    }

    private void b(ii iiVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, iiVar) == null) {
            Map<String, String> m476a = iiVar.m476a();
            if (m476a == null) {
                str = "detect failed because null";
            } else {
                String str2 = (String) ay.a(m476a, "pkgList", (Object) null);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f47a.getSystemService("activity")).getRunningAppProcesses();
                        if (com.xiaomi.push.w.a(runningAppProcesses)) {
                            com.xiaomi.channel.commonutils.logger.b.m84a("detect failed because params illegal");
                            return;
                        }
                        String[] split = str2.split(",");
                        HashMap hashMap = new HashMap();
                        for (String str3 : split) {
                            String[] split2 = str3.split(Constants.WAVE_SEPARATOR);
                            if (split2.length >= 2) {
                                hashMap.put(split2[1], split2[0]);
                            }
                        }
                        w.a aVar = new w.a(Constants.WAVE_SEPARATOR, ",");
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (hashMap.containsKey(runningAppProcessInfo.processName)) {
                                aVar.a((String) hashMap.get(runningAppProcessInfo.processName), String.valueOf(runningAppProcessInfo.importance));
                                hashMap.remove(runningAppProcessInfo.processName);
                            }
                        }
                        if (aVar.toString().length() <= 0) {
                            com.xiaomi.channel.commonutils.logger.b.b("detect failed because no alive process");
                            return;
                        }
                        ii iiVar2 = new ii();
                        iiVar2.a(iiVar.m475a());
                        iiVar2.b(iiVar.b());
                        iiVar2.d(iiVar.c());
                        iiVar2.c(ht.ag.f498a);
                        HashMap hashMap2 = new HashMap();
                        iiVar2.f637a = hashMap2;
                        hashMap2.put("alive", aVar.toString());
                        if (Boolean.parseBoolean((String) ay.a(m476a, "reportNotAliveApp", "false")) && hashMap.size() > 0) {
                            w.a aVar2 = new w.a("", ",");
                            for (String str4 : hashMap.keySet()) {
                                aVar2.a((String) hashMap.get(str4), "");
                            }
                            iiVar2.f637a.put("notAlive", aVar2.toString());
                        }
                        ao.a(this.f47a).a((ao) iiVar2, hj.i, false, (hw) null);
                        return;
                    } catch (Throwable th) {
                        com.xiaomi.channel.commonutils.logger.b.m84a("detect failed " + th);
                        return;
                    }
                }
                str = "detect failed because empty";
            }
            com.xiaomi.channel.commonutils.logger.b.m84a(str);
        }
    }

    public PushMessageHandler.a a(Intent intent) {
        InterceptResult invokeL;
        String str;
        eo a2;
        String packageName;
        String str2;
        eo a3;
        String packageName2;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            String action = intent.getAction();
            com.xiaomi.channel.commonutils.logger.b.m84a("receive an intent from server, action=" + action);
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
                    eo.a(this.f47a).a(this.f47a.getPackageName(), intent, "12");
                    return null;
                }
                Cif cif = new Cif();
                try {
                    it.a(cif, byteArrayExtra);
                    b m126a = b.m126a(this.f47a);
                    hw m460a = cif.m460a();
                    if (cif.a() == hj.e && m460a != null && !m126a.m137e() && !booleanExtra) {
                        m460a.a("mrt", stringExtra);
                        m460a.a("mat", Long.toString(System.currentTimeMillis()));
                        if (m108a(cif)) {
                            com.xiaomi.channel.commonutils.logger.b.b("this is a mina's message, ack later");
                            m460a.a(Constants.EXTRA_KEY_HYBRID_MESSAGE_TS, String.valueOf(m460a.m424a()));
                            m460a.a(Constants.EXTRA_KEY_HYBRID_DEVICE_STATUS, String.valueOf((int) it.a(this.f47a, cif)));
                        } else {
                            b(cif);
                        }
                    }
                    if (cif.a() == hj.e && !cif.m468b()) {
                        if (com.xiaomi.push.service.al.m604a(cif)) {
                            Object[] objArr = new Object[2];
                            objArr[0] = cif.b();
                            objArr[1] = m460a != null ? m460a.m426a() : "";
                            com.xiaomi.channel.commonutils.logger.b.m84a(String.format("drop an un-encrypted wake-up messages. %1$s, %2$s", objArr));
                            a3 = eo.a(this.f47a);
                            packageName2 = this.f47a.getPackageName();
                            format = String.format("13: %1$s", cif.b());
                        } else {
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = cif.b();
                            objArr2[1] = m460a != null ? m460a.m426a() : "";
                            com.xiaomi.channel.commonutils.logger.b.m84a(String.format("drop an un-encrypted messages. %1$s, %2$s", objArr2));
                            a3 = eo.a(this.f47a);
                            packageName2 = this.f47a.getPackageName();
                            format = String.format("14: %1$s", cif.b());
                        }
                        a3.a(packageName2, intent, format);
                        s.a(this.f47a, cif, booleanExtra);
                        return null;
                    }
                    if (cif.a() == hj.e && cif.m468b() && com.xiaomi.push.service.al.m604a(cif) && (!booleanExtra || m460a == null || m460a.m427a() == null || !m460a.m427a().containsKey("notify_effect"))) {
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = cif.b();
                        objArr3[1] = m460a != null ? m460a.m426a() : "";
                        com.xiaomi.channel.commonutils.logger.b.m84a(String.format("drop a wake-up messages which not has 'notify_effect' attr. %1$s, %2$s", objArr3));
                        eo.a(this.f47a).a(this.f47a.getPackageName(), intent, String.format("25: %1$s", cif.b()));
                        s.b(this.f47a, cif, booleanExtra);
                        return null;
                    }
                    if (m126a.m135c() || cif.f618a == hj.a) {
                        if (!m126a.m135c() || !m126a.m138f()) {
                            return a(cif, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                        }
                        if (cif.f618a != hj.b) {
                            s.e(this.f47a, cif, booleanExtra);
                            MiPushClient.unregisterPush(this.f47a);
                        } else if (cif.m468b()) {
                            m126a.m128a();
                            MiPushClient.clearExtras(this.f47a);
                            PushMessageHandler.a();
                        } else {
                            com.xiaomi.channel.commonutils.logger.b.d("receiving an un-encrypt unregistration message");
                        }
                    } else if (com.xiaomi.push.service.al.m604a(cif)) {
                        return a(cif, booleanExtra, byteArrayExtra, stringExtra2, intExtra, intent);
                    } else {
                        s.e(this.f47a, cif, booleanExtra);
                        boolean m136d = m126a.m136d();
                        com.xiaomi.channel.commonutils.logger.b.d("receive message without registration. need re-register!registered?" + m136d);
                        eo.a(this.f47a).a(this.f47a.getPackageName(), intent, "15");
                        if (m136d) {
                            a();
                        }
                    }
                } catch (iz e) {
                    e = e;
                    a2 = eo.a(this.f47a);
                    packageName = this.f47a.getPackageName();
                    str2 = "16";
                    a2.a(packageName, intent, str2);
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    return null;
                } catch (Exception e2) {
                    e = e2;
                    a2 = eo.a(this.f47a);
                    packageName = this.f47a.getPackageName();
                    str2 = "17";
                    a2.a(packageName, intent, str2);
                    com.xiaomi.channel.commonutils.logger.b.a(e);
                    return null;
                }
            } else if ("com.xiaomi.mipush.ERROR".equals(action)) {
                MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
                Cif cif2 = new Cif();
                try {
                    byte[] byteArrayExtra2 = intent.getByteArrayExtra("mipush_payload");
                    if (byteArrayExtra2 != null) {
                        it.a(cif2, byteArrayExtra2);
                    }
                } catch (iz unused) {
                }
                miPushCommandMessage.setCommand(String.valueOf(cif2.a()));
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
                Cif cif3 = new Cif();
                try {
                    it.a(cif3, byteArrayExtra3);
                    b m126a2 = b.m126a(this.f47a);
                    if (com.xiaomi.push.service.al.m604a(cif3)) {
                        str = "message arrived: receive ignore reg message, ignore!";
                    } else if (!m126a2.m135c()) {
                        str = "message arrived: receive message without registration. need unregister or re-register!";
                    } else if (!m126a2.m135c() || !m126a2.m138f()) {
                        return a(cif3, byteArrayExtra3);
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
