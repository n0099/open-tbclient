package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hr;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public class e implements AbstractPushManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f4765a;

    /* renamed from: a  reason: collision with other field name */
    private Context f75a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f76a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f78a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<d, AbstractPushManager> f77a = new HashMap();

    private e(Context context) {
        this.f75a = context.getApplicationContext();
    }

    public static e a(Context context) {
        if (f4765a == null) {
            synchronized (e.class) {
                if (f4765a == null) {
                    f4765a = new e(context);
                }
            }
        }
        return f4765a;
    }

    private void a() {
        AbstractPushManager a2;
        AbstractPushManager a3;
        AbstractPushManager a4;
        AbstractPushManager a5;
        if (this.f76a != null) {
            if (this.f76a.getOpenHmsPush()) {
                com.xiaomi.channel.commonutils.logger.b.m57a("ASSEMBLE_PUSH : " + (" HW user switch : " + this.f76a.getOpenHmsPush() + " HW online switch : " + h.m118a(this.f75a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ah.HUAWEI.equals(m.a(this.f75a))));
            }
            if (this.f76a.getOpenHmsPush() && h.m118a(this.f75a, d.ASSEMBLE_PUSH_HUAWEI) && ah.HUAWEI.equals(m.a(this.f75a))) {
                if (!m114a(d.ASSEMBLE_PUSH_HUAWEI)) {
                    a(d.ASSEMBLE_PUSH_HUAWEI, al.a(this.f75a, d.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m114a(d.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(d.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m113a(d.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f76a.getOpenFCMPush()) {
                com.xiaomi.channel.commonutils.logger.b.m57a("ASSEMBLE_PUSH : " + (" FCM user switch : " + this.f76a.getOpenFCMPush() + " FCM online switch : " + h.m118a(this.f75a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + m.m121a(this.f75a)));
            }
            if (this.f76a.getOpenFCMPush() && h.m118a(this.f75a, d.ASSEMBLE_PUSH_FCM) && m.m121a(this.f75a)) {
                if (!m114a(d.ASSEMBLE_PUSH_FCM)) {
                    a(d.ASSEMBLE_PUSH_FCM, al.a(this.f75a, d.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m114a(d.ASSEMBLE_PUSH_FCM) && (a3 = a(d.ASSEMBLE_PUSH_FCM)) != null) {
                m113a(d.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f76a.getOpenCOSPush()) {
                com.xiaomi.channel.commonutils.logger.b.m57a("ASSEMBLE_PUSH : " + (" COS user switch : " + this.f76a.getOpenCOSPush() + " COS online switch : " + h.m118a(this.f75a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + m.b(this.f75a)));
            }
            if (this.f76a.getOpenCOSPush() && h.m118a(this.f75a, d.ASSEMBLE_PUSH_COS) && m.b(this.f75a)) {
                a(d.ASSEMBLE_PUSH_COS, al.a(this.f75a, d.ASSEMBLE_PUSH_COS));
            } else if (m114a(d.ASSEMBLE_PUSH_COS) && (a4 = a(d.ASSEMBLE_PUSH_COS)) != null) {
                m113a(d.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f76a.getOpenFTOSPush() && h.m118a(this.f75a, d.ASSEMBLE_PUSH_FTOS) && m.c(this.f75a)) {
                a(d.ASSEMBLE_PUSH_FTOS, al.a(this.f75a, d.ASSEMBLE_PUSH_FTOS));
            } else if (!m114a(d.ASSEMBLE_PUSH_FTOS) || (a5 = a(d.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m113a(d.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(d dVar) {
        return this.f77a.get(dVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f76a = pushConfiguration;
        this.f78a = com.xiaomi.push.service.ak.a(this.f75a).a(hr.AggregatePushSwitch.a(), true);
        if (this.f76a.getOpenHmsPush() || this.f76a.getOpenFCMPush() || this.f76a.getOpenCOSPush()) {
            com.xiaomi.push.service.ak.a(this.f75a).a(new f(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m113a(d dVar) {
        this.f77a.remove(dVar);
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f77a.containsKey(dVar)) {
                this.f77a.remove(dVar);
            }
            this.f77a.put(dVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m114a(d dVar) {
        return this.f77a.containsKey(dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean b(d dVar) {
        boolean z = false;
        switch (g.f4767a[dVar.ordinal()]) {
            case 1:
                if (this.f76a != null) {
                    return this.f76a.getOpenHmsPush();
                }
                return false;
            case 2:
                if (this.f76a != null) {
                    return this.f76a.getOpenFCMPush();
                }
                return false;
            case 3:
                if (this.f76a != null) {
                    z = this.f76a.getOpenCOSPush();
                    break;
                }
                break;
            case 4:
                break;
            default:
                return false;
        }
        return this.f76a != null ? this.f76a.getOpenFTOSPush() : z;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m57a("ASSEMBLE_PUSH : assemble push register");
        if (this.f77a.size() <= 0) {
            a();
        }
        if (this.f77a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f77a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            h.m115a(this.f75a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m57a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f77a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f77a.clear();
    }
}
