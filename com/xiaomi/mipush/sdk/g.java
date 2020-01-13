package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hl;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class g implements AbstractPushManager {
    private static volatile g a;

    /* renamed from: a  reason: collision with other field name */
    private Context f71a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f72a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f74a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<f, AbstractPushManager> f73a = new HashMap();

    private g(Context context) {
        this.f71a = context.getApplicationContext();
    }

    public static g a(Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g(context);
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
                com.xiaomi.channel.commonutils.logger.b.m42a("ASSEMBLE_PUSH : " + (" HW user switch : " + this.f72a.getOpenHmsPush() + " HW online switch : " + j.m101a(this.f71a, f.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ap.HUAWEI.equals(o.a(this.f71a))));
            }
            if (this.f72a.getOpenHmsPush() && j.m101a(this.f71a, f.ASSEMBLE_PUSH_HUAWEI) && ap.HUAWEI.equals(o.a(this.f71a))) {
                if (!m97a(f.ASSEMBLE_PUSH_HUAWEI)) {
                    a(f.ASSEMBLE_PUSH_HUAWEI, at.a(this.f71a, f.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m97a(f.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(f.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m96a(f.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f72a.getOpenFCMPush()) {
                com.xiaomi.channel.commonutils.logger.b.m42a("ASSEMBLE_PUSH : " + (" FCM user switch : " + this.f72a.getOpenFCMPush() + " FCM online switch : " + j.m101a(this.f71a, f.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + o.m104a(this.f71a)));
            }
            if (this.f72a.getOpenFCMPush() && j.m101a(this.f71a, f.ASSEMBLE_PUSH_FCM) && o.m104a(this.f71a)) {
                if (!m97a(f.ASSEMBLE_PUSH_FCM)) {
                    a(f.ASSEMBLE_PUSH_FCM, at.a(this.f71a, f.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m97a(f.ASSEMBLE_PUSH_FCM) && (a3 = a(f.ASSEMBLE_PUSH_FCM)) != null) {
                m96a(f.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f72a.getOpenCOSPush()) {
                com.xiaomi.channel.commonutils.logger.b.m42a("ASSEMBLE_PUSH : " + (" COS user switch : " + this.f72a.getOpenCOSPush() + " COS online switch : " + j.m101a(this.f71a, f.ASSEMBLE_PUSH_COS) + " COS isSupport : " + o.b(this.f71a)));
            }
            if (this.f72a.getOpenCOSPush() && j.m101a(this.f71a, f.ASSEMBLE_PUSH_COS) && o.b(this.f71a)) {
                a(f.ASSEMBLE_PUSH_COS, at.a(this.f71a, f.ASSEMBLE_PUSH_COS));
            } else if (m97a(f.ASSEMBLE_PUSH_COS) && (a4 = a(f.ASSEMBLE_PUSH_COS)) != null) {
                m96a(f.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f72a.getOpenFTOSPush() && j.m101a(this.f71a, f.ASSEMBLE_PUSH_FTOS) && o.c(this.f71a)) {
                a(f.ASSEMBLE_PUSH_FTOS, at.a(this.f71a, f.ASSEMBLE_PUSH_FTOS));
            } else if (!m97a(f.ASSEMBLE_PUSH_FTOS) || (a5 = a(f.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m96a(f.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(f fVar) {
        return this.f73a.get(fVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f72a = pushConfiguration;
        this.f74a = com.xiaomi.push.service.ag.a(this.f71a).a(hl.AggregatePushSwitch.a(), true);
        if (this.f72a.getOpenHmsPush() || this.f72a.getOpenFCMPush() || this.f72a.getOpenCOSPush()) {
            com.xiaomi.push.service.ag.a(this.f71a).a(new h(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m96a(f fVar) {
        this.f73a.remove(fVar);
    }

    public void a(f fVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f73a.containsKey(fVar)) {
                this.f73a.remove(fVar);
            }
            this.f73a.put(fVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m97a(f fVar) {
        return this.f73a.containsKey(fVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean b(f fVar) {
        boolean z = false;
        switch (i.a[fVar.ordinal()]) {
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
        com.xiaomi.channel.commonutils.logger.b.m42a("ASSEMBLE_PUSH : assemble push register");
        if (this.f73a.size() <= 0) {
            a();
        }
        if (this.f73a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f73a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            j.m98a(this.f71a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m42a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f73a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f73a.clear();
    }
}
