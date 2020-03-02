package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hl;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class g implements AbstractPushManager {
    private static volatile g a;

    /* renamed from: a  reason: collision with other field name */
    private Context f68a;

    /* renamed from: a  reason: collision with other field name */
    private PushConfiguration f69a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f71a = false;

    /* renamed from: a  reason: collision with other field name */
    private Map<f, AbstractPushManager> f70a = new HashMap();

    private g(Context context) {
        this.f68a = context.getApplicationContext();
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
        if (this.f69a != null) {
            if (this.f69a.getOpenHmsPush()) {
                com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : " + (" HW user switch : " + this.f69a.getOpenHmsPush() + " HW online switch : " + j.m106a(this.f68a, f.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + ap.HUAWEI.equals(o.a(this.f68a))));
            }
            if (this.f69a.getOpenHmsPush() && j.m106a(this.f68a, f.ASSEMBLE_PUSH_HUAWEI) && ap.HUAWEI.equals(o.a(this.f68a))) {
                if (!m102a(f.ASSEMBLE_PUSH_HUAWEI)) {
                    a(f.ASSEMBLE_PUSH_HUAWEI, at.a(this.f68a, f.ASSEMBLE_PUSH_HUAWEI));
                }
                com.xiaomi.channel.commonutils.logger.b.c("hw manager add to list");
            } else if (m102a(f.ASSEMBLE_PUSH_HUAWEI) && (a2 = a(f.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m101a(f.ASSEMBLE_PUSH_HUAWEI);
                a2.unregister();
            }
            if (this.f69a.getOpenFCMPush()) {
                com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : " + (" FCM user switch : " + this.f69a.getOpenFCMPush() + " FCM online switch : " + j.m106a(this.f68a, f.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + o.m109a(this.f68a)));
            }
            if (this.f69a.getOpenFCMPush() && j.m106a(this.f68a, f.ASSEMBLE_PUSH_FCM) && o.m109a(this.f68a)) {
                if (!m102a(f.ASSEMBLE_PUSH_FCM)) {
                    a(f.ASSEMBLE_PUSH_FCM, at.a(this.f68a, f.ASSEMBLE_PUSH_FCM));
                }
                com.xiaomi.channel.commonutils.logger.b.c("fcm manager add to list");
            } else if (m102a(f.ASSEMBLE_PUSH_FCM) && (a3 = a(f.ASSEMBLE_PUSH_FCM)) != null) {
                m101a(f.ASSEMBLE_PUSH_FCM);
                a3.unregister();
            }
            if (this.f69a.getOpenCOSPush()) {
                com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : " + (" COS user switch : " + this.f69a.getOpenCOSPush() + " COS online switch : " + j.m106a(this.f68a, f.ASSEMBLE_PUSH_COS) + " COS isSupport : " + o.b(this.f68a)));
            }
            if (this.f69a.getOpenCOSPush() && j.m106a(this.f68a, f.ASSEMBLE_PUSH_COS) && o.b(this.f68a)) {
                a(f.ASSEMBLE_PUSH_COS, at.a(this.f68a, f.ASSEMBLE_PUSH_COS));
            } else if (m102a(f.ASSEMBLE_PUSH_COS) && (a4 = a(f.ASSEMBLE_PUSH_COS)) != null) {
                m101a(f.ASSEMBLE_PUSH_COS);
                a4.unregister();
            }
            if (this.f69a.getOpenFTOSPush() && j.m106a(this.f68a, f.ASSEMBLE_PUSH_FTOS) && o.c(this.f68a)) {
                a(f.ASSEMBLE_PUSH_FTOS, at.a(this.f68a, f.ASSEMBLE_PUSH_FTOS));
            } else if (!m102a(f.ASSEMBLE_PUSH_FTOS) || (a5 = a(f.ASSEMBLE_PUSH_FTOS)) == null) {
            } else {
                m101a(f.ASSEMBLE_PUSH_FTOS);
                a5.unregister();
            }
        }
    }

    public AbstractPushManager a(f fVar) {
        return this.f70a.get(fVar);
    }

    public void a(PushConfiguration pushConfiguration) {
        this.f69a = pushConfiguration;
        this.f71a = com.xiaomi.push.service.ag.a(this.f68a).a(hl.AggregatePushSwitch.a(), true);
        if (this.f69a.getOpenHmsPush() || this.f69a.getOpenFCMPush() || this.f69a.getOpenCOSPush()) {
            com.xiaomi.push.service.ag.a(this.f68a).a(new h(this, 101, "assemblePush"));
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m101a(f fVar) {
        this.f70a.remove(fVar);
    }

    public void a(f fVar, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f70a.containsKey(fVar)) {
                this.f70a.remove(fVar);
            }
            this.f70a.put(fVar, abstractPushManager);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m102a(f fVar) {
        return this.f70a.containsKey(fVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean b(f fVar) {
        boolean z = false;
        switch (i.a[fVar.ordinal()]) {
            case 1:
                if (this.f69a != null) {
                    return this.f69a.getOpenHmsPush();
                }
                return false;
            case 2:
                if (this.f69a != null) {
                    return this.f69a.getOpenFCMPush();
                }
                return false;
            case 3:
                if (this.f69a != null) {
                    z = this.f69a.getOpenCOSPush();
                    break;
                }
                break;
            case 4:
                break;
            default:
                return false;
        }
        return this.f69a != null ? this.f69a.getOpenFTOSPush() : z;
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : assemble push register");
        if (this.f70a.size() <= 0) {
            a();
        }
        if (this.f70a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f70a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            j.m103a(this.f68a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        com.xiaomi.channel.commonutils.logger.b.m47a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f70a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f70a.clear();
    }
}
