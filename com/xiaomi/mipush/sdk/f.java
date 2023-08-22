package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hm;
import com.xiaomi.push.service.ba;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class f implements AbstractPushManager {
    public static volatile f a;

    /* renamed from: a  reason: collision with other field name */
    public Context f81a;

    /* renamed from: a  reason: collision with other field name */
    public PushConfiguration f82a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f84a = false;

    /* renamed from: a  reason: collision with other field name */
    public Map<e, AbstractPushManager> f83a = new HashMap();

    public f(Context context) {
        this.f81a = context.getApplicationContext();
    }

    public static f a(Context context) {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f(context);
                }
            }
        }
        return a;
    }

    private void a() {
        AbstractPushManager a2;
        AbstractPushManager a3;
        AbstractPushManager a4;
        AbstractPushManager a5;
        PushConfiguration pushConfiguration = this.f82a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder sb = new StringBuilder();
                sb.append("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f82a.getOpenHmsPush() + " HW online switch : " + i.m248a(this.f81a, e.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + n.m252a(this.f81a));
                com.xiaomi.channel.commonutils.logger.b.m180a(sb.toString());
            }
            if (this.f82a.getOpenHmsPush() && i.m248a(this.f81a, e.ASSEMBLE_PUSH_HUAWEI) && n.m252a(this.f81a)) {
                if (!m242a(e.ASSEMBLE_PUSH_HUAWEI)) {
                    e eVar = e.ASSEMBLE_PUSH_HUAWEI;
                    a(eVar, ak.a(this.f81a, eVar));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m242a(e.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(e.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m241a(e.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f82a.getOpenFCMPush()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ASSEMBLE_PUSH : ");
                sb2.append(" FCM user switch : " + this.f82a.getOpenFCMPush() + " FCM online switch : " + i.m248a(this.f81a, e.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + n.b(this.f81a));
                com.xiaomi.channel.commonutils.logger.b.m180a(sb2.toString());
            }
            if (this.f82a.getOpenFCMPush() && i.m248a(this.f81a, e.ASSEMBLE_PUSH_FCM) && n.b(this.f81a)) {
                if (!m242a(e.ASSEMBLE_PUSH_FCM)) {
                    e eVar2 = e.ASSEMBLE_PUSH_FCM;
                    a(eVar2, ak.a(this.f81a, eVar2));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m242a(e.ASSEMBLE_PUSH_FCM) && (a3 = a(e.ASSEMBLE_PUSH_FCM)) != null) {
                m241a(e.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f82a.getOpenCOSPush()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("ASSEMBLE_PUSH : ");
                sb3.append(" COS user switch : " + this.f82a.getOpenCOSPush() + " COS online switch : " + i.m248a(this.f81a, e.ASSEMBLE_PUSH_COS) + " COS isSupport : " + n.c(this.f81a));
                com.xiaomi.channel.commonutils.logger.b.m180a(sb3.toString());
            }
            if (this.f82a.getOpenCOSPush() && i.m248a(this.f81a, e.ASSEMBLE_PUSH_COS) && n.c(this.f81a)) {
                e eVar3 = e.ASSEMBLE_PUSH_COS;
                a(eVar3, ak.a(this.f81a, eVar3));
            } else if (m242a(e.ASSEMBLE_PUSH_COS) && (a4 = a(e.ASSEMBLE_PUSH_COS)) != null) {
                m241a(e.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f82a.getOpenFTOSPush() && i.m248a(this.f81a, e.ASSEMBLE_PUSH_FTOS) && n.d(this.f81a)) {
                e eVar4 = e.ASSEMBLE_PUSH_FTOS;
                a(eVar4, ak.a(this.f81a, eVar4));
            } else if (!m242a(e.ASSEMBLE_PUSH_FTOS) || (a5 = a(e.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m241a(e.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(e eVar) {
        return this.f83a.get(eVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f82a = pushConfiguration;
        this.f84a = ba.a(this.f81a).a(hm.AggregatePushSwitch.a(), true);
        if (this.f82a.getOpenHmsPush() || this.f82a.getOpenFCMPush() || this.f82a.getOpenCOSPush() || this.f82a.getOpenFTOSPush()) {
            ba.a(this.f81a).a(new g(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m241a(e eVar) {
        this.f83a.remove(eVar);
    }

    public void a(e eVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f83a.containsKey(eVar)) {
                this.f83a.remove(eVar);
            }
            this.f83a.put(eVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m242a(e eVar) {
        return this.f83a.containsKey(eVar);
    }

    public boolean b(e eVar) {
        int i = h.a[eVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f82a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        } else if (i == 2) {
            PushConfiguration pushConfiguration2 = this.f82a;
            if (pushConfiguration2 != null) {
                return pushConfiguration2.getOpenFCMPush();
            }
            return false;
        } else {
            if (i == 3) {
                PushConfiguration pushConfiguration3 = this.f82a;
                if (pushConfiguration3 != null) {
                    z = pushConfiguration3.getOpenCOSPush();
                }
            } else if (i != 4) {
                return false;
            }
            PushConfiguration pushConfiguration4 = this.f82a;
            return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : z;
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m180a("ASSEMBLE_PUSH : assemble push register");
        if (this.f83a.size() <= 0) {
            a();
        }
        if (this.f83a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f83a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            i.m244a(this.f81a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m180a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f83a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f83a.clear();
    }
}
