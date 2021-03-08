package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hr;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class e implements AbstractPushManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f8228a;

    /* renamed from: a  reason: collision with other field name */
    private Context f72a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f73a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f75a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<d, AbstractPushManager> f74a = new HashMap();

    private e(Context context) {
        this.f72a = context.getApplicationContext();
    }

    public static e a(Context context) {
        if (f8228a == null) {
            synchronized (e.class) {
                if (f8228a == null) {
                    f8228a = new e(context);
                }
            }
        }
        return f8228a;
    }

    private void a() {
        AbstractPushManager a2;
        AbstractPushManager a3;
        AbstractPushManager a4;
        AbstractPushManager a5;
        if (this.f73a != null) {
            if (this.f73a.getOpenHmsPush()) {
                com.xiaomi.channel.commonutils.logger.b.m58a("ASSEMBLE_PUSH : " + (" HW user switch : " + this.f73a.getOpenHmsPush() + " HW online switch : " + h.m119a(this.f72a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ah.HUAWEI.equals(m.a(this.f72a))));
            }
            if (this.f73a.getOpenHmsPush() && h.m119a(this.f72a, d.ASSEMBLE_PUSH_HUAWEI) && ah.HUAWEI.equals(m.a(this.f72a))) {
                if (!m115a(d.ASSEMBLE_PUSH_HUAWEI)) {
                    a(d.ASSEMBLE_PUSH_HUAWEI, al.a(this.f72a, d.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m115a(d.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(d.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m114a(d.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f73a.getOpenFCMPush()) {
                com.xiaomi.channel.commonutils.logger.b.m58a("ASSEMBLE_PUSH : " + (" FCM user switch : " + this.f73a.getOpenFCMPush() + " FCM online switch : " + h.m119a(this.f72a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + m.m122a(this.f72a)));
            }
            if (this.f73a.getOpenFCMPush() && h.m119a(this.f72a, d.ASSEMBLE_PUSH_FCM) && m.m122a(this.f72a)) {
                if (!m115a(d.ASSEMBLE_PUSH_FCM)) {
                    a(d.ASSEMBLE_PUSH_FCM, al.a(this.f72a, d.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m115a(d.ASSEMBLE_PUSH_FCM) && (a3 = a(d.ASSEMBLE_PUSH_FCM)) != null) {
                m114a(d.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f73a.getOpenCOSPush()) {
                com.xiaomi.channel.commonutils.logger.b.m58a("ASSEMBLE_PUSH : " + (" COS user switch : " + this.f73a.getOpenCOSPush() + " COS online switch : " + h.m119a(this.f72a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + m.b(this.f72a)));
            }
            if (this.f73a.getOpenCOSPush() && h.m119a(this.f72a, d.ASSEMBLE_PUSH_COS) && m.b(this.f72a)) {
                a(d.ASSEMBLE_PUSH_COS, al.a(this.f72a, d.ASSEMBLE_PUSH_COS));
            } else if (m115a(d.ASSEMBLE_PUSH_COS) && (a4 = a(d.ASSEMBLE_PUSH_COS)) != null) {
                m114a(d.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f73a.getOpenFTOSPush() && h.m119a(this.f72a, d.ASSEMBLE_PUSH_FTOS) && m.c(this.f72a)) {
                a(d.ASSEMBLE_PUSH_FTOS, al.a(this.f72a, d.ASSEMBLE_PUSH_FTOS));
            } else if (!m115a(d.ASSEMBLE_PUSH_FTOS) || (a5 = a(d.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m114a(d.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(d dVar) {
        return this.f74a.get(dVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f73a = pushConfiguration;
        this.f75a = com.xiaomi.push.service.ak.a(this.f72a).a(hr.AggregatePushSwitch.a(), true);
        if (this.f73a.getOpenHmsPush() || this.f73a.getOpenFCMPush() || this.f73a.getOpenCOSPush()) {
            com.xiaomi.push.service.ak.a(this.f72a).a(new f(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m114a(d dVar) {
        this.f74a.remove(dVar);
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f74a.containsKey(dVar)) {
                this.f74a.remove(dVar);
            }
            this.f74a.put(dVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m115a(d dVar) {
        return this.f74a.containsKey(dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean b(d dVar) {
        boolean z = false;
        switch (g.f8230a[dVar.ordinal()]) {
            case 1:
                if (this.f73a != null) {
                    return this.f73a.getOpenHmsPush();
                }
                return false;
            case 2:
                if (this.f73a != null) {
                    return this.f73a.getOpenFCMPush();
                }
                return false;
            case 3:
                if (this.f73a != null) {
                    z = this.f73a.getOpenCOSPush();
                    break;
                }
                break;
            case 4:
                break;
            default:
                return false;
        }
        return this.f73a != null ? this.f73a.getOpenFTOSPush() : z;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m58a("ASSEMBLE_PUSH : assemble push register");
        if (this.f74a.size() <= 0) {
            a();
        }
        if (this.f74a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f74a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            h.m116a(this.f72a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m58a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f74a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f74a.clear();
    }
}
