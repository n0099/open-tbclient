package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hr;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class e implements AbstractPushManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f13824a;

    /* renamed from: a  reason: collision with other field name */
    private Context f151a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f152a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f154a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<d, AbstractPushManager> f153a = new HashMap();

    private e(Context context) {
        this.f151a = context.getApplicationContext();
    }

    public static e a(Context context) {
        if (f13824a == null) {
            synchronized (e.class) {
                if (f13824a == null) {
                    f13824a = new e(context);
                }
            }
        }
        return f13824a;
    }

    private void a() {
        AbstractPushManager a2;
        AbstractPushManager a3;
        AbstractPushManager a4;
        AbstractPushManager a5;
        if (this.f152a != null) {
            if (this.f152a.getOpenHmsPush()) {
                com.xiaomi.channel.commonutils.logger.b.m80a("ASSEMBLE_PUSH : " + (" HW user switch : " + this.f152a.getOpenHmsPush() + " HW online switch : " + h.m141a(this.f151a, d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ah.HUAWEI.equals(m.a(this.f151a))));
            }
            if (this.f152a.getOpenHmsPush() && h.m141a(this.f151a, d.ASSEMBLE_PUSH_HUAWEI) && ah.HUAWEI.equals(m.a(this.f151a))) {
                if (!m137a(d.ASSEMBLE_PUSH_HUAWEI)) {
                    a(d.ASSEMBLE_PUSH_HUAWEI, al.a(this.f151a, d.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m137a(d.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(d.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m136a(d.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f152a.getOpenFCMPush()) {
                com.xiaomi.channel.commonutils.logger.b.m80a("ASSEMBLE_PUSH : " + (" FCM user switch : " + this.f152a.getOpenFCMPush() + " FCM online switch : " + h.m141a(this.f151a, d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + m.m144a(this.f151a)));
            }
            if (this.f152a.getOpenFCMPush() && h.m141a(this.f151a, d.ASSEMBLE_PUSH_FCM) && m.m144a(this.f151a)) {
                if (!m137a(d.ASSEMBLE_PUSH_FCM)) {
                    a(d.ASSEMBLE_PUSH_FCM, al.a(this.f151a, d.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m137a(d.ASSEMBLE_PUSH_FCM) && (a3 = a(d.ASSEMBLE_PUSH_FCM)) != null) {
                m136a(d.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f152a.getOpenCOSPush()) {
                com.xiaomi.channel.commonutils.logger.b.m80a("ASSEMBLE_PUSH : " + (" COS user switch : " + this.f152a.getOpenCOSPush() + " COS online switch : " + h.m141a(this.f151a, d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + m.b(this.f151a)));
            }
            if (this.f152a.getOpenCOSPush() && h.m141a(this.f151a, d.ASSEMBLE_PUSH_COS) && m.b(this.f151a)) {
                a(d.ASSEMBLE_PUSH_COS, al.a(this.f151a, d.ASSEMBLE_PUSH_COS));
            } else if (m137a(d.ASSEMBLE_PUSH_COS) && (a4 = a(d.ASSEMBLE_PUSH_COS)) != null) {
                m136a(d.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f152a.getOpenFTOSPush() && h.m141a(this.f151a, d.ASSEMBLE_PUSH_FTOS) && m.c(this.f151a)) {
                a(d.ASSEMBLE_PUSH_FTOS, al.a(this.f151a, d.ASSEMBLE_PUSH_FTOS));
            } else if (!m137a(d.ASSEMBLE_PUSH_FTOS) || (a5 = a(d.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m136a(d.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(d dVar) {
        return this.f153a.get(dVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f152a = pushConfiguration;
        this.f154a = com.xiaomi.push.service.ak.a(this.f151a).a(hr.AggregatePushSwitch.a(), true);
        if (this.f152a.getOpenHmsPush() || this.f152a.getOpenFCMPush() || this.f152a.getOpenCOSPush()) {
            com.xiaomi.push.service.ak.a(this.f151a).a(new f(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m136a(d dVar) {
        this.f153a.remove(dVar);
    }

    public void a(d dVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f153a.containsKey(dVar)) {
                this.f153a.remove(dVar);
            }
            this.f153a.put(dVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m137a(d dVar) {
        return this.f153a.containsKey(dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean b(d dVar) {
        boolean z = false;
        switch (g.f13826a[dVar.ordinal()]) {
            case 1:
                if (this.f152a != null) {
                    return this.f152a.getOpenHmsPush();
                }
                return false;
            case 2:
                if (this.f152a != null) {
                    return this.f152a.getOpenFCMPush();
                }
                return false;
            case 3:
                if (this.f152a != null) {
                    z = this.f152a.getOpenCOSPush();
                    break;
                }
                break;
            case 4:
                break;
            default:
                return false;
        }
        return this.f152a != null ? this.f152a.getOpenFTOSPush() : z;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m80a("ASSEMBLE_PUSH : assemble push register");
        if (this.f153a.size() <= 0) {
            a();
        }
        if (this.f153a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f153a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            h.m138a(this.f151a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m80a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f153a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f153a.clear();
    }
}
