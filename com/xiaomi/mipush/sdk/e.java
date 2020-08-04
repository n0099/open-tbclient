package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hr;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes9.dex */
public class e implements AbstractPushManager {
    private static volatile e a;

    /* renamed from: a  reason: collision with other field name */
    private Context f77a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f78a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f80a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<d, AbstractPushManager> f79a = new HashMap();

    private e(Context context) {
        this.f77a = context.getApplicationContext();
    }

    public static e a(Context context) {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e(context);
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
        if (this.f78a != null) {
            if (this.f78a.getOpenHmsPush()) {
                com.xiaomi.channel.commonutils.logger.b.m49a("ASSEMBLE_PUSH : " + (" HW user switch : " + this.f78a.getOpenHmsPush() + " HW online switch : " + h.m110a(this.f77a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ah.HUAWEI.equals(m.a(this.f77a))));
            }
            if (this.f78a.getOpenHmsPush() && h.m110a(this.f77a, d.ASSEMBLE_PUSH_HUAWEI) && ah.HUAWEI.equals(m.a(this.f77a))) {
                if (!m106a(d.ASSEMBLE_PUSH_HUAWEI)) {
                    a(d.ASSEMBLE_PUSH_HUAWEI, al.a(this.f77a, d.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m106a(d.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(d.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m105a(d.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f78a.getOpenFCMPush()) {
                com.xiaomi.channel.commonutils.logger.b.m49a("ASSEMBLE_PUSH : " + (" FCM user switch : " + this.f78a.getOpenFCMPush() + " FCM online switch : " + h.m110a(this.f77a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + m.m113a(this.f77a)));
            }
            if (this.f78a.getOpenFCMPush() && h.m110a(this.f77a, d.ASSEMBLE_PUSH_FCM) && m.m113a(this.f77a)) {
                if (!m106a(d.ASSEMBLE_PUSH_FCM)) {
                    a(d.ASSEMBLE_PUSH_FCM, al.a(this.f77a, d.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m106a(d.ASSEMBLE_PUSH_FCM) && (a3 = a(d.ASSEMBLE_PUSH_FCM)) != null) {
                m105a(d.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f78a.getOpenCOSPush()) {
                com.xiaomi.channel.commonutils.logger.b.m49a("ASSEMBLE_PUSH : " + (" COS user switch : " + this.f78a.getOpenCOSPush() + " COS online switch : " + h.m110a(this.f77a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + m.b(this.f77a)));
            }
            if (this.f78a.getOpenCOSPush() && h.m110a(this.f77a, d.ASSEMBLE_PUSH_COS) && m.b(this.f77a)) {
                a(d.ASSEMBLE_PUSH_COS, al.a(this.f77a, d.ASSEMBLE_PUSH_COS));
            } else if (m106a(d.ASSEMBLE_PUSH_COS) && (a4 = a(d.ASSEMBLE_PUSH_COS)) != null) {
                m105a(d.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f78a.getOpenFTOSPush() && h.m110a(this.f77a, d.ASSEMBLE_PUSH_FTOS) && m.c(this.f77a)) {
                a(d.ASSEMBLE_PUSH_FTOS, al.a(this.f77a, d.ASSEMBLE_PUSH_FTOS));
            } else if (!m106a(d.ASSEMBLE_PUSH_FTOS) || (a5 = a(d.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m105a(d.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(d dVar) {
        return this.f79a.get(dVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f78a = pushConfiguration;
        this.f80a = com.xiaomi.push.service.ak.a(this.f77a).a(hr.AggregatePushSwitch.a(), true);
        if (this.f78a.getOpenHmsPush() || this.f78a.getOpenFCMPush() || this.f78a.getOpenCOSPush()) {
            com.xiaomi.push.service.ak.a(this.f77a).a(new f(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m105a(d dVar) {
        this.f79a.remove(dVar);
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f79a.containsKey(dVar)) {
                this.f79a.remove(dVar);
            }
            this.f79a.put(dVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m106a(d dVar) {
        return this.f79a.containsKey(dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean b(d dVar) {
        boolean z = false;
        switch (g.a[dVar.ordinal()]) {
            case 1:
                if (this.f78a != null) {
                    return this.f78a.getOpenHmsPush();
                }
                return false;
            case 2:
                if (this.f78a != null) {
                    return this.f78a.getOpenFCMPush();
                }
                return false;
            case 3:
                if (this.f78a != null) {
                    z = this.f78a.getOpenCOSPush();
                    break;
                }
                break;
            case 4:
                break;
            default:
                return false;
        }
        return this.f78a != null ? this.f78a.getOpenFTOSPush() : z;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m49a("ASSEMBLE_PUSH : assemble push register");
        if (this.f79a.size() <= 0) {
            a();
        }
        if (this.f79a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f79a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            h.m107a(this.f77a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m49a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f79a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f79a.clear();
    }
}
