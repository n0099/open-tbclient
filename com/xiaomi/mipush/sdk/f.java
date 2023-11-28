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
    public Context f76a;

    /* renamed from: a  reason: collision with other field name */
    public PushConfiguration f77a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f79a = false;

    /* renamed from: a  reason: collision with other field name */
    public Map<e, AbstractPushManager> f78a = new HashMap();

    public f(Context context) {
        this.f76a = context.getApplicationContext();
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
        PushConfiguration pushConfiguration = this.f77a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                StringBuilder sb = new StringBuilder();
                sb.append("ASSEMBLE_PUSH : ");
                sb.append(" HW user switch : " + this.f77a.getOpenHmsPush() + " HW online switch : " + i.m258a(this.f76a, e.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + n.m262a(this.f76a));
                com.xiaomi.channel.commonutils.logger.b.m190a(sb.toString());
            }
            if (this.f77a.getOpenHmsPush() && i.m258a(this.f76a, e.ASSEMBLE_PUSH_HUAWEI) && n.m262a(this.f76a)) {
                if (!m252a(e.ASSEMBLE_PUSH_HUAWEI)) {
                    e eVar = e.ASSEMBLE_PUSH_HUAWEI;
                    a(eVar, ak.a(this.f76a, eVar));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m252a(e.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(e.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m251a(e.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f77a.getOpenFCMPush()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ASSEMBLE_PUSH : ");
                sb2.append(" FCM user switch : " + this.f77a.getOpenFCMPush() + " FCM online switch : " + i.m258a(this.f76a, e.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + n.b(this.f76a));
                com.xiaomi.channel.commonutils.logger.b.m190a(sb2.toString());
            }
            if (this.f77a.getOpenFCMPush() && i.m258a(this.f76a, e.ASSEMBLE_PUSH_FCM) && n.b(this.f76a)) {
                if (!m252a(e.ASSEMBLE_PUSH_FCM)) {
                    e eVar2 = e.ASSEMBLE_PUSH_FCM;
                    a(eVar2, ak.a(this.f76a, eVar2));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m252a(e.ASSEMBLE_PUSH_FCM) && (a3 = a(e.ASSEMBLE_PUSH_FCM)) != null) {
                m251a(e.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f77a.getOpenCOSPush()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("ASSEMBLE_PUSH : ");
                sb3.append(" COS user switch : " + this.f77a.getOpenCOSPush() + " COS online switch : " + i.m258a(this.f76a, e.ASSEMBLE_PUSH_COS) + " COS isSupport : " + n.c(this.f76a));
                com.xiaomi.channel.commonutils.logger.b.m190a(sb3.toString());
            }
            if (this.f77a.getOpenCOSPush() && i.m258a(this.f76a, e.ASSEMBLE_PUSH_COS) && n.c(this.f76a)) {
                e eVar3 = e.ASSEMBLE_PUSH_COS;
                a(eVar3, ak.a(this.f76a, eVar3));
            } else if (m252a(e.ASSEMBLE_PUSH_COS) && (a4 = a(e.ASSEMBLE_PUSH_COS)) != null) {
                m251a(e.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f77a.getOpenFTOSPush() && i.m258a(this.f76a, e.ASSEMBLE_PUSH_FTOS) && n.d(this.f76a)) {
                e eVar4 = e.ASSEMBLE_PUSH_FTOS;
                a(eVar4, ak.a(this.f76a, eVar4));
            } else if (!m252a(e.ASSEMBLE_PUSH_FTOS) || (a5 = a(e.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m251a(e.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(e eVar) {
        return this.f78a.get(eVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f77a = pushConfiguration;
        this.f79a = ba.a(this.f76a).a(hm.AggregatePushSwitch.a(), true);
        if (this.f77a.getOpenHmsPush() || this.f77a.getOpenFCMPush() || this.f77a.getOpenCOSPush() || this.f77a.getOpenFTOSPush()) {
            ba.a(this.f76a).a(new g(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m251a(e eVar) {
        this.f78a.remove(eVar);
    }

    public void a(e eVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f78a.containsKey(eVar)) {
                this.f78a.remove(eVar);
            }
            this.f78a.put(eVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m252a(e eVar) {
        return this.f78a.containsKey(eVar);
    }

    public boolean b(e eVar) {
        int i = h.a[eVar.ordinal()];
        boolean z = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f77a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        } else if (i == 2) {
            PushConfiguration pushConfiguration2 = this.f77a;
            if (pushConfiguration2 != null) {
                return pushConfiguration2.getOpenFCMPush();
            }
            return false;
        } else {
            if (i == 3) {
                PushConfiguration pushConfiguration3 = this.f77a;
                if (pushConfiguration3 != null) {
                    z = pushConfiguration3.getOpenCOSPush();
                }
            } else if (i != 4) {
                return false;
            }
            PushConfiguration pushConfiguration4 = this.f77a;
            return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : z;
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m190a("ASSEMBLE_PUSH : assemble push register");
        if (this.f78a.size() <= 0) {
            a();
        }
        if (this.f78a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f78a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            i.m254a(this.f76a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m190a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f78a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f78a.clear();
    }
}
