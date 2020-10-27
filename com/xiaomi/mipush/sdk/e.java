package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hr;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes12.dex */
public class e implements AbstractPushManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f4763a;

    /* renamed from: a  reason: collision with other field name */
    private Context f70a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f71a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f73a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<d, AbstractPushManager> f72a = new HashMap();

    private e(Context context) {
        this.f70a = context.getApplicationContext();
    }

    public static e a(Context context) {
        if (f4763a == null) {
            synchronized (e.class) {
                if (f4763a == null) {
                    f4763a = new e(context);
                }
            }
        }
        return f4763a;
    }

    private void a() {
        AbstractPushManager a2;
        AbstractPushManager a3;
        AbstractPushManager a4;
        AbstractPushManager a5;
        if (this.f71a != null) {
            if (this.f71a.getOpenHmsPush()) {
                com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : " + (" HW user switch : " + this.f71a.getOpenHmsPush() + " HW online switch : " + h.m115a(this.f70a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ah.HUAWEI.equals(m.a(this.f70a))));
            }
            if (this.f71a.getOpenHmsPush() && h.m115a(this.f70a, d.ASSEMBLE_PUSH_HUAWEI) && ah.HUAWEI.equals(m.a(this.f70a))) {
                if (!m111a(d.ASSEMBLE_PUSH_HUAWEI)) {
                    a(d.ASSEMBLE_PUSH_HUAWEI, al.a(this.f70a, d.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m111a(d.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(d.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m110a(d.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f71a.getOpenFCMPush()) {
                com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : " + (" FCM user switch : " + this.f71a.getOpenFCMPush() + " FCM online switch : " + h.m115a(this.f70a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + m.m118a(this.f70a)));
            }
            if (this.f71a.getOpenFCMPush() && h.m115a(this.f70a, d.ASSEMBLE_PUSH_FCM) && m.m118a(this.f70a)) {
                if (!m111a(d.ASSEMBLE_PUSH_FCM)) {
                    a(d.ASSEMBLE_PUSH_FCM, al.a(this.f70a, d.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m111a(d.ASSEMBLE_PUSH_FCM) && (a3 = a(d.ASSEMBLE_PUSH_FCM)) != null) {
                m110a(d.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f71a.getOpenCOSPush()) {
                com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : " + (" COS user switch : " + this.f71a.getOpenCOSPush() + " COS online switch : " + h.m115a(this.f70a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + m.b(this.f70a)));
            }
            if (this.f71a.getOpenCOSPush() && h.m115a(this.f70a, d.ASSEMBLE_PUSH_COS) && m.b(this.f70a)) {
                a(d.ASSEMBLE_PUSH_COS, al.a(this.f70a, d.ASSEMBLE_PUSH_COS));
            } else if (m111a(d.ASSEMBLE_PUSH_COS) && (a4 = a(d.ASSEMBLE_PUSH_COS)) != null) {
                m110a(d.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f71a.getOpenFTOSPush() && h.m115a(this.f70a, d.ASSEMBLE_PUSH_FTOS) && m.c(this.f70a)) {
                a(d.ASSEMBLE_PUSH_FTOS, al.a(this.f70a, d.ASSEMBLE_PUSH_FTOS));
            } else if (!m111a(d.ASSEMBLE_PUSH_FTOS) || (a5 = a(d.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m110a(d.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(d dVar) {
        return this.f72a.get(dVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f71a = pushConfiguration;
        this.f73a = com.xiaomi.push.service.ak.a(this.f70a).a(hr.AggregatePushSwitch.a(), true);
        if (this.f71a.getOpenHmsPush() || this.f71a.getOpenFCMPush() || this.f71a.getOpenCOSPush()) {
            com.xiaomi.push.service.ak.a(this.f70a).a(new f(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m110a(d dVar) {
        this.f72a.remove(dVar);
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f72a.containsKey(dVar)) {
                this.f72a.remove(dVar);
            }
            this.f72a.put(dVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m111a(d dVar) {
        return this.f72a.containsKey(dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean b(d dVar) {
        boolean z = false;
        switch (g.f4765a[dVar.ordinal()]) {
            case 1:
                if (this.f71a != null) {
                    return this.f71a.getOpenHmsPush();
                }
                return false;
            case 2:
                if (this.f71a != null) {
                    return this.f71a.getOpenFCMPush();
                }
                return false;
            case 3:
                if (this.f71a != null) {
                    z = this.f71a.getOpenCOSPush();
                    break;
                }
                break;
            case 4:
                break;
            default:
                return false;
        }
        return this.f71a != null ? this.f71a.getOpenFTOSPush() : z;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : assemble push register");
        if (this.f72a.size() <= 0) {
            a();
        }
        if (this.f72a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f72a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            h.m112a(this.f70a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m54a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f72a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f72a.clear();
    }
}
