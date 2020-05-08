package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hr;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class e implements AbstractPushManager {
    private static volatile e a;

    /* renamed from: a  reason: collision with other field name */
    private Context f71a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f72a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f74a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<d, AbstractPushManager> f73a = new HashMap();

    private e(Context context) {
        this.f71a = context.getApplicationContext();
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
        if (this.f72a != null) {
            if (this.f72a.getOpenHmsPush()) {
                com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : " + (" HW user switch : " + this.f72a.getOpenHmsPush() + " HW online switch : " + h.m111a(this.f71a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ah.HUAWEI.equals(m.a(this.f71a))));
            }
            if (this.f72a.getOpenHmsPush() && h.m111a(this.f71a, d.ASSEMBLE_PUSH_HUAWEI) && ah.HUAWEI.equals(m.a(this.f71a))) {
                if (!m107a(d.ASSEMBLE_PUSH_HUAWEI)) {
                    a(d.ASSEMBLE_PUSH_HUAWEI, al.a(this.f71a, d.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m107a(d.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(d.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m106a(d.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f72a.getOpenFCMPush()) {
                com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : " + (" FCM user switch : " + this.f72a.getOpenFCMPush() + " FCM online switch : " + h.m111a(this.f71a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + m.m114a(this.f71a)));
            }
            if (this.f72a.getOpenFCMPush() && h.m111a(this.f71a, d.ASSEMBLE_PUSH_FCM) && m.m114a(this.f71a)) {
                if (!m107a(d.ASSEMBLE_PUSH_FCM)) {
                    a(d.ASSEMBLE_PUSH_FCM, al.a(this.f71a, d.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m107a(d.ASSEMBLE_PUSH_FCM) && (a3 = a(d.ASSEMBLE_PUSH_FCM)) != null) {
                m106a(d.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f72a.getOpenCOSPush()) {
                com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : " + (" COS user switch : " + this.f72a.getOpenCOSPush() + " COS online switch : " + h.m111a(this.f71a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + m.b(this.f71a)));
            }
            if (this.f72a.getOpenCOSPush() && h.m111a(this.f71a, d.ASSEMBLE_PUSH_COS) && m.b(this.f71a)) {
                a(d.ASSEMBLE_PUSH_COS, al.a(this.f71a, d.ASSEMBLE_PUSH_COS));
            } else if (m107a(d.ASSEMBLE_PUSH_COS) && (a4 = a(d.ASSEMBLE_PUSH_COS)) != null) {
                m106a(d.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f72a.getOpenFTOSPush() && h.m111a(this.f71a, d.ASSEMBLE_PUSH_FTOS) && m.c(this.f71a)) {
                a(d.ASSEMBLE_PUSH_FTOS, al.a(this.f71a, d.ASSEMBLE_PUSH_FTOS));
            } else if (!m107a(d.ASSEMBLE_PUSH_FTOS) || (a5 = a(d.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m106a(d.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(d dVar) {
        return this.f73a.get(dVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f72a = pushConfiguration;
        this.f74a = com.xiaomi.push.service.ak.a(this.f71a).a(hr.AggregatePushSwitch.a(), true);
        if (this.f72a.getOpenHmsPush() || this.f72a.getOpenFCMPush() || this.f72a.getOpenCOSPush()) {
            com.xiaomi.push.service.ak.a(this.f71a).a(new f(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m106a(d dVar) {
        this.f73a.remove(dVar);
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f73a.containsKey(dVar)) {
                this.f73a.remove(dVar);
            }
            this.f73a.put(dVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m107a(d dVar) {
        return this.f73a.containsKey(dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean b(d dVar) {
        boolean z = false;
        switch (g.a[dVar.ordinal()]) {
            case 1:
                if (this.f72a != null) {
                    return this.f72a.getOpenHmsPush();
                }
                return false;
            case 2:
                if (this.f72a != null) {
                    return this.f72a.getOpenFCMPush();
                }
                return false;
            case 3:
                if (this.f72a != null) {
                    z = this.f72a.getOpenCOSPush();
                    break;
                }
                break;
            case 4:
                break;
            default:
                return false;
        }
        return this.f72a != null ? this.f72a.getOpenFTOSPush() : z;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : assemble push register");
        if (this.f73a.size() <= 0) {
            a();
        }
        if (this.f73a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f73a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            h.m108a(this.f71a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m50a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f73a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f73a.clear();
    }
}
