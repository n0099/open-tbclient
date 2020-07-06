package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hr;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class e implements AbstractPushManager {
    private static volatile e a;

    /* renamed from: a  reason: collision with other field name */
    private Context f78a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f79a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f81a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<d, AbstractPushManager> f80a = new HashMap();

    private e(Context context) {
        this.f78a = context.getApplicationContext();
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
        if (this.f79a != null) {
            if (this.f79a.getOpenHmsPush()) {
                com.xiaomi.channel.commonutils.logger.b.m48a("ASSEMBLE_PUSH : " + (" HW user switch : " + this.f79a.getOpenHmsPush() + " HW online switch : " + h.m109a(this.f78a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ah.HUAWEI.equals(m.a(this.f78a))));
            }
            if (this.f79a.getOpenHmsPush() && h.m109a(this.f78a, d.ASSEMBLE_PUSH_HUAWEI) && ah.HUAWEI.equals(m.a(this.f78a))) {
                if (!m105a(d.ASSEMBLE_PUSH_HUAWEI)) {
                    a(d.ASSEMBLE_PUSH_HUAWEI, al.a(this.f78a, d.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m105a(d.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(d.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m104a(d.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f79a.getOpenFCMPush()) {
                com.xiaomi.channel.commonutils.logger.b.m48a("ASSEMBLE_PUSH : " + (" FCM user switch : " + this.f79a.getOpenFCMPush() + " FCM online switch : " + h.m109a(this.f78a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + m.m112a(this.f78a)));
            }
            if (this.f79a.getOpenFCMPush() && h.m109a(this.f78a, d.ASSEMBLE_PUSH_FCM) && m.m112a(this.f78a)) {
                if (!m105a(d.ASSEMBLE_PUSH_FCM)) {
                    a(d.ASSEMBLE_PUSH_FCM, al.a(this.f78a, d.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m105a(d.ASSEMBLE_PUSH_FCM) && (a3 = a(d.ASSEMBLE_PUSH_FCM)) != null) {
                m104a(d.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f79a.getOpenCOSPush()) {
                com.xiaomi.channel.commonutils.logger.b.m48a("ASSEMBLE_PUSH : " + (" COS user switch : " + this.f79a.getOpenCOSPush() + " COS online switch : " + h.m109a(this.f78a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + m.b(this.f78a)));
            }
            if (this.f79a.getOpenCOSPush() && h.m109a(this.f78a, d.ASSEMBLE_PUSH_COS) && m.b(this.f78a)) {
                a(d.ASSEMBLE_PUSH_COS, al.a(this.f78a, d.ASSEMBLE_PUSH_COS));
            } else if (m105a(d.ASSEMBLE_PUSH_COS) && (a4 = a(d.ASSEMBLE_PUSH_COS)) != null) {
                m104a(d.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f79a.getOpenFTOSPush() && h.m109a(this.f78a, d.ASSEMBLE_PUSH_FTOS) && m.c(this.f78a)) {
                a(d.ASSEMBLE_PUSH_FTOS, al.a(this.f78a, d.ASSEMBLE_PUSH_FTOS));
            } else if (!m105a(d.ASSEMBLE_PUSH_FTOS) || (a5 = a(d.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m104a(d.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(d dVar) {
        return this.f80a.get(dVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f79a = pushConfiguration;
        this.f81a = com.xiaomi.push.service.ak.a(this.f78a).a(hr.AggregatePushSwitch.a(), true);
        if (this.f79a.getOpenHmsPush() || this.f79a.getOpenFCMPush() || this.f79a.getOpenCOSPush()) {
            com.xiaomi.push.service.ak.a(this.f78a).a(new f(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m104a(d dVar) {
        this.f80a.remove(dVar);
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f80a.containsKey(dVar)) {
                this.f80a.remove(dVar);
            }
            this.f80a.put(dVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m105a(d dVar) {
        return this.f80a.containsKey(dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean b(d dVar) {
        boolean z = false;
        switch (g.a[dVar.ordinal()]) {
            case 1:
                if (this.f79a != null) {
                    return this.f79a.getOpenHmsPush();
                }
                return false;
            case 2:
                if (this.f79a != null) {
                    return this.f79a.getOpenFCMPush();
                }
                return false;
            case 3:
                if (this.f79a != null) {
                    z = this.f79a.getOpenCOSPush();
                    break;
                }
                break;
            case 4:
                break;
            default:
                return false;
        }
        return this.f79a != null ? this.f79a.getOpenFTOSPush() : z;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m48a("ASSEMBLE_PUSH : assemble push register");
        if (this.f80a.size() <= 0) {
            a();
        }
        if (this.f80a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f80a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            h.m106a(this.f78a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m48a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f80a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f80a.clear();
    }
}
