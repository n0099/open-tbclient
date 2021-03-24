package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hk;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class f implements AbstractPushManager {

    /* renamed from: a  reason: collision with root package name */
    public static volatile f f40192a;

    /* renamed from: a  reason: collision with other field name */
    public Context f86a;

    /* renamed from: a  reason: collision with other field name */
    public PushConfiguration f87a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f89a = false;

    /* renamed from: a  reason: collision with other field name */
    public Map<e, AbstractPushManager> f88a = new HashMap();

    public f(Context context) {
        this.f86a = context.getApplicationContext();
    }

    public static f a(Context context) {
        if (f40192a == null) {
            synchronized (f.class) {
                if (f40192a == null) {
                    f40192a = new f(context);
                }
            }
        }
        return f40192a;
    }

    private void a() {
        AbstractPushManager a2;
        AbstractPushManager a3;
        AbstractPushManager a4;
        AbstractPushManager a5;
        PushConfiguration pushConfiguration = this.f87a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder sb = new StringBuilder();
                sb.append("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f87a.getOpenHmsPush() + " HW online switch : " + i.m114a(this.f86a, e.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + af.HUAWEI.equals(n.a(this.f86a)));
                com.xiaomi.channel.commonutils.logger.b.m51a(sb.toString());
            }
            if (this.f87a.getOpenHmsPush() && i.m114a(this.f86a, e.ASSEMBLE_PUSH_HUAWEI) && af.HUAWEI.equals(n.a(this.f86a))) {
                if (!m110a(e.ASSEMBLE_PUSH_HUAWEI)) {
                    e eVar = e.ASSEMBLE_PUSH_HUAWEI;
                    a(eVar, aj.a(this.f86a, eVar));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m110a(e.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(e.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m109a(e.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f87a.getOpenFCMPush()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ASSEMBLE_PUSH : ");
                sb2.append(" FCM user switch : " + this.f87a.getOpenFCMPush() + " FCM online switch : " + i.m114a(this.f86a, e.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + n.m117a(this.f86a));
                com.xiaomi.channel.commonutils.logger.b.m51a(sb2.toString());
            }
            if (this.f87a.getOpenFCMPush() && i.m114a(this.f86a, e.ASSEMBLE_PUSH_FCM) && n.m117a(this.f86a)) {
                if (!m110a(e.ASSEMBLE_PUSH_FCM)) {
                    e eVar2 = e.ASSEMBLE_PUSH_FCM;
                    a(eVar2, aj.a(this.f86a, eVar2));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m110a(e.ASSEMBLE_PUSH_FCM) && (a3 = a(e.ASSEMBLE_PUSH_FCM)) != null) {
                m109a(e.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f87a.getOpenCOSPush()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("ASSEMBLE_PUSH : ");
                sb3.append(" COS user switch : " + this.f87a.getOpenCOSPush() + " COS online switch : " + i.m114a(this.f86a, e.ASSEMBLE_PUSH_COS) + " COS isSupport : " + n.b(this.f86a));
                com.xiaomi.channel.commonutils.logger.b.m51a(sb3.toString());
            }
            if (this.f87a.getOpenCOSPush() && i.m114a(this.f86a, e.ASSEMBLE_PUSH_COS) && n.b(this.f86a)) {
                e eVar3 = e.ASSEMBLE_PUSH_COS;
                a(eVar3, aj.a(this.f86a, eVar3));
            } else if (m110a(e.ASSEMBLE_PUSH_COS) && (a4 = a(e.ASSEMBLE_PUSH_COS)) != null) {
                m109a(e.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f87a.getOpenFTOSPush() && i.m114a(this.f86a, e.ASSEMBLE_PUSH_FTOS) && n.c(this.f86a)) {
                e eVar4 = e.ASSEMBLE_PUSH_FTOS;
                a(eVar4, aj.a(this.f86a, eVar4));
            } else if (!m110a(e.ASSEMBLE_PUSH_FTOS) || (a5 = a(e.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m109a(e.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(e eVar) {
        return this.f88a.get(eVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f87a = pushConfiguration;
        this.f89a = com.xiaomi.push.service.aq.a(this.f86a).a(hk.AggregatePushSwitch.a(), true);
        if (this.f87a.getOpenHmsPush() || this.f87a.getOpenFCMPush() || this.f87a.getOpenCOSPush()) {
            com.xiaomi.push.service.aq.a(this.f86a).a(new g(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m109a(e eVar) {
        this.f88a.remove(eVar);
    }

    public void a(e eVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f88a.containsKey(eVar)) {
                this.f88a.remove(eVar);
            }
            this.f88a.put(eVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m110a(e eVar) {
        return this.f88a.containsKey(eVar);
    }

    public boolean b(e eVar) {
        int i = h.f40194a[eVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f87a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        } else if (i == 2) {
            PushConfiguration pushConfiguration2 = this.f87a;
            if (pushConfiguration2 != null) {
                return pushConfiguration2.getOpenFCMPush();
            }
            return false;
        } else {
            if (i == 3) {
                PushConfiguration pushConfiguration3 = this.f87a;
                if (pushConfiguration3 != null) {
                    z = pushConfiguration3.getOpenCOSPush();
                }
            } else if (i != 4) {
                return false;
            }
            PushConfiguration pushConfiguration4 = this.f87a;
            return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : z;
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m51a("ASSEMBLE_PUSH : assemble push register");
        if (this.f88a.size() <= 0) {
            a();
        }
        if (this.f88a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f88a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            i.m111a(this.f86a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m51a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f88a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f88a.clear();
    }
}
